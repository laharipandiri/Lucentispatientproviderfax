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
import com.juno.qa.getandsetTestData.Patients_FaxInfoTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_FaxInfoTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC19_AdminPortal_Patients_VerifyFaxInfoTabPage extends AdminPortalLoginLogoutPage {

	Patients_FaxInfoTab dat = new Patients_FaxInfoTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_FaxInfoTabPage aft = new AdminPortal_Patients_FaxInfoTabPage();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	
	String Key = "PatientFaxInfoTabGridCols";
	String Key1 = "FaxInfoLinksTestData";
	String Key2 = "PatientFaxInfoTabGridColsForAdminReimbursement";
	String Key3 = "FaxInfoLinksTestDataForAdminReimbursement";
	String Key4 = "SmokePatientEnrollment";
	
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
	@Test ( description = "verify the FaxInfo page content ")
	public void VerifyFaxInfoPageContent_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum1 = etd.getKeyValuePair(Key4);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key4, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
		
		
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientsFaxInfoTabGridCols(Key, rowNum);
		
		aft.FaxInfoTab().click();
		
		for(int i=1;i<=aft.FaxInfoGridCols().size();i++)
		{
			if(i<4) {
				Assert.assertEquals(aft.FaxInfoGridColNames(i).getText(), testData.get(i));
			 }	
			 else if(i==4)
			 		{
				 		for(int j=1; j<=aft.NestedFaxInfoGridCols().size(); j++)
				 		{
				 			Assert.assertEquals(aft.NestedFaxInfoGridColNames(j).getText(), testData.get(j+3));
				 		}
			 		}
			 else if(i>4)
			 {
				 Assert.assertEquals(aft.FaxInfoGridColNames(i).getText(), testData.get(i+7));
			 }
		}
		
		//Verify the faxID and Action col links
	
		//Assert.assertTrue(aft.EditAssignLinkFirstRow().isDisplayed());
		
	
		AdminPortalLogout();
		
	} 
	
	@Test ( description = "verify the links in FaxInfoTab ")
	public void VerifyLinksInFaxInfoTab_DrugReimbursement() throws IOException, AWTException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum1 = etd.getKeyValuePair(Key4);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key4, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		int rowNum = etd.getKeyValuePair(Key1);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientsFaxInfoLinksTestData(Key1, rowNum);
		System.out.println("The testData is:" +testData);
		
		aft.FaxInfoTab().click();
		//click on the faxID link and make sure that a new window with the EOB file is opened
		
		
		//Click on edit/assign link in the fax info tab
		//aft.EditAssignLinkFirstRow().click();
		//Assert.assertEquals(driver.getCurrentUrl(), testData.get(1));
		Thread.sleep(2000);
		//reporting
		if(driver.getCurrentUrl().equalsIgnoreCase(testData.get(1)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Links in FaxInfoTab","Succesfully able to  Verify links in FaxInfoTab");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Links in FaxInfoTab","Failed to  Verify links in FaxInfoTab");
	     }
		
		AdminPortalLogout();
		
	}


}
