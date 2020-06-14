package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Shop;

/**
 * @author arman.shamenov
 */
public class GetShopQuery extends DreamkasQuery<Shop> {

    public GetShopQuery(DreamkasClient client, Long id) {
        super(client, substitute("/shops/{id}", id), null, Shop.class, DreamkasTransportClient.Method.GET);
    }
}
