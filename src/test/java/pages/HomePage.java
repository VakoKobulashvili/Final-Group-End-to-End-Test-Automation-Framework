package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class HomePage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By testCasesBtn = By.xpath("//a[contains(@href,'/test_cases')]");
    private final By productsBtn  = By.xpath("//a[contains(@href,'/products')]");
    private final By cartBtn      = By.xpath("//a[contains(@href,'/view_cart')]");

    private final By logo = By.xpath("//div[@class='logo pull-left']//a");

    private final By subscriptionHeader = By.xpath("//h2[text()='Subscription']");
    private final By subscribeEmail = By.id("susbscribe_email");
    private final By subscribeBtn = By.id("subscribe");
    private final By subscribeSuccess = By.id("success-subscribe");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertHomePageVisible() {
        Assert.assertTrue(wait.visible(logo).isDisplayed(), "Home page is not visible (logo not found).");
    }

    public void clickTestCases() {
        wait.clickable(testCasesBtn).click();
    }

    public void clickProducts() {
        wait.clickable(productsBtn).click();
    }

    public void clickCart() {
        wait.clickable(cartBtn).click();
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.visible(subscriptionHeader);
    }

    public void assertSubscriptionVisible() {
        Assert.assertTrue(wait.visible(subscriptionHeader).isDisplayed(), "Subscription header not visible.");
    }

    public void subscribeWithEmail(String email) {
        wait.visible(subscribeEmail).clear();
        driver.findElement(subscribeEmail).sendKeys(email);
        wait.clickable(subscribeBtn).click();
    }

    public void assertSubscriptionSuccessMessage() {
        String msg = wait.visible(subscribeSuccess).getText().trim();
        Assert.assertEquals(msg, "You have been successfully subscribed!", "Subscription success message mismatch.");
    }
}
