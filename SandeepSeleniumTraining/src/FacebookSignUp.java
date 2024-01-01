import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUp 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		String parentwindow = driver.getWindowHandle(); // To store the parent window handle of the main window or ho,e page
		
		System.out.println("parentwindow = "+parentwindow);
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
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
					System.out.println("parent window does not match with child window ");
				}
		} 
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 		
		WebElement searchBox1= driver.findElement(By.xpath("//input[@placeholder='First name']"));
		js.executeScript("arguments[0].click();", searchBox1);
		// searchBox1.click();
		searchBox1.sendKeys("Mark");
						
		WebElement searchBox2= driver.findElement(By.xpath("//input[@aria-label='Surname']"));
		searchBox2.click();
		searchBox2.sendKeys("West");
		
		WebElement searchBox3= driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
		searchBox3.click();
		searchBox3.sendKeys("xyz@yahoo.in");
		
		// searchBox4.sendKeys("Abcd123");
		
	/*	WebElement Sortby=driver.findElement(By.id("products-orderly"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: Low to High"); */
		
		Thread.sleep(2000);
		
					
		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
