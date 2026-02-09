package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.WaitUtils;

public class SignupPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By enterAccountInfoHeader = By.xpath("//h2[contains(text(),'ENTER ACCOUNT INFORMATION')] | //b[contains(text(),'Enter Account Information')]");
    private final By titleMr = By.id("id_gender1");
    private final By titleMrs = By.id("id_gender2");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By addressInput = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[contains(@data-qa,'create-account')]");

    private final By accountCreatedHeader = By.xpath("//h2[contains(text(),'ACCOUNT CREATED!')] | //b[contains(text(),'Account Created!')]");
    private final By continueButton = By.xpath("//a[contains(@data-qa,'continue-button')] | //a[contains(text(),'Continue')]");

    private final By accountDeletedHeader = By.xpath("//h2[contains(text(),'ACCOUNT DELETED!')] | //b[contains(text(),'Account Deleted!')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertEnterAccountInformationVisible() {
        Assert.assertTrue(wait.visible(enterAccountInfoHeader).isDisplayed(), "ENTER ACCOUNT INFORMATION header is not visible.");
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            wait.clickable(titleMr).click();
        } else if (title.equalsIgnoreCase("Mrs")) {
            wait.clickable(titleMrs).click();
        }
    }

    public void enterName(String name) {
        WebElement nameElement = wait.visible(nameInput);
        try {
            if (nameElement.isEnabled()) {
                nameElement.clear();
                nameElement.sendKeys(name);
            }
        } catch (InvalidElementStateException e) {
        }
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.visible(emailInput);
        try {
            if (emailElement.isEnabled()) {
                emailElement.clear();
                emailElement.sendKeys(email);
            }
        } catch (InvalidElementStateException e) {
        }
    }

    public void enterPassword(String password) {
        wait.visible(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select daySelect = new Select(wait.visible(dayDropdown));
        daySelect.selectByValue(day);
        Select monthSelect = new Select(wait.visible(monthDropdown));
        monthSelect.selectByValue(month);
        Select yearSelect = new Select(wait.visible(yearDropdown));
        yearSelect.selectByValue(year);
    }

    public void selectNewsletterCheckbox() {
        WebElement checkbox = wait.visible(newsletterCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectOffersCheckbox() {
        WebElement checkbox = wait.visible(offersCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void enterFirstName(String firstName) {
        wait.visible(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.visible(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        wait.visible(companyInput).clear();
        driver.findElement(companyInput).sendKeys(company);
    }

    public void enterAddress(String address) {
        wait.visible(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);
    }

    public void enterAddress2(String address2) {
        wait.visible(address2Input).clear();
        driver.findElement(address2Input).sendKeys(address2);
    }

    public void selectCountry(String country) {
        Select countrySelect = new Select(wait.visible(countryDropdown));
        countrySelect.selectByVisibleText(country);
    }

    public void enterState(String state) {
        wait.visible(stateInput).clear();
        driver.findElement(stateInput).sendKeys(state);
    }

    public void enterCity(String city) {
        wait.visible(cityInput).clear();
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        wait.visible(zipcodeInput).clear();
        driver.findElement(zipcodeInput).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        wait.visible(mobileNumberInput).clear();
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        wait.clickable(createAccountButton).click();
    }

    public void assertAccountCreatedVisible() {
        Assert.assertTrue(wait.visible(accountCreatedHeader).isDisplayed(), "ACCOUNT CREATED! header is not visible.");
    }

    public void clickContinueButton() {
        wait.clickable(continueButton).click();
    }

    public void assertAccountDeletedVisible() {
        Assert.assertTrue(wait.visible(accountDeletedHeader).isDisplayed(), "ACCOUNT DELETED! header is not visible.");
    }
}

