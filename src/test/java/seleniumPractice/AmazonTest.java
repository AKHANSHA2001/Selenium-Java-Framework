package seleniumPractice;

import org.openqa.selenium.By; // Added missing import
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions; // For Explicit Wait
import org.openqa.selenium.support.ui.WebDriverWait; // For Explicit Wait
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class AmazonTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        String driverPath = projectPath + File.separator + "src" + File.separator + "test" + 
                           File.separator + "java" + File.separator + "resources" + 
                           File.separator + "driver" + File.separator + "chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test(description = "Verify Amazon logo is displayed correctly")
    public void verifyAmazonLogo() {
        driver.get("https://www.amazon.com/");

        // Defining an Explicit Wait (up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting until the logo is visible before interacting
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));

        // Validation: Is it displayed?
        boolean isLogoDisplayed = logo.isDisplayed();
        System.out.println("Is Amazon Logo Displayed? " + isLogoDisplayed);

        Assert.assertTrue(isLogoDisplayed, "Failure: Amazon logo was not visible on the page!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                // Short pause to see the result before closing (for debugging)
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
                
            }
            driver.quit();
            System.out.println("Test complete: Browser closed");
        }
    }
}