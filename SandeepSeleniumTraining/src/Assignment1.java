import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//comment
public class Assignment1 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		WebElement searchBox= driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("About Selenium Testing");			// to input data into any text field
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//li[3]//div[@class='pcTkSc']/div[@class='lnnVSe'])[1]")).click();
		// driver.getTitle();
		System.out.println(driver.getTitle());		
							
		driver.close();							// Will close only current window

	}

}
