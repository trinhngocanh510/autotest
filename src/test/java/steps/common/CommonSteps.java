package steps.common;

import io.cucumber.java.en.When;

import pages.BasePage;

public class CommonSteps {
    BasePage basePage = new BasePage();

    @When("^I click button \"([^\\\"]*)\"$")
    public void iClickButton(String buttonName) {
        basePage.clickButtonByName(buttonName);
    }
}
