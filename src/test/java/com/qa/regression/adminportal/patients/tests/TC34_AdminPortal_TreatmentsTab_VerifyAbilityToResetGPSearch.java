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
public class TC34_AdminPortal_TreatmentsTab_VerifyAbilityToResetGPSearch extends AdminPortalLoginLogoutPage {

	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	String Key = "ResetGPAutoSuggestSearch";
	String Key1 = "ResetGPAutoSuggestSearchForAdminReimbursement";
	String Key2 = "ResetGPAutoSuggestSearchForBothDrugReimbursement";
	String Key3 = "ResetGPAutoSuggestSearchForBothAdminReimbursement";
	

	
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
	
	@Test ( description = "Verify the GP reset search in treatments tab for a patient in DrugReimbursement")
	public void VerifyGPResetSearchInTreatmentsTabForPatient_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetResetGPAutoSuggestSearchTestData(Key, rowNum);
		System.out.println("testData is:" +testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData.get(0));
		app.PatientsPageFindButton().click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(15000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		//select the BO option
		atp.SelectTreatingPracticeDropdownFirstValidOption().click();
		
		Assert.assertFalse(atp.TreatingPracticeNameValue().isEmpty());
		Assert.assertFalse(atp.TreatingAddressValue().isEmpty());
		Assert.assertFalse(atp.TreatingCityValue().isEmpty());
		Assert.assertFalse(atp.TreatingStateValue().isEmpty());
		Assert.assertFalse(atp.TreatingZipValue().isEmpty());
		Assert.assertFalse(atp.TreatingPhoneNumberValue().isEmpty());
		Assert.assertFalse(atp.TreatingFaxNumberValue().isEmpty());
		//Assert.assertFalse(atp.TreatingTaxNumberValue().isEmpty());
		Assert.assertFalse(atp.TreatingNPIValue().isEmpty());
		Assert.assertFalse(atp.TreatingProviderIDValue().isEmpty());
		
		Assert.assertFalse(atp.SelectTreatingPracticeDropdown().isDisplayed());
		Assert.assertFalse(atp.PracticeName().isDisplayed());
		Assert.assertFalse(atp.PracticeNPI().isDisplayed());
		
		//Now click on Reset Search button
		atp.GPResetSearchButton().click();
		
		Assert.assertTrue(atp.SelectTreatingPracticeDropdown().isDisplayed());
		Assert.assertTrue(atp.PracticeName().isDisplayed());
		Assert.assertTrue(atp.PracticeNPI().isDisplayed());
		
		AdminPortalLogout();
	}
	
	
	
}
