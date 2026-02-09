package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyLoginApiTest extends BaseApiTest {

    @Test
    public void verifyLoginValid() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("email", "test@test.com")
            .formParam("password", "test123")
        .when()
            .post("/verifyLogin")
        .then()
            .statusCode(200)
            .body("message", containsString("User exists"));
    }
}
