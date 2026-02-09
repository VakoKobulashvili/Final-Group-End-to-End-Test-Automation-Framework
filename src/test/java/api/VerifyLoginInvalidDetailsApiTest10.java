package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyLoginInvalidDetailsApiTest10 extends BaseApiTest {

    @Test(description = " test 10: Verify that POST to verifyLogin with invalid credentials returns 404 error response")
    public void verifyLoginInvalidDetails() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "invalid@test.com")
            .formParam("password", "wrongpassword123")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(404)
            .body(containsString("User not found!"));
    }
}
