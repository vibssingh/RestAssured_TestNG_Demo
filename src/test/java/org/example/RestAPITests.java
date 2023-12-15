package org.example;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("REST API Regression Testing using TestNG")
@Feature("Verify CRUID Operations on User module")
public class RestAPITests {

    @Test(description = "To get the details of user with id 3", priority = 0)
    @Story("GET Request with Valid User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of user of id-3")
    public void verifyUser() {

        // Given
        given()

                .filter(new AllureRestAssured())
                // When
                .when()
                .get("https://reqres.in/api/users/3")

                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")

                // To verify user of id 3
                .body("data.email", equalTo("emma.wong@reqres.in"))
                .body("data.first_name", equalTo("Emma"))
                .body("data.last_name", equalTo("Wong"));
    }

    @Test(description = "To create a new user", priority = 1)
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the creation of a new user")
    public void createUser() throws JSONException {

        JSONObject data = new JSONObject();

        data.put("name", "RestAPITest");
        data.put("job", "Testing");

        // GIVEN
        given()

                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(data.toString())

                // WHEN
                .when()
                .post("https://reqres.in/api/users")

                // THEN
                .then()
                .statusCode(201)
                .body("name", equalTo("RestAPITest"))
                .body("job", equalTo("Testing"));

    }

}