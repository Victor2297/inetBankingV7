package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver driver;
	@FindBy(xpath =  "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(name = "name")
	WebElement customerName;
	@FindBy(name = "dob")
	WebElement birthDate;
	@FindBy(name = "addr")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "state")
	WebElement state;
	@FindBy(name = "pinno")
	WebElement pin;
	@FindBy(name = "telephoneno")
	WebElement mobileNumber;
	@FindBy(name = "emailid")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "sub")
	WebElement submitButton;
	
	public NewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomer() {
		newCustomer.click();
	}
	public void setCustomerName(String cName) {
		customerName.sendKeys(cName);
	}
	public void setBirthDate(String bd) {
		birthDate.sendKeys(bd);
	}
	public void setAddress(String newAddress) {
		address.sendKeys(newAddress);
	}
	public void setCity(String newCity) {
		city.sendKeys(newCity);
	}
	public void setState(String newState) {
		state.sendKeys(newState);
	}
	public void setPin(String newPin) {
		pin.sendKeys(newPin);
	}
	public void setMobileNumber(String newNumber) {
		mobileNumber.sendKeys(newNumber);
	}
	public void setEmail(String newEmail) {
		email.sendKeys(newEmail);
	}
	public void setPassword(String newPassword) {
		password.sendKeys(newPassword);
	}
	public void submitForm() {
		submitButton.click();
	}
}