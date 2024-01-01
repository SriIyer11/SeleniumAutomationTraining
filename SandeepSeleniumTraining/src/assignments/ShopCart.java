package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopCart extends BaseClass{
	
	By country = By.id("CountryId");
		
	By estship = By.xpath("//input[@class='button-2 estimate-shipping-button']");
	
	By tos = By.id("termsofservice");
	
	By chkout = By.id("checkout");
	
public CartPage Check_Out()
{
	
	Select Sortbydrp = new Select(driver.findElement(country));	
	Sortbydrp.selectByVisibleText("India");
	
	driver.findElement(estship).click();
	driver.findElement(tos).click();
	driver.findElement(chkout).click();
	
	return new CartPage();
	
}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
