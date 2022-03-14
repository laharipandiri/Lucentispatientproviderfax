package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC23_AdminPortal_Patients_VerifyDOSAndEOBDatePickersFutureDatesDisabledTest extends AdminPortalLoginLogoutPage {
	
	CommonFunctions cf =new CommonFunctions();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	
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
	@Test ( description = "Verify DOS date picker future date/month/year are disabled/not available In Treatments Tab")
	public void VerifyFutureDatesDisabledForDOSDateTreatmentsTab() throws InterruptedException, IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
				
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		apt.TreatmentsTabOption().click();
		Thread.sleep(20000);
		
		apt.DateOfService().click();
		//Now assert future dates are disabled in date picker
		System.out.println("current date: "+currentDate);
		//Assert.assertTrue(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ));//the last two parameters are the class attribute values for td elements that identifies if the date is enabled/disabled
		//reporting
		if(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ))
		{Thread.sleep(20000);
			TestBase.classAInstance.logReport("Pass","DOS date picker future date/month/year are disabled/not available In Treatments Tab","Succesfully able to  Verify DOS date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","DOS date picker future date/month/year are disabled/not available In Treatments Tab","Failed to  Verify  DOS date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
		
		AdminPortalLogout();
	}		
	
		
	
	
	@Test ( description = "Verify EOB date picker future date/month/year are disabled/not available In Treatments Tab")
	public void VerifyFutureDatesDisabledForEOBDateTreatmentsTab() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
				
		ahp.PatientsLink().click();
		ahp.FindLink().click();

		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		apt.TreatmentsTabOption().click();
		Thread.sleep(20000);
		
		apt.EOBDate().click();
		//Now assert future dates are disabled in date picker
		System.out.println("current date: "+currentDate);
		//Assert.assertTrue(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ));//the last two parameters are the class attribute values for td elements that identifies if the date is enabled/disabled
		//reporting
		 //scroll down to capture the screenshot at the correct location
        js.executeScript("window.scrollBy(0,850)", "");
		if(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ))
		{
			TestBase.classAInstance.logReport("Pass","EOB date picker future date/month/year are disabled/not available In Treatments Tab","Succesfully able to  Verify EOB date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","EOB date picker future date/month/year are disabled/not available In Treatments Tab","Failed to  Verify  EOB date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
		
		AdminPortalLogout();
	}		
	 
	/*
	@Test ( description = "Verify DOS date picker future date/month/year are disabled/not available In Treatments Tab for BothTypeEnrollment", enabled = false)
	public void VerifyFutureDatesDisabledForDOSDateTreatmentsTab_BothTypeEnrollment() throws InterruptedException, IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
				
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPageMemberID().sendKeys("19552025240");
		
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		apt.TreatmentsTabOption().click();
		Thread.sleep(20000);
		
		apt.DateOfService().click();
		//Now assert future dates are disabled in date picker
		System.out.println("current date: "+currentDate);
		//Assert.assertTrue(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ));//the last two parameters are the class attribute values for td elements that identifies if the date is enabled/disabled
		//reporting
		if(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ))
		{
			TestBase.classAInstance.logReport("Pass","DOS date picker future date/month/year are disabled/not available In Treatments Tab","Succesfully able to  Verify DOS date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","DOS date picker future date/month/year are disabled/not available In Treatments Tab","Failed to  Verify  DOS date picker future date/month/year are disabled/not available In Treatments Tab");
	     }
		
		AdminPortalLogout();
}		
	
		
	 
	
	@Test ( description = "Verify EOB date picker future date/month/year are disabled/not available In Treatments Tab for BothTypeEnrollment", enabled = false)
	public void VerifyFutureDatesDisabledForEOBDateTreatmentsTab_BothTypeEnrollment() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for(int i=1; i<=2; i++)
		{
			if(i==1)
			{
				AdminPortalLogin();
			}
			else 
			{
				AdminReimbursementPortalLogin();
			}
		//AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
				
				ahp.PatientsLink().click();
				ahp.FindLink().click();
				if(i==1)
				{
					app.PatientsFindPageMemberID().sendKeys("19552025240");
				}
				else if(i==2)
				{
					app.PatientsFindPageMemberID().sendKeys("29520276066");
				}
				app.PatientsPageFindButton().click();
				wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
				
				app.PatientsFindFirstReviewButton().click();
				wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
				
				apt.TreatmentsTabOption().click();
				Thread.sleep(20000);
				
				apt.EOBDate().click();
				//Now assert future dates are disabled in date picker
				System.out.println("current date: "+currentDate);
				//Assert.assertTrue(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ));//the last two parameters are the class attribute values for td elements that identifies if the date is enabled/disabled
				//reporting
				 //scroll down to capture the screenshot at the correct location
		        js.executeScript("window.scrollBy(0,850)", "");
				if(cf.VerifyFutureDatesAreDisabled(currentDate,  "ui-state-disabled", "ui-datepicker-today" ))
				{
					TestBase.classAInstance.logReport("Pass","EOB date picker future date/month/year are disabled/not available In Treatments Tab","Succesfully able to  Verify EOB date picker future date/month/year are disabled/not available In Treatments Tab");
			     }
			     else
			     {
			    	TestBase.classAInstance.logReport("Fail","EOB date picker future date/month/year are disabled/not available In Treatments Tab","Failed to  Verify  EOB date picker future date/month/year are disabled/not available In Treatments Tab");
			     }
				
				AdminPortalLogout();
		}
	} 
*/
}
