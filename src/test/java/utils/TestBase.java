package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LandingPage;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = testCondition ? value1 : value2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
				 ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
				//ChromeOptions options = new ChromeOptions();
				//options.addArguments("--remote-allow-origins=*");
				//options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);// driver gets the life
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","//Users//rahulshetty//Downloads//geckodriver 5");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		}
		
		return driver;
		
	}
	
	
	
}

