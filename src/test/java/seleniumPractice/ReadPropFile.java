package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        
        // Use relative pathing so it works on any computer
        String projectPath = System.getProperty("user.dir");
        FileInputStream ip = new FileInputStream(projectPath + "/src/seleniumPractice/config.properties");
        prop.load(ip);

        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("URL");

        // Logic to switch browsers
        if (browserName.equalsIgnoreCase("chrome")) {
            // Recommendation: Use WebDriverManager or ensure driverPath is correct
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("FF")) {
            driver = new FirefoxDriver();
        }

        driver.get(url);
        
        // Using properties for locators
        driver.findElement(By.xpath(prop.getProperty("firstname_xpath")))
              .sendKeys(prop.getProperty("firstName"));
    }
}
