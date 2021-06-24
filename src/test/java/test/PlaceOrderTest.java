package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.OrderPlace;
import pages.PaymentPage;
import pages.homePage;
import pages.productPage;
import testBase.Base;

public class PlaceOrderTest extends Base{

	public PlaceOrderTest() throws IOException {
		super();
		
	}
	Login login_;
	homePage home;
	productPage product;
	OrderPlace order;
	PaymentPage payment;
	@BeforeTest
	public void before() throws IOException, InterruptedException {
		start();
		login_=new Login();
		
		Thread.sleep(4000);
		home=login_.login(prop.getProperty("username"), prop.getProperty("password"));
		product=home.productSearchAndClick("samsung mobile");
		product.nextWindow();
		order=product.addToCart();
		
	}
	@Test(priority=1)
	public void verifyProductInCart() throws InterruptedException {
		String cart_verify=order.verifyCart();
			Assert.assertEquals(cart_verify, "Shopping Cart | Flipkart.com","not added to cart");
			
	}
	@Test(priority=2)	
	public void orderTest() throws InterruptedException, IOException {
		order.placeOrder();
	}
	
	@AfterTest
	public void end() {
		driver.quit();
	}
}
