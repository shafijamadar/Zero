package com.actions;

import org.openqa.selenium.WebDriver;

import com.applicationPages.LoginPage;

public class LoginActions {
	
  public void login(WebDriver driver, String userName, String password){
	  LoginPage loginPage= new LoginPage(driver);
	  loginPage.typelogin(userName);
	  loginPage.typePassword(password);
	  loginPage.homeClickonSignin();  
  }
}
