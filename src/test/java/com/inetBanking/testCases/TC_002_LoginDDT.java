package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_002_LoginDDT extends BaseClass {
	@Test(dataProvider = "Data", dataProviderClass = ClassDataProvider.class)
	public void loginDDT(String UID, String pass) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(UID);
		logger.info("Entered username");
		lp.setPassword(pass);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		if(this.isAlertPresent() == true) {
			String text = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			logger.info("Test failed - " + text);
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Manger Id : " + UID)) {
				lp.scrollPage();
				lp.clickOnLogoutButton();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				logger.info("Test Passed");
				Assert.assertTrue(true);
			}
			else {
				lp.scrollPage();
				lp.clickOnLogoutButton();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				logger.info("Test failed - wrong name");
				Assert.assertTrue(false);
			}
		}
	}
	
}