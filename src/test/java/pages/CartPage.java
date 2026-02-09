package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class CartPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By cartBreadcrumb = By.xpath("//li[@class='active' and contains(text(),'Shopping Cart')]");

    private final By subscriptionHeader = By.xpath("//h2[text()='Subscription']");
    private final By email = By.id("susbscribe_email");
    private final By subscribeBtn = By.id("subscribe");
    private final By success = By.id("success-subscribe");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertCartPageVisible() {
        Assert.assertTrue(wait.visible(cartBreadcrumb).isDisplayed(), "Cart page not visible.");
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.visible(subscriptionHeader);
    }

    public void assertSubscriptionVisible() {
        Assert.assertTrue(wait.visible(subscriptionHeader).isDisplayed(), "Subscription not visible on Cart page.");
    }

    public void subscribeWithEmail(String mail) {
        wait.visible(email).clear();
        driver.findElement(email).sendKeys(mail);
        wait.clickable(subscribeBtn).click();
    }

    public void assertSubscriptionSuccessMessage() {
        String msg = wait.visible(success).getText().trim();
        Assert.assertEquals(msg, "You have been successfully subscribed!", "Subscription success message mismatch.");
    }
}
