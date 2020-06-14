package org.kilinochi.dreamkas.sdk.client;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.NewShopBody;
import org.kilinochi.dreamkas.sdk.model.Shop;
import org.kilinochi.dreamkas.sdk.queries.CreateShopQuery;
import org.kilinochi.dreamkas.sdk.queries.GetShopQuery;
import org.kilinochi.dreamkas.sdk.queries.GetShopsQuery;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class ShopsTest extends UnitTestBase {

    @Test
    void getShopsTest() throws ExecutionException, InterruptedException {

        server.stubFor(get(urlEqualTo("/api/shops"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/shops.json")));

        List<Shop> shops = new GetShopsQuery(client).execute().get().getShops();

        assertEquals(4, shops.size());
        assertThat(shops, hasItems(
                new Shop(1L, 999L, "Магазин №1"),
                new Shop(2L, 1000L, "Магазин №2"),
                new Shop(3L, 1001L, "Магазин №3"),
                new Shop(4L, 1002L, "Магазин №4")
        ));
    }

    @Test
    void getShopTest() throws ExecutionException, InterruptedException {
        server.stubFor(get(urlEqualTo("/api/shops/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/shop.json")));

        Shop shop = new GetShopQuery(client, 1L).execute().get();

        assertEquals(new Shop(1L, 999L, "Магазин №1"), shop);
    }

    @Test
    void createShopTest() throws ExecutionException, InterruptedException {

        server.stubFor(post(urlEqualTo("/api/shops"))
                .withRequestBody(equalToJson("{\n" +
                        "  \"name\": \"Магазин №1\",\n" +
                        "  \"sort\": 999\n" +
                        "}"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"name\": \"Магазин №1\",\n" +
                                "    \"sort\": 999,\n" +
                                "    \"id\": 1\n" +
                                "  }")));

        Shop shop = new CreateShopQuery(client, new NewShopBody("Магазин №1", 999L)).execute().get();

        assertEquals(new Shop(1L, 999L, "Магазин №1"), shop);
    }
}
