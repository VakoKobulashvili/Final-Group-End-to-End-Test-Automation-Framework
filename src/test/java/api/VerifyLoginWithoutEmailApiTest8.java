package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyLoginWithoutEmailApiTest8 extends BaseApiTest {

    @Test(description = " test 8: Verify that POST to verifyLogin without email parameter returns 400 error response")
    public void verifyLoginWithoutEmail() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("password", "test12345678")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(400)
            .body(containsString("Bad request, email or password parameter is missing in POST request."));
    }
}
