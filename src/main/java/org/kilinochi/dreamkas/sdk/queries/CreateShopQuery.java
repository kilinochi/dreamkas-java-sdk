package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.NewShopBody;
import org.kilinochi.dreamkas.sdk.model.Shop;

/**
 * @author arman.shamenov
 */
public class CreateShopQuery extends DreamkasQuery<Shop> {

    public CreateShopQuery(DreamkasClient client, NewShopBody body) {
        super(client, "/shops", body, Shop.class, DreamkasTransportClient.Method.POST);
    }
}
