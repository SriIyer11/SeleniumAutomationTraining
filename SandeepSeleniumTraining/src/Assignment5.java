import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class Assignment5 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();        // To maximize the browser window
		
			
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // This will wait for max 10 seconds for the entire page to get laod
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // This will implicitly wait for 2 seconds before interacting with the next element in current page
		

		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("gender-male")).click();
		
		WebElement searchBox1= driver.findElement(By.id("FirstName"));
		searchBox1.sendKeys("ROK");
						
		WebElement searchBox2= driver.findElement(By.id("LastName"));
		searchBox2.sendKeys("DANS");
		
		WebElement searchBox3= driver.findElement(By.id("Email"));
		searchBox3.sendKeys("dummyperson812@gmail.com");
		
		Thread.sleep(2000);	
		
		WebElement searchBox4= driver.findElement(By.id("Password"));
		searchBox4.sendKeys("Abc@1234");
		
		WebElement searchBox5= driver.findElement(By.id("ConfirmPassword"));
		searchBox5.sendKeys("Abc@1234");
		
		driver.findElement(By.id("register-button")).click();
		
		// Do assertion that registration is successfully completed. Msg - Your registration completed should get display and also verify that Continue button is getting display as Enabled and Clickable
		// User new email address is getting display on top RHS along with Log Out link
		
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("(//a[@href='/books'])[3]")).click();
		
		WebElement Sortby=driver.findElement(By.id("products-orderby"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: Low to High");
		
		driver.findElement(By.xpath("(//a[@href='/fiction'])[2]")).click();		
		
		driver.findElement(By.id("add-to-cart-button-45")).click();
		
		Thread.sleep(2000);
		
		WebElement scart = driver.findElement(By.xpath("//li[@id='topcartlink']/a"));
		
		String strexp = "Shopping cart\n(1)"; 
		String actscart = scart.getText();
		
		System.out.println("Expected:"+strexp+" Actual:"+actscart);
		
		Assert.assertTrue(strexp.equals(actscart));
		//Assert.assertTrue(strexp.equals(actscart), "Shopping Cart Message Did Not Match"); // String equals method is to check
				
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click(); /*this locator works when user is getting log in at Step # 45 post new user registration. 
		Since email address & password is already used, it is not allowing the user to login */
		
		Assert.assertTrue(driver.findElement(By.linkText("Log in")).isEnabled()); // this is a check that user has been logged out successfully
		
		driver.close();							// Will close only current window

	}

}
