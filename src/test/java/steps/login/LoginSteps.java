package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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

    @When("^I login successful with username \"([^\\\"]*)\"$")
    public void iLoginWithSuccessfulUsernameAndPassword(String username) {
        loginPage.loginSuccessful(username);
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        Assert.assertTrue(loginPage.isLoginSuccessfully());
    }
}
