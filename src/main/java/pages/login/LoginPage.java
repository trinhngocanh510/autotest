package pages.login;

import org.openqa.selenium.By;
import pages.BasePage;

public class LoginPage extends BasePage {
    private By inpUsername = By.id("user-name");
    private By inpPassword = By.id("password");
    private By btnLogin = By.id("login-button");
    private By iconCart = By.id("shopping_cart_container");
    private By fieldErrorMessage = By.cssSelector("h3[data-test='error']");

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        type(inpUsername, username);
        type(inpPassword, password);

        click(btnLogin);
    }

    public String getErrorMessage() {
        return getText(fieldErrorMessage);
    }

    public boolean isLoginSuccessful() {
        return !driver.findElements(iconCart).isEmpty();
    }
}
