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

public class ProviderGroups_BillingOffice_New extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	public List<String> GetBillingOfficeRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
	         }
			 
			 return testData;
		}
		
		return null;
	}
	
	public List<String> GetBillingOfficeCreateTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//testData.add(0, row.getCell(1).toString());//GPName
			
			testData.add(0, row.getCell(2).toString());//FirstName
			String lastName = TestUtil.randomAlpha(5);
			testData.add(1, lastName);//LastName
			//testData.add(1, row.getCell(3).toString());//LastName
			reader.setDataInNewRow(sheetname, "LastName", rowNum, lastName);
			testData.add(2, testData.get(1)+" "+testData.get(0));
			reader.setCellData(sheetname, "BOName", rowNum, null);
			reader.setDataInNewRow(sheetname, "BOName", rowNum, testData.get(2));
			testData.add(3, row.getCell(4).toString());//AddressOne
			testData.add(4, row.getCell(5).toString());//City
			testData.add(5, row.getCell(6).toString());//State
			String Zipcode = TestUtil.randomNumeric(5);
			testData.add(6, Zipcode);//Zip
			reader.setDataInNewRow(sheetname, "Zip", rowNum, Zipcode);
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//Phone
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//TaxField
			testData.add(9, row.getCell(10).toString());//Confirmation msg one
			testData.add(10, row.getCell(11).toString());//confirmation msg two
			testData.add(11, row.getCell(12).toString());//provider type
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetBOAndCardInfoTestDataForUpdate(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//ProviderNPI
			testData.add(1, row.getCell(2).toString());//providerType
			testData.add(2, row.getCell(3).toString());//confirmation msg
			testData.add(3, row.getCell(4).toString());//ConfirmLoginIDRequired
			testData.add(4, row.getCell(5).toString());//ConfirmEmailRequired
			
			return testData;
		}
		 
		return null;
	}
	
	
	

}
