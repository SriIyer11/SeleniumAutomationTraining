import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollUpDown 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); // will wait for all the elements to get load on website
		
		JavascriptExecutor jse = (JavascriptExecutor) driver; // This is typecasting in Java
		
		jse.executeScript("window.scrollBy(0,400)", ""); // trying to scroll down by some positive number; 0 is for X axis & 400 is for Y axis
		jse.executeScript("window.scrollBy(0,-250)", ""); // trying to scroll up
		
		WebElement virtualcard = driver.findElement(By.linkText("$25 Virtual Gift Card"));
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // will scroll down to the extreme bottom
		jse.executeScript("window.scrollBy(0,- document.body.scrollHeight)"); // will scroll to the extreme top
		
		WebDriverWait expwait = new WebDriverWait(driver, 9000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("$25 Virtual Gift Card"))); // Asked to wait until the element is shown over UI
		
		jse.executeScript("arguments[0].scrollIntoView();",virtualcard);	
		
							
		//driver.close();							// Will close only current window

	}

}
