package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class E2EWorkflow_TestData {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	public List<String> GetStatusBeforePaymentApprovalData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, row.getCell(3).toString());//TransactionPaymentStatus
			testData.add(3, row.getCell(4).toString());//PaymentsClaimStatus
			testData.add(4, row.getCell(5).toString());//PaymentsCheckStatus
			testData.add(5, row.getCell(6).toString());//BenefitsHistoryBalance
			testData.add(6, NumberToTextConverter.toText(row.getCell(7).getNumericCellValue()));//Use#
			testData.add(7, row.getCell(8).toString());//PaymentsChecksPaymentStatus
			testData.add(8, row.getCell(9).toString());//PaymentsChecksCheckStatus
			testData.add(9, row.getCell(10).toString());//TransactionAmountIn$
			testData.add(10, row.getCell(11).toString());//TransactionType
			testData.add(11, row.getCell(12).toString());//PaymenType
			testData.add(12, row.getCell(13).toString());//Provider
			testData.add(13, row.getCell(14).toString());//DOS
			testData.add(14, row.getCell(15).toString());//BillingProviderName
			testData.add(15, row.getCell(16).toString());//FaxID
			testData.add(16, row.getCell(17).toString());//PaymentsPaidTo
			testData.add(17, row.getCell(18).toString());//ClaimID
			testData.add(18, row.getCell(19).toString());//ACHID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetStatusAfterPaymentApprovalData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
													

			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, row.getCell(3).toString());//PaymentsClaimStatus
			testData.add(3, row.getCell(4).toString());//PaymentsCheckStatus
			testData.add(4, row.getCell(5).toString());//PaymentsChecksPaymentStatus
			testData.add(5, row.getCell(6).toString());//PaymentsChecksCheckStatus
			testData.add(6, row.getCell(7).toString());//AmountIn$
			testData.add(7, row.getCell(8).toString());//DOS
			testData.add(8, row.getCell(9).toString());//BillingProviderName
			testData.add(9, row.getCell(10).toString());//FaxID
			testData.add(10, row.getCell(11).toString());//PaymentsPaidTo
			testData.add(11, row.getCell(12).toString());//ClaimID
			testData.add(12, row.getCell(13).toString());//ACHID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetStatusAfterPaymentApprovalAndCheckAllData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID													
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, row.getCell(3).toString());//TransactionPaymentStatus
			testData.add(3, row.getCell(4).toString());//PaymentsClaimStatus
			testData.add(4, row.getCell(5).toString());//PaymentsCheckStatus
			testData.add(5, row.getCell(6).toString());//TotalUsage
			testData.add(6, row.getCell(7).toString());//BenefitsHistoryBalance
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//Use#
			testData.add(8, row.getCell(9).toString());//PaymentsChecksPaymentStatus
			testData.add(9, row.getCell(10).toString());//PaymentsChecksCheckStatus
			testData.add(10, row.getCell(11).toString());//TransactionAmountIn$
			testData.add(11, row.getCell(12).toString());//TransactionType
			testData.add(12, row.getCell(13).toString());//PaymenType
			testData.add(13, row.getCell(14).toString());//Provider
			testData.add(14, row.getCell(15).toString());//DOS
			testData.add(15, row.getCell(16).toString());//BillingProviderName
			testData.add(16, row.getCell(17).toString());//FaxID
			testData.add(17, row.getCell(18).toString());//PaymentsPaidTo
			testData.add(18, row.getCell(19).toString());//ClaimID
			testData.add(19, row.getCell(20).toString());//CheckID
			testData.add(20, row.getCell(21).toString());//Check#
			testData.add(21, row.getCell(22).toString());//FinalFileName
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetStatusAfterCheckClearData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID									
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, row.getCell(3).toString());//TransactionPaymentStatus
			testData.add(3, row.getCell(4).toString());//PaymentsClaimStatus
			testData.add(4, row.getCell(5).toString());//PaymentsCheckStatus
			testData.add(5, row.getCell(6).toString());//PaymentsChecksPaymentStatus
			testData.add(6, row.getCell(7).toString());//PaymentsChecksCheckStatus
			testData.add(7, row.getCell(8).toString());//TransactionAmountIn$
			testData.add(8, row.getCell(9).toString());//TransactionType
			testData.add(9, row.getCell(10).toString());//PaymenType
			testData.add(10, row.getCell(11).toString());//Provider
			testData.add(11, row.getCell(12).toString());//DOS
			testData.add(12, row.getCell(13).toString());//BillingProviderName
			testData.add(13, row.getCell(14).toString());//FaxID
			testData.add(14, row.getCell(15).toString());//PaymentsPaidTo
			testData.add(15, row.getCell(16).toString());//ClaimID			
			testData.add(16, row.getCell(17).toString());//CheckID
			testData.add(17, row.getCell(18).toString());//Check#
			testData.add(18, row.getCell(19).toString());//FinalFileName
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetStatusAfterCheckClearForACH(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//CardID
			testData.add(2, row.getCell(3).toString());//TransactionPaymentStatus				
			testData.add(3, row.getCell(4).toString());//PaymentsClaimStatus
			testData.add(4, row.getCell(5).toString());//PaymentsCheckStatus
			testData.add(5, row.getCell(6).toString());//TotalUsage
			testData.add(6, row.getCell(7).toString());//BenefitsHistoryBalance
			testData.add(7, NumberToTextConverter.toText(row.getCell(8).getNumericCellValue()));//Use#
			testData.add(8, row.getCell(9).toString());//EFTListACHStatus
			testData.add(9, row.getCell(10).toString());//TransactionAmountIn$
			testData.add(10, row.getCell(11).toString());//TransactionType
			testData.add(11, row.getCell(12).toString());//PaymenType
			testData.add(12, row.getCell(13).toString());//Provider
			testData.add(13, row.getCell(14).toString());//DOS
			testData.add(14, row.getCell(15).toString());//BillingProviderName
			testData.add(15, row.getCell(16).toString());//FaxID
			testData.add(16, row.getCell(17).toString());//PaymentsPaidTo
			testData.add(17, row.getCell(18).toString());//ClaimID
			testData.add(18, row.getCell(19).toString());//ACHID
			testData.add(19, row.getCell(20).toString());//check#
			testData.add(20, row.getCell(21).toString());//Finalfilename  
			
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetHubStatusForPayments(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//PaymentType
			testData.add(2, row.getCell(3).toString());//PaymentStatus
			testData.add(3, row.getCell(4).toString());//Amount
			testData.add(4, row.getCell(5).toString());//DOS
			testData.add(5, row.getCell(6).toString());//Physician
			testData.add(6, row.getCell(7).toString());//CheckStatus		
			testData.add(7, row.getCell(8).toString());//ShippedTo
			testData.add(8, row.getCell(9).toString());//ShippingAddress
			testData.add(9, row.getCell(10).toString());//ClaimID#

			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetCTMDataForPaymentApproval(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetCTMDataForPaymentApprovalForCheckAll(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			testData.add(3, row.getCell(4).toString());//Check#
			testData.add(4, row.getCell(5).toString());//ClaimID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetCTPDataForPaymentApproval(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetCTPDataForPaymentApprovalForCheckAll(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			testData.add(3, row.getCell(4).toString());//Check#
			testData.add(4, row.getCell(5).toString());//ClaimID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetACHDataForPaymentApproval(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetACHDataForPaymentApprovalForCheckAll(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
		//	testData.add(2, NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));//Amount
			testData.add(2, row.getCell(3).toString());//Amount
			testData.add(3, row.getCell(4).toString());//Check#
			testData.add(4, row.getCell(5).toString());//ClaimID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetACHDataForPaymentApprovalForBothReimbursement(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, row.getCell(1).toString());//CardID								
			testData.add(1, row.getCell(2).toString());//ProgramName
			testData.add(2, row.getCell(3).toString());//TotalAmount
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetEnrollmentLetterTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
									
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//PatientFirstName
			testData.add(2, row.getCell(3).toString());//PatientLastName				
			testData.add(3, row.getCell(4).toString());//PatientAddress
			testData.add(4, row.getCell(5).toString());//PatientCity
			testData.add(5, row.getCell(6).toString());//PatientState
			testData.add(6, row.getCell(7).toString());//PatientZipCode
			testData.add(7, row.getCell(8).toString());//CardID
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetClaimLetterTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
									
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//PatientFirstName
			testData.add(2, row.getCell(3).toString());//PatientLastName				
			testData.add(3, row.getCell(4).toString());//PatientAddress
			testData.add(4, row.getCell(5).toString());//PatientCity
			testData.add(5, row.getCell(6).toString());//PatientState
			testData.add(6, row.getCell(7).toString());//PatientZipCode
			testData.add(7, row.getCell(8).toString());//FaxType
			testData.add(8, row.getCell(9).toString());//Type				
			testData.add(9, row.getCell(10).toString());//FaxStatus
			testData.add(10, row.getCell(11).toString());//CardID
			testData.add(11, row.getCell(12).toString());//FaxNum
			testData.add(12, row.getCell(13).toString());//PartnerPatientID
			testData.add(13, row.getCell(14).toString());//copay
			testData.add(14, row.getCell(15).toString());//OutgoingFaxInAdmin
			testData.add(15, row.getCell(16).toString());//IncomingFaxStatus
			testData.add(16, row.getCell(17).toString());//OutgoingFaxNumber	
			
			
			return testData;
		}
		return null;
	}
	
	public List<String> GetUploadedFaxVerificationForAdminReimbursementTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
														
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//FaxType
			testData.add(2, row.getCell(3).toString());//Type				
			testData.add(3, row.getCell(4).toString());//FaxStatus
			testData.add(4, row.getCell(5).toString());//CardID
			testData.add(5, row.getCell(6).toString());//FaxNum
			testData.add(6, row.getCell(7).toString());//PartnerPatientID
			testData.add(7, row.getCell(8).toString());//EditAssignLinkURL

			
			return testData;
		}
		return null;
	}
	
	public List<String> GetPaymentsBOTestDataBeforePaymentApproval(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "e2e";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
																								
			testData.add(0, row.getCell(1).toString());//BOPRoviderName								
			testData.add(1, row.getCell(2).toString());//Program
			testData.add(2, row.getCell(3).toString());//PatientFirstName				
			testData.add(3, row.getCell(4).toString());//PatientLastName
			testData.add(4, row.getCell(5).toString());//MemberID
			testData.add(5, row.getCell(6).toString());//TreatmentID
			testData.add(6, row.getCell(7).toString());//DOS
			testData.add(7, row.getCell(8).toString());//ACHID
			testData.add(8, row.getCell(9).toString());//PaymentID
			testData.add(9, row.getCell(10).toString());//ACHStatus
			testData.add(10, row.getCell(11).toString());//PaidAmount
			testData.add(11, NumberToTextConverter.toText(row.getCell(12).getNumericCellValue()));//PartnerPracticeID

			
			return testData;
		}
		return null;
	}
	
	public List<String> GetPMApprovedTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Smoke";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
																								
			testData.add(0, row.getCell(1).toString());//MemberID								
			testData.add(1, row.getCell(2).toString());//CardID
			

			
			return testData;
		}
		return null;
	}
	
	
}
