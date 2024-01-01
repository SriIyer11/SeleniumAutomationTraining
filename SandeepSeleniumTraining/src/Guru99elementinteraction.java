import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99elementinteraction 
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
		
		Thread.sleep(1000);
		
	    //WebElement popupad=driver.findElement(By.id("card"));
	    
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card']//iframe")));
		
	 //   WebElement popupad1=driver.findElement(By.xpath("//div[@id='card']"));
		
		WebElement iframe1=driver.findElement(By.xpath("//div[@id='card']//iframe"));
	    
	    if(iframe1.isDisplayed())
	    {
	    	// driver.findElement(By.xpath("//div[@id='card']//div[@id='dismiss-button']/descendant::div")).click();
	    	driver.findElement(By.xpath("//div[@id='dismiss-button']//span[text()='Close']/ancestor::div[@role='button']")).click();
	    }
	   /* else if(popupad1.isDisplayed())
	    {
	    	driver.findElement(By.xpath("//div[@id='dismiss-button']//span[text()='Close']/parent::div")).click();
	    } */
	    
	   System.out.println(driver.getTitle());
		
	//	Select Sortbydrp = new Select(Sortby);
		
	//	Sortbydrp.selectByVisibleText("Price: Low to High");
		
	//	System.out.println(Sortbydrp.getFirstSelectedOption()); // This will get the text of the value selected from the drop-down
		Thread.sleep(2000);
		
					
		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
