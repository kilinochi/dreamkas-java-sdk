package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.CreateProductResult;
import org.kilinochi.dreamkas.sdk.model.NewProductBody;

/**
 * @author arman.shamenov
 */
public class CreateProductQuery extends DreamkasQuery<CreateProductResult> {

    public CreateProductQuery(DreamkasClient client, NewProductBody body) {
        super(client, "/products", body, CreateProductResult.class, DreamkasTransportClient.Method.POST);
    }
}
