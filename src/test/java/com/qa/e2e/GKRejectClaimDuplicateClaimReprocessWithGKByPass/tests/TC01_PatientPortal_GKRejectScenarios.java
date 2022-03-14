package com.qa.e2e.GKRejectClaimDuplicateClaimReprocessWithGKByPass.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
//this test case writes in smoke sheet
@Listeners(TestNGListner.class)
public class TC01_PatientPortal_GKRejectScenarios extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializePatientDriverPopUp();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException

	{

		// String ExpectedTitle = prop.getProperty("ExpectedHubPageTitle");
		String title = driver.getTitle();
		// Assert.assertEquals(title,ExpectedTitle);

		
		
		try {
//			eft.PatientPopUpVerification();
			eft.e2eCTPLucentisEnrollmentPatient();
		} catch (Exception e) {

		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "E2E CTP Lucentis Enrollment Patient", "Succesfully enrolled a patient");
			} else {
			TestBase.classAInstance.logReport("Fail", "E2E CTP Lucentis Enrollment Patient", "Failed to enrolled a patient");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	

}
