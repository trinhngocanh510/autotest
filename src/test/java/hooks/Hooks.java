package hooks;

import core.driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario() {
        DriverFactory.initDriver("gecko");
    }

    @After
    public void afterScenario() {
        DriverFactory.quitDriver();
    }
}
