package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;
import java.nio.file.*;

public class ScreenshotUtils {

    public static void attachFailureScreenshot(WebDriver driver) {

        try {
            byte[] bytes = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Path dir = Paths.get("screenshots");
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }

            String fileName = "screenshots/fail_"
                    + System.currentTimeMillis() + ".png";

            Files.write(Paths.get(fileName), bytes);

            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(bytes),
                    ".png"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
