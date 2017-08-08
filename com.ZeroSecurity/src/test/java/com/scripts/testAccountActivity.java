package com.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actions.LoginActions;
import com.applicationPages.AccountActivityPage;
import com.applicationPages.AccountSummaryPage;
import com.applicationPages.HomePage;
import com.applicationPages.LoginPage;
import com.utilities.PropertyFileReader;
import com.utilities.SeleniumUtils;

public class testAccountActivity {
	
	WebDriver driver=null;
	SeleniumUtils seleniumUtils=null;
	
	Logger logger=LogManager.getLogger(this.getClass().getName());
	
	@BeforeMethod
	
	public void setup(){
		seleniumUtils= new SeleniumUtils(); 
		PropertyFileReader.loadProperties(); 
		driver=seleniumUtils.openBrowser("firefox", PropertyFileReader.getProperty("url"));
	}
	
	@Test(enabled=false)
	public void AccountPage() {
		try{
			
		HomePage homepage=new HomePage(driver);
		homepage.clickOnSignIn();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.typelogin(PropertyFileReader.getProperty("username"));
		loginpage.typePassword(PropertyFileReader.getProperty("password"));
		loginpage.homeClickonSignin();
		
		AccountSummaryPage accountsummary= new AccountSummaryPage(driver);
		accountsummary.isAccountSummary();
				
		AccountActivityPage account= new AccountActivityPage(driver);
		account.clickOnAccountActivity();
		
		account.isAccountActivityPage();
		
		Assert.assertTrue(account.isAccountActivityPage());
		Assert.assertTrue(account.isShowTransactionTab());
		Assert.assertTrue(account.isFindTransactionTab());  
		
		account.getSavings();
		Assert.assertEquals(account.getSavings(), "Savings");
		}
		catch(Exception e){
			e.getMessage();
		}
		//System.out.println(account.getSavings());
	}
	
	@Test(enabled=false)
	public void showTransactionPageDetails(){
		
		HomePage homePage= new HomePage(driver);
		homePage.clickOnSignIn();
		
		LoginActions loginAction= new LoginActions();
		loginAction.login(driver, "username", "password");
		
		//LoginPage loginPage= new LoginPage(driver);
		
		AccountSummaryPage account=new AccountSummaryPage(driver);
		account.isAccountSummary();
		
		AccountActivityPage accountActivity= new AccountActivityPage(driver);
		accountActivity.clickOnAccountActivity();
		accountActivity.getDateDetails();
		accountActivity.getDescription();
		accountActivity.getDesposite();
		accountActivity.getWithdrawal();
		
		Assert.assertEquals(accountActivity.getDateDetails(), "Date");
		Assert.assertEquals(accountActivity.getDescription(), "Description");
		Assert.assertEquals(accountActivity.getDesposite(), "Deposit");
		Assert.assertEquals(accountActivity.getWithdrawal(), "Withdrawal");
		
	}
	
	//Test Case No - AccActShow_03 and AccActShow_04
	@Test(enabled=false)
	public void loanDetails(){
	
		try{
		HomePage homePage=new HomePage(driver);
		homePage.clickOnSignIn();
		
		LoginActions loginAction=new LoginActions();
		loginAction.login(driver, "username", "password");
		
		AccountSummaryPage accountsummary= new AccountSummaryPage(driver);
		accountsummary.isAccountSummary();
		
		AccountActivityPage accountActivity=new AccountActivityPage(driver);
		accountActivity.clickOnAccountActivity();
		
		accountActivity.selectLoanAccount();
		
		accountActivity.getRowdata();
		
		Assert.assertEquals(accountActivity.getRowdata(), "RENT");	
		
		System.out.println(accountActivity.getRowdata());
		
		// Test case no - AccActShow_04 -no results for credit card are verified under this test only
	
		accountActivity.getCreditCard();
		
		Assert.assertEquals(accountActivity.getCreditCard(), "No Results");
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	@Test
	public void checkingAccount()
	{
		HomePage homePage=new HomePage(driver);
		homePage.clickOnSignIn();
		
		LoginActions loginAction=new LoginActions();
		loginAction.login(driver, "username", "password");
			
		AccountSummaryPage accountsummary= new AccountSummaryPage(driver);
		accountsummary.isAccountSummary();
		System.out.println("Check if account summary is loaded");
		
		AccountActivityPage accountActivity=new AccountActivityPage(driver);
		//accountActivity.clickOnAccountActivity();
		System.out.println("Account is not checked");
		accountActivity.clickOnAccountActivity();
		
		System.out.println("Account is checked");
		accountActivity.selectCheckingAccount();
		System.out.println(accountActivity.getRowdata());
		
	}
	
	
}