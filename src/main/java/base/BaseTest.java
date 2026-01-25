package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("=== Launching Chrome ===");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // ✅ prevents Chrome renderer timeout

        // Use only one PageLoadStrategy for stability
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);

        // Implicit wait for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        // Retry navigation in case of timeout
        int retries = 2;
        while (retries > 0) {
            try {
                System.out.println("Navigating to login page...");
                driver.get("https://practicetestautomation.com/practice-test-login/");
                System.out.println("✅ Page loaded successfully.");
                break;
            } catch (Exception e) {
                retries--;
                System.out.println("⚠️ Navigation failed, retries left: " + retries);
                if (retries == 0) {
                    System.out.println("❌ Failed to load login page after retries.");
                    e.printStackTrace();
                }
            }
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("❌ Test Failed: " + result.getName());
            System.out.println("Reason: " + result.getThrowable());
            takeScreenshot(result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("✅ Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("⚠️ Test Skipped: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    private void takeScreenshot(String testName) {
        try {
            if (driver != null) {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File(System.getProperty("user.dir") + "/screenshots/" + testName + ".png");
                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath());
                System.out.println("📸 Screenshot saved -> " + dest.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to save screenshot for " + testName);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("⚠️ Screenshot skipped due to driver issue.");
        }
    }
}
