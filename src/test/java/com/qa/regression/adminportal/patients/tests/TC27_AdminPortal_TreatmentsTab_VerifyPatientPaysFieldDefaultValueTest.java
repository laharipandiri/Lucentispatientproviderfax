package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC27_AdminPortal_TreatmentsTab_VerifyPatientPaysFieldDefaultValueTest extends AdminPortalLoginLogoutPage {
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	String Key = "DefaultPatientPays";
	

	
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

	
	@Test ( description = "Verify the default value for Patient Pays in treatments tab for a patient")
	public void VerifyPatientPaysDefaultValueInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientPaysDefaultTestData(Key, rowNum);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(50000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(15000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		Assert.assertTrue(atp.PatientPays().getAttribute("value").contains(testData.get(0)));
		System.out.println("the Patient pay default value is:" +(atp.PatientPays().getAttribute("value")));
		//reporting
		if(atp.PatientPays().getAttribute("value").contains(testData.get(0)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Default value for Patient Pays in treatments tab for a patient","Succesfully able to  Verify default value for Patient Pays in treatments tab for a patient:" +(atp.PatientPays().getAttribute("value")));
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Default value for Patient Pays in treatments tab for a patient","Failed to  Verify default value for Patient Pays in treatments tab for a patient");
	     }
		
		
		AdminPortalLogout();
	}		

	
	@Test ( description = "Verify the default value for Patient Pays in treatments tab for a patient for Both type enrollment", enabled = false)
	public void VerifyPatientPaysDefaultValueInTreatmentsTabForPatient_BothTypeEnrollment() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String both = etd.getBothValue(Key);
		if(both.equalsIgnoreCase("Yes"))
		{
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
	//	AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
				int rowNum = etd.getKeyValuePair(Key);
				List<String> testData = new ArrayList<String>();
				testData = dat.GetPatientPaysDefaultTestData(Key, rowNum);
				
				ahp.PatientsLink().click();
				ahp.FindLink().click();
				app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
				if(i==1)
				{
					app.PatientsFindPageMemberID().sendKeys("09552025196");
				}
				else if(i==2)
				{
					app.PatientsFindPageMemberID().sendKeys("49520276020");
				}
					
				app.PatientsPageFindButton().click();
				wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
				
				app.PatientsFindFirstReviewButton().click();
				wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
				
				//Go to treatments tab
				atp.TreatmentsTabOption().click();
				Thread.sleep(15000);
				wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
				
				Assert.assertTrue(atp.PatientPays().getAttribute("value").contains(testData.get(0)));
				
				//reporting
				if(atp.PatientPays().getAttribute("value").contains(testData.get(0)))
			     {
			    	TestBase.classAInstance.logReport("Pass","Default value for Patient Pays in treatments tab for a patient","Succesfully able to  Verify default value for Patient Pays in treatments tab for a patient");
			     }
			     else
			     {
			    	TestBase.classAInstance.logReport("Fail","Default value for Patient Pays in treatments tab for a patient","Failed to  Verify default value for Patient Pays in treatments tab for a patient");
			     }
				
				
				AdminPortalLogout();
			}
		}
	} 

}
