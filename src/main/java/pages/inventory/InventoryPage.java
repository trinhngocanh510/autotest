package pages.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    private By iconCart = By.id("shopping_cart_container");

    public boolean isDisplayListOfProduct() {
        return isElementExist(By.id("inventory_container"));
    }

    public void verifyEachProductHaveNameDescriptionAndPrice() {
        driver.findElements(By.id("inventory_container"))
                .forEach(
                        item -> {
                            assert item.findElement(By.className("inventory_item_name "))
                                            .isDisplayed()
                                    && item.findElement(By.className("inventory_item_desc "))
                                            .isDisplayed()
                                    && item.findElement(By.className("inventory_item_price "))
                                            .isDisplayed();
                        });
    }

    public void sortProductBy(String sortName) {
        WebElement selectElement = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(sortName);
    }

    public List<String> getListProductName() {
        List<String> listProductName = new ArrayList<>();
        driver.findElements(By.cssSelector(".inventory_item_name"))
                .forEach(item -> listProductName.add(item.getText()));
        return listProductName;
    }

    public List<Double> getListProductPrice() {
        List<Double> listProductPrice = new ArrayList<>();
        driver.findElements(By.cssSelector(".inventory_item_price"))
                .forEach(
                        item ->
                                listProductPrice.add(
                                        Double.parseDouble(item.getText().replace("$", ""))));
        return listProductPrice;
    }

    public void clickViewDetailProduct(String productName) {
        click(By.xpath(String.format("//a[./div[text()='%s']]", productName)));
    }

    public boolean isDisplayProduct(String productName) {
        return isElementExist(
                By.xpath(
                        String.format(
                                "//div[@class='inventory_details_name large_size' and text()='%s']",
                                productName)));
    }

    public void addProductToCart(String productName) {
        click(
                By.xpath(
                        String.format(
                                "//div[./a/div[text()='%s']]/following-sibling::div/button[text()='Add to cart']",
                                productName)));
    }

    public void openMyCart() {
        click(iconCart);
        waitForVisibilityText("Your Cart");
    }
}
