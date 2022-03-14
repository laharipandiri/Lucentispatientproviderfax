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

//land on Patient portal-
//Click ok on Patient portal pop up msg
//click on HCp portal
//Click ok on HCP portal pop up
//verify your in HCP portal but checking landing message
//click on patient portal & click on OK
//Click on HCP portal and click on Cancle

@Listeners(TestNGListner.class)
public class TC01_HCPPortal_HCPPortal_PopUp extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	//Smoke excel sheet
		String Key = "HCPPortalPopUp";
		

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeHubDriverPopUp();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{    String title = driver.getTitle();
		
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetSmokedata(Key, rowNum); 
		System.out.println("testdata is:" +testData);


		try {
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
			//Patient portal pop up message
			//String abc= PatientPopUpMsg().getText();
			//System.out.println("PatientPopUpMsg is:" +abc);
			if (MyAccountButton().isDisplayed()) {
				TestBase.classAInstance.logReport("Pass", "Patient Portal", "Succesfully in Patient Portal");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Portal", "Failed in Patient Portal");
			}
			/*	
			//Patient paortal pop up messgae OK Button
			PatientPopUpMsgOKButton().click();
			Thread.sleep(1000);
			*/
			//Click on HCP portal Link
			HCPLink().click();
			Thread.sleep(6000);
			PatientPopUpMsgOKButton().click();
			Thread.sleep(2000);
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
			//HCP link error message Verify
			//String abd= HCPPopUpMsgOK().getText();
			//System.out.println("HCPPopUpMsgOK is:" +abd);
			System.out.println("CLicked on HCP Link");
			if ( UserID().isDisplayed()) {
				TestBase.classAInstance.logReport("Pass", "HCP Portal Pop Up Message", "Succesfully verified the pop up message in HCP portal-2");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Portal Pop Up Message", "Failed verified the pop up message in HCP portal");
			}
		
			//HCP link error message click on OK
			/*
			if (UserID().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Succesfully verified the HCP Welcome Message after clicking OK");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the HCP Welcome Message after clicking OK");
			}
			*/
			/*	HCPPopUpMsgCloseButton().click();
			
						
			//HCP portal landing page message
			String afd= HCPWelcomeMessage().getText();
			System.out.println("HCPWelcomeMessage is:" +afd);
			if (HCPWelcomeMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Succesfully verified the HCP Welcome Message after clicking OK");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the HCP Welcome Message after clicking OK");
			}
		*/	
			//Click on patient link- ok- then click on HCP link
			PatientLink().click();
			System.out.println("Clicked on Patient link");
			Thread.sleep(4000);
			/*if ( PatientPopUpMsgOKButton().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Portal Pop Up Message", "Succesfully verified the pop up message in Patient Portal");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Portal Pop Up Message", "Failed verified the pop up message in Patient Portal");
			}
	
			PatientPopUpMsgOKButton().click();
			Thread.sleep(1000);
			HCPLink().click();
			Thread.sleep(1000);
			
			//Click on Cancle on HCP portal pop up message
			if ( HCPPopUpMsgCancle().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP portal Pop Up Message", "Succesfully verified the pop up message in HCP portal before clicking cancle button");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP portal Pop Up Message", "Failed verified the pop up message in HCP portal before clicking cancle button");
			}
			
			HCPPopUpMsgCancle().click();
			Thread.sleep(1000);
			if ( PatientVerificationMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Back to Patient Portal", "Succesfully User is able to go back to Patient portal by clicking on Cancle button-6");
			} else {
				TestBase.classAInstance.logReport("Fail", "Back to Patient Portal", "Failed as User is not able to go back to Patient portal by clicking on Cancle button-6");
			}
			*/			
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "HubLogin", "HubLogin Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP Portal", "Succesfully verified HCP Portal");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP Portal", "Failed to verified HCP Portal");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

}
