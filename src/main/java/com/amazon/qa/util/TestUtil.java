package com.amazon.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.amazon.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String TestDataSheetPath = "C:\\Users\\meenal.s\\eclipse-workspace\\AmazonTest\\"
			+ "src\\main\\java\\com\\amazon\\qa\\data\\AmazonTestData.xlsx";
	
	public static void PageLoadTimeout (WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	public static void ImplicitlyWait (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] GetTestData(String sheetName){
		
		FileInputStream file = null;
		try {
				file = new FileInputStream(TestDataSheetPath);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
				
		try { 
				book = WorkbookFactory.create(file);
		} catch(InvalidFormatException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		sheet = book.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int row=0; row <sheet.getLastRowNum(); row++) {
			for (int col=0; col< sheet.getRow(0).getLastCellNum(); col++) {
				Cell cell = sheet.getRow(row+1).getCell(col);
				if(cell == null) {
					data[row][col] = "";
				} else {
					if (cell.getCellType() == CellType.STRING) {
						data[row][col] = cell.toString();
					}else {
						if(cell.getCellType() == CellType.NUMERIC) {
							data[row][col] = String.valueOf(cell.getNumericCellValue());
						}
					}
	
				
				}
				
				
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
