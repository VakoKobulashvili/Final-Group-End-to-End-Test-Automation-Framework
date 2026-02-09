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

            .formParam("email", createdUserEmail)
            .formParam("password", CREATED_USER_PASSWORD)
        .when()
            .post("/verifyLogin")
        .then()
                .statusCode(200)
                .body(containsString("User exists!"));
    }
}
