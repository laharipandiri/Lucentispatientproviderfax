package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProviderGroups_GroupPractice {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetPGGPAndPatientMappingTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//GPNPI
			//The following fields are the column names in the Patients tab of GP page
			testData.add(1, row.getCell(2).toString());//Name
			testData.add(2, row.getCell(3).toString());//Provide Type
			testData.add(3, row.getCell(4).toString());//ActivationDate
			testData.add(4, row.getCell(5).toString());//PatientName
			testData.add(5, row.getCell(6).toString());//City
			testData.add(6, row.getCell(7).toString());//State
			testData.add(7, row.getCell(8).toString());//Zip
			testData.add(8, row.getCell(9).toString());//PatientPartnerID
			testData.add(9, row.getCell(10).toString());//CardID
			testData.add(10, row.getCell(11).toString());//ProviderNameType
			testData.add(11, row.getCell(12).toString());//Program name
			testData.add(12, row.getCell(13).toString());//Action
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPGGPPatientDataForPatientAndCardInfo(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//The following fields are the patient data that we captured from the patients tab in Providers page onto the excel to be cross checked with the patient and card info page
			/*
			 * testData.add(0, row.getCell(14).toString());//PatientNameValue
			 * testData.add(1, row.getCell(15).toString());//CityValue testData.add(2,
			 * row.getCell(16).toString());//stateValue testData.add(3,
			 * row.getCell(17).toString());//ZipValue testData.add(4,
			 * row.getCell(18).toString());//MemberIDValue testData.add(5,
			 * row.getCell(19).toString());//PartnerPatientIDValue testData.add(6,
			 * row.getCell(20).toString());//CardIDValue testData.add(7,
			 * row.getCell(21).toString());//providernametypevalue testData.add(8,
			 * row.getCell(13).toString());//activation date
			 */			
			for(int i=0;i<9;i++) {
				testData.add(i, row.getCell(i+14).toString());
			}
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPGGPNotesTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//GPNPI
			testData.add(1, row.getCell(2).toString());//ProviderTypeDD
			testData.add(2, row.getCell(3).toString());//Fieldrequiredmsg
			testData.add(3, row.getCell(4).toString());//Callerdropdowndefault
			testData.add(4, row.getCell(5).toString());//Reasondropdowndefault
			testData.add(5, row.getCell(6).toString());//Caller
			testData.add(6, row.getCell(7).toString());//Reason
			testData.add(7, row.getCell(8).toString());//Notes
			testData.add(8, row.getCell(9).toString());//ReasonCol
			testData.add(9, row.getCell(10).toString());//NotesCol
			testData.add(10, row.getCell(11).toString());//CardLoadIDCol
			testData.add(11, row.getCell(12).toString());//OriginatedFromCol
			testData.add(12, row.getCell(13).toString());//CreatedByCol
			testData.add(13, row.getCell(14).toString());//CreatedDateCol
			testData.add(14, row.getCell(15).toString());//ModifiedByCol
			testData.add(15, row.getCell(16).toString());//ModifiedDateCol
			testData.add(16, row.getCell(17).toString());//ActionCol
			testData.add(17, row.getCell(18).toString());//NotesAddedMsg
			testData.add(18, row.getCell(19).toString());//UpdatedTextNotes
			testData.add(19, row.getCell(20).toString());//CallerDropdownUpdate
			testData.add(20, row.getCell(21).toString());//ReasonDropdownUpdate
			testData.add(21, row.getCell(22).toString());//NotesUpdatedMessage
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPGGPFindPageFieldsDropdownDefault(String Key, int rowNum)
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
