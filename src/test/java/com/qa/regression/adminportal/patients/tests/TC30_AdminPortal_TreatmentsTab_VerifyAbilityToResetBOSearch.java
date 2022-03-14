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
public class TC30_AdminPortal_TreatmentsTab_VerifyAbilityToResetBOSearch extends AdminPortalLoginLogoutPage {
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	String Key = "ResetBOAutoSuggestSearch";
	String Key1 = "ResetBOAutoSuggestSearchForAdminReimbursement";
	String Key2 = "ResetBOAutoSuggestSearchForBothDrugReimbursement";
	String Key3 = "ResetBOAutoSuggestSearchForBothAdminReimbursement";
	
	

	
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
	
	@Test ( description = "Verify the BO reset search in treatments tab for a patient in DrugReimbursement")
	public void VerifyBOResetSearchInTreatmentsTabForPatient_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetResetBOAutoSuggestSearchTestData(Key, rowNum);
		System.out.println("testData is:" +testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData.get(0));
		app.PatientsPageFindButton().click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(40000);
		//select the BO option
		atp.SelectBillingProviderDropdownFirstValidOption().click();
		
		Assert.assertFalse(atp.BillingNameValue().isEmpty());
		Assert.assertFalse(atp.ContactFirstNameValue().isEmpty());
		Assert.assertFalse(atp.ContactLastNameValue().isEmpty());
		Assert.assertFalse(atp.AddressValue().isEmpty());
		Assert.assertFalse(atp.CityValue().isEmpty());
		Assert.assertFalse(atp.StateValue().isEmpty());
		Assert.assertFalse(atp.ZipValue().isEmpty());
		Assert.assertFalse(atp.PhoneNumberValue().isEmpty());
		Assert.assertFalse(atp.FaxNumberValue().isEmpty());
		Assert.assertFalse(atp.NPIValue().isEmpty());
		Assert.assertFalse(atp.ProviderIDValue().isEmpty());
		
		Assert.assertFalse(atp.SelectBillingProviderDropdown().isDisplayed());
		Assert.assertFalse(atp.BillingName().isDisplayed());
		Assert.assertFalse(atp.BillingContactLastName().isDisplayed());
		Assert.assertFalse(atp.BillingNPI().isDisplayed());
		
		//reporting
		if(!atp.BillingNameValue().isEmpty())
		{
			TestBase.classAInstance.logReport("Pass","BO reset search in treatments tab for a patient","Succesfully able to  Verify BO reset search in treatments tab for a patient");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","BO reset search in treatments tab for a patient","Failed able to  Verify BO reset search in treatments tab for a patient");
		}
		
		//Now click on Reset Search button
		atp.BOResetSearchButton().click();
		
		Assert.assertTrue(atp.SelectBillingProviderDropdown().isDisplayed());
		Assert.assertTrue(atp.BillingName().isDisplayed());
		Assert.assertTrue(atp.BillingContactLastName().isDisplayed());
		Assert.assertTrue(atp.BillingNPI().isDisplayed());
		
		//reporting
		if(atp.SelectBillingProviderDropdown().isDisplayed())
		{
			TestBase.classAInstance.logReport("Pass","BO reset search in treatments tab for a patient","Succesfully able to  Verify BO reset search in treatments tab for a patient");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","BO reset search in treatments tab for a patient","Failed able to  Verify BO reset search in treatments tab for a patient");
		}		
		
		AdminPortalLogout();
		
	}
	

}