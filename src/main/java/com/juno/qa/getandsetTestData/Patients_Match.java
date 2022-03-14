package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Patients_Match {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetPatientMatchWithPhysicianTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			
			testData.add(0, row.getCell(1).toString());//PatientMemberID						
			testData.add(1, row.getCell(2).toString());//ProviderName
			testData.add(2, row.getCell(3).toString());//ProviderFirstName
			testData.add(3, row.getCell(4).toString());//ProviderLastName
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//ProviderNPI	
			testData.add(5, row.getCell(6).toString());//ProviderAddress
			testData.add(6, row.getCell(7).toString());//ProviderCity							
			testData.add(7, row.getCell(8).toString());//ProviderState
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//ProviderZip
			testData.add(9, row.getCell(10).toString());//ProviderPhone
			testData.add(10, row.getCell(11).toString());//PatientInfoLabel	
			testData.add(11, row.getCell(12).toString());//ProviderInfoLabel
			testData.add(12, row.getCell(13).toString());//ProviderType
			testData.add(13, row.getCell(14).toString());//ContactName
			testData.add(14, row.getCell(15).toString());//PrimaryLink		
			testData.add(15, row.getCell(16).toString());//SecondaryLink
			testData.add(16, row.getCell(17).toString());//LinkedConfirmationMsg
			testData.add(17, row.getCell(18).toString());//email
			testData.add(18, row.getCell(19).toString());//unlinkProviderMsg
			testData.add(19, NumberToTextConverter.toText(row.getCell(20).getNumericCellValue()));//ProviderID	
		//	testData.add(20, NumberToTextConverter.toText(row.getCell(21).getNumericCellValue()));//ParentProviderID
			
			
			return testData;
		}
		 
		return null;
	}

	public List<String> GetPatientMatchWithPhysicianTestData_DrugReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			
			testData.add(0, row.getCell(1).toString());//PatientMemberID						
			testData.add(1, row.getCell(2).toString());//ProviderName
			testData.add(2, row.getCell(3).toString());//ProviderFirstName
			testData.add(3, row.getCell(4).toString());//ProviderLastName
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//ProviderNPI	
			testData.add(5, row.getCell(6).toString());//ProviderAddress
			testData.add(6, row.getCell(7).toString());//ProviderCity							
			testData.add(7, row.getCell(8).toString());//ProviderState
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//ProviderZip
			testData.add(9, row.getCell(10).toString());//ProviderPhone
			testData.add(10, row.getCell(11).toString());//PatientInfoLabel	
			testData.add(11, row.getCell(12).toString());//ProviderInfoLabel
			testData.add(12, row.getCell(13).toString());//ProviderType
			testData.add(13, row.getCell(14).toString());//ContactName
			testData.add(14, row.getCell(15).toString());//PrimaryLink		
			testData.add(15, row.getCell(16).toString());//SecondaryLink
			testData.add(16, row.getCell(17).toString());//LinkedConfirmationMsg
			testData.add(17, row.getCell(18).toString());//email
			testData.add(18, row.getCell(19).toString());//unlinkProviderMsg
			testData.add(19, NumberToTextConverter.toText(row.getCell(20).getNumericCellValue()));//ProviderID	
		//	testData.add(20, NumberToTextConverter.toText(row.getCell(21).getNumericCellValue()));//ParentProviderID
			
			
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientProviderTabGridCols(String Key, int rowNum)
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
	
	public List<String> GetMatchPatientRequiredFields(String Key, int rowNum)
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
	
	public List<String> GetPatientMatchWithBOTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			
			testData.add(0, row.getCell(1).toString());//MemberID
			testData.add(1, row.getCell(2).toString());//BOName															
			testData.add(2, row.getCell(3).toString());//BOFirstName
			testData.add(3, row.getCell(4).toString());//BOLastName
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//BONPI
			testData.add(5, row.getCell(6).toString());//BOAddress	
			testData.add(6, row.getCell(7).toString());//BOCity
			testData.add(7, row.getCell(8).toString());//BOState							
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//BOZip
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//BOPhone
			testData.add(10, NumberToTextConverter.toText(row.getCell(11).getNumericCellValue()));//BOFaxNumber
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//BOProviderID	
			testData.add(12, row.getCell(13).toString());//PrimaryProviderType	
			testData.add(13, row.getCell(14).toString());//SecondaryProviderType
			testData.add(14, row.getCell(15).toString());//link confirmation msg
			
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPatientMatchWithGPTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			
			testData.add(0, row.getCell(1).toString());//MemberID											
			testData.add(1, row.getCell(2).toString());//PracticeName															
			testData.add(2, row.getCell(3).toString());//PracticeAddress
			testData.add(3, row.getCell(4).toString());//PracticeCity
			testData.add(4, row.getCell(5).toString());//PracticeState
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//PracticeZip	
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//PracticePhone
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//PracticeFaxNumber							
			testData.add(8, row.getCell(9).toString());//PracticeTaxID
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//PracticeNPI
			testData.add(10, NumberToTextConverter.toText(row.getCell(11).getNumericCellValue()));//PracticeProviderID	
			testData.add(11, row.getCell(12).toString());//PrimaryProviderType	
			testData.add(12, row.getCell(13).toString());//SecondaryProviderType
			testData.add(13, row.getCell(14).toString());//link confirmation msg
			
			return testData;
		}
		 
		return null;
	}
	

}
