package com.qa.TestBase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.qa.util.Testutil;
import com.qa.util.WebElementListiener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebElementListiener eventListener;

	public TestBase(){
	
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\amit\\eclipse-workspace\\FreeCRM"
					+ "\\src\\main\\java\\com\\qa\\config\\config.properties");	
			prop.load(ip);
			} catch (FileNotFoundException e) 
			{
			e.printStackTrace();
			}catch (IOException e) 
			{
			e.printStackTrace();
			}
		}
	
	
	public void intialize()
	{
		   String browser = prop.getProperty("browser");
		    if (browser.equals("chrome")) {
		    	System.setProperty("webdriver.chrome.driver", "F:\\library\\chromedriver.exe");
				driver=new ChromeDriver();
			}else if(browser.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "F:\\library\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			
		    e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebElementListiener();
			e_driver.register(eventListener);
			driver = e_driver;
		
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
