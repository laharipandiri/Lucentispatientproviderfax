package com.WaitTime.qa;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.pages.ProviderPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC01_AdminPortal_ButtonClick extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	ExcelTestDataReader etd= new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	AdminPortalLoginLogoutPage eft= new AdminPortalLoginLogoutPage();
	PatientPage abd=new PatientPage();
	ProviderPage abc= new ProviderPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	
	
	
	String Key = "LoginTest";
	
	
	@BeforeMethod
	public void OpenBrowser() {
		try {
		intializeAdminDriver();
		TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		}
		catch(InterruptedException e) {
			
		}
	} 
	
	@Test(description = "Sucessful Login of Drug Reimbursement in Admin Portal")
	public void AdminWaitTime() throws Exception

	{
		WebDriverWait wait = new WebDriverWait(driver, 1);
		//First get keyvalue pair
		int rowNum = etd.getKeyValuePair(Key);//Returns the rownum in which the test data is available and the method name that can be called to get that test data into the test
		
		//get test data based on the key
		List<String> testData = new ArrayList<String>();
		testData = gst.GetAdminLoginSmokeTestData(Key,rowNum);
	    System.out.println("The testData is:" +testData);
		
		UserID().clear();
		UserID().sendKeys(testData.get(0));
		Thread.sleep(2000);
		Password().clear();
		Password().sendKeys(testData.get(1));
		Thread.sleep(2000);
		
		//Selecting a Program name
		ProgramName().selectByVisibleText(testData.get(2));
		
		//click on submit button
		Instant start = Instant.now();
		System.out.println("The testData is:" +start);
		LoginButton().click();
		wait.until(ExpectedConditions.visibilityOf(WelcomeVerification()));
		
		//your code
		Instant end = Instant.now();
		System.out.println("The testData is:" +end);
		Duration timeElapsed = Duration.between(start, end);
		long ayc=timeElapsed.getSeconds();
		System.out.println("Time taken: "+ timeElapsed.getSeconds()+"seconds");
			
		if (WelcomeVerification().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Time took for login Button in seconds :" +ayc );
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the HCP Welcome Message after clicking OK");
		}
		
		//Patient search patient
		
		abd.PatientsLink().click(); //Click on  Patient link
		abd.SearchPatient().click(); //Click on search Patient link
				
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		
		//time monitoring
		Instant start1 = Instant.now();
		boolean load = true;
		while(load == true) {
		   if(abd.Loading().isDisplayed() == true) {
		      	Thread.sleep(1000);
		    }
		   load= abd.Loading().isDisplayed();
		 }
		
		Instant end1 = Instant.now();
		System.out.println("The Patient Search button end1 is:" +end1);
		Duration timeElapsed1 = Duration.between(start1, end1);
		long ayc1=timeElapsed1.getSeconds();
		System.out.println("Time taken: "+ timeElapsed1.getSeconds()+"seconds");
			
		if (WelcomeVerification().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Patient Search button", "Time took for Patient Search button in seconds :" +ayc1 );
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Search button", "Patient Search button");
		}
			
		//search provider
		
		abc.Providers().click(); //Provider link
		abc.SearchProvider().click(); //Search Provider
		
		abc.ProvidersType().selectByVisibleText("Physician");
		abc.ProviderNameField().sendKeys("a");
		Instant start2 = Instant.now();
		abc.ProvidersSearchdButton().click(); // Search button
		
		//time monitoring
			
				Instant end2 = Instant.now();
				System.out.println("The Provider Search button end1 is:" +end2);
				Duration timeElapsed2 = Duration.between(start2, end2);
				long ayc2=timeElapsed2.getSeconds();
				System.out.println("Time taken: "+ timeElapsed2.getSeconds()+"seconds");
					
				if (abc.ProvidersSearchReview().isDisplayed()== true) {
					TestBase.classAInstance.logReport("Pass", "Provider Search button", "Time took for Provider Search button in seconds :" +ayc2 );
				} else {
					TestBase.classAInstance.logReport("Fail", "Provider Search button", "Provider Search button");
				}
				
		
			
		//payment
		//check List page load
		ahp.PaymentsLink().click();
		ahp.ChecksLink().click();
		
		Instant start3 = Instant.now();
		ahp.ListLink().click();
		
		Instant end3 = Instant.now();
		System.out.println("The payment  check list end3 is:" +end3);
		Duration timeElapsed3 = Duration.between(start3, end3);
		long ayc3=timeElapsed3.getSeconds();
		System.out.println("Time taken: "+ timeElapsed3.getSeconds()+"seconds");
			
		if (ahp.ListLink().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "payment  check list", "Time took for payment  check list in seconds :" +ayc3 );
		} else {
			TestBase.classAInstance.logReport("Fail", "payment  check list", "payment  check list");
		}
		  
		
		
		ahp.RepaymentsLink().click();
		Assert.assertTrue(ahp.ListLink().isDisplayed());
		Assert.assertTrue(ahp.RepaymentNewLink().isDisplayed());
		Thread.sleep(2000);
		Instant start4 = Instant.now();
		ahp.ListLink().click();
		
		Instant end4 = Instant.now();
		System.out.println("The payment  check list end3 is:" +end4);
		Duration timeElapsed4 = Duration.between(start4, end4);
		long ayc4=timeElapsed4.getSeconds();
		System.out.println("Time taken: "+ timeElapsed4.getSeconds()+"seconds");
			
		if (ahp.ListLink().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "RepaymentsLink  check list", "Time took for RepaymentsLink  check list in seconds :" +ayc4 );
		} else {
			TestBase.classAInstance.logReport("Fail", "RepaymentsLink  check list", "RepaymentsLink  check list");
		}
		
		
		ahp.RepaymentsLink().click();
		Instant start5 = Instant.now();
		ahp.RepaymentNewLink().click();
		
		Instant end5 = Instant.now();
		System.out.println("The payment  check list end5 is:" +end5);
		Duration timeElapsed5 = Duration.between(start5, end5);
		long ayc5=timeElapsed5.getSeconds();
		System.out.println("Time taken: "+ timeElapsed5.getSeconds()+"seconds");
			
		if (ahp.RepaymentNewLink().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "RepaymentNew   check list", "Time took for Repayment New   check list in seconds :" +ayc5 );
		} else {
			TestBase.classAInstance.logReport("Fail", "RepaymentNewLink  check list", "RepaymentNewLink  check list");
		}
		
			
		ahp.EFTLink().click();
		Thread.sleep(6000);
		Instant start6 = Instant.now();
		ahp.ListLink().click();
		
		Instant end6 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end6);
		Duration timeElapsed6 = Duration.between(start6, end6);
		long ayc6=timeElapsed6.getSeconds();
		System.out.println("Time taken: "+ timeElapsed6.getSeconds()+"seconds");
			
		if (ahp.ListLink().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "EFT Link  check list", "Time took for EFT Link  check list in seconds :" +ayc6 );
		} else {
			TestBase.classAInstance.logReport("Fail", "EFT Link  check list", "EFT Link  check list");
		}
		
		
		//Fax link
		
		ahp.FaxesLink().click();
		Instant start7 = Instant.now();
		ahp.IncomingFaxesLink().click();
		Instant end7 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end7);
		Duration timeElapsed7 = Duration.between(start7, end7);
		long ayc7=timeElapsed7.getSeconds();
		System.out.println("Time taken: "+ timeElapsed7.getSeconds()+"seconds");
			
		if (ahp.IncomingFaxesLink().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Incoming Faxes Link", "Time took for Incoming Faxes Link in seconds :" +ayc7 );
		} else {
			TestBase.classAInstance.logReport("Fail", "Incoming Faxes Link", "Incoming Faxes Link");
		}
		
		
		Instant start8 = Instant.now();
		ahp.OutgoingFaxLink().click();
		Instant end8 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end8);
		Duration timeElapsed8 = Duration.between(start8, end8);
		long ayc8=timeElapsed8.getSeconds();
		System.out.println("Time taken: "+ timeElapsed8.getSeconds()+"seconds");
			
		if (ahp.IncomingFaxesHeaderName().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", ".Outgoing Faxes Link", "Time took for .Outgoing Faxes Link in seconds :" +ayc7 );
		} else {
			TestBase.classAInstance.logReport("Fail", ".Outgoing Faxes Link", ".Outgoing Faxes Link");
		}
		
		Instant start9 = Instant.now();
		ahp.ListAllLink().click();
		Thread.sleep(2000);
		Instant end9 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end9);
		Duration timeElapsed9 = Duration.between(start9, end9);
		long ayc9=timeElapsed9.getSeconds();
		System.out.println("Time taken: "+ timeElapsed9.getSeconds()+"seconds");
			
		if (ahp.IncomingFaxesHeaderName().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "List All Link", "Time took for List All Link in seconds :" +ayc9 );
		} else {
			TestBase.classAInstance.logReport("Fail", "List All Link", "List All Link");
		}
		
		
		//admin portal
		
		ahp.AdminOnlyLink().click();
		ahp.HelpDeskLink().click();
		Instant start10 = Instant.now();
		ahp.SearchHelpDeskUser().click();
		Instant end10 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end10);
		Duration timeElapsed10 = Duration.between(start10, end10);
		long ayc10=timeElapsed10.getSeconds();
		System.out.println("Time taken: "+ timeElapsed10.getSeconds()+"seconds");
			
		if (ahp.SearchHelpDeskUser().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Admin Search Help Desk User", "Time took for Admin Search Help Desk User in seconds :" +ayc10);
		} else {
			TestBase.classAInstance.logReport("Fail", "Admin Search Help Desk User", "Admin Search Help Desk User");
		}
		
			
		Instant start11 = Instant.now();
		ahp.NewHelpdeskUser().click();
		Instant end11 = Instant.now();
		System.out.println("The payment  check list end6 is:" +end11);
		Duration timeElapsed11 = Duration.between(start11, end11);
		long ayc11=timeElapsed11.getSeconds();
		System.out.println("Time taken: "+ timeElapsed11.getSeconds()+"seconds");
			
		if (ahp.NewHelpdeskUserAddButton().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Admin New Help desk User", "Time took for Admin New Help desk User in seconds :" +ayc11);
		} else {
			TestBase.classAInstance.logReport("Fail", "Admin New Help desk User", "Admin New Help desk User");
		}
	
		
		}
	
	
	@AfterMethod
	public void CloseBrowser()
	{
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	

	
	

}
