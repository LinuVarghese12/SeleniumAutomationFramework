package com.testCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.pageObjects.Page_01_Login;
import com.utilityPackage.DataProviderUtils;
import com.utilityPackage.ExcelUtils;

import baseClass.BaseClass;

public class Test_01_Login extends BaseClass {

	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
	public void userLogin(String username, String password) throws InterruptedException, IOException {

	    Page_01_Login login = new Page_01_Login(driver);

	    login.sendUserName(username);
	    login.sendPassword(password);
	    login.clickLoginButton();

	    Thread.sleep(Duration.ofSeconds(2));

	    if (login.isLoginFailed()) {
	    	login.closeAuthenticationPopup();
	        System.out.println("❌ Login failed for: " + username + " | " + password);
	        login.clearUsername();
	        login.clearPassword();
	    } else {
	        System.out.println("✅ Login successful for: " + username + " | " + password);
	    }

	    Thread.sleep(Duration.ofSeconds(1));
	}

	
	
	
	
}
