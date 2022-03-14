package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class GetAndSetTestData extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	public List<String> EnrollInfoTestData(String Key, int rowNum) throws InterruptedException
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List <String> testData = new ArrayList<String>();
		

			testData.add(0, row.getCell(1).toString());//Program
			testData.add(1, row.getCell(2).toString());//GroupNumber
			testData.add(2, row.getCell(3).toString());//Channel
			testData.add(3, row.getCell(4).toString());//Name
			testData.add(4, row.getCell(5).toString());//Title
			testData.add(5, row.getCell(6).toString());//Firstname
			
			//Set patient middle name into excel
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, null);
			String randomPatientMiddleName = TestUtil.randomAlpha(1);
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, randomPatientMiddleName);
			testData.add(6, randomPatientMiddleName);//middlename
			
			//Set patient last name into excel
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, null);
			String randomPatientLastName = TestUtil.randomAlpha(3);
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, randomPatientLastName);
			testData.add(7, randomPatientLastName);//lastname
			
			testData.add(8, row.getCell(9).toString());//Address1
			testData.add(9, row.getCell(10).toString());//Address2
			testData.add(10, row.getCell(11).toString());//City
			testData.add(11, row.getCell(12).toString());//State
			
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, null);
			String PatientZipCode = TestUtil.randomNumeric(9);
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, PatientZipCode);
			testData.add(12, PatientZipCode);//PatientZipCode
			
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//PatientCellNumber
			testData.add(14, row.getCell(15).toString());//EnrollmentType
			testData.add(15, row.getCell(16).toString());//Gender
			testData.add(16, row.getCell(17).toString());//DOB
			
			
			//Set Partner PatientID ----  PartnerPatientID should be Unique for each patient?
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, null);
			String randomPartnerPatientID = TestUtil.randomNumeric(10);
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, randomPartnerPatientID);
			testData.add(17, randomPartnerPatientID);
			
		
			testData.add(18, row.getCell(19).toString());//HIPPAConsentDate 
			
			//Adding new fields for Express 2.0
			testData.add(19, row.getCell(21).toString()); //PhysicianNPI
			testData.add(20, row.getCell(22).toString()); //PhysicianPartnerId
			testData.add(21, row.getCell(23).toString()); //PhysicianWorkPhone
			testData.add(22, row.getCell(24).toString()); //PhysicianFax
			
			return testData;
		}
		
		return null;
	}
	
	
	/*public List<String> GetAndSetPatientEnrollInfoTestData(String Key, int rowNum) throws InterruptedException
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List <String> testData = new ArrayList<String>();
		

			testData.add(0, row.getCell(1).toString());//Program
			testData.add(1, row.getCell(2).toString());//GroupNumber
			testData.add(2, row.getCell(3).toString());//Channel
			testData.add(3, row.getCell(4).toString());//Name
			testData.add(4, row.getCell(5).toString());//Title
			testData.add(5, row.getCell(6).toString());//Firstname
			
			//Set patient middle name into excel
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, null);
			String randomPatientMiddleName = TestUtil.randomAlpha(1);
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, randomPatientMiddleName);
			testData.add(6, randomPatientMiddleName);//middlename
			
			//Set patient last name into excel
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, null);
			String randomPatientLastName = TestUtil.randomAlpha(3);
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, randomPatientLastName);
			testData.add(7, randomPatientLastName);//lastname
			
			testData.add(8, row.getCell(9).toString());//Address1
			testData.add(9, row.getCell(10).toString());//Address2
			testData.add(10, row.getCell(11).toString());//City
			testData.add(11, row.getCell(12).toString());//State
			
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, null);
			String PatientZipCode = TestUtil.randomNumeric(9);
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, PatientZipCode);
			testData.add(12, PatientZipCode);//PatientZipCode
			
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//PatientCellNumber
			testData.add(14, row.getCell(15).toString());//EnrollmentType
			testData.add(15, row.getCell(16).toString());//Gender
			testData.add(16, row.getCell(17).toString());//DOB
			
			
			//Set Partner PatientID ----  PartnerPatientID should be Unique for each patient?
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, null);
			String randomPartnerPatientID = TestUtil.randomNumeric(10);
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, randomPartnerPatientID);
			testData.add(17, randomPartnerPatientID);
			
		
			testData.add(18, row.getCell(19).toString());//HIPPAConsentDate 
			
			//Adding new fields for Express 2.0
			testData.add(19, row.getCell(21).toString()); //PhysicianNPI
			testData.add(20, row.getCell(22).toString()); //PhysicianPartnerId
			testData.add(21, row.getCell(23).toString()); //PhysicianWorkPhone
			testData.add(22, row.getCell(24).toString()); //PhysicianFax
			
			return testData;
		}
		
		return null;
	}
	*/
	public List<String> GetAdminLoginSmokeTestData(String Key,int rowNum)
	{
		//First get the sheet
		reader.getSheet("Smoke");
		
		//Go to the specific row in that sheet
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List<String> testData = new ArrayList<String>();
			testData.add(0, row.getCell(1).toString());//username
			testData.add(1, row.getCell(2).toString());//password
			testData.add(2, row.getCell(3).toString());//drug program name
			testData.add(3, row.getCell(4).toString());//admin program name
			testData.add(4, row.getCell(5).toString());//AdminProgramName
			testData.add(5, row.getCell(6).toString());//AdminReimbursementProgramName

			
			
			return testData;
		}
		
		return null;
		
		
	}
	
	public List<String> GetAndSetPatientEnrollInfoTestData(String Key, int rowNum) throws InterruptedException
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List <String> testData = new ArrayList<String>();
		

			testData.add(0, row.getCell(1).toString());//Program
			testData.add(1, row.getCell(2).toString());//GroupNumber
			testData.add(2, row.getCell(3).toString());//Channel
			testData.add(3, row.getCell(4).toString());//Name
			testData.add(4, row.getCell(5).toString());//Title
			testData.add(5, row.getCell(6).toString());//Firstname
			
			//Set patient middle name into excel
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, null);
			String randomPatientMiddleName = TestUtil.randomAlpha(1);
			reader.setCellData(sheetname, "PatientMiddleName", rowNum + 1, randomPatientMiddleName);
			testData.add(6, randomPatientMiddleName);//middlename
			
			//Set patient last name into excel
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, null);
			String randomPatientLastName = TestUtil.randomAlpha(3);
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, randomPatientLastName);
			testData.add(7, randomPatientLastName);//lastname
			
			testData.add(8, row.getCell(9).toString());//Address1
			testData.add(9, row.getCell(10).toString());//Address2
			testData.add(10, row.getCell(11).toString());//City
			testData.add(11, row.getCell(12).toString());//State
			
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, null);
			String PatientZipCode = TestUtil.randomNumeric(9);
			reader.setCellData(sheetname, "PatientZipCode", rowNum + 1, PatientZipCode);
			testData.add(12, PatientZipCode);//PatientZipCode
			
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//PatientCellNumber
			testData.add(14, row.getCell(15).toString());//EnrollmentType
			testData.add(15, row.getCell(16).toString());//Gender
			testData.add(16, row.getCell(17).toString());//DOB
			
			
			//Set Partner PatientID ----  PartnerPatientID should be Unique for each patient?
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, null);
			String randomPartnerPatientID = TestUtil.randomNumeric(10);
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, randomPartnerPatientID);
			testData.add(17, randomPartnerPatientID);
			
		
			testData.add(18, row.getCell(19).toString());//HIPPAConsentDate 
			
			//Adding new fields for Express 2.0
			testData.add(19, row.getCell(21).toString()); //PhysicianNPI
			testData.add(20, row.getCell(22).toString()); //PhysicianPartnerId
			testData.add(21, row.getCell(23).toString()); //PhysicianWorkPhone
			testData.add(22, row.getCell(24).toString()); //PhysicianFax
			
			return testData;
		}
		
		return null;
	}
	public List<String> GetHubLoginSmokeTestData(String Key,int rowNum)
	{
		//First get the sheet
		reader.getSheet("Smoke");
		
		//Go to the specific row in that sheet
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List<String> testData = new ArrayList<String>();
			testData.add(0, row.getCell(1).toString());//username
			testData.add(1, row.getCell(2).toString());//password
			testData.add(2, row.getCell(3).toString());//home page title
			
			return testData;
		}
		
		return null;
		
		
	}
	
	
	public List<String> GetAndSetHubPatientEnrollInfoTestData(String Key, int rowNum) throws InterruptedException
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List <String> testData = new ArrayList<String>();
			
			reader.setCellData(sheetname, "Program", rowNum+1, null);//Need to give rowNum+1 refer to the definition for this method
			//WebElement programListItem =  hap.getProgramName().getFirstSelectedOption();
			
			reader.setCellData(sheetname, "Program", rowNum+1, hap.Brand().getAttribute("value"));
			testData.add(0, hap.Brand().getAttribute("value"));
			Thread.sleep(1000);
			
			//Get group number from application and add it to excel
			reader.setCellData(sheetname, "GroupNumber", rowNum + 1, null);
			reader.setCellData(sheetname, "GroupNumber", rowNum+1, hap.GroupNumber().getAttribute("value"));
			testData.add(1, hap.GroupNumber().getAttribute("value"));
			
			Thread.sleep(1000);
			
			
			testData.add(2, row.getCell(3).toString());//Firstname
			
			//Set patient last name into excel
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, null);
			String randomPatientLastName = TestUtil.randomAlpha(3);
			reader.setCellData(sheetname, "PatientLastName", rowNum + 1, randomPatientLastName);
			testData.add(3, randomPatientLastName);//lastname
			
			testData.add(4, row.getCell(5).toString());//DOB
			
			testData.add(5, row.getCell(6).toString());//PatientGender
			
			//Set Partner PatientID ----  PartnerPatientID should be Unique for each patient?
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, null);
			String randomPartnerPatientID = TestUtil.randomNumeric(10);
			reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, randomPartnerPatientID);
			testData.add(6, randomPartnerPatientID);
			
			
			//get patient details from excel
			
			testData.add(7, row.getCell(8).toString());//PatientAddress 
			testData.add(8, row.getCell(9).toString());//PatientCity 
			testData.add(9,row.getCell(10).toString());//PatientState  
			testData.add(10, row.getCell(11).toString());//PatientZipCode 
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//PatientCellNumber 
			testData.add(12, NumberToTextConverter.toText(row.getCell(13).getNumericCellValue()));//PhysicianNPI 
			testData.add(13, row.getCell(14).toString());//PartnerPhysicianID 
			testData.add(14, row.getCell(15).toString());//PhysicianFirstName 
			testData.add(15, row.getCell(16).toString());//PhysicianLastName  
			testData.add(16, row.getCell(17).toString());//PhysicianAddress  
			testData.add(17, row.getCell(18).toString());//PhysicianCity  
			testData.add(18, row.getCell(19).toString());//PhysicianState  
			testData.add(19, row.getCell(20).toString());//PhysicianZipCode  
			testData.add(20, row.getCell(21).toString());//PhysicianPhone  
			testData.add(21, row.getCell(22).toString());//PhysicianFax  
			testData.add(22, row.getCell(23).toString());//InsCompanyName  
			testData.add(23, row.getCell(24).toString());//InsGroupNumber  
			testData.add(24, NumberToTextConverter.toText(row.getCell(25).getNumericCellValue()));//InsMemberNumber  
			testData.add(25, row.getCell(26).toString());//PatientConsent  
			testData.add(26, row.getCell(27).toString());//HIPPAConsentDate  
			testData.add(27, row.getCell(29).toString());//PhysicianPreferredContactMethod			  
			testData.add(28, row.getCell(30).toString());//PhysicianPreferredContactTime 
			testData.add(29, row.getCell(31).toString());//PatientPreferredContactMethod  
			testData.add(30, row.getCell(32).toString());//EnrollmentType
			testData.add(31, NumberToTextConverter.toText(row.getCell(33).getNumericCellValue()));//PhysicianWorkPhone
			testData.add(32, NumberToTextConverter.toText(row.getCell(34).getNumericCellValue()));//InsuranceBIN	
			testData.add(33, NumberToTextConverter.toText(row.getCell(35).getNumericCellValue()));//InsurancePCN
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAndSetHubPatientEnrollInfoTestData_OtherInsurance(String Key, int rowNum) throws InterruptedException
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			List <String> testData = new ArrayList<String>();
			
		//	reader.setCellData(sheetname, "Program", rowNum+1, null);//Need to give rowNum+1 refer to the definition for this method
			reader.setDataInNewRow(sheetname, "Program", rowNum, null);
			//WebElement programListItem =  hap.getProgramName().getFirstSelectedOption();
			
			//reader.setCellData(sheetname, "Program", rowNum+1, hap.Brand().getAttribute("value"));
			reader.setDataInNewRow(sheetname, "Program", rowNum, hap.Brand().getAttribute("value"));
			testData.add(0, hap.Brand().getAttribute("value"));
			Thread.sleep(1000);
			
			//Get group number from application and add it to excel
		//	reader.setCellData(sheetname, "GroupNumber", rowNum + 1, null);
			reader.setDataInNewRow(sheetname, "GroupNumber", rowNum, null);
			reader.setDataInNewRow(sheetname, "GroupNumber", rowNum, hap.GroupNumber().getAttribute("value"));
		//	reader.setCellData(sheetname, "GroupNumber", rowNum+1, hap.GroupNumber().getAttribute("value"));
			testData.add(1, hap.GroupNumber().getAttribute("value"));
			
			Thread.sleep(1000);
			
			
			testData.add(2, row.getCell(3).toString());//Firstname
			
			//Set patient last name into excel
		//	reader.setCellData(sheetname, "PatientLastName", rowNum + 1, null);
			reader.setDataInNewRow(sheetname, "PatientLastName", rowNum, null);
			String randomPatientLastName = TestUtil.randomAlpha(3);
		//	reader.setCellData(sheetname, "PatientLastName", rowNum + 1, randomPatientLastName);
			reader.setDataInNewRow(sheetname, "PatientLastName", rowNum, randomPatientLastName);
			testData.add(3, randomPatientLastName);//lastname
			
			testData.add(4, row.getCell(5).toString());//DOB
			
			testData.add(5, row.getCell(6).toString());//PatientGender
			
			//Set Partner PatientID ----  PartnerPatientID should be Unique for each patient?
		//	reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, null);
			reader.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, null);
			String randomPartnerPatientID = TestUtil.randomNumeric(10);
		//	reader.setCellData(sheetname, "PartnerPatientID", rowNum + 1, randomPartnerPatientID);
			reader.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, randomPartnerPatientID);
			testData.add(6, randomPartnerPatientID);
			
			
			//get patient details from excel
			
			testData.add(7, row.getCell(8).toString());//PatientAddress 
			testData.add(8, row.getCell(9).toString());//PatientCity 
			testData.add(9,row.getCell(10).toString());//PatientState  
			testData.add(10, NumberToTextConverter.toText(row.getCell(11).getNumericCellValue()));//PatientZipCode 
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//PatientCellNumber 
			testData.add(12, NumberToTextConverter.toText(row.getCell(13).getNumericCellValue()));//PhysicianNPI 
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//PartnerPhysicianID 
			testData.add(14, row.getCell(15).toString());//PhysicianFirstName 
			testData.add(15, row.getCell(16).toString());//PhysicianLastName  
			testData.add(16, row.getCell(17).toString());//PhysicianAddress  
			testData.add(17, row.getCell(18).toString());//PhysicianCity  
			testData.add(18, row.getCell(19).toString());//PhysicianState  
			testData.add(19, row.getCell(20).toString());//PhysicianZipCode  
			testData.add(20, row.getCell(21).toString());//PhysicianPhone  
			testData.add(21, row.getCell(22).toString());//PhysicianFax  
			testData.add(22, row.getCell(23).toString());//InsCompanyName  
			testData.add(23, NumberToTextConverter.toText(row.getCell(24).getNumericCellValue()));//InsGroupNumber  
			testData.add(24, NumberToTextConverter.toText(row.getCell(25).getNumericCellValue()));//InsMemberNumber  
			testData.add(25, row.getCell(26).toString());//PatientConsent  
			testData.add(26, row.getCell(27).toString());//HIPPAConsentDate  
			testData.add(27, row.getCell(29).toString());//PhysicianPreferredContactMethod			  
			testData.add(28, row.getCell(30).toString());//PhysicianPreferredContactTime 
			testData.add(29, row.getCell(31).toString());//PatientPreferredContactMethod  
			testData.add(30, row.getCell(32).toString());//EnrollmentType
			testData.add(31, NumberToTextConverter.toText(row.getCell(33).getNumericCellValue()));//PhysicianWorkPhone
			testData.add(32, NumberToTextConverter.toText(row.getCell(34).getNumericCellValue()));//InsuranceBIN	
			testData.add(33, NumberToTextConverter.toText(row.getCell(35).getNumericCellValue()));//InsurancePCN
			
			return testData;
		}
		
		return null;
	}
	
	public void setMemberIDInExcel(String Key, String MemberID, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			
			reader.setCellData(sheetname, "MemberID", rowNum + 1, MemberID);
		}
		
	}
	
	public void setMemberIDInExcel_OtherInsurance(String Key, String MemberID, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Key value from excel:"+row.getCell(0).toString());
			System.out.println("Inside memberid copy if");
			System.out.println("MemberID: "+MemberID);
			
			reader.setDataInNewRow(sheetname, "MemberID", rowNum, MemberID);
		}
		
	}
	
	
	public void setCardIDInExcel_OtherInsurance(String Key, String CardNO, int rowNum) //newly added for treatment
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			reader.setDataInNewRow(sheetname, "CardNO", rowNum, CardNO);
		}
		
	}
	public void setAmountInExcel_OtherInsurance(String Key, Double amount, int rowNum) //newly added for treatment
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			reader.setDataInNewRow1(sheetname, "Amount", rowNum, amount);
		}
		
	}
	public void setMemberIDInExcel_E2ECTP(String Key, String MemberID, int rowNum)
	{
		String sheetname = "E2ECTP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Key value from excel:"+row.getCell(0).toString());
			System.out.println("Inside memberid copy if");
			System.out.println("MemberID: "+MemberID);
			
			reader.setDataInNewRow(sheetname, "MemberID", rowNum, MemberID);
		}
		
	}
	public void HCPsetMemberIDInExcel_OtherInsurance(String Key, String MemberID, int rowNum)
	{
		System.out.println("I am inside HCPsetMemberIDInExcel_OtherInsurance ");
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Key value from excel:"+row.getCell(0).toString());
			System.out.println("Inside memberid copy if");
			System.out.println("MemberID: "+MemberID);
			
			reader.setDataInNewRow(sheetname, "MemberID", rowNum, MemberID);
		}
	}
	public void E2EScenariossetMemberIDInExcel_OtherInsurance(String Key, String MemberID, int rowNum)
	{
		System.out.println("I am inside HCPsetMemberIDInExcel_OtherInsurance ");
		String sheetname = "E2EScenarios";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Key value from excel:"+row.getCell(0).toString());
			System.out.println("Inside memberid copy if");
			System.out.println("MemberID: "+MemberID);
			
			reader.setDataInNewRow(sheetname, "MemberID", rowNum, MemberID);
		}
	}
	public void HCPsetFullnameInExcel_OtherInsurance(String Key, String Fullname, int rowNum)
	{
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			reader.setDataInNewRow(sheetname, "Fullname", rowNum, Fullname);
		}
	}
	public void HCPsetSearchDOBInExcel_OtherInsurance(String Key, String SearchDOB, int rowNum)
	{
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			reader.setDataInNewRow(sheetname, "SearchDOB", rowNum, SearchDOB);
		}
	}
	public void HCPsetPhoneNumberInExcel_OtherInsurance(String Key, String PhoneNumber, int rowNum)
	{
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			reader.setDataInNewRow(sheetname, "PhoneNumber", rowNum, PhoneNumber);
		}
	}
	
	
		public void HCPsetAddressInExcel_OtherInsurance(String Key, String Address, int rowNum)
		{
			String sheetname = "HCP";
			reader.getSheet(sheetname);
			Row row = Xls_Reader.sheet.getRow(rowNum);
			if(Key.equalsIgnoreCase(row.getCell(0).toString()))
			{
				System.out.println("Key:"+Key);
				System.out.println("Key value from excel:"+row.getCell(0).toString());
				System.out.println("Inside memberid copy if");
				System.out.println("Address: "+Address);
				
				reader.setDataInNewRow(sheetname, "Address", rowNum, Address);
			}
	}
	
	public String copyValueToDiffRow(String Key, int existingRowNum, int existingColNum, int newRowNum, String newColName, String sheetname)
	{
		//String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row1 = Xls_Reader.sheet.getRow(existingRowNum);//This row has memberID
		String originalFieldValue = row1.getCell(existingColNum).toString();
		Row row2 = Xls_Reader.sheet.getRow(newRowNum);
		if(Key.equalsIgnoreCase(row2.getCell(0).toString()))
		{
			reader.copyCellData(sheetname, newColName, newRowNum, originalFieldValue);
			return originalFieldValue;
		}
		return null;
	}
	
	public String copyValueToDiffRowAndDiffSheet(String oldKey, String newKey, String oldSheet, String newSheet, int existingRowNum, int existingColNum, int newRowNum, String newColName)
	{
		//String sheetname = "Smoke";
		reader.getSheet(oldSheet);
		Row row1 = reader.sheet.getRow(existingRowNum);//This row has memberID
		if(oldKey.equalsIgnoreCase(row1.getCell(0).toString()))
		{
			String originalFieldValue = row1.getCell(existingColNum).toString();
			reader1.getSheet(newSheet);
			Row row2 = reader1.sheet.getRow(newRowNum);
			if(newKey.equalsIgnoreCase(row2.getCell(0).toString()))
			{
				reader.copyCellData(newSheet, newColName, newRowNum, originalFieldValue);
				return originalFieldValue;
			}
		}
		return null;
	}
	public List<String> GetUploadEOBTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(3).toString());//Firstname
			testData.add(1, row.getCell(4).toString());//lastname
			testData.add(2, row.getCell(28).toString());//memberID
			return testData;
		}
		return null;
	}
	
	public List<String> GetUploadEOBTestDataForRepayment(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(24).toString());//Firstname
			testData.add(1, row.getCell(25).toString());//lastname
			testData.add(2, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//memberID
			return testData;
		}
		return null;
	}
	
	
	public List<String> GetFaxAndTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	

			testData.add(0, row.getCell(13).toString());//memberID
			testData.add(1, row.getCell(1).toString());//faxtype
			testData.add(2, row.getCell(2).toString());//fax status
			testData.add(3, row.getCell(3).toString());//eob status
			testData.add(4, row.getCell(4).toString());//outgoing fax number
			testData.add(5, row.getCell(5).toString());//date of service
			testData.add(6, row.getCell(6).toString());//insurance name on EOB
			testData.add(7, row.getCell(7).toString());//quantity
			testData.add(8, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//copay
			testData.add(9, row.getCell(9).toString());//eob date
			testData.add(10, row.getCell(10).toString());//billing provider name
			testData.add(11, row.getCell(11).toString());//group practice name
			testData.add(12, row.getCell(12).toString());//physician last name
			testData.add(13, row.getCell(14).toString());//Patient first name
			testData.add(14, row.getCell(15).toString());//partnerpatientid 
			testData.add(15, row.getCell(18).toString());//Status
 
			
		}
		
		return testData;
	}
	
	public List<String> HCPGetFaxAndTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	

			testData.add(0, row.getCell(13).toString());//memberID
			testData.add(1, row.getCell(1).toString());//faxtype
			testData.add(2, row.getCell(2).toString());//fax status
			testData.add(3, row.getCell(3).toString());//eob status
			testData.add(4, row.getCell(4).toString());//outgoing fax number
			testData.add(5, row.getCell(5).toString());//date of service
			testData.add(6, row.getCell(6).toString());//insurance name on EOB
			testData.add(7, row.getCell(7).toString());//quantity
			testData.add(8, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//copay
			testData.add(9, row.getCell(9).toString());//eob date
			testData.add(10, row.getCell(10).toString());//billing provider name
			testData.add(11, row.getCell(11).toString());//group practice name
			testData.add(12, row.getCell(12).toString());//physician last name
			testData.add(13, row.getCell(14).toString());//Patient first name
			testData.add(14, row.getCell(15).toString());//partnerpatientid 
			testData.add(15, row.getCell(18).toString());//Status
 
			
		}
		
		return testData;
	}
	public List<String> E2EScenariosGetFaxAndTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "E2EScenarios";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	

			testData.add(0, row.getCell(13).toString());//memberID
			testData.add(1, row.getCell(1).toString());//faxtype
			testData.add(2, row.getCell(2).toString());//fax status
			testData.add(3, row.getCell(3).toString());//eob status
			testData.add(4, row.getCell(4).toString());//outgoing fax number
			testData.add(5, row.getCell(5).toString());//date of service
			testData.add(6, row.getCell(6).toString());//insurance name on EOB
			testData.add(7, row.getCell(7).toString());//quantity
			testData.add(8, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//copay
			testData.add(9, row.getCell(9).toString());//eob date
			testData.add(10, row.getCell(10).toString());//billing provider name
			testData.add(11, row.getCell(11).toString());//group practice name
			testData.add(12, row.getCell(12).toString());//physician last name
			testData.add(13, row.getCell(14).toString());//Patient first name
			testData.add(14, row.getCell(15).toString());//partnerpatientid 
			testData.add(15, row.getCell(18).toString());//Status
			}
		
		return testData;
	}
	
	public List<String> E2EScenariosRejectGetFaxAndTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "E2EScenarios";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	

			testData.add(0, row.getCell(13).toString());//memberID
			testData.add(1, row.getCell(1).toString());//faxtype
			testData.add(2, row.getCell(2).toString());//fax status
			testData.add(3, row.getCell(3).toString());//eob status
			testData.add(4, row.getCell(4).toString());//outgoing fax number
			testData.add(5, row.getCell(5).toString());//date of service
			testData.add(6, row.getCell(6).toString());//insurance name on EOB
			testData.add(7, row.getCell(7).toString());//quantity
			testData.add(8, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//copay
			testData.add(9, row.getCell(9).toString());//eob date
			testData.add(10, row.getCell(10).toString());//billing provider name
			testData.add(11, row.getCell(11).toString());//group practice name
			testData.add(12, row.getCell(12).toString());//physician last name
			testData.add(13, row.getCell(14).toString());//Patient first name
			testData.add(14, row.getCell(15).toString());//partnerpatientid 
			testData.add(15, row.getCell(18).toString());//Status
			
			testData.add(16, row.getCell(22).toString());//Status
			testData.add(17, row.getCell(23).toString());//Reject reason
 
			
		}
		
		return testData;
	}
	public List<String> GetFaxAndTreatmentTestDataForRepayment(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
//	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	DateOfService	InsuranceNameOnEOB	Quantity	EOBDate	BillingProviderName	GroupPracticeName	PhysicianLastName	ProgramName	Status	MemberID	CardID	FirstName	LastName	PartnerPatientID
						
		
			testData.add(0, row.getCell(1).toString());//faxtype
			testData.add(1, row.getCell(2).toString());//fax status
			testData.add(2, row.getCell(3).toString());//eob status
			testData.add(3, row.getCell(4).toString());//outgoing fax number
			testData.add(4, row.getCell(5).toString());//date of service
			testData.add(5, row.getCell(6).toString());//insurance name on EOB
			testData.add(6, row.getCell(7).toString());//quantity
			testData.add(7, TestUtil.randomNumeric(2));//copay
			testData.add(8, row.getCell(8).toString());//eob date
			testData.add(9, row.getCell(9).toString());//billing provider name
			testData.add(10, row.getCell(10).toString());//group practice name
			testData.add(11, row.getCell(11).toString());//physician last name
			testData.add(12, row.getCell(12).toString());//ProgramName
			testData.add(13, row.getCell(13).toString());//Status
			testData.add(14, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//MemberID
			testData.add(15, row.getCell(15).toString());//CardID
			testData.add(16, row.getCell(16).toString());//FirstName
			testData.add(17, row.getCell(17).toString());//LastName
			testData.add(18, NumberToTextConverter.toText(row.getCell(18).getNumericCellValue()));//PartnerPatientID
			
 
			
		}
		
		return testData;
	}
	
	public List<String> GetFaxAndTreatmentTestDataForBothReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
	
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{																				
			testData.add(0, row.getCell(17).toString());//memberID
			testData.add(1, row.getCell(1).toString());//faxtype
			testData.add(2, row.getCell(2).toString());//fax status
			testData.add(3, row.getCell(3).toString());//eob status
			testData.add(4, row.getCell(4).toString());//outgoing fax number
			testData.add(5, row.getCell(5).toString());//date of service
			testData.add(6, row.getCell(6).toString());//insurance name on EOB
			testData.add(7, row.getCell(7).toString());//Jcode
			testData.add(8, row.getCell(8).toString());//Quantity
			testData.add(9, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//NDC
			testData.add(10, row.getCell(10).toString());//DrugCopay
			testData.add(11, row.getCell(11).toString());//CPTCode
			testData.add(12, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//AdminCopay
			testData.add(13, row.getCell(13).toString());//eob date
			testData.add(14, row.getCell(14).toString());//billing provider name
			testData.add(15, row.getCell(15).toString());//group practice name
			testData.add(16, row.getCell(16).toString());//physician last name
			testData.add(17, row.getCell(18).toString());//Patient first name
			testData.add(18, row.getCell(19).toString());//partnerpatientid 
			testData.add(19, row.getCell(20).toString());//ProgramName
			testData.add(20, row.getCell(21).toString());//CardID 
			testData.add(21, row.getCell(22).toString());//Status
 
			
		}
		
		return testData;
	}
	
	public boolean SetTotalCopayDataForBothAdminACH(double totalCopay)
	{
		boolean verify = true;
		if(verify)
		{
			int row = etd.getKeyValuePair("ACHStatusBeforePaymentApprovalForBothAdminReimbursementAdminPortal");
	        int row1 = etd.getKeyValuePair("ACHStatusAfterPaymentApprovalForBothAdminReimbursementAdminPortal");
	        int row2 = etd.getKeyValuePair("ACHStatusAfterCheckAllForBothAdminReimbursement");
	        int row3 = etd.getKeyValuePair("HubStatusACHBeforePaymentApprovalForBothAdminReimbursement");
	        int row4 = etd.getKeyValuePair("HubStatusACHAfterPaymentApprovalForBothAdminReimbursement");
	        int row5 = etd.getKeyValuePair("HubACHStatusCheckAfterCheckAllForBothAdminReimbursement");
	        int row6 = etd.getKeyValuePair("ACHDataForBothAdminReimbursement");
	        int row7 = etd.getKeyValuePair("ClaimLetterGenerationAndOutgoingFaxForBothAdminReimbursement");
	        
	        Assert.assertTrue(reader.setCellData("e2e", "TransactionAmountIn$", row+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "AmountIn$", row1+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "TransactionAmountIn$", row2+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "TotalUsage", row2+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "Amount", row3+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "Amount", row4+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "Amount", row5+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("Smoke", "TotalAmount", row6+1, String.valueOf(totalCopay)));
	        Assert.assertTrue(reader.setCellData("e2e", "TotalCopay", row7+1, String.valueOf(totalCopay)));
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public List<String> GetHubHomePageTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//Admin reimbursement heading
			testData.add(1, row.getCell(2).toString());//Drug reimbursement heading
			testData.add(2, row.getCell(3).toString());//HubPortalLoginPageURL
		}
		
		return testData;
	}
	
	public List<String> GetReimbursementHomePageData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//EnrollNewPatientHeading								
			testData.add(1, row.getCell(2).toString());//FindCopayProgramPatientHeading
			testData.add(2, row.getCell(3).toString());//ListAllPatientsHeading
			testData.add(3, row.getCell(4).toString());//UploadFileHeading
			testData.add(4, row.getCell(5).toString());//DownloadableFormsHeading
			testData.add(5, row.getCell(6).toString());//CopaySupportContactHeading
			testData.add(6, row.getCell(7).toString());//AdminPageTitleHeading
			String sideButtonsCount = NumberToTextConverter.toText(row.getCell(8).getNumericCellValue());
			testData.add(7, sideButtonsCount);//SidePanelButtonsCount
			testData.add(8, row.getCell(9).toString());//HubPortalLoginPageURL
			testData.add(9, row.getCell(10).toString());//DrugPageTitleHeading
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetAdminPagesLinksTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
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
	
	public List<String> GetEnrollPatientMandatoryFields(String Key, int rowNum)
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
	
	public List<String> GetPatientInfoForUpdateForAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("before if in the getpatientifno method");
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Excel:"+row.getCell(0).toString());
			System.out.println("inside if in getinfo method");
			testData.add(0, TestUtil.randomAlpha(8));//PatientFirstName
			testData.add(1, TestUtil.randomAlpha(3));//PatientLastName 
			testData.add(2, row.getCell(3).getDateCellValue().toString());//PatientDOB - Ability to generate random date is specified as a function in the excel sheet for this cell
			testData.add(3, TestUtil.randomAlphaNumeric(2) + TestUtil.randomAlpha(8) + "Dr");//PatientAddress 
			testData.add(4, TestUtil.randomAlpha(10));//PatientCity 
			//For patient state, a random value will be selected from the drop down in the UpdatePatientInfo method and will be returned back to the test
			testData.add(5, TestUtil.randomNumeric(5));//PatientZipCode 
			testData.add(6, row.getCell(8).toString());//Update confirmation message in hub
			testData.add(7, row.getCell(9).toString());//update confirmation message in admin
			testData.add(8, TestUtil.randomNumeric(10));//phno
			testData.add(9, TestUtil.randomNumeric(10));//partnerpatientid
			testData.add(10, TestUtil.randomNumeric(10));//insgrpnum
			testData.add(11, TestUtil.randomNumeric(10));//insmemnum
			testData.add(12, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//memberid
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPatientInfoForUpdateForBothReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("before if in the getpatientifno method");
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Excel:"+row.getCell(0).toString());
			System.out.println("inside if in getinfo method");
			testData.add(0, TestUtil.randomAlpha(8));//PatientFirstName
			testData.add(1, TestUtil.randomAlpha(3));//PatientLastName 
			testData.add(2, row.getCell(3).getDateCellValue().toString());//PatientDOB - Ability to generate random date is specified as a function in the excel sheet for this cell
			testData.add(3, TestUtil.randomAlphaNumeric(2) + TestUtil.randomAlpha(8) + "Dr");//PatientAddress 
			testData.add(4, TestUtil.randomAlpha(10));//PatientCity 
			//For patient state, a random value will be selected from the drop down in the UpdatePatientInfo method and will be returned back to the test
			testData.add(5, TestUtil.randomNumeric(5));//PatientZipCode 
			testData.add(6, row.getCell(8).toString());//Update confirmation message in hub
			testData.add(7, row.getCell(9).toString());//update confirmation message in admin
			testData.add(8, TestUtil.randomNumeric(10));//phno
			testData.add(9, TestUtil.randomNumeric(10));//partnerpatientid
			testData.add(10, TestUtil.randomNumeric(10));//insgrpnum
			testData.add(11, TestUtil.randomNumeric(10));//insmemnum
			testData.add(12, row.getCell(14).toString());//memberid
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetPatientInfoForUpdateForDrugReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("before if in the getpatientifno method");
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Key:"+Key);
			System.out.println("Excel:"+row.getCell(0).toString());
			System.out.println("inside if in getinfo method");
			testData.add(0, TestUtil.randomAlpha(8));//PatientFirstName
			testData.add(1, TestUtil.randomAlpha(3));//PatientLastName 
			testData.add(2, row.getCell(3).getDateCellValue().toString());//PatientDOB - Ability to generate random date is specified as a function in the excel sheet for this cell
			testData.add(3, TestUtil.randomAlphaNumeric(2) + TestUtil.randomAlpha(8) + "Dr");//PatientAddress 
			testData.add(4, TestUtil.randomAlpha(10));//PatientCity 
			//For patient state, a random value will be selected from the drop down in the UpdatePatientInfo method and will be returned back to the test
			testData.add(5, TestUtil.randomNumeric(5));//PatientZipCode 
			testData.add(6, row.getCell(8).toString());//Update confirmation message in hub
			testData.add(7, row.getCell(9).toString());//update confirmation message in admin
			testData.add(8, TestUtil.randomNumeric(10));//phno
			testData.add(9, row.getCell(11).toString());//memberid
			
			
			return testData;
		}
		
		return null;
	}
	
	public void setUpdatedPatientInfoInExcelForHub(List<String> testData, String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader1.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		 reader1.setDataInNewRow(sheetname, "PatientFirstName", rowNum, null);
		 reader1.setDataInNewRow(sheetname, "PatientFirstName", rowNum, testData.get(0));
		    
		    reader1.setDataInNewRow(sheetname, "PatientLastName", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientLastName", rowNum, testData.get(1));
		    
		    reader1.setDataInNewRow(sheetname, "PatientAddress", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientAddress", rowNum, testData.get(3));
		    
		    reader1.setDataInNewRow(sheetname, "PatientCity", rowNum, null);
			reader1.setDataInNewRow(sheetname, "PatientCity", rowNum, testData.get(4));
			
			reader1.setDataInNewRow(sheetname, "PatientZipCode", rowNum, null);
			reader1.setDataInNewRow(sheetname, "PatientZipCode", rowNum, testData.get(5));
		    
		    reader1.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, testData.get(9));
		    
		    reader1.setDataInNewRow(sheetname, "MemberID", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "MemberID", rowNum, testData.get(12));
		    
		    reader1.setDataInNewRow(sheetname, "GroupNumber",rowNum, null);
		    reader1.setDataInNewRow(sheetname, "GroupNumber", rowNum, testData.get(13));
		    
		    reader1.setDataInNewRow(sheetname, "EnrollmentStatus", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "EnrollmentStatus", rowNum, testData.get(14));
		    
		    reader1.setDataInNewRow(sheetname, "PatientDOBAfterUpdate", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientDOBAfterUpdate", rowNum, testData.get(15));		
		    
		    reader1.setDataInNewRow(sheetname, "PatientState", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientState", rowNum, testData.get(1));
		        
	}
	
	public void setUpdatedPatientInfoInExcelForAdmin(List<String> testData, String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader1.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		 reader1.setDataInNewRow(sheetname, "PatientFirstName", rowNum, null);
		 reader1.setDataInNewRow(sheetname, "PatientFirstName", rowNum, testData.get(0));
		    
		    reader1.setDataInNewRow(sheetname, "PatientLastName", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientLastName", rowNum, testData.get(1));
		    
		    reader1.setDataInNewRow(sheetname, "PatientAddress", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientAddress", rowNum, testData.get(3));
		    
		    reader1.setDataInNewRow(sheetname, "PatientCity", rowNum, null);
			reader1.setDataInNewRow(sheetname, "PatientCity", rowNum, testData.get(4));
			
			reader1.setDataInNewRow(sheetname, "PatientZipCode", rowNum, null);
			reader1.setDataInNewRow(sheetname, "PatientZipCode", rowNum, testData.get(5));
		    
		    reader1.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PartnerPatientID", rowNum, testData.get(8));
		    
		    reader1.setDataInNewRow(sheetname, "MemberID", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "MemberID", rowNum, testData.get(9));
		    
		    reader1.setDataInNewRow(sheetname, "GroupNumber",rowNum, null);
		    reader1.setDataInNewRow(sheetname, "GroupNumber", rowNum, testData.get(10));
		    
		    reader1.setDataInNewRow(sheetname, "EnrollmentStatus", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "EnrollmentStatus", rowNum, testData.get(11));
		    
		    reader1.setDataInNewRow(sheetname, "PatientDOBAfterUpdate", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientDOBAfterUpdate", rowNum, testData.get(12));	
		    
		    reader1.setDataInNewRow(sheetname, "PatientState", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "PatientState", rowNum, testData.get(13));
		    	    
	}
	
	public List<String> GetPatientAndInsuranceInfoTestData(String Key, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	//updated for replatform
			/*testData.add(0, row.getCell(28).toString());//memberID
			testData.add(1, row.getCell(2).toString());//GroupNumber 
			testData.add(2, row.getCell(3).toString());//PatientFirstName  
			testData.add(3, row.getCell(4).toString());//PatientLastName 
			testData.add(4, row.getCell(5).toString());//PatientDOB 
			testData.add(5, row.getCell(6).toString());//PatientGender 
			testData.add(6, row.getCell(7).toString());//PartnerPatientID 
			testData.add(7, row.getCell(8).toString());//PatientAddress 
			testData.add(8, row.getCell(9).toString());//PatientCity 
			testData.add(9, row.getCell(10).toString());//PatientState 
			testData.add(10, row.getCell(11).toString());//PatientZipCode  
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//PatientCellNumber 
			testData.add(12, row.getCell(23).toString());//InsCompanyName 
			testData.add(13, row.getCell(24).toString());//InsGroupNumber 
			testData.add(14, NumberToTextConverter.toText(row.getCell(25).getNumericCellValue()));//InsMemberNumber
			testData.add(15, NumberToTextConverter.toText(row.getCell(34).getNumericCellValue()));//BIN 
			testData.add(16, NumberToTextConverter.toText(row.getCell(35).getNumericCellValue()));//PCN */
			
			testData.add(0, row.getCell(21).toString());//memberID
			testData.add(1, row.getCell(10).toString());//GroupNumber 
			testData.add(2, row.getCell(2).toString());//PatientFirstName  
			testData.add(3, row.getCell(3).toString());//PatientLastName 
			testData.add(4, row.getCell(4).toString());//PatientDOB 
			//testData.add(5, row.getCell(6).toString());//PatientGender 
			//testData.add(6, row.getCell(7).toString());//PartnerPatientID 
			testData.add(7, row.getCell(5).toString());//PatientAddress 
			testData.add(8, row.getCell(6).toString());//PatientCity 
			testData.add(9, row.getCell(7).toString());//PatientState 
			testData.add(10, row.getCell(11).toString());//PatientZipCode  
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//PatientCellNumber 
			testData.add(12, row.getCell(23).toString());//InsCompanyName 
			testData.add(13, row.getCell(24).toString());//InsGroupNumber 
			testData.add(14, NumberToTextConverter.toText(row.getCell(25).getNumericCellValue()));//InsMemberNumber
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetAdminPortalLoginCredentialsRequiredWarningMessage(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//username
			testData.add(1, row.getCell(2).toString());//password
			testData.add(2, row.getCell(3).toString());//programname
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetAdminPortalLoginCredentialsForForgotPassword(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//username
			testData.add(1, TestUtil.randomAlpha(8));//password
			testData.add(2, row.getCell(3).toString());//Forgot password page URL
			testData.add(3, row.getCell(4).toString());//default select program
			
			//set the test data back to excel for password
			reader1.setDataInNewRow(sheetname, "Password", rowNum, null);
		    reader1.setDataInNewRow(sheetname, "Password", rowNum, testData.get(1));
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetTransactionsTabLinksData_DrugReimbursement(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID						
			testData.add(1, row.getCell(2).toString());//ShowProvider
			testData.add(2, row.getCell(3).toString());//ShowPatient
			
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetTransactionsTabLinksData(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID						
			testData.add(1, row.getCell(2).toString());//ShowProvider
			testData.add(2, row.getCell(3).toString());//ShowPatient
			
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetTransactionsTabLinksDataForBothReimbursement(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID						
			testData.add(1, row.getCell(2).toString());//ShowProvider
			testData.add(2, row.getCell(3).toString());//ShowPatient
			
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetTransactionsTabLinksDataForAdminReimbursement(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID						
			testData.add(1, row.getCell(2).toString());//ShowProvider
			testData.add(2, row.getCell(3).toString());//ShowPatient
			
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetBenefitsHistoryTabTestData(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//memberID
			testData.add(1, row.getCell(2).toString());//tableheading
			testData.add(2, row.getCell(3).toString());//benefitsperiodcolname 							
			testData.add(3, row.getCell(4).toString());//ActiveBenefitsPeriod
			testData.add(4, row.getCell(5).toString());//EnrollDate
			testData.add(5, row.getCell(6).toString());//ExpirationDate
			testData.add(6, row.getCell(7).toString());//RetroDate
			testData.add(7, row.getCell(8).toString());//TotalUsage
			testData.add(8, row.getCell(9).toString());//Balance
			testData.add(9, row.getCell(10).toString());//UseNumber
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetBenefitsHistoryTabTestData_DrugReimbursement(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//memberID
			testData.add(1, row.getCell(2).toString());//tableheading
			testData.add(2, row.getCell(3).toString());//benefitsperiodcolname 							
			testData.add(3, row.getCell(4).toString());//ActiveBenefitsPeriod
			testData.add(4, row.getCell(5).toString());//EnrollDate
			testData.add(5, row.getCell(6).toString());//ExpirationDate
			testData.add(6, row.getCell(7).toString());//RetroDate
			testData.add(7, row.getCell(8).toString());//TotalUsage
			testData.add(8, row.getCell(9).toString());//Balance
			testData.add(9, row.getCell(10).toString());//UseNumber
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetBenefitsHistoryTabTestData_BothDrugReimbursement(String Key, int rowNum)
	{
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		List<String> testData = new ArrayList<String>();
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//memberID
			testData.add(1, row.getCell(2).toString());//tableheading
			testData.add(2, row.getCell(3).toString());//benefitsperiodcolname 							
			testData.add(3, row.getCell(4).toString());//ActiveBenefitsPeriod
			testData.add(4, row.getCell(5).toString());//EnrollDate
			testData.add(5, row.getCell(6).toString());//ExpirationDate
			testData.add(6, row.getCell(7).toString());//RetroDate
			testData.add(7, row.getCell(8).toString());//TotalUsage
			testData.add(8, row.getCell(9).toString());//Balance
			testData.add(9, row.getCell(10).toString());//UseNumber
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GethelpDeskNotesData(String Key, int rowNum)
	{
		String oldKey = "EnrollPatient";
		String newKey = "HelpDeskNotes";
		String oldSheet = "Smoke";
		String newSheet = "Regression";
		List<String> testData = new ArrayList<String>();
		
		int rowNum1 = etd.getKeyValuePair(oldKey);
		String MemberID = copyValueToDiffRowAndDiffSheet(oldKey, newKey, oldSheet, newSheet, rowNum1, 28, rowNum, "MemberID");
		reader.getSheet(newSheet);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, MemberID);//memberID
			testData.add(1, row.getCell(2).toString());//caller
			testData.add(2, row.getCell(3).toString());//reason
			String notes = TestUtil.randomAlpha(8);
			reader.setDataInNewRow(newSheet, "NotesText", rowNum, notes);
			testData.add(3, row.getCell(4).toString());//help desk notes text
			testData.add(4, row.getCell(5).toString());//Reason		
			testData.add(5, row.getCell(6).toString());//Notes
			testData.add(6, row.getCell(7).toString());//CardLoad
			testData.add(7, row.getCell(8).toString());//OriginatedFrom
			testData.add(8, row.getCell(9).toString());//CreatedBy
			testData.add(9, row.getCell(10).toString());//CreatedDate
			testData.add(10, row.getCell(11).toString());//ModifiedBy
			testData.add(11, row.getCell(12).toString());//ModifiedDate
			testData.add(12, row.getCell(13).toString());//Action
			testData.add(13, row.getCell(14).toString());//updates to existing notes
			testData.add(14, row.getCell(15).toString());//update to caller dropdown
			testData.add(15, row.getCell(16).toString());//update to reason dropdown
			testData.add(16, row.getCell(17).toString());//notes added msg
			testData.add(17, row.getCell(18).toString());//notes updated msg
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GethelpDeskNotesDataForBothReimbursement(String Key, int rowNum)
	{
		String oldKey = "EnrollBothTypePatient";
		String newKey = "HelpDeskNotes";
		String oldSheet = "Smoke";
		String newSheet = "Regression";
		List<String> testData = new ArrayList<String>();
		
		int rowNum1 = etd.getKeyValuePair(oldKey);
		String MemberID = copyValueToDiffRowAndDiffSheet(oldKey, newKey, oldSheet, newSheet, rowNum1, 28, rowNum, "MemberID");
		reader.getSheet(newSheet);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, MemberID);//memberID
			testData.add(1, row.getCell(2).toString());//caller
			testData.add(2, row.getCell(3).toString());//reason
			String notes = TestUtil.randomAlpha(8);
			reader.setDataInNewRow(newSheet, "NotesText", rowNum, notes);
			testData.add(3, row.getCell(4).toString());//help desk notes text
			testData.add(4, row.getCell(5).toString());//Reason		
			testData.add(5, row.getCell(6).toString());//Notes
			testData.add(6, row.getCell(7).toString());//CardLoad
			testData.add(7, row.getCell(8).toString());//OriginatedFrom
			testData.add(8, row.getCell(9).toString());//CreatedBy
			testData.add(9, row.getCell(10).toString());//CreatedDate
			testData.add(10, row.getCell(11).toString());//ModifiedBy
			testData.add(11, row.getCell(12).toString());//ModifiedDate
			testData.add(12, row.getCell(13).toString());//Action
			testData.add(13, row.getCell(14).toString());//updates to existing notes
			testData.add(14, row.getCell(15).toString());//update to caller dropdown
			testData.add(15, row.getCell(16).toString());//update to reason dropdown
			testData.add(16, row.getCell(17).toString());//notes added msg
			testData.add(17, row.getCell(18).toString());//notes updated msg
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GethelpDeskNotesDataForAdminReimbursement(String Key, int rowNum)
	{
		String oldKey = "EnrollAdminReimbursementPatient";
		String newKey = "HelpDeskNotes";
		String oldSheet = "Smoke";
		String newSheet = "Regression";
		List<String> testData = new ArrayList<String>();
		
		int rowNum1 = etd.getKeyValuePair(oldKey);
		String MemberID = copyValueToDiffRowAndDiffSheet(oldKey, newKey, oldSheet, newSheet, rowNum1, 28, rowNum, "MemberID");
		reader.getSheet(newSheet);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, MemberID);//memberID
			testData.add(1, row.getCell(2).toString());//caller
			testData.add(2, row.getCell(3).toString());//reason
			String notes = TestUtil.randomAlpha(8);
			reader.setDataInNewRow(newSheet, "NotesText", rowNum, notes);
			testData.add(3, row.getCell(4).toString());//help desk notes text
			testData.add(4, row.getCell(5).toString());//Reason		
			testData.add(5, row.getCell(6).toString());//Notes
			testData.add(6, row.getCell(7).toString());//CardLoad
			testData.add(7, row.getCell(8).toString());//OriginatedFrom
			testData.add(8, row.getCell(9).toString());//CreatedBy
			testData.add(9, row.getCell(10).toString());//CreatedDate
			testData.add(10, row.getCell(11).toString());//ModifiedBy
			testData.add(11, row.getCell(12).toString());//ModifiedDate
			testData.add(12, row.getCell(13).toString());//Action
			testData.add(13, row.getCell(14).toString());//updates to existing notes
			testData.add(14, row.getCell(15).toString());//update to caller dropdown
			testData.add(15, row.getCell(16).toString());//update to reason dropdown
			testData.add(16, row.getCell(17).toString());//notes added msg
			testData.add(17, row.getCell(18).toString());//notes updated msg
			
			return testData;
		}
		
		return null;
		
	}
	
	public List<String> GetPhysicianNewPageRequiredFields(String Key, int rowNum)
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
	public List<String> HCPGetPhysicianNewPageRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "HCP";
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
	public List<String> E2EScenariosGetPhysicianNewPageRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "E2EScenarios";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
//	                System.out.println("$$$" + testData.add(cell.getStringCellValue()));
	         }
			 
			 return testData;
		}
		
		return null;
	}
	
	public List<String> SmokeGetPhysicianNewPageRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
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
	
	public List<String> GetPhysicianNewPageRequiredFields1(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Fax";
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
	public List<String> E2ECTPRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "E2ECTP";
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
	public List<String> RegressionHCP(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "HCP";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			Iterator<Cell> cellIterator = row.cellIterator();
			 while (cellIterator.hasNext()) 
			 {
	               Cell cell = cellIterator.next();
	                testData.add(cell.getStringCellValue());
	                System.out.println("**********" +cell);
	         }
			 
			 return testData;
		}
		
		return null;
	}

	public List<String> FaxGetPhysicianNewPageRequiredFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Fax";
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

	
	public List<String> GetSmokedata(String Key, int rowNum)
	{
		System.out.println("GetSmokedata inside");
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("GetSmokedata inside");
		
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
	public List<String> GetPhysicianAddressFields(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
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
	public List<String> GetFindPageGridColumnNames(String Key, int rowNum)
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
	
	public List<String> GetPhysicianInfoTestDataForUpdate(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//PhysicianNPI
			testData.add(1, row.getCell(2).toString());//PhysicianNPI
			testData.add(2, row.getCell(3).toString());//confirmation msg
			
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPhysicianPatientTabColumns(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//Physician NPI
			//The following fields are the column names in the Patients tab of providers page											
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
	
	public List<String> GetPatientDataForPatientAndCardInfo(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//The following fields are the patient data that we captured from the patients tab in Providers page onto the excel to be cross checked with the patient and card info page
			testData.add(0, row.getCell(13).toString());//PatientNameValue						
			testData.add(1, row.getCell(14).toString());//CityValue
			testData.add(2, row.getCell(15).toString());//ZipValue
			testData.add(3, row.getCell(16).toString());//MemberIDValue
			testData.add(4, row.getCell(17).toString());//PartnerPatientIDValue
			testData.add(5, row.getCell(18).toString());//CardIDValue
			testData.add(6, row.getCell(19).toString());//StateValue
			testData.add(7, row.getCell(20).toString());//providernametypevalue
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetProviderNotesData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//NPI
			testData.add(1, row.getCell(2).toString());//caller
			testData.add(2, row.getCell(3).toString());//reason
			String notes = TestUtil.randomAlpha(8);
			reader.setDataInNewRow(sheetname, "NotesText", rowNum, notes);
			testData.add(3, row.getCell(4).toString());//help desk notes text
			testData.add(4, row.getCell(5).toString());//Reason		
			testData.add(5, row.getCell(6).toString());//Notes
			testData.add(6, row.getCell(7).toString());//CardLoad
			testData.add(7, row.getCell(8).toString());//OriginatedFrom
			testData.add(8, row.getCell(9).toString());//CreatedBy
			testData.add(9, row.getCell(10).toString());//CreatedDate
			testData.add(10, row.getCell(11).toString());//ModifiedBy
			testData.add(11, row.getCell(12).toString());//ModifiedDate
			testData.add(12, row.getCell(13).toString());//Action
			testData.add(13, row.getCell(14).toString());//updates to existing notes
			testData.add(14, row.getCell(15).toString());//update to caller dropdown
			testData.add(15, row.getCell(16).toString());//update to reason dropdown
			testData.add(16, row.getCell(17).toString());//notes added msg
			testData.add(17, row.getCell(18).toString());//notes updated msg
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetGroupPracticeRequiredFields(String Key, int rowNum)
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
	
	public List<String> GetGroupPracticeMaxCharTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		

		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//ProviderNPI 						
								
			testData.add(1, row.getCell(2).toString());//GPName
			testData.add(2, row.getCell(3).toString());//FirstName
			testData.add(3, row.getCell(4).toString());//LastName
			testData.add(4, row.getCell(5).toString());//AddressOne
			testData.add(5, row.getCell(6).toString());//City
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//Zip
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//Phone
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//TaxField
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//NPICharLimit				
			testData.add(10, NumberToTextConverter.toText(row.getCell(11).getNumericCellValue()));//SupervisorName
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//Firstlastname
			testData.add(12, NumberToTextConverter.toText(row.getCell(13).getNumericCellValue()));//Address
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//CityCharLimit
			testData.add(14, NumberToTextConverter.toText(row.getCell(15).getNumericCellValue()));//ZipCharlimit
			testData.add(15, NumberToTextConverter.toText(row.getCell(16).getNumericCellValue()));//PhoneTaxCharLimit
			testData.add(16, NumberToTextConverter.toText(row.getCell(17).getNumericCellValue()));//FaxTaxCharLimit
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetStatesList(String Key, int rowNum)
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
	
	public List<String> GetGroupPracticeSpecialCharTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//GPName							
			testData.add(1, row.getCell(2).toString());//FirstName
			testData.add(2, row.getCell(3).toString());//LastName
			testData.add(3, row.getCell(4).toString());//AddressOne
			testData.add(4, row.getCell(5).toString());//City
			testData.add(5, row.getCell(6).toString());//State
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//Zip
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//Phone
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//TaxField
			testData.add(9, row.getCell(10).toString());//Confirmation msg one
			testData.add(10, row.getCell(11).toString());//Confirmation msg two
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetGroupPracticeCreateTestData(String Key, int rowNum)
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
			reader.setCellData(sheetname, "GPName", rowNum, null);
			reader.setDataInNewRow(sheetname, "GPName", rowNum, testData.get(2));
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
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetGroupPracticeFindTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//lastname											
			testData.add(1, row.getCell(2).toString());//PracticeLocationName
			testData.add(2, row.getCell(3).toString());//ContactName
			testData.add(3, row.getCell(4).toString());//Address
			testData.add(4, row.getCell(5).toString());//City
			testData.add(5, row.getCell(6).toString());//State
			testData.add(6, row.getCell(7).toString());//Zip
			testData.add(7, row.getCell(8).toString());//Territory
			testData.add(8, row.getCell(9).toString());//CardID
			testData.add(9, row.getCell(10).toString());//PartnerPracticeID
			testData.add(10, row.getCell(11).toString());//CRXPhysicianID
			testData.add(11, row.getCell(12).toString());//ProviderType
			testData.add(12, row.getCell(13).toString());//ProviderID
			testData.add(13, row.getCell(14).toString());//NPI
			testData.add(14, row.getCell(15).toString());//TaxID
			testData.add(15, row.getCell(16).toString());//Action
			
			
			return testData;
			
		}
		
		return null;
		
	}	
	
	public List<String> GetGroupPracticeAndCardInfoData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(16).toString());//PracticeLocationNameValue												
			testData.add(1, row.getCell(17).toString());//ContactNameValue
			testData.add(2, row.getCell(18).toString());//AddressValue
			testData.add(3, row.getCell(19).toString());//CityValue
			testData.add(4, row.getCell(20).toString());//StateValue
			testData.add(5, row.getCell(21).toString());//ZipValue
			//testData.add(6, NumberToTextConverter.toText(row.getCell(23).getNumericCellValue()));//PartnerPracticeID
			testData.add(6, row.getCell(22).toString());//PartnerPracticeID
			//testData.add(7, row.getCell(24).toString());//CRXPhysicianID
			testData.add(7, row.getCell(23).toString());//ProviderTypeValue
			testData.add(8, row.getCell(24).toString());//ProviderIDValue
			testData.add(9, row.getCell(25).toString());//ParentProviderID
			testData.add(10, row.getCell(26).toString());//NPI
			testData.add(11, row.getCell(27).toString());//TaxID
		/*	testData.add(8, NumberToTextConverter.toText(row.getCell(25).getNumericCellValue()));//ProviderIDValue
			testData.add(9, NumberToTextConverter.toText(row.getCell(26).getNumericCellValue()));//ParentProviderID
			testData.add(10, NumberToTextConverter.toText(row.getCell(27).getNumericCellValue()));//NPI
			testData.add(11, NumberToTextConverter.toText(row.getCell(28).getNumericCellValue()));//TaxID */
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetGPPGListPageTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//Links
			testData.add(1, row.getCell(2).toString());//ProviderGroupNameCol								
			testData.add(2, row.getCell(3).toString());//ContactName
			testData.add(3, row.getCell(4).toString());//Address
			testData.add(4, row.getCell(5).toString());//City
			testData.add(5, row.getCell(6).toString());//State
			testData.add(6, row.getCell(7).toString());//Zip
			testData.add(7, row.getCell(8).toString());//PartnerPracticeIDCol
			testData.add(8, row.getCell(9).toString());//CrxPhysicianIDCol
			testData.add(9, row.getCell(10).toString());//ProviderTypeCol
			testData.add(10, row.getCell(11).toString());//ProviderIDCol
			testData.add(11, row.getCell(12).toString());//ParentProviderIDCol
			testData.add(12, row.getCell(13).toString());//NPICol
			testData.add(13, row.getCell(14).toString());//TaxIDCol
			testData.add(14, row.getCell(15).toString());//ActionCol
			testData.add(15, row.getCell(16).toString());//ActionCol
			
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetGPPGListPageAlphabetLinks(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//Links
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetGPAndCardInfoTestDataForUpdate(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//lastName
			testData.add(1, row.getCell(2).toString());//Provider Type
			testData.add(2, row.getCell(3).toString());//confirmation msg
			
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetProvidersTabRequiredFieldsTestData(String Key, int rowNum)
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
	
	public List<String> GetPGGPProvidersTabTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//Providername
			testData.add(1, row.getCell(2).toString());//Providername
			testData.add(2, row.getCell(3).toString());//Providername
			testData.add(3, row.getCell(4).toString());//ProviderContactLastName
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//ProviderNPI	
			testData.add(5, row.getCell(6).toString());//AddConfirmationMsg
			testData.add(6, row.getCell(7).toString());//ProviderName							
			testData.add(7, row.getCell(8).toString());//ContactName
			testData.add(8, row.getCell(9).toString());//Address
			testData.add(9, row.getCell(10).toString());//City
			testData.add(10, row.getCell(11).toString());//State
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//Zip
			testData.add(12, row.getCell(13).toString());//Territory
			testData.add(13, row.getCell(14).toString());//ProviderType
			testData.add(14, row.getCell(15).toString());//BOLastName
			return testData;
		}
		 
		return null;
	}
	
	public List<String> GetPGGPProvidersTabHeaderCols(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{								
			testData.add(0, row.getCell(1).toString());//ProviderName
			testData.add(1, row.getCell(2).toString());//ContactName
			testData.add(2, row.getCell(3).toString());//Address
			testData.add(3, row.getCell(4).toString());//City
			testData.add(4, row.getCell(5).toString());//State
			testData.add(5, row.getCell(6).toString());//Zip
			testData.add(6, row.getCell(7).toString());//Territory
			testData.add(7, row.getCell(8).toString());//CardID
			testData.add(8, row.getCell(9).toString());//ProviderType
			
			return testData;
			
		}
		
		return null;
	}
	
	
/* ******************************************************************************************************************************************************* */	
	
	/*	public String copyMemberIDToDiffRow(String Key, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row1 = Xls_Reader.sheet.getRow(1);//This row has memberID
		String MemberID = row1.getCell(28).toString();
		System.out.println("memberID: "+MemberID);
		Row row2 = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("copy method before if key value:"+Key);
		System.out.println("copy method before if rowNum value:"+rowNum);
		System.out.println("row2.getCell(0).toString(): "+row2.getCell(0).toString());
		if(Key.equalsIgnoreCase(row2.getCell(0).toString()))
		{
			System.out.println("copy method after if key value:"+Key);
			System.out.println("copy method after if rowNum value:"+rowNum);
			reader.copyCellData(sheetname, "MemberID", rowNum, MemberID);
			return MemberID;
		}
		return null;
	}
		
	
	public String copyPatientFirstNameToDiffRow(String Key, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row1 = Xls_Reader.sheet.getRow(1);//This row has memberID
		String PatientFirstName = row1.getCell(3).toString();
		System.out.println("memberID: "+PatientFirstName);
		Row row2 = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("copy method before if key value:"+Key);
		System.out.println("copy method before if rowNum value:"+rowNum);
		System.out.println("row2.getCell(0).toString(): "+row2.getCell(0).toString());
		if(Key.equalsIgnoreCase(row2.getCell(0).toString()))
		{
			System.out.println("copy method after if key value:"+Key);
			System.out.println("copy method after if rowNum value:"+rowNum);
			reader.copyCellData(sheetname, "PatientFirstName", rowNum, PatientFirstName);
			return PatientFirstName;
		}
		return null;
	}
	
	public String copyPartnerPatientIDToDiffRow(String Key, int rowNum)
	{
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row1 = Xls_Reader.sheet.getRow(1);//This row has memberID
		String PartnerPatientID = row1.getCell(7).toString();
		System.out.println("memberID: "+PartnerPatientID);
		Row row2 = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("copy method before if key value:"+Key);
		System.out.println("copy method before if rowNum value:"+rowNum);
		System.out.println("row2.getCell(0).toString(): "+row2.getCell(0).toString());
		if(Key.equalsIgnoreCase(row2.getCell(0).toString()))
		{
			System.out.println("copy method after if key value:"+Key);
			System.out.println("copy method after if rowNum value:"+rowNum);
			reader.copyCellData(sheetname, "PartnerPatientID", rowNum, PartnerPatientID);
			return PartnerPatientID;
		}
		return null;
	} */
		
	
		
	

public List<String> GetPhysicianSearchTestData(String Key, int rowNum)
{
	List<String> testData = new ArrayList<String>();
	String sheetname = "Regression";
	reader.getSheet(sheetname);
	Row row = Xls_Reader.sheet.getRow(rowNum);
	
	if(Key.equalsIgnoreCase(row.getCell(0).toString()))
	{
												
		testData.add(0, row.getCell(1).toString());//ProviderName
		testData.add(1, row.getCell(2).toString());//ContactName
		testData.add(2, row.getCell(3).toString());//Address
		testData.add(3, row.getCell(4).toString());//City
		testData.add(4, row.getCell(5).toString());//State
		testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//Zip
		testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//PartnerPracticeID
		testData.add(7, row.getCell(8).toString());//ProviderType
		testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//ProviderID
		testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//ParentProviderID
		testData.add(10, NumberToTextConverter.toText(row.getCell(11).getNumericCellValue()));//NPI
		testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//TaxID
		 
		 return testData;
	}
	
	return null;
}



	
}




	
	


