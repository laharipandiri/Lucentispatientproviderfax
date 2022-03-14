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
public class TC06_HCPPortal_VerifyPatientSearchPage extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	HubPortal_SearchPatient abc=new HubPortal_SearchPatient();
	@BeforeMethod
	public void OpenBrowser() throws IOException, AWTException {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {
	TestBase.classAInstance.logReport("Fail", "VerifyPatientSearchPag", "VerifyPatientSearchPag Failed");
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
			Thread.sleep(3000);
			
			//Verify the Logo
			if (LoginLogo().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify the logo");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify the logo");
			}
			//Verify the Indications and Important Safety Information link
			if (IAndILink().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Indications and Important Safety Information");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Indications and Important Safety Information");
			}
			//Verify the Prescribing Information link
			if (PrescribingInfoLink().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Prescribing Information");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Prescribing Information");
			}
			
			//Verify the welcome message on Patient search screen
			System.out.println(PatientSearchWelcomeMessage().getText());
			String msg="Enter one or more criteria to search your patients. “First Name” and “Last Name” provides partial text search.";
			if (PatientSearchWelcomeMessage().getText().equalsIgnoreCase(msg)) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Prescribing Information-3");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Prescribing Information");
			}
			
			Thread.sleep(3000);
			System.out.println("clicked on search button");
			abc.PateintSearchButton().click();
			Thread.sleep(10000);
			System.out.println("clicked on search button");
			abc.PateintSearchOpenPatient().click();
			
			//Patient Profile Details
			
			Assert.assertNotNull(abc.PateintSearchFullName()); //Full name
			Assert.assertNotNull(abc.PateintSearchGender());  //Gender
			Assert.assertNotNull(abc.PateintSearchDOB());  //BOD
			Assert.assertNotNull(abc.PateintSearchAddress());  //Address
			Assert.assertNotNull(abc.PateintSearchPhoneNumber());  //Phone Number
			Assert.assertNotNull(abc.PateintSearchDOB());  //BOD
			System.out.println("Patient Profile Details");
			
			//Membership Information
			Assert.assertNotNull(abc.PateintSearchBIN()); //BIN
			Assert.assertNotNull(abc.PateintSearchPCN());  //PCN
			Assert.assertNotNull(abc.PateintSearchGroup());  // Group
			Assert.assertNotNull(abc.PateintSearchMember());  //Member ID
			System.out.println("Membership Information");
			
			//Commercial Medical Insurance Information
			Assert.assertNotNull(abc.PateintSearchCompanyName()); //Company Name
			Assert.assertNotNull(abc.PateintSearchPlanType());  //Plan Type
			Assert.assertNotNull(abc.PateintSearchGroupNumber());  //Group Number
			Assert.assertNotNull(abc.PateintSearchMemberNumber());  //Member Number
			Assert.assertNotNull(abc.PateintSearchEffectiveDate());  //EffectiveDate
			Assert.assertNotNull(abc.PateintSearchBIN2());  //BIN
			Assert.assertNotNull(abc.PateintSearchPCN2());  //PCN
			System.out.println("Commercial Medical Insurance Information");
			
			
			
			
			
			
			
			
			
		/*	
			String rrr=PatientSearchPagination().getText();
			System.out.println("got text from Pagination");
			System.out.println("rrr" +rrr);
			PatientSearchPagination().click();
			System.out.println("Click on Pagination 20");
			Thread.sleep(10000);
			if (PatientSearchPaginationSelection20().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Pagination for 20");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Pagination for 20");
			}
			PatientSearchPaginationSelection20().click();
			Thread.sleep(2000);
			
			
			
			PatientSearchPagination().click();
			System.out.println("Click on Pagination 50");
			if (PatientSearchPaginationSelection50().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Pagination for 50");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Pagination for 50");
			}
			PatientSearchPaginationSelection50().click();
			Thread.sleep(2000);
			
			
			
			
			PatientSearchPagination().click();
			System.out.println("Click on Pagination 100");
			if (PatientSearchPaginationSelection100().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Search Screen", "Succesfully able to Verify Pagination for 100-7");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search Screen", "Failed to Verify Pagination for 100-7");
			}
			PatientSearchPaginationSelection100().click();
			Thread.sleep(2000);
			*/
			
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "VerifyPatientSearchPag", "VerifyPatientSearchPag Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP VerifyNonAuthenticatedMenuOptions", "Succesfully verified HCP VerifyNonAuthenticatedMenuOptions");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP VerifyNonAuthenticatedMenuOptions", "Failed to verified HCP VerifyNonAuthenticatedMenuOptions");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	

}
