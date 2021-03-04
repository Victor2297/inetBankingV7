package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig(){
		File file = new File("C:\\Users\\Victor\\eclipse-workspace\\inetBankingV7\\Configuration\\config.properties");
		try {
		FileInputStream myFile = new FileInputStream(file);
		p = new Properties();
		p.load(myFile);
		}
		catch(Exception e) {
			
		}
	}
	public String getUsername() {
		String username = p.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
	public String getChromeDriverPath() {
		String chDriverP = p.getProperty("chromeDriverPath");
		return chDriverP;
	}
	public String getFirefoxDriverPath() {
		String ffDriverP = p.getProperty("firefoxDriverPath");
		return ffDriverP;
	}
	public String getBaseUrl() {
		String baseUrl = p.getProperty("baseUrl");
		return baseUrl;
	}
	
	
	
}