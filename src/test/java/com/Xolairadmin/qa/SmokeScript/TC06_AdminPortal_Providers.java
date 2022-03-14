package com.Xolairadmin.qa.SmokeScript;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//import com.aventstack.extentreports.util.Assert;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.pages.ProviderPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.*;

//THIS test case will click on Search and verify the Physician info for 1 particular physician


@Listeners(TestNGListner.class)
public class TC06_AdminPortal_Providers extends AdminPortalLoginLogoutPage{
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderPage abc= new ProviderPage();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Providers_FindPage app = new AdminPortal_Providers_FindPage();
	AdminPortal_Providers_PhysicianAndCardInfoTabPage apc = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	
	//Regression excel sheet
	String Key = "SearchPhysician";
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			}
			catch(InterruptedException e) {
				
			}
	} 
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Verify the Search Provider", "Succesfully Verify the Search Provider");
			} else {
			TestBase.classAInstance.logReport("Fail", "Verify the Search Provider", "Failed to Verify the Search Provider");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Search Provider")
	public void SearchProvider() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
			
		abc.Providers().click(); //Provider link
		//abc.EnrollNewProvider().click(); //Enroll New Provider
		
		boolean hhh1= driver.getPageSource().contains("Error");
		System.out.println("hhh12:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Providers" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-HelpDesk Notes");
			}
		 
		Assert.assertTrue(abc.EnrollNewProvider().isDisplayed());
		if(abc.EnrollNewProvider().isDisplayed()== true)
		{
			TestBase.classAInstance.logReport("Pass","Verify the Provider-Enroll New Provider link","Succesfully able to  Verify the Enroll New Provider link");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Verify the Provider-Enroll New Provider link","Failed to  Verify the Enroll New Provider link");
	     }
		
				
		abc.Providers().click(); //Provider link
		abc.SearchProvider().click(); //Search Provider
		Assert.assertTrue(abc.SearchProvider().isDisplayed());
		if(abc.SearchProvider().isDisplayed()== true)
		{
			TestBase.classAInstance.logReport("Pass","Verify the Provider-Search Provider link","Succesfully able to  Verify the Search Provider link");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Verify the Provider-Search Provider link","Failed to  Verify the Search Provider link");
	     }
			
		wait.until(ExpectedConditions.visibilityOf(abc.ProvidersSearchdButton()));
	
		abc.ProvidersSearchdButton().click(); // Search button
		
		
		
		Assert.assertTrue(abc.ProvidersSearchdButton().isDisplayed());
		if(abc.ProvidersSearchdButton().isDisplayed()== true)
		{
			TestBase.classAInstance.logReport("Pass","Verify the Provider-Search Button","Succesfully able to  Verify the Provider Search Button-4");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Verify the Provider-Search Button","Failed to  Verify the Provider Search Button-4");
	     }
		
		
		AdminPortalLogout();
	}		

}
