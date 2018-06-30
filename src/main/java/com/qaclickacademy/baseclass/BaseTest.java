package com.qaclickacademy.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qaclickacademy.utility.Utilities;
import com.qaclickacademy.utility.WebEventListener;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public BaseTest()
	{
		try {
			prop=new Properties();
			FileInputStream fs=new FileInputStream("C:/Users/Nilesh/workspace/QAClickAcademy/src/main/java/com/qaclickacademy/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			System.out.println("Config.properties file is NOT found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error loading config properties file");
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("user.dir")+"\\QAClickAcademy\\src\\main\\java\\com\\"
			+"qaclickacademy\\config\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("user.dir")+"\\QAClickAcademy\\src\\main\\java\\com\\"
			+"qaclickacademy\\config\\firefoxdriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			//InternetExplorerDriver
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
