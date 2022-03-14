package com.Xolair.qa.smoke.tests;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC09_AdminPortal_Verify_HomePageContentTest extends AdminPortalLoginLogoutPage {

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
	public void CloseBrowser()
	{
		//Close the driver
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify content of Admin portal home page")
	public void VerifyHubHeaderAndFooter() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
				AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
				
				Assert.assertEquals(ahp.ProgramTypeDropdown().getFirstSelectedOption().getText(), "Xolair RX Replatform");
			
				//Header items verification
				Assert.assertTrue(ahp.PatientsLink().isDisplayed());
				Assert.assertTrue(ahp.ProvidersLink().isDisplayed());
				//Assert.assertTrue(ahp.ProviderGroupsLink().isDisplayed());
				Assert.assertTrue(ahp.PaymentsLink().isDisplayed());
				Assert.assertTrue(ahp.FaxesLink().isDisplayed());
				//Assert.assertTrue(ahp.LinksLink().isDisplayed());
				Assert.assertTrue(ahp.AdminOnlyLink().isDisplayed());
				Assert.assertTrue(AdminPortalLogoutButton().isDisplayed());
				
				//Verify the number of links displayed on the side panel in Admin portal home page
				Assert.assertEquals(ahp.SidePanelLinksCount(), 7);
				
				//Verify the header and footer in admin portal home page
			
				Assert.assertTrue(ahp.AdminPortalConnectiverxHeaderImage().isDisplayed());
				Assert.assertEquals(ahp.AdminPortalWelcomeMessage().getText(), "Welcome kalyani siva");
				Assert.assertTrue(ahp.AdminPortalConnectiverxFooterImage().isDisplayed());
				Assert.assertTrue(ahp.AdminPortalHelpdeskMessage().isDisplayed());
				Assert.assertTrue(ahp.AdminPortalRightsReservedMessage().isDisplayed());
				
				//reporting
				if(ahp.PatientsLink().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify content of Admin portal home page","Succesfully able to Verify content of Admin portal home page");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify content of Admin portal home page","Failed to Verify content of Admin portal home page");
				}
				
				AdminPortalLogout();
			}
		}
	

