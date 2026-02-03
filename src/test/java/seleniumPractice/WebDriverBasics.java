package seleniumPractice;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		
		//1. FF browser:
		//geckodriver
			// C:\\downloads\\geckodriver.exe -- windows 
	//	System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Downloads/geckodriver");	
	  //  WebDriver driver = new FirefoxDriver(); //launch FF
		
	    
	    //2. chrome browser:
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
		driver.get("http://www.google.com");	//enter url
		
		String title = driver.getTitle(); //get title
		
		System.out.println(title);
		
		//validation point:
		if(title.equals("Google")){
			System.out.println("correct title");
		}
		else{
			System.out.println("in-correct title");
		}
	   
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.quit(); //quit the browser
		
		
	}

}
