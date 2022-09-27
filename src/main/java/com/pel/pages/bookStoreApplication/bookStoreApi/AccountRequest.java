package com.pel.pages.bookStoreApplication.bookStoreApi;

import com.pel.utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AccountRequest {
    private final String ENDPOINT_AUTHORIZED = Constants.DEMOQA_URL + "/Account/v1/Authorized";
    private final String ENDPOINT_GENERATE_TOKEN = Constants.DEMOQA_URL + "/Account/v1/GenerateToken";
    private final String ENDPOINT_USER = Constants.DEMOQA_URL + "/Account/v1/User";

    public Response postNewUser(String name, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", name);
        params.put("password", password);

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .with()
                .body(params)
                .log()
                .all()
                .when()
                .post(ENDPOINT_USER);
    }
}
