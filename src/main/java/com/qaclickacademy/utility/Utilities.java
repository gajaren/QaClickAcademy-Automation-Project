package com.qaclickacademy.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	public static long PAGE_LOAD_TIMEOUTS=10;
	public static long IMPLICIT_WAIT=20;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String path=System.getProperty("user.home") + "/EclipseProject/QaClickAcademy-Automation-Project/src/main/"
			+ "java/com/qaclickacademy/testdata/TestData.xlsx";
	public static String dateTime = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	
	
	public static Object[][] readExcelFile(String sheetname) throws IOException 
	{
		workbook=new XSSFWorkbook(path);
		sheet=workbook.getSheet(sheetname);
				
		int totalrows=sheet.getLastRowNum();
		int totalcol=sheet.getRow(0).getLastCellNum();
		
		Object data[][]=new Object [totalrows][totalcol];
		for( int i=0; i<totalrows;i++)
		{
			for (int j=0;j<totalcol;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	public static void takeScreenshots(WebDriver driver,String testname ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.home") + "\\workspace\\QAClickAcademy\\Screenshots\\" + testname + dateTime + ".png");
		FileHandler.copy(src, dest);
	}

}
