package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchProductWithoutParamApiTest6 extends BaseApiTest {

    @Test(description = " test 6: Verify that POST to searchProduct without search_product parameter returns 400 error response")
    public void searchProductWithoutParam() {
        given()
            .contentType(ContentType.URLENC)
        .when()
            .post("/searchProduct")
        .then()
            .statusCode(400)
            .body(containsString("Bad request, search_product parameter is missing in POST request."));
    }
}
