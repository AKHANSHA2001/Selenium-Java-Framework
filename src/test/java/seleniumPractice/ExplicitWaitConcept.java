package seleniumPractice;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitConcept {

	public static void main(String[] args) {


		WebDriver driver;
		 String projectPath = System.getProperty("user.dir");
	        String driverPath = projectPath + File.separator + "src" + File.separator + "test" + 
	                           File.separator + "java" + File.separator + "resources" + 
	                           File.separator + "driver" + File.separator + "chromedriver.exe";

	        System.setProperty("webdriver.chrome.driver", driverPath);

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        driver = new ChromeDriver(options);

		 driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.facebook.com");
		
		clickOn(driver, driver.findElement(By.xpath("//*[@id='u_0_2']")), 20);//login button
		
		clickOn(driver, driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a")), 10); //create a page link
		
		
	}
	
	
	
	public static void clickOn(WebDriver driver, WebElement locator, int i) {
	    // Change 'i' to 'Duration.ofSeconds(i)'
	    new WebDriverWait(driver, Duration.ofSeconds(i))
	        .ignoring(StaleElementReferenceException.class)
	        .until(ExpectedConditions.elementToBeClickable(locator));
	    locator.click();
	}

}
