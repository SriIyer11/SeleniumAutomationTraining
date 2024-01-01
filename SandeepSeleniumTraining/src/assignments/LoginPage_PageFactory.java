package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory extends BaseClass { 

	
	 @FindBy(how=How.ID, using="Email")
	 WebElement loginuser;	 	 
	 
	 @FindBy(id="Password")
	 WebElement passwd;
	 
	 @FindBy(xpath="//input[@class='button-1 login-button']")
	 WebElement loginBtn;
	 

	 public LoginPage_PageFactory()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	public HomePage login_HomePage(String UserName, String Pwd)
	{
		loginuser.sendKeys(UserName);
		passwd.sendKeys(Pwd);
		loginBtn.click();
		System.out.println(driver.getTitle());
		
		return new HomePage();
		
	}

	public static void main(String[] args) 
	{
		BaseClass base = new BaseClass();
		base.initialize();
		LoginPage_PageFactory login = new LoginPage_PageFactory();
		login.login_HomePage("dummyperson508@gmail.com", "Abc@1234");
	//	base.teardown();
		
	}

}
