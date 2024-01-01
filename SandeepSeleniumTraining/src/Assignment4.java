import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import junit.framework.Assert;

public class Assignment4 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		// driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		WebElement searchBox= driver.findElement(By.xpath("//input[@aria-label='Email or phone']"));
		searchBox.click();
		searchBox.sendKeys("dummyperson808@gmail.com");	
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		WebDriverWait expwait = new WebDriverWait(driver, 2000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Passwd']"))); // Asked to wait until the element is shown over UI
		WebElement pwd = driver.findElement(By.xpath("//input[@name='Passwd']"));
		pwd.click();
		
		pwd.clear(); // clear the previous data in the filed, if present any
		
		pwd.sendKeys("Abc@1234");
		
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@aria-label,'dummyperson808@gmail.com')]"))); // will explicitly wait to check whether user has logged in or not
		
		WebElement cmpse = driver.findElement(By.xpath("//div[text()='Compose']"));
		if(cmpse.isEnabled())
		{
			cmpse.click();
			expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Subject']/ancestor::div[@class='AD']")));
			
			WebElement recipient = driver.findElement(By.xpath("//div[text()='Recipients']"));
			recipient.click();
			recipient.sendKeys("dummyperson808@gmail.com");
			
			WebElement sbjt = driver.findElement(By.xpath("//input[@aria-label='Subject']"));
			sbjt.click();
			sbjt.sendKeys("Test Email");
			
			WebElement textbody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
			textbody.click();
			textbody.sendKeys("Hello and how are you ?");
			
			driver.findElement(By.xpath("//div[text()='Send']")).click();
			
			expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Message Sent']")));
			
			driver.findElement(By.linkText("Sent")).click();
			
			Assert.assertEquals("Test Email", driver.findElement(By.xpath("(//span[@class='bqe'])[2]")).getText());
			
			//*[text()='New Message']/ancestor::div[@class='nH']

			//*[@aria-label='Subject']/ancestor::div[@class='AD']

			//span[@id=':er']
		}		
		
		
		driver.close();							// Will close only current window

	}

}
