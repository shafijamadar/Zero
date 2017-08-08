package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileNewWay {

	// this class is explicity written to load property file with different approach
	
	public Properties prop=null;
	
	public void property() {
		
			if(prop ==null){
				prop= new Properties();
			}
			
	try{
		
	  File file= new File(System.getProperty("User.dir")+"\\src\\test\\resources\\configs\\config.properties");
//		C:\Users\Mohammadshafi\workspace\com.ZeroSecurity\src\test\resources\configs\config.
		
	FileInputStream fs=new FileInputStream(file);
	prop.load(fs);
	}
	catch(Exception e){
		e.getMessage();
		e.printStackTrace(); 	
	}
}
}
