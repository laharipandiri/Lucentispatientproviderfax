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
//verify using program body(excel),Offer&eligibality body(excel),term & condition body(excel), form body(excel) 

@Listeners(TestNGListner.class)
public class TC04_HCPPortal_VerifyNonAuthenticatedMenuOptions extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	String pwd = prop.getProperty("HCPpassword").trim();
	String tit = prop.getProperty("ExpectedHCPPageTitle");

	@BeforeMethod
	public void OpenBrowser() throws IOException, AWTException {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {
			
		}
	}

	@Test(description = "Sucessful Login")
	public void ProgramUsing() throws InterruptedException, IOException, AWTException
	{	
		String ExpectedTitle = prop.getProperty("ExpectedHCPPageTitle");
		String title = driver.getTitle();
		Assert.assertEquals(title,ExpectedTitle);

		try {
			UsingProgram();
			//Thread.sleep(5000);
			eft.HCPLogout();
		} catch (Exception e) {
			//TestBase.classAInstance.logReport("Fail", "VerifyNonAuthenticatedMenuOptions", "VerifyNonAuthenticatedMenuOptions Failed");	
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

	
	public void UsingProgram() throws IOException, AWTException, InterruptedException {
		
try {
	
			//Smoke excel sheet
			String Key = "VerifyNonAuthenticatedMenuOptions";
		
			System.out.println("The Key is:" +Key);
			int rowNum = etd.getKeyValuePair(Key);
			System.out.println("The rowNum is:" +rowNum);
			List<String> testData = new ArrayList<String>();
			testData = gst.GetSmokedata(Key, rowNum); 
		System.out.println("testdata is:" +testData);
	
			
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
		
//			//Click on Home link
//			Assert.assertTrue(Home().isDisplayed());
//			Home().click();
//			Thread.sleep(2000);
//			Assert.assertTrue(HCPWelcomeMessage().isDisplayed());
//			if (HCPWelcomeMessage().isDisplayed()== true) {
//				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on Home link");
//			} else {
//				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on Home link");
//			}
//			Thread.sleep(1000);
			
			//Click on Using Program link
			Assert.assertTrue(HCPProgramDetailsDropDown().isDisplayed());
			HCPProgramDetailsDropDown().click();
			
			System.out.println("ProgramDetailsDropDown");
			HCPUsingProgramLink().click();
			Thread.sleep(3000);
			String content1=UsingProgramBody().getText();
			System.out.println("The value in Content1 is:" +content1);
			System.out.println("$$$$$" +testData.get(1));
			Thread.sleep(1000);
			// reporting
			if (UsingProgramBody().getText().equalsIgnoreCase(testData.get(1))) {
				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on UsingProgram link");
			} else {
				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on UsingProgram link");
			}
			Thread.sleep(1000);
			
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
			Thread.sleep(4000);
			
			
			//Click on Forms link
			Assert.assertTrue(HCPFormsLink().isEnabled());
			HCPFormsLink().click();
			Assert.assertTrue(FormsBody().isDisplayed());
			String content4=FormsBody().getText();
			System.out.println("The value in Content4 is:" +content4);
			Thread.sleep(3000);
			// reporting
			if (FormsBody().getText().equalsIgnoreCase(testData.get(4))) {
				TestBase.classAInstance.logReport("Pass", "Forms page", "Succesfully able click on Forms link-5");
			} else {
				TestBase.classAInstance.logReport("Fail", "Forms page", "Failed to click on Forms link-5");
			}
} catch (Exception e) {
	TestBase.classAInstance.logReport("Fail", "VerifyNonAuthenticatedMenuOptions", "VerifyNonAuthenticatedMenuOptions Failed");
}
	}
	
	public void UsingProgramAfterLogin() throws IOException, AWTException {
		ProgramDetailsDropDown().click();
		UsingProgramLink().click();
		boolean content=UsingProgramBody().isDisplayed();
		String content2=UsingProgramBody().getText();
		System.out.println("The value in Content is ###############:" +content2);
		// reporting
		if (content= true) {
			TestBase.classAInstance.logReport("Pass", "UsingProgram page after logout", "Succesfully able click on UsingProgram link");
		} else {
			TestBase.classAInstance.logReport("Fail", "UsingProgram page  after logout", "Failed to click on UsingProgram link");
		}


}
}