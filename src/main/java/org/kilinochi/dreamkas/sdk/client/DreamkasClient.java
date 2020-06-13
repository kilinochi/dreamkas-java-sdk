package org.kilinochi.dreamkas.sdk.client;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.kilinochi.dreamkas.sdk.exception.ClientException;
import org.kilinochi.dreamkas.sdk.exception.SerializationException;
import org.kilinochi.dreamkas.sdk.exception.ServerException;
import org.kilinochi.dreamkas.sdk.jackson.JacksonSerializer;
import org.kilinochi.dreamkas.sdk.jackson.Serializer;
import org.kilinochi.dreamkas.sdk.model.Error;
import org.kilinochi.dreamkas.sdk.queries.DreamkasQuery;
import org.kilinochi.dreamkas.sdk.queries.QueryParam;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author arman.shamenov
 */
public class DreamkasClient {
    static final String ENDPOINT_ENV_NAME = "DREAMKAS_API_NAME";
    private static final String ENDPOINT = "https://kabinet.dreamkas.ru/api";

    private final DreamkasTransportClient transport;
    private final Serializer serializer;
    private final String endpoint;

    public DreamkasClient(DreamkasTransportClient transport, Serializer serializer) {
        this.transport = transport;
        this.serializer = serializer;
        this.endpoint = createEndpoint();
    }

    public static DreamkasClient create(String bearerToken) {
        Objects.requireNonNull(bearerToken, "No token given. Get it in dreamkas");
        DreamkasHttpTransportClient transport = new DreamkasHttpTransportClient(bearerToken);
        JacksonSerializer serializer = new JacksonSerializer();
        return new DreamkasClient(transport, serializer);
    }

    public <T> CompletableFuture<T> newCall(DreamkasQuery<T> query) {
        DreamkasTransportClient.Method method = query.getMethod();
        URI uri;

        try {
            uri = buildUrl(query);
        } catch (URISyntaxException e) {
            throw new ClientException(404, "Not found");
        }

        CompletableFuture<ClientResponse> call;

        Object body = query.getBody();
        String stringBody;
        try {
            stringBody = body == null ? null : serializer.serializeToString(body);
        } catch (SerializationException e) {
            throw new ClientException(e);
        }

        switch (method) {
            case GET: {
                call = getTransport().get(uri);
                break;
            }
            case PUT: {
                call = getTransport().put(uri, stringBody);
                break;
            }
            case POST: {
                call = getTransport().post(uri, stringBody);
                break;
            }
            case DELETE: {
                call = getTransport().delete(uri);
                break;
            }
            default:
                throw new ClientException(400, "Method " + method.name() + " is not supported.");

        }

        return call.thenApply(res -> handleResponse(res, query.getResponseType()));
    }

    private URI buildUrl(DreamkasQuery<?> query) throws URISyntaxException {

        String url = query.getUrl();

        String apiEndpoint = url.startsWith("http") || url.startsWith("https") ? url : getEndpoint() + url;

        List<QueryParam<?>> params = query.getParams();
        if (params == null || params.isEmpty()) {
            return URI.create(apiEndpoint);
        }

        List<NameValuePair> pairs = params.stream()
                .map(param -> {
                    String name = param.getName();
                    String paramValue = param.format();
                    return new BasicNameValuePair(name, paramValue);
                })
                .collect(Collectors.toList());

        return new URIBuilder(apiEndpoint).addParameters(pairs).build();
    }

    public DreamkasTransportClient getTransport() {
        return transport;
    }

    private <T> T handleResponse(ClientResponse response, Class<T> classType) throws ServerException, ClientException {
        String responseBody = response.getBody();

        int statusCode = response.getStatusCode();

        if (statusCode == 503) {
            throw new ServerException(statusCode, "Service not available");
        }

        try {

            if (statusCode / 100 == 2) {
                return serializer.deserialize(responseBody, classType);
            }
        } catch (SerializationException e) {
            throw new ServerException(500, "Internal server error");
        }
        Error error;
        try {
            error = serializer.deserialize(responseBody, Error.class);
        } catch (SerializationException e) {
            throw new ServerException(statusCode, responseBody);
        }

        String message = error.getMessage();

        if (statusCode / 100 == 4) {
            throw new ClientException(statusCode, message);
        }

        throw new ServerException(message);
    }

    public String getEndpoint() {
        return endpoint;
    }

    String getEnvironment(String name) {
        return System.getenv(name);
    }

    private String createEndpoint() {
        String env = getEnvironment(ENDPOINT_ENV_NAME);

        if (env != null) {
            return env;
        }

        // default is ENDPOINT
        return System.getProperty("dreamkas.api.endpoint", ENDPOINT);
    }
}
