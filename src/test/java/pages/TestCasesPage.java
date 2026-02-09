package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class TestCasesPage {
    private final WaitUtils wait;

    private final By header = By.xpath("//h2[contains(.,'Test Cases')]");

    public TestCasesPage(WebDriver driver) {
        this.wait = new WaitUtils(driver);
    }

    public void assertNavigatedSuccessfully() {
        Assert.assertTrue(wait.visible(header).isDisplayed(), "User is not on Test Cases page.");
    }
}