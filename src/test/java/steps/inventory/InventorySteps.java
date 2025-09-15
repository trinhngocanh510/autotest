package steps.inventory;

import constants.VariableName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.inventory.InventoryPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Then("^I should see list of product sorted by name \"([^\\\"]*)\"$")
    public void iShouldSeeListOfProductSortedByName(String sortName) {
        List<String> listProductName = inventoryPage.getListProductName();
        List<String> listProductNameSorted = new ArrayList<>(listProductName);
        switch (sortName) {
            case VariableName.SORT_NAME_A_TO_Z:
                Collections.sort(listProductName);
                break;
            case VariableName.SORT_NAME_Z_TO_A:
                listProductNameSorted.sort(Collections.reverseOrder());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortName);
        }
        Assertions.assertEquals(
                listProductNameSorted,
                listProductName,
                "Product list is not sorted correctly: expected "
                        + listProductNameSorted
                        + " but was "
                        + listProductName);
    }

    @Then("^I should see list of product sorted by price \"([^\\\"]*)\"$")
    public void iShouldSeeListOfProductSortedByPrice(String sortName) {
        List<Double> listProductPrice = inventoryPage.getListProductPrice();
        List<Double> listProductPriceSorted = new ArrayList<>(listProductPrice);
        switch (sortName) {
            case VariableName.SORT_PRICE_LOW_TO_HIGH:
                Collections.sort(listProductPrice);
                break;
            case VariableName.SORT_PRICE_HIGH_TO_LOW:
                listProductPriceSorted.sort(Collections.reverseOrder());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortName);
        }
        Assertions.assertEquals(
                listProductPriceSorted, listProductPrice, "Product list is not sorted correctly");
    }

    @When("^I click view detail product \"([^\\\"]*)\"$")
    public void iClickViewDetailProduct(String productName) {
        inventoryPage.clickViewDetailProduct(productName);
    }

    @Then("^I should see only detail of product \"([^\\\"]*)\"$")
    public void iShouldSeeOnlyDetailOfProduct(String productName) {
        Assertions.assertTrue(inventoryPage.isDisplayProduct(productName));
	}

	@When("^I add product \"([^\\\"]*)\" to cart$")
	public void iAddProductToCart(String productName) {
		inventoryPage.addProductToCart(productName);
	}

	@And("I open my cart")
	public void iOpenMyCart() {
        inventoryPage.openMyCart();
    }
}
