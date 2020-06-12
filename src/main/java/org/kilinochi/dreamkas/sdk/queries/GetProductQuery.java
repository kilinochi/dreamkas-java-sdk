package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Product;

import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class GetProductQuery extends DreamkasQuery<Product> {

    private QueryParam<Long> limit;
    private QueryParam<Long> offset;

    public GetProductQuery(DreamkasClient client, UUID productId) {
        super(client, substitute("/products/{id}", productId), null, Product.class, DreamkasTransportClient.Method.GET);
    }

    public GetProductQuery limit(long limit) {
        if (this.limit == null) {
            this.limit = new QueryParam<>("limit", this);
        }

        this.limit.setValue(limit);
        return this;
    }

    public GetProductQuery offset(long offset) {
        if (this.offset == null) {
            this.offset = new QueryParam<>("offset", this);
        }
        
        this.offset.setValue(offset);
        return this;
    }
}
