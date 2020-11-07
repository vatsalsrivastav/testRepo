package com.selenium.setup;        //Do not change the package name

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {        //Do not change the class name

	public static String[] excelData1=new String[9];
	
	public static String[] readExcelData(String sheetName) throws Exception {
	   //Get the excel file path
	   //Using the sheet name passed to this method, read the data and store it in a string array.
	   //Return the array. Only one row in the excel sheet so keep 'row' as 0.
	   //Store only the column value in the array.
		
		FileInputStream file = new FileInputStream("UserRegistration/src/FormRegistration.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);;
		XSSFCell clm;
		for(int i=0;i<9;i++)
		{
			clm = row.getCell(i);
			excelData1[i] = clm.toString();
		}
		workbook.close();
		return excelData1;
		
	}

}