package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Faxes_Incoming {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetIncomingFaxesFindPageSearchGridCols(String Key, int rowNum)
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
	
	public List<String> GetIncomingFaxesSearchTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID	
			testData.add(1, NumberToTextConverter.toText(row.getCell(2).getNumericCellValue()));//Fax#
			testData.add(2, row.getCell(3).toString());//enrollfromdate
			testData.add(3, row.getCell(4).toString());//ReviewFaxPageURL
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetIncomingFaxesReviewPageDefaultDropdown(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Fax";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
		/*	Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
	         } */
			
			testData.add(0, row.getCell(1).toString());//Program
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//PatientState
			testData.add(5, row.getCell(6).toString());//ProviderState
			testData.add(6, row.getCell(7).toString());//FaxLabel
			testData.add(7, row.getCell(8).toString());//PatientLabel
			testData.add(8, row.getCell(9).toString());//ProviderLabel
			testData.add(9, row.getCell(10).toString());//EnrollFromDate 
			testData.add(10, row.getCell(11).toString());//FaxPageURL 
			testData.add(11, row.getCell(12).toString());//AdminReimbursementProgram 
			 
			 return testData;
		}
		
		return null;
	}
	
	public List<String> GetIncomingFaxesCloneFaxTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID	
			testData.add(1, NumberToTextConverter.toText(row.getCell(2).getNumericCellValue()));//Fax#
			testData.add(2, row.getCell(3).toString());//enrollfromdate
			testData.add(3, row.getCell(4).toString());//Type		
			testData.add(4, row.getCell(5).toString());//File
			testData.add(5, row.getCell(6).toString());//Time
			testData.add(6, row.getCell(7).toString());//confirmationMsg
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetClonedFaxGridCols(String Key, int rowNum)
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

}
