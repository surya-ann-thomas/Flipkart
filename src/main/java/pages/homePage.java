package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class homePage extends Base{
	@FindBy(xpath="//div[text()='Surya']")
    WebElement name;
	
	@FindBy(xpath="//input[@type='text']")
	    WebElement productName;
	 @FindBy(xpath="//button[@type='submit']")
	    WebElement search_click;
	// @FindBy(xpath="//div[contains(text(),'SAMSUNG Galaxy M12 (Black, 64 GB)')]")
	 @FindBy(xpath="//div[contains(text(),'SAMSUNG Galaxy F12 (Sky Blue, 64 GB)')]")
	    WebElement product_click;
	 @FindBy(xpath="//button[@type='button']")
	    WebElement buy;
	 
	 public homePage() throws IOException {
		 PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
	 
	 public boolean verifyLogin() {
		return name.isDisplayed();
		 
	 }
	 
	 public productPage productSearchAndClick(String product) throws InterruptedException, IOException {
		 Thread.sleep(3000);
		
		productName.sendKeys(product);
		 search_click.click();
		 product_click.click();
		 return new productPage();
	 }

}
