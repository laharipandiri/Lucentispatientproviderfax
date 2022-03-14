package com.Xolairadmin.qa.SmokeScript;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC02_XolairAdminPortal_HomePageContentAndTabVerify extends AdminPortalLoginLogoutPage {

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	
	
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
			TestBase.classAInstance.logReport("Pass", "content of Admin portal home page", "Succesfully Verify content of Admin portal home page");
			} else {
			TestBase.classAInstance.logReport("Fail", "content of Admin portal home page", "Failed to Verify content of Admin portal home page");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify content of Admin portal home page")
	public void VerifyHubHeaderAndFooter() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
				AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
				
				//Assert.assertEquals(ahp.ProgramTypeDropdown().getFirstSelectedOption().getText(), "Xolair RX Replatform");
				
				boolean hhh12= driver.getPageSource().contains("Error");
				//System.out.println("hhh12:" +hhh12);
				
				 if (hhh12 == true) {
					 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-HelpDesk Notes-1" );
					 
					}
					else
					{
					TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-HelpDesk Notes");
					}
			
				//Header items verification
				Assert.assertTrue(ahp.PatientsLink().isDisplayed());
				if(ahp.PatientsLink().isDisplayed() == true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify Patients Link in Admin portal home page-2");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify Patients Link in Admin portal home page");
				}
				
				Assert.assertTrue(ahp.ProvidersLink().isDisplayed());
				if(ahp.ProvidersLink().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify Providers Link in Admin portal home page-3");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify Providers Link in Admin portal home page");
				}
				
				Assert.assertTrue(ahp.PaymentsLink().isDisplayed());
				if(ahp.PaymentsLink().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify Payments Link in Admin portal home page-4");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify Payments Link in Admin portal home page");
				}
				Assert.assertTrue(ahp.FaxesLink().isDisplayed());
				if(ahp.FaxesLink().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify Faxes Link in Admin portal home page-5");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify Faxes Link in Admin portal home page");
				}
				
				Assert.assertTrue(ahp.AdminOnlyLink().isDisplayed());
				if(ahp.AdminOnlyLink().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify Admin Only Link in Admin portal home page-6");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify Admin Only Link in Admin portal home page");
				}
				Assert.assertTrue(AdminPortalLogoutButton().isDisplayed());
				
				//Verify the number of links displayed on the side panel in Admin portal home page
				Assert.assertEquals(ahp.SidePanelLinksCount(), 7);
				
				//Verify the header and footer in admin portal home page
			
				Assert.assertTrue(ahp.AdminPortalConnectiverxHeaderImage().isDisplayed());
				if(ahp.AdminPortalConnectiverxHeaderImage().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verified Admin Portal Connectiverx Header Image-7");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verified Admin Portal Connectiverx Header Image");
				}
				
				Assert.assertEquals(ahp.AdminPortalWelcomeMessage().getText(), "Welcome Raina I Jain");
				if(ahp.AdminPortalWelcomeMessage().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verified Admin Portal Welcome Message-8");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verified Admin Portal Welcome Message");
				}
				Assert.assertTrue(ahp.AdminPortalConnectiverxFooterImage().isDisplayed());
				
				if(ahp.AdminPortalConnectiverxFooterImage().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verified Admin Portal Connectiverx Footer Image-9");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verified Admin Portal Connectiverx Footer Image");
				}
				Assert.assertTrue(ahp.AdminPortalHelpdeskMessage().isDisplayed());
				if(ahp.AdminPortalHelpdeskMessage().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verified Admin Portal Help desk Message-10");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verified Admin Portal Help desk Message");
				}
				
				Assert.assertTrue(ahp.AdminPortalRightsReservedMessage().isDisplayed());
				
				if(ahp.AdminPortalRightsReservedMessage().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verified Admin Portal Rights Reserved Message-11");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verified Admin Portal Rights Reserved Message");
				}
				
				//reporting
				Assert.assertTrue(ahp.PatientsLink().isDisplayed());
				if(ahp.PatientsLink().isDisplayed()== true)
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify content of Admin portal home page-12");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify content of Admin portal home page-12");
				}
				
				AdminPortalLogout();
			}
		}
	

