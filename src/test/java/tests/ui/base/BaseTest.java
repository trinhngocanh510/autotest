package tests.ui.base;

import common.DriverFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    //  @BeforeEach
    //  public void setUp() {
    //    driver = DriverFactory.getDriver();
    //    driver.get(ConfigLoader.get("base.url"));
    //  }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
