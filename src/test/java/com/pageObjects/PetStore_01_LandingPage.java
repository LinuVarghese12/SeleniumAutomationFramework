package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PetStore_01_LandingPage extends BasePage{

	public PetStore_01_LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@id=\"LogoContent\"]//a//img")
	WebElement headerLogo;
	
	@FindBy(xpath="//img[@name=\"img_cart\"]")
	WebElement cartIcon;
	
	@FindBy(xpath="//div//a[text()=\"Sign In\"]")
	WebElement signInButton;
	
	public void checkHeaderLogoVisibility() throws InterruptedException {
		Thread.sleep(3000);
		boolean buttonVisibility= headerLogo.isDisplayed();
		Assert.assertEquals(buttonVisibility, true);
	}	
	public void checkCartIconClickable() throws InterruptedException {
		boolean cartbuttonClickable= cartIcon.isEnabled();
		Assert.assertEquals(cartbuttonClickable, true);
		Thread.sleep(3000);
		cartIcon.click();
	}
	
	public void clickSignInButton() throws InterruptedException {
		Thread.sleep(3000);
		boolean buttonVisibility= signInButton.isEnabled();
		Assert.assertEquals(buttonVisibility, true);
		signInButton.click();
	}
}