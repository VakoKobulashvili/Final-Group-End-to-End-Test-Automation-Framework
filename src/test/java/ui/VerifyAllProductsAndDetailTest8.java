package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.ProductDetailPage;

public class VerifyAllProductsAndDetailTest8 extends BaseTest {

    @Test(description = "Test 8: Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetail() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);

        products.assertAllProductsPageVisible();

        products.assertProductsListVisible();

        products.openFirstProductDetail();

        new ProductDetailPage(driver).assertAllDetailFieldsVisible();
    }
}
