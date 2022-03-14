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
import java.util.Set;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.HubHomeLoginLogoutPage;

//verify Login Logo, Header(excel), Footer(excel), IAndILink, PrescribingInfoLink

@Listeners(TestNGListner.class)
public class TC02_HCPPortal_VerifyHomePageContent extends HubHomeLoginLogoutPage {

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
		TestBase.classAInstance.logReport("Fail", "VerifyHomePageContent", "VerifyHomePageContent Failed");
				}

		}


	@Test(description = "Sucessful Login")
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{
		String title = driver.getTitle();
		
		try {
			//Smoke excel sheet
			String Key = "HCPLogin";
			
			System.out.println("The Key is:" +Key);
			int rowNum = etd.getKeyValuePair(Key);
			System.out.println("The rowNum is:" +rowNum);
			List<String> testData = new ArrayList<String>();
			testData = gst.GetSmokedata(Key, rowNum); 
			System.out.println("testdata is:" +testData);

			HCPPopUpMsgCloseButton().click();
			Thread.sleep(2000);
			
			
			if (LoginLogo().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the logo");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the logo");
			}
					
			System.out.println("HCPHeader:" +HCPHeader().getText());
			
			
			if (HCPHeader().getText().equalsIgnoreCase(testData.get(2))) {
				TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the Header");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the Header");
			}
			
			System.out.println("HCPFooter:" +HCPFooter().getText());
			
			if (HCPFooter().getText().equalsIgnoreCase(testData.get(1))) {
				TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the Footer");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the Footer");
			}
			
			IAndILink().click();
			Thread.sleep(3000);
			
			if (IAndILinkVerification().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Click on Indications and Important Safety Information");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Click on Indications and Important Safety Information");
			}
			
			String parentHandle = driver.getWindowHandle(); // get the current window handle
			System.out.println("parentHandle:" +parentHandle);
			Thread.sleep(1000);
			System.out.println("Before CLicked on Prescribing Info Link");
			PrescribingInfoLink().click();
			System.out.println("CLicked on Prescribing Info Link");
			Thread.sleep(10000);
				
			Set<String> ggg= driver.getWindowHandles();
			System.out.println("ggg:" +ggg);
			
			
		

			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			    String abc= PrescribingInfoVerification();
				System.out.println("abc is:" +abc);
			}
			String ttt= PrescribingInfoVerification(); 
			System.out.println("#########:" +ttt);
			if (ttt!=null) {
				TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Click on Prescribing Information-5");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Click on Prescribing Information-5");
			}
			
			driver.switchTo().window(parentHandle); // switch back to the original window
			
			
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "VerifyHomePageContent", "VerifyHomePageContent Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP Portal", "Succesfully verified HCP Portal page content");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP Portal", "Failed to verified HCP Portal page content");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}


	

}
