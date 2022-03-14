package com.Xolairadmin.qa.SmokeScript;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC01_XolairAdminPortal_Login extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	ExcelTestDataReader etd= new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	AdminPortalLoginLogoutPage eft= new AdminPortalLoginLogoutPage();
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
	
	@Test(description = "Sucessful Login in Admin Portal")
	public void AdminLoginUsingExcel_DrugReimbursement() throws Exception

	{
		
		String ExpectedTitle = prop.getProperty("ExpectedAdminPageTitle");
		String title = driver.getTitle();
		Assert.assertEquals(title,ExpectedTitle);
		
		//First get keyvalue pair
		int rowNum = etd.getKeyValuePair(Key);//Returns the rownum in which the test data is available and the method name that can be called to get that test data into the test
		
		//get test data based on the key
		List<String> testData = new ArrayList<String>();
		testData = gst.GetAdminLoginSmokeTestData(Key,rowNum);
	
		eft.BeforeLoginVerification();
		}
	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Login in Admin Portal", "Succesfully Login in Admin Portal");
			} else {
			TestBase.classAInstance.logReport("Fail", "Login in Admin Portal", "Failed to Login in Admin Portal");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	
	public void Login(List<String> testData) throws IOException, AWTException
	{
		
		//String ExpectedTitle = "CAR T Copay Program";
		try {
			UserID().clear();
			UserID().sendKeys(testData.get(0));
			Thread.sleep(2000);
			Password().clear();
			Password().sendKeys(testData.get(1));
			Thread.sleep(2000);
			
			//Selecting a Program name
			ProgramName().selectByVisibleText(testData.get(2));
			
			//click on submit button
			LoginButton().click();
			Thread.sleep(2000);

			String title = driver.getTitle();
			System.out.println(title);


			Assert.assertEquals(title, testData.get(3));
			//reporting
			if(title.equalsIgnoreCase(testData.get(3)) == true)
	        {
	        	TestBase.classAInstance.logReport("Pass","Sucessful Login Drug Reimbursement","Succesfully able to Verify Sucessful Login of Drug Reimbursement Admin Portal-1");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Sucessful Login Drug Reimbursement","Failed to Verify Sucessful Login of Drug Reimbursement Admin Portal-1");
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
