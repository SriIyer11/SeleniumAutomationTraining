package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static void initialize()
	{
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://demowebshop.tricentis.com/login");
			driver.manage().window().maximize();        // To maximize the browser window
			System.out.println(driver.getTitle());			
	}
	
	public static void teardown()
	{
		driver.close();
	}

	public static void main(String[] args) 
	{
		

	}

}
