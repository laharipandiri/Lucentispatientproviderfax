package com.XolairHCPPortal.qa.SmokeScript;

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
// Login and logout of HCP
@Listeners(TestNGListner.class)
public class TC08_HCPPortal_VerifyUserAccount extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{

		// String ExpectedTitle = prop.getProperty("ExpectedHubPageTitle");
		String title = driver.getTitle();
		// Assert.assertEquals(title,ExpectedTitle);

		try {
			eft.HCPLogin();
			eft.HCPUserAccount();
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "VerifyUserAccount", "VerifyUserAccount Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP Logout", "Succesfully verified HCP Logout");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP Logout", "Failed to verified HCP Logout");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	

}
