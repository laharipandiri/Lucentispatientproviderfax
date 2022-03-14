package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProviderGroups_Supervisors_PatientsTab extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetPGSupervisorsAndPatientMappingTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//SupervisorsNPI
			//The following fields are the column names in the Patients tab of BO page											
			testData.add(1, row.getCell(2).toString());//ActivationDate
			testData.add(2, row.getCell(3).toString());//PatientName
			testData.add(3, row.getCell(4).toString());//City
			testData.add(4, row.getCell(5).toString());//State
			testData.add(5, row.getCell(6).toString());//Zip
			testData.add(6, row.getCell(7).toString());//MemberID
			testData.add(7, row.getCell(8).toString());//PatientPartnerID
			testData.add(8, row.getCell(9).toString());//CRXPhysicianID
			testData.add(9, row.getCell(10).toString());//CardID
			testData.add(10, row.getCell(11).toString());//ProviderNameType
			testData.add(11, row.getCell(12).toString());//Action
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPGSupervisorsPatientDataForPatientAndCardInfo(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//The following fields are the patient data that we captured from the patients tab in Providers page onto the excel to be cross checked with the patient and card info page
			testData.add(0, row.getCell(14).toString());//PatientNameValue						
			testData.add(1, row.getCell(15).toString());//CityValue
			testData.add(2, row.getCell(16).toString());//stateValue
			testData.add(3, row.getCell(17).toString());//ZipValue
			testData.add(4, row.getCell(18).toString());//MemberIDValue
			testData.add(5, row.getCell(19).toString());//PartnerPatientIDValue
			testData.add(6, row.getCell(20).toString());//CardIDValue
			testData.add(7, row.getCell(21).toString());//providernametypevalue
			testData.add(8, row.getCell(13).toString());//activation date
			
			
			return testData;
		}
		
		return null;
	}

}
