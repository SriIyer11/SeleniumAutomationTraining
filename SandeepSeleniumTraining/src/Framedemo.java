import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framedemo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize(); 
		
		System.out.println(driver.getTitle());
		
		WebElement frameElement= driver.findElement(By.xpath("//div[@class='module-surround']/iframe")); // this is like defining the locator for frame element
		
		driver.switchTo().frame(frameElement); // Switch first to frame by WebElement strategy so that elements under frame can get detect
		
		Thread.sleep(2000);
		
		WebElement searchBox= driver.findElement(By.cssSelector("div#player"));
		
		System.out.println(searchBox.isDisplayed()); // return true is the element is displayed in UI
		
										
		driver.close();							
		// driver.quit(); 

	}

}
