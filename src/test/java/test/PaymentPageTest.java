package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Login;
import pages.OrderPlace;
import pages.PaymentPage;
import pages.homePage;
import pages.productPage;
import testBase.Base;

public class PaymentPageTest extends Base {

	public PaymentPageTest() throws IOException {
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
		payment=order.placeOrder();
	}
	
	
	@Test(priority=1)
	public void verifyPaymentPageTitle() {
		String title=payment.paymentPageVerification();
		Assert.assertEquals(title, "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order","not expected page");
	}
	
	@Test(priority=2)
	public void selectCreditCardAndEnter() throws InterruptedException {
	payment.creditCardPage();	
	}
	
	@Test(priority=3)
	public void cardNumberValidation() {
	String text=payment.invalidCardNumber();
	Assert.assertEquals(text, "Not a valid card number","card number is valid");
	}
	
	@AfterTest
	public void end() {
	driver.quit();	
	}
	
}
