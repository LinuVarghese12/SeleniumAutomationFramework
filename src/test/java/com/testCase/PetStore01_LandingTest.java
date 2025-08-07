package com.testCase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageObjects.PetStore_02_Cart;
import com.pageObjects.PetStore_01_LandingPage;

import baseClass.BaseClass;

public class PetStore01_LandingTest extends BaseClass{

	PetStore_01_LandingPage lp;
	PetStore_02_Cart ct;
	
	@Test(priority=0)
	public void verifyLandingPageNavigation() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}
	
	
	@Test(priority=1)
	public void verifyHeaderLogoIsVisible() throws InterruptedException {
		lp = new PetStore_01_LandingPage(driver);
		lp.checkHeaderLogoVisibility();
	}
	
	@Test(priority=2)
	public void verifyCartIsClickable() throws InterruptedException {
		ct= new PetStore_02_Cart(driver);
		lp= new PetStore_01_LandingPage(driver);
		lp.checkCartIconClickable();
		ct.verifyCartPageNavigation();
	}
	
	public void verifySignInButtonIsClickable() throws InterruptedException {
		lp= new PetStore_01_LandingPage(driver);
		lp.clickSignInButton();
	}
	
}
