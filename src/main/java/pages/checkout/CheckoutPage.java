package pages.checkout;

import org.openqa.selenium.By;

import pages.BasePage;

public class CheckoutPage extends BasePage {

    By inpFirstName = By.id("first-name");
    By inpLastName = By.id("last-name");
    By inpZipCode = By.id("postal-code");

    public void enterFirstName(String firstName) {
        type(inpFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        type(inpLastName, lastName);
    }

    public void enterZipCode(String zipCode) {
        type(inpZipCode, zipCode);
    }
}
