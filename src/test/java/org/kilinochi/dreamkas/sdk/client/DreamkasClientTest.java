package org.kilinochi.dreamkas.sdk.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.jackson.JacksonSerializer;
import org.kilinochi.dreamkas.sdk.jackson.Serializer;
import org.kilinochi.dreamkas.sdk.model.Product;
import org.kilinochi.dreamkas.sdk.queries.GetProductQuery;

import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(JUnitPlatform.class)
class DreamkasClientTest {

    private final WireMockServer server = new WireMockServer( 10000);

    private final DreamkasTransportClient transport = DreamkasTransportClient.createTransport("dummy-token");
    private final Serializer serializer = new JacksonSerializer();
    private final DreamkasClient client = new DreamkasClient(transport, serializer) {
        @Override
        public String getEndpoint() {
            return "http://localhost:10000/api";
        }
    };

    @BeforeEach
    void setUp() {
        server.start();
        server.stubFor(get(urlEqualTo("/api/products/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/product.json")));

    }

    @Test
    void productTest() throws ExecutionException, InterruptedException {

        GetProductQuery query = new GetProductQuery(client, 1L);
        Product product = query.execute().get();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }
}
