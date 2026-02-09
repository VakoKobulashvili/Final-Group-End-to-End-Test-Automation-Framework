package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegisterUserApiTest extends BaseApiTest {

    @Test
    public void registerUserAccount() {
        String email = "luka" + System.currentTimeMillis() + "@test.com";

        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Luka")
            .formParam("email", email)
            .formParam("password", "test123")
            .formParam("title", "Mr")
            .formParam("birth_date", "10")
            .formParam("birth_month", "May")
            .formParam("birth_year", "1998")
            .formParam("firstname", "Luka")
            .formParam("lastname", "Gachechiladze")
            .formParam("company", "QA")
            .formParam("address1", "Test Address")
            .formParam("address2", "Test Address2")
            .formParam("country", "Georgia")
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
