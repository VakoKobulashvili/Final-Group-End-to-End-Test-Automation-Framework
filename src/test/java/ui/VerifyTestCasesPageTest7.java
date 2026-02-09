package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

public class VerifyTestCasesPageTest7 extends BaseTest {

    @Test(description = "Test 7: Verify Test Cases Page")
    public void verifyTestCasesPage() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickTestCases();

        new TestCasesPage(driver).assertNavigatedSuccessfully();
    }
}