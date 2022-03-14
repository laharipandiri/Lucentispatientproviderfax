package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProviderGroups_Supervisors_ProvidersTab extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	
	public List<String> GetPGSupervisorsProvidersTabHeaderCols(String Key, int rowNum)
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
	
	public List<String> GetSupervisorsProvidersTabRequiredFieldsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//RequiredFieldsMsg
			return testData;
		}
		 
		return null;
		
	}
	
	public List<String> GetPGSupervisorsProvidersTabTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//Providername
			testData.add(1, row.getCell(2).toString());//ProviderContactLastName
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//ProviderNPI	
			testData.add(3, row.getCell(4).toString());//AddConfirmationMsg
			testData.add(4, row.getCell(5).toString());//ProviderName							
			testData.add(5, row.getCell(6).toString());//ContactName
			testData.add(6, row.getCell(7).toString());//Address
			testData.add(7, row.getCell(8).toString());//City
			testData.add(8, row.getCell(9).toString());//State
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//Zip
			testData.add(10, row.getCell(11).toString());//Territory
			testData.add(11, row.getCell(12).toString());//ProviderType
			testData.add(12, row.getCell(13).toString());//SupervisorLastName
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPGSupervisorsProvidersTabGPTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//GPName			
			testData.add(1, row.getCell(2).toString());//GPLastName
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//GPNPI	
			testData.add(3, row.getCell(4).toString());//AddConfirmationMsg
			testData.add(4, row.getCell(5).toString());//GPName							
			testData.add(5, row.getCell(6).toString());//ContactName
			testData.add(6, row.getCell(7).toString());//Address
			testData.add(7, row.getCell(8).toString());//City
			testData.add(8, row.getCell(9).toString());//State
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//Zip
			testData.add(10, row.getCell(11).toString());//Territory
			testData.add(11, row.getCell(12).toString());//ProviderType
			testData.add(12, row.getCell(13).toString());//SupervisorLastName
			return testData;
		}
		 
		return null;
	}
	
	
	

}
