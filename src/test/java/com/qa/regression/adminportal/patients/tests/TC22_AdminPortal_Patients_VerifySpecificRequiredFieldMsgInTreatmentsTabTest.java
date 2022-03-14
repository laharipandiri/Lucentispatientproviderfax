package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.HubUploadEOBPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC22_AdminPortal_Patients_VerifySpecificRequiredFieldMsgInTreatmentsTabTest extends AdminPortalLoginLogoutPage {

	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	HubUploadEOBPage hup = new HubUploadEOBPage();
	AdminPortal_Faxes_IncomingFindPage aif = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	
	String Key = "VerifyIndividualRequiredFields";
	String Key1 = "VerifyIndividualRequiredFieldsForAdminReimbursement";
	String Key2 = "VerifyIndividualRequiredFieldsForBothDrugReimbursement";
	String Key3 = "VerifyIndividualRequiredFieldsForBothAdminReimbursement";
	String Key4 = "SmokePatientEnrollment";
	
	
	public void OpenBrowser()  
	{
		try {
			System.out.println("I am intialize Admin");
			intializeAdminDriver();
			System.out.println("I am intialize Admin-Done");
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			}
			catch(InterruptedException e) {
				
			}
	} 
	

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestBase.classAInstance.logReport(testStatusRef.get(result.getStatus()),
					result.getMethod().getDescription(),
					"Succesfully able to " + result.getMethod().getDescription());
		} else {
			result.getThrowable().printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			TestBase.classAInstance.logReport(testStatusRef.get(result.getStatus()),
					result.getMethod().getDescription(), "Failed to " + result.getMethod().getDescription());
		}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify EOB Date required Field In Treatments Tab in DrugReimbursement")
	public void VerifyEOBDateRequiredFieldInTreatmentsTab_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		int rowNum1 = etd.getKeyValuePair(Key4);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key4, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
		System.out.println("The testData1 is:" +testData1);
		
		//Specify all required fields except for EOBDAte
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetVerifyIndividualRequiredFieldsTestData(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		//First upload EOB and then add the fax
		//Upload EOB
		//Assert.assertTrue(hup.UploadEOB(testData.get(21), testData.get(22), testData.get(0), "Drug reimbursement"));
		//Add Fax
		OpenBrowser();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		//wait.until(ExpectedConditions.visibilityOf(aif.MemberID()));
		aif.EnrollFromDate().clear();
		aif.EnrollFromDate().sendKeys("2021-01-15");
		//app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
		aif.FaxesPageFindButton().click();
		
		
		Thread.sleep(50000);
		wait.until(ExpectedConditions.visibilityOf(aif.PatientReviewLinkFirstRow()));
		aif.PatientReviewLinkFirstRow().click();
		
		if(aip.IncomingFaxMemberID().getAttribute("value").isEmpty())
 		{

 			aip.IncomingFaxMemberID().sendKeys("EYE00044690");
 		}
 		else
 		{
 			aip.IncomingFaxMemberID().clear();
 			aip.IncomingFaxMemberID().sendKeys("EYE00044690");
 		}
				
		
		AdminPortalLogout();
		//CloseBrowser(null);
		
		
	} 
	
}