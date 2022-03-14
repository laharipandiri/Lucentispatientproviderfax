package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class HubPortal_ListAllCopayProgramPatient extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> ListAllCopayProgramPatientsPageContentData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//														
			testData.add(0, row.getCell(1).toString());//PageHeading
			testData.add(1, row.getCell(2).toString());//ShowingLabel																	
			testData.add(2, row.getCell(3).toString());//MemberIDCol
			testData.add(3, row.getCell(4).toString());//LastNameCol
			testData.add(4, row.getCell(5).toString());//FirstNameCol
			testData.add(5, row.getCell(6).toString());//Address
			testData.add(6, row.getCell(7).toString());//PartnerPatientID
			testData.add(7, row.getCell(8).toString());//Status
			testData.add(8, row.getCell(9).toString());//Action
			testData.add(9, row.getCell(10).toString());//MemberIDSort
			testData.add(10, row.getCell(11).toString());//LastNameSort
			testData.add(11, row.getCell(12).toString());//FirstNameSort
			testData.add(12, row.getCell(13).toString());//AddressSort
			testData.add(13, row.getCell(14).toString());//PartnerPatientIDSort
			testData.add(14, row.getCell(15).toString());//StatusSort
			testData.add(15, row.getCell(16).toString());//StatusSort

			 
			return testData;
		}
		 
		return null;
	}
	
	

}
