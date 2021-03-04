package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		Thread.sleep(3000);
		
		if(this.isAlertPresent() == true) {
			String v = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			logger.info("Test failed " + v);
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Manger Id : "+ username)) {
			logger.info("Test Passed");
			Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "loginTest");
				logger.info("Test Failed");
				Assert.assertTrue(false);
			}
		}
	}
}