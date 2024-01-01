import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import junit.framework.Assert;

public class Assignment2 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// driver.manage().deleteAllCookies(); // to delete the browser cookies history
		
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());
		
		WebElement searchBox= driver.findElement(By.xpath("//input[@aria-label='Email or phone']"));
		searchBox.click();
		searchBox.sendKeys("dummyperson808@gmail.com");	
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		WebDriverWait expwait = new WebDriverWait(driver, 2000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Passwd']"))); // Asked to wait until the element is shown over UI
		WebElement pwd = driver.findElement(By.xpath("//input[@name='Passwd']"));
		
		SoftAssert sassert = new SoftAssert();
		
		for(int i=0;i<2;i++)
		{
		
		pwd.click();
				
		pwd.clear(); // clear the previous data in the filed, if present any
		
		pwd.sendKeys("Abc1234");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']")));
		
		sassert.assertEquals(driver.findElement(By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']")).getText(), "Wrong password. Try again or click Forgot password to reset it.");
		
		System.out.println("Password entered incorrectly "+(i+1)+ " times ");
		}
		
		sassert.assertAll();
		
	//	driver.close();							// Will close only current window

	}

}
