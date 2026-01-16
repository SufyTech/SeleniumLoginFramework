package pages;
import utils.WaitUtil;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    WaitUtil waitUtil;
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By successMsg = By.cssSelector(  ".flash.success");
    By errorMsg = By.cssSelector(".flash.error");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }
    public void enterUsername(String user){
        waitUtil.waitForVisibilty(username).sendKeys(user);
    }

    public void enterPassword(String pass){
        waitUtil.waitForVisibilty(password).sendKeys(pass);
    }

    public void clickLogin(){
        waitUtil.waitForClickable(loginBtn).click();
    }

    public void verifyLoginSuccess(){
        Assert.assertTrue(
                waitUtil.waitForVisibilty(successMsg).isDisplayed(),
                "Login Success"
        );
    }

    public void verifyLoginFailure(){
        Assert.assertTrue(
                waitUtil.waitForVisibilty(errorMsg).isDisplayed(),
                "Error message not shown"
        );
    }

}