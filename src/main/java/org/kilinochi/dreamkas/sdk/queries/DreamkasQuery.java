package org.kilinochi.dreamkas.sdk.queries;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author arman.shamenov
 */
public abstract class DreamkasQuery<T> {
    private final DreamkasClient dreamkasClient;
    private final String url;
    private final Class<T> responseType;
    @Nullable
    private final Object body;
    private final DreamkasTransportClient.Method method;

    private List<QueryParam<?>> params;

    protected DreamkasQuery(
            DreamkasClient client,
            String url,
            @Nullable Object body,
            Class<T> responseType,
            DreamkasTransportClient.Method method) {
        this.dreamkasClient = client;
        this.url = url;
        this.responseType = responseType;
        this.method = method;
        this.body = body;
    }

    void addParam(@NotNull QueryParam<?> param) {
        if (this.params == null) {
            this.params = new ArrayList<>();
        }
        params.add(param);
    }

    public DreamkasTransportClient.Method getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public List<QueryParam<?>> getParams() {
        return params;
    }

    @Nullable
    public Object getBody() {
        return body;
    }

    public Class<T> getResponseType() {
        return responseType;
    }

    public CompletableFuture<T> execute() {
        return dreamkasClient.newCall(this);
    }

    static String substitute(String pathTemplate, Object... substitutions) {
        StringBuilder sb = new StringBuilder();
        int nextSubst = 0;
        char[] chars = pathTemplate.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '{') {
                i = pathTemplate.indexOf('}', i);
                sb.append(substitutions[nextSubst++]);
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
