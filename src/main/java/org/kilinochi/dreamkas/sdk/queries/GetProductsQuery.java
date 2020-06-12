package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.ProductList;

/**
 * @author arman.shamenov
 */
public class GetProductsQuery extends DreamkasQuery<ProductList> {

    private QueryParam<Long> limit;
    private QueryParam<Long> offset;

    public GetProductsQuery(DreamkasClient client) {
        super(client, "/products", null, ProductList.class, DreamkasTransportClient.Method.GET);
    }

    public GetProductsQuery limit(long limit) {
        if (this.limit == null) {
            this.limit = new QueryParam<>("limit", this);
        }
        this.limit.setValue(limit);
        return this;
    }

    public GetProductsQuery offset(long offset) {
        if (this.offset == null) {
            this.offset = new QueryParam<>("offset", this);
        }
        this.offset.setValue(offset);
        return this;
    }
}
