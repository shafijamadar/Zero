package com.scripts;

import org.testng.annotations.Test;

import com.applicationPages.HomePage;
import com.utilities.ExcelUtils;

import org.testng.annotations.DataProvider;

public class ExcelTest {
	
  @Test(dataProvider = "getData")
  public void verifyLogin(String username, String password) {

	//  HomePage page=new HomePage(driver);
	  System.out.println("TESTNG CALLED METHODS "+username + "" +password );
	  // to get only row	  
  }

  @DataProvider(name="getData")
  
  public Object[][] dp() {
  
	  ExcelUtils excelUtils=new ExcelUtils();
	  excelUtils.openExcel("DataTest4.xls", "Sheet1");
	  
	  Object [][] data=excelUtils.getAllRows();
	  excelUtils.closeExcel();
	  return data;
	  
	  /*return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      */
	  }
  
  @Test
  public void singleRow() {
	  ExcelUtils excelUtils=new ExcelUtils();
	  excelUtils.openExcel("DataTest4.xls", "Sheet1");
	  
	  String[] data=excelUtils.getRowData(1);
	//  excelUtils.getCellData(0, 2);
	  excelUtils.closeExcel();
	  System.out.println("Single row username "+data[0]+ "password" +data[1]);
  }
  }
