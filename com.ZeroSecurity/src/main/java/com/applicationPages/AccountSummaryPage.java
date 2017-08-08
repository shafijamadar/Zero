package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPage {
	
	String ACCOUNTSUMMARY_XPATH="//li[@id='account_summary_tab']/a";
	
	WebDriver driver;
	
	public AccountSummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isAccountSummary(){
		return driver.findElement(By.xpath(ACCOUNTSUMMARY_XPATH)).isDisplayed();
	}
}
