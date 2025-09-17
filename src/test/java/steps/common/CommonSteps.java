package steps.common;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

import pages.BasePage;

public class CommonSteps {
    BasePage basePage = new BasePage();

    @When("^I click button \"([^\\\"]*)\"$")
    public void iClickButton(String buttonName) {
        basePage.clickButtonByName(buttonName);
    }

    @Then("^I should see \"([^\\\"]*)\" page$")
    public void iShouldSeePage(String pageTitle) {
        Assertions.assertEquals(pageTitle, basePage.getTitlePage());
    }

    @Then("^I should see an error message \"([^\\\"]*)\"$")
    public void iShouldSeeAnErrorMessage(String message) {
        Assertions.assertEquals(message, basePage.getErrorMessage());
    }

    @Then("^I should see a message \"([^\\\"]*)\"$")
    public void iShouldSeeAMessage(String message) {
        Assertions.assertTrue(basePage.isVisibleText(message));
    }
}
