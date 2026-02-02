package seleniumPractice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeLocators {
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

	    @Test(description = "Verify Locators Used correctly")
	    public void verifyAmazonLogo() {
	        driver.get("https://demoqa.com/");

	        // Defining an Explicit Wait (up to 10 seconds)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement elementsHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        	    By.xpath("//div[@class='card-body']//h5[text()='Elements']")
	        	));

	        	System.out.println("Found text: " + elementsHeading.getText());
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
