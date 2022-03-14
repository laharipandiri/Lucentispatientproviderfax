package com.XolairPatientPortal.qa.SmokeScript;

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
public class TC02_PatientPortal_VerifyHomePageContent extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();

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
		String title = driver.getTitle();
		
		try {
			UsingProgram();
			eft.PatientLoginPageContent();
		} catch (Exception e) {

		}

	}

	@AfterMethod
	public void CloseBrowser() {
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	public void UsingProgram() throws IOException, AWTException, InterruptedException {
		
		/*PatientPopUpMsgOKButton().click();
		Thread.sleep(2000);
		
		
		//Click on Home link
		//Home().click();
		Thread.sleep(2000);
		
		if (ApplyNowButton().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the Enroll Now Button");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the Enroll Now Button");
		}
		*/
		System.out.println("ApplyNowButton");
		//Enroll
	//	Assert.assertTrue(ApplyNowButton().isDisplayed());
		ApplyNowButton().click();
		System.out.println("Clicked on ENroll");
		Thread.sleep(2000);
		if (EnrollBodyPatient().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Enroll page", "Succesfully able click on Enroll link-2");
		} else {
			TestBase.classAInstance.logReport("Fail", "Enroll page", "Failed to click on Enroll link-2");
		}
		
		//My Account
		Assert.assertTrue(MyAccountButton().isDisplayed());
		MyAccountButton().click();
		System.out.println("Clicked on MyAccountButton");
		//PatientPopUpMsgOKButton().click(); //Pop up message comes back
		System.out.println("Clicked on Patient PopUp Msg OK Button");
		Thread.sleep(2000);
		
		Assert.assertTrue(HCPWelcomeMessage().isDisplayed());
		if (HCPWelcomeMessage().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on Home link-3");
		} else {
			TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on Home link");
		}
		
		//Click on Offering/Eligibility
				Thread.sleep(3000);
				Assert.assertTrue(ProgramDetailsDropDown().isDisplayed());
				System.out.println("ProgramDetailsDropDown");
				Thread.sleep(1000);
				ProgramDetailsDropDown().click();
				Assert.assertTrue(OfferingEligibility().isDisplayed());
				OfferingEligibility().click();
				System.out.println("Clicked on Offering Eligibility");
				Thread.sleep(3000);
				String content2=OfferingEligibilityPatientBody().getText();
				System.out.println("The value in Content2 is:" +content2);
				if (OfferingEligibilityPatientBody().isDisplayed()== true) {
					TestBase.classAInstance.logReport("Pass", "Offering Eligibility page", "Succesfully able click on Offering Eligibility  link-4");
				} else {
					TestBase.classAInstance.logReport("Fail", "Offering Eligibility  page", "Failed to click on Offering Eligibility  link");
				}
				Thread.sleep(3000);
				
		
		//Click on Using Program link
		Assert.assertTrue(ProgramDetailsDropDown().isDisplayed());
		ProgramDetailsDropDown().click();
		Assert.assertTrue(UsingProgramLink().isDisplayed());
		UsingProgramLink().click();
		System.out.println("Clicked on Using Program Link");
		Thread.sleep(3000);
		String content1=UsingProgramPatientBody().getText();
		System.out.println("The value in Content1 is:" +content1);
		Thread.sleep(1000);
		// reporting
		if (UsingProgramPatientBody().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on UsingProgram link-5");
		} else {
			TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed to click on UsingProgram link");
		}
		Thread.sleep(1000);
		
		
		//Click on Terms And Conditions link
		ProgramDetailsDropDown().click();
		Thread.sleep(1000);
		TermsAndConditions().click();
		Thread.sleep(3000);
		String content3=TermsAndConditionsBody().getText();
		System.out.println("The value in Content3 is:" +content3);
		Thread.sleep(1000);
		// reporting
		if (TermsAndConditionsBody().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Terms And Conditions page", "Succesfully able click on Terms And Conditions  link-6");
		} else {
			TestBase.classAInstance.logReport("Fail", "Terms And Conditions page", "Failed to click on Terms And Conditions link");
		}
		Thread.sleep(1000);
		
		
		//Click on Forms link
		FormsLink().click();
		String content4=FormsBody().getText();
		System.out.println("The value in Content4 is:" +content4);
		Thread.sleep(3000);
		// reporting
		if (FormsBody().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Forms page", "Succesfully able click on Forms link-7");
		} else {
			TestBase.classAInstance.logReport("Fail", "Forms page", "Failed to click on Forms link");
		}

		//Click on Home link
		Home().click();
		Thread.sleep(2000);
		PatientPopUpMsgOKButton().click();
		
		
		
		
		
}


}
