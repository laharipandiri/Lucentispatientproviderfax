package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Patients_FaxInfoTab {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetPatientsFaxInfoTabGridCols(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(19).getNumericCellValue()));//MemberID
			testData.add(1, row.getCell(1).toString());//CardIDCol																	
			testData.add(2, row.getCell(2).toString());//FaxTypeCol
			testData.add(3, row.getCell(3).toString());//ANICol
			testData.add(4, row.getCell(4).toString());//TypeCol
			testData.add(5, row.getCell(5).toString());//IDCol
			testData.add(6, row.getCell(6).toString());//FileCol
			testData.add(7, row.getCell(7).toString());//TimeCol
			testData.add(8, row.getCell(8).toString());//StatusCol
			testData.add(9, row.getCell(9).toString());//OutAniCol
			testData.add(10, row.getCell(10).toString());//AmountCol
			testData.add(11, row.getCell(11).toString());//ActionCol
			testData.add(12, row.getCell(12).toString());//ReviewedDateCol
			testData.add(13, row.getCell(13).toString());//ApprovedAmountCol
			testData.add(14, row.getCell(14).toString());//ApprovedDateCol
			testData.add(15, row.getCell(15).toString());//AssignedToCol
			testData.add(16, row.getCell(16).toString());//AssignedDateCol
			testData.add(17, row.getCell(17).toString());//NotesCol
			testData.add(18, row.getCell(18).toString());//ActionCol
			 
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientsFaxInfoTabGridColsForAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(19).toString());//MemberID
			testData.add(1, row.getCell(1).toString());//CardIDCol																	
			testData.add(2, row.getCell(2).toString());//FaxTypeCol
			testData.add(3, row.getCell(3).toString());//ANICol
			testData.add(4, row.getCell(4).toString());//TypeCol
			testData.add(5, row.getCell(5).toString());//IDCol
			testData.add(6, row.getCell(6).toString());//FileCol
			testData.add(7, row.getCell(7).toString());//TimeCol
			testData.add(8, row.getCell(8).toString());//StatusCol
			testData.add(9, row.getCell(9).toString());//OutAniCol
			testData.add(10, row.getCell(10).toString());//AmountCol
			testData.add(11, row.getCell(11).toString());//ActionCol
			testData.add(12, row.getCell(12).toString());//ReviewedDateCol
			testData.add(13, row.getCell(13).toString());//ApprovedAmountCol
			testData.add(14, row.getCell(14).toString());//ApprovedDateCol
			testData.add(15, row.getCell(15).toString());//AssignedToCol
			testData.add(16, row.getCell(16).toString());//AssignedDateCol
			testData.add(17, row.getCell(17).toString());//NotesCol
			testData.add(18, row.getCell(18).toString());//ActionCol
			 
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientsFaxInfoLinksTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//cardID
			testData.add(1, row.getCell(2).toString());//URL																	
			
			 
			return testData;
		}
		 
		return null;
	}

}
