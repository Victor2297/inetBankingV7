package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name = "uid")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "btnLogin")
	WebElement loginButton;
	@FindBy(xpath = "//*[@href=\"Logout.php\"]")
	WebElement logoutButton;
	JavascriptExecutor js;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void setUsername(String uName) {
		username.sendKeys(uName);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
	}
}
