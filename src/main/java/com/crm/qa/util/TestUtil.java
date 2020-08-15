package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.io.FileUtils;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	static Workbook book;
	static Sheet    sheet;

	public static String TESTDATA_SHEET_PATH = "C:/Users/Chetan Chauhan/eclipse-workspace/FreeCRMPOM/src/main/java/com/crm/qa/testdata/Free CRM Test Data.xlsx";
	
	public static Object[][] getTestData(String sheetName) throws IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException ex) {
			ex.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+currentDir);
		//String currentDir = System.getProperty("user.dir");
		
			FileUtils.copyFile(srcFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
		}
	
}
