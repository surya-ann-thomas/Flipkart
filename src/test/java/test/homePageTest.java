package test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.ExcelUtility;

import pages.Login;

import pages.homePage;
import pages.productPage;
import testBase.Base;

public class homePageTest extends Base{

	public homePageTest() throws IOException {
		super();
		
	}
	
	
	Login login_;
	homePage home;
	productPage product;
	
	@BeforeMethod
	public void before() throws IOException, InterruptedException {
		start();
		login_=new Login();
		
		Thread.sleep(4000);
		Map<String,String> data=ExcelUtility.getMap();
	     home=login_.login(data.get("username"), data.get("password"));
		//home=login_.login(prop.getProperty("username"), prop.getProperty("password"));
	}
@Test(priority=1)
	public void loginVerifyTest() {
	Assert.assertTrue(home.verifyLogin(), "not logged in");
}
@Test(priority=2)
public void enterProductName() throws InterruptedException, IOException {
	product=home.productSearchAndClick("samsung mobile");
}
@AfterMethod
public void end() {
	driver.quit();
}
}
