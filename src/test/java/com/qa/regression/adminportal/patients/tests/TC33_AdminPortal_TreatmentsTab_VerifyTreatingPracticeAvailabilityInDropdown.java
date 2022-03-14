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
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.Patients_Match;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_MatchPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC33_AdminPortal_TreatmentsTab_VerifyTreatingPracticeAvailabilityInDropdown extends HubHomeLoginLogoutPage {
	
	String Key = "EnrollPatient";
	String Key1 = "MatchGPWithPatient";
	String Key2 = "EnrollAdminReimbursementPatient";
	String Key3 = "EnrollBothTypePatient";
	
	HubHomePage hhp=new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd= new ExcelTestDataReader();
	AdminPortalLoginLogoutPage all = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage app = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_MatchPage apm = new AdminPortal_Patients_MatchPage();
	AdminPortal_Patients_PatientAndCardTabPage ppc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	Patients_Match dat = new Patients_Match();
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			intializeHubDriver();
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
	
	@Test(description = "Verify the availability of Primary Treating Practice after patient is matched with a Treating Practice in Drug Reimbursement")
	public void verifyPrimaryTreatingPracticeAfterPatientMatchedWithTreatingPractice_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		

		WebDriverWait wait = new WebDriverWait(driver, 30);
		eft.HCPLogin();
		//wait.until(ExpectedConditions.visibilityOf(HubHomePageLogoutButton()));
		
		
		
		//Replatform code
		
		PatientsLink().click();
		Thread.sleep(1000);
		EnrollLink().click();
		Thread.sleep(4000);
		//click on Enroll Patient button HCP portal
		eft.EnrollInAdminPortal();
		
		
		
		
		//hrp.EnrollAPatientButton().click();
		//Thread.sleep(14000);
		eft.HCPLogout();
		//all.AdminPortalLogout();
		//AdminPortalLogout();
			
	} 

}
