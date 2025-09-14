package core.extension;

import core.driver.DriverFactory;

import io.qameta.allure.Allure;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class DriverLifecycleExtension
        implements BeforeEachCallback, AfterTestExecutionCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        if (context.getTags().contains("ui")) {
            DriverFactory.initDriver();
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            WebDriver driver = DriverFactory.getDriver();
            if (driver == null) {
                System.out.println(
                        "⚠️ No WebDriver available for screenshot: " + context.getDisplayName());
                return;
            }

            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Attach screenshot to Allure report
                Allure.addAttachment(
                        "Screenshot on Failure - " + context.getDisplayName(),
                        new ByteArrayInputStream(screenshot));

                System.out.println(
                        "📸 Screenshot attached to Allure for test: " + context.getDisplayName());
            } catch (Exception e) {
                System.err.println("❌ Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (context.getTags().contains("ui")) {
            DriverFactory.quitDriver();
        }
    }
}
