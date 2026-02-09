package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContactUsFormTest6 extends BaseTest {

    @Test(description = "Test Case 6: Contact Us Form")
    public void contactUsForm() {
        HomePage home = new HomePage(driver);

        home.assertHomePageVisible();

        home.clickContactUs();

        ContactUsPage contactUs = new ContactUsPage(driver);

        contactUs.assertGetInTouchVisible();

        contactUs.enterName("SabaUser");
        contactUs.enterEmail("Sabauser@gmail.com");
        contactUs.enterSubject("Test Subject");
        contactUs.enterMessage("Test Message");

        try {
            Path tempFile = Files.createTempFile("test_upload", ".txt");
            Files.write(tempFile, "Test file content".getBytes());
            String filePath = tempFile.toAbsolutePath().toString();
            contactUs.uploadFile(filePath);
        } catch (IOException e) {
        }

        contactUs.clickSubmitButton();

        contactUs.acceptAlert();

        contactUs.assertSuccessMessageVisible();

        contactUs.clickHomeButton();
        home.assertHomePageVisible();
    }
}

