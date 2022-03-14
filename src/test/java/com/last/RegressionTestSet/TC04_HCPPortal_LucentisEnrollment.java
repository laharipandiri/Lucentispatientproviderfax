package com.last.RegressionTestSet;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;

@Listeners(TestNGListner.class)
public class TC04_HCPPortal_LucentisEnrollment extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	
	

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	@Test(description = "HCPEnrollment")
	public void HCPEnrollment() throws InterruptedException, IOException, AWTException

	{ try {
				eft.HCPLogin();
				PatientsLink().click();
				Thread.sleep(1000);
				EnrollLink().click();
				Thread.sleep(3000);
				eft.LucentisEnrollInAdminPortal();
			
		} catch (Exception e) {

		}

	}

	private String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Lucentis HCP Enrollment", "Succesfully enrolled a patient in HCP Lucentis drug");
			} else {
			TestBase.classAInstance.logReport("Fail", "Lucentis HCP Enrollment", "Failed to enrolled a patient in HCP Lucentis drug");
			}
		//closeBrowser();
		TestBase.classAInstance.endReport();
	}
	

}
