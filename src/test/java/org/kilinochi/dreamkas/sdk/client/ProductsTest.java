package org.kilinochi.dreamkas.sdk.client;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.CreateProductResult;
import org.kilinochi.dreamkas.sdk.model.NewProductBody;
import org.kilinochi.dreamkas.sdk.model.Price;
import org.kilinochi.dreamkas.sdk.model.Product;
import org.kilinochi.dreamkas.sdk.model.ProductList;
import org.kilinochi.dreamkas.sdk.model.ProductType;
import org.kilinochi.dreamkas.sdk.model.Tax;
import org.kilinochi.dreamkas.sdk.queries.CreateProductQuery;
import org.kilinochi.dreamkas.sdk.queries.GetProductQuery;
import org.kilinochi.dreamkas.sdk.queries.GetProductsQuery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class ProductsTest extends UnitTestBase {

    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Test
    void getProductTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

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
        assertThat(product.getTax(), is(nullValue()));
        assertThat(product.getType().getClass(), is(ProductType.class));
    }

    @Test
    void getProductV2Test() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT_V2);

        server.stubFor(get(urlEqualTo("/api/v2/products/b0381fe4-4428-4dcb-8169-c8bbcab59626"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/productV2.json")));

        UUID productId = UUID.fromString("b0381fe4-4428-4dcb-8169-c8bbcab59626");
        GetProductQuery query = new GetProductQuery(client, productId);
        Product product = query.execute().get();

        assertEquals(productId, product.getId());
        assertThat(product.getPrices(), hasItems(
                new Price(1L, 1200L)
        ));
        assertThat(product.getTax(), is(notNullValue()));
        assertThat(product.getType().getClass(), is(ProductType.class));
    }

    @Test
    void getProductsTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

        server.stubFor(get(urlEqualTo("/api/products?limit=2&offset=0"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/products.json")));

        GetProductsQuery query = new GetProductsQuery(client).limit(2).offset(0);
        ProductList productList = query.execute().get();
        List<Product> products = productList.getProducts();

        Product product1 = new Product(
                UUID.fromString("b0381fe4-4428-4dcb-8169-c8bbcab59626"),
                "Новый товар",
                ProductType.COUNTABLE,
                0L,
                1000L,
                Lists.newArrayList(new Price(1L, 1200L)),
                false,
                null,
                Lists.newArrayList("AB_1234", "00000001"),
                Tax.NDS_0_V1,
                LocalDateTime.parse("2017-05-05T14:15:01.239Z", FORMATTER),
                LocalDateTime.parse("2017-05-05T14:15:01.239Z", FORMATTER));

        Product product2 = new Product(
                UUID.fromString("cc73c6d9-8d5b-4f3c-8e24-aa582159b589"),
                "Новый товар 2",
                ProductType.SCALABLE,
                0L,
                4000L,
                Lists.newArrayList(new Price(1L, 7200L)),
                true,
                null,
                Lists.newArrayList("AB_5834", "00000008"),
                Tax.NDS_10_V1,
                LocalDateTime.parse("2018-06-05T19:54:01.239Z", FORMATTER),
                LocalDateTime.parse("2018-06-05T19:54:01.239Z", FORMATTER));

        assertEquals(2, products.size());
        assertThat(products, hasItems(product1, product2));
    }

    @Test
    void createProductTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

        server.stubFor(post(urlEqualTo("/api/products"))
                .withRequestBody(equalToJson("{\n" +
                        "  \"type\": \"COUNTABLE\",\n" +
                        "  \"departmentId\": 0,\n" +
                        "  \"quantity\": 1000,\n" +
                        "  \"prices\": [\n" +
                        "    {\n" +
                        "      \"deviceId\": 1,\n" +
                        "      \"value\": 1200\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"isMarked\": false,\n" +
                        "  \"barcodes\": [\n" +
                        "    \"AB_1234\",\n" +
                        "    \"00000001\"\n" +
                        "  ],\n" +
                        "  \"tax\": 0\n" +
                        "}"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "  \"id\": \"b0381fe4-4428-4dcb-8169-c8bbcab59626\"\n" +
                                "}")));

        CreateProductResult productResult = new CreateProductQuery(client, new NewProductBody(
                null,
                null,
                ProductType.COUNTABLE,
                0L,
                1000L,
                Collections.singletonList(new Price(1L, 1200L)),
                false,
                null,
                Lists.newArrayList("AB_1234", "00000001"),
                Tax.NDS_0_V1)).execute().get();

        assertEquals(UUID.fromString("b0381fe4-4428-4dcb-8169-c8bbcab59626"), productResult.getUuid());
    }
}
