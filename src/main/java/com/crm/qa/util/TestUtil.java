package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public TestUtil() throws IOException {
	
		
	}
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestData(String sheetname) throws IOException {
		String excelPath="C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Data.csv";
		FileInputStream fis=new FileInputStream(excelPath);
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		HSSFSheet sheet=workbook.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	
	
}
