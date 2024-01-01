package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactoryTest extends BaseClass { 
	
	
	public static void main(String[] args) 
	{
		BaseClass base = new BaseClass();
		base.initialize();
		LoginPage_PageFactory login = new LoginPage_PageFactory();
		login.login_HomePage("dummyperson508@gmail.com", "Abc@1234");
	    base.teardown();		
	}

}
