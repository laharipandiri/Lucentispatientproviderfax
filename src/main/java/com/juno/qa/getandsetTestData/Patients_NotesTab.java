package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Patients_NotesTab {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetPatientsNotesCallerDropdownValues(String Key, int rowNum)
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
	
	public List<String> GetPatientsNotesReasonDropdownValues(String Key, int rowNum)
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
