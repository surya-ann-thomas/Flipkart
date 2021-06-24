package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.OrderPlace;
import pages.homePage;
import pages.productPage;
import testBase.Base;

public class productTest extends Base{

	public productTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
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
		product=home.productSearchAndClick("samsung mobile");
	}
	
@Test(priority=1)
	public void verifyPrdoduct() throws IOException, InterruptedException {
	Thread.sleep(3000);
	product.nextWindow();
	String title=product.productVerify();
	Assert.assertEquals(title,"SAMSUNG Galaxy F12 ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com","titles do not match");

	}


@Test(priority=2)
public void addToCartTest() throws IOException {
	order=product.addToCart();
}



@AfterTest
public void end() {
	driver.quit();
}

}
