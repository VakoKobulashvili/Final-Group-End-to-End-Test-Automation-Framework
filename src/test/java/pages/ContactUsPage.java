package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class ContactUsPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By getInTouchHeader = By.xpath("//h2[contains(.,'GET IN TOUCH')] | //h2[contains(.,'Get In Touch')] | //h2[contains(.,'Get in Touch')] | //h2[contains(.,'get in touch')]");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.id("message");
    private final By uploadFileInput = By.name("upload_file");
    private final By submitButton = By.xpath("//input[@name='submit']");
    private final By successMessage = By.xpath("//div[contains(@class,'status alert alert-success')]");
    private final By homeButton = By.xpath("//a[contains(@href,'/') and contains(@class,'btn')] | //span[contains(text(),'Home')]/parent::a");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void assertGetInTouchVisible() {
        Assert.assertTrue(wait.visible(getInTouchHeader).isDisplayed(), "GET IN TOUCH header is not visible.");
    }

    public void enterName(String name) {
        wait.visible(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.visible(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterSubject(String subject) {
        wait.visible(subjectInput).clear();
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void enterMessage(String message) {
        wait.visible(messageInput).clear();
        driver.findElement(messageInput).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        WebElement fileInput = wait.visible(uploadFileInput);
        fileInput.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        wait.clickable(submitButton).click();
    }

    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }
    }

    public void assertSuccessMessageVisible() {
        String successText = wait.visible(successMessage).getText().trim();
        Assert.assertTrue(successText.contains("Success! Your details have been submitted successfully."), 
            "Success message is not visible or incorrect. Actual: " + successText);
    }

    public void clickHomeButton() {
        wait.clickable(homeButton).click();
    }
}

