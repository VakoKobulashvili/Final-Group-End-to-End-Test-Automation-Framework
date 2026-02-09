package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {
    public static void attachFailureScreenshot(WebDriver driver) {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("UI Failure Photo", new ByteArrayInputStream(bytes));
    }
}
