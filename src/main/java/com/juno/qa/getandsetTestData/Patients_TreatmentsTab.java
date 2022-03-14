package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;


import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortal_Patients_MessagesTabPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class Patients_TreatmentsTab extends TestBase {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	AdminPortal_Patients_MessagesTabPage apm = new AdminPortal_Patients_MessagesTabPage();

	CommonFunctions cf = new CommonFunctions();
	
	public List<String> GetRejectReasonsListNames(){
		List<String> testData = new ArrayList<String>();
		testData.add(0, "Max Benefit Exceeded");
		testData.add(1, "Duplicate claim");
		testData.add(2, "No Patient Responsibility");
		testData.add(3, "No Eligible Charges");
		testData.add(4, "DOS outside eligibility Period");
		testData.add(5, "Timely Filing - EOB");
		testData.add(6, "Missing Info Claim Form Provider");
		testData.add(7, "Government Payer");
		testData.add(8, "Missing Info EOB");
		testData.add(9, "Missing Info Check Request Form");
		testData.add(10, "Missing info Patient Receipt");
		testData.add(11, "Primary Payer Denial");
		testData.add(12, "Insurance Mismatch");
		testData.add(13, "Other");
		
		
		
		return testData;
	}
	
	public List<String> GetVerifyReadOnlyFieldsInTreatmentsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID											
			testData.add(1, row.getCell(2).toString());//readonly property value
			testData.add(2, row.getCell(3).toString());//hidden property value
			testData.add(3, row.getCell(4).toString());//readonlyattributevalue
			testData.add(4, row.getCell(5).toString());//disabledattributevalue
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetVerifyReadOnlyFieldsInTreatmentsTestDataForAdminReimursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID											
			testData.add(1, row.getCell(2).toString());//readonly property value
			testData.add(2, row.getCell(3).toString());//hidden property value
			testData.add(3, row.getCell(4).toString());//readonlyattributevalue
			testData.add(4, row.getCell(5).toString());//disabledattributevalue
			
			return testData;
		}
		
		return null;
	}
	
	public List<String> GetVerifyRequiredFieldsInTreatmentsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID	
			testData.add(1, row.getCell(2).toString());//copay
			testData.add(2, row.getCell(3).toString());//EOBFaxes															
			testData.add(3, row.getCell(4).toString());//OutgoingFax#
			testData.add(4, row.getCell(5).toString());//DOS
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, row.getCell(8).toString());//NDC
			testData.add(8, row.getCell(9).toString());//EOBDate
			testData.add(9, row.getCell(10).toString());//Name
			testData.add(10, row.getCell(11).toString());//Address
			testData.add(11, row.getCell(12).toString());//City
			testData.add(12, row.getCell(13).toString());//State
			testData.add(13, row.getCell(14).toString());//Zip
			testData.add(14, row.getCell(15).toString());//Phone
			testData.add(15, row.getCell(16).toString());//BillingProvider
			testData.add(16, row.getCell(17).toString());//TreatingPractice
			testData.add(17, row.getCell(18).toString());//Physician
			testData.add(18, row.getCell(19).toString());//req msg under add button
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetVerifyRequiredFieldsInTreatmentsTestData_BothDrugReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID	
			testData.add(1, row.getCell(2).toString());//copay
			testData.add(2, row.getCell(3).toString());//EOBFaxes															
			testData.add(3, row.getCell(4).toString());//OutgoingFax#
			testData.add(4, row.getCell(5).toString());//DOS
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, row.getCell(8).toString());//NDC
			testData.add(8, row.getCell(9).toString());//EOBDate
			testData.add(9, row.getCell(10).toString());//Name
			testData.add(10, row.getCell(11).toString());//Address
			testData.add(11, row.getCell(12).toString());//City
			testData.add(12, row.getCell(13).toString());//State
			testData.add(13, row.getCell(14).toString());//Zip
			testData.add(14, row.getCell(15).toString());//Phone
			testData.add(15, row.getCell(16).toString());//BillingProvider
			testData.add(16, row.getCell(17).toString());//TreatingPractice
			testData.add(17, row.getCell(18).toString());//Physician
			testData.add(18, row.getCell(19).toString());//req msg under add button
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetVerifyRequiredFieldsInTreatmentsTestDataAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID											
			testData.add(1, row.getCell(2).toString());//copay
			testData.add(2, row.getCell(3).toString());//EOBFaxes															
			testData.add(3, row.getCell(4).toString());//OutgoingFax#
			testData.add(4, row.getCell(5).toString());//DOS
			testData.add(5, row.getCell(6).toString());//EOBDate
			testData.add(6, row.getCell(7).toString());//Name
			testData.add(7, row.getCell(8).toString());//Address
			testData.add(8, row.getCell(9).toString());//City
			testData.add(9, row.getCell(10).toString());//State
			testData.add(10, row.getCell(11).toString());//Zip
			testData.add(11, row.getCell(12).toString());//BillingProvider
			testData.add(12, row.getCell(13).toString());//TreatingPractice
			testData.add(13, row.getCell(14).toString());//Physician
			testData.add(14, row.getCell(15).toString());//AddButtonValidations
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetVerifyIndividualRequiredFieldsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																
			testData.add(1, row.getCell(2).toString());//EOBDate
			testData.add(2, row.getCell(3).toString());//Jcode															
			testData.add(3, row.getCell(4).toString());//Quantity
			testData.add(4, row.getCell(5).toString());//NDC
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber
			testData.add(6, row.getCell(7).toString());//DOS
			testData.add(7, row.getCell(8).toString());//InsuranceNameOnEOB
			testData.add(8, row.getCell(9).toString());//Copay
			testData.add(9, row.getCell(10).toString());//BillingName
			testData.add(10, row.getCell(11).toString());//PracticeName
			testData.add(11, row.getCell(12).toString());//PhysicianLastName
			testData.add(12, row.getCell(13).toString());//EOBDateRequired
			testData.add(13, row.getCell(14).toString());//JCodeRequired
			testData.add(14, row.getCell(15).toString());//QuantityRequired
			testData.add(15, row.getCell(16).toString());//NDCRequired
			testData.add(16, row.getCell(17).toString());//DOSCannotBeAfterEOB	
			testData.add(17, row.getCell(18).toString());//MsgUnderAddButtonForEOBDate
			testData.add(18, row.getCell(19).toString());//MsgUnderAddButtonForJCode
			testData.add(19, row.getCell(20).toString());//MsgUnderAddButtonForQty
			testData.add(20, row.getCell(21).toString());//MsgUnderAddButtonForNDC
			testData.add(21, row.getCell(22).toString());//FirstName
			testData.add(22, row.getCell(23).toString());//lastName
			testData.add(23, row.getCell(24).toString());//FaxType		
			testData.add(24, row.getCell(25).toString());//FaxStatus
			testData.add(25, row.getCell(26).toString());//EOBStatus
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetVerifyIndividualRequiredFieldsTestData_BothDrugReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID																
			testData.add(1, row.getCell(2).toString());//EOBDate
			testData.add(2, row.getCell(3).toString());//Jcode															
			testData.add(3, row.getCell(4).toString());//Quantity
			testData.add(4, row.getCell(5).toString());//NDC
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber
			testData.add(6, row.getCell(7).toString());//DOS
			testData.add(7, row.getCell(8).toString());//InsuranceNameOnEOB
			testData.add(8, row.getCell(9).toString());//Copay
			testData.add(9, row.getCell(10).toString());//BillingName
			testData.add(10, row.getCell(11).toString());//PracticeName
			testData.add(11, row.getCell(12).toString());//PhysicianLastName
			testData.add(12, row.getCell(13).toString());//EOBDateRequired
			testData.add(13, row.getCell(14).toString());//JCodeRequired
			testData.add(14, row.getCell(15).toString());//QuantityRequired
			testData.add(15, row.getCell(16).toString());//NDCRequired
			testData.add(16, row.getCell(17).toString());//DOSCannotBeAfterEOB	
			testData.add(17, row.getCell(18).toString());//MsgUnderAddButtonForEOBDate
			testData.add(18, row.getCell(19).toString());//MsgUnderAddButtonForJCode
			testData.add(19, row.getCell(20).toString());//MsgUnderAddButtonForQty
			testData.add(20, row.getCell(21).toString());//MsgUnderAddButtonForNDC
			testData.add(21, row.getCell(22).toString());//FirstName
			testData.add(22, row.getCell(23).toString());//lastName
			testData.add(23, row.getCell(24).toString());//FaxType		
			testData.add(24, row.getCell(25).toString());//FaxStatus
			testData.add(25, row.getCell(26).toString());//EOBStatus
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetVerifyIndividualRequiredFieldsTestDataAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID																		
			testData.add(1, row.getCell(2).toString());//EOBDate
			testData.add(2, row.getCell(3).toString());//OutgoingFaxNumber
			testData.add(3, row.getCell(4).toString());//DOS
			testData.add(4, row.getCell(5).toString());//InsuranceNameOnEOB
			testData.add(5, row.getCell(6).toString());//CPTCode
			testData.add(6, row.getCell(7).toString());//Copay
			testData.add(7, row.getCell(8).toString());//BillingName
			testData.add(8, row.getCell(9).toString());//PracticeName
			testData.add(9, row.getCell(10).toString());//PhysicianLastName
			testData.add(10, row.getCell(11).toString());//EOBDateRequired
			testData.add(11, row.getCell(12).toString());//DOSCannotBeAfterEOB	
			testData.add(12, row.getCell(13).toString());//MsgUnderAddButtonForEOBDate
			testData.add(13, row.getCell(14).toString());//FirstName
			testData.add(14, row.getCell(15).toString());//lastName
			testData.add(15, row.getCell(16).toString());//FaxType		
			testData.add(16, row.getCell(17).toString());//FaxStatus
			testData.add(17, row.getCell(18).toString());//EOBStatus
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetRejectReasonDropdownValidationsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																
			testData.add(1, row.getCell(2).toString());//TreatmentStatus	
			testData.add(2, row.getCell(3).toString());//RejectReasonDropdown															
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetRejectReasonDropdownValidationsTestDataForAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID																
			testData.add(1, row.getCell(2).toString());//TreatmentStatus	
			testData.add(2, row.getCell(3).toString());//RejectReasonDropdown															
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetEOBPriorToDosErrorMsg(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{																
			testData.add(0, row.getCell(1).toString());//ValidationMsg	
			testData.add(1, row.getCell(2).toString());//DOSDate	
			testData.add(2, row.getCell(3).toString());//EOBDate	
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetUpdateRejectPopUpForZeroCopayTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																	
		//	testData.add(1, row.getCell(2).toString());//CardID	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
	//		testData.add(5, row.getCell(6).toString());//PartnerPatientID	
	//		testData.add(6, row.getCell(7).toString());//PatientFirstName	
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//ZeroCopay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//FindPageFaxStatus	
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetRejectedDuplicateTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//ReasonForHoldInGrid

			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetDOSErrorForDOSLessThanRetroTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																																		
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOSDate
			testData.add(13, row.getCell(14).toString());//EOBDate				
			testData.add(14, row.getCell(15).toString());//DOSFieldError	
			testData.add(15, row.getCell(16).toString());//DOSErrorHeadingAdd
			testData.add(16, row.getCell(17).toString());//DOSErrorMsgAdd
			testData.add(17, row.getCell(18).toString());//ReasonForHoldInGrid
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetClaimBenefitsAfterMaxBenefitsTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																																		
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOSDate
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//StatusInGrid	
			testData.add(15, row.getCell(16).toString());//ReasonForHoldIngrid
			testData.add(16, row.getCell(17).toString());//MaxBenReachError

			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetClaimBenefitsAfterMaxBenefitsTestDataAdminReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																																		
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, row.getCell(6).toString());//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB
			testData.add(7, row.getCell(8).toString());//CPTCode	
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOSDate
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//StatusInGrid	
			testData.add(15, row.getCell(16).toString());//ReasonForHoldIngrid
			testData.add(16, row.getCell(17).toString());//MaxBenReachError

			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetTreatmentsTabRejectReasonDropdownValues(String Key, int rowNum)
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
				
			 return testData;
				
		}
		return null;
		
		
	}
	
	public List<String> GetPatientPaysDefaultTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
	
			//testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//Amount
			testData.add(0, row.getCell(1).toString());//amount
			
			return testData;
			
		}
		
		return null;
	}
	//	BOName	BOLastName	BONPI	PracticeName	PracticeNPI	PhysicianLastName	PhysicianNPI	BOFirstname	BOAddress	BOCity	BOState	BOZip	BOPhone	BOFaxNum	BOProviderID	PracticeName	PracticeAddress	PracticeCity	PracticeState	PracticeZip	PracticePhone	PracticeFax	PracticeTaxID	PracticeProviderID	PhysicianFirstName	PhysicianAddress	PhysicianCity	PhysicianState	PhysicianZip	PhysicianPhone	PhysicianFax	PhysicianProviderID
																														
	public List<String> GetProviderSearchesTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//BOName																																		
			testData.add(1, row.getCell(2).toString());//BOLastName	
			testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//BONPI	
			testData.add(3, row.getCell(4).toString());//PracticeName
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//PracticeNPI	
			testData.add(5, row.getCell(6).toString());//PhysicianLastName	
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//PhysicianNPI
			testData.add(7, row.getCell(8).toString());//BOFirstname	
			testData.add(8, row.getCell(9).toString());//BOAddress	
			testData.add(9, row.getCell(10).toString());//BOCity
			testData.add(10, row.getCell(11).toString());//BOState	
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//BOZip	
			testData.add(12, NumberToTextConverter.toText(row.getCell(13).getNumericCellValue()));//BOPhone
			testData.add(13, NumberToTextConverter.toText(row.getCell(14).getNumericCellValue()));//BOFaxNum	
			testData.add(14, NumberToTextConverter.toText(row.getCell(15).getNumericCellValue()));//BOProviderID	
			testData.add(15, row.getCell(16).toString());//PracticeName
			testData.add(16, row.getCell(17).toString());//PracticeAddress
			testData.add(17, row.getCell(18).toString());//PracticeCity	
			testData.add(18, row.getCell(19).toString());//PracticeState
			testData.add(19, NumberToTextConverter.toText(row.getCell(20).getNumericCellValue()));//PracticeZip	
			testData.add(20, NumberToTextConverter.toText(row.getCell(21).getNumericCellValue()));//PracticePhone	
			testData.add(21, NumberToTextConverter.toText(row.getCell(22).getNumericCellValue()));//PracticeFax
			testData.add(22, row.getCell(23).toString());//PracticeTaxID	
			testData.add(23, NumberToTextConverter.toText(row.getCell(24).getNumericCellValue()));//PracticeProviderID	
			testData.add(24, row.getCell(25).toString());//PhysicianFirstName
			testData.add(25, row.getCell(26).toString());//PhysicianAddress
			testData.add(26, row.getCell(27).toString());//PhysicianCity
			testData.add(27, row.getCell(28).toString());//PhysicianState	
			testData.add(28, NumberToTextConverter.toText(row.getCell(29).getNumericCellValue()));//PhysicianZip	
			testData.add(29, NumberToTextConverter.toText(row.getCell(30).getNumericCellValue()));//PhysicianPhone
			testData.add(30, NumberToTextConverter.toText(row.getCell(31).getNumericCellValue()));//PhysicianFax
			testData.add(31, NumberToTextConverter.toText(row.getCell(32).getNumericCellValue()));//PhysicianProviderID
			testData.add(32, row.getCell(33).toString());//BillingName

			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetResetBOAutoSuggestSearchTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																																		
			testData.add(0, row.getCell(1).toString());//BOState
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetResetBOAutoSuggestSearchForBothTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																																		
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetResetGPAutoSuggestSearchTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			testData.add(0, row.getCell(1).toString());//MemberID																																		
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetSelectBOFromDropdownForTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID																													
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus															
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//EOBDate
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//NDC
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//OutgoingFaxNumber
			testData.add(9, row.getCell(10).toString());//DOS
			testData.add(10, row.getCell(11).toString());//InsuranceNameOnEOB
			String copay = TestUtil.randomNumeric(2);
			testData.add(11, copay);//Copay
			testData.add(12, row.getCell(12).toString());//PracticeName
			testData.add(13, row.getCell(13).toString());//PhysicianLastName
			testData.add(14, row.getCell(14).toString());//PatientFirstName
			testData.add(15, row.getCell(15).toString());//PatientLastName
			
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetSelectBOFromDropdownForTreatmentForBothReimbursementTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//MemberID	FaxType	FaxStatus	EOBStatus	EOBDate	Quantity	NDC	OutgoingFaxNumber	DOS	InsuranceNameOnEOB	PracticeName	PhysicianLastName	PatientFirstName	PatientLastName	BOName
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus															
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//EOBDate
			testData.add(5, row.getCell(6).toString());//Quantity
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//NDC
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//OutgoingFaxNumber
			testData.add(8, row.getCell(9).toString());//DOS
			testData.add(9, row.getCell(10).toString());//InsuranceNameOnEOB
			String copay1 = TestUtil.randomNumeric(4);
			String copay2 = TestUtil.randomNumeric(4);
			testData.add(10, copay1);//DrugCopay
			testData.add(11, copay2);//AdminCopay
			testData.add(12, row.getCell(11).toString());//PracticeName
			testData.add(13, row.getCell(12).toString());//PhysicianLastName
			testData.add(14, row.getCell(13).toString());//PatientFirstName
			testData.add(15, row.getCell(14).toString());//PatientLastName
			testData.add(16, row.getCell(15).toString());//BOName
			
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetUploadInsuranceCardTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("Inside get fax data");
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Inside if");
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus															
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//EOBDate
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//NDC
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//OutgoingFaxNumber
			testData.add(9, row.getCell(10).toString());//DOS
			testData.add(10, row.getCell(11).toString());//InsuranceNameOnEOB
			String copay = TestUtil.randomNumeric(4);
			testData.add(11, copay);//Copay
			testData.add(12, row.getCell(12).toString());//PracticeName
			testData.add(13, row.getCell(13).toString());//PhysicianLastName
			testData.add(14, row.getCell(14).toString());//PatientFirstName
			testData.add(15, row.getCell(15).toString());//PatientLastName	
			testData.add(16, row.getCell(16).toString());//BOName
			testData.add(17, row.getCell(17).toString());//FaxType			
			testData.add(18, row.getCell(18).toString());//Type
			testData.add(19, row.getCell(19).toString());//FaxStatus
			testData.add(20, row.getCell(20).toString());//PartnerPatientID
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetUploadOtherFileTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("Inside get fax data");
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			System.out.println("Inside if");
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus															
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//EOBDate
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//NDC
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//OutgoingFaxNumber
			testData.add(9, row.getCell(10).toString());//DOS
			testData.add(10, row.getCell(11).toString());//InsuranceNameOnEOB
			String copay = TestUtil.randomNumeric(4);
			testData.add(11, copay);//Copay
			testData.add(12, row.getCell(12).toString());//PracticeName
			testData.add(13, row.getCell(13).toString());//PhysicianLastName
			testData.add(14, row.getCell(14).toString());//PatientFirstName
			testData.add(15, row.getCell(15).toString());//PatientLastName
			testData.add(16, row.getCell(16).toString());//BOName
			testData.add(17, row.getCell(17).toString());//FaxType			
			testData.add(18, row.getCell(18).toString());//Type
			testData.add(19, row.getCell(19).toString());//FaxStatus
			testData.add(20, row.getCell(20).toString());//PartnerPatientID
			
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetSelectGPFromDropdownForTreatmentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//FaxStatus															
			testData.add(3, row.getCell(4).toString());//EOBStatus
			testData.add(4, row.getCell(5).toString());//EOBDate
			testData.add(5, row.getCell(6).toString());//Jcode
			testData.add(6, row.getCell(7).toString());//Quantity
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//NDC
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//OutgoingFaxNumber
			testData.add(9, row.getCell(10).toString());//DOS
			testData.add(10, row.getCell(11).toString());//InsuranceNameOnEOB
			String copay = TestUtil.randomNumeric(2);
			testData.add(11, copay);//Copay
			testData.add(12, row.getCell(12).toString());//PracticeName
			testData.add(13, row.getCell(13).toString());//PhysicianLastName
			testData.add(14, row.getCell(14).toString());//PatientFirstName
			testData.add(15, row.getCell(15).toString());//PatientLastName
			testData.add(16, row.getCell(16).toString());//BOName
		
			
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetNoPatientResponsibilityClaimRejectionTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Qty	ZeroCopay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	FindPageFaxStatus	RejectReason	TreatmentStatus
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty/CPT Code	
			testData.add(8, row.getCell(9).toString());//ZeroCopay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//FindPageFaxStatus	
			testData.add(15, row.getCell(16).toString());//RejectReason	
			testData.add(16, row.getCell(17).toString());//TreatmentStatus	
			testData.add(17, row.getCell(18).toString());//AmountLoaded	
			testData.add(18, row.getCell(19).toString());//PatientFirstName	
			testData.add(19, row.getCell(20).toString());//PatientLastName	
			testData.add(20, row.getCell(21).toString());//PatientAddress	
			testData.add(21, row.getCell(22).toString());//PatientCity	
			testData.add(22, row.getCell(23).toString());//PatientState	
			testData.add(23, row.getCell(24).toString());//PatientZipCode	
			testData.add(24, row.getCell(25).toString());//FaxTypeInAdmin		
			testData.add(25, row.getCell(26).toString());//FaxTypeInHub	
			testData.add(26, row.getCell(27).toString());//OutgoingFaxStatus	
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetNoPatientResponsibilityClaimRejectionBothReimbursementTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Qty	ZeroCopay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	FindPageFaxStatus	RejectReason	TreatmentStatus
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//ZeroCopay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//FindPageFaxStatus	
			testData.add(15, row.getCell(16).toString());//RejectReason	
			testData.add(16, row.getCell(17).toString());//TreatmentStatus	
			testData.add(17, row.getCell(18).toString());//AmountLoaded	
			testData.add(18, row.getCell(19).toString());//PatientFirstName	
			testData.add(19, row.getCell(20).toString());//PatientLastName	
			testData.add(20, row.getCell(21).toString());//PatientAddress	
			testData.add(21, row.getCell(22).toString());//PatientCity	
			testData.add(22, row.getCell(23).toString());//PatientState	
			testData.add(23, row.getCell(24).toString());//PatientZipCode	
			testData.add(24, row.getCell(25).toString());//FaxTypeInAdmin		
			testData.add(25, row.getCell(26).toString());//FaxTypeInHub	
			testData.add(26, row.getCell(27).toString());//OutgoingFaxStatus	
			testData.add(27, row.getCell(28).toString());//Qty
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetDuplicateClaimRejectionTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Qty	ZeroCopay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	FindPageFaxStatus	RejectReason	TreatmentStatus
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//ZeroCopay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//FindPageFaxStatus	
			testData.add(15, row.getCell(16).toString());//RejectReason	
			testData.add(16, row.getCell(17).toString());//TreatmentStatus	
			testData.add(17, row.getCell(18).toString());//AmountLoaded	
			testData.add(18, row.getCell(19).toString());//PatientFirstName	
			testData.add(19, row.getCell(20).toString());//PatientLastName	
			testData.add(20, row.getCell(21).toString());//PatientAddress	
			testData.add(21, row.getCell(22).toString());//PatientCity	
			testData.add(22, row.getCell(23).toString());//PatientState	
			testData.add(23, row.getCell(24).toString());//PatientZipCode	
			testData.add(24, row.getCell(25).toString());//ReasonForHold
			testData.add(25, row.getCell(26).toString());//FaxTypeInAdmin		
			testData.add(26, row.getCell(27).toString());//FaxTypeInHub	
			testData.add(27, row.getCell(28).toString());//OutgoingFaxStatus	
			
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetDuplicateClaimRejectionTestDataForBothReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//FindPageFaxStatus	
			testData.add(15, row.getCell(16).toString());//RejectReason	
			testData.add(16, row.getCell(17).toString());//TreatmentStatus	
			testData.add(17, row.getCell(18).toString());//AmountLoaded	
			testData.add(18, row.getCell(19).toString());//PatientFirstName	
			testData.add(19, row.getCell(20).toString());//PatientLastName	
			testData.add(20, row.getCell(21).toString());//PatientAddress	
			testData.add(21, row.getCell(22).toString());//PatientCity	
			testData.add(22, row.getCell(23).toString());//PatientState	
			testData.add(23, row.getCell(24).toString());//PatientZipCode	
			testData.add(24, row.getCell(25).toString());//ReasonForHold
			testData.add(25, row.getCell(26).toString());//FaxTypeInAdmin		
			testData.add(26, row.getCell(27).toString());//FaxTypeInHub	
			testData.add(27, row.getCell(28).toString());//OutgoingFaxStatus
			testData.add(28, row.getCell(29).toString());//CPTCode
			
			
			return testData;
			
		}
		
		return null;
	}
	
	
	public List<String> GetRejectionReasonForRejectionLetterTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Qty	Copay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	TreatmentStatus	AmountLoaded	PatientFirstName	PatientLastName	PatientAddress	PatientCity	PatientState	PatientZipCode
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//Copay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//TreatmentStatus	
			testData.add(15, row.getCell(16).toString());//AmountLoaded	
			testData.add(16, row.getCell(17).toString());//	PatientFirstName
			testData.add(17, row.getCell(18).toString());//	PatientLastName
			testData.add(18, row.getCell(19).toString());//	PatientAddress
			testData.add(19, row.getCell(20).toString());//	PatientCity
			testData.add(20, row.getCell(21).toString());//	PatientState
			testData.add(21, row.getCell(22).toString());//	PatientZipCode
			testData.add(22, row.getCell(23).toString());//FaxTypeInAdmin		
			testData.add(23, row.getCell(24).toString());//FaxTypeInHub	
			testData.add(24, row.getCell(25).toString());//OutgoingFaxStatus	
		
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetNoCodePresentTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Qty	ZeroCopay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	FindPageFaxStatus	RejectReason	TreatmentStatus
			testData.add(0, row.getCell(1).toString());//MemberID																	
			testData.add(1, row.getCell(2).toString());//EnrollFromDate	
			testData.add(2, row.getCell(3).toString());//FaxType	
			testData.add(3, row.getCell(4).toString());//FaxStatus	
			testData.add(4, row.getCell(5).toString());//EOBStatus	
			testData.add(5, NumberToTextConverter.toText(row.getCell(6).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB	
			testData.add(7, row.getCell(8).toString());//Qty	
			testData.add(8, row.getCell(9).toString());//ZeroCopay	
			testData.add(9, row.getCell(10).toString());//BillingProviderName	
			testData.add(10, row.getCell(11).toString());//GroupPracticeName	
			testData.add(11, row.getCell(12).toString());//PhysicianLastName	
			testData.add(12, row.getCell(13).toString());//DOS	
			testData.add(13, row.getCell(14).toString());//EOBDate	
			testData.add(14, row.getCell(15).toString());//TreatmentStatus		
			
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetMaxBenefitsReachedRejectionLetterTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//												
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																	
			testData.add(1, row.getCell(2).toString());//PatientFirstName	
			testData.add(2, row.getCell(3).toString());//PatientLastName	
			testData.add(3, row.getCell(4).toString());//EnrollFromDate	
			testData.add(4, row.getCell(5).toString());//FaxType	
			testData.add(5, row.getCell(6).toString());//FaxStatus	
			testData.add(6, row.getCell(7).toString());//EOBStatus	
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(8, row.getCell(9).toString());//InsNameOnEOB	
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//Copay	
			testData.add(10, row.getCell(11).toString());//BillingProviderName	
			testData.add(11, row.getCell(12).toString());//GroupPracticeName	
			testData.add(12, row.getCell(13).toString());//PhysicianLastName	
			testData.add(13, row.getCell(14).toString());//DOS	
			testData.add(14, row.getCell(15).toString());//EOBDate	
			testData.add(15, row.getCell(16).toString());//Quantity	
			testData.add(16, row.getCell(17).toString());//validation Msg	
			
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetMaxBenefitsReachedRejectionLetterTestDataForInitialClaim(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			
			testData.add(0, row.getCell(1).toString());//MemberID																		
			testData.add(1, row.getCell(2).toString());//FaxType	
			testData.add(2, row.getCell(3).toString());//FaxStatus	
			testData.add(3, row.getCell(4).toString());//EOBStatus	
			testData.add(4, NumberToTextConverter.toText(row.getCell(5).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(5, row.getCell(6).toString());//DOS
			testData.add(6, row.getCell(7).toString());//InsNameOnEOB
			testData.add(7, row.getCell(8).toString());//Quantity	
			testData.add(8, NumberToTextConverter.toText(row.getCell(9).getNumericCellValue()));//Copay	
			testData.add(9, row.getCell(10).toString());//EOBDate
			testData.add(10, row.getCell(11).toString());//BillingProviderName	
			testData.add(11, row.getCell(12).toString());//GroupPracticeName	
			testData.add(12, row.getCell(13).toString());//PhysicianLastName		
			testData.add(13, row.getCell(14).toString());//validation Msg	
			
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetUploadEOBTestDataForMaxBenefits(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//memberID  
			testData.add(1, row.getCell(2).toString());//Firstname
			testData.add(2, row.getCell(3).toString());//lastname
			return testData;
		}
		return null;
	}
	
	public List<String> GetUploadEOBTestDataForMaxBenefitsInitialClaim(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(28).toString());//memberID  
			testData.add(1, row.getCell(3).toString());//Firstname
			testData.add(2, row.getCell(4).toString());//lastname
			return testData;
		}
		return null;
	}
	
	public List<String> GetMaxBenefitsReachedRejectionLetterTestDataForAdmin(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{	
			//MemberID	PatientFirstName	PatientLastName	EnrollFromDate	FaxType	FaxStatus	EOBStatus	OutgoingFaxNumber	InsNameOnEOB	Quantity	Copay	BillingProviderName	GroupPracticeName	PhysicianLastName	DOS	EOBDate	TreatmentStatus	AmountLoaded	PatientAddress	PatientCity	PatientState	PatientZipCode	ReasonForHold	FaxTypeInAdmin	FaxTypeInHub	OutgoingFaxStatus	CPTCode	Quantity																						
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//MemberID																	
			testData.add(1, row.getCell(2).toString());//PatientFirstName	
			testData.add(2, row.getCell(3).toString());//PatientLastName	
			testData.add(3, row.getCell(4).toString());//EnrollFromDate	
			testData.add(4, row.getCell(5).toString());//FaxType	
			testData.add(5, row.getCell(6).toString());//FaxStatus	
			testData.add(6, row.getCell(7).toString());//EOBStatus	
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//OutgoingFaxNumber	
			testData.add(8, row.getCell(9).toString());//InsNameOnEOB	
			testData.add(9, NumberToTextConverter.toText(row.getCell(10).getNumericCellValue()));//Copay	
			testData.add(10, row.getCell(11).toString());//BillingProviderName	
			testData.add(11, row.getCell(12).toString());//GroupPracticeName	
			testData.add(12, row.getCell(13).toString());//PhysicianLastName	
			testData.add(13, row.getCell(14).toString());//DOS	
			testData.add(14, row.getCell(15).toString());//EOBDate	
			testData.add(15, row.getCell(16).toString());//TreatmentStatus	
			testData.add(16, row.getCell(17).toString());//AmountLoaded
			testData.add(17, row.getCell(18).toString());//PatientAddress	
			testData.add(18, row.getCell(19).toString());//PatientCity	
			testData.add(19, row.getCell(20).toString());//PatientState	
			testData.add(20, row.getCell(21).toString());//PatientZipCode	
			testData.add(21, row.getCell(22).toString());//ReasonForHold	
			testData.add(22, row.getCell(23).toString());//FaxTypeInAdmin	
			testData.add(23, row.getCell(24).toString());//FaxTypeInHub	
			testData.add(24, row.getCell(25).toString());//OutgoingFaxStatus	
			testData.add(25, row.getCell(26).toString());//CPTCode	
			testData.add(26, row.getCell(27).toString());//Qty
		
			
			
			
			return testData;
			
		}
		
		return null;
	}
	
	public List<String> GetShipToAddressTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																								
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FirstName
			testData.add(2, row.getCell(3).toString());//LastName
			String fullName = TestUtil.randomAlpha(10);
			testData.add(3, fullName);//Name
			reader.setDataInNewRow(sheetname, "Name", rowNum, fullName);
			String address = TestUtil.randomAlpha(10);
			testData.add(4, address);//Address
			reader.setDataInNewRow(sheetname, "Address", rowNum, address);
			String address2 = TestUtil.randomAlpha(10);
			testData.add(5, address2);//Address2
			reader.setDataInNewRow(sheetname, "Address2", rowNum, address2);
			String city = TestUtil.randomAlpha(10);
			testData.add(6, city);//City
			reader.setDataInNewRow(sheetname, "City", rowNum, city);
			String zip = TestUtil.randomNumeric(9);
			testData.add(7, zip);//Zip
			reader.setDataInNewRow(sheetname, "Zip", rowNum, zip);
			String phno = TestUtil.randomNumeric(10);
			testData.add(8, phno);//Phno
			reader.setDataInNewRow(sheetname, "Phone", rowNum, phno);
			testData.add(9, row.getCell(10).toString());//FaxType
			testData.add(10, row.getCell(11).toString());//FaxStatus																													
			testData.add(11, row.getCell(12).toString());//EOBStatus
			testData.add(12, NumberToTextConverter.toText(row.getCell(13).getNumericCellValue()));//OutgoingFaxNumber															
			testData.add(13, row.getCell(14).toString());//DateOfService
			testData.add(14, row.getCell(15).toString());//InsuranceNameOnEOB
			testData.add(15, row.getCell(16).toString());//Quantity
			String copay = TestUtil.randomNumeric(2);
			testData.add(16, copay);//Copay
			double amountloaded = Double.parseDouble(copay)-5.0;
			reader.setDataInNewRow(sheetname, "Amount", rowNum, String.valueOf(amountloaded));
			testData.add(17, row.getCell(17).toString());//EOBDate
			testData.add(18, row.getCell(18).toString());//BillingProviderName
			testData.add(19, row.getCell(19).toString());//GroupPracticeName
			testData.add(20, row.getCell(20).toString());//PhysicianLastName
			testData.add(21, NumberToTextConverter.toText(row.getCell(21).getNumericCellValue()));//PartnerPatientID
			testData.add(22, row.getCell(22).toString());//ProgramName
			testData.add(23, row.getCell(23).toString());//CardID
			testData.add(24, row.getCell(24).toString());//Status
			
			
			return testData;
			
		}
		
		return null;
			
	}
	
	public List<String> GetShipToAddressForAffordabilityTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			//																													
			testData.add(0, row.getCell(1).toString());//MemberID																													
			testData.add(1, row.getCell(2).toString());//FirstName
			testData.add(2, row.getCell(3).toString());//LastName
			testData.add(3, row.getCell(4).toString());//Name																													
			testData.add(4, row.getCell(5).toString());//Address
			testData.add(5, row.getCell(6).toString());//Address2
			testData.add(6, row.getCell(7).toString());//City																													
			testData.add(7, row.getCell(8).toString());//Zip
			testData.add(8, row.getCell(9).toString());//Phone
			testData.add(9, row.getCell(18).toString());//BillingProviderName
			testData.add(10, row.getCell(25).toString());//State
			testData.add(11, row.getCell(22).toString());//ProgramName
			testData.add(12, row.getCell(26).toString());//Amount
			testData.add(13, row.getCell(23).toString());//CardID


			
			return testData;
			
		}
		
		return null;
	}
	
	
}

