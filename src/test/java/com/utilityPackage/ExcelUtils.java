package com.utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static FileInputStream fi;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow rw;
	static XSSFCell cl;
	
/*
 *  This method is used for getting the cell data from the excel file. 
 *  
 */	
	
	
	public static Object[][] readExcelData(String sheetname) throws IOException {
	fi = new FileInputStream("C:\\Users\\LinuVarghese\\Documents\\Selenium-Automation\\AutomationFramework\\testData\\ProjectName_TestData File.xlsx");
	wb= new XSSFWorkbook(fi);
	sheet= wb.getSheet(sheetname);
	int rowCount= sheet.getLastRowNum();
	int cellCount=sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rowCount][cellCount];
	
	for(int i=1; i<=rowCount;i++) {
		rw=sheet.getRow(i);
		
		for (int j=0;j<cellCount;j++) {
		cl=rw.getCell(j);
		
		data[i-1][j]=cl !=null ? cl.toString(): "";
		}		
	}
	wb.close();
	fi.close();
	return data;
	}
}


