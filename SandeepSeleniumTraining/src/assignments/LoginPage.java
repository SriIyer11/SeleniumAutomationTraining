package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass { 
	
	By loginuser = By.id("Email");
	
	By loginpwd = By.id("Password");
			
	By loginbtn = By.xpath("//input[@class='button-1 login-button']");
	
	public HomePage login_HomePage(String UserName, String Pwd)
	{
		driver.findElement(loginuser).sendKeys(UserName);
		driver.findElement(loginpwd).sendKeys(Pwd);
		driver.findElement(loginbtn).click();
		System.out.println(driver.getTitle());
		
		return new HomePage();
		
	}

	public static void main(String[] args) 
	{
		BaseClass base = new BaseClass();
		base.initialize();
		LoginPage login = new LoginPage();
		login.login_HomePage("dummyperson508@gmail.com", "Abc@1234");
	//	base.teardown();
		
	}

}
