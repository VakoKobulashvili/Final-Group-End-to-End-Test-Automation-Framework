package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By allProductsHeader = By.xpath("//h2[contains(.,'All Products')]");
    private final By productsList = By.cssSelector(".features_items .product-image-wrapper");
    private final By firstViewProduct = By.xpath("(//a[text()='View Product'])[1]");

    private final By searchInput = By.id("search_product");
    private final By searchBtn = By.id("submit_search");
    private final By searchedHeader = By.xpath("//h2[text()='Searched Products']");
    private final By searchedItems = By.cssSelector(".features_items .product-image-wrapper");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertAllProductsPageVisible() {
        Assert.assertTrue(wait.visible(allProductsHeader).isDisplayed(), "ALL PRODUCTS page header not visible.");
    }

    public void assertProductsListVisible() {
        List<WebElement> items = driver.findElements(productsList);
        Assert.assertTrue(items.size() > 0, "Products list is not visible or empty.");
    }

    public void openFirstProductDetail() {
        wait.clickable(firstViewProduct).click();
    }

    public void searchFor(String productName) {
        wait.visible(searchInput).clear();
        driver.findElement(searchInput).sendKeys(productName);
        wait.clickable(searchBtn).click();
    }

    public void assertSearchedProductsVisible() {
        Assert.assertTrue(wait.visible(searchedHeader).isDisplayed(), "SEARCHED PRODUCTS header not visible.");
    }

    public void assertSearchResultsVisible() {
        List<WebElement> items = driver.findElements(searchedItems);
        Assert.assertTrue(items.size() > 0, "No searched products are visible.");
        for (WebElement el : items) {
            Assert.assertTrue(el.isDisplayed(), "A searched product item is not displayed.");
        }
    }
}
