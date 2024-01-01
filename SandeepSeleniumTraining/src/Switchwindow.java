import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Switchwindow 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		
		String parentwindow = driver.getWindowHandle(); // To store the parent window handle of the main window or ho,e page
		
		System.out.println("parentwindow = "+parentwindow);
		
	    driver.findElement(By.id("windowButton")).click();
		
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
		
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().defaultContent(); // 
		driver.switchTo().window(parentwindow);
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.close();							// Will close only current window
		 driver.quit();                         // To close all the open windows

	}

}
