package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegisterUserApiTest extends BaseApiTest {

    @Test
    public void registerUserAccount() {

        ApiTestData.email = "luka" + System.currentTimeMillis() + "@test.com";

        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Luka")
            .formParam("email", ApiTestData.email)
            .formParam("password", ApiTestData.password)
            .formParam("title", "Mr")
            .formParam("birth_date", "10")
            .formParam("birth_month", "May")
            .formParam("birth_year", "1998")
            .formParam("firstname", "Luka")
            .formParam("lastname", "Test")
            .formParam("company", "QA")
            .formParam("address1", "Test Address")
            .formParam("country", "India")
            .formParam("zipcode", "12345")
            .formParam("state", "Test State")
            .formParam("city", "Test City")
            .formParam("mobile_number", "1234567890")
        .when()
            .post("/createAccount")
        .then()
            .statusCode(200)
            .body("message", containsString("User created"));
    }
}
