package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

import pages.login.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("^I am on the SauceDemo login page$")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage.open();
    }

    @When("^I login with username \"([^\\\"]*)\" and password \"([^\\\"]*)\"$")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        Assertions.assertTrue(loginPage.isLoginSuccessful());
    }

    @Then("^I should see an error message \"([^\\\"]*)\"$")
    public void iShouldSeeAnErrorMessage(String message) {
        Assertions.assertEquals(message, loginPage.getErrorMessage());
    }
}
