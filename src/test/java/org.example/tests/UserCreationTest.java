package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserCreationTest {

    @Test
    public void testUserCreation() {
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Create JSON object with user data
        String userData = "{ \"name\": \"John Doe\", \"job\": \"Software Engineer\" }";

        // Send POST request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/users")
                .then()
                .statusCode(201) // Assert that the status code is 201
                .body("name", equalTo("John Doe"))
                .body("job", equalTo("Software Engineer"))
                .extract()
                .response();

        // Additional validation: Check if the response contains "id" and "createdAt"
        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        // Assert that the id and createdAt fields are present and not null
        Assert.assertNotNull(id, "The ID field should not be null");
        Assert.assertNotNull(createdAt, "The createdAt field should not be null");
    }
}

