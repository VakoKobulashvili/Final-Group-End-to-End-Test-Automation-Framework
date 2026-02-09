package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class LoginPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By newUserSignupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By signupNameInput = By.name("name");
    private final By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[contains(@data-qa,'signup-button')]");

    private final By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
    private final By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[contains(@data-qa,'login-button')]");
    private final By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By logoutButton = By.xpath("//a[contains(@href,'/logout')]");
    private final By deleteAccountButton = By.xpath("//a[contains(@href,'/delete_account')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertNewUserSignupVisible() {
        Assert.assertTrue(wait.visible(newUserSignupHeader).isDisplayed(), "New User Signup! header is not visible.");
    }

    public void enterSignupNameAndEmail(String name, String email) {
        wait.visible(signupNameInput).clear();
        driver.findElement(signupNameInput).sendKeys(name);
        wait.visible(signupEmailInput).clear();
        driver.findElement(signupEmailInput).sendKeys(email);
    }

    public void clickSignupButton() {
        wait.clickable(signupButton).click();
    }

    public void assertLoginToYourAccountVisible() {
        Assert.assertTrue(wait.visible(loginHeader).isDisplayed(), "Login to your account header is not visible.");
    }

    public void enterLoginCredentials(String email, String password) {
        wait.visible(loginEmailInput).clear();
        driver.findElement(loginEmailInput).sendKeys(email);
        wait.visible(loginPasswordInput).clear();
        driver.findElement(loginPasswordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.clickable(loginButton).click();
    }

    public void assertLoginErrorVisible() {
        Assert.assertTrue(wait.visible(loginError).isDisplayed(), "Login error message is not visible.");
    }

    public void assertLoggedInAsUsername(String username) {
        String loggedInText = wait.visible(loggedInAs).getText();
        Assert.assertTrue(loggedInText.contains("Logged in as"), "Logged in as username is not visible.");
        Assert.assertTrue(loggedInText.contains(username), "Username is not displayed correctly.");
    }

    public void clickLogoutButton() {
        wait.clickable(logoutButton).click();
    }

    public void assertNavigatedToLoginPage() {
        Assert.assertTrue(wait.visible(loginHeader).isDisplayed(), "User is not navigated to login page.");
    }

    public void clickDeleteAccountButton() {
        wait.clickable(deleteAccountButton).click();
    }
}

