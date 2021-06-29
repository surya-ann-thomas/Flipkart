package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class PaymentPage extends Base{
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement order_continue;
	@FindBy(xpath="//div[text()='Credit / Debit / ATM Card' and @class='_2nxZhC']")
	WebElement creditcard;
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement cardnumber;
	@FindBy(xpath="//button[contains(text(),'PAY')]")
	WebElement continue_click;
	@FindBy(xpath="//span[text()='Not a valid card number']")
	WebElement invalid;
	@FindBy(xpath="//button[text()='Accept & Continue']")
	WebElement accept;
	public PaymentPage() throws IOException  {
		PageFactory.initElements(driver, this);
		
	}
	
	public String paymentPageVerification() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}

	public void creditCardPage() throws InterruptedException {
		order_continue.click();
		//accept.click();
		Thread.sleep(5000);
		creditcard.click();
		cardnumber.sendKeys("123456");
		continue_click.click();
		
	}
	
	public String invalidCardNumber() {
		String invalidMessage="";
		if(driver.findElements(By.xpath("//span[text()='Not a valid card number']")).size()>0) {
			System.out.println("error message found");
			invalidMessage=invalid.getText();
			
		}
		else {
			System.out.println("error message not displayed");
		}
		return invalidMessage;
		
	}
}
