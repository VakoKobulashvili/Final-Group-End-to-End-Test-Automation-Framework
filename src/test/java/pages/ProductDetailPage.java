package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class ProductDetailPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By productName = By.cssSelector(".product-information h2");
    private final By category = By.xpath("//p[contains(text(),'Category:')]");
    private final By price = By.cssSelector(".product-information span span");
    private final By availability = By.xpath("//b[text()='Availability:']");
    private final By condition = By.xpath("//b[text()='Condition:']");
    private final By brand = By.xpath("//b[text()='Brand:']");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertAllDetailFieldsVisible() {
        Assert.assertTrue(wait.visible(productName).isDisplayed(), "Product name not visible.");
        Assert.assertTrue(wait.visible(category).isDisplayed(), "Category not visible.");
        Assert.assertTrue(wait.visible(price).isDisplayed(), "Price not visible.");

        Assert.assertTrue(wait.visible(availability).isDisplayed(), "Availability label not visible.");
        Assert.assertTrue(wait.visible(condition).isDisplayed(), "Condition label not visible.");
        Assert.assertTrue(wait.visible(brand).isDisplayed(), "Brand label not visible.");

        String body = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(body.contains("Availability:"), "Availability text not present.");
        Assert.assertTrue(body.contains("Condition:"), "Condition text not present.");
        Assert.assertTrue(body.contains("Brand:"), "Brand text not present.");
    }
}
