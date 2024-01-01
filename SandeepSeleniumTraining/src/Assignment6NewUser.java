import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6NewUser 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();        // To maximize the browser window
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // This will wait for max 10 seconds for the entire page to get load
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // This will implicitly wait for 2 seconds before interacting with the next element in current page
		
	
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		WebElement searchBox1= driver.findElement(By.id("Email"));
		searchBox1.sendKeys("dummyperson208@gmail.com");
						
		Thread.sleep(1000);	
		
		WebElement searchBox2= driver.findElement(By.id("Password"));
		searchBox2.sendKeys("Abc@1234");
		
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("(//a[@href='/books'])[3]")).click();
		
		WebElement Sortby=driver.findElement(By.id("products-orderby"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: Low to High");
		
		driver.findElement(By.xpath("(//a[@href='/fiction'])[2]")).click();		
		
		driver.findElement(By.id("add-to-cart-button-45")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='ico-cart']/child::span[@class='cart-label']")).click();
		
		Thread.sleep(1000);
		
		WebElement Sortby1=driver.findElement(By.id("CountryId"));
		Select Sortbydrp1 = new Select(Sortby1);
		
		Sortbydrp1.selectByVisibleText("India");
		
		WebElement Sortby2=driver.findElement(By.id("StateProvinceId"));
		Sortby2.click();
		
		driver.findElement(By.xpath("//input[@class='button-2 estimate-shipping-button']")).click();
		
		driver.findElement(By.id("termsofservice")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(2000);
		/*WebElement ab1 = driver.findElement(By.xpath("//select[@id='billing-address-select']"));
		
		boolean retuser = false; 
		
		if(ab1.isDisplayed())  // If condition is only for returning user
		{
			System.out.println(ab1.getAttribute("value"));
			retuser = true;
		}
		else
		{ */
			
		WebElement Sortby3=driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select Sortbydrp3 = new Select(Sortby3);
		Sortbydrp3.selectByVisibleText("India");	
		
		WebElement searchBox3= driver.findElement(By.id("BillingNewAddress_City"));
		searchBox3.sendKeys("PUNE");
		
		WebElement searchBox4= driver.findElement(By.id("BillingNewAddress_Address1"));
		searchBox4.sendKeys("Vishal Nagar");
		
		WebElement searchBox5= driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
		searchBox5.sendKeys("400706");
		
		WebElement searchBox6= driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
		searchBox6.sendKeys("+91-8000012345");
		
		driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]")).click();
		
		Thread.sleep(1000);
		
	/*	if(retuser)
		{
			System.out.println("This Is A Returning User");
		}
		else
		{ 
			System.out.println("This Is A New User");
			
			String parentwindow = driver.getWindowHandle(); // To store the parent window handle of the main window or ho,e page
			
			System.out.println("parentwindow = "+parentwindow);
			
			//driver.findElement(By.id("windowButton")).click();
			
			Set<String> windows = driver.getWindowHandles(); // To store all the windows (parent & child ) into a set
			
			System.out.println(windows.size());
			
			for(String s:windows) 
			{
				System.out.println(s);
			}
			
			Iterator<String> Itrwindows = windows.iterator();
			while(Itrwindows.hasNext())
			{
				String childwindow = Itrwindows.next();
				System.out.println("childwindow = "+childwindow);
					if(childwindow==parentwindow)
					{
						
						System.out.println("parent window matches with child window ");
					}
					else
					{
						driver.switchTo().window(childwindow);
						System.out.println(driver.getCurrentUrl());
						driver.findElement(By.xpath("//*[text()='Save']")).click();
						System.out.println("parent window does not match with child window ");
					}
			} 
			
				
			//System.out.println(driver.findElement(By.id("sampleHeading")).getText());
			System.out.println(driver.getCurrentUrl());
			driver.switchTo().defaultContent(); // 
			//driver.switchTo().window(parentwindow);
			
			System.out.println(driver.getCurrentUrl());
			
			/* Alert alert1 = driver.switchTo().alert();
			System.out.println(alert1.getText());
			alert1.accept(); */
		
		Thread.sleep(2000);

		
	    driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
				
		driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();		
		
		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		
		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Click here for order details.\"]")).click();
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();		
		
		driver.close();							// Will close only current window

	}

}
