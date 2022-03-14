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
public class TC08_AdminPortal_Faxes extends AdminPortalLoginLogoutPage{
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderPage abc= new ProviderPage();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Providers_FindPage app = new AdminPortal_Providers_FindPage();
	AdminPortal_Providers_PhysicianAndCardInfoTabPage apc = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	
	//Regression excel sheet
	//String Key = "SearchPhysician";
	
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
			TestBase.classAInstance.logReport("Pass", "Verify the Fax", "Succesfully Verify the Fax");
			} else {
			TestBase.classAInstance.logReport("Fail", "Verify the Fax", "Failed to Verify the Fax");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Fax")
	public void Faxes() throws InterruptedException, IOException, AWTException
	{
		
		
		AdminPortalLogin();
		
		//Verify that clicking on Faxes link displays 5 sub links
		ahp.FaxesLink().click();
		
		
		//Verify the sub-links now
		Assert.assertTrue(ahp.IncomingFaxesLink().isDisplayed());
		Assert.assertTrue(ahp.OutgoingFaxLink().isDisplayed());
		Assert.assertTrue(ahp.ListAllLink().isDisplayed());
		//Assert.assertTrue(ahp.AssignmentsLink().isDisplayed());
		//Assert.assertTrue(ahp.AssignmentRulesLink().isDisplayed());
		
		boolean hhh1= driver.getPageSource().contains("Error");
		System.out.println("hhh12:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Faxes Link" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Faxes Link");
			}
		//reporting
		
		ahp.IncomingFaxesLink().click();
		Thread.sleep(5000);
		Assert.assertTrue(ahp.IncomingFaxesHeaderName().isDisplayed());
		Assert.assertTrue(ahp.IncomingFaxesFindButton().isDisplayed());
		if(ahp.IncomingFaxesFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal Fax-Incoming Faxes-Find Button","Succesfully able to Verify Admin portal incoming Faxes link Find button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal Fax-Incoming Faxes-Find Button","Failed to Verify Admin portal incoming Faxes link Find button");
		}
		
		ahp.OutgoingFaxLink().click();
		Thread.sleep(2000);
		ahp.IncomingFaxesHeaderName().isDisplayed();
		Assert.assertTrue(ahp.IncomingFaxesHeaderName().isDisplayed());
		Assert.assertTrue(ahp.IncomingFaxesFindButton().isDisplayed());
		if(ahp.IncomingFaxesFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal Fax-Outgoing Faxes-Find Button","Succesfully able to Verify Admin portal Outgoing Faxes link Find button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal Fax-Outgoing Faxes-Find Button","Failed to Verify Admin portal Outgoing Faxes link Find button");
		}
		
		ahp.ListAllLink().click();
		Thread.sleep(2000);
		ahp.IncomingFaxesHeaderName().isDisplayed();
		Assert.assertTrue(ahp.IncomingFaxesHeaderName().isDisplayed());
		Assert.assertTrue(ahp.IncomingFaxesFindButton().isDisplayed());
		if(ahp.IncomingFaxesFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal Fax-List All -Find Button","Succesfully able to Verify Admin portal List All link Find button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal Fax-List All -Find Button","Failed to Verify Admin portal List All link Find button");
		}
		
		
		AdminPortalLogout();
	}		

}
