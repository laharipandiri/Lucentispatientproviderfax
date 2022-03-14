package com.Xolairadmin.qa.SmokeScript;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FaxesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_BenefitsHisoryTabPage;
import com.juno.qa.pages.AdminPortal_Patients_EligibilityAndSurvey;
import com.juno.qa.pages.AdminPortal_Patients_HelpDeskNotesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_InsuranceTabPage;
import com.juno.qa.pages.AdminPortal_Patients_MessagesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PaymentsTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TransactionsTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsListTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.pages.ProviderPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.*;

//this is to collect all the locator information for search patient page


@Listeners(TestNGListner.class)
public class TC05_XolairAdminPortal_SearchPatientTabVerification extends AdminPortalLoginLogoutPage{
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderPage abc= new ProviderPage();
	PatientPage abd=new PatientPage();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Patients_InsuranceTabPage aty= new AdminPortal_Patients_InsuranceTabPage();
	AdminPortal_Patients_TreatmentsPage afg= new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Patients_ProviderTabPage afh= new AdminPortal_Patients_ProviderTabPage();
	AdminPortal_Patients_TreatmentsListTabPage afi= new AdminPortal_Patients_TreatmentsListTabPage();
	AdminPortal_Patients_TransactionsTabPage afj= new AdminPortal_Patients_TransactionsTabPage();
	AdminPortal_Patients_PaymentsTabPage afk= new AdminPortal_Patients_PaymentsTabPage();
	AdminPortal_PG_BO_FaxesTabPage afl= new AdminPortal_PG_BO_FaxesTabPage();
	AdminPortal_Patients_MessagesTabPage afm= new AdminPortal_Patients_MessagesTabPage();
	AdminPortal_Patients_EligibilityAndSurvey afn= new AdminPortal_Patients_EligibilityAndSurvey();
	AdminPortal_Patients_BenefitsHisoryTabPage afo= new AdminPortal_Patients_BenefitsHisoryTabPage();
	AdminPortal_Patients_HelpDeskNotesTabPage afp= new AdminPortal_Patients_HelpDeskNotesTabPage();
	
