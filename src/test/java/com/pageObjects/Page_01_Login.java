package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page_01_Login extends BasePage{

	public Page_01_Login(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement userNameField;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passWordField;

	@FindBy(xpath="//button[@id='LoginBtn']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[text()=\"Username or password is wrong.\"]")
	WebElement errorMessage;
	
	@FindBy(xpath="//button[text()=\"OK\"]")
	WebElement okButtonClick;
	
	public void sendUserName(String username) {
		userNameField.sendKeys(username);
	}
	
	public void sendPassword(String password) {
		passWordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clearUsername() {
	    userNameField.clear(); // replace with your actual field locator
	}

	public void clearPassword() {
	    passWordField.clear(); // replace with your actual field locator
	}

	public boolean isLoginFailed() {
	    return driver.getPageSource().contains("Invalid credentials") 
	           || errorMessage.isDisplayed(); // use real logic here
	}
	public void closeAuthenticationPopup() {
		okButtonClick.click();
	}

}
