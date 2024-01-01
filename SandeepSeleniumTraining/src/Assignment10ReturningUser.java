import java.math.BigDecimal;
import java.text.DecimalFormat;
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

public class Assignment10ReturningUser 
{

	public static void main(String[] args) throws InterruptedException
	{
		Logger log = Logger.getLogger("devpinoyLogger");
		final DecimalFormat decfor = new DecimalFormat("0.00");
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
		
		driver.findElement(By.xpath("(//a[@href='/gift-cards'])[3]")).click();
		
		WebElement Sortby=driver.findElement(By.id("products-orderby"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: High to Low");
		
		String itemprice = driver.findElement(By.xpath("(//span[@class='price actual-price'])[1]")).getText();
		System.out.println(itemprice);
		BigDecimal bid = new BigDecimal(itemprice);
		System.out.println(bid);
		
		double itemprice_double = Double.valueOf(itemprice);
		System.out.println(itemprice_double);
		float floatprice = Float.valueOf(itemprice);
		System.out.println(floatprice);
		
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
		String cartvalue = driver.findElement(By.xpath("//span[@class='price-value-4']")).getText();
		double CartInt = Double.valueOf(cartvalue); // if need to convert string to double
	
		Assert.assertEquals(itemprice, cartvalue); // Verify actual item price matches with the expected item price
				
		Thread.sleep(1000);
		
		WebElement searchBox3= driver.findElement(By.id("giftcard_4_RecipientName"));
		searchBox3.clear();
		searchBox3.sendKeys("RAM");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
		
		driver.findElement(By.xpath("(//a[@href='/electronics'])[3]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='/cell-phones'])[5]")).click();
		
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]")).click();
		
		WebElement scart = driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));
		
		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		WebElement searchBox4= driver.findElement(By.id("addtocart_4_EnteredQuantity"));
		searchBox4.clear();
		searchBox4.sendKeys("2");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		driver.findElement(By.xpath("//a[@class='ico-cart']/child::span[@class='cart-label']")).click();
		
	//	double finalitmexpvalue = itemprice_double*2.00;
		BigDecimal b2 = new BigDecimal("3");             // Now we have 3 items in cart, so hard-coded 3 
		bid = bid.multiply(b2);		
		System.out.println(bid);
		
	/*	float expvalue = floatprice*2;
		finalitmexpvalue= Float.valueOf(decfor.format(finalitmexpvalue));
		System.out.println(expvalue); */
		
		System.out.println(driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText());
		Assert.assertTrue((driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText()).equals(String.valueOf(bid))); 
		
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

	}

}
