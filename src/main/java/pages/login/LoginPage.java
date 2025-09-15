package pages.login;

import org.json.JSONObject;
import org.openqa.selenium.By;

import pages.BasePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void loginSuccessful(String username) {
        String content;

		try {
            content = new String(Files.readAllBytes(Paths.get("src/test/resources/users.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

		JSONObject users = new JSONObject(content);
        String password = users.getJSONObject("validUser").getString("password");

		login(username, password);
        waitForVisibility(iconCart);
    }

    public String getErrorMessage() {
        return getText(fieldErrorMessage);
    }

    public boolean isLoginSuccessfully() {
        return !driver.findElements(iconCart).isEmpty();
    }
}
