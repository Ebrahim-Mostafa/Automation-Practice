package nextlevel.liveproject.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AllureReport {

    @Step("User message")
    public static void logMessage(String message) {
	System.out.println(message);
    }

    @Step("Screenshot")
    public static void logScreenshot(WebDriver driver) {
	attachScreenshot(driver);
    }

    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////

    @Attachment(type = "image/png")
    private static byte[] attachScreenshot(WebDriver driver) {
	try {
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    return Files.toByteArray(screenshot);
	} catch (IOException e) {
	    return null;
	}
    }

}