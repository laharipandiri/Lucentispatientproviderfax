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
public class TC07_AdminPortal_Payments extends AdminPortalLoginLogoutPage{
	
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
			TestBase.classAInstance.logReport("Pass", "Verify the Payments link", "Succesfully Verify the Payments link");
			} else {
			TestBase.classAInstance.logReport("Fail", "Verify the Payments link", "Failed to Verify the Payments link");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Payments links")
	public void Payments() throws InterruptedException, IOException, AWTException
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		
		wait.until(ExpectedConditions.visibilityOf(ahp.PaymentsLink()));
		//Verify that clicking on payments link displays 3 sub links
		ahp.PaymentsLink().click();
		//Verify the sub-links now
		
		boolean hhh1= driver.getPageSource().contains("Error");
		System.out.println("hhh12:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Payments" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-Payments");
			}
		 
		Assert.assertTrue(ahp.ChecksLink().isDisplayed()); //Check
		Assert.assertTrue(ahp.RepaymentsLink().isDisplayed()); //Re Payment
		Assert.assertTrue(ahp.EFTLink().isDisplayed()); //EFT
		//Payments expanded
		if(ahp.ChecksLink().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Payments link","Succesfully able to Verify Admin portal side panel Payments link");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Payments link","Failed to Verify Admin portal side panel Payments link");
		}
		
		//Now click on Checks sub-link
		ahp.ChecksLink().click();
		Assert.assertTrue(ahp.ListLink().isDisplayed());
		Thread.sleep(2000);
		//Checks link
		if(ahp.ListLink().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Checks link","Succesfully able to Verify Admin portal side panel Checks link");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Checks link","Failed to Verify Admin portal side panel Checks link");
		}
		ahp.ListLink().click();
		Thread.sleep(2000);
		//Checks link Find button
		Assert.assertTrue(ahp.ListLinkFindButton().isDisplayed());
		if(ahp.ListLinkFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Checks link Find Button","Succesfully able to Verify Admin portal side panel Checks link  Find Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Checks link  Find Button","Failed to Verify Admin portal side panel Checks link  Find Button");
		}
		
		//Now click on Repayments sub-link
		ahp.RepaymentsLink().click();
		Assert.assertTrue(ahp.ListLink().isDisplayed());
		Assert.assertTrue(ahp.RepaymentNewLink().isDisplayed());
		Thread.sleep(2000);
		
		//Repayments expandable
		if(ahp.RepaymentsLink().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Repayments link","Succesfully able to Verify Admin portal side panel Repayments link");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Repayments link","Failed to Verify Admin portal side panel Repayments link");
		}
		ahp.ListLink().click();
		ahp.ListLinkFindButton().click();
		//Repayments-list-find
		if(ahp.ListLinkFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Repayments link-List","Succesfully Verify Admin portal side panel Repayments link-List-Find Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Repayments link-List","Failed to Verify Admin portal side panel Repayments link-List-Find Button");
		}
		ahp.RepaymentsLink().click();
		ahp.RepaymentNewLink().click();
		//Repayments-New-find
		if(ahp.RepaymentAddButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Repayments link-New","Succesfully Verify Admin portal side panel Repayments link-New-Add Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Repayments link-New","Failed to Verify Admin portal side panel Repayments link-New-Add Button");
		}
		
		
		//Now click on EFT sub-link
		ahp.EFTLink().click();
		Thread.sleep(6000);
		ahp.ListLink().click();
		Thread.sleep(6000);
		ahp.ListLinkFindButton().click();
		Thread.sleep(6000);
		if(ahp.ListLinkFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel EFT link Find Button","Succesfully able to Verify Admin portal side panel EFT link Find Button-8");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel EFT link Find Button","Failed to Verify Admin portal side panel EFT link Find Button-8");
		}

		/*Assert.assertTrue(ahp.ListLink().isDisplayed());
		ahp.ListLink().click();
		Thread.sleep(6000);
		
		//reporting
		if(ahp.ListLinkFindButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel EFT link Find Button","Succesfully able to Verify Admin portal side panel EFT link Find Button");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel EFT link Find Button","Failed to Verify Admin portal side panel EFT link Find Button");
		}

		*/
		AdminPortalLogout();
	}		

}
