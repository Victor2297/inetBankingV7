package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	String username = readConfig.getUsername();
	String password = readConfig.getPassword();
	String baseUrl = readConfig.getBaseUrl();
	Logger logger;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) throws Exception {
		logger = Logger.getLogger("log");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDriverPath());
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Wrong browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	public void captureScreen(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\";
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath + methodName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("Screenshot was taken");
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}