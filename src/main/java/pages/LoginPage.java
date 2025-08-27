package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  private WebDriver driver;
  private By usernameField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");
  private By cartIcon = By.id("shopping_cart_container");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void login(String username, String password) {
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
  }

  public boolean isLoginSuccessful() {
    return !driver.findElements(cartIcon).isEmpty();
  }
}
