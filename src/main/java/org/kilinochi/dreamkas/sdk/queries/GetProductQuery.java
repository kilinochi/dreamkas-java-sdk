package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Product;

import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class GetProductQuery extends DreamkasQuery<Product> {

    public GetProductQuery(DreamkasClient client, UUID productId) {
        super(client, substitute("/products/{id}", productId), null, Product.class, DreamkasTransportClient.Method.GET);
    }
}
