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
import com.juno.qa.getandsetTestData.Patients_Match;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_MatchPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC12_AdminPortal_Patients_MatchPatientWithPhysicianByGPName extends AdminPortalLoginLogoutPage {

	Patients_Match dat = new Patients_Match();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage app = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_MatchPage apm = new AdminPortal_Patients_MatchPage();
	AdminPortal_Patients_PatientAndCardTabPage ppc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	
	String Key = "MatchPatientWithPhysicianByGPName";
	String Key1 = "PatientProviderTabGridCols";
	String Key2 = "MatchPatientWithPhysicianByGPNameForAdminReimbursement";
	String Key3 = "MatchPatientWithPhysicianByGPNameForBothDrugReimbursement";
	String Key4 = "MatchPatientWithPhysicianByGPNameForBothAdminReimbursement";
	
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
	
	@Test ( description = "Verify ability to match a Physician as primary to a patient by GPName in DrugReimbursement" )
	public void Verify_Patients_MatchPrimaryPhysician_GPName_DrugReimbursement()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key1);
		List<String> providertabCols = new ArrayList<String>();
		providertabCols = dat.GetPatientProviderTabGridCols(Key1, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientMatchWithPhysicianTestData_DrugReimbursement(Key, rowNum1);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		//click on match link
		app.PatientsFindFirstMatchButton().click();
		//User should be navigated to Patient Information, Provider information tables with 'ASSIGN' button at the bottom of the page.
		Assert.assertEquals(apm.PatientInformationLabel().getText(), testData.get(10));
		Assert.assertTrue(apm.PatientInformationGrid().isDisplayed());
		Assert.assertEquals(apm.ProviderInformationLabel().getText(), testData.get(11));
		Assert.assertTrue(apm.ProviderInformationGrid().isDisplayed());
		Assert.assertTrue(apm.AssignButton().isDisplayed());
		
//		try
//		{
//			//PrimaryPhysician as ProviderType and by ProviderName for autosuggest
//			Assert.assertTrue(apm.VerifyAbilityToMatchAndUnlinkPrimaryProviderWithPatient(testData, providertabCols, apm.ProviderName(), testData.get(1),testData.get(14)));
//		}
//		catch(InterruptedException e)
//		{
//			
//		}
//		catch(IOException ie)
//		{
//			
//		}
//		catch(AWTException awt)
//		{
//			
//		}
		
		
		
		
		AdminPortalLogout();
	} 
	
	@Test ( description = "Verify ability to match a Physician as secondary to a patient by GPName in DrugReimbursement"  )
	public void Verify_Patients_MatchSecondaryPhysician_GPName_DrugReimbursement() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key1);
		List<String> providertabCols = new ArrayList<String>();
		providertabCols = dat.GetPatientProviderTabGridCols(Key1, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientMatchWithPhysicianTestData_DrugReimbursement(Key, rowNum1);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		//click on match link
		app.PatientsFindFirstMatchButton().click();
		Thread.sleep(2000);
		//User should be navigated to Patient Information, Provider information tables with 'ASSIGN' button at the bottom of the page.
		Assert.assertEquals(apm.PatientInformationLabel().getText(), testData.get(10));
		Assert.assertTrue(apm.PatientInformationGrid().isDisplayed());
		Assert.assertEquals(apm.ProviderInformationLabel().getText(), testData.get(11));
		Assert.assertTrue(apm.ProviderInformationGrid().isDisplayed());
		Assert.assertTrue(apm.AssignButton().isDisplayed());
		
//		try
//		{
//			//Secondary Physician as ProviderType and by Providername for autosuggest
//			Assert.assertTrue(apm.VerifyAbilityToMatchAndUnlinkSecondaryPrimaryProviderWithPatient(testData, providertabCols, apm.ProviderName(), testData.get(1),testData.get(15)));
//		}
//		catch(InterruptedException e)
//		{
//			
//		}
//		catch(IOException ie)
//		{
//			
//		}
//		catch(AWTException awt)
//		{
//			
//		}
//		
		
		AdminPortalLogout();
	} 
	
}
