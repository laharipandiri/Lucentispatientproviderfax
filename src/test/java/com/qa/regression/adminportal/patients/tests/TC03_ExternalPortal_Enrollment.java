package com.qa.regression.adminportal.patients.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
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

@Listeners(TestNGListner.class)
public class TC03_ExternalPortal_Enrollment extends HubHomeLoginLogoutPage {
	

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
			eft.PatientPopUpVerification();
			eft.EnrollInPateintPortal();
		} catch (Exception e) {

		}

	}

	@AfterMethod
	public void CloseBrowser() {
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	

}
