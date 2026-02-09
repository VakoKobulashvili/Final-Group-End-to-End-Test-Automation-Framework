package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyLoginApiTest7 extends BaseApiTest {

    @Test(description = " test 7: verifies if the user is logged in successfully", dependsOnMethods = "api.RegisterUserApiTest11.registerUserAccount")
    public void verifyLoginValid() {

        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "luka1@test.com")
            .formParam("password", "test12345678")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(200)
            .body("message", containsString("User exists"));
    }
}
