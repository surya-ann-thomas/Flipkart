package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	FileInputStream input;
	//Logger log;
	public Base() throws IOException {
		 prop = new Properties();
			File file = new File("D:\\selenium_training\\pageObjectModel\\src\\main\\java\\testData\\data.properties");
			input = new FileInputStream(file);
			prop.load(input);
		
	}
		public static void start() {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		
			
		}
		
		public WebDriver getDriver() {
			return driver;
		}
		
	}


