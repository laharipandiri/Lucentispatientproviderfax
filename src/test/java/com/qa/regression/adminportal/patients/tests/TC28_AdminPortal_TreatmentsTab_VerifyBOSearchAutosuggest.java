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
public class TC28_AdminPortal_TreatmentsTab_VerifyBOSearchAutosuggest extends AdminPortalLoginLogoutPage {

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

	
	@Test ( description = "Verify the BO name search in treatments tab for a patient")
	public void VerifyBONameSearchInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetProviderSearchesTestData(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(50000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		//Verify BO searches
		atp.BillingName().sendKeys(testData.get(0));
		Thread.sleep(2000);
		Assert.assertTrue(atp.SearchDisplayBox().isDisplayed());
		
		//reporting
		if(atp.SearchDisplayBox().isDisplayed())
	     {
	    	TestBase.classAInstance.logReport("Pass","Auto suggest search displayed for Billing Name","Succesfully able to  Verify Auto suggest search displayed for Billing Name");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Auto suggest search displayed for Billing Name","Failed to  Verify Auto suggest search displayed for Billing Name");
	     }
		
		//Now click on auto suggest search
		atp.SearchDisplayBox().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(atp.BillingNameValue(), testData.get(32));
		Assert.assertEquals(atp.ContactFirstNameValue(), testData.get(7));
		Assert.assertEquals(atp.ContactLastNameValue(), testData.get(1));
		//Assert.assertEquals(atp.AddressValue(), testData.get(8));
		Assert.assertEquals(atp.CityValue(), testData.get(9));
		Assert.assertEquals(atp.StateValue(), testData.get(10));
		Assert.assertEquals(atp.ZipValue(), testData.get(11));
		//Assert.assertEquals(atp.PhoneNumberValue(), testData.get(12));
		//Assert.assertEquals(atp.FaxNumberValue(), testData.get(13));
		Assert.assertEquals(atp.NPIValue(), testData.get(2));
		//Assert.assertEquals(atp.ProviderIDValue(), testData.get(14));
		
		//reporting
	//	if(atp.BillingNameValue().equalsIgnoreCase(testData.get(32)))
			if(atp.ContactLastNameValue().equalsIgnoreCase(testData.get(1)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Billing Office Values","Succesfully able to  Verify Billing Office Values");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Billing Office Values","Failed to  Verify Billing Office Values");
	     }
		
		AdminPortalLogout();
	}		

	
	@Test ( description = "Verify the BO last name search in treatments tab for a patient")
	public void VerifyBOLastNameSearchInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetProviderSearchesTestData(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(40000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		//Verify BO searches
		atp.BillingContactLastName().sendKeys(testData.get(1));
		Thread.sleep(2000);
		Assert.assertTrue(atp.SearchDisplayBox().isDisplayed());
		
		//reporting
		if(atp.SearchDisplayBox().isDisplayed())
	     {
	    	TestBase.classAInstance.logReport("Pass","Auto suggest search displayed for Billing contact last Name","Succesfully able to  Verify Auto suggest search displayed for Billing contact last Name");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Auto suggest search displayed for Billing contact last Name","Failed to  Verify Auto suggest search displayed for Billing contact last Name");
	     }
		
		//Now click on auto suggest search
		atp.SearchDisplayBox().click();
		Thread.sleep(2000);
		
		//Assert.assertEquals(atp.BillingNameValue(), testData.get(32));
		//Assert.assertEquals(atp.ContactFirstNameValue(), testData.get(7));
		Assert.assertEquals(atp.ContactLastNameValue(), testData.get(1));
		//Assert.assertEquals(atp.AddressValue(), testData.get(8));
//		Assert.assertEquals(atp.CityValue(), testData.get(9));
//		Assert.assertEquals(atp.StateValue(), testData.get(10));
//		Assert.assertEquals(atp.ZipValue(), testData.get(11));
		//Assert.assertEquals(atp.PhoneNumberValue(), testData.get(12));
		//Assert.assertEquals(atp.FaxNumberValue(), testData.get(13));
//		Assert.assertEquals(atp.NPIValue(), testData.get(2));
		//Assert.assertEquals(atp.ProviderIDValue(), testData.get(14));
		
		//reporting
	//	if(atp.BillingNameValue().equalsIgnoreCase(testData.get(32)))
		if(atp.ContactLastNameValue().equalsIgnoreCase(testData.get(1)))		
	     {
	    	TestBase.classAInstance.logReport("Pass","Billing Office Values","Succesfully able to  Verify Billing Office Values");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Billing Office Values","Failed to  Verify Billing Office Values");
	     }
		
		AdminPortalLogout();
	}		
	
	
	@Test ( description = "Verify the BO NPI search in treatments tab for a patient")
	public void VerifyBONPISearchInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetProviderSearchesTestData(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(40000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		//Verify BO searches
		atp.BillingNPI().sendKeys(testData.get(2));
		Thread.sleep(2000);
		Assert.assertTrue(atp.SearchDisplayBox().isDisplayed());
		
		//reporting
		if(atp.SearchDisplayBox().isDisplayed())
	     {
	    	TestBase.classAInstance.logReport("Pass","Auto suggest search displayed for Billing NPI","Succesfully able to  Verify Auto suggest search displayed for Billing NPI");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Auto suggest search displayed for Billing NPI","Failed to  Verify Auto suggest search displayed for Billing NPI");
	     }
		
		//Now click on auto suggest search
		atp.SearchDisplayBox().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(atp.BillingNameValue(), testData.get(32));
		Assert.assertEquals(atp.ContactFirstNameValue(), testData.get(7));
		Assert.assertEquals(atp.ContactLastNameValue(), testData.get(1));
		//Assert.assertEquals(atp.AddressValue(), testData.get(8));
		Assert.assertEquals(atp.CityValue(), testData.get(9));
		Assert.assertEquals(atp.StateValue(), testData.get(10));
		Assert.assertEquals(atp.ZipValue(), testData.get(11));
		//Assert.assertEquals(atp.PhoneNumberValue(), testData.get(12));
		//Assert.assertEquals(atp.FaxNumberValue(), testData.get(13));
		Assert.assertEquals(atp.NPIValue(), testData.get(2));
		//Assert.assertEquals(atp.ProviderIDValue(), testData.get(14));
		
		//reporting
		//if(atp.BillingNameValue().equalsIgnoreCase(testData.get(32)))
		if(atp.ContactLastNameValue().equalsIgnoreCase(testData.get(1)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Billing Office Values","Succesfully able to  Verify Billing Office Values");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Billing Office Values","Failed to  Verify Billing Office Values");
	     }
		
		AdminPortalLogout();
	}		

	
	

}
