import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingAlerts 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // will wait for all the elements to get load on website
		
		WebElement searchBox1= driver.findElement(By.xpath("//input[@name='cusid']"));
		searchBox1.click();
		
		double random = Math.random();
		System.out.println("Customer ID IS"+random);
		searchBox1.sendKeys(Double.toString(random));
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Alert delalert = driver.switchTo().alert(); // Switching to alert using alert method
		System.out.println(delalert.getText());
		
		delalert.accept(); // if want to click on OK or Accept button or else can use dismiss method
		
		
		Alert conalert = driver.switchTo().alert();
		System.out.println(conalert.getText());
		Assert.assertEquals("Customer Successfully Delete!", conalert.getText()); // To get the alert test message getting display
		conalert.accept();		
							
		 driver.close();							// Will close only current window

	}

}
