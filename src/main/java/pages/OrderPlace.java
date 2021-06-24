package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class OrderPlace extends Base{

	@FindBy(xpath="//button/span[text()='Place Order']")
	WebElement order;
//	@FindBy(xpath="(//button[text()='Change'])[2]")
//	WebElement addressChange;
//	@FindBy(xpath="//button[text()='Deliver Here']")
//	WebElement addressContinue;

	
	 public OrderPlace() throws IOException  {
			PageFactory.initElements(driver, this);
			
		}
	 public String verifyCart() throws InterruptedException {
			Thread.sleep(3000);
			return driver.getTitle();
			
			
		}
	public PaymentPage placeOrder() throws InterruptedException, IOException {
		order.click();
		
		return new PaymentPage();
		
	}
	 
}
