package com.XolairHCPPortal.qa.SmokeScript;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import com.juno.qa.pages.HubPortal_SearchPatient;

@Listeners(TestNGListner.class)
public class TC07_HCPPortal_VerifyPatientReviewpage extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	HubPortal_SearchPatient abc=new HubPortal_SearchPatient();
	@BeforeMethod
	public void OpenBrowser() throws IOException, AWTException {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {
			//TestBase.classAInstance.logReport("Fail", "VerifyPatientReviewpage", "VerifyPatientReviewpage Failed");
		}
	}

	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{
	try {

		// String ExpectedTitle = prop.getProperty("ExpectedHubPageTitle");
		String title = driver.getTitle();
		// Assert.assertEquals(title,ExpectedTitle);

		
			eft.HCPLogin();
			Thread.sleep(3000);
			abc.PateintSearchButton().click();
			Thread.sleep(9000);
			abc.PateintSearchFirstReview().click();
			Thread.sleep(5000);
			Assert.assertTrue(abc.PateintSearchPatientsTabLandingMessage().isDisplayed());
			if (abc.PateintSearchPatientsTabLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search-Patient tab", "Succesfully able verify Patient tab in Patient search page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search-Patient tab", "Failed to verify Patient tab in Patient search page");
			}
			System.out.println("Assert");
			Assert.assertTrue(abc.PateintSearchClaimsTab().isDisplayed());
			System.out.println("PateintSearchClaimsTab");
			abc.PateintSearchClaimsTab().click();
			System.out.println("Clicked on Claims");
			Thread.sleep(1000);
			Assert.assertTrue(abc.PateintSearchClaimsTabLandingMessage().isDisplayed());
			if (abc.PateintSearchClaimsTabLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search-Claims tab", "Succesfully able verify Claims tab in Patient search page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search-Claims tab", "Failed to verify Claims tab in Patient search page");
			}
			Assert.assertTrue(abc.PateintSearchCommunicationTab().isDisplayed());
			abc.PateintSearchCommunicationTab().click();
			System.out.println("Clicked on Communication");
			Thread.sleep(1000);
			Assert.assertTrue(abc.PateintSearchCommunicationTabLandingMessage().isDisplayed());
			if (abc.PateintSearchCommunicationTabLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search-Communication tab", "Succesfully able verify Communication tab in Patient search page-3");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search-Communication tab", "Failed to verify Communication tab in Patient search page-3");
			}
	}
	catch(InterruptedException e) {
		TestBase.classAInstance.logReport("Fail", "VerifyPatientReviewpage", "VerifyPatientReviewpage Failed");
	}
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP Patient Search-Patient tab", "Succesfully verified Patient Search-Patient tabs");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP Patient Search-Patient tab", "Failed to verified Patient Search-Patient tab");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	

}
