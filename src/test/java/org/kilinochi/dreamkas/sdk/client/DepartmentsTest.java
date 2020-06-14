package org.kilinochi.dreamkas.sdk.client;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kilinochi.dreamkas.sdk.model.Department;
import org.kilinochi.dreamkas.sdk.model.DepartmentList;
import org.kilinochi.dreamkas.sdk.model.NewDepartmentBody;
import org.kilinochi.dreamkas.sdk.model.Tax;
import org.kilinochi.dreamkas.sdk.queries.CreateDepartmentQuery;
import org.kilinochi.dreamkas.sdk.queries.GetDepartmentQuery;
import org.kilinochi.dreamkas.sdk.queries.GetDepartmentsQuery;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class DepartmentsTest extends UnitTestBase {

    @Test
    void getDepartmentTest() throws ExecutionException, InterruptedException {

        server.stubFor(
                get(urlEqualTo("/api/departments/1"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/department.json")));

        Department department = new GetDepartmentQuery(client, 1L).execute().get();

        assertEquals(new Department("Хлебобулочные изделия", Tax.NDS_0_V1, 1L), department);
    }

    @Test
    void getDepartmentsTest() throws ExecutionException, InterruptedException {

        server.stubFor(
                get(urlEqualTo("/api/departments"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/departments.json")));

        DepartmentList departmentList = new GetDepartmentsQuery(client).execute().get();

        List<Department> departments = departmentList.getDepartments();

        assertEquals(4, departments.size());
        assertThat(departments, hasItems(
                new Department("Хлебобулочные изделия", Tax.NDS_0_V1, 1L),
                new Department("Мясные изделия", Tax.NDS_20_V1, 2L),
                new Department("Молочная продукция", Tax.NDS_10, 3L),
                new Department("Бытовая химия", Tax.NDS_MIXED_V1, 4L)
        ));
    }

    @Test
    void createDepartmentTest() throws ExecutionException, InterruptedException {
        server.stubFor(
                post(urlEqualTo("/api/departments"))
                        .withRequestBody(equalToJson("{\n" +
                                "  \"name\": \"Хлебобулочные изделия\",\n" +
                                "  \"tax\": 0\n" +
                                "}"))
                        .willReturn(aResponse()
                                .withStatus(201)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("json/department.json")));

        Department department = new CreateDepartmentQuery(client, new NewDepartmentBody("Хлебобулочные изделия", Tax.NDS_0_V1)).execute().get();

        assertEquals(new Department("Хлебобулочные изделия", Tax.NDS_0_V1, 1L), department);
    }
}
