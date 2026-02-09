package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllProductsApiTest1 extends BaseApiTest {

    @Test(description = " test 1: Verify that the API returns a list of all products with correct structure and status code")
    public void getAllProductsList() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/productsList")
        .then()
            .statusCode(200)
            .body("products", notNullValue())
            .body("products.size()", greaterThan(0));
    }
}
