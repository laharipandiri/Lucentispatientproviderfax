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

//verify HCPWelcomeMessage(excel),HCPFooterMessage(excel),error, UserID,Password, submit


@Listeners(TestNGListner.class)
public class TC03_HCPPortal_LoginTest extends HubHomeLoginLogoutPage {

	
	// Patient Portal Page Objects
		String uname = prop.getProperty("HCPusername");
		String pwd = prop.getProperty("HCPpassword").trim();
		String tit = prop.getProperty("ExpectedHCPPageTitle");
		
		
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
		TestBase.classAInstance.logReport("Fail", "LoginTest", "LoginTest Failed");
		}
	}

	@Test(description = "Sucessful Login",invocationCount=4, threadPoolSize = 4)
	public void HubLogin() throws InterruptedException, IOException, AWTException

	{
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
			
//			String HCPWelcome= HCPWelcomeMessage().getText();
//			System.out.println("HCPWelcome is:" +HCPWelcome);
//			
			
//			if (HCPWelcomeMessage().getText().equalsIgnoreCase(testData.get(3))) {
//				TestBase.classAInstance.logReport("Pass", "Able to login", "HCP Welcome Message Field is available");
//			} else {
//				TestBase.classAInstance.logReport("Fail", "Not able to login", "HCP Welcome Message Field is not available");
//			}
			
			
			String HCPFooter= HCPFooterMessage().getText();
			System.out.println("HCPFooter is:" +HCPFooter);
			System.out.println("the test data:" +testData.get(1));
			
			if (HCPFooterMessage().getText().equalsIgnoreCase(testData.get(1))) {
				TestBase.classAInstance.logReport("Pass", "Able to login", "HCP Footer Message Field is available");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to login", "HCP Footer Message Field is not available");
			}
			
			//Checking for Error
//			boolean data= driver.getPageSource().contains("An error occurred. Please try again later.");
//			Thread.sleep(3000);
//			if (data == false) {
//				TestBase.classAInstance.logReport("Pass", "UsingProgram page", "Succesfully able click on UsingProgram page");
//			} else {
//				TestBase.classAInstance.logReport("Fail", "UsingProgram page", "Failed as we see an error in UsingProgram page");
//			}
	
			UserID().clear();
			UserID().sendKeys(uname);
			Thread.sleep(2000);
			if (UserID().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Able to login", "UserID Field is available");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to login", "UserID Field is not available");
			}
			
			
			Password().clear();
			Password().sendKeys(pwd);
			if (Password().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Able to login", "Password Field is available");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to login", "Password Field is not available");
			}
			Thread.sleep(3000);
			
			if (SubmitButton().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Able to login", "SubmitButton Field is available");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to login", "Password Field is not available");
			}
			
			// click on submit button
			SubmitButton().click();
			Thread.sleep(2000);
					
			String title = driver.getTitle();
			System.out.println("the title is:" +title);

			Assert.assertEquals(title,tit);
			// reporting
			if (title.equalsIgnoreCase(tit)) {
				TestBase.classAInstance.logReport("Pass", "Able to login", "Succesfully able to login-7");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to login", "Failed to login-7");
			}
			
	
		} catch (Exception e) {
			TestBase.classAInstance.logReport("Fail", "LoginTest", "LoginTest Failed");
		}

	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "HCP Login", "Succesfully verified HCP Portal Login");
			} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login", "Failed to verified HCP Portal Login");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}


	

}
