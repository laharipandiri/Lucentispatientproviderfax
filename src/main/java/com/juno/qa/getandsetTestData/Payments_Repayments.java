package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortal_Patients_MessagesTabPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Payments_Repayments extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	AdminPortal_Patients_MessagesTabPage apm = new AdminPortal_Patients_MessagesTabPage();

	CommonFunctions cf = new CommonFunctions();
	
	public List<String> GetRefundCheckClearedTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																																	
			testData.add(0, row.getCell(1).toString());//MemberID	
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//TransactionIDForCheckClearSelectionCheckbox
			testData.add(3, row.getCell(4).toString());//Amount
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//CheckNum
			testData.add(5, row.getCell(6).toString());//PaymentStatus
			testData.add(6, row.getCell(7).toString());//CheckStatus
			testData.add(7, row.getCell(8).toString());//Notes
			testData.add(8, row.getCell(9).toString());//ProviderName
			testData.add(9, row.getCell(10).toString());//ConfirmationOne
			testData.add(10, row.getCell(11).toString());//ConfirmationTwo
			testData.add(11, row.getCell(12).toString());//ConfirmationThree
			testData.add(12, row.getCell(15).toString());//OriginalTransactionAmount
			testData.add(13, row.getCell(17).toString());//TransactionWiped
			testData.add(14, row.getCell(18).toString());//CreatedBy
			testData.add(15, row.getCell(19).toString());//TransactionType
			testData.add(16, row.getCell(20).toString());//PaymentType
			testData.add(17, row.getCell(23).toString());//ProgramName
			testData.add(18, row.getCell(24).toString());//FirstName
			testData.add(19, row.getCell(25).toString());//LastName
			testData.add(20, row.getCell(26).toString());//State
			testData.add(21, row.getCell(27).toString());//ProviderFN
			testData.add(22, row.getCell(28).toString());//ProviderLN
			testData.add(23, row.getCell(29).toString());//ProviderAddress
			testData.add(24, row.getCell(30).toString());//ProviderCity
			testData.add(25, row.getCell(31).toString());//ProviderState
			testData.add(26, NumberToTextConverter.toText(row.getCell(32).getNumericCellValue()));//ProviderZip
			testData.add(27, NumberToTextConverter.toText(row.getCell(33).getNumericCellValue()));//ProviderNPI
			testData.add(28, row.getCell(34).toString());//ProviderPhone
			testData.add(29, row.getCell(35).toString());//ShowPatient
			
			
			
			return testData;
		}
		
		return null;
	}
	
	
	public List<String> GetRefundConfirmationTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																																	
			testData.add(0, row.getCell(13).toString());//PaymentNum
			testData.add(1, row.getCell(14).toString());//RefundNum
			testData.add(2, row.getCell(16).toString());//TransactionAmountLeft
			testData.add(3, row.getCell(21).toString());//RefundTransactionNum
			testData.add(4, row.getCell(22).toString());//Balance
			
			
			
			return testData;
		}
		
		return null;
	}
	
	

}
