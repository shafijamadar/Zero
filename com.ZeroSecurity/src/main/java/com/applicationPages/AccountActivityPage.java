package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage {
	
	String ACCOUNTACTIVITY_TAB_XPATH="//li[@id='account_activity_tab']/a";
	String HEADER_SHOWTRANSACTIONS_XPATH="//div[@id='ui-tabs-1']/h2";
	String TAB_SHOWTRANSACTION_XPATH="//div[@id='tabs']/ul/li/a";
	String TAB_FINDTANSACTION_XPATH="//div[@id='tabs']/ul/li[2]/a";
	String DROPDOWN_XPATH=".//*[@id='aa_accountId']";
	String TABLE_DATE_XPATH=".//*[@id='all_transactions_for_account']/table/thead/tr/th[1]";
	String TABLE_DESCRIPTION_XPATH=".//*[@id='all_transactions_for_account']/table/thead/tr/th[2]";
	String TABLE_DEPOSITE_XPATH=".//*[@id='all_transactions_for_account']/table/thead/tr/th[3]";
	String TABLE_WITHDRAWAL_XPATH=".//*[@id='all_transactions_for_account']/table/thead/tr/th[4]";
	String DATE_CHECKING_XPATH=".//*[@id='all_transactions_for_account']/table/tbody/tr[3]/td[1]";
	String WITHDRAWAL_CHECKING_XPATH=".//*[@id='all_transactions_for_account']/table/tbody/tr[3]/td[4]";
	String DESCRIPTION_CHECKING_XPATH=".//*[@id='all_transactions_for_account']/table/tbody/tr[3]/td[4]";
	String CREDIT_CARD_TABLE_CLASS="//div[@class='well']";
	

	private WebDriver driver;
	
	public AccountActivityPage(WebDriver driver) {
		this.driver=driver;
	}

	public Select selectDropdown(){
	
		WebElement drop=driver.findElement(By.xpath(DROPDOWN_XPATH));
		
		Select select= new Select(drop);
		return select;
		
	}
	
	
	public void clickOnAccountActivity(){
		driver.findElement(By.xpath(ACCOUNTACTIVITY_TAB_XPATH)).click();
	}
	
	public boolean isAccountActivityPage(){
		return driver.findElement(By.xpath(HEADER_SHOWTRANSACTIONS_XPATH)).isEnabled();
		
	}
	public boolean isShowTransactionTab(){
		return driver.findElement(By.xpath(TAB_SHOWTRANSACTION_XPATH)).isDisplayed();
	}
	
	public boolean isFindTransactionTab(){
		return driver.findElement(By.xpath(TAB_FINDTANSACTION_XPATH)).isDisplayed();
	}
	
	public String getSavings(){
		
	
	//	getFirstSelectedOption - isSelected method of select class which returns the first selected option from dropdown
		
		return selectDropdown().getFirstSelectedOption().getText();
	}
	public String getDateDetails(){
		return driver.findElement(By.xpath(TABLE_DATE_XPATH)).getText();
	}
	
	public String getDescription(){
		return driver.findElement(By.xpath(TABLE_DESCRIPTION_XPATH)).getText();
	}
	
	public String getDesposite(){
		return driver.findElement(By.xpath(TABLE_DEPOSITE_XPATH)).getText();
	}
	
	public String getWithdrawal(){
		return driver.findElement(By.xpath(TABLE_WITHDRAWAL_XPATH)).getText();
	}
	
	public void selectLoanAccount(){
	/*	WebElement dropdown=driver.findElement(By.xpath(DROPDOWN_XPATH));
		Select select=new Select(dropdown);
	*/	
		selectDropdown().selectByVisibleText("Loan");
		
		/*List<WebElement> list=select.getOptions();
		int a=list.size();
		String b=null;
		for(int i=0;i<a;i++){
			b=list.get(3).getText();
		}
		return b;*/
	}
	// Test Case No - AccActShow_03 - Verify each transaction's Description should be RENT from table
	
	public String getRowdata(){
		
		String FIRST_PART=".//*[@id='all_transactions_for_account']/table/tbody/tr[";
		String SECOND_PART="]/td[";
		String THIRD_PART="]";
		String TABLE_DATA=null;
		
		int row_count=driver.findElements(By.xpath(".//*[@id='all_transactions_for_account']/table/tbody/tr")).size();
		long col_count=driver.findElements(By.xpath(".//*[@id='all_transactions_for_account']/table/tbody/tr[1]/td")).size();
		// used for loop to get number of row
		
		for(int i=1;i<row_count;i++)
		{
			for(int j=1;j<col_count;j++)
			{
			String FINAL_XPATH=FIRST_PART+i+SECOND_PART+j+THIRD_PART;
			TABLE_DATA=driver.findElement(By.xpath(FINAL_XPATH)).getText();
			
			if(TABLE_DATA.equalsIgnoreCase("RENT"))
			{
				break;
			}
		}
		}
		return TABLE_DATA;
	}
	public String getCreditCard(){
		
		selectDropdown().selectByIndex(6);
		
		return driver.findElement(By.xpath(CREDIT_CARD_TABLE_CLASS)).getText();
		
	}
	
	public String selectCheckingAccount(){
		
		/*WebElement dropdown1=driver.findElement(By.xpath(DROPDOWN_XPATH));
		Select sel= new Select(dropdown1);*/
		
		selectDropdown().selectByVisibleText("Checking");
		
		return driver.findElement(By.xpath(DATE_CHECKING_XPATH)).getText();	
	}
	
	public String getCheckingRow(){
		
		String CARPAYMENT_ROW_XPATH=".//*[@id='all_transactions_for_account']/table/tbody/tr[3]";
		
		return driver.findElement(By.xpath(CARPAYMENT_ROW_XPATH)).getText();
	}
}