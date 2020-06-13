package org.kilinochi.dreamkas.sdk.client;

import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author arman.shamenov
 */
class DreamkasHttpTransportClient implements DreamkasTransportClient {

    private final HttpClient httpClient;
    private final String bearerToken;

    DreamkasHttpTransportClient(String bearerToken) {
        this.bearerToken = bearerToken;
        this.httpClient = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    @Override
    public CompletableFuture<ClientResponse> get(URI uri) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .GET();
        return newCall(requestBuilder, uri);
    }

    @Override
    public CompletableFuture<ClientResponse> post(URI uri, @Nullable String body) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .POST(wrapBody(body));
        return newCall(requestBuilder, uri);
    }

    @Override
    public CompletableFuture<ClientResponse> put(URI uri, @Nullable String body) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .PUT(wrapBody(body));
        return newCall(requestBuilder, uri);
    }

    @Override
    public CompletableFuture<ClientResponse> delete(URI uri) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .DELETE();
        return newCall(requestBuilder, uri);
    }

    private CompletableFuture<ClientResponse> newCall(HttpRequest.Builder requestBuilder, URI uri) {
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

        HttpRequest request = requestBuilder
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .uri(uri)
                .build();
        return httpClient.sendAsync(request, handler)
            .thenApply(rawResponse -> toResponse(rawResponse, uri));
    }

    private static ClientResponse toResponse(HttpResponse<String> response, URI uri) {
        int code = response.statusCode();
        String bodyRequest = wrapJsonResponse(response.body(), uri);
        Map<String, List<String>> headers = response.headers().map();
        return new ClientResponse(code, bodyRequest, headers);
    }

    private static String wrapJsonResponse(String body, URI uri) {
        if (body == null) {
            return null;
        }

        if (!body.startsWith("[")) {
            return body;
        }

        String uriPath = uri.getPath();
        String pathEnd = uriPath.substring(uriPath.lastIndexOf("/")).replace("/", "");
        return new StringBuilder(body)
                .insert(0, "{\"" + pathEnd + "\": \n")
                .append("\n}")
                .toString();
    }

    private static HttpRequest.BodyPublisher wrapBody(@Nullable String body) {
        if (body == null) {
            return HttpRequest.BodyPublishers.noBody();
        }

        return HttpRequest.BodyPublishers.ofString(body);
    }
}
