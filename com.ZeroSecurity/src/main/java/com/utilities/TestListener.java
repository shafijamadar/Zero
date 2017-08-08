package com.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{
	
	WebDriver driver;
	
	Logger logger=LogManager.getLogger(this.getClass().getName());
	
	private static String fileSeperator = System.getProperty("file.separator");
			
			@Override
			public void onTestFailure(ITestResult result){
				
			logger.info("Test failed Screenshot Captured");
			System.out.println("**** " + result.getName() + " has failed ****");
			driver = SeleniumUtils.getDriver();
			
			String testClassName = getTestClassName(result.getInstanceName().trim());
			
			String testMethodName = result.getName().toString().trim();
			String screenShotName = testMethodName + ".png";
			
			if(driver !=null){
				String imagePath= ".." + fileSeperator + "Screenshots" + fileSeperator + "Results" + fileSeperator + testClassName 
						+ fileSeperator + takeScreenShot(driver, screenShotName, testClassName);
				
				System.out.println("Screenshot: " +imagePath);
			
				}
			}
			
			private static String takeScreenShot(WebDriver driver, String screenShotName, String testClassName){
				try
				{
					File file = new File("Screenshots" + fileSeperator + "Results");
					if(!file.exists()){
						file.mkdirs();
						
				}
					
					File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + testClassName, screenShotName);
							
					FileUtils.copyFile(screenshotFile, targetFile);
					
					return screenShotName;
					
				} catch(Exception e){
					System.out.println("An exception occured while taking screenshot" + e.getCause());
					return null;
				}
			}
			
			private String getTestClassName(String testName) {
				String[] reqTestClassname = testName.split("\\.");
				int i=reqTestClassname.length -1;
				return reqTestClassname[i];
				}
}