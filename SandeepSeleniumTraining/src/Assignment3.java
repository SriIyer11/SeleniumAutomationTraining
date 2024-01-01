import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class Assignment3 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // will wait for all the elements to get load on website
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // will scroll down to the extreme bottom
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,- document.body.scrollHeight)"); // will scroll to the extreme top
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
		
		Alert alert1 = driver.switchTo().alert(); // Switching to alert using alert method
		System.out.println(alert1.getText());
		alert1.accept();
		WebElement alerttext = driver.findElement(By.xpath("//span[@class='text-success' and @id='confirmResult']"));
		Assert.assertTrue("You selected Ok".equals(alerttext.getText()));
		System.out.println(alerttext.getText());
		
	//	Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
		Alert alert2 = driver.switchTo().alert(); // Switching to alert using alert method
		System.out.println(alert2.getText());
		alert2.dismiss();
		WebElement alerttextn = driver.findElement(By.xpath("//span[@class='text-success' and @id='confirmResult']"));
		Assert.assertTrue("You selected Cancel".equals(alerttextn.getText()));
		System.out.println(alerttextn.getText());
			
		driver.close();							// Will close only current window

	}

}
