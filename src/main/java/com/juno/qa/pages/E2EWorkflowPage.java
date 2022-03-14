package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;

public class E2EWorkflowPage extends TestBase {
	
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_TransactionsTabPage apt = new AdminPortal_Patients_TransactionsTabPage();
	AdminPortal_Patients_PaymentsTabPage ppt = new AdminPortal_Patients_PaymentsTabPage();
	AdminPortal_Patients_BenefitsHisoryTabPage pbt = new AdminPortal_Patients_BenefitsHisoryTabPage();
	AdminPortal_PaymentsPage pmp = new AdminPortal_PaymentsPage();
	AdminPortal_Payments_EFT_ListPage ael = new AdminPortal_Payments_EFT_ListPage();
	AdminPortalHomePage aph = new AdminPortalHomePage();
	AdminPortal_PG_BO_PaymentsTab pbp = new AdminPortal_PG_BO_PaymentsTab();
	
	CommonFunctions cf = new CommonFunctions();
	
	public E2EWorkflowPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyStatusAcrossPagesBeforePaymentApprovalInAdminPortal(List<String> testData, String PaymentType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			
			System.out.println("fullname is:" +fullname);
			System.out.println("contact is:" +contact);
			
			System.out.println("contact0 is:" +contact[0]);
			System.out.println("contact1 is:" +contact[1].trim());
			System.out.println("contact2 is:" +contact[2].trim());
			System.out.println("contact3 is:" +contact[3]);
			
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];			
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
			
			
			
