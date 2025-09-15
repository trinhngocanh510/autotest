package pages.cart;

import org.openqa.selenium.By;

import pages.BasePage;

public class CartPage extends BasePage {

    public boolean isProductAddedToCart(String productName) {
        return isElementExist(
                By.xpath(
                        String.format(
                                "//a[./div[text()='%s']]/following-sibling::div/button[text()='Remove']",
                                productName)));
    }

    public void removeProduct(String productName) {
        click(
                By.xpath(
                        String.format(
                                "//a[./div[text()='%s']]/following-sibling::div/button[text()='Remove']",
                                productName)));
    }
}
