package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	//WebElements locators
	
	private String SIGN_IN_ID="signin_button";
	private String LOGO_XPATH="html/body/div[1]/div[1]/div/div/a";
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickOnSignIn(){
		driver.findElement(By.id(SIGN_IN_ID)).click();
	}
	
	public boolean isHomePage(){
		return driver.findElement(By.xpath(LOGO_XPATH)).isDisplayed();
		
	}
}
