package api;

import base.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutAllBrandsApiTest4 extends BaseApiTest {

    @Test(description = " test 4: Verify that PUT method on brandsList endpoint returns 405 error response")
    public void putAllBrandsList() {
        given()
            .contentType(ContentType.URLENC)
        .when()
            .put("/brandsList")
        .then()
            .statusCode(405)
            .body(containsString("This request method is not supported."));
    }
}
