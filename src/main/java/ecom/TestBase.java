package ecom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Testutil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Automation\\ecom\\src\\main\\java\\config\\config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

public static void initilization() {
		
		String Browsers = prop.getProperty("browser");
		
		
		if(Browsers.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\ecom\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsers.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Automation\\ecom\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
/*		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
*/
		
		driver.get(prop.getProperty("url"));
		
//		WebElement Mainimage = driver.findElement(By.xpath(prop.getProperty("homeopageimage")));
//		
//		Testutil.WaitforElement(driver, Mainimage, Duration.ofSeconds(10));
		
	}
}
