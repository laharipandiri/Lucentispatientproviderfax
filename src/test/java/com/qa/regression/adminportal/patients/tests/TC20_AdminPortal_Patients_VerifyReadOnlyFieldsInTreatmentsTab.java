package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC20_AdminPortal_Patients_VerifyReadOnlyFieldsInTreatmentsTab extends AdminPortalLoginLogoutPage {

	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf =new CommonFunctions();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	
	String Key = "VerifyReadOnlyFieldsInTreatments";
	String Key1 = "RejectReasonDropdownValidations";
	String Key2 = "SmokePatientEnrollment";
	
	
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
	
	@Test ( description = "Verify ReadOnly Fields In Treatments Tab ")
	public void VerifyReadOnlyFieldsInTreatmentsTab_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum1 = etd.getKeyValuePair(Key2);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key2, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetVerifyReadOnlyFieldsInTreatmentsTestData(Key, rowNum);
		System.out.println("The testData is:"+testData);
		
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		apt.TreatmentsTabOption().click();
		Thread.sleep(20000);
		//MemberID	Program	ShortCardID	RequestPatientReleaseForm	BirthDate	PatientStatus	BenefitsBalanceRemaining	EnrollmentDate	RejectReason	BenefitsBalanceExpirationDate	DrugReimbursement	ProcedureReimbursement
		Assert.assertEquals(apt.ProgramField().getAttribute("readonly"), testData.get(1));
		Assert.assertEquals(apt.ShortCardIDInputTypeHidden().getAttribute("type"), testData.get(2));
		Assert.assertEquals(apt.RequirePatientReleaseFormInputTypeHidden().getAttribute("type"), testData.get(2));
		Assert.assertEquals(apt.MemberIDInputTypeHidden().getAttribute("type"), testData.get(2));
		Assert.assertEquals(apt.BenefitsBalanceRemaining().getAttribute("readonly"), testData.get(1));
		Assert.assertEquals(apt.BenefitsBalanceExpirationInputTypeHidden().getAttribute("type"), testData.get(2));
	//	Assert.assertEquals(apt.DrugReimbursementInputTypeHidden().getAttribute("type"), testData.get(2));
		
	//	Assert.assertEquals(apt.ProcedureReimbursementInputTypeHidden().getAttribute("type"), testData.get(2));
		
		//Assert for the following fields contains the attribute readonly or disabled with value null or true
	//	Assert.assertNull(apt.BirthDate().getAttribute(testData.get(3)));
		Assert.assertTrue(cf.isAttributePresent(apt.BirthDate(), testData.get(3)));
		Assert.assertNull(apt.EnrollmentType().getFirstSelectedOption().getAttribute(testData.get(4)));
		Assert.assertNull(apt.PatientStatusField().getAttribute(testData.get(4)));
		Assert.assertTrue(cf.isAttributePresent(apt.EnrollmentDate(), testData.get(3)));
		Assert.assertTrue(cf.isAttributePresent(apt.RejectReasonField(), testData.get(4)));
		
		//reporting
		if(apt.ProgramField().getAttribute("readonly").equalsIgnoreCase(testData.get(1)))
	     {
	    	TestBase.classAInstance.logReport("Pass","ReadOnly Fields In Treatments Tab","Succesfully able to  Verify ReadOnly Fields In Treatments Tab");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","ReadOnly Fields In Treatments Tab","Failed to  Verify  ReadOnly Fields In Treatments Tab");
	     }
		
		AdminPortalLogout();
		
	}
	
	@Test ( description  = "Verify that the Reject Reason dropdown is enabled when the Treatment Status is set to Rejected ")
	public void VerifyRejectReasonDropdownEnableDisableFeature_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum1 = etd.getKeyValuePair(Key2);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key2, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
		
		int rowNum = etd.getKeyValuePair(Key1);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetRejectReasonDropdownValidationsTestData(Key1, rowNum);
		System.out.println("The testData is:"+testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		apt.TreatmentsTabOption().click();
		Thread.sleep(20000);
		
		Assert.assertTrue(cf.isAttributePresent(apt.RejectReasonField(), testData.get(2)));
		apt.TreatmentStatus().selectByVisibleText(testData.get(1));
		//Assert.assertFalse(cf.isAttributePresent(apt.RejectReasonField(), testData.get(2)));
		Thread.sleep(3000);
		//reporting
		if(!cf.isAttributePresent(apt.RejectReasonField(), testData.get(2)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Reject Reason dropdown is enabled when the Treatment Status is set to Rejected","Succesfully able to  Verify Reject Reason dropdown is enabled when the Treatment Status is set to Rejected");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Reject Reason dropdown is enabled when the Treatment Status is set to Rejected","Failed to  Verify  Reject Reason dropdown is enabled when the Treatment Status is set to Rejected");
	     }
		
		AdminPortalLogout();
		
	} 
	

}
