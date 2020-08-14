package org.kilinochi.dreamkas.sdk.client;

import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

/**
 * @author arman.shamenov
 */
public interface DreamkasTransportClient {

    CompletableFuture<ClientResponse> get(URI uri);

    CompletableFuture<ClientResponse> post(URI uri, @Nullable String body);

    CompletableFuture<ClientResponse> put(URI uri, @Nullable String body);

    CompletableFuture<ClientResponse> delete(URI uri);

    static DreamkasTransportClient createTransport(String bearerToken) {
        return new DreamkasHttpTransportClient(bearerToken);
    }

    enum Method {
        /*
        * Get method
        */
        GET,
        /*
         * Post method
         */
        POST,
        /*
         * Put method
         */
        PUT,
        /*
         * Delete method
         */
        DELETE
    }
}
