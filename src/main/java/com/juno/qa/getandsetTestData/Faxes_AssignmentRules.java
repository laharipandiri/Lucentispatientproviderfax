package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Faxes_AssignmentRules {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetAssignmentRulesNCreateTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//User								
			testData.add(1, row.getCell(2).toString());//StartTime
			testData.add(2, row.getCell(3).toString());//EndTime
			testData.add(3, NumberToTextConverter.toText(row.getCell(4).getNumericCellValue()));//DailyMax
			testData.add(4, row.getCell(6).toString());//CatchOutsideHoursN
			testData.add(5, row.getCell(7).toString());//add confirmation msg
			testData.add(6, row.getCell(13).toString());//Statusdropdownvalue
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAssignmentRulesYCreateTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//User								
			testData.add(1, NumberToTextConverter.toText(row.getCell(4).getNumericCellValue()));//DailyMax
			testData.add(2, row.getCell(5).toString());//CatchOutsideHoursY
			testData.add(3, row.getCell(7).toString());//add confirmation msg
			testData.add(4, row.getCell(13).toString());//Statusdropdownvalue
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAssignmentRulesGridLabels(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(8).toString());//StartTimeLabel				
			testData.add(1, row.getCell(9).toString());//EndTimeLabel
			testData.add(2, row.getCell(10).toString());//CatchoutsideHoursLabel
			testData.add(3, row.getCell(11).toString());//DailyMaxLabel
			testData.add(4, row.getCell(12).toString());//StatusLabel
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAssignmentRulesFieldValidationMsgs(String Key, int rowNum)
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
	
	public List<String> GetAssignmentRulesUpdateTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//StartTime		
			testData.add(1, row.getCell(2).toString());//EndTime
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//DailyMax
			testData.add(3, row.getCell(4).toString());//UpdateConfirmationMsg
			testData.add(4, row.getCell(5).toString());//RemoveConfirmationMsg
			testData.add(5, row.getCell(6).toString());//CatchOutsideHoursYToN
			testData.add(6, row.getCell(7).toString());//CatchOutsideHoursY


			return testData;
		}
		
		return null;
	}

}
