package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchProductApiTest extends BaseApiTest {

    @Test
    public void searchProduct() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("search_product", "top")
        .when()
            .post("/searchProduct")
        .then()
            .statusCode(200)
            .body("products", notNullValue())
            .body("products.size()", greaterThan(0));
    }
}
