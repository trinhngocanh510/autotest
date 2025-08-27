package tests.ui;

import tests.ui.base.BaseTest;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginTest extends BaseTest {
  @Test
  public void testValidLogin() throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("src/test/resources/users.json")));
    JSONObject users = new JSONObject(content);

    String username = users.getJSONObject("validUser").getString("username");
    String password = users.getJSONObject("validUser").getString("password");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    Assertions.assertTrue(loginPage.isLoginSuccessful());
  }
}
