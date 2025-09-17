package steps.checkout;

import io.cucumber.java.en.And;
import pages.checkout.CheckoutPage;

public class CheckoutSteps {
    CheckoutPage checkoutPage = new CheckoutPage();

    @And("^I enter first name \"([^\\\"]*)\"$")
    public void iEnterFirstName(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @And("^I enter last name \"([^\\\"]*)\"$")
    public void iEnterLastName(String lastName) {
        checkoutPage.enterLastName(lastName);
    }

    @And("^I enter zip code \"([^\\\"]*)\"$")
    public void iEnterZipCode(String zipCode) {
        checkoutPage.enterZipCode(zipCode);
    }
}