	//AdminPortal_Providers_FindPage app = new AdminPortal_Providers_FindPage();
	//AdminPortal_Providers_PhysicianAndCardInfoTabPage apc = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	
	//Regression excel sheet
	String Key = "SearchEnrolledPatient";
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			}
			catch(InterruptedException e) {
				
			}
	} 
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Verify the Search Patient", "Succesfully Verify the Search Patient");
			} else {
			TestBase.classAInstance.logReport("Fail", "Verify the Search Patient", "Failed to Verify the Search Patient");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Search Patient")
	public void SearchPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
	
		abd.PatientsLink().click(); //Click on  Patient link
		Thread.sleep(9000);
		//abd.PatientSearchLastName().sendKeys("a");
		abd.SearchPatient().click(); //Click on search Patient link
		//Thread.sleep(90000);
		
		Assert.assertTrue(abd.PatientSearchLastName().isDisplayed());
		if(abd.PatientSearchLastName().isDisplayed())
		 {
       	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Last Name Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Last Name Field");
		}
		
		Assert.assertTrue(abd.PatientSearchMemberID().isDisplayed());
		if(abd.PatientSearchMemberID().isDisplayed())
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Member ID Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Member ID Field");
		}
		
		Assert.assertTrue(abd.PatientSearchPartnerPatientID().isDisplayed());
		if(abd.PatientSearchPartnerPatientID().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Partner Patient ID Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Partner Patient IDe Field");
		}
		
		//This field is removed
		
		/*Assert.assertTrue(abd.PatientSearchPartnerPatientID().isDisplayed());
		if(abd.PatientSearchShortCardID().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Short Card ID Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Short Card ID Field");
		}*/
		
		Assert.assertTrue(abd.PatientSearchCity().isDisplayed());
		if(abd.PatientSearchCity().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify City Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify City Field");
		}
		
		Assert.assertTrue(abd.PatientSearchEnrollMaxDate().isDisplayed());
		if(abd.PatientSearchEnrollMaxDate().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Enroll Max Date Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Enroll Max Date Field");
		}
		
		Assert.assertTrue(abd.PatientSearchConfirmationID().isDisplayed());
		if(abd.PatientSearchConfirmationID().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Confirmation ID Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Confirmation ID Field");
		}
		
		Assert.assertTrue(abd.PatientSearchEnrollmentGuid().isDisplayed());
		if(abd.PatientSearchEnrollmentGuid().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Enrollment Guid Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Enrollment Guid Field");
		}
		
		Assert.assertTrue(abd.PatientSearchPatientuid().isDisplayed());
		if(abd.PatientSearchPatientuid().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Patient uid Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Patient uid Field");
		}
		
		Assert.assertTrue(abd.PatientSearchPatientStatus().isDisplayed());
		if(abd.PatientSearchPatientStatus().isDisplayed()== true)
		 {
      	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Status Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Status Field");
		}
		
		Assert.assertTrue(abd.PatientSearchEnrollmentDateFrom().isDisplayed());
		if(abd.PatientSearchEnrollmentDateFrom().isDisplayed()== true)
		 {
     	TestBase.classAInstance.logReport("Pass","Verified Patient search Fields","Succesfully able to Verify Enrollment Date From Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search Fields","Failed to Verify Enrollment Date From Field");
		}
		
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		System.out.println("Start time" +System.currentTimeMillis());
		Thread.sleep(40000);
		List<WebElement> gfh= abd.PatientSearchPagination().getOptions();
		//System.out.println("gfh is:" +gfh);
		/*abd.PatientSearchPagination().selectByVisibleText("5");
		abd.PatientSearchPagination().selectByVisibleText("10");
		Thread.sleep(3000);
		abd.PatientSearchPagination().selectByVisibleText("20");
		Thread.sleep(3000);
		abd.PatientSearchPagination().selectByVisibleText("50");
		Thread.sleep(3000);
		abd.PatientSearchPagination().selectByVisibleText("100");
		Thread.sleep(3000);
		abd.PatientSearchPagination().selectByVisibleText("5");
		Thread.sleep(5000);*/
		
		//Card and Info Tab
		System.out.println("end time" +System.currentTimeMillis());
		abd.PatientReview().click(); //Click on Review button for 1st patient
		/*
		Thread.sleep(7000);
		
		boolean hhh1= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Card and Info Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Card and Info Tab");
			}
			
		Assert.assertTrue(abd.PatientAndCardTabUpdateButton().isDisplayed()); //Update button
		Assert.assertTrue(abd.PatientAndCardTabCancelButton().isDisplayed()); //Cancle button
		Assert.assertTrue(abd.PatientAndCardTabGoBackButton().isDisplayed()); //Go Back button
		abd.PatientAndCardTabFSVDATAExpandable().click(); //FSV DATA from portal.clientaccesssite.com
		Thread.sleep(4000);
		abd.PatientAndCardTabCurrentYearProgramBnBExpandable().click();//Current Year Program Benefit and Balances
		Thread.sleep(4000);
		abd.PatientAndCardTabDebitCardInfoExpandable().click(); //Debit Card Information
		Thread.sleep(4000);
		abd.PatientAndCardTabCardReplacementExpandable().click(); //Card Replacement
		Thread.sleep(4000); 
		abd.PatientAndCardTabCardReplacementHistoryExpandable().click(); //Card Replacement History
		Thread.sleep(4000);
		abd.PatientAndCardTabCardAuthAmountExpandable().click(); //Card Authorization Amounts
		Thread.sleep(4000);
		abd.PatientAndCardTabCardSwipeInfoExpandable().click(); //Card Swipe info
		Thread.sleep(4000);
		abd.PatientAndCardTabFSVSystemStatusExpandable().click(); //FSV System Status
		Thread.sleep(4000);
		
		//Insurance Tab
		
		aty.InsuranceTab().click();
		Thread.sleep(8000);
		String aa=driver.getPageSource();
		//System.out.println("aa" +aa);
		boolean hhh2= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh:" +hhh2);
		
		 if (hhh2 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Insurance Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Insurance Tab");
			}
		
		
		Assert.assertTrue(aty.InsuranceTabInsuranceGroupNumber().isDisplayed());
		if(aty.InsuranceTabInsuranceGroupNumber().isDisplayed()== true)
		 {
    	TestBase.classAInstance.logReport("Pass","Verified Patient search-Insurance Tab","Succesfully able to Verify Insurance Group Number Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search-Insurance Tab","Failed to Verify Insurance Group Number Field");
		}
		
		Assert.assertTrue(aty.InsuranceTabInsuranceMemberNumber().isDisplayed());
		if(aty.InsuranceTabInsuranceMemberNumber().isDisplayed()== true)
		 {
			TestBase.classAInstance.logReport("Pass","Verified Patient search-Insurance Tab","Succesfully able to Verify Insurance Member Number Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search-Insurance Tab","Failed to Verify Insurance Member Number Field");
		}
		
		Assert.assertTrue(aty.InsuranceTabInsuranceBIN().isDisplayed());
		if(aty.InsuranceTabInsuranceBIN().isDisplayed()== true)
		 {
			TestBase.classAInstance.logReport("Pass","Verified Patient search-Insurance Tab","Succesfully able to Verify Insurance BIN Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search-Insurance Tab","Failed to Verify Insurance BIN Field");
		}
		
		Assert.assertTrue(aty.InsuranceTabInsurancePCN().isDisplayed());
		if(aty.InsuranceTabInsurancePCN().isDisplayed()== true)
		 {
			TestBase.classAInstance.logReport("Pass","Verified Patient search-Insurance Tab","Succesfully able to Verify Insurance PCN Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search-Insurance Tab","Failed to Verify Insurance PCN Field");
		}
		
		Assert.assertTrue(aty.InsuranceTabInsuranceMemberNumber().isDisplayed());
		if(aty.InsuranceTabInsuranceMemberNumber().isDisplayed()== true)
		 {
			TestBase.classAInstance.logReport("Pass","Verified Patient search-Insurance Tab","Succesfully able to Verify Insurance Member Number Field");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Patient search-Insurance Tab","Failed to Verify Insurance Member Number Field");
		}
		
		Assert.assertTrue(aty.InsuranceTabName().isDisplayed());
		if(aty.InsuranceTabName().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Verified Insurance tab content","Succesfully able to Verify Insurance tab content");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Insurance tab content","Failed to Verify Insurance tab content");
		}
		Thread.sleep(3000);
		
		//Treatment Tab
		
		afg.TreatmentsTabOption().click();
		Thread.sleep(10000);
		
		boolean hhh3= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh3:" +hhh3);
		
		 if (hhh3 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Treatment Tab");
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Treatment Tab");
			}
		
		Assert.assertTrue(afg.AddButton().isDisplayed());
		if(afg.AddButton().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Verified Treatment tab content","Succesfully able to Verify Treatment tab content-22");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified Treatment tab content","Failed to Verify Treatment tab content-22");
		}*/
	/*	
		//Provider Tab
		
		afh.PatientProviderTab().click();
		Thread.sleep(4000);
				
		boolean hhh4= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh4:" +hhh4);
		
		 if (hhh4 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Provider Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Provider Tab");
			}
		 
		Assert.assertTrue(afh.PrimaryProviderInfm().isDisplayed());
		if(afh.PrimaryProviderInfm().isDisplayed()== true) 
		 {
       	TestBase.classAInstance.logReport("Pass","Match Provider Tab","Succesfully able to Verify Primary Provider Information");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Tab","Failed to Verify Primary Provider Information");
		}
		//Clicks on  Patient's Provider List
		Assert.assertTrue(afh.PatientProviderList().isDisplayed());
		if(!afh.PatientProviderList().isDisplayed())
		 {
      	TestBase.classAInstance.logReport("Pass","Match Provider Tab","Succesfully able to Verify Patient's Provider List");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Tab","Failed to Verify Patient's Provider List");
		}
		
		//Click on PatientLinkedProviderList
		Assert.assertTrue(afh.PatientLinkedProviderList().isDisplayed());
		if(!afh.PatientLinkedProviderList().isDisplayed())
		 {
      	TestBase.classAInstance.logReport("Pass","Provider Tab","Succesfully able to Verify Patient Linked Provider List");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Provider Tab","Failed to Verify Patient Linked Provider List");
		}
		
		
		
		Assert.assertTrue(afh.MatchProviderButton().isDisplayed());
		if(afh.MatchProviderButton().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Match Provider Button is present","Succesfully able to Verify Match Provider Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Button is not present","Failed to Verify Match Provider Button");
		}
		
		boolean data= afh.MatchProviderUnlink().
		
		if(data == true)
		 {
       	TestBase.classAInstance.logReport("Pass","Match Provider Button is present","Succesfully able to Verify Match Provider Unlink Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Button is not present","Failed to Verify Match Provider Unlink Button");
		}
		Thread.sleep(4000);
		afh.ProviderActionFirstRowValue().click();
		Thread.sleep(9000);
		
		Assert.assertTrue(afh.ProviderAfterReviewVerify().isDisplayed());
		if(afh.ProviderAfterReviewVerify().isDisplayed()== true)
		 {
       	TestBase.classAInstance.logReport("Pass","Patient Search-Provider-Review","Succesfully able to Verify Match Provider Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Patient Search-Provider-Review","Failed to Verify Match Provider Button");
		}
		*/
		//Treatment List Tab
		
		abd.PatientsLink().click(); //Click on  Patient link
		abd.SearchPatient().click(); //Click on search Patient link
		Thread.sleep(3000);
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		Thread.sleep(40000);
		abd.PatientReview().click(); //Click on Review button for 1st patient
		Thread.sleep(4000);
			
		afi.TreatmentsListTab().click();
		Thread.sleep(4000);
		
		boolean hhh5= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh5:" +hhh5);
		
		 if (hhh5 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Treatment List Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Treatment List Tab");
			}
		
		afi.TreatmentsListShowTreatmentInfo().click();
		Thread.sleep(4000);
		Assert.assertTrue(afi.TreatmentsListShowTreatmentInfo().isDisplayed());
		
		if(afi.TreatmentsListShowTreatmentInfo().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Treatment list tab","Succesfully Verified Show Treatment Information");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Button is not present","Failed to Verify Show Treatment Information");
		}
		
		afi.TreatmentsListEDITreatmentInfo().click();
		Thread.sleep(4000);
		Assert.assertTrue(afi.TreatmentsListEDITreatmentInfo().isDisplayed());
		
		if(afi.TreatmentsListEDITreatmentInfo().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Treatment list tab","Succesfully Verified EDI Show Treatment Information");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Button is not present","Failed to Verify EDI Show Treatment Information");
		}
		
		//Transaction Tab
		
		afj.TransactionsTab().click();
		Thread.sleep(4000);
		
		boolean hhh6= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh6:" +hhh6);
		
		 if (hhh6 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Transaction Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Transaction Tab");
			}
				
		afj.Pagination().selectByVisibleText("5");
		Thread.sleep(2000);
		afj.Pagination().selectByVisibleText("10");
		Thread.sleep(2000);
		afj.Pagination().selectByVisibleText("20");
		Thread.sleep(2000);
		afj.Pagination().selectByVisibleText("50");
		Thread.sleep(2000);
		afj.Pagination().selectByVisibleText("100");
		Thread.sleep(3000);
		
		Assert.assertTrue(afj.TransactionsTab().isDisplayed());
		if(afj.TransactionsTab().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Treatment list tab","Succesfully Verified Show Treatment Information");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Match Provider Button is not present","Failed to Verify Show Treatment Information");
		}
		
		//Payment Tab
		
		afk.PaymentsTab().click();
		Thread.sleep(4000);
		
		boolean hhh7= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh7:" +hhh7);
		
		 if (hhh7 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Payment Tab" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Payment Tab");
			}
			
		Assert.assertTrue(afk.CardReplacement().isDisplayed());
		Assert.assertTrue(afk.CheckPaymentInformation().isDisplayed());
		Assert.assertTrue(afk.EFTPayment().isDisplayed());
		Assert.assertTrue(afk.DEBITCARDPaymentInformation().isDisplayed());
		Assert.assertTrue(afk.PaymentsTab().isDisplayed());
		
		if(afk.PaymentsTab().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Payment tab","Succesfully Verified Payment tab");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Payment tab","Failed to Verify Payment tab");
		}
		
		afk.RepaymentCard().click();
		Thread.sleep(4000);
				
		Assert.assertTrue(afk.RepaymentCardInfo().isDisplayed());
		Assert.assertTrue(afk.RepaymentCardPaymentInfo().isDisplayed());
		Assert.assertTrue(afk.RepaymentCardProviderInfo().isDisplayed());
		
		if(afk.RepaymentCardAddUpdate().isDisplayed()== true)
		 {
       	TestBase.classAInstance.logReport("Pass","Search Patient- Payment tab","Succesfully Verified RepaymentCard");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Payment tab","Failed to Verify RepaymentCard");
		}
		
		//Fax Info 
		/*
		abd.PatientsLink().click(); //Click on  Patient link
		abd.SearchPatient().click(); //Click on search Patient link
		Thread.sleep(3000);
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		Thread.sleep(40000);
		abd.PatientReview().click(); //Click on Review button for 1st patient
		Thread.sleep(4000);
		afl.FaxesTab().click();
		Thread.sleep(8000);
					
		boolean hhh8= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh8:" +hhh8);
		
	
		 if (hhh8 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Fax Info:" +hhh8);
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Fax Info");
			}
		
		Assert.assertTrue(afl.FaxesTabVerification().isDisplayed());
		if(afl.FaxesTabVerification().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Fax info tab","Succesfully Verified Fax info tab");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Fax info tab","Failed to Verify Fax info tab");
		}
		
		//Message Tab
		
		afm.MessagesTab().click();
		Thread.sleep(8000);
		
		boolean hhh9= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh9:" +hhh9);
		
		 if (hhh9 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Message Tab:" +hhh9);
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Message Tab");
			}
		Assert.assertTrue(afm.MessagesTab().isDisplayed());
		if(afm.MessagesTab().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Message tab","Succesfully Verified Message tab");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Message tab","Failed to Verify Message tab");
		}
		
		//Eligibility and Survey Tab
		
		afn.EligibilityTab().click();
		Thread.sleep(8000);
		
		boolean hhh10= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh10:" +hhh10);
		
		 if (hhh10 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Eligibility and Survey Tab");
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Eligibility and Survey Tab");
			}
		 
		Assert.assertTrue(afn.EligibilityTab().isDisplayed());
		
		if(afn.EligibilityTab().isDisplayed()== true)
		 {
        	TestBase.classAInstance.logReport("Pass","Search Patient- Eligibility Tab","Succesfully Verified Eligibility Tab");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Eligibility Tab","Failed to Verify Eligibility Tab");
		}
		
		String Message= "Questions\r\n" + 
				"# Description Answer\r\n" + 
				"Activation Type Reported Date Reviewed Date\r\n" + 
				"3 Are you currently 18 years of age or older? yes\r\n" + 
				"4 Are you receiving drug assistance through the Genentech® Access to Care Foundation or any other charitable organization? no\r\n" + 
				"5 Are you utilizing any federal or state-funded healthcare program? This includes, but is not limited to, Medicare, Medicaid, Medigap, VA, DoD and TRICARE. no\r\n" + 
				"6 Insurance company name BCBS\r\n" + 
				"7 Insurance plan type PPO\r\n" + 
				"8 Insurance group number 019847\r\n" + 
				"9 Insurance member number 834289180\r\n" + 
				"16 Would the patient like to enroll in the patient support program? no\r\n" + 
				"18 I am using XOLAIR for the FDA-approved indication listed below CIU\r\n" + 
				"19 I give my consent to enroll in the XOLAIR Co-pay Card Program yes\r\n" + 
				"20 Are you on commercial (also known as private) insurance? yes\r\n" + 
				"21 Please select the state in which you reside: IL\r\n" + 
				"22 I agree to be contacted by phone or mail with the information and/or materials about my XOLAIR Co-pay Card Program. For more information, our privacy policy can be found at: www.xolair.com. agree\r\n" + 
				"23 By using the XOLAIR Co-pay Card Program, the patient acknowledges and confirms that at the time of usage, (s)he is currently eligible and meets the criteria set forth in the terms and descriptions described: agree\r\n" + 
				"HUB Portal 2018-01-01 23:28:08.224904";
		String abc= afn.EligibilityQuestions().getText();
		//System.out.println("abc:" +abc);
		Assert.assertTrue(afn.EligibilityQuestions().isDisplayed());
		if(afn.EligibilityQuestions().isDisplayed()== true)
		 {
       	TestBase.classAInstance.logReport("Pass","Search Patient- Eligibility Tab","Succesfully Verified Eligibility Table with questions:"  +abc);
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Search Patient- Eligibility Tab","Failed to Verify Eligibility Table with questions");
		}
		
		//Benefits History
		
		afo.BenefitsHistoryTab().click();
		Thread.sleep(6000);
		
		boolean hhh11= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh11:" +hhh11);
		
		 if (hhh11 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Benefits History" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Benefits History");
			}
		
		Assert.assertTrue(afo.BenefitsHistoryTableHeader().isDisplayed());
		Assert.assertFalse(afo.BenefitsHistoryTable().isEmpty());
		
		if(afo.BenefitsHistoryTable().isEmpty()== true)
		 {
			TestBase.classAInstance.logReport("Fail","Search Patient- Benefit History Tab","Failed to Verify Benefit History table");
		}
		else
		{		
			TestBase.classAInstance.logReport("Pass","Search Patient- Benefit History Tab","Succesfully Verified Benefit History table");
		}
		
		//HelpDesk Notes
		
		afp.HelpDeskNotesTab().click();
		Thread.sleep(6000);
			
		boolean hhh12= driver.getPageSource().contains("PHP Error");
		//System.out.println("hhh12:" +hhh12);
		
		 if (hhh12 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-HelpDesk Notes" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-HelpDesk Notes");
			}
		Assert.assertTrue(afp.HelpDeskNotesHeader().isDisplayed());
		if(afp.HelpDeskNotesHeader().isDisplayed()== true)
		 {
			TestBase.classAInstance.logReport("Pass","Search Patient- Help Desk Notes Tab","Succesfully Verified Help Desk Notes");
		}
		else
		{	TestBase.classAInstance.logReport("Fail","Search Patient- Help Desk Notes Tab","Failed to Verify Help Desk Notes");	
			
		}
	*/
		AdminPortalLogout();
	}		

}
