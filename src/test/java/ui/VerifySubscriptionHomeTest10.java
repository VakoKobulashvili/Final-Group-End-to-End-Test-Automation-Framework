package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifySubscriptionHomeTest10 extends BaseTest {

    @Test(description = "Test 10: Verify Subscription in home page")
    public void verifySubscriptionHome() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.scrollToFooter();

        home.assertSubscriptionVisible();

        home.subscribeWithEmail("vakotest@gmail.com");

        home.assertSubscriptionSuccessMessage();
    }
}
