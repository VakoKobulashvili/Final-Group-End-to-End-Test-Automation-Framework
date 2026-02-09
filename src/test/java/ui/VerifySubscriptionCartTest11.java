package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class VerifySubscriptionCartTest11 extends BaseTest {

    @Test(description = "Test 11: Verify Subscription in Cart page")
    public void verifySubscriptionCart() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickCart();

        CartPage cart = new CartPage(driver);
        cart.assertCartPageVisible();

        cart.scrollToFooter();

        cart.assertSubscriptionVisible();

        cart.subscribeWithEmail("vakotest@gmail.com");

        cart.assertSubscriptionSuccessMessage();
    }
}
