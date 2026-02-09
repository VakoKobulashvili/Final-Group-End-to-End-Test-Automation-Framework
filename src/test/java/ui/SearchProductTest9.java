package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class SearchProductTest9 extends BaseTest {

    @Test(description = "Test 9: Search Product")
    public void searchProduct() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);

        products.assertAllProductsPageVisible();

        products.searchFor("top");

        products.assertSearchedProductsVisible();

        products.assertSearchResultsVisible();
    }
}
