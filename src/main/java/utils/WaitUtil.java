package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Wait for visibility with default timeout
    public WebElement waitForVisibility(By locator) {
        return waitForVisibility(locator, 20); // default 20 sec
    }

    // Wait for visibility with custom timeout
    public WebElement waitForVisibility(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.ignoring(StaleElementReferenceException.class); // ✅ prevents stale element crash
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for clickable with default timeout
    public WebElement waitForClickable(By locator) {
        return waitForClickable(locator, 15); // default 15 sec
    }

    // Wait for clickable with custom timeout
    public WebElement waitForClickable(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.ignoring(StaleElementReferenceException.class); // ✅ prevents stale element crash
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Safe wait: returns null instead of throwing TimeoutException
    public WebElement waitForVisibilitySafe(By locator, int timeoutSeconds) {
        try {
            return waitForVisibility(locator, timeoutSeconds);
        } catch (Exception e) {
            System.out.println("⚠️ Element not found: " + locator);
            return null;
        }
    }

    public WebElement waitForClickableSafe(By locator, int timeoutSeconds) {
        try {
            return waitForClickable(locator, timeoutSeconds);
        } catch (Exception e) {
            System.out.println("⚠️ Element not clickable: " + locator);
            return null;
        }
    }
}
