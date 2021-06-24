package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.util.ExcelUtility;

import pages.Login;
import pages.homePage;
import testBase.Base;

public class LoginTest extends Base{
	Login login_;
	homePage home;
	FileInputStream fis;
	Logger log=Logger.getLogger(LoginTest.class);
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
public void before() throws InterruptedException, IOException {
		start();
		log.info("Logging into flipkart");
		login_=new Login();
		
		Thread.sleep(4000);
}
	
	@Test(priority=2) 
	public void loginTest() throws IOException, InterruptedException {

			Map<String,String> data=ExcelUtility.getMap();

	     home=login_.login(data.get("username"), data.get("password"));
		//home=login_.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void titleTest() {
		String title=login_.before_login();
		
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","login page not visible");
	}
	
	@AfterTest
	public void end() {
	driver.quit();	
	}
	 
}
