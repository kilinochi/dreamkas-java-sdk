package org.kilinochi.dreamkas.sdk.client;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.QueryResponse;
import org.kilinochi.dreamkas.sdk.model.Receipt;
import org.kilinochi.dreamkas.sdk.model.ReceiptsList;
import org.kilinochi.dreamkas.sdk.queries.GetReceiptsQuery;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class ReceiptsTest extends UnitTestBase {

    @Test
    void getReceiptsTest() throws ExecutionException, InterruptedException {

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
}
