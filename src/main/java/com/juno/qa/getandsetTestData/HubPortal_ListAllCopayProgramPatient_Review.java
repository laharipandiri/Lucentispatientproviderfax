package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class HubPortal_ListAllCopayProgramPatient_Review extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetPhysicianInfoTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																									
			testData.add(0, row.getCell(1).toString());//TypeCol
			testData.add(1, row.getCell(2).toString());//LocationNameCol																	
			testData.add(2, row.getCell(3).toString());//NameCol
			testData.add(3, row.getCell(4).toString());//AddressCol
			testData.add(4, row.getCell(5).toString());//LinkTypeCol
			testData.add(5, row.getCell(6).toString());//InfoCol
			testData.add(6, row.getCell(7).toString());//TypeValue
			testData.add(7, row.getCell(8).toString());//LocationNameValue
			testData.add(8, row.getCell(9).toString());//NameValue
			testData.add(9, row.getCell(10).toString());//AddressValue
			testData.add(10, row.getCell(11).toString());//InfoValue
			testData.add(11, row.getCell(12).toString());//PhysicianLabel
			
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetEnrollmentsTableColTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																													
			testData.add(0, row.getCell(1).toString());//ActiveCol
			testData.add(1, row.getCell(2).toString());//EnrollDateCol																	
			testData.add(2, row.getCell(3).toString());//ExpirationDateCol
			testData.add(3, row.getCell(4).toString());//LookBackDateCol
			testData.add(4, row.getCell(5).toString());//EnrollmentLabel
			
			
			return testData;
		}
		 
		return null;
	}

}
