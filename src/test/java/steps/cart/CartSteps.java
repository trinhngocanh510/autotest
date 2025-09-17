package steps.cart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.cart.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Then("^I should see product \"([^\\\"]*)\" in my cart$")
    public void iShouldSeeProductInMyCart(String productName) {
        Assertions.assertTrue(cartPage.isProductAddedToCart(productName));
    }

    @And("^I remove product \"([^\\\"]*)\" from cart$")
    public void iRemoveProductFromCart(String productName) {
        cartPage.removeProduct(productName);
    }

    @Then("^I should not see product \"([^\\\"]*)\" in my cart$")
    public void iShouldNotSeeProductInMyCart(String productName) {
        Assertions.assertFalse(cartPage.isProductAddedToCart(productName));
    }
}
