package org.kilinochi.dreamkas.sdk.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.kilinochi.dreamkas.sdk.jackson.JacksonSerializer;
import org.kilinochi.dreamkas.sdk.jackson.Serializer;

abstract class ServerMock {
    final static String ENDPOINT_KEY = "test_key_endpoint";

    final static String ENDPOINT = "http://localhost:10000/api";
    final static String ENDPOINT_V2 = "http://localhost:10000/api/v2";

    protected final WireMockServer server = new WireMockServer(10000);

    protected final DreamkasTransportClient transport = DreamkasTransportClient.createTransport("dummy-token");
    protected final Serializer serializer = new JacksonSerializer();
    protected final DreamkasClient client = new DreamkasClient(transport, serializer) {
        @Override
        public String getEndpoint() {
            return System.getProperty(ENDPOINT_KEY, ENDPOINT);
        }
    };

    @BeforeEach
    void setUp() {
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }
}
