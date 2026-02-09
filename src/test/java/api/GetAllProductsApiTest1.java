package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllProductsApiTest extends BaseApiTest {

    @Test
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
