package tests.ui;

import common.ConfigLoader;

import io.qameta.allure.*;

import org.testng.annotations.Test;

import pages.checkout.CheckoutPage;
import pages.inventory.InventoryPage;
import pages.login.LoginPage;

import tests.ui.base.BaseUiTest;

@Epic("Authentication")
@Feature("Login")
@Story("Valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("tna")
@Test(groups = {"ui"})
public class CheckoutTest extends BaseUiTest {
    @Test(groups = {"checkout"})
    @Description("User thêm sản phẩm vào giỏ hàng và thanh toán thành công")
    public void testAddItemToCartAndCheckout() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        loginPage.openUrl(ConfigLoader.get("base.url"));
        String username = "standard_user";

        loginPage.loginSuccessful(username);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.openMyCart();
        inventoryPage.clickButtonByName("Checkout");
        checkoutPage.enterFirstName("Trinh");
        checkoutPage.enterLastName("Anh");
        checkoutPage.enterZipCode("100000");
        checkoutPage.clickButtonByName("Continue");
        checkoutPage.clickButtonByName("Finish");
        checkoutPage.waitForVisibilityText("Thank you for your order!");
    }
}
