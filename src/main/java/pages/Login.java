package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class Login extends Base{
	


	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	    WebElement username;
	 
	 @FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	    WebElement password;
	 
	 
	 @FindBy(xpath="(//span[text()='Login'])[2]")
	    WebElement signin_click;
	 

	 public Login() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	 
	 public String before_login() {
		 return driver.getTitle();
	 }
	 public homePage login(String uname,String pass) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pass);
		signin_click.click();
		return new homePage();
	 }
	 

}
