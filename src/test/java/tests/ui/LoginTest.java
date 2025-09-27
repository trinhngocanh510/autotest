package tests.ui;

import common.ConfigLoader;

import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.login.LoginPage;

import tests.ui.base.BaseUiTest;

@Epic("Authentication")
@Feature("Login")
@Story("Valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("tna")
@Test(groups = {"ui"})
public class LoginTest extends BaseUiTest {
    @Test(groups = {"login"})
    @Description("User đăng nhập thành công bằng tài khoản hợp lệ")
    public void testLoginValidAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessfully());
    }

    @Description("User đăng nhập không thành công bằng tài khoản sai tên đăng nhập")
    public void testLoginInvalidUsernameAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "standard_users";
        String password = "secret_sauce";
        loginPage.login(username, password);

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Description("User đăng nhập không thành công bằng tài khoản sai tên mật khẩu")
    public void testLoginInvalidPasswordAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "standard_user";
        String password = "secret_sauced";
        loginPage.login(username, password);

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Description("User đăng nhập không thành công với tên đăng nhập bỏ trống")
    public void testLoginEmptyUsernameAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "";
        String password = "secret_sauce";
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Description("User đăng nhập không thành công với mật khẩu bỏ trống")
    public void testLoginEmptyPasswordAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "standard_user";
        String password = "";
        loginPage.login(username, password);

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Description("User đăng nhập không thành công với tài khoản bị khóa")
    public void testLoginLockedAccount() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl(ConfigLoader.get("base.url"));

        String username = "locked_out_user";
        String password = "secret_sauce";
        loginPage.login(username, password);

        Assert.assertEquals(
                loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
