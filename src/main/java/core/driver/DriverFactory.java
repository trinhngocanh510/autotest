package core.driver;

import common.ConfigLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void initDriver() {
        WebDriver driver;
        String browser = ConfigLoader.get("browser");
        String switches = ConfigLoader.get("chrome.switches");
        String pathDriver = ConfigLoader.get("webdriver.chrome.driver");

        if (threadDriver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", pathDriver);
                    ChromeOptions options = new ChromeOptions();

                    if (switches != null & !switches.isEmpty()) {
                        String[] listSwitches = switches.split(",");
                        for (String arg : listSwitches) {
                            options.addArguments(arg);
                        }
                    }

                    driver = new ChromeDriver(options);
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
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
    }
}
