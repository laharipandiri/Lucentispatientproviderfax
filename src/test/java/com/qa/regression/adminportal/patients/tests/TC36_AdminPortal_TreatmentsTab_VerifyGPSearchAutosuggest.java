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
public class TC36_AdminPortal_TreatmentsTab_VerifyGPSearchAutosuggest extends AdminPortalLoginLogoutPage {
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	String Key = "ProviderSearchesInTreatments";
	

	
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
	
	@Test ( description = "Verify the GP name search in treatments tab for a patient")
	public void VerifyGPNameSearchInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetProviderSearchesTestData(Key, rowNum);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		//wait.until(ExpectedConditions.visibilityOf(atp.PracticeName()));
		Thread.sleep(15000);
		
		//Verify BO searches
		atp.PracticeName().sendKeys(testData.get(3));
		Thread.sleep(2000);
		Assert.assertTrue(atp.SearchDisplayBox().isDisplayed());
		
		//Now click on auto suggest search
		atp.SearchDisplayBox().click();
		
		Assert.assertEquals(atp.TreatingPracticeNameValue(), testData.get(15));
		Assert.assertEquals(atp.TreatingAddressValue(), testData.get(16));
		Assert.assertEquals(atp.TreatingCityValue(), testData.get(17));
		Assert.assertEquals(atp.TreatingStateValue(), testData.get(18));
		Assert.assertEquals(atp.TreatingZipValue().substring(0, 5), testData.get(19));
		Assert.assertEquals(atp.TreatingPhoneNumberValue(), testData.get(20));
		Assert.assertEquals(atp.TreatingFaxNumberValue(), testData.get(21));
		Assert.assertEquals(atp.TreatingTaxNumberValue(), testData.get(22));
		Assert.assertEquals(atp.TreatingNPIValue(), testData.get(4));
		Assert.assertEquals(atp.TreatingProviderIDValue(), testData.get(23));
		
		AdminPortalLogout();
	}		
	
	@Test ( description = "Verify the GP NPI search in treatments tab for a patient")
	public void VerifyBONPISearchInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetProviderSearchesTestData(Key, rowNum);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(15000);
		
		//Verify BO searches
		atp.TreatingNPI().sendKeys(testData.get(4));
		Thread.sleep(2000);
		Assert.assertTrue(atp.SearchDisplayBox().isDisplayed());
		
		//Now click on auto suggest search
		atp.SearchDisplayBox().click();
		
		Assert.assertEquals(atp.TreatingPracticeNameValue(), testData.get(15));
		Assert.assertEquals(atp.TreatingAddressValue(), testData.get(16));
		Assert.assertEquals(atp.TreatingCityValue(), testData.get(17));
		Assert.assertEquals(atp.TreatingStateValue(), testData.get(18));
		Assert.assertEquals(atp.TreatingZipValue().substring(0, 5), testData.get(19));
		Assert.assertEquals(atp.TreatingPhoneNumberValue(), testData.get(20));
		Assert.assertEquals(atp.TreatingFaxNumberValue(), testData.get(21));
		Assert.assertEquals(atp.TreatingTaxNumberValue(), testData.get(22));
		Assert.assertEquals(atp.TreatingNPIValue(), testData.get(4));
		Assert.assertEquals(atp.TreatingProviderIDValue(), testData.get(23));
		
		AdminPortalLogout();
	}		

}
