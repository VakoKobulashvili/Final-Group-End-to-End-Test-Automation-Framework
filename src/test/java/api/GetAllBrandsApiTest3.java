package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllBrandsApiTest3 extends BaseApiTest {

    @Test(description = " test 3: Verify that the API returns a list of all brands with correct structure and status code")
    public void getAllBrandsList() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/brandsList")
        .then()
            .statusCode(200)
            .body("brands", notNullValue())
            .body("brands.size()", greaterThan(0));
    }
}
