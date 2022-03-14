package com.AWS.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.io.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.AWS.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	public static String TESTDATA_SHEET_PATH =System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\AWS3\\qa\\testdata\\TestData.xlsx";

	public static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	static Workbook book;
	static Sheet sheet;
	static Xls_Reader reader;
	static boolean result = false;

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

		System.out.println(sheet.getLastRowNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static String randomAlphaNumeric(int count) {

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
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

		System.out.println(sheet.getLastRowNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			String TestCaseId = sheet.getRow(i + 1).getCell(0).toString();

			System.out.println(TestCaseId);

			if (TestCaseId.equals(Classname))

			{

				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

					data[0][k] = sheet.getRow(i + 1).getCell(k).toString();

					System.out.println(data[0][k]);

				}

			}

		}

		return data;

	}
}
