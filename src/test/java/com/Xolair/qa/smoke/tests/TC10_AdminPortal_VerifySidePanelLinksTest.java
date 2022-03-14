package com.Xolair.qa.smoke.tests;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC10_AdminPortal_VerifySidePanelLinksTest extends AdminPortalLoginLogoutPage {
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	
	@BeforeMethod
	public void OpenBrowser() 
	{
		//initialization("Admin");
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			}
			catch(InterruptedException e) {
				
			}
	//	AdminPortalLogin();
		
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		//Close the driver
	//	AdminPortalLogout();
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify Admin portal side panel patients link", priority = 1)
	public void VerifyAdminPortalSidePanelPatientsLink() throws IOException, AWTException
	{
		
			AdminPortalLogin();
		
		//Verify that clicking on Patient link displays 5 new sub-links
			ahp.PatientsLink().click();
			//Verify the sub-links now
			//Assert.assertTrue(ahp.ActiveLink().isDisplayed());
			//Assert.assertTrue(ahp.DuplicateLink().isDisplayed());
			//Assert.assertTrue(ahp.InactiveLink().isDisplayed());
			Assert.assertTrue(ahp.NewLink().isDisplayed());
			Assert.assertTrue(ahp.FindLink().isDisplayed());
			
			//reporting
			if(ahp.FindLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel patients link","Succesfully able to Verify Admin portal side panel patients link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel patients link","Failed to Verify Admin portal side panel patients link");
			}
			
			AdminPortalLogout();
		}

	

	@Test ( description = "Verify Admin portal side panel providers link", priority = 2)
	public void VerifyAdminPortalSidePanelProvidersLink() throws InterruptedException, IOException, AWTException
	{
	
			AdminPortalLogin();
			
			//Verify that clicking on providers link displays 2 new sub-links
			ahp.ProvidersLink().click();
			//Verify the sub-links now
			//Assert.assertTrue(ahp.PhysicianLink().isDisplayed());
			Assert.assertTrue(ahp.EnrollNewProvider().isDisplayed());
			Assert.assertTrue(ahp.SearchProvider().isDisplayed());
			Thread.sleep(2000);
			
			//Now click on Physician sub-link
			//ahp.PhysicianLink().click();
			//Assert.assertTrue(ahp.ActiveLink().isDisplayed());
	//		Assert.assertTrue(ahp.PendingLink().isDisplayed());
			//Assert.assertTrue(ahp.InactiveLink().isDisplayed());
			
			//reporting
			if(ahp.SearchProvider().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel providers link","Succesfully able to Verify Admin portal side panel providers link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel providers link","Failed to Verify Admin portal side panel providers link");
			}
			
			AdminPortalLogout();
		}
	 


	
	@Test ( description = "Verify Admin portal side panel payments link", priority = 4)
	public void VerifyAdminPortalSidePanelPaymentsLink() throws InterruptedException, IOException, AWTException
	{
			AdminPortalLogin();
			
			//Verify that clicking on payments link displays 3 sub links
			ahp.PaymentsLink().click();
			//Verify the sub-links now
			Assert.assertTrue(ahp.ChecksLink().isDisplayed()); //Check
			Assert.assertTrue(ahp.RepaymentsLink().isDisplayed()); //Re Payment
			Assert.assertTrue(ahp.EFTLink().isDisplayed()); //EFT
			//reporting
			if(ahp.ChecksLink().isDisplayed())
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
			//reporting
			if(ahp.ListLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Checks link","Succesfully able to Verify Admin portal side panel Checks link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Checks link","Failed to Verify Admin portal side panel Checks link");
			}
			
			//Now click on Repayments sub-link
			ahp.RepaymentsLink().click();
			Assert.assertTrue(ahp.ListLink().isDisplayed());
			Assert.assertTrue(ahp.RepaymentNewLink().isDisplayed());
			Thread.sleep(2000);
			//reporting
			if(ahp.ListLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Repayments link","Succesfully able to Verify Admin portal side panel Repayments link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Repayments link","Failed to Verify Admin portal side panel Repayments link");
			}
			
			//Now click on EFT sub-link
			ahp.EFTLink().click();
			Assert.assertTrue(ahp.ListLink().isDisplayed());
			//reporting
			if(ahp.ListLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel EFT link","Succesfully able to Verify Admin portal side panel EFT link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel EFT link","Failed to Verify Admin portal side panel EFT link");
			}
			AdminPortalLogout();
		}
		

	
	@Test ( description = "Verify Admin portal side panel faxes link", priority = 5)
	public void VerifyAdminPortalSidePanelFaxesLink() throws IOException, AWTException
	{
			AdminPortalLogin();
			
			//Verify that clicking on payments link displays 5 sub links
			ahp.FaxesLink().click();
			//Verify the sub-links now
			Assert.assertTrue(ahp.IncomingFaxesLink().isDisplayed());
			Assert.assertTrue(ahp.OutgoingFaxLink().isDisplayed());
			Assert.assertTrue(ahp.ListAllLink().isDisplayed());
			Assert.assertTrue(ahp.AssignmentsLink().isDisplayed());
			Assert.assertTrue(ahp.AssignmentRulesLink().isDisplayed());
			
			//reporting
			if(ahp.IncomingFaxesLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Faxes link","Succesfully able to Verify Admin portal side panel Faxes link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Faxes link","Failed to Verify Admin portal side panel Faxes link");
			}
			
			AdminPortalLogout();
		}
	
		
	
	
	
		

	
/*	@Test ( description = "Verify Admin portal side panel Admin only link", priority = 7)
	public void VerifyAdminPortalSidePanelAdminOnlyLink() throws InterruptedException, IOException, AWTException
	{
			AdminPortalLogin();
			
			//Verify that clicking on Admin only link displays 2 sub link
			ahp.AdminOnlyLink().click();
			
			//Verify the sub-links now
			Assert.assertTrue(ahp.HelpDeskLink().isDisplayed());
			Assert.assertTrue(ahp.SettingsLink().isDisplayed());
			
			//reporting
			if(ahp.HelpDeskLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Admin Only link","Succesfully able to Verify Admin portal side panel Admin Only link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Admin Only link","Failed to Verify Admin portal side panel Admin Only link");
			}
			
			//Verify sub-links in Helpdesk link
			ahp.HelpDeskLink().click();
			Assert.assertTrue(ahp.AdminListLink().isDisplayed());
			Assert.assertTrue(ahp.CompanyAdminListLink().isDisplayed());
			Assert.assertTrue(ahp.ProgramAdminListLink().isDisplayed());
			Assert.assertTrue(ahp.HelpDeskRestrictedListLink().isDisplayed());
			Assert.assertTrue(ahp.NewLink().isDisplayed());
			Assert.assertTrue(ahp.FindLink().isDisplayed());
			Thread.sleep(2000);
			//reporting
			if(ahp.AdminListLink().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel HelpDesk link","Succesfully able to Verify Admin portal side panel HelpDesk link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel HelpDesk link","Failed to Verify Admin portal side panel HelpDesk link");
			}
			
			//verify the sub-link in Settings
			ahp.SettingsLink().click();
			Assert.assertTrue(ahp.ProgramLink().isDisplayed());
			
			AdminPortalLogout();
		}
		
}*/
	//Remove this test from here and add it in TC13 for logout page verification
	@Test ( description = "Verify Admin portal side panel Logout link", priority = 8)
	public void VerifyAdminPortalSidePanelLogoutLink() throws InterruptedException, IOException, AWTException
	{
			AdminPortalLogin();
			
			Assert.assertTrue(AdminPortalLogoutButton().isDisplayed());
			//reporting
			if(AdminPortalLogoutButton().isDisplayed())
	        {
	        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Logout link","Succesfully able to Verify Admin portal side panel Logout link");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Logout link","Failed to Verify Admin portal side panel Logout link");
			}
			
			
			AdminPortalLogout();
		}
	} 
	
	
	

