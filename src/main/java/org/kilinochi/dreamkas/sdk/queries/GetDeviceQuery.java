package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Device;

/**
 * @author arman.shamenov
 */
public class GetDeviceQuery extends DreamkasQuery<Device> {

    public GetDeviceQuery(DreamkasClient client, Long id) {
        super(client, substitute("/devices/{id}", id), null, Device.class, DreamkasTransportClient.Method.GET);
    }
}
