package base;

import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get("http://automationexercise.com");
    }

    protected void assertHomeVisible() {
        HomePage home = new HomePage(driver);
        home.assertHomePageVisible();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
