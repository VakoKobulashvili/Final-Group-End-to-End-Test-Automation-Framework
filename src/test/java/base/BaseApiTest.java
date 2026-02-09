package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    // Shared test data for API tests
    protected static String createdUserEmail;
    protected static final String CREATED_USER_PASSWORD = "test12345678";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }
}
