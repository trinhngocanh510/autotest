package pages;

import core.driver.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver = DriverFactory.getDriver();
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityText(String text) {
        return waitForVisibility(By.xpath(String.format("//*[text()='%s']", text)));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void clickButtonByName(String buttonName) {
        click(By.xpath(String.format("//*[text()='%s']", buttonName)));
    }

    public void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public boolean isElementExist(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
