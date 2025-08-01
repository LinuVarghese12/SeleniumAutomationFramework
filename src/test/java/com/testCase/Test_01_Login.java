package com.testCase;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pageObjects.Page_01_Login;
import com.utilityPackage.DataProviderUtils;


import baseClass.BaseClass;

public class Test_01_Login extends BaseClass {

	private static final Logger log = LogManager.getLogger(Test_01_Login.class);
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
	public void userLogin(String username, String password) throws InterruptedException, IOException {

	    Page_01_Login login = new Page_01_Login(driver);

	    login.sendUserName(username);
	    login.sendPassword(password);
	    login.clickLoginButton();
	    
	    Thread.sleep(Duration.ofSeconds(2));

	    if (login.isLoginFailed()) {
	    	login.closeAuthenticationPopup();
	        log.debug("Login failed due to invalid username or password");
	        login.clearUsername();
	        login.clearPassword();
	    } else {
	        System.out.println("✅ Login successful for: " + username + " | " + password);
	    }

	    Thread.sleep(Duration.ofSeconds(1));
	    
	   
	   
	}	
}
