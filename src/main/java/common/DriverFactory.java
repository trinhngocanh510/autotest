package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      String browser = ConfigLoader.get("browser");
      switch (browser.toLowerCase()) {
        case "chrome":
          System.setProperty(
              "webdriver.chrome.driver", "src/test/resources/drives/windows/chromedriver.exe");
          driver = new ChromeDriver();
          break;
        case "firefox":
          driver = new FirefoxDriver();
          break;
        default:
          throw new IllegalArgumentException("Browser not supported: " + browser);
      }
      driver.manage().window().maximize();
      threadDriver.set(driver);
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
      threadDriver.get().quit();
      threadDriver.remove();
    }
  }
}
