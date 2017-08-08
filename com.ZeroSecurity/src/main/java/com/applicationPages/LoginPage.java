package com.applicationPages;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	private String USERNAME_ID="user_";
	private String PASSWORD_Xpath=".//*[@id='user_password']";
	private String SIGN_IN_CSS=".btn.btn-primary";
	private String PAGETITLE_XPATH="//h3[text()='Log in to ZeroBank']";
	private String PAGE_ERROR_XPATH="html/body/div[1]/div[2]/div/div/div/div/h3";
	private String FORGET_PASSWORD_CSS=".offset3.span6>a";
	private String TOOL_TIP_ID="credentials";
	private String DROPDOWN_XPATH=".//*[@id='settingsBox']/ul/li[3]/a";
	private String LOGOUT_XPATH=".//*[@id='logout_link']";
	
	private WebDriver driver;
	
	Logger logger=null;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		logger=LogManager.getLogger(this.getClass().getName());
	}

	
	
	public void typelogin(String userName){

		
		try{
			driver.findElement(By.id(USERNAME_ID)).sendKeys(userName);
	//		logger.error("User id"+USERNAME_ID + " userName " +userName);
		}catch (Exception e)
		{
			logger.error("User Name field not found on page" + " Check locator is correct " +USERNAME_ID);
		}
	}
		
	
	public void typePassword(String passWord){
	
		//WebDriverWait wait=new WebDriverWait(driver, 2);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_Xpath)));
	try{
		driver.findElement(By.xpath(PASSWORD_Xpath)).sendKeys(passWord);
	}catch(NoSuchElementException e){
		logger.error("Password field is visable" + "Check the timeout exception" + PASSWORD_Xpath);
	}
	}
	
	public void homeClickonSignin(){
		driver.findElement(By.cssSelector(SIGN_IN_CSS)).click();
	}
	
	public boolean isLoginPage(){
		return driver.findElement(By.xpath(PAGETITLE_XPATH)).isDisplayed();
		
	}
	
	public String loginerrorcheck(){
		return driver.findElement(By.xpath(PAGE_ERROR_XPATH)).getText();
	}
	
	public void clickForgetPassword(){
		 driver.findElement(By.cssSelector(FORGET_PASSWORD_CSS)).click();
		
	}
	
	public String mouseHourTooltip(){
		
		WebElement tooltip=driver.findElement(By.id(TOOL_TIP_ID));
		Actions act=new Actions(driver);
		act.moveToElement(tooltip).perform();
		return tooltip.getText();	
	}
	
	public void logout(){
		WebElement dropdown=driver.findElement(By.xpath(DROPDOWN_XPATH));
		dropdown.click();
		
		WebElement logout=driver.findElement(By.xpath(LOGOUT_XPATH));
		Actions act=new Actions(driver);
		act.moveToElement(logout).click().perform();
		/*
		Select logout=new Select(dropdown);
		logout.selectByVisibleText("Logout");*/
	}

	
}
