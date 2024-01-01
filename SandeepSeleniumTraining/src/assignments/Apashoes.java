package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Apashoes extends BaseClass{  // Apashoes is classname
	
By drpdwn = By.id("products-orderby");
//By wrikshirt = By.xpath("(//a[@href='/mens-wrinkle-free-long-sleeve'])[2]");
//By addcart = By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]");
By handbag = By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]");

By nxtpage = By.xpath("//a[text()='Next']");
By casbelt_addcart = By.xpath("//a[text()='Casual Golf Belt']/ancestor::div[@class='details']/descendant::input");
// By shopcart = By.xpath("//li[@id='topcartlink']/a"); // shopcart is variable name

By shopcart = By.xpath("//span[@class='cart-label' and text()='Shopping cart']");
	
	public void SortBy_SelectValue(String drpname) // SortBy_SelectValue is method name
	{
		
		Select Sortbydrp = new Select(driver.findElement(drpdwn));
		Sortbydrp.selectByVisibleText("Name: Z to A");
		
	}
	
	public ShopCart ApparelShoesClick()  // here return type of method is ShopCart
	{
	//	driver.findElement(wrikshirt).click();
	//	driver.findElement(addcart).click();
		driver.findElement(handbag).click();
		
	//	driver.navigate().back(); // it will navigate to the previous page
				
		driver.findElement(nxtpage).click();
		
		driver.findElement(casbelt_addcart).click();	
		
		WebDriverWait expwait = new WebDriverWait(driver,4000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(shopcart)); // Asked to wait until the element is shown over UI
	//	Assert.assertEquals(driver.findElement(shopcart).getText(), "Shopping cart(2)");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl()); 
		
		driver.findElement(shopcart).click();
		
		return new ShopCart();
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



