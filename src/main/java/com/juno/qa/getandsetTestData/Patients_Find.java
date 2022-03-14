package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Patients_Find extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetPatientsFindFieldDropdownDefaultValues(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
	         }
			 
			 return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientsFindPageSearchgridCols(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
	         }
			 
			 return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientTestDataForSearch(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());
			
			return testData;
		}
		return null;
	}
}
