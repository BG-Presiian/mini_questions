package com.groupi.library.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class used to grab appropriate credentials from config.properties file. 
 * @author Sarah Hansen
 *
 */
public class DatabaseLogin {
	
	String result = "";
	InputStream inputStream;
	
	public String getLoginValue(String var) throws IOException{
		try {
			Properties prop = new Properties();
			//String propFileName = "config.properties";
			
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			inputStream = new FileInputStream("src/resources/config.properties");
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property file not found in the classpath");
			}
			
			result = prop.getProperty(var);
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
		return result;
	} 
}
