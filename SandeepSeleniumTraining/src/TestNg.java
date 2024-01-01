import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
// import org.testng.annotations.Test;

public class TestNg 
{
@Test
public void initialize() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/books");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	driver.close();	
}
	

}

