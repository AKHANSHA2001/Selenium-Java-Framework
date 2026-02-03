package seleniumPractice;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {

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
		
		//WebDriver driver = new ChromeDriver(); //launch chrome
		
		//htmlunitdriver is not available in Selenium 3.x version.
		//htmlunitdriver -- to use this concept, we have to download htmlunitdriver JAR file.
		
		//advantages:
		//1. testing is happening behind the scene -- no browser is launched
		//2. Very fast -- execution of test cases -- very fast -- performance of the script
		//3. not suitable for Actions class -- user actions -- mousemovement, doubleClick, drag and drop
		//4. Ghost Driver -- HeadLess Browser: 
			//--HtmlUnit Driver -- JAva
			//--PhantomJS -- JavaScript
		
		
		
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.freecrm.com");
		
		System.out.println("Before login, title is:==="+ driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("after login, title is:==="+ driver.getTitle());
		
		
		
		
		
		
		
	}

}
