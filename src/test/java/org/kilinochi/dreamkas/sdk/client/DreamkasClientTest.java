package org.kilinochi.dreamkas.sdk.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.Department;
import org.kilinochi.dreamkas.sdk.model.DepartmentList;
import org.kilinochi.dreamkas.sdk.model.Encashment;
import org.kilinochi.dreamkas.sdk.model.EncashmentsList;
import org.kilinochi.dreamkas.sdk.model.Price;
import org.kilinochi.dreamkas.sdk.model.Product;
import org.kilinochi.dreamkas.sdk.model.ProductList;
import org.kilinochi.dreamkas.sdk.model.ProductType;
import org.kilinochi.dreamkas.sdk.model.QueryResponse;
import org.kilinochi.dreamkas.sdk.model.Receipt;
import org.kilinochi.dreamkas.sdk.model.ReceiptsList;
import org.kilinochi.dreamkas.sdk.model.Tax;
import org.kilinochi.dreamkas.sdk.queries.GetDepartmentsQuery;
import org.kilinochi.dreamkas.sdk.queries.GetEncashmentsQuery;
import org.kilinochi.dreamkas.sdk.queries.GetProductQuery;
import org.kilinochi.dreamkas.sdk.queries.GetProductsQuery;
import org.kilinochi.dreamkas.sdk.queries.GetReceiptsQuery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class DreamkasClientTest extends ServerMock {

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
        assertThat(product.getTax().getClass(), is(Tax.class));
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
        assertThat(product.getTax().getClass(), is(Tax.class));
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
    void getReceiptsTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

        server.stubFor(
                get(urlEqualTo("/api/receipts?from=2017-10-13T14%3A15%3A01.239Z&to=2017-10-14T14%3A15%3A01.239Z&limit=1&offset=0&devices=1%2C2"))
                        .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBodyFile("json/receipts.json")));

        ReceiptsList receiptsList = new GetReceiptsQuery(client)
                .from("2017-10-13T14:15:01.239Z")
                .to("2017-10-14T14:15:01.239Z")
                .limit(1L)
                .offset(0L)
                .devices(Sets.newHashSet("1", "2"))
                .execute()
                .get();
        List<Receipt> data = receiptsList.getData();
        QueryResponse queryResponse = receiptsList.getQueryResponse();

        assertEquals(1, data.size());
        assertThat(queryResponse, notNullValue());
    }

    @Test
    void getDepartmentsTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

        server.stubFor(
                get(urlEqualTo("/api/departments"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/departments.json")));

        DepartmentList departmentList = new GetDepartmentsQuery(client).execute().get();

        List<Department> departments = departmentList.getDepartments();

        assertEquals(4, departments.size());
        assertThat(departments, hasItems(
                new Department("Хлебобулочные изделия", Tax.NDS_0_V1, 1L),
                new Department("Мясные изделия", Tax.NDS_20_V1, 2L),
                new Department("Молочная продукция", Tax.NDS_10, 3L),
                new Department("Бытовая химия", Tax.NDS_MIXED_V1, 4L)
        ));
    }

    @Test
    void getEncashmentTest() throws ExecutionException, InterruptedException {
        System.setProperty(ENDPOINT_KEY, ENDPOINT);

        server.stubFor(
                get(urlEqualTo("/api/encashments?from=2017-10-13T14%3A15%3A01.239Z&to=2017-10-14T14%3A15%3A01.239Z&limit=1&offset=0&devices=1%2C2"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBodyFile("json/encashments.json")));

        EncashmentsList encashmentsList = new GetEncashmentsQuery(client)
                .from("2017-10-13T14:15:01.239Z")
                .to("2017-10-14T14:15:01.239Z")
                .limit(1L)
                .offset(0L)
                .devices(Sets.newHashSet("1", "2"))
                .execute()
                .get();

        List<Encashment> data = encashmentsList.getData();
        QueryResponse queryResponse = encashmentsList.getQueryResponse();


    }
}
