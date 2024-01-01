import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Elementinteraction 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/books");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		WebElement Sortby=driver.findElement(By.id("products-orderby"));
		Select Sortbydrp = new Select(Sortby);
		
		Sortbydrp.selectByVisibleText("Price: Low to High");
		
	//	System.out.println(Sortbydrp.getFirstSelectedOption()); // This will get the text of the value selected from the drop-down
		Thread.sleep(2000);
		
					
		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
