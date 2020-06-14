package org.kilinochi.dreamkas.sdk.queries;

import org.kilinochi.dreamkas.sdk.client.DreamkasClient;
import org.kilinochi.dreamkas.sdk.client.DreamkasTransportClient;
import org.kilinochi.dreamkas.sdk.model.Department;
import org.kilinochi.dreamkas.sdk.model.NewDepartmentBody;

/**
 * @author arman.shamenov
 */
public class CreateDepartmentQuery extends DreamkasQuery<Department> {

    public CreateDepartmentQuery(DreamkasClient client, NewDepartmentBody body) {
        super(client, "/departments", body, Department.class, DreamkasTransportClient.Method.POST);
    }
}
