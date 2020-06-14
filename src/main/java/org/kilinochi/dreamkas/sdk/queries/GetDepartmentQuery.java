package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Department;

/**
 * @author arman.shamenov
 */
public class GetDepartmentQuery extends DreamkasQuery<Department> {

    public GetDepartmentQuery(DreamkasClient client, Long id) {
        super(client, substitute("/departments/{id}", id), null, Department.class, DreamkasTransportClient.Method.GET);
    }
}
