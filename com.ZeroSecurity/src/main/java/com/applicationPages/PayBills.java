package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayBills {
	
	String ADD_PAYEE_XPATH="//div[@id='tabs']/ul/li[2]/a";
	
	private WebDriver driver;
	
	PayBills(WebDriver driver){
		
		this.driver=driver;
	}
	
	private void AddNewPayee(){
		driver.findElement(By.xpath(ADD_PAYEE_XPATH)).click();
				
	}

}
