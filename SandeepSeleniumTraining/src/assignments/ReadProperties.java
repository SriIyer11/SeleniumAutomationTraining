package assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {

	static Properties prop = new Properties();
	static WebDriver driver;
	
	public static void initialize()
	{
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readProperty("Chrome_WebDriver_path"));
			driver=new ChromeDriver();
			driver.get(readProperty("application_url"));
			driver.manage().window().maximize();        // To maximize the browser window
			System.out.println(driver.getTitle());			
	}
	
	public static void teardown()
	{
		driver.close();
	}
	
	public static void initializePropertiesFile()
	{
		String ProjDirPath = System.getProperty("user.dir");
		System.out.println("Dir Path: "+ProjDirPath);
		
		File file = new File(ProjDirPath + "\\src\\assignments\\ObjectRepo.properties");
		FileInputStream fip;
		try {
			fip = new FileInputStream(file);
			prop.load(fip);
			System.out.println("URL:"+ prop.getProperty("application_url"));
			System.out.println("chrome driver path:"+ prop.getProperty("Chrome_WebDriver_path"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String readProperty(String key)
	{
		return prop.getProperty(key);
	}
	
	public static void main(String[] args)
	{
		initializePropertiesFile();
	    initialize();		
	    teardown();
	}

}
