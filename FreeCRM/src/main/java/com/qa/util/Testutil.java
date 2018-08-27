package com.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.TestBase.TestBase;

public class Testutil extends TestBase{

	
	public static long PAGE_LOAD_TIME=60;
	public static long IMPLICITLY_WAIT=40;
	
	public static String datasheet="C:\\Users\\amit\\eclipse-workspace\\FreeCRM"
			+ "\\src\\main\\java\\com\\qa\\TestData\\Testdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshot() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\amit\\eclipse-workspace\\FreeCRM\\src\\main"
				+ "\\java\\"+System.currentTimeMillis()+".png"));
	}
	
	public static Object[][] gettestdata(String sheetName){
		FileInputStream file= null;
		try {
			file=new FileInputStream(datasheet);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
				book=WorkbookFactory.create(file);
			}catch (InvalidFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet=book.getSheet(sheetName);
		Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++)
		{
			for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
			
				data[i][j] =sheet.getRow(i+1).getCell(j).toString();
				
				}
		}
		return data;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
