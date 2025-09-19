package tests.ui;

import io.qameta.allure.*;

@Epic("Authentication")
@Feature("Login")
@Story("Valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("tna")
//@ExtendWith(DriverLifecycleExtension.class)
public class LoginTest {
//    @Test
//    @Tag("ui")
//    @Description("User có thể đăng nhập bằng tài khoản hợp lệ")
//    public void testValidLogin() throws IOException {
//        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/data/users.json")));
//        JSONObject users = new JSONObject(content);
//
//        String username = users.getJSONObject("validUser").getString("username");
//        String password = users.getJSONObject("validUser").getString("password");
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.openUrl(ConfigLoader.get("base.url"));
//        loginPage.login(username, password);
//
//        Assertions.assertTrue(loginPage.isLoginSuccessfully());
//    }
}
