package seleniumPractice;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTableHandle {

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

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.freecrm.com/"); // enter URL
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a		
		//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
		
		
		//Method-1:
		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		
		for(int i=4; i<=7; i++){
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains("test2 test2")){ //i=6
				//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
			}
		}
		
		//Method-2:
		driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'ui uiii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();

		
		
		
		
		
		
		
		
		
	}

}
