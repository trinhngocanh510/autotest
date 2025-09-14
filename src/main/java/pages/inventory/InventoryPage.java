package pages.inventory;

import org.openqa.selenium.By;

import pages.BasePage;

public class InventoryPage extends BasePage {

    public boolean isDisplayListOfProduct() {
        return isElementExist(By.id("inventory_item"));
    }

    public void verifyEachProductHaveNameDescriptionAndPrice() {
        driver.findElements(By.id("inventory_item"))
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

    }
}
