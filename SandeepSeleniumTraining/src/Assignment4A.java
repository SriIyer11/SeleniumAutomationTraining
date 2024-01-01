import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment4A 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();        // To maximize the browser window
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		WebElement searchBox= driver.findElement(By.xpath("//input[@aria-label='Email or phone']"));
		searchBox.click();
		searchBox.sendKeys("dummyperson808@gmail.com");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		WebDriverWait expwait = new WebDriverWait(driver,9000); // This is for explicit wait
		expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Passwd']"))); // Asked to wait until the element is shown over UI
		WebElement pwd = driver.findElement(By.xpath("//input[@name='Passwd']"));
		Actions actions= new Actions(driver);
		actions.moveToElement(pwd).click().build().perform();
        
		pwd.clear(); // clear the previous data in the filed, if present any
		pwd.sendKeys("Abc@1234");
				
		expwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))); // Asked to wait until the element is shown over UI
		WebElement NextButton = driver.findElement(By.xpath("//span[text()='Next']"));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",NextButton);
		
		WebElement cmpse = driver.findElement(By.xpath("//div[text()='Compose']"));
		if(cmpse.isEnabled())
		{
			cmpse.click();
			expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Subject']/ancestor::div[@class='AD']")));
			expwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='To']/ancestor::td[1]/following-sibling::td//input")));
			WebElement recipient = driver.findElement(By.xpath("//span[text()='To']/ancestor::td[1]/following-sibling::td//input"));
			recipient.click();
			recipient.sendKeys("dummyperson808@gmail.com");			
			WebElement sbjt = driver.findElement(By.xpath("//input[@aria-label='Subject']"));
			actions.moveToElement(sbjt).click().build().perform();
			
			sbjt.sendKeys("Test Email");			
			WebElement textbody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
			textbody.click();
			textbody.sendKeys("Hello and how are you ?");
			
			driver.findElement(By.xpath("//div[text()='Send']")).click();
			
			
			driver.findElement(By.linkText("Sent")).click();
			
			WebElement SubjMail = driver.findElement(By.xpath("(//div[text()='Inbox']/ancestor::div[@class='yi']/following-sibling::div//span[@class='bqe'])[1]"));
			
			//Assert.assertEquals("Test Email",SubjMail.getAttribute("value"));
			
			actions.moveToElement(SubjMail);
			
			expwait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='Cp']//table[@role='grid'])[2]//tbody/tr[1]/td[2]")));
			WebElement checkBox= driver.findElement(By.xpath("(//div[@class='Cp']//table[@role='grid'])[2]//tbody/tr[1]/td[2]"));
			checkBox.click();

			driver.findElement(By.xpath("(//div[@title='Delete']/div[@class='asa'])[2]")).click(); 
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//span[@class='CJ' and text()='More'])[1]")).click();
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div[@class='aio UKr6le'])[11]")).click();
			
			//Assert.assertEquals("Conversation moved to Trash.",driver.findElement(By.xpath("(//div[@class='aio UKr6le'])[11]")).getText());
		}		
		
		Thread.sleep(1000);
		
	//	driver.close();							// Will close only current window

	}

}
