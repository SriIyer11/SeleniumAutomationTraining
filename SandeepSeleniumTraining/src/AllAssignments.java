import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllAssignments 
{
	WebDriver driver=null;
	String applicationURL = "";
	public AllAssignments(String applicationURL)
	{
		this.applicationURL= applicationURL;
	}
	public void initialize() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(applicationURL);
		driver.manage().window().maximize();        // To maximize the browser window
		System.out.println(driver.getTitle());		
	}
	
	public void closebrowser() 
	{
		driver.close();							// Will close only current window	
	}
	public void Assignment1()
	{
		initialize();
		WebElement searchBox= driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("About Selenium Testing");			// to input data into any text field
		
		driver.findElement(By.xpath("(//li[3]//div[@class='pcTkSc']/div[@class='lnnVSe'])[1]")).click();
		// driver.getTitle();
		System.out.println(driver.getTitle());			
		closebrowser();
	}
	
	public static void main(String[] args)
	{
		AllAssignments a1 = new AllAssignments("https//www.google.com"); // a1 is the object for AllAssignments class
		a1.Assignment1();

		// a1.Assignment2(); // to call assignment 2 
	}

}
