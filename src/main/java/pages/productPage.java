package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import testBase.Base;

public class productPage extends Base{

	
	
	@FindBy(xpath="//button[@type='button']")
	WebElement buybutton;
	
	 public productPage() throws IOException {
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
	 
public void nextWindow() {
		String MainWindow=driver.getWindowHandle();		
    Set<String> s1=driver.getWindowHandles();		
    Iterator<String> i1=s1.iterator();		
    		
    while(i1.hasNext())			
    {		
        String ChildWindow=i1.next();		
        		
        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        {    		
             
                
                driver.switchTo().window(ChildWindow);	                                                                                                           
         
               
        }        
        		
        }		
}

public String productVerify() {
	return driver.getTitle();
	
}

public PaymentPage addToCart() throws IOException {
	buybutton.click();
	return new PaymentPage();
}

}
