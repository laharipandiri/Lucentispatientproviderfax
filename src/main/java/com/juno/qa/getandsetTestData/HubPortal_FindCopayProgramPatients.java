package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class HubPortal_FindCopayProgramPatients extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetNoDataFoundSearchData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//														
			testData.add(0, row.getCell(1).toString());//LastName			
			testData.add(1, NumberToTextConverter.toText(row.getCell(2).getNumericCellValue()));//ParrtnerPatientID																	
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//MemberID
			testData.add(3, row.getCell(4).toString());//Msg
			return testData;
		}
		
		return null;
	}

}
