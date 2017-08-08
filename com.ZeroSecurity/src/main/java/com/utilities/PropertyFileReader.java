package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
	private static Properties prop=null;
	private static File file=null;
		
	public static String getProperty(String propertyame)
	{
		if(prop!=null)
			return prop.getProperty(propertyame);
			return null;
	}
	
	private void getFile(){
		ClassLoader classloader = getClass().getClassLoader();
		file = new File(classloader.getResource("configs/config1.properties").getFile());
	}
	
	public static void loadProperties(){
		prop = new Properties();
		InputStream input = null;
	
		try{
			PropertyFileReader propertyFileReader= new PropertyFileReader();
			propertyFileReader.getFile();
			
			input = new FileInputStream(file);
			//load a properties file
			prop.load(input);
			
		}catch (IOException ex){
			ex.printStackTrace();
		}finally {
			if(input !=null) {
		}
	}
}
}