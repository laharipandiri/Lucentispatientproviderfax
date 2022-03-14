package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProvideGroups_BillingOffice_Find  extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetPGBOFindPageFieldsDropdownDefault(String Key, int rowNum)
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
	
	public List<String> GetPGBOFindPageSearchgridCols(String Key, int rowNum)
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
	
	public List<String> GetBillingOfficeAndCardInfoData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(3).toString());//ProviderNameValue
			testData.add(1, row.getCell(4).toString());//ContactNameValue
			testData.add(2, row.getCell(5).toString());//AddressValue
			testData.add(3, row.getCell(6).toString());//CityValue
			testData.add(4, row.getCell(7).toString());//StateValue
			testData.add(5, row.getCell(8).toString());//ZipValue
			testData.add(6, row.getCell(9).toString());//PartnerPracticeIDValue
			testData.add(7, row.getCell(10).toString());//StatusValue
			testData.add(8, row.getCell(11).toString());//ProviderTypeValue
			testData.add(9, row.getCell(12).toString());//ProviderIDValue
			testData.add(10, row.getCell(13).toString());//ParentProviderIDValue
			testData.add(11, row.getCell(14).toString());//NPIValue
			testData.add(12, row.getCell(15).toString());//TaxIDValue
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetBillingOfficeFindTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//lastname
			testData.add(1, row.getCell(2).toString());//providerType
			
			return testData;
			
		}
		
		return null;
		
	}	

}
