package steps.inventory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

import pages.inventory.InventoryPage;

public class InventorySteps {
    InventoryPage inventoryPage = new InventoryPage();

    @Then("I should see a list of products")
    public void iShouldSeeAListOfProducts() {
        Assertions.assertTrue(inventoryPage.isDisplayListOfProduct());
    }

    @And("Each product should have a name, description, and price")
    public void eachProductShouldHaveANameDescriptionAndPrice() {
        inventoryPage.verifyEachProductHaveNameDescriptionAndPrice();
    }

    @When("^I sort product by \"([^\\\"]*)\"$")
    public void iSortProductBy(String sortName) {
        inventoryPage.sortProductBy(sortName);
    }
}
