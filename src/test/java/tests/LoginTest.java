package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    public void validLoginTest() {
        System.out.println("Starting valid login test...");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        if (loginPage.isLoginSuccessful()) {
            System.out.println("Login successful ✅");
        } else {
            System.out.println("Login failed ❌");
        }

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed even with valid credentials"
        );
    }

    @Test(description = "Verify error message for invalid username")
    public void invalidUsernameTest() {
        System.out.println("Starting invalid username test...");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        if (loginPage.isLoginFailed()) {
            System.out.println("Invalid username error displayed ✅");
        } else {
            System.out.println("Invalid username error NOT displayed ❌");
        }

        Assert.assertTrue(
                loginPage.isLoginFailed(),
                "Error message not displayed for invalid username"
        );
    }

    @Test(description = "Verify error message for invalid password")
    public void invalidPasswordTest() {
        System.out.println("Starting invalid password test...");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("student");
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickLogin();

        if (loginPage.isLoginFailed()) {
            System.out.println("Invalid password error displayed ✅");
        } else {
            System.out.println("Invalid password error NOT displayed ❌");
        }

        Assert.assertTrue(
                loginPage.isLoginFailed(),
                "Error message not displayed for invalid password"
        );
    }
}
