package seleniumPractice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

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
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);//switch to frame if its present
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
		.release()
		.build()
		.perform();
		
	}

}
