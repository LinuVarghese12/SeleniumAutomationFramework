package com.utilityPackage;
import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviderUtils {

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() throws IOException {
	    return ExcelUtils.readExcelData("SignUp"); // sheet name from your Excel
	}

	
	
	}
