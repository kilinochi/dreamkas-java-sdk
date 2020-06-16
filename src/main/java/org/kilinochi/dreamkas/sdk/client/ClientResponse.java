package org.kilinochi.dreamkas.sdk.client;

import java.util.List;
import java.util.Map;

/**
 * @author arman.shamenov
 */
public final class ClientResponse {
    private final int statusCode;
    private final String jsonBody;
    private final Map<String, List<String>> headers;

    public ClientResponse(
            int statusCode,
            String body,
            Map<String, List<String>> headers) {
        this.statusCode = statusCode;
        this.jsonBody = body;
        this.headers = headers;
    }

    public String getBody() {
        return jsonBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}
