package tests.ui;

import common.ConfigLoader;

import core.extension.DriverLifecycleExtension;

import io.qameta.allure.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import pages.login.LoginPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("Authentication")
@Feature("Login")
@Story("Valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("tna")
@ExtendWith(DriverLifecycleExtension.class)
public class LoginTest {
    @Test
    @Tag("ui")
    @Description("User có thể đăng nhập bằng tài khoản hợp lệ")
    public void testValidLogin() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/users.json")));
        JSONObject users = new JSONObject(content);

        String username = users.getJSONObject("validUser").getString("username");
        String password = users.getJSONObject("validUser").getString("password");

        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));
        loginPage.login(username, password);

        Assertions.assertTrue(loginPage.isLoginSuccessfully());
    }
}
