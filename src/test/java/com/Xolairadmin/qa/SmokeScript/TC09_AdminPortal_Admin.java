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
public class TC09_AdminPortal_Admin extends AdminPortalLoginLogoutPage{
	
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
			TestBase.classAInstance.logReport("Pass", "Verify the Admin  link", "Succesfully Verify Admin  link");
			} else {
			TestBase.classAInstance.logReport("Fail", "Verify the Admin  link", "Failed to Verify Admin  link");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Admin  link")
	public void Faxes() throws InterruptedException, IOException, AWTException
	{
		
		
		AdminPortalLogin();
		
		ahp.AdminOnlyLink().click();
		
		boolean hhh1= driver.getPageSource().contains("Error");
		System.out.println("hhh12:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Admin Only Link" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Admin Only Link");
			}
		
		//Verify the sub-links now
		Assert.assertTrue(ahp.HelpDeskLink().isDisplayed());
		if(ahp.HelpDeskLink().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Admin Only link","Succesfully able to Verify Admin portal side panel Admin Only link");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Admin Only link","Failed to Verify Admin portal side panel Admin Only link");
		}
		
		//Verify sub-links in Helpdesk link
		ahp.HelpDeskLink().click();
		ahp.SearchHelpDeskUser().click();
		Thread.sleep(2000);
				
		Assert.assertTrue(ahp.SearchHelpDeskUserFindButton().isDisplayed());
		if(ahp.SearchHelpDeskUserFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel HelpDesk link-Search Help Desk User","Succesfully able to Verify Admin portal side panel HelpDesk link-Search Help Desk User");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel HelpDesk link -Search Help Desk User","Failed to Verify Admin portal side panel HelpDesk link-Search Help Desk User");
		}
		
		ahp.NewHelpdeskUser().click();
		Thread.sleep(2000);
		Assert.assertTrue(ahp.NewHelpdeskUserAddButton().isDisplayed());
		if(ahp.NewHelpdeskUserAddButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel HelpDesk link-Search Help Desk User","Succesfully able to Verify Admin portal side panel HelpDesk link-Search Help Desk User-4");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel HelpDesk link -Search Help Desk User","Failed to Verify Admin portal side panel HelpDesk link-Search Help Desk User-4");
		}
		
		
		AdminPortalLogout();
	}		

}
