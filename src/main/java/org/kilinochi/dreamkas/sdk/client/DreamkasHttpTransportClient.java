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
                .uri(uri)
                .GET();
        return newCall(requestBuilder);
    }

    @Override
    public CompletableFuture<ClientResponse> post(URI uri, @Nullable String body) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .uri(uri)
                .POST(wrapBody(body));
        return newCall(requestBuilder);
    }

    @Override
    public CompletableFuture<ClientResponse> put(URI uri, @Nullable String body) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .uri(uri)
                .PUT(wrapBody(body));
        return newCall(requestBuilder);
    }

    @Override
    public CompletableFuture<ClientResponse> delete(URI uri) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .uri(uri)
                .DELETE();
        return newCall(requestBuilder);
    }

    private CompletableFuture<ClientResponse> newCall(HttpRequest.Builder requestBuilder) {
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

        HttpRequest request = requestBuilder
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .build();
        return httpClient.sendAsync(request, handler)
            .thenApply(DreamkasHttpTransportClient::toResponse);
    }

    private static ClientResponse toResponse(HttpResponse<String> response) {
        int code = response.statusCode();
        String body = response.body();
        Map<String, List<String>> headers = response.headers().map();
        return new ClientResponse(code, body, headers);
    }

    private static HttpRequest.BodyPublisher wrapBody(@Nullable String body) {
        if (body == null) {
            return HttpRequest.BodyPublishers.noBody();
        }

        return HttpRequest.BodyPublishers.ofString(body);
    }
}
