package pages;

import utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil waitUtil;

    // ✅ Correct locators for Practice Test Automation
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("submit");          // 🔥 FIXED
    private By successMsg = By.cssSelector(".post-title"); // Logged In Successfully
    private By errorMsg = By.id("error");            // Error message box

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public void enterUsername(String user) {
        waitUtil.waitForVisibility(username, 20).clear();
        waitUtil.waitForVisibility(username, 20).sendKeys(user);
    }

    public void enterPassword(String pass) {
        waitUtil.waitForVisibility(password, 20).clear();
        waitUtil.waitForVisibility(password, 20).sendKeys(pass);
    }

    public void clickLogin() {
        waitUtil.waitForClickable(loginBtn, 15).click();
    }

    // 🔒 Intelligent validation (UNCHANGED)
    public boolean isLoginSuccessful() {
        try {
            return waitUtil.waitForVisibility(successMsg, 10).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔒 Intelligent validation (UNCHANGED)
    public boolean isLoginFailed() {
        try {
            return waitUtil.waitForVisibility(errorMsg, 10).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
