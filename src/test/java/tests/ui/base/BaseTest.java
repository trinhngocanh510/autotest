package tests.ui.base;

import common.DriverFactory;
import common.ConfigLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
  protected WebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = DriverFactory.getDriver();
    driver.get(ConfigLoader.get("base.url"));
  }

  @AfterEach
  public void tearDown() {
    DriverFactory.quitDriver();
  }
}
