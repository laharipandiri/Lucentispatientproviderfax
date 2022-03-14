package com.qa.e2e.LapEnrollment.test;

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
public class New_TC01_PatientPortal_LAPLucentisEnrollment extends HubHomeLoginLogoutPage {

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

	@Test(description = "Lucentis Login")
	public void LapEnrollment() throws InterruptedException

	{
		String title = driver.getTitle();
	
	try {
//			eft.PatientPopUpVerification();
			eft.LAPLucentisEnrollmentPatient();
			} catch (Exception e) {

		}

	}
	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Lap Enrollment", "Succesfully Lap Enrollment");
			} else {
			TestBase.classAInstance.logReport("Fail", "Lap Enrollment", "Failed to Lap Enrollment");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	

}
