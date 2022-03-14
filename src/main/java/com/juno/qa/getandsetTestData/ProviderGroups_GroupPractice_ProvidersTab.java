package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProviderGroups_GroupPractice_ProvidersTab {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetPGSupervisorDataForGP(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//SupervisorName												
			testData.add(1, row.getCell(2).toString());//SupervisorLastName
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//SupervisorNPI	
			testData.add(3, row.getCell(4).toString());//AddConfirmationMsg
			testData.add(4, row.getCell(5).toString());//SupervisorName							
			testData.add(5, row.getCell(6).toString());//ContactName
			testData.add(6, row.getCell(7).toString());//Address
			testData.add(7, row.getCell(8).toString());//City
			testData.add(8, row.getCell(9).toString());//State
			testData.add(9, row.getCell(10).toString());//Zip
			//testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//Zip
			testData.add(10, row.getCell(11).toString());//Territory
			testData.add(11, row.getCell(12).toString());//ProviderType
			testData.add(12, row.getCell(13).toString());//GPLastName
			return testData;
		}
		 
		return null;
	}

}
