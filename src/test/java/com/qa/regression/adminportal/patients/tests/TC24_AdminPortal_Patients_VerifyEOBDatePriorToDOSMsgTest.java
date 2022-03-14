package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC24_AdminPortal_Patients_VerifyEOBDatePriorToDOSMsgTest extends AdminPortalLoginLogoutPage {
	
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	ExcelTestDataReader etd = new  ExcelTestDataReader();
	CommonFunctions cf =new CommonFunctions();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	
	String Key = "EOBDatePriorToDOSMsg";
	
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
	
	@Test ( description = "Verify EOB Date is prior is to DOS In Treatments Tab")
	public void VerifyEOBDatePriorToDOSMsgTreatmentsTab() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetEOBPriorToDosErrorMsg(Key, rowNum);
		System.out.println("The testdata is:" +testData);
		
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
		cf.SelectDate(testData.get(1));
		
		apt.EOBDate().click();
		cf.SelectDate(testData.get(2));
		Thread.sleep(2000);
		Assert.assertEquals(apt.EOBDatePriorToDOS(), testData.get(0).trim());
		
		//reporting
		
		if(apt.EOBDatePriorToDOS().equalsIgnoreCase(testData.get(0).trim()))
		{
			//scroll down to capture the screenshot at the correct location
	        js.executeScript("window.scrollBy(0,-300)", "");
			TestBase.classAInstance.logReport("Pass","EOB Date is prior is to DOS In Treatments Tab","Succesfully able to  Verify EOB Date is prior is to DOS In Treatments Tab");
	     }
	     else
	     {
	    	//scroll down to capture the screenshot at the correct location
	         js.executeScript("window.scrollBy(0,-300)", "");
	    	TestBase.classAInstance.logReport("Fail","EOB Date is prior is to DOS In Treatments Tab","Failed to  Verify  EOB Date is prior is to DOS In Treatments Tab");
	     }
		
		AdminPortalLogout();
		}		
	
	
	

}
