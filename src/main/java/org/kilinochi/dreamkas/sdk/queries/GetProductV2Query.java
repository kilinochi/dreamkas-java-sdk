package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.ProductV2;

import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class GetProductV2Query extends DreamkasQuery<ProductV2> {

    public GetProductV2Query(DreamkasClient client, UUID productId) {
        super(client, substitute("/products/{id}", productId), null, ProductV2.class, DreamkasTransportClient.Method.GET);
    }
}
