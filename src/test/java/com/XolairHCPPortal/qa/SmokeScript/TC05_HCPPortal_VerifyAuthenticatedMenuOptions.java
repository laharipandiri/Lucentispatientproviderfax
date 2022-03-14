package com.XolairHCPPortal.qa.SmokeScript;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
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
//Verify using program link after login and before login
@Listeners(TestNGListner.class)
public class TC05_HCPPortal_VerifyAuthenticatedMenuOptions extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	@BeforeMethod
	public void OpenBrowser() throws IOException, AWTException {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {
			TestBase.classAInstance.logReport("Fail", "VerifyAuthenticatedMenuOptions", "VerifyAuthenticatedMenuOptions Failed");
		}
	}

	@Test(description = "Sucessful Login")
	public void ProgramUsing() throws InterruptedException, IOException, AWTException
	{	
		String ExpectedTitle = prop.getProperty("ExpectedHCPPageTitle");
		String title = driver.getTitle();
		Assert.assertEquals(title,ExpectedTitle);

		try {
			eft.HCPLogin();
			UsingProgramAfterLogin();
			//Thread.sleep(5000);
			eft.HCPLogout();
		} catch (Exception e) {
			//TestBase.classAInstance.logReport("Fail", "VerifyAuthenticatedMenuOptions", "VerifyAuthenticatedMenuOptions Failed");
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

	
	public void UsingProgramAfterLogin() throws IOException, AWTException, InterruptedException {
			
		//Smoke excel sheet
		String Key = "VerifyNonAuthenticatedMenuOptions";
	
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetSmokedata(Key, rowNum); 
		System.out.println("testdata is:" +testData);
		
			//Click on Home link
			Home().click();
			Thread.sleep(2000);
			HCPPopUpMsgCloseButton().click();
		
			/*if (HCPWelcomeMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on Home link");
			} else {
				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on Home link");
			}
			Thread.sleep(1000);
			*/
			//Click on Using Program link
			HCPProgramDetailsDropDown().click();
			HCPUsingProgramLink().click();
			Thread.sleep(3000);
			String content1=UsingProgramBody().getText();
			System.out.println("The value in Content1 is:" +content1);
			Thread.sleep(1000);
			// reporting
			if (UsingProgramBody().getText().equalsIgnoreCase(testData.get(1))) {
				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on UsingProgram link");
			} else {
				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on UsingProgram link");
			}
			Thread.sleep(1000);
			
			//Checking for Error
			boolean data1= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			if (data1 == false) {
				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on UsingProgram page");
			} else {
				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed as we see an error in UsingProgram page");
			}
			
			//Click on Offering/Eligibility
			HCPProgramDetailsDropDown().click();
			HCPOfferingEligibility().click();
			Thread.sleep(3000);
			String content2=OfferingEligibilityBody().getText();
			System.out.println("The value in Content2 is:" +content2);
			if (OfferingEligibilityBody().getText().equalsIgnoreCase(testData.get(2))) {
				TestBase.classAInstance.logReport("Pass", "Offering Eligibility page", "Succesfully able click on Offering Eligibility  link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Offering Eligibility  page", "Failed to click on Offering Eligibility  link");
			}
			Thread.sleep(1000);
			
			//Checking for Error
			boolean data2= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			if (data2 == false) {
				TestBase.classAInstance.logReport("Pass", "Offering Eligibility page", "Succesfully able click on Offering Eligibility page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Offering Eligibility page", "Failed as we see an error in Offering Eligibility page");
			}
			
			//Click on Terms And Conditions link
			HCPProgramDetailsDropDown().click();
			HCPTermsAndConditions().click();
			Thread.sleep(3000);
			String content3=TermsAndConditionsBody().getText();
			System.out.println("The value in Content3 is:" +content3);
			Thread.sleep(1000);
			// reporting
			if (TermsAndConditionsBody().getText().equalsIgnoreCase(testData.get(3))) {
				TestBase.classAInstance.logReport("Pass", "Terms And Conditions page", "Succesfully able click on Terms And Conditions  link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Terms And Conditions page", "Failed to click on Terms And Conditions link");
			}
			Thread.sleep(1000);
			
			//Checking for Error
			boolean data3= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			if (data3 == false) {
				TestBase.classAInstance.logReport("Pass", "Terms And Conditions page", "Succesfully able click on Terms And Conditions page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Terms And Conditions page", "Failed as we see an error in Terms And Conditions page");
			}
			
			
			//Click on Forms link
			HCPFormsLink().click();
			String content4=FormsBody().getText();
			System.out.println("The value in Content4 is:" +content4);
			Thread.sleep(3000);
			// reporting
			if (FormsBody().getText().equalsIgnoreCase(testData.get(4))) {
				TestBase.classAInstance.logReport("Pass", "Forms page", "Succesfully able click on Forms link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Forms page", "Failed to click on Forms link");
			}
			//Checking for Error
			boolean data4= driver.getPageSource().contains("An error occurred. Please try again later.");
			System.out.println("Clicked on ProviderProfileLink ");
			Thread.sleep(3000);
			if (data4 == false) {
				TestBase.classAInstance.logReport("Pass", "Forms page", "Succesfully able click on Forms link page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Forms page", "Failed as we see an error in Forms link page");
			}
	
			//Click on Provider Profile link
			Thread.sleep(3000);
			ProviderProfileLink().click();
			System.out.println("Clicked on ProviderProfileLink ");
			Thread.sleep(3000);
			String content5=ProviderProfileBody().getText();
			System.out.println("The value in Content5 is:" +content5);
			Thread.sleep(3000);
			// reporting
			if (ProviderProfileBody().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Provider Profile page", "Succesfully able click on Provider Profile link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Provider Profile page", "Failed to click on Provider Profile link");
			}
			
			//Checking for Error
			boolean data5= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			if (data5 == false) {
				TestBase.classAInstance.logReport("Pass", "Provider Profile page", "Succesfully able click on Provider Profile page");
			} else {
				TestBase.classAInstance.logReport("Fail", "Provider Profile page", "Failed as we see an error in Provider Profile page");
			}
	
			//Click on Patient->Enroll a patient link
			PatientsLink().click();
			System.out.println("Clicked on Patient link");
			Thread.sleep(1000);
			EnrollLink().click();
			System.out.println("Clicked on Enroll link");
			Thread.sleep(1000);
			String content6=EnrollBodyPatient().getText();
			System.out.println("The value in Content6 is:" +content6);
			Thread.sleep(3000);
			// reporting
			if (EnrollBodyPatient().getText().equalsIgnoreCase(testData.get(5))) {
				TestBase.classAInstance.logReport("Pass", "Enroll page", "Succesfully able click on Enroll link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Enroll page", "Failed to click on Enroll link");
			}
			
			//Checking for Error
			boolean data6= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			if (data6 == false) {
				TestBase.classAInstance.logReport("Pass", "Enroll page", "Succesfully able click on Enroll link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Enroll page", "Failed as we see an error in Enroll link page");
			}
			
			
			//Click on Patient->patient Search link
			PatientsLink().click();
			Thread.sleep(1000);
			HCPPatientSearchLink().click();
			Thread.sleep(1000);
			String content7=PatientSearchBody().getText();
			System.out.println("The value in Content7 is:" +content7);
			Thread.sleep(3000);
			// reporting
			if (PatientSearchBody().getText().equalsIgnoreCase(testData.get(6))) {
				TestBase.classAInstance.logReport("Pass", "Patient Search page", "Succesfully able click on Patient Search link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search page", "Failed to click on Patient Search link");
			}
			
			boolean data7= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			// reporting
			if (data7 == false) {
				TestBase.classAInstance.logReport("Pass", "Patient Search page", "Succesfully able click on Patient Search link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Search page", "Failed as we see an error in Patient Search page");
			}
			
			
			//Click on Reports link EFT
			ReportsLink().click();
			Thread.sleep(1000);
			PaymentReportLink().click();
			Thread.sleep(3000);
			if (PaymentReportBody().isDisplayed()==true) {
				TestBase.classAInstance.logReport("Pass", "Payment Report page", "Succesfully able click on Payment Report link");
			} else {
				TestBase.classAInstance.logReport("Fail", "Payment Report page", "Failed to click on Payment Report link");
			}
			boolean data8= driver.getPageSource().contains("An error occurred. Please try again later.");
			Thread.sleep(3000);
			// reporting
			if (data8 == false) {
				TestBase.classAInstance.logReport("Pass", "EFT Check page", "Succesfully able click on EFT Check link-15");
			} else {
				TestBase.classAInstance.logReport("Fail", "EFT Check page", "Failed as we see an error in EFT page-15");
			}
	}
	
	
	

}
