package org.kilinochi.dreamkas.sdk.client;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.Encashment;
import org.kilinochi.dreamkas.sdk.model.EncashmentsList;
import org.kilinochi.dreamkas.sdk.model.QueryResponse;
import org.kilinochi.dreamkas.sdk.queries.GetEncashmentsQuery;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class EncashmentsTest extends UnitTestBase {

    @Test
    void getEncashmentTest() throws ExecutionException, InterruptedException {

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

        assertThat(data, hasSize(1));
        assertEquals(LocalDateTime.of(2017, Month.OCTOBER, 13, 14, 15, 1,239000000), queryResponse.getFrom());
    }
}
