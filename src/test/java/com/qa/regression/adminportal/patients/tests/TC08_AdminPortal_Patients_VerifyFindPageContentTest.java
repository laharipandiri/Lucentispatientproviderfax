package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
import com.juno.qa.getandsetTestData.Patients_Find;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC08_AdminPortal_Patients_VerifyFindPageContentTest extends AdminPortalLoginLogoutPage {

	Patients_Find dat = new Patients_Find();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage acp = new AdminPortalPatientsPage();
	AdminPortal_Patients_FindPage pfp = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_PatientAndCardTabPage app = new AdminPortal_Patients_PatientAndCardTabPage();
	HubHomeLoginLogoutPage hlp = new HubHomeLoginLogoutPage();
	HubHomePage hhp=new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	CommonFunctions cf = new CommonFunctions();
	
	String Key = "FindPageFields";
	String Key1 = "PatientsFindPageSearchgridCols";
	

	@BeforeMethod
	public void OpenBrowser() {
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
	
	@Test ( description = "Verify Patients-->Find page content")
	public void VerifyPatientsFindPageContent() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(alp.AdminPortalLogoutButton()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientsFindFieldDropdownDefaultValues(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		List<String> searchGridCols = new ArrayList<String>();
		searchGridCols = dat.GetPatientsFindPageSearchgridCols(Key1, rowNum1);
		
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		acp.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		
		Assert.assertEquals(pfp.PatientsFindPageProgramDropDown().getFirstSelectedOption().getText(), testData.get(1));
		
		Assert.assertTrue(pfp.PatientsFindPagePatientLastName().isDisplayed());
		//Assert.assertTrue(pfp.PatientsFindPageMemberID().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPageCardID().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPageEnrollDateFrom().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPageConfirmationID().isDisplayed());
		//Assert.assertTrue(pfp.PatientsFindPageProviderName().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPagePartnerPatientID().isDisplayed());
	//	Assert.assertTrue(pfp.PatientsFindPageMasterCardNum().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPageCity().isDisplayed());
		Assert.assertTrue(pfp.PatientsFindPageEnrollDateTo().isDisplayed());
		Assert.assertTrue(pfp.PatientsPageFindButton().isDisplayed());
		Assert.assertEquals(pfp.PatientsFindPagePatientStatusDropDown().getFirstSelectedOption().getText(), testData.get(2));
		Assert.assertEquals(pfp.PatientsFindPageResidingStateDropDown().getFirstSelectedOption().getText(), testData.get(3));
		Assert.assertEquals(pfp.PatientsFindPageActivationTypeDropDown().getFirstSelectedOption().getText(), testData.get(4));
		//Assert.assertEquals(pfp.PatientsFindPageProviderTypeDropDown().getFirstSelectedOption().getText(), testData.get(5));
		
		//verify the search grid cols
		for(int i=1; i<=pfp.PatientsFindPageSearchResultGridCols().size(); i++)
		{
			Assert.assertEquals(pfp.PatientsFindPageSearchResultGridColNames(i).getText(), searchGridCols.get(i));
		}
		
		//reporting
		if(pfp.PatientsFindPageSearchResultGridCols().isEmpty())
	     {
	    	TestBase.classAInstance.logReport("Pass","Patients-->Find page content","Succesfully able to  Verify Patients-->Find page content");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Patients-->Find page content","Failed to  Verify Patients-->Find page content");
	     }
		
		AdminPortalLogout();
	}		

}
