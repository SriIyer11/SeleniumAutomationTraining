import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Elementinteraction2 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.get("https://demo.guru99.com/test/guru99home/");
		
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		WebElement Sortby=driver.findElement(By.xpath("//a[contains(text(),'Selenium') and @href='#']"));
		Sortby.click();
		
		WebElement radiobutton=driver.findElement(By.linkText("Radio & Checkbox Demo"));
		radiobutton.click();
		
		Thread.sleep(5000); 
		
	/*	driver.get("https://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();       
		System.out.println(driver.getTitle());  */
		
		driver.findElement(By.id("vfb-7-1")).click();
		driver.findElement(By.id("vfb-7-3")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("vfb-6-1")).click();
		driver.findElement(By.id("vfb-6-0")).click();
		
		Thread.sleep(2000);
	 		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
