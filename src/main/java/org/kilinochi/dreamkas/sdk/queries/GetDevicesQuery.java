package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.DevicesList;

/**
 * @author arman.shamenov
 */
public class GetDevicesQuery extends DreamkasQuery<DevicesList> {

    public GetDevicesQuery(DreamkasClient client) {
        super(client, "/devices", null, DevicesList.class, DreamkasTransportClient.Method.GET);
    }
}
