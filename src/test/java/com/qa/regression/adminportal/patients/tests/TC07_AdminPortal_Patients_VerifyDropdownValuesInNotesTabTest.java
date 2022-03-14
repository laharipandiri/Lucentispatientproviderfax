package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
import com.juno.qa.getandsetTestData.Patients_NotesTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_HelpDeskNotesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC07_AdminPortal_Patients_VerifyDropdownValuesInNotesTabTest extends AdminPortalLoginLogoutPage {
	
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_NotesTab dat = new Patients_NotesTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_HelpDeskNotesTabPage anp = new AdminPortal_Patients_HelpDeskNotesTabPage();
	
	String Key1 = "CallerDropdownsInPatientNotes";
	String Key2 = "ReasonDropdownsInPatientNotes";

	
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
	
	@Test ( description = "verify the values in caller dropdown in helpdesk notes for a patient")
	public void VerifyCallerDropdownValuesInHDNotesForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key1);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientsNotesCallerDropdownValues(Key1, rowNum);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to hdnotes tab
		anp.HelpDeskNotesTab().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(anp.AddButton()));
		
		anp.CallerDropdownList().click();
		//verify values in caller dropdown
		for(int i=1; i<=anp.callerDropwdownValues().size(); i++)
		{
			Assert.assertEquals(anp.CallerDropwdownValueNames(i).getText(), testData.get(i));
		}
		
		//reporting
		//if(!anp.callerDropwdownValues().isEmpty())
		if(anp.callerDropwdownValues().isEmpty()== false)
	     {
	    	TestBase.classAInstance.logReport("Pass","Caller dropdown in helpdesk notes for a patient","Succesfully able to  Verify caller dropdown in helpdesk notes for a patient");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Caller dropdown in helpdesk notes for a patient","Failed to  Verify caller dropdown in helpdesk notes for a patient");
	     }
		
		
		AdminPortalLogout();
	}		

	@Test ( description = "verify the values in reason dropdown in helpdesk notes for a patient")
	public void VerifyReasonDropdownValuesInHDNotesForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key2);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientsNotesCallerDropdownValues(Key2, rowNum);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to hdnotes tab
		anp.HelpDeskNotesTab().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(anp.AddButton()));
		
		anp.ReasonDropdownList().click();
		//verify values in reason dropdown
		for(int i=1; i<=anp.reasonDropwdownValues().size(); i++)
		{
			Assert.assertEquals(anp.ReasonDropwdownValues(i).getText(), testData.get(i));
		}
		
		//reporting
		//if(!anp.reasonDropwdownValues().isEmpty())
			if(anp.reasonDropwdownValues().isEmpty()== false)
	     {
	    	TestBase.classAInstance.logReport("Pass","Reason dropdown in helpdesk notes for a patient","Succesfully able to  Verify Reason dropdown in helpdesk notes for a patient");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Reason dropdown in helpdesk notes for a patient","Failed to  Verify Reason dropdown in helpdesk notes for a patient");
	     }
		
		
		AdminPortalLogout();
	}		


}
