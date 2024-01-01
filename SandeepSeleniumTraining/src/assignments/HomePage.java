package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass
{
	
	By apashoe = By.xpath("(//a[@href='/apparel-shoes'])[3]");
	
	public Apashoes click_Apashoes()
	{
		driver.findElement(apashoe).click();
		System.out.println(driver.getTitle());
		
		return new Apashoes();
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
