package com.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public Properties properties;
	public final String propertyFilePath= "./src/test/resource/configs/config.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	public String getBrowser(){
		String browerInput = properties.getProperty("browser");
		if(browerInput!= null) return browerInput;
		else throw new RuntimeException("browerInput not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getMyStoreApplicationUrl() {
		String url = properties.getProperty("mystoreURL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getUserName() {
		String userName = properties.getProperty("userName");
		if(userName != null) return userName;
		else throw new RuntimeException("userName not specified in the Configuration.properties file.");
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	
	public String getOpenCartApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getOpenCartUserName() {
		String userName = properties.getProperty("username");
		if(userName != null) return userName;
		else throw new RuntimeException("userName not specified in the Configuration.properties file.");
	}
	
	public String getOpenCartPassword() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
}
