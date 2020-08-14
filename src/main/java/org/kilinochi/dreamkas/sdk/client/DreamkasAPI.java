package org.kilinochi.dreamkas.sdk.client;

/**
 * @author arman.shamenov
 */
public class DreamkasAPI {

    private final DreamkasClient client;

    public DreamkasAPI(String bearerToken) {
        this.client = DreamkasClient.create(bearerToken);
    }

    public DreamkasAPI(DreamkasClient client) {
        this.client = client;
    }
}
