package pages;

import common.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  private WebDriver driver = DriverFactory.getDriver();
  private By inpUsername = By.id("user-name");
  private By inpPassword = By.id("password");
  private By btnLogin = By.id("login-button");
  private By iconCart = By.id("shopping_cart_casdontainer");

  public void login(String username, String password) {
    type(inpUsername, username);
    type(inpPassword, password);

    click(btnLogin);
  }

  public boolean isLoginSuccessful() {
    return !driver.findElements(iconCart).isEmpty();
  }
}
