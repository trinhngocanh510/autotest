package core.driver;

import common.ConfigLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        WebDriver driver;

        if (threadDriver.get() == null) {
            String pathDriver = ConfigLoader.get(String.format("webdriver.%s.driver", browser));
            switch (browser.toLowerCase()) {
                case "chrome":
                    String switches = ConfigLoader.get("chrome.switches");
                    System.setProperty("webdriver.chrome.driver", pathDriver);
                    ChromeOptions chromeOptions = new ChromeOptions();

                    if (switches != null) {
                        String[] listSwitches = switches.split(";");
                        chromeOptions.addArguments(Arrays.asList(listSwitches));
                    }

                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    prefs.put("profile.password_manager_leak_detection", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);

                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "gecko":
                    System.setProperty("webdriver.gecko.driver", pathDriver);

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
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
