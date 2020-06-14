package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.ShopsList;

/**
 * @author arman.shamenov
 */
public class GetShopsQuery extends DreamkasQuery<ShopsList> {

    public GetShopsQuery(DreamkasClient client) {
        super(client, "/shops",null, ShopsList.class, DreamkasTransportClient.Method.GET);
    }
}
