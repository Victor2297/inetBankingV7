package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomer;

public class TC_003_NewCustomerTest extends BaseClass {
	@Test
	public void createNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		NewCustomer nc = new NewCustomer(driver);
		nc.openNewCustomer();
		logger.info("New Customer page is opened");
		lp.scrollPage();
		lp.scrollPage();
		nc.setCustomerName("VghjV");
		logger.info("Customer name is entered");
		nc.setBirthDate("12222021");
		logger.info("birth date is entered");
		nc.setAddress("SDFGHJKLFGGHJdfgh FTYklV");
		logger.info("Address is added");
		nc.setCity("Chisinau");
		logger.info("City is added");
		nc.setState("MD");
		logger.info("State is added");
		nc.setPin("123123");
		logger.info("Pin is entered");
		nc.setMobileNumber("34567456722");
		logger.info("Mobile number is added");
		String email = this.getRandomAlphabeticString();
		nc.setEmail(email + "@gmail.com");
		logger.info("Email is added");
		nc.setPassword("234567vc");
		logger.info("Password is entered");
		nc.submitForm();
		logger.info("Form is submitted");
		
		Thread.sleep(1000);
		
		if(this.isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "createNewCustomer");
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "createNewCustomer");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}