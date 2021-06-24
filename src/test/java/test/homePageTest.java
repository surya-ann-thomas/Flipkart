package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.OrderPlace;
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
	OrderPlace order;
	@BeforeTest
	public void before() throws IOException, InterruptedException {
		start();
		login_=new Login();
		
		Thread.sleep(4000);
		home=login_.login(prop.getProperty("username"), prop.getProperty("password"));
	}
@Test(priority=1)
	public void loginVerifyTest() {
	Assert.assertTrue(home.verifyLogin(), "not logged in");
}
@Test(priority=2)
public void enterProductName() throws InterruptedException, IOException {
	product=home.productSearchAndClick("samsung mobile");
}
@AfterTest
public void end() {
	driver.quit();
}
}
