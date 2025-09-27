package tests.ui.base;

import core.driver.DriverFactory;

import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseUiTest {

    private boolean isUiTest(ITestResult result) {
        return result.getMethod().getGroups() != null
                && java.util.Arrays.asList(result.getMethod().getGroups()).contains("ui");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(ITestResult result, @Optional("gecko") String browser) {
        if (isUiTest(result)) {
            System.out.println("Launching browser " + browser);
            DriverFactory.initDriver(browser);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
