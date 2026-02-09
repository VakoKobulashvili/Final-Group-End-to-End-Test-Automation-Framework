package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAllProductsApiTest2 extends BaseApiTest {

    @Test(description = " test 2: Verify that POST method on productsList endpoint returns 405 error response")
    public void postAllProductsList() {
        given()
            .contentType(ContentType.URLENC)
        .when()
            .post("/productsList")
        .then()
            .statusCode(405)
            .body(containsString("This request method is not supported."));
    }
}
