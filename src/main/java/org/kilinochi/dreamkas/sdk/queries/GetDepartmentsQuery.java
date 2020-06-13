package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.DepartmentList;

/**
 * @author arman.shamenov
 */
public class GetDepartmentsQuery extends DreamkasQuery<DepartmentList> {

    public GetDepartmentsQuery(DreamkasClient client) {
        super(client, "/departments", null, DepartmentList.class, DreamkasTransportClient.Method.GET);
    }
}
