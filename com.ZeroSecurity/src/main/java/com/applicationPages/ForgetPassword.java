package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetPassword {

	private String EMAIL_ID="user_email";
	private String VERIFY_MESSAGE_XPATH="html/body/div[1]/div[2]/div/div/div/p";
	private String VERIFY_EMAILSENT_MESSAGE_XPATH="html/body/div[1]/div[2]/div/div/div";
	
	private WebDriver driver;
	
	public ForgetPassword(WebDriver driver){
		this.driver=driver;
	}
	
	public void textEmail(String emailid){
		 driver.findElement(By.id(EMAIL_ID)).sendKeys(emailid);
	}
	
	public boolean verifyMessage(){
		return driver.findElement(By.xpath(VERIFY_MESSAGE_XPATH)).isDisplayed();
		
	}
	
	public boolean verifyEmailSentMessage(){
		return driver.findElement(By.xpath(VERIFY_EMAILSENT_MESSAGE_XPATH)).isDisplayed();
	}
}
