import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment8ReturningUser 
{

	public static void main(String[] args) throws InterruptedException
	{
		Logger log = Logger.getLogger("devpinoyLogger");
		try {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		
		driver.get("https://demowebshop.tricentis.com/register");
		
		log.info("Website Launched");
		
		driver.manage().window().maximize();        // To maximize the browser window
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // This will wait for max 10 seconds for the entire page to get load
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // This will implicitly wait for 2 seconds before interacting with the next element in current page
		
	
		System.out.println(driver.getTitle());
		
		log.info(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		WebElement searchBox1= driver.findElement(By.id("Email"));
		searchBox1.sendKeys("dummyperson508@gmail.com");
						
		Thread.sleep(1000);	
		
		WebElement searchBox2= driver.findElement(By.id("Password"));
		searchBox2.sendKeys("Abc@1234");
		
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("(//a[@href='/electronics'])[3]")).click();
		
		driver.findElement(By.xpath("(//a[@href='/cell-phones'])[5]")).click();
		
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
	//	driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]")).click();
		
		WebElement searchBox3= driver.findElement(By.id("addtocart_80_EnteredQuantity"));
		searchBox3.clear();
		searchBox3.sendKeys("2");
		
		driver.findElement(By.id("add-to-cart-button-80")).click();
		
		Thread.sleep(2000);
		
		WebElement scart = driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));
		
		String scarttext = scart.getText();
		
		System.out.println(scarttext);
		
		System.out.println(scart.getAttribute("value"));
		
		Assert.assertTrue("Shopping cart\n(3)".equals(scarttext));
		
		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		WebElement searchBox4= driver.findElement(By.id("addtocart_80_EnteredQuantity"));
		searchBox4.clear();
		searchBox4.sendKeys("1");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		driver.findElement(By.xpath("//a[@class='ico-cart']/child::span[@class='cart-label']")).click();
		
		WebElement Sortby1=driver.findElement(By.id("CountryId"));
		Select Sortbydrp1 = new Select(Sortby1);		
		Sortbydrp1.selectByVisibleText("India");
		
		WebElement Sortby2=driver.findElement(By.id("StateProvinceId"));
		Sortby2.click();
		
		driver.findElement(By.xpath("//input[@class='button-2 estimate-shipping-button']")).click();
		
		driver.findElement(By.id("termsofservice")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		
		log.info("Billing Info Provided");
				
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		
		log.info("Shipping Address Provided");
		
		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
				
//		driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		
		log.info("Payment Info Provided");
		
		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Click here for order details.']")).click();
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();		
		
		driver.close();		// Will close only current window
		
		}
		
		catch(Exception e) 
		{
			log.error("Exception Caught:"+e.getMessage());
			log.error("Exception Stactrix:"+e.getStackTrace());
		}
		
		finally
		{
			System.out.println("In Finally Block");
		}
	
		
		/*		catch(Error e1)
		{
			
			log.error("Error Caught:"+e1.getMessage());
			log.error("Error Stactrix:"+e1.getStackTrace());
		}*/

	}

}
