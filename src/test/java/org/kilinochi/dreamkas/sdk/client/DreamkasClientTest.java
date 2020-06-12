package org.kilinochi.dreamkas.sdk.client;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.Price;
import org.kilinochi.dreamkas.sdk.model.Product;
import org.kilinochi.dreamkas.sdk.queries.GetProductQuery;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class DreamkasClientTest extends ServerMock {

    @Test
    void productTest() throws ExecutionException, InterruptedException {
        server.stubFor(get(urlEqualTo("/api/products/b0381fe4-4428-4dcb-8169-c8bbcab59626"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/product.json")));

        UUID productId = UUID.fromString("b0381fe4-4428-4dcb-8169-c8bbcab59626");
        GetProductQuery query = new GetProductQuery(client, productId);
        Product product = query.execute().get();

        assertEquals(productId, product.getId());
        assertThat(product.getPrices(), hasItems(
                new Price(1L, 1200L)
        ));
    }
}
