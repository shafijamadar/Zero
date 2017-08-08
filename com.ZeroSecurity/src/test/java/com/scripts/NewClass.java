 package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actions.LoginActions;
import com.applicationPages.LoginPage;
import com.utilities.PropertyFileNewWay;
import com.utilities.PropertyFileReader;
import com.utilities.SeleniumUtils;

public class NewClass {
	
	public SeleniumUtils seleniumutils = null;
	public PropertyFileNewWay propNew = null;
	public PropertyFileReader prop= null;
	public WebDriver driver = null;
	
	@BeforeTest
	public void setUp(){
		
		seleniumutils= new SeleniumUtils();
		prop = new PropertyFileReader();
		propNew = new PropertyFileNewWay();
		seleniumutils.openBrowser("Mozilla", prop.getProperty("url"));
	}
	
	@Test
	public void check()
	{
		LoginActions action = new LoginActions();
		action.login(driver, prop.getProperty("username"), prop.getProperty("password"));
		
		LoginPage login= new LoginPage(driver);
		login.homeClickonSignin();
		
		
		
	}

}
