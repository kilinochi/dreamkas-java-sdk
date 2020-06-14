package org.kilinochi.dreamkas.sdk.client;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.kilinochi.dreamkas.sdk.model.Device;
import org.kilinochi.dreamkas.sdk.model.DevicesList;
import org.kilinochi.dreamkas.sdk.queries.GetDeviceQuery;
import org.kilinochi.dreamkas.sdk.queries.GetDevicesQuery;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class DevicesTest extends UnitTestBase {

    @Test
    void getDeviceTest() throws ExecutionException, InterruptedException {
        server.stubFor(
                get("/api/devices/1").willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/device.json")));


        Device device = new GetDeviceQuery(client, 1L).execute().get();

        assertEquals(new Device("Касса 1", 1L, 20L, 1L, 4), device);
    }

    @Test
    void getDevicesTest() throws ExecutionException, InterruptedException {
        server.stubFor(
                get("/api/devices").willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/devices.json")));

        DevicesList devicesList = new GetDevicesQuery(client).execute().get();
        List<Device> devices = devicesList.getDevices();

        assertThat(devices, hasItems(
                new Device("Касса 1", 1L, 20L, 1L, 4),
                new Device("Касса 2", 2L, 25L, 2L, 4)
        ));
    }
}
