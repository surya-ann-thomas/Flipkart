package test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.ExcelUtility;

import pages.Login;

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
	
	PaymentPage payment;
	@BeforeMethod
	public void before() throws IOException, InterruptedException {
		start();
		login_=new Login();
		
		Thread.sleep(4000);
		Map<String,String> data=ExcelUtility.getMap();
	     home=login_.login(data.get("username"), data.get("password"));
		//home=login_.login(prop.getProperty("username"), prop.getProperty("password"));
		product=home.productSearchAndClick("samsung mobile");
		product.nextWindow();
		payment=product.addToCart();
		//payment=order.placeOrder();
	}
	
	
	@Test(priority=1)
	public void verifyPaymentPageTitle() throws InterruptedException {
		String Pagetitle=payment.paymentPageVerification();
		
		Assert.assertEquals(Pagetitle, "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order","not expected page");
	}
	
	@Test(priority=2)
	public void selectCreditCardAndEnter() throws InterruptedException {
	payment.creditCardPage();	
	
	String text=payment.invalidCardNumber();
	Assert.assertEquals(text, "Not a valid card number","card number is valid");
	}
	
	@AfterMethod
	public void end() {
	driver.quit();	
	}
	
}
