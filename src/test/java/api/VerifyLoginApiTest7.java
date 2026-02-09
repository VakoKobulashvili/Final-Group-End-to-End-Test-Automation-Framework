package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyLoginApiTest7 extends BaseApiTest {

    @Test(dependsOnMethods = "api.RegisterUserApiTest.registerUserAccount")
    public void verifyLoginValid() {

        given()
            .contentType(ContentType.URLENC)
            .formParam("email", ApiTestData.email)
            .formParam("password", ApiTestData.password)
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(200)
            .body("message", containsString("User exists"));
    }
}
