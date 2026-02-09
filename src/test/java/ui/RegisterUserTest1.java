package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

import java.util.UUID;

public class RegisterUserTest1 extends BaseTest {

    @Test(description = "Test Case 1: Register User")
    public void registerUser() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        login.assertNewUserSignupVisible();

        String name = "SabaAAAAAAA";
        String email = "sabatest@gmail.ge";

        login.enterSignupNameAndEmail(name, email);

        login.clickSignupButton();

        SignupPage signup = new SignupPage(driver);

        signup.assertEnterAccountInformationVisible();

        signup.selectTitle("Mr");
        signup.enterName(name);
        signup.enterEmail(email);
        signup.enterPassword("TestPassword123");
        signup.selectDateOfBirth("15", "5", "2006");

        signup.selectNewsletterCheckbox();

        signup.selectOffersCheckbox();

        signup.enterFirstName("Saba");
        signup.enterLastName("Kublashvili");
        signup.enterCompany("Test Company");
        signup.enterAddress("123 Test Street");
        signup.enterAddress2("Building 43");
        signup.selectCountry("United States");
        signup.enterState("California");
        signup.enterCity("Los Angeles");
        signup.enterZipcode("90001");
        signup.enterMobileNumber("1234567890");

        signup.clickCreateAccountButton();

        signup.assertAccountCreatedVisible();

        signup.clickContinueButton();

        login.assertLoggedInAsUsername(name);

        login.clickDeleteAccountButton();

        signup.assertAccountDeletedVisible();
        signup.clickContinueButton();
    }
}

