package tests.ui.base;

import common.DriverFactory;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotOnFailureExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
	    try {
		    WebDriver driver = DriverFactory.getDriver();
		    if (driver != null) {
			    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    Path destPath = Paths.get("screenshots",
					    context.getDisplayName().replace(" ", "_") + ".png");
			    Files.createDirectories(destPath.getParent());
			    Files.copy(src.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
			    System.out.println("📸 Screenshot saved: " + destPath);
		    }
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }
}
