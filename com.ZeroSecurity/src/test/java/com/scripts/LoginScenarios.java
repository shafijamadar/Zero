package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applicationPages.ForgetPassword;
import com.applicationPages.HomePage;
import com.applicationPages.LoginPage;
import com.utilities.PropertyFileReader;
import com.utilities.SeleniumUtils;

public class LoginScenarios {
	
	private WebDriver driver=null;
	private SeleniumUtils seleniumUtils=null;
	
  @BeforeMethod
	
  	public void setUp()
  	{
	  seleniumUtils= new SeleniumUtils();
	  PropertyFileReader.loadProperties();
	  driver=seleniumUtils.openBrowser("firefox", PropertyFileReader.getProperty("url"));
  	
  	}
  
  @Test(enabled=true)
  public void verifySuccessfulllogin() 
  {
	  HomePage homePage= new HomePage(driver);
	  homePage.clickOnSignIn();
	  
	  LoginPage loginPage= new LoginPage(driver); 
	  Assert.assertTrue(loginPage.isLoginPage());
	//  loginPage.typelogin("username");
	 loginPage.typelogin(PropertyFileReader.getProperty("username"));
	  loginPage.typePassword("password");
	  loginPage.homeClickonSignin();  
  }
  
  @Test(enabled=false)
  public void invalidlogin()
  {
	  HomePage homePage= new HomePage(driver);
	  homePage.clickOnSignIn();
	  
	  LoginPage loginPage=new LoginPage(driver);
	  loginPage.typelogin("456789");
	  loginPage.typePassword("username");
	  loginPage.homeClickonSignin();
	  Assert.assertEquals("Log in to ZeroBank", loginPage.loginerrorcheck());
	//  Assert.assertTrue(loginPage.isLoginPage());
  }
  
  @Test(enabled=false)
  public void VerifyForgetPassword()
  {
	  HomePage homePage=new HomePage(driver);
	  homePage.clickOnSignIn();
	  
	  LoginPage loginPage=new LoginPage(driver);
	  loginPage.clickForgetPassword();
	  System.out.println(driver.getCurrentUrl());
	  
	  ForgetPassword forgetPassword=new ForgetPassword(driver);
	  Assert.assertTrue(forgetPassword.verifyMessage());
	  
	  forgetPassword.textEmail("test123@test.com");
	  Assert.assertTrue(forgetPassword.verifyEmailSentMessage());
	  
  }
  
 // @Test(enabled=true)
  public void toolTip(){
	  
	  HomePage homePage=new HomePage(driver);
	  homePage.clickOnSignIn();
	  
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.mouseHourTooltip();
	  
	  Assert.assertEquals(loginpage.mouseHourTooltip(), "Login/Password - username/password");
	  
	  System.out.println(loginpage.mouseHourTooltip()); 
  }
  
 // @Test //(dependsOnMethods="verifySuccessfulllogin")
  public void logout(){
	  
	  HomePage homepage=new HomePage(driver);
	  homepage.clickOnSignIn();
	  
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.typelogin("username");
	  loginpage.typePassword("password");
	  loginpage.homeClickonSignin();
	  
	  loginpage.logout();
	  System.out.println("Logged Out");
	  
	  Assert.assertTrue(homepage.isHomePage(), "User logged out successfully");
  }
  
  @AfterMethod
  public void tearDown(){
	  seleniumUtils.closeBrowser();
  }
}