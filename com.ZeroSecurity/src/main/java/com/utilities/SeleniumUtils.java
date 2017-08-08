package com.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumUtils {
	
	private static WebDriver driver=null;
	Logger logger = LogManager.getLogger(this.getClass().getName());
	
	public WebDriver openBrowser(String browserName, String url)
	{

		if(browserName.equalsIgnoreCase("firefox"))
		{ 
			logger.info("Creating FireFox browser object");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{ 
			logger.info("Creating chrome browser object");
			System.setProperty("webdriver.chrome.driver", "Servers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("internetexplore"))
		{
			System.setProperty("webdriver.ie.driver", "Servers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		logger.info(url);
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	public void closeBrowser(){
		
		if(driver!=null)
		{
		driver.quit();
		}
		else{
			logger.warn("Driver is not initialised");
		}
	}
}