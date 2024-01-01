import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementinteractionMouseHover 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/books");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		WebElement digitaldownloads=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]"));
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(digitaldownloads).click().build().perform(); // movetoElement method is for mouse-hover //// compile everything in single step and than get execute
		
	/*	Action action=actions.moveToElement(digitaldownloads).click().build();
		action.perform(); */
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
					
		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
