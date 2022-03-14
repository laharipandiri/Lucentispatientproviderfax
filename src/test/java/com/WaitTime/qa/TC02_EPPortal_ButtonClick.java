package com.WaitTime.qa;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubPortal_SearchPatient;

//verify HCPWelcomeMessage(excel),HCPFooterMessage(excel),error, UserID,Password, submit


@Listeners(TestNGListner.class)
public class TC02_EPPortal_ButtonClick extends HubHomeLoginLogoutPage {

	
	// Patient Portal Page Objects
		String uname = prop.getProperty("HCPusername");
		String pwd = prop.getProperty("HCPpassword").trim();
		String tit = prop.getProperty("ExpectedHCPPageTitle");
		
		
	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	HubPortal_SearchPatient abc=new HubPortal_SearchPatient();


	@BeforeMethod
	public void OpenBrowser() throws IOException, AWTException {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {
		TestBase.classAInstance.logReport("Fail", "LoginTest", "LoginTest Failed");
		}
	}

	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			
			//Smoke excel sheet
			String Key = "HCPLogin";
			
			int rowNum = etd.getKeyValuePair(Key);
			List<String> testData = new ArrayList<String>();
			testData = gst.GetSmokedata(Key, rowNum); 
			System.out.println("testdata is:" +testData);
			
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
					
			UserID().clear();
			UserID().sendKeys(uname);
			
			Password().clear();
			Password().sendKeys(pwd);
				
			// click on submit button
			Instant start = Instant.now();
			System.out.println("Login time started:" +start);
			SubmitButton().click();
			wait.until(ExpectedConditions.visibilityOf(abc.PateintSearchButton()));
			
			//your code
			Instant end = Instant.now();
			System.out.println("Login time ended:" +end);
			Duration timeElapsed = Duration.between(start, end);
			long ayc=timeElapsed.getSeconds();
			System.out.println("Time taken: "+ timeElapsed.getSeconds()+"seconds");
				
			if (abc.PateintSearchButton().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Time took for login Button in seconds :" +ayc );
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the HCP Welcome Message after clicking OK");
			}
			
			
			System.out.println("clicked on Pateint Search Button");
			Instant start1 = Instant.now();
			System.out.println("Login time Pateint Search Button started:" +start);
			abc.PateintSearchButton().click();
						
			boolean load = false;
			while(load == false) {
			   if(eft.UploadDocumentLink().isDisplayed() == false) {
			      	Thread.sleep(1000);
			    }
			   load= eft.UploadDocumentLink().isDisplayed();
			 }
	
			Instant end1 = Instant.now();
			System.out.println("Login time Pateint Search Button ended:" +end1);
			Duration timeElapsed1 = Duration.between(start1, end1);
			long ayc1=timeElapsed1.getSeconds();
			System.out.println("Time taken: "+ timeElapsed1.getSeconds()+"seconds");
				
			if (eft.UploadDocumentLink().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Time took for Patient search in seconds :" +ayc1 );
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the Patient search ");
			}
			
			System.out.println("i am searching for this memeber ID EYE00044386");
			//Thread.sleep(3000);
			eft.SearchByMemberId().sendKeys("EYE00044386");
			System.out.println("i am searching for this memeber ID EYE00044386");
			abc.PateintSearchButton().click();
			abc.PateintName().click();
			Instant start3 = Instant.now();
			System.out.println("Login time Claims Search Button started:" +start3);
			abc.PateintSearchClaimsTab().click();
			
			Instant end3 = Instant.now();
			System.out.println("Login time Claims Search Button ended:" +end3);
			Duration timeElapsed3 = Duration.between(start3, end3);
			long ayc3=timeElapsed3.getSeconds();
			System.out.println("Time taken: "+ timeElapsed3.getSeconds()+"seconds");
				
			if (abc.ClaimsTable().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", " Claims Tab Search Button", "Time took for Claims Tab Search Button in seconds :" +ayc3 );
			} else {
				TestBase.classAInstance.logReport("Fail", " Claims Tab Search Button", "Failed verified the Claims Tab Search Button ");
			}
			
			abc.PateintSearchCommunicationTab().click();
			Instant start4= Instant.now();
			System.out.println("Login time Claims Search Button started:" +start4);
			abc.ClaimsTabSearchButton().click();
			
			Instant end4 = Instant.now();
			System.out.println("Login time Claims Search Button ended:" +end4);
			Duration timeElapsed4 = Duration.between(start4, end4);
			long ayc4=timeElapsed4.getSeconds();
			System.out.println("Time taken: "+ timeElapsed4.getSeconds()+"seconds");
				
			if (abc.PateintSearchCommunicationTabLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", " Communication Tab Search Button", "Time took for Communication Tab Search Button in seconds :" +ayc4 );
			} else {
				TestBase.classAInstance.logReport("Fail", " Communication Tab Search Button", "Failed verified the CommunicationTab Search Button ");
			}
			
			
			//Click on Reports link EFT
			ReportsLink().click();
			System.out.println("Clicked on ReportsLink");
			Thread.sleep(1000);
			PaymentReportLink().click();
			System.out.println("Clicked on PaymentReportLink");
			Instant start2= Instant.now();
			System.out.println("Login time Payment Report Link started:" +start2);
			PaymentReportLinkSearchButton().click();
			System.out.println("Clicked on SearchButton");
			
			boolean load1 = false;
			System.out.println("$$$$$$$$$$$$$$$$:" +PaymentReportTableBody().isDisplayed());
			while(load1 == false)
			{
			   if(PaymentReportTableBody().isDisplayed() == false) {
			      	Thread.sleep(1000);
			      	System.out.println("PaymentReportTableBody");
			    }
			   load1=PaymentReportTableBody().isDisplayed();
			 }
	
			Instant end2 = Instant.now();
			System.out.println("Login time Payment Report Link ended:" +end2);
			Duration timeElapsed2 = Duration.between(start2, end2);
			long ayc2=timeElapsed2.getSeconds();
			System.out.println("Time taken: "+ timeElapsed2.getSeconds()+"seconds");
			
			
			if (PaymentReportTableBody().isDisplayed()==true) {
				TestBase.classAInstance.logReport("Pass", "Payment Report page", "Succesfully able click on Payment Report table:" +ayc2);
			} else {
				TestBase.classAInstance.logReport("Fail", "Payment Report page", "Failed to click on Payment Report table");
			}
			
			
			
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "LoginTest", "LoginTest Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser() {
		//closeBrowser();
		TestBase.classAInstance.endReport();
	}

	

}
