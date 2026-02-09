package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegisterUserApiTest11 extends BaseApiTest {

    @Test(description = " test 11: registers a new user and checks if the user is created successfully")
    public void registerUserAccount() {

        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Luka")
            .formParam("email", "luka1@test.com")
            .formParam("password", "test12345678")
            .formParam("title", "Mr")
            .formParam("birth_date", "10")
            .formParam("birth_month", "May")
            .formParam("birth_year", "1998")
            .formParam("firstname", "Luka")
            .formParam("lastname", "gachechiladze")
            .formParam("company", "QA")
            .formParam("address1", "Test Address")
            .formParam("address2", "Test Address2")
            .formParam("country", "India")
            .formParam("zipcode", "12345")
            .formParam("state", "Test State")
            .formParam("city", "Test City")
            .formParam("mobile_number", "1234567890")
        .when()
            .post("/createAccount")
        .then()
            .statusCode(201)
            .body("message", containsString("User created"));
    }
}
