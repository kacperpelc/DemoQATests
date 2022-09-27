package com.pel.pages.bookStoreApplication.bookStoreApi;

import com.pel.utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookStoreRequest {
    private final String ENDPOINT_BOOKS = Constants.DEMOQA_URL + "/BookStore/v1/Books";
    private final String ENDPOINT_BOOK = Constants.DEMOQA_URL + "/BookStore/v1/Book";

    public Response getBooks() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(ENDPOINT_BOOKS)
                .then()
                .extract()
                .response();
    }
}
