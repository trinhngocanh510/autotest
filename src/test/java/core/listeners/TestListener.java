package core.listeners;

import core.driver.DriverFactory;

import io.qameta.allure.Allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            System.out.println("⚠️ No WebDriver available for screenshot: " + result.getName());
            return;
        }

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Allure report
            Allure.addAttachment(
                    "Screenshot on Failure - " + result.getName(),
                    new ByteArrayInputStream(screenshot));

            System.out.println("📸 Screenshot attached to Allure for test: " + result.getName());
        } catch (Exception e) {
            System.err.println("❌ Failed to capture screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
