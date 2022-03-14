package com.qa.e2e.TwoDrugEnrollmentLucentisSusvimo.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
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
public class TC08_New_EPPortal_PaymentReport_Paid extends HubHomeLoginLogoutPage {

	
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
			Thread.sleep(300000);
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
			String Key = "SmokePatientEnrollment";
			
			int rowNum = etd.getKeyValuePair(Key);
			List<String> testData = new ArrayList<String>();
			testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); 
			System.out.println("testdata is:" +testData);
			
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
					
			UserID().clear();
			UserID().sendKeys(uname);
			
			Password().clear();
			Password().sendKeys(pwd);
				
			SubmitButton().click();
			wait.until(ExpectedConditions.visibilityOf(abc.PateintSearchButton()));
			
			//Click on Reports link EFT
			ReportsLink().click();
			System.out.println("Clicked on ReportsLink");
			Thread.sleep(1000);
			PaymentReportLink().click();
			System.out.println("Clicked on PaymentReportLink");
			
			PaymentReportLinkSearchButton().click();
			System.out.println("Clicked on SearchButton");
			Thread.sleep(9000);
			
			PaymentReportLinkSortByDate().click();
			System.out.println("Clicked on DOS");
			Thread.sleep(9000);
			
			int TotalRowsPayment = NumOfRowsPayment().size();
			System.out.println("TotalRowsPayment:" +TotalRowsPayment);
			
			
			
			//trying to find the member ID
			
			for (int i = 1; i <= TotalRowsPayment; i++) {	
				System.out.println("i am inside for loop");
				String MemberIDScreen =driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/app-check/div[2]/table/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println("Screen member id amount "+MemberIDScreen);
				
				String abc= testData.get(20).trim();
				System.out.println("The member ID is:" +abc);

			  if(MemberIDScreen.equals(abc))	
			  {
				System.out.println("Member " + MemberIDScreen + "is present on the screen");
				String Status =driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/app-check/div[2]/table/tbody/tr["+i+"]/td[9]")).getText();
				System.out.println("Screen member id Status "+Status);
				Thread.sleep(4000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(150,750)", "");
				 if (Status.equals("Paid")) {
						TestBase.classAInstance.logReport("Pass", "HCP payment status", "Succesfully verified HCP payment status is Paid");
					} else {
						TestBase.classAInstance.logReport("Fail", "HCP payment status", "Failed to verified HCP payment status is Paid");
					}  
				 break;
				  }
			  
			 }
						
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "LoginTest", "LoginTest Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser() {
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	

}
