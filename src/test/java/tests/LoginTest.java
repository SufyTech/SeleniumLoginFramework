package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        loginPage.verifyLoginSuccess();

    }

    @Test
    public void invalidLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        loginPage.verifyLoginFailure();
    }
}
