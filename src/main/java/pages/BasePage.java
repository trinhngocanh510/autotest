package pages;

import common.DriverFactory;
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

  //  public BasePage(WebDriver driver) {
  //    this.driver = driver;
  //    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  //  }

  protected WebElement waitForVisibility(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected WebElement waitForClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  protected void click(By locator) {
    logger.info("Clicking on element: {}", locator);
    waitForClickable(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = waitForVisibility(locator);
    element.clear();
    element.sendKeys(text);
  }

  protected String getText(By locator) {
    return waitForVisibility(locator).getText();
  }

  public void openUrl(String url) {
    driver.get(url);
  }

  protected boolean isElementExist(By locator) {
    return !driver.findElements(locator).isEmpty();
  }
}
