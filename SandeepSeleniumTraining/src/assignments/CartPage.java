package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends BaseClass
{

	By billingadd = By.xpath("//input[@onclick='Billing.save()']");
	
//	By shipadd = By.xpath("//input[@onclick='Shipping.save()']");
	
	By shipadd = By.xpath("(//input[@value='Continue'])[2]");
	
	By shipmethod = By.xpath("//input[@onclick='ShippingMethod.save()']");
	
	By pmtmethod = By.xpath("//input[@onclick='PaymentMethod.save()']");
	
	By pmtinfo = By.xpath("//input[@onclick='PaymentInfo.save()']");
	
	By cnforder = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	
	By logout = By.xpath("//a[text()='Log out']");	
	
	public void fill_CartDetails()
	{
		driver.findElement(billingadd).click();		

		WebDriverWait expwait = new WebDriverWait(driver,2); // This is for explicit wait
	//	expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tab-section allow active' and @id='opc-shipping']"))); 
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='shipping-address-select']")));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")));
		
	//	driver.findElement(shipadd).click();
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")));
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='shippingoption_0']")));
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")));
	
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='paymentmethod_0']")));
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")));
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='You will pay by COD']")));
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")));
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='order-review-data']")));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")));
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")));
		
		expwait = new WebDriverWait(driver,5); 
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Your order has been successfully processed!']")));
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).getText().equals("Your order has been successfully processed!"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Click here for order details.\"]")).isDisplayed());
		
		driver.findElement(logout).click();
		
		driver.close();
		
	}
	
	public static void main(String[] args) 
	{
		
	
	}

}
