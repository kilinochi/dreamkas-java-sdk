package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.ProductList;

/**
 * @author arman.shamenov
 */
public class GetProductsQuery extends DreamkasQuery<ProductList> {

    private final QueryParam<Long> limit = new QueryParam<>("limit", this);
    private final QueryParam<Long> offset = new QueryParam<>("offset", this);

    public GetProductsQuery(DreamkasClient client) {
        super(client, "/products", null, ProductList.class, DreamkasTransportClient.Method.GET);
    }

    public GetProductsQuery limit(long limit) {
        this.limit.setValue(limit);
        return this;
    }

    public GetProductsQuery offset(long offset) {
        this.offset.setValue(offset);
        return this;
    }
}