			apt.TransactionsTab().click();
			Thread.sleep(6000);
			//Now verify the payment status in Detail column's show transaction detail
			try
			{
				Assert.assertTrue(VerifyTransactionsTabDetails(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
				
			}
			
			
			//Now verify in payments tab
			ppt.PaymentsTab().click();
			Thread.sleep(5000);
			try
			{
				Assert.assertTrue(VerifyPaymentsTabDetails(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
			
			}
			catch(ParseException p)
			{
				
			}
			
			//Now verify in Benefits history tab for balance and use#
			pbt.BenefitsHistoryTab().click();
			Thread.sleep(3000);
//			try
//			{
//				Assert.assertTrue(VerifyBenefitsHistoryTabDetails(testData));
//			}
//			catch(InterruptedException e)
//			{
//				
//			}
			
			//Now verify in Payments --> checks --> List
			if(PaymentType.equalsIgnoreCase("CTM") || PaymentType.equalsIgnoreCase("CTP"))
			{
				ahp.PaymentsLink().click();
				ahp.ChecksLink().click();
				ahp.ListLink().click();
				Thread.sleep(4000);
				pmp.CardID().sendKeys(testData.get(0));
				pmp.FindButton().click();
				
				//Commented for 01102022 ***
//				try
//				{
//					Assert.assertTrue(VerifyPaymentsBeforePaymentAppovalAndCheckAllForClaimForCTPCTM(testData, PaymentType));
//				}
//				catch(ParseException p)
//				{
//					
//				}
				return verify;
				
			}
			else if(PaymentType.equalsIgnoreCase("ACH"))
			{
				ahp.PaymentsLink().click();
				ahp.EFTLink().click();
				Thread.sleep(1000);
				ahp.ListLink().click();
				Thread.sleep(2000);
				
				try
				{
					Assert.assertTrue(VerifyACHPaymentsEFTReport(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				catch(ParseException p)
				{
					
				}
				
				
				return verify;
		
			}
		
		}
		verify = false;
		return verify;
	}
	
	public boolean VerifyStatusAcrossPagesAfterPaymentApprovalInAdminPortalForACH(List<String> testData, String PaymentType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];
				
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
		
			//Now verify in payments tab
			
				ppt.PaymentsTab().click();
				Thread.sleep(5000);
				try
				{
					Assert.assertTrue(VerifyPaymentsTabDetailsAfterPaymentApproval(testData));
				}
				catch(InterruptedException e)
				{
				
				}
				catch(ParseException p)
				{
					
				}
				
				ahp.PaymentsLink().click();
				ahp.EFTLink().click();
				Thread.sleep(1000);
				ahp.ListLink().click();
				Thread.sleep(5000);
				try
				{
					Assert.assertTrue(VerifyACHPaymentsEFTReportAfterPaymentApproval(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				catch(ParseException p)
				{
					
				}
				
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyStatusAcrossPagesAfterPaymentApprovalInAdminPortalForCTPCTM(List<String> testData, String PaymentType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];
				
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
		
			//Now verify in payments tab
			
				ppt.PaymentsTab().click();
				Thread.sleep(5000);
				try
				{
					Assert.assertTrue(VerifyPaymentsTabDetailsAfterPaymentApproval(testData));
				}
				catch(InterruptedException e)
				{
				
				}
				catch(ParseException p)
				{
					
				}
				
				ahp.PaymentsLink().click();
				ahp.ChecksLink().click();
				Thread.sleep(1000);
				ahp.ListLink().click();
				Thread.sleep(5000);
				try
				{
					Assert.assertTrue(VerifyPaymentsAfterPaymentApprovalForCTPCTM(testData, PaymentType, patientDetails));
				}
				catch(InterruptedException e)
				{
					
				}
				catch(ParseException p)
				{
					
				}
				
				
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyStatusAcrossPagesAfterPaymentApprovalAndCheckAllInAdminPortalForACH(List<String> testData, String PaymentType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];
				
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
			apt.TransactionsTab().click();
			Thread.sleep(2000);
			//Now verify the payment status in Detail column's show transaction detail
			try
			{
				Assert.assertTrue(VerifyTransactionsTabDetails(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
				
			}
		
			
			//Now verify in payments tab
			
				ppt.PaymentsTab().click();
				Thread.sleep(3000);
				try
				{
					Assert.assertTrue(VerifyPaymentsTabDetailsAfterCheckAll(testData));
				}
				catch(InterruptedException e)
				{
				
				}
				catch(ParseException p)
				{
					
				}
				
				//Now verify in Benefits history tab for balance and use#
				pbt.BenefitsHistoryTab().click();
				Thread.sleep(3000);
				try
				{
					Assert.assertTrue(VerifyBenefitsHistoryTabDetailsAfterCheckAll(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				
			//Now verify in Payments --> checks --> List
		/*	if(PaymentType.equalsIgnoreCase("CTM") || PaymentType.equalsIgnoreCase("CTP"))
			{		
				ahp.PaymentsLink().click();
				ahp.ChecksLink().click();
				ahp.ListLink().click();
				Thread.sleep(4000);
				pmp.CardID().sendKeys(testData.get(1));
				pmp.FindButton().click();
				
				Assert.assertTrue(VerifyPaymentsCheckForClaimForCTPCTM(testData, PaymentType));
				
				return verify;
			}
			
			else if(PaymentType.equalsIgnoreCase("ACH"))
			{ */
				ahp.PaymentsLink().click();
				ahp.EFTLink().click();
				ahp.ListLink().click();
				Thread.sleep(2000);
				try
				{
					Assert.assertTrue(VerifyACHPaymentsEFTReport(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				catch(ParseException p)
				{
					
				}
				
			//}
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyStatusAcrossPagesAfterPaymentApprovalAndCheckAllInAdminPortalForCTPCTM(List<String> testData, String PaymentType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];
				
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
			apt.TransactionsTab().click();
			Thread.sleep(6000);
			//Now verify the payment status in Detail column's show transaction detail
			try
			{
				Assert.assertTrue(VerifyTransactionsTabDetailsAfterCheckAllForCTPCTM(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
				
			}
			
			//Now verify in payments tab
			
				ppt.PaymentsTab().click();
				Thread.sleep(4000);
				try
				{
					Assert.assertTrue(VerifyPaymentsTabDetailsAfterCheckAllForCTPCTM(testData, PaymentType, patientDetails));
				}
				catch(InterruptedException e)
				{
				
				}
				catch(ParseException p)
				{
					
				}
				
				//Now verify in Benefits history tab for balance and use#
				pbt.BenefitsHistoryTab().click();
				Thread.sleep(3000);
				try
				{
					Assert.assertTrue(VerifyBenefitsHistoryTabDetailsAfterCheckAllForCTPCTM(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				
			//Now verify in Payments --> checks --> List
		/*	if(PaymentType.equalsIgnoreCase("CTM") || PaymentType.equalsIgnoreCase("CTP"))
			{	*/	
				ahp.PaymentsLink().click();
				ahp.ChecksLink().click();
				ahp.ListLink().click();
				Thread.sleep(4000);
				pmp.CardID().sendKeys(testData.get(1));
				pmp.FindButton().click();
				
				try
				{
					Assert.assertTrue(VerifyPaymentsCheckAllForClaimForCTPCTM(testData, PaymentType));
				}
				catch(ParseException p)
				{
					
				}
				
				return verify;
		/*	}
			
			else if(PaymentType.equalsIgnoreCase("ACH"))
			{
				ahp.PaymentsLink().click();
				ahp.EFTLink().click();
				ahp.ListLink().click();
				Thread.sleep(2000);
				try
				{
					Assert.assertTrue(VerifyACHPaymentsEFTReport(testData));
				}
				catch(InterruptedException e)
				{
					
				}
				
			} */
		
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyStatusAcrossPagesAfterCheckClearInAdminPortal(List<String> testData, String PaymentType) throws InterruptedException, IOException, AWTException
	{
		boolean verify = true;
		if(verify)
		{
			String fullname = app.PatientsFindFirstNameValueFirstRow()+" "+app.PatientsFindLastNameValueFirstRow();
			String[] contact = app.PatientsFindContactValueFirstRow().split(",");
			String patientDetails = fullname+"\n"+contact[0]+"\n"+contact[1].trim()+","+contact[2].trim()+contact[3];
			
			app.PatientsActiveFirstReviewButton().click();
			Thread.sleep(2000);
			apt.TransactionsTab().click();
			Thread.sleep(4000);
			//Now verify the payment status in Detail column's show transaction detail
			try
			{
				Assert.assertTrue(VerifyTransactionsTabDetailsAfterCheckClearForCTPCTM(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
				
			}
			/*
			//Now verify in payments tab
			
			ppt.PaymentsTab().click();
			Thread.sleep(4000);
			try
			{
				Assert.assertTrue(VerifyPaymentsTabDetailsAfterCheckClearForCTPCTM(testData, PaymentType, patientDetails));
			}
			catch(InterruptedException e)
			{
			
			}
			catch(ParseException p)
			{
				
			}
			
			//Now verify in Payments --> checks --> List
				ahp.PaymentsLink().click();
				ahp.ChecksLink().click();
				ahp.ListLink().click();
				
				pmp.CardID().sendKeys(testData.get(1));
				pmp.FindButton().click();
				
				try
				{
					Assert.assertTrue(VerifyPaymentsCheckClearForClaimForCTPCTM(testData, PaymentType));
				}
				catch(ParseException p)
				{
					
				}
			
			*/	
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyTransactionsTabDetails(List<String> testData, String PaymentType, String patientDetails) throws InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(apt.CardIDValueFirstRow(), testData.get(0));
			
			System.out.println("UI1:"+apt.AmountInDollarValueFirstRow());
			System.out.println("UI2:"+testData.get(9));
			
			Assert.assertTrue(apt.AmountInDollarValueFirstRow().contains(testData.get(9)));
			Assert.assertTrue(apt.OriginalAmountInDollarValueFirstRow().contains(testData.get(9)));
			Assert.assertEquals(apt.TransactionTypeValueFirstRow(), testData.get(10));
			Assert.assertEquals(apt.PaymentTypeValueFirstRow(), testData.get(11));
			
			System.out.println("UI value: "+apt.DateAndTimeValueFirstRow());
			System.out.println("Current date: "+currentDate);
			
			Assert.assertTrue(apt.DateAndTimeValueFirstRow().contains(currentDate));
			
			//click on showprovider
			apt.ShowProviderLatestRowLink().click();
			Thread.sleep(4000);
//			Assert.assertEquals(apt.ShowProviderLatestRowLink().getText(), testData.get(12)); 
			
			//click on refresh data link, otherwise the test is not able to click on show patient link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on showpatient
//			apt.ShowPatientLatestRowLink().click();
//			System.out.println("Clicked on patient link");
//			Thread.sleep(2000);
//			Assert.assertEquals(apt.ShowPatientLatestRowLink().getText(), patientDetails); 
			
			//click on refresh data link, otherwise the test is not able to click on show transaction details link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on show transaction detail
			apt.ShowTransactionDetailLatestRowLink().click();
			Thread.sleep(1000);
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeIDValueForFirstRow().getText(), testData.get(18));
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeStatusValueForFirstRow().getText(), testData.get(2));
			if(apt.GetTransactionDetailClaimTypeStatusValueForFirstRow().getText().equalsIgnoreCase("Completed"))
			{
				Assert.assertEquals(apt.GetTransactionDetailClaimTypeTraceNumValueForFirstRow().getText(), testData.get(19));
			}
			Assert.assertTrue(apt.GetTransactionDetailAmountValueForFirstRow().getText().contains(testData.get(9)));
			Thread.sleep(2000);
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyTransactionsTabDetailsAfterCheckAllForCTPCTM(List<String> testData, String PaymentType, String patientDetails) throws InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(apt.CardIDValueFirstRow(), testData.get(1));
			Assert.assertTrue(apt.AmountInDollarValueFirstRow().contains(testData.get(10)));
			Assert.assertTrue(apt.OriginalAmountInDollarValueFirstRow().contains(testData.get(10)));
			Assert.assertEquals(apt.TransactionTypeValueFirstRow(), testData.get(11));
			Assert.assertEquals(apt.PaymentTypeValueFirstRow(), testData.get(12));
			System.out.println("UI value: "+apt.DateAndTimeValueFirstRow());
			System.out.println("Current date: "+currentDate);
			
			Assert.assertTrue(apt.DateAndTimeValueFirstRow().contains(currentDate));
			
			//click on showprovider
			apt.ShowProviderLatestRowLink().click();
			Thread.sleep(2000);
			Assert.assertEquals(apt.ShowProviderLatestRowLink().getText(), testData.get(13)); 
			
			//click on refresh data link, otherwise the test is not able to click on show patient link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on showpatient
			apt.ShowPatientLatestRowLink().click();
			System.out.println("Clicked on patient link");
			Thread.sleep(2000);
			Assert.assertEquals(apt.ShowPatientLatestRowLink().getText(), patientDetails); 
			
			//click on refresh data link, otherwise the test is not able to click on show transaction details link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on show transaction detail
			apt.ShowTransactionDetailLatestRowLink().click();
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeIDValueForFirstRow().getText(), testData.get(19));
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeStatusValueForFirstRow().getText(), testData.get(2));
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeTraceNumValueForFirstRow().getText(), testData.get(20));
			Assert.assertTrue(apt.GetTransactionDetailAmountValueForFirstRow().getText().contains(testData.get(10)));
			Thread.sleep(2000);
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyTransactionsTabDetailsAfterCheckClearForCTPCTM(List<String> testData, String PaymentType, String patientDetails) throws InterruptedException, IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(apt.CardIDValueFirstRow(), testData.get(0)); // before 1
			Assert.assertTrue(apt.AmountInDollarValueFirstRow().contains(testData.get(7))); // before 7
			Assert.assertTrue(apt.OriginalAmountInDollarValueFirstRow().contains(testData.get(7))); // before 7
			Assert.assertEquals(apt.TransactionTypeValueFirstRow(), testData.get(8)); // before 8
			Assert.assertEquals(apt.PaymentTypeValueFirstRow(), testData.get(9)); // before 9
			
			System.out.println("UI value: "+apt.DateAndTimeValueFirstRow());
			System.out.println("Current date: "+currentDate);
			
			Assert.assertTrue(apt.DateAndTimeValueFirstRow().contains(currentDate));
			
			//click on showprovider
			apt.ShowProviderLatestRowLink().click();
			Thread.sleep(2000);
			Assert.assertEquals(apt.ShowProviderLatestRowLink().getText(), testData.get(10));  // before 10
			
			//click on refresh data link, otherwise the test is not able to click on show patient link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on showpatient
//			apt.ShowPatientLatestRowLink().click();
//			System.out.println("Clicked on patient link");
//			Thread.sleep(2000);
//			Assert.assertEquals(apt.ShowPatientLatestRowLink().getText(), patientDetails); 
			
			//click on refresh data link, otherwise the test is not able to click on show transaction details link
			apt.RefreshDataLink().click();
			Thread.sleep(2000);
			
			//click on show transaction detail
			apt.ShowTransactionDetailLatestRowLink().click();
			Thread.sleep(2000);
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeIDValueForFirstRow().getText(), testData.get(16)); // before 16
			Assert.assertEquals(apt.GetTransactionDetailClaimTypeStatusValueForFirstRow().getText(), testData.get(2)); // before 2
//			Assert.assertEquals(apt.GetTransactionDetailClaimTypeTraceNumValueForFirstRow().getText(), testData.get(17)); // before 17
			Assert.assertTrue(apt.GetTransactionDetailAmountValueForFirstRow().getText().contains(testData.get(7))); // before 7
			Thread.sleep(2000);
			
//			js.executeScript("window.scrollBy(500,300)", "");
//			if(apt.GetTransactionDetailClaimTypeIDValueForFirstRow().getText().equalsIgnoreCase(testData.get(16)))
//	    	{
//	    		TestBase.classAInstance.logReport("Pass","Verify transaction tab","Succesfully able to Verify transaction tab");
//	    	}
//	    	else
//	    	{
//	    		TestBase.classAInstance.logReport("Fail","Verify transaction tab","Failed to Verify transaction tab");
//	    	}
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyPaymentsTabDetails(List<String> testData, String PaymentType, String patientdetails) throws InterruptedException, ParseException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		String[] patient = patientdetails.split(",");
		String finalPatient = patient[0]+" "+patient[1];
		boolean verify = true;
		if(verify)
		{	
			DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date = sdf.parse(testData.get(13));
		    String fullDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			String notes = "Date of Service #1: "+fullDate+" Amount: "+testData.get(9);
			
			ppt.ShowCheckPayments().click();
			Thread.sleep(2000);
			
			//Assert.assertEquals(ppt.ClaimIDLatestRow().getText(), testData.get(17));
			Assert.assertEquals(ppt.ClaimStatusLatestRow().getText(), testData.get(3));
			if(ppt.ClaimStatusLatestRow().getText().equalsIgnoreCase("Paid"))
			{
				Assert.assertEquals(ppt.CheckTraceNumLatestRow().getText(), testData.get(17));
			}
			Assert.assertTrue(ppt.AmountLatestRow().getText().contains(testData.get(9)));
			Assert.assertEquals(ppt.CheckStatusLatestRow().getText(), testData.get(4));
			//Assert.assertEquals(ppt.FaxIDLatestRow().getText(), testData.get(15));
		//	Assert.assertTrue(ppt.SentDateLatestRow().getText().contains(currentDate));
		//	Assert.assertTrue(ppt.CheckDateLatestRow().getText().contains(currentDate));
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertTrue(ppt.PaidToLatestRow().getText().contains(finalPatient));
			}
			else if(PaymentType.equalsIgnoreCase("CTM") || PaymentType.equalsIgnoreCase("ACH"))
			{
				Assert.assertEquals(ppt.PaidToLatestRow().getText(), testData.get(16));
			}
			
		//	Assert.assertTrue(ppt.NotesLatestRow().getText().contains(notes));
			
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsTabDetailsAfterPaymentApproval(List<String> testData) throws InterruptedException, ParseException
	{
		
		
		boolean verify = true;
		if(verify)
		{
			
			
			DateFormat sdf = new SimpleDateFormat("dd-MMM-YY");
		    Date date = sdf.parse(testData.get(7));
		        
			String fullDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();//0-y, 1-m, 2-d
			
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    Date date1 = sdf.parse(currentDate);
		        
			String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date1);
			
			String notes = "Date of Service #1: "+fullDate+" Amount: "+testData.get(6)+"0 , ;User bhanu.bangalore@connectiverx.com updated the status to approved at "+formattedDate;
			Assert.assertEquals(ppt.ClaimIDLatestRow().getText(), testData.get(11));
			Assert.assertEquals(ppt.ClaimStatusLatestRow().getText(), testData.get(2));
			Assert.assertTrue(ppt.AmountLatestRow().getText().contains(testData.get(6)));
			Assert.assertEquals(ppt.CheckStatusLatestRow().getText(), testData.get(3));
			Assert.assertEquals(ppt.PaidToLatestRow().getText(), testData.get(10));
			Assert.assertTrue(ppt.NotesLatestRow().getText().contains(notes));
			Assert.assertEquals(ppt.FaxIDLatestRow().getText(), testData.get(9));
		//	Assert.assertTrue(ppt.SentDateLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ppt.CheckDateLatestRow().getText().contains(currentDate));
			
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsTabDetailsAfterCheckAll(List<String> testData) throws InterruptedException, ParseException
	{
		
		
		boolean verify = true;
		if(verify)
		{
			
			DateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date1 = sdf1.parse(testData.get(13));
		        
			String fullDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();//0-y, 1-m, 2-d
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(currentDate);
		    String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
		    System.out.println("DOS1:"+formattedDate);
		    
			String notes = "Date of Service #1: "+fullDate+" Amount: "+testData.get(9)+"0 , ;User bhanu.bangalore@connectiverx.com updated the status to approved at "+formattedDate;
			
			Assert.assertEquals(ppt.ClaimIDLatestRow().getText(), testData.get(17));
			Assert.assertEquals(ppt.CheckTraceNumLatestRow().getText(), testData.get(19));
			Assert.assertEquals(ppt.ClaimStatusLatestRow().getText(), testData.get(3));
			System.out.println("UI1:"+ppt.AmountLatestRow().getText());
			System.out.println("UI2:"+testData.get(9));
			Assert.assertTrue(ppt.AmountLatestRow().getText().contains(testData.get(9)));
			Assert.assertEquals(ppt.CheckStatusLatestRow().getText(), testData.get(4));
			Assert.assertEquals(ppt.PaidToLatestRow().getText(), testData.get(16));
			Assert.assertTrue(ppt.NotesLatestRow().getText().contains(notes));
			Assert.assertEquals(ppt.FaxIDLatestRow().getText(), testData.get(15));
		//	Assert.assertTrue(ppt.SentDateLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ppt.CheckDateLatestRow().getText().contains(currentDate));
			
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	
	
	public boolean VerifyPaymentsTabDetailsAfterCheckAllForCTPCTM(List<String> testData, String PaymentType, String patientdetails) throws InterruptedException, ParseException
	{
		String[] patient = patientdetails.split(",");
		String finalPatient = patient[0]+" "+patient[1];
		
		boolean verify = true;
		if(verify)
		{
			/*String[] dateMod = testData.get(14).split("-");
			int month = cf.ConvertToMonthNumber(dateMod[1]);
			String mon = "";
			if(month<10)
			{
				mon = "0"+month;
			}
			String fullDate = dateMod[2]+"-"+mon+"-"+dateMod[0]; */
			
			DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date = sdf.parse(testData.get(14));
		    String fullDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();//0-y, 1-m, 2-d
			
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    Date date1 = sdf.parse(currentDate);
		    String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date1);
		    
			
			
			String notes = "Date of Service #1: "+fullDate+" Amount: "+testData.get(10)+"0 , ;User bhanu.bangalore@connectiverx.com updated the status to approved at "+formattedDate;
			Assert.assertEquals(ppt.ClaimIDLatestRow().getText(), testData.get(17));
			Assert.assertEquals(ppt.CheckTraceNumLatestRow().getText(), testData.get(19));
			Assert.assertEquals(ppt.ClaimStatusLatestRow().getText(), testData.get(3));
			Assert.assertTrue(ppt.AmountLatestRow().getText().contains(testData.get(10)));
			Assert.assertEquals(ppt.CheckStatusLatestRow().getText(), testData.get(4));
			Assert.assertEquals(ppt.FaxIDLatestRow().getText(), testData.get(16));
			Assert.assertTrue(ppt.SentDateLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ppt.CheckDateLatestRow().getText().contains(currentDate));
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertTrue(ppt.PaidToLatestRow().getText().contains(finalPatient));
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(ppt.PaidToLatestRow().getText(), testData.get(17));
			}
			
			System.out.println("notes1:"+ppt.NotesLatestRow().getText());
			System.out.println("notes2:"+notes);
			Assert.assertTrue(ppt.NotesLatestRow().getText().contains(notes));
			
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsTabDetailsAfterCheckClearForCTPCTM(List<String> testData, String PaymentType, String patientdetails) throws InterruptedException, ParseException
	{
		String[] patient = patientdetails.split(",");
		String finalPatient = patient[0]+" "+patient[1];
		
		boolean verify = true;
		if(verify)
		{
		/*	String[] dateMod = testData.get(11).split("-");
			int month = cf.ConvertToMonthNumber(dateMod[1]);
			String mon = "";
			if(month<10)
			{
				mon = "0"+month;
			}
			String fullDate = dateMod[2]+"-"+mon+"-"+dateMod[0]; */
			
			DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date = sdf.parse(testData.get(11));
		    String fullDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();//0-y, 1-m, 2-d
			
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    Date date1 = sdf.parse(currentDate);
		    String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date1);
		    
/*			String[] date = currentDate.split("-");
			String formattedDate = date[1]+"/"+date[2]+"/"+date[0]; */
			
			String notes = "Date of Service #1: "+fullDate+" Amount: "+testData.get(7)+"0 , ;User bhanu.bangalore@connectiverx.com updated the status to approved at "+formattedDate;
			Assert.assertEquals(ppt.ClaimIDLatestRow().getText(), testData.get(15));
			Assert.assertEquals(ppt.CheckTraceNumLatestRow().getText(), testData.get(17));
			Assert.assertEquals(ppt.ClaimStatusLatestRow().getText(), testData.get(3));
			Assert.assertTrue(ppt.AmountLatestRow().getText().contains(testData.get(7)));
			Assert.assertEquals(ppt.CheckStatusLatestRow().getText(), testData.get(4));
	
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertTrue(ppt.PaidToLatestRow().getText().contains(finalPatient));
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(ppt.PaidToLatestRow().getText(), testData.get(17));
			}
			System.out.println("notes1:"+ppt.NotesLatestRow().getText());
			System.out.println("notes2:"+notes);
			Assert.assertTrue(ppt.NotesLatestRow().getText().contains(notes));
			Assert.assertEquals(ppt.FaxIDLatestRow().getText(), testData.get(13));
			Assert.assertTrue(ppt.SentDateLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ppt.CheckDateLatestRow().getText().contains(currentDate));
			
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyBenefitsHistoryTabDetails(List<String> testData) throws InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		String[] date = currentDate.split("-");
		
		LocalDate ld = LocalDate.now().minusDays(120);
		String retroDate = ld.toString();
		
		LocalDate now = LocalDate.now();
		LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfYear());
		
		
		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(pbt.BenefitsPeriodColumn().getText(), date[0]);
			Assert.assertEquals(pbt.ActiveBenefitsPeriodColumn().getText(), "Y");
			Assert.assertEquals(pbt.EnrollDateColumn().getText(), currentDate);
			Assert.assertEquals(pbt.ExpirationDateColumn().getText(), lastDay.toString());
			Assert.assertEquals(pbt.RetroDateColumn().getText(), retroDate);
			Assert.assertEquals(pbt.TotalUsageColumn().getText(), "$0.00");
			Assert.assertEquals(pbt.BalanceColumn().getText(), testData.get(5));
			Assert.assertEquals(pbt.UseNumberColumn().getText(), testData.get(6));
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyBenefitsHistoryTabDetailsAfterCheckAll(List<String> testData) throws InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		String[] date = currentDate.split("-");
		
		LocalDate ld = LocalDate.now().minusDays(120);
		String retroDate = ld.toString();
		
		LocalDate now = LocalDate.now();
		LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfYear());
		
		
		boolean verify = true;
		if(verify)
		{
			String totalUsage = pbt.TotalUsageColumn().getText().substring(1, pbt.TotalUsageColumn().getText().length());
			Assert.assertTrue(totalUsage.contains(testData.get(5)));
			Assert.assertTrue(testData.get(6).contains(pbt.BalanceColumn().getText()));
			Assert.assertEquals(pbt.BenefitsPeriodColumn().getText(), date[0]);
			Assert.assertEquals(pbt.ActiveBenefitsPeriodColumn().getText(), "Y");
			Assert.assertEquals(pbt.EnrollDateColumn().getText(), currentDate);
			Assert.assertEquals(pbt.ExpirationDateColumn().getText(), lastDay.toString());
			Assert.assertEquals(pbt.RetroDateColumn().getText(), retroDate);
			Assert.assertEquals(pbt.UseNumberColumn().getText(), testData.get(7));
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyBenefitsHistoryTabDetailsAfterCheckAllForCTPCTM(List<String> testData) throws InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		String[] date = currentDate.split("-");
		
		LocalDate ld = LocalDate.now().minusDays(120);
		String retroDate = ld.toString();
		
		LocalDate now = LocalDate.now();
		LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfYear());
		
		
		boolean verify = true;
		if(verify)
		{
			String totalUsage = pbt.TotalUsageColumn().getText().substring(1, pbt.TotalUsageColumn().getText().length());
			Assert.assertTrue(totalUsage.contains(testData.get(5)));
			Assert.assertTrue(testData.get(6).contains(pbt.BalanceColumn().getText()));
			Assert.assertEquals(pbt.BenefitsPeriodColumn().getText(), date[0]);
			Assert.assertEquals(pbt.ActiveBenefitsPeriodColumn().getText(), "Y");
			Assert.assertEquals(pbt.EnrollDateColumn().getText(), currentDate);
			Assert.assertEquals(pbt.ExpirationDateColumn().getText(), lastDay.toString());
			Assert.assertEquals(pbt.RetroDateColumn().getText(), retroDate);
			Assert.assertEquals(pbt.UseNumberColumn().getText(), testData.get(7));
			
			Thread.sleep(2000);
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyACHPaymentsEFTReport(List<String> testData) throws InterruptedException, ParseException
	{
		String Programname = aph.ProgramTypeDropdown().getFirstSelectedOption().getText();
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		DateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
		
		Calendar c = Calendar.getInstance();  
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    String sDate = c.getTime().toString(); 
	    Date date = sdf.parse(sDate);
	    String stateDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
	    Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.DAY_OF_MONTH, c1.getActualMaximum(Calendar.DAY_OF_MONTH));
		String eDate = c1.getTime().toString();
	    Date date1 = sdf.parse(eDate);
	    String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
	   
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Num of rows:"+ael.ACHDetailsTableRows().size());
			System.out.println("test data:"+testData.get(1));
			System.out.println("value on UI:"+ael.DetailCardIDInGridLatestRow().getText());
			//click on cardID col to sort it in ascending manner so that the record will be in the last/latest row
			ael.ACHDetailsCardIDTableCol().click();
			for(int i=1;i<=ael.ACHDetailsTableRows().size();i++)
			{
				System.out.println("DetailCard: "+ael.DetailCardIDInGridMatchingRow(i).getText());
				System.out.println("testData:"+testData.get(1));
				if(ael.DetailCardIDInGridMatchingRow(i).getText().equalsIgnoreCase(testData.get(1)))
				{
					
					//summary
				/*	Assert.assertEquals(ael.SummaryProgramFirstRowValue().getText(), Programname);
					Assert.assertEquals(ael.SummaryACHStatusFirstRowValue().getText(), testData.get(8));
					Assert.assertTrue(ael.SummaryTotalAmountFirstRowValue().getText().contains(testData.get(9))); */
					
					//Detail
					System.out.println("Matching record found in row#:"+i);
					Assert.assertEquals(ael.DetailProgramMatchingRowValue(i).getText(), Programname);
					Assert.assertEquals(ael.DetailACHIDMatchingRowValue(i).getText(), testData.get(18));
					Assert.assertEquals(ael.DetailCardIDInGridMatchingRow(i).getText(), testData.get(1));
					Assert.assertTrue(ael.DetailTotalAmountMatchingRowValue(i).getText().contains(testData.get(9)));
					Assert.assertEquals(ael.DetailACHStatusInGridMatchingRow(i).getText(), testData.get(8));
					Assert.assertTrue(ael.DetailCreatedDateMatchingRowValue(i).getText().contains(currentDate));
					Assert.assertEquals(ael.DetailPaymentPeriodInGridMatchingRow(i).getText(), "Monthly");
					Assert.assertEquals(ael.DetailStateDateMatchingRowValue(i).getText(),stateDate);
					Assert.assertEquals(ael.DetailEndDateMatchingRowValue(i).getText(), endDate);
					
					if(ael.DetailACHStatusInGridMatchingRow(i).getText().equalsIgnoreCase("Completed"))
					{
						System.out.println("testData:"+testData.get(20));
						String[] textFile = testData.get(20).split("\\.csv");
						Assert.assertEquals(ael.DetailFileNameMatchingRowValue(i).getText(), textFile[0]+".txt"); 
					//	Assert.assertEquals(ael.DetailFileNameMatchingRowValue(i).getText(), testData.get(20));
						Assert.assertEquals(ael.HeaderFileNameMatchingRowValue(i).getText(), testData.get(20));
					}
					
					
				
					return verify;
				}
				else
				{
					System.out.println("No matching record found in checks EFTs List in row#:"+i);
				}
			}
			
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyACHPaymentsEFTReportAfterPaymentApproval(List<String> testData) throws InterruptedException, ParseException
	{
		String Programname = aph.ProgramTypeDropdown().getFirstSelectedOption().getText();
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		DateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
		
		Calendar c = Calendar.getInstance();  
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    String sDate = c.getTime().toString(); 
	    Date date = sdf.parse(sDate);
	    String stateDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
	    Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.DAY_OF_MONTH, c1.getActualMaximum(Calendar.DAY_OF_MONTH));
		String eDate = c1.getTime().toString();
	    Date date1 = sdf.parse(eDate);
	    String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
	    
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Num of rows:"+ael.ACHDetailsTableRows().size());
			System.out.println("test data:"+testData.get(1));
			System.out.println("value on UI:"+ael.DetailCardIDInGridLatestRow().getText());
			//click on cardID col to sort it in ascending manner so that the record will be in the last/latest row
			ael.ACHDetailsCardIDTableCol().click();
			//go through each row in the grid and compare the values
			for(int i=1; i<=ael.ACHDetailsTableRows().size();i++)
			{
				if(ael.DetailCardIDInGridMatchingRow(i).getText().equalsIgnoreCase(testData.get(1)))
				{
					//summary
				/*	Assert.assertEquals(ael.SummaryProgramFirstRowValue().getText(), Programname);
					Assert.assertEquals(ael.SummaryACHStatusFirstRowValue().getText(), testData.get(8));
					Assert.assertTrue(ael.SummaryTotalAmountFirstRowValue().getText().contains(testData.get(9))); */
					
					//Detail
					System.out.println("Matching record found at row#:"+i);
					Assert.assertEquals(ael.DetailProgramMatchingRowValue(i).getText(), Programname);
					Assert.assertEquals(ael.DetailACHIDMatchingRowValue(i).getText(), testData.get(12));
					Assert.assertEquals(ael.DetailCardIDInGridMatchingRow(i).getText(), testData.get(1));
					Assert.assertTrue(ael.DetailTotalAmountMatchingRowValue(i).getText().contains(testData.get(6)));
					Assert.assertEquals(ael.DetailACHStatusInGridMatchingRow(i).getText(), testData.get(4));
					Assert.assertTrue(ael.DetailCreatedDateMatchingRowValue(i).getText().contains(currentDate));
					Assert.assertEquals(ael.DetailPaymentPeriodInGridMatchingRow(i).getText(), "Monthly");
					Assert.assertEquals(ael.DetailStateDateMatchingRowValue(i).getText(),stateDate);
					Assert.assertEquals(ael.DetailEndDateMatchingRowValue(i).getText(), endDate);
				
					return verify;
					
				}
				else
				{
					System.out.println("No matching record found in checks EFTs List at row#:"+i);
				}
			}
			
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyACHPaymentsEFTReportAfterCheckAll(List<String> testData) throws InterruptedException, ParseException
	{
		String Programname = aph.ProgramTypeDropdown().getFirstSelectedOption().getText();
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		DateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
		
		Calendar c = Calendar.getInstance();  
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    String sDate = c.getTime().toString(); 
	    Date date = sdf.parse(sDate);
	    String stateDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
	    Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.DAY_OF_MONTH, c1.getActualMaximum(Calendar.DAY_OF_MONTH));
		String eDate = c1.getTime().toString();
	    Date date1 = sdf.parse(eDate);
	    String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
		
		boolean verify = true;
		if(verify)
		{
			ael.ACHDetailsCardIDTableCol().click();
			System.out.println("Num of rows:"+ael.ACHDetailsTableRows().size());
			System.out.println("test data:"+testData.get(1));
			System.out.println("value on UI:"+ael.DetailCardIDInGridLatestRow().getText());
			
			if(ael.DetailCardIDInGridLatestRow().getText().equalsIgnoreCase(testData.get(1)))
			{
				//summary
			/*	Assert.assertEquals(ael.SummaryProgramFirstRowValue().getText(), Programname);
				Assert.assertEquals(ael.SummaryACHStatusFirstRowValue().getText(), testData.get(8));
				Assert.assertTrue(ael.SummaryTotalAmountFirstRowValue().getText().contains(testData.get(9))); */
				
				//Detail
				Assert.assertEquals(ael.DetailProgramLatestRowValue().getText(), Programname);
				Assert.assertEquals(ael.DetailCardIDInGridLatestRow().getText(), testData.get(1));
				Assert.assertTrue(ael.DetailTotalAmountLatestRowValue().getText().contains(testData.get(9)));
				Assert.assertEquals(ael.DetailACHStatusInGridLatestRow().getText(), testData.get(8));
				Assert.assertTrue(ael.DetailCreatedDateLatestRowValue().getText().contains(currentDate));
				Assert.assertEquals(ael.DetailPaymentPeriodInGridLatestRow().getText(), "Monthly");
				Assert.assertEquals(ael.DetailStateDateLatestRowValue().getText(),stateDate);
				Assert.assertEquals(ael.DetailEndDateFirstRowValue().getText(), endDate);
				
				//filenames will be verified after the AWS scripts have been fixed
			
				return verify;
			}
			else
			{
				System.out.println("No matching record found in checks EFTs List");
			}
			
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsBeforePaymentAppovalAndCheckAllForClaimForCTPCTM(List<String> testData, String PaymentType) throws ParseException 
	{
		/*String[] date = testData.get(13).split("-");//0-d,1-mon,2-y
		int mon = cf.ConvertToMonthNumber(date[1]);
		String month = "";
		if(mon<10)
		{
			month = "0"+mon;
		}
		String formattedDate = date[2]+"-"+month+"-"+date[0];*/
		
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = sdf.parse(testData.get(13));
	    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
		String notes = " Date of Service #1: "+formattedDate+" Amount: "+testData.get(9);
		
		boolean verify = true;
		if(verify)
		{
			//click on cardID col to sort it in ascending manner so that the record will be in the last/latest row
			pmp.CardIDCol().click();//ascending
			pmp.CardIDCol().click();//descending
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();
			
			Assert.assertEquals(pmp.FirstRowPaymentStatusCol().getText(), testData.get(7));
			Assert.assertTrue(pmp.FirstRowAmountCol().getText().contains(testData.get(9)));
			Assert.assertEquals(pmp.FirstRowCardIDCol().getText(), testData.get(0));
			//Assert.assertEquals(pmp.FirstRowMemberIDCol().getText(), testData.get(0));
			Assert.assertTrue(pmp.FirstRowRequestDateCol().getText().contains(currentDate));
			Assert.assertEquals(pmp.FirstRowCheckStatusCol().getText(), testData.get(8));
			Assert.assertEquals(pmp.FirstRowPayeeInfoCol().getText(), testData.get(14));
//			Assert.assertEquals(pmp.FirstRowFaxIDCol().getText(), testData.get(15));
		//	Assert.assertTrue(pmp.FirstRowDateIssuedCol().getText().contains(currentDate));//We do not verify this field because it shows date only after Paid status for payment
		//	Assert.assertTrue(pmp.FirstRowDateSentCol().getText().contains(currentDate));
			
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "Yes");
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "No");
			}
			System.out.println("Before Notes");
			System.out.println("Found 1:"+pmp.FirstRowNotesCol().getText());
			System.out.println("Found 2:"+notes);
			Assert.assertTrue(pmp.FirstRowNotesCol().getText().contains(notes));
			System.out.println("After Notes");
			return verify;
			
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsAfterPaymentApprovalForCTPCTM(List<String> testData, String PaymentType, String patientdetails) throws InterruptedException, ParseException
	{
		/*String[] date = testData.get(13).split("-");//0-d,1-mon,2-y
		int mon = cf.ConvertToMonthNumber(date[1]);
		String month = "";
		if(mon<10)
		{
			month = "0"+mon;
		}
		String formattedDate = date[2]+"-"+month+"-"+date[0]; */
		
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = sdf.parse(testData.get(7));
	    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
		String notes = " Date of Service #1: "+formattedDate+" Amount: "+testData.get(6);
		
		boolean verify = true;
		if(verify)
		{
			pmp.CardID().sendKeys(testData.get(1));
			pmp.FindButton().click();
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();
			
			Assert.assertEquals(pmp.FirstRowPaymentStatusCol().getText(), testData.get(2));
			Assert.assertTrue(pmp.FirstRowAmountCol().getText().contains(testData.get(6)));
			Assert.assertEquals(pmp.FirstRowCardIDCol().getText(), testData.get(1));
			Assert.assertEquals(pmp.FirstRowMemberIDCol().getText(), testData.get(0));
			Assert.assertTrue(pmp.FirstRowRequestDateCol().getText().contains(currentDate));
			Assert.assertEquals(pmp.FirstRowCheckStatusCol().getText(), testData.get(5));
			Assert.assertEquals(pmp.FirstRowPayeeInfoCol().getText(), testData.get(8));
			Assert.assertEquals(pmp.FirstRowFaxIDCol().getText(), testData.get(9));
		//	Assert.assertTrue(pmp.FirstRowDateIssuedCol().getText().contains(currentDate));//This will contain a date only after Paid status
		//	Assert.assertTrue(pmp.FirstRowDateSentCol().getText().contains(currentDate));
			
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "Yes");
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "No");
			}
			System.out.println("Before Notes");
			System.out.println("Found 1:"+pmp.FirstRowNotesCol().getText());
			System.out.println("Found 2:"+notes);
			Assert.assertTrue(pmp.FirstRowNotesCol().getText().contains(notes));
			System.out.println("After Notes");
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsCheckAllForClaimForCTPCTM(List<String> testData, String PaymentType) throws ParseException 
	{
	/*	String[] date = testData.get(14).split("-");//0-d,1-mon,2-y
		int mon = cf.ConvertToMonthNumber(date[1]);
		String month = "";
		if(mon<10)
		{
			month = "0"+mon;
		}
		String formattedDate = date[2]+"-"+month+"-"+date[0]; */
		
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = sdf.parse(testData.get(14));
	    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
		String notes = " Date of Service #1: "+formattedDate+" Amount: "+testData.get(10);
		
		boolean verify = true;
		if(verify)
		{
			//click on cardID col to sort it in ascending manner so that the record will be in the last/latest row
			pmp.CardIDCol().click();//ascending
			pmp.CardIDCol().click();//descending
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();
			
			Assert.assertEquals(pmp.FirstRowPaymentStatusCol().getText(), testData.get(8));
			Assert.assertEquals(pmp.FirstRowCheckNumCol().getText(), testData.get(20));
			Assert.assertTrue(pmp.FirstRowAmountCol().getText().contains(testData.get(10)));
			Assert.assertEquals(pmp.FirstRowCardIDCol().getText(), testData.get(1));
			Assert.assertEquals(pmp.FirstRowMemberIDCol().getText(), testData.get(0));
			Assert.assertTrue(pmp.FirstRowRequestDateCol().getText().contains(currentDate));
			Assert.assertEquals(pmp.FirstRowCheckStatusCol().getText(), testData.get(9));
			Assert.assertEquals(pmp.FirstRowPayeeInfoCol().getText(), testData.get(15));
			Assert.assertEquals(pmp.FirstRowFaxIDCol().getText(), testData.get(16));
			Assert.assertTrue(pmp.FirstRowDateIssuedCol().getText().contains(currentDate));
		//	Assert.assertTrue(pmp.FirstRowDateSentCol().getText().contains(currentDate));
			
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "Yes");
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "No");
			}
			System.out.println("Before Notes");
			System.out.println("Found 1:"+pmp.FirstRowNotesCol().getText());
			System.out.println("Found 2:"+notes);
			Assert.assertTrue(pmp.FirstRowNotesCol().getText().contains(notes));
			System.out.println("After Notes");
			return verify;
			
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsCheckClearForClaimForCTPCTM(List<String> testData, String PaymentType) throws ParseException 
	{
	/*	String[] date = testData.get(11).split("-");//0-d,1-mon,2-y
		int mon = cf.ConvertToMonthNumber(date[1]);
		String month = "";
		if(mon<10)
		{
			month = "0"+mon;
		}
		String formattedDate = date[2]+"-"+month+"-"+date[0]; */
		
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = sdf.parse(testData.get(11));
	    String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    
		String notes = " Date of Service #1: "+formattedDate+" Amount: "+testData.get(7);
		
		boolean verify = true;
		if(verify)
		{
			//click on cardID col to sort it in ascending manner so that the record will be in the last/latest row
			pmp.CardIDCol().click();//ascending
			pmp.CardIDCol().click();//descending
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();
			
			Assert.assertEquals(pmp.FirstRowPaymentStatusCol().getText(), testData.get(2));
			Assert.assertEquals(pmp.FirstRowCheckNumCol().getText(), testData.get(17));
			Assert.assertTrue(pmp.FirstRowAmountCol().getText().contains(testData.get(7)));
			Assert.assertEquals(pmp.FirstRowCardIDCol().getText(), testData.get(1));
			Assert.assertEquals(pmp.FirstRowMemberIDCol().getText(), testData.get(0));
			Assert.assertTrue(pmp.FirstRowRequestDateCol().getText().contains(currentDate));
			Assert.assertEquals(pmp.FirstRowCheckStatusCol().getText(), testData.get(4));
			Assert.assertEquals(pmp.FirstRowPayeeInfoCol().getText(), testData.get(12));
			Assert.assertEquals(pmp.FirstRowFaxIDCol().getText(), testData.get(13));
			Assert.assertTrue(pmp.FirstRowDateIssuedCol().getText().contains(currentDate));
			Assert.assertTrue(pmp.FirstRowDateSentCol().getText().contains(currentDate));
			
			if(PaymentType.equalsIgnoreCase("CTP"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "Yes");
			}
			else if(PaymentType.equalsIgnoreCase("CTM"))
			{
				Assert.assertEquals(pmp.FirstRowPayPatientCol().getText(), "No");
			}
			System.out.println("Before Notes");
			System.out.println("Found 1:"+pmp.FirstRowNotesCol().getText());
			System.out.println("Found 2:"+notes);
			Assert.assertTrue(pmp.FirstRowNotesCol().getText().contains(notes));
			System.out.println("After Notes");
			return verify;
			
		}
		
		verify = false;
		return verify;
	}

	public boolean VerifyPaymentsInBOForACH(List<String> testData) throws ParseException
	{
		String fullName = testData.get(2)+" "+testData.get(3);
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		boolean verify = true;
		if(verify)
		{
			for(int i=1; i<=pbp.EFTToProviderTableRows().size(); i++)
			{
				System.out.println("testdata:"+testData.get(4));
				System.out.println("MemberID:"+pbp.EFTMemberIDColValue(i));
				if(pbp.EFTMemberIDColValue(i).equalsIgnoreCase(testData.get(4)))
				{
					System.out.println("Inside if of the EFT table condition");
					Assert.assertEquals(pbp.EFTProgramNameColValue(i), testData.get(1));
					Assert.assertEquals(pbp.EFTPatientNameColValue(i), fullName);
					Assert.assertEquals(pbp.EFTTreatmentIDColValue(i), testData.get(5));
					DateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
				    Date date1 = sdf1.parse(testData.get(6));
				    String formattedDOS = new SimpleDateFormat("YYYY-MM-dd").format(date1);
					Assert.assertEquals(pbp.EFTDOSColValue(i), formattedDOS);
					Assert.assertEquals(pbp.EFTACHIDColValue(i), testData.get(7));
					Assert.assertEquals(pbp.EFTPaymentIDColValue(i), testData.get(8));
					Assert.assertEquals(pbp.EFTACHStatusColValue(i), testData.get(9));
					Assert.assertTrue(pbp.EFTPaidAmountColValue(i).contains(testData.get(10)));
					Assert.assertTrue(pbp.EFTPaidDateColValue(i).contains(currentDate));
					Assert.assertEquals(pbp.EFTPartnerPracticeIDColValue(i), testData.get(11));
					break;
				}
			}
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyPaymentsInBOForCTPCTM(List<String> testData) throws ParseException
	{
		String fullName = testData.get(2)+" "+testData.get(3);
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		boolean verify = true;
		if(verify)
		{
			for(int i=1; i<=pbp.CheckToProviderTableRows().size(); i++)
			{
				System.out.println("testdata:"+testData.get(4));
				System.out.println("MemberID:"+pbp.MemberIDColValue(i));
				if(pbp.MemberIDColValue(i).equalsIgnoreCase(testData.get(4)))
				{
					System.out.println("Inside if of the EFT table condition");
					Assert.assertEquals(pbp.ProgramNameColValue(i), testData.get(1));
					Assert.assertEquals(pbp.PatientNameColValue(i), fullName);
					Assert.assertEquals(pbp.TreatmentIDColValue(i), testData.get(5));
					DateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
				    Date date1 = sdf1.parse(testData.get(6));
				    String formattedDOS = new SimpleDateFormat("YYYY-MM-dd").format(date1);
					Assert.assertEquals(pbp.DOSColValue(i), formattedDOS);
				//	Assert.assertEquals(pbp.CheckIDColValue(i), testData.get(7));// for now commneted. Need to check with manual QA, where is this data generated and how and if we can cross verify this field
					Assert.assertEquals(pbp.PaymentIDColValue(i), testData.get(8));
					Assert.assertEquals(pbp.CheckStatusColValue(i), testData.get(9));
					Assert.assertTrue(pbp.PaidAmountColValue(i).contains(testData.get(10)));
					Assert.assertTrue(pbp.PaidDateColValue(i).contains(currentDate));
					Assert.assertEquals(pbp.PartnerPracticeIDColValue(i), testData.get(11));
					break;
				}
			}
			return verify;
		}
		
		verify = false;
		return verify;
	}
}
