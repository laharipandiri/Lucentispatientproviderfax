package com.juno.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author Chetan
 
 */
public class ExcelTestDataReader {
	
	TestUtil testUtil;

	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);

	public LinkedList<Object[]> getRowDataMap(String inputFile, String sheetName) {
		int count = 0;
		Sheet sheet = null;
		Map<String, String> rowdatamap = null;
		FileInputStream fis = null;
		Workbook workbook = null;
		final LinkedList<Object[]> dataBeans = new LinkedList<Object[]>();

		// Creating index map
		Map<String, Integer> index = new HashMap<String, Integer>();

		try {
			fis = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			System.out.println("debug :"+sheet);
			workbook.close();

			// mapping column index with column name.
			Row firstRow = sheet.getRow(0);
			for (Cell cell : firstRow) {
				index.put(cell.getStringCellValue(), count);
				count++;
			}
			
			//get total rows count present in sheet
			int rowCount = sheet.getLastRowNum();
			//running for loop for each excel row and storing values in map
			for (int iCounter = 1; iCounter <= rowCount; iCounter++) {
				
						//if(sheet.getRow(iCounter).getCell(0).getStringCellValue()=="Y") {
							
							
							//initialize excel row map
							rowdatamap = new HashMap<String, String>();
							Row rowData = sheet.getRow(iCounter);
							for (String key : index.keySet()) {
								int columnnum = (Integer) index.get(key);
								if(rowData.getCell(columnnum)==null){
									rowdatamap.put(key,null);
								}
								else{
									
									String cellValue = rowData.getCell(columnnum).toString();
									if(cellValue.contains("UNIQUE")){
										cellValue = getUNiqueData(cellValue);
									}
									rowdatamap.put(key,cellValue );
								}
								
							}
							dataBeans.add(new Object[] { rowdatamap });
							
					}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataBeans;

	}
	
	public String getUNiqueData(String cellValue){
		String randomValue =  System.currentTimeMillis()+"";
		return cellValue.replace("UNIQUE",randomValue);
	}
	
	public int getKeyValuePair(String Key)
	{
		int rwCount = reader.getRowCount("KeyValuePair");
		rwCount = Xls_Reader.sheet.getLastRowNum();
//		System.out.println("Row cnt:"+rwCount);
		
		
		Row row = null;

		for (int i = 1; i <= rwCount; i++) 
		{
			int rowNum;
			row = Xls_Reader.sheet.getRow(i);
//			System.out.println("value of i is:" +i);
//			System.out.println("value of row.getCell(0).toString()is:" +row.getCell(0).toString());
			if(Key.equalsIgnoreCase(row.getCell(0).toString()))
			{
				rowNum = Integer.parseInt(NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));
				//rowNum = Integer.parseInt(row.getCell(1).toString());//rowNum - Here the row# in the excel starts with 0th index, just as cells start at 0th index
				return rowNum;
			}
			
			
		}
		
		return 0;
	}
	
	public String getBothValue(String Key)
	{
		int rwCount = reader.getRowCount("KeyValuePair");
		rwCount = Xls_Reader.sheet.getLastRowNum();
		System.out.println("Row cnt:"+rwCount);
		
		
		Row row = null;

		for (int i = 1; i <= rwCount; i++) 
		{
			String both;
			row = Xls_Reader.sheet.getRow(i);
			if(Key.equalsIgnoreCase(row.getCell(0).toString()))
			{
				both = row.getCell(2).toString();
				//rowNum = Integer.parseInt(row.getCell(1).toString());//rowNum - Here the row# in the excel starts with 0th index, just as cells start at 0th index
				return both;
			}
			
			
		}
		
		return null;
	}
	//("FaxAndTreatment", "Smoke", "MemberID")
	public List<Integer> GetRowAndColNumOfTheFieldValue(String Key, String sheetname, String existingColName)
	{
//		System.out.println("i am inside GetRowAndColNumOfTheFieldValue");
		//get row and col num of existing test data
		System.out.println("The sheetname is:" +sheetname);
		int rwCount = reader.getRowCount(sheetname);
		rwCount = Xls_Reader.sheet.getLastRowNum();
 	System.out.println("rwCount is" +rwCount);
		Row row = null;
		List<Integer> rowColNum = new ArrayList<Integer>();
		for (int i = 0; i < rwCount; i+=3) 
		{
		System.out.println("Value of i is:" +i);
			Row row2 = Xls_Reader.sheet.getRow(i+1);
			System.out.println("The row2 is:" +row2);
			System.out.println("********" +row2.getCell(0).toString());
			if(Key.equalsIgnoreCase(row2.getCell(0).toString()))//before you start navigating through the col headers, first check if the col header belong to correct key
		{
				System.out.println("I am inside the Key");
				row = Xls_Reader.sheet.getRow(i);
				int cellCount = row.getLastCellNum();
					for(int j=0; j<=cellCount;j++) 
					{
						if(row.getCell(j).toString().equalsIgnoreCase(existingColName))
						{

							rowColNum.add(0, j);//assigning the colnum of the memberID field label
							rowColNum.add(1, i+1);//assigning the rownum of the memberID field value	
							return rowColNum;
						}
				    }
			}
	}
		return null;
	}
}

