package com.juno.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;


//import org.apache.commons.io.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.juno.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

//	public static String TESTDATA_SHEET_PATH_PROVIDERS = System.getProperty("user.dir")
//			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestDataProvider.xlsx";

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestData.xlsx";
	
//	public static String TESTDATA_SHEET_PATH_PATIENTS = System.getProperty("user.dir")
//			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestDataPatients.xlsx";

	public static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	public static final String ALPHABETICAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMERIC = "0123456789";

	static Workbook book;
	static Sheet sheet;
	static Xls_Reader reader;
	static boolean result = false;
	
	/*public int getTestDataRow(String Key)
	{
		Xls_Reader reader1 = new Xls_Reader(TESTDATA_SHEET_PATH);
		int rwCount = reader1.getRowCount("KeyValuePair");
		rwCount = Xls_Reader.sheet.getLastRowNum();
		System.out.println("Row cnt:"+rwCount);
		
		String rowNum;
		Row row = null;
		Cell cell = null;

		for (int i = 1; i <= rwCount; i++) 
		{
			row = Xls_Reader.sheet.getRow(i);
			if(Key.equalsIgnoreCase(row.getCell(0).toString()))//comparing the Key value the the calling method is asking for with the key value in the excel sheet
			{
				rowNum = row.getCell(1).toString();
				int rNum = Integer.parseInt(rowNum);
				return rNum;
				
			}
			
			break;
		}
		return 0;
			
	}*/

	

	public static Object[][] getTestDatafromExcel(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		System.out.println(sheet.getLastRowNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void readFormula() {
		
	}

	public static String randomAlphaNumeric(int count) {

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String randomAlpha(int count) {

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHABETICAL.length());
			builder.append(ALPHABETICAL.charAt(character));
		}
		return builder.toString();
	}
	
	public static String randomNumeric(int count) {

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * NUMERIC.length());
			builder.append(NUMERIC.charAt(character));
		}
		return builder.toString();
	}

	public static boolean setPatientLastName(String name)

	{

		try {
			reader = new Xls_Reader(TESTDATA_SHEET_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rownum = 2; rownum <= reader.getRowCount("Single"); rownum++) {
			result = reader.setCellData("Single", "PatientLastName", rownum, name);

		}
		return result;

	}

	public static String getTimeStamp() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy_h-mm-ss");
		String date = sdf.format(d).toString();
		return date;
	}

	public static Object[][] getSpecificTestDatafromExcel(String sheetName, String Classname) {

		FileInputStream file = null;

		try {

			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		try {

			book = WorkbookFactory.create(file);

		} catch (InvalidFormatException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		sheet = book.getSheet(sheetName);

		int column1 = sheet.getRow(0).getLastCellNum();

		System.out.println(column1);

		Object[][] data = new Object[1][sheet.getRow(0).getLastCellNum()];

		// System.out.println(sheet.getLastRowNum() + "--------" +

		// sheet.getRow(0).getLastCellNum());

		System.out.println(sheet.getLastRowNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			String TestCaseId = sheet.getRow(i + 1).getCell(0).toString();

			System.out.println(TestCaseId);

			if (TestCaseId.equals(Classname))

			{

				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

					data[0][k] = sheet.getRow(i + 1).getCell(k).toString();

					// System.out.println(i);

					System.out.println(data[0][k]);

					// System.out.println(data[i][k]);

				}

				// break;

			}

		}

		return data;

	}

	public static String programArray(String sheetName) {

		String SelectedProgram = "";

		FileInputStream file = null;

		try {

			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		try {

			book = WorkbookFactory.create(file);

		} catch (InvalidFormatException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		sheet = book.getSheet(sheetName);

		String columnWanted = "SelectedProgram";
		Integer columnNo = null;
		// output all not null values to the list

		ArrayList<String> strCells = new ArrayList<String>();
		// Get the first cell.
		Row row = sheet.getRow(0);
		// Cell cell = row.getCell(0);
		for (Cell cell : row) {
			// Column header names.

			if (cell.getStringCellValue().equals(columnWanted)) {
				columnNo = cell.getColumnIndex();
				System.out.println("columnNo: " + columnNo);
			}
		}

		if (columnNo != null) {
			for (Row row1 : sheet) {
				Cell c = row1.getCell(columnNo);
				if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
					// Nothing in the cell in this row, skip it
				} else {

					strCells.add(c.getStringCellValue());
					
				}
			}

		} else {
			System.out.println("could not find column ");
		}

		strCells.remove(0);
		System.out.println("Excel program list : "+strCells);
		System.out.println("Excel program list size: " + (strCells.size()));
		
		String[] programArray = { "Alecensa", "Herceptin HYLECTA", "Kadcyla", "Rituxan Hycela", "Tarceva", "Rozlytrek",
				"Avastin", "Tecentriq", "Venclexta", "Zelboraf", "Gazyva", "Herceptin" };
		ArrayList<String> programList = new ArrayList<>(Arrays.asList(programArray));

		
		//System.out.println("All Program list : "+programList);

		

		//System.out.println("All ProgramList size : " + programList.size());

		programList.removeAll(strCells);
		List<String> programList1 = new ArrayList<String>();
		for (String ProgramName : programList) {
			//System.out.println("ProgramName is: " + ProgramName);
			programList1.add(ProgramName);
		}

		System.out.println(programList1);

		String[] newProgramList = programList1.toArray(new String[0]);

		Random r = new Random();
		System.out.println("Number of Programs : " + newProgramList.length);

		int randomNumber = r.nextInt(newProgramList.length);
		SelectedProgram = newProgramList[randomNumber];

		return SelectedProgram;

	}
	
	public static String [] comboProgCat (String sheetName){

		String[] programArray = { "Herceptin-Perjeta-ComboDrugCategory1", 
				"Cotellic-Zelboraf-ComboDrugCategory2", 
				"Venclexta-Gazyva-ComboDrugCategory3", 
				"Rituxan-Venclexta-ComboDrugCategory2", 
				"Rituxan-Rituxan Hycela-ComboDrugCategory2", 
				"Avastin-Tecentriq-ComboDrugCategory3",
				"Polivy-Rituxan-ComboDrugCategory1"};
		


		
		
		
		
		
		
		
		
		
		String[] comboProginfo = new String[3];

		
		Random r = new Random();
		System.out.println("Number of Programs : " + programArray.length);

		int randomNumber = r.nextInt(programArray.length);
		String progString = programArray[randomNumber];
		comboProginfo = progString.split("-") ;
		

		return comboProginfo;

	
	}
}
