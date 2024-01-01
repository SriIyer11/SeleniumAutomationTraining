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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9ReturningUser 
{
	static String scarttext="";

	public static void shopCartText(WebDriver driver)
	{
        WebElement scart = driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));
		
		scarttext = scart.getText();
		
		System.out.println(scarttext);
		
		//System.out.println(scart.getAttribute("value"));
	}
	
	
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
		
		WebElement Sortby=driver.findElement(By.id("products-orderby"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: Low to High");
		
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
	//	driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='overview']//input[@value='Add to cart']")).click();
		
		WebDriverWait expwait = new WebDriverWait(driver,2000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='cart-qty' and text()='(1)']")));
		
		shopCartText(driver);
		
		Assert.assertTrue("Shopping cart\n(1)".equals(scarttext));
		
		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		
		Assert.assertTrue((driver.findElement(By.cssSelector("div.order-summary-content")).getText()).equals("Your Shopping Cart is empty!"));
		
		shopCartText(driver);
		
		Assert.assertTrue("Shopping cart\n(0)".equals(scarttext));
		
		System.out.println(driver.findElement(By.cssSelector("div.order-summary-content")).getText());
		
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
