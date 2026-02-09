package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginUserIncorrectTest3 extends BaseTest {

    @Test(description = "Test Case 3: Login User with incorrect email and password")
    public void loginUserIncorrect() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        login.assertLoginToYourAccountVisible();

        login.enterLoginCredentials("incorrect@gmail.com", "pass123");

        login.clickLoginButton();

        login.assertLoginErrorVisible();
    }
}

