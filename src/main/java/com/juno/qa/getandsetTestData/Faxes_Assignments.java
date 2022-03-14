package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Faxes_Assignments {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetFaxCountWrongMsgTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//FaxCountOne				
			testData.add(1, row.getCell(2).toString());//FaxIDListOne
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//FaxCountTwo
			testData.add(3, NumberToTextConverter.toText(row.getCell(4).getNumericCellValue()));//FaxIDListTwo
			testData.add(4, row.getCell(5).toString());//CountErrorMsg
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAssignmentsFieldsRequiredMsgTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//Iterate through each cell in the current row
			 Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	             Cell  cell = cellIterator.next();
	               testData.add(cell.getStringCellValue());//the value at 0th index will be the key element value
	         }
			/* for(String data: testData) {
					System.out.println("data :"+data);
				} */
				
			 return testData;
				
				
		}
		return null;
		
		
	}
	
	public List<String> GetReqFieldsMsgTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{			
			testData.add(0, row.getCell(1).toString());//FaxCountOrListReq		
			testData.add(1, row.getCell(2).toString());//UserReq
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Fax#
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetFaxIDDoesNotExistMsgTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{			
			testData.add(0, row.getCell(1).toString());//ErrorMsg	
			testData.add(1, NumberToTextConverter.toText(row.getCell(2).getNumericCellValue()));//Fax#
			testData.add(2, row.getCell(3).toString());//FromUser		
			testData.add(3, row.getCell(4).toString());//ToUser
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetMarkAsOutTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{			
			testData.add(0, row.getCell(1).toString());//FromDate	
			testData.add(1, row.getCell(2).getDateCellValue().toString());//ToDate	
			testData.add(2, row.getCell(3).toString());//cancelout text	
			testData.add(3, row.getCell(4).toString());//markasout text	
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetReassignFaxTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//FaxIDCol	
			testData.add(1, row.getCell(2).toString());//AssignedToColBeforeValue				
			testData.add(2, row.getCell(3).toString());//EnrollFromDate	
			testData.add(3, row.getCell(4).toString());//FromUser 	
			testData.add(4, row.getCell(5).toString());//ToUser
			testData.add(5, row.getCell(6).toString());//AssignedToColAfterValue
			testData.add(6, row.getCell(7).toString());//FaxAssignedConfirmationMsg

			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAssignmentsPageColsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//Iterate through each cell in the current row
			 Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	             Cell  cell = cellIterator.next();
	               testData.add(cell.getStringCellValue());//the value at 0th index will be the key element value
	         }
			/* for(String data: testData) {
					System.out.println("data :"+data);
				} */
				
			 return testData;
				
				
		}
		return null;
		
		
	}

}
