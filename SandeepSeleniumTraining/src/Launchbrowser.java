import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launchbrowser 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.co.in");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Laptops");			// to input data into any text field
		String searchBoxvalue=searchBox.getAttribute("value");
		// String searchBoxvalue=searchBox.getText();  
		System.out.println("Value is "+searchBoxvalue);
		
		//Thread.sleep(9000);						// Will wait for 9 seconds				
		driver.close();							// Will close only current window
		// driver.quit();                         // To close all the open windows

	}

}
