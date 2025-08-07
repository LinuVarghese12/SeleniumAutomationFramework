package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class PetStore_02_Cart  extends BasePage{

	public PetStore_02_Cart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div//h2[text()=\"Shopping Cart\"]")
	WebElement cartPageTitle;
	
	
	
	
	public void verifyCartPageNavigation() {
		boolean cartPageButtonVisibility=cartPageTitle.isDisplayed();
		Assert.assertEquals(cartPageButtonVisibility, true);
		
	}
	
	
}
