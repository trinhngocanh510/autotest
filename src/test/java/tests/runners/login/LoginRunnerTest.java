package tests.runners.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/login/Login.feature",
        glue = {"steps", "hooks"},
        plugin = {"pretty","summary", "html:target/cucumber-reports/checkout-report.html"},
        monochrome = true)
public class LoginRunnerTest extends AbstractTestNGCucumberTests {}
