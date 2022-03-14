package com.Xolair.qa.smoke.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalAdminOnlyPage;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortalPaymentsPage;
import com.juno.qa.pages.AdminPortalProviderGroupsPage;
import com.juno.qa.pages.AdminPortalProvidersPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC11_AdminPortal_Verify_LinksPagesTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortalProvidersPage apr = new AdminPortalProvidersPage();
	AdminPortalProviderGroupsPage agp = new AdminPortalProviderGroupsPage();
	AdminPortalPaymentsPage pay = new AdminPortalPaymentsPage();
	AdminPortal_Faxes_IncomingFindPage apf = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortalAdminOnlyPage aap = new AdminPortalAdminOnlyPage();
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	GetAndSetTestData dat = new GetAndSetTestData();
	
	String sheetname = "Smoke";
	String Key = "AdminPagesLinks";
	
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
	
	@Test ( description = "Verify that the correct pages are displayed when the User clicks on the sub-links in the side panel")
	public void VerifySublinkPages() throws InterruptedException, IOException, AWTException
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
				
				int rowNum = etd.getKeyValuePair(Key);
				List<String> testData = new ArrayList<String>();
				testData = dat.GetAdminPagesLinksTestData(Key, rowNum);
				
		
				/* For each page the verification is done with 2 things.
				 *  #1: validate that the correct URL is getting loaded; 
				 *  #2: validate any one webelement
				 * This approach is taken because all the pages have same title and pretty much all the pages have most of the elements with same identifiers. 
				 * This combo should give unique verification	*/
				
				//Click on patients link and then select Search Patient and verify the URLs and one web-element
			/*	ahp.PatientsLink().click();
				Thread.sleep(2000);
				ahp.PatientSearch().click();
				Thread.sleep(2000);
				Assert.assertTrue(app.PatientsPageFindButton().isDisplayed());
				
				//reporting
				if(app.PatientsPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Patients Active link","Succesfully able to Verify Admin portal side panel Patients Active link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Patients Active link","Failed to Verify Admin portal side panel Patients Active link");
				}
									
				ahp.NewLink().click(); // Patient- New Enrollment
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(5));//PatientsNewLink 
				Assert.assertEquals(app.PatientsNewHubPortalText().getText(), testData.get(38));//PatientsNewPageHeading 
				//reporting
				if(app.PatientsNewHubPortalText().getText().equalsIgnoreCase(testData.get(38)))
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Patients new link","Succesfully able to Verify Admin portal side panel Patients new link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Patients new link","Failed to Verify Admin portal side panel Patients new link");
				}
				
				//Click on providers link and then select each sub-link and verify the URLs and one web-element
				ahp.ProvidersLink().click();
				Thread.sleep(2000);
				ahp.EnrollNewProvider().click();
				Thread.sleep(2000);
				Assert.assertTrue(apr.ProviderPhysicianNewPageAddButton().isDisplayed());
				//reporting
				if(apr.ProviderPhysicianNewPageAddButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Providers New link","Succesfully able to Verify Admin portal side panel Providers New link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Providers New link","Failed to Verify Admin portal side panel Providers New link");
				}
					
			
				ahp.ProvidersLink().click();
				Thread.sleep(2000);
				ahp.SearchProvider().click(); //Provider-Search Provider
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(10));//ProvidersFindLink 
				Assert.assertTrue(apr.ProvidersPageFindButton().isDisplayed());		
				//reporting
				if(apr.ProvidersPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Providers Find link","Succesfully able to Verify Admin portal side panel Providers Find link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Providers Find link","Failed to Verify Admin portal side panel Providers Find link");
				}
				
				
			
			// ********************************************************************************************************** 
				//Click on payments link and then select each sub-link and verify the URLs and one web-element
				ahp.PaymentsLink().click();
				Thread.sleep(2000);
				ahp.ChecksLink().click();
				ahp.ListLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(20));//PaymentsChecksList 
				Assert.assertTrue(pay.PaymentsPageFindButton().isDisplayed());
				//reporting
				if(pay.PaymentsPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Payments List link","Succesfully able to Verify Admin portal side panel Payments List link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Payments List link","Failed to Verify Admin portal side panel Payments List link");
				}
				
				ahp.RepaymentsLink().click();
				Thread.sleep(2000);
				ahp.ListLink().click();
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(21));//PaymentsRePaymentsListLink 
				Assert.assertTrue(pay.PaymentsPageFindButton().isDisplayed());
				//reporting
				if(pay.PaymentsPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel RePayments List link","Succesfully able to Verify Admin portal side panel RePayments List link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel RePayments List link","Failed to Verify Admin portal side panel RePayments List link");
				}
				
				ahp.RepaymentNewLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(22));//PaymentsRePaymentsNewLink 
				Assert.assertTrue(pay.PaymentsPageAddButton().isDisplayed());
				//reporting
				if(pay.PaymentsPageAddButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel RePayments New link","Succesfully able to Verify Admin portal side panel RePayments New link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel RePayments New link","Failed to Verify Admin portal side panel RePayments New link");
				}
				
				ahp.EFTLink().click();
				Thread.sleep(2000);
				ahp.ListLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(23));//PaymentsEFTListLink 
				Assert.assertTrue(pay.PaymentsPageFindButton().isDisplayed());
				//reporting
				if(pay.PaymentsPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel EFT List link","Succesfully able to Verify Admin portal side panel EFT List link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel EFT List link","Failed to Verify Admin portal side panel EFT List link");
				}
		
			// ********************************************************************************************************** 
				//Click on Faxes link and then select each sub-link and verify the URLs and one web-element
				ahp.FaxesLink().click();
				Thread.sleep(2000);
				ahp.IncomingFaxesLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(24));//FaxesIncoming 
				Assert.assertTrue(apf.FaxesPageFindButton().isDisplayed());
				//reporting
				if(apf.FaxesPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Incoming Faxes link","Succesfully able to Verify Admin portal side panel Incoming Faxes link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Incoming Faxes link","Failed to Verify Admin portal side panel Incoming Faxes link");
				}
				
				ahp.OutgoingFaxLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(25));//FaxesOutgoing 
				Assert.assertTrue(apf.FaxesPageFindButton().isDisplayed());
				//reporting
				if(apf.FaxesPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Outgoing Faxes link","Succesfully able to Verify Admin portal side panel Outgoing Faxes link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Outgoing Faxes link","Failed to Verify Admin portal side panel Outgoing Faxes link");
				}
				
				ahp.ListAllLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(26));//FaxesFind 
				Assert.assertTrue(apf.FaxesPageFindButton().isDisplayed());
				//reporting
				if(apf.FaxesPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Faxes ListAll link","Succesfully able to Verify Admin portal side panel Faxes ListAll link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Faxes ListAll link","Failed to Verify Admin portal side panel Faxes ListAll link");
				}
				
				ahp.AssignmentsLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(27));//FaxesAssignments 
				Assert.assertTrue(apf.FaxesPageFindButton().isDisplayed());
				//reporting
				if(apf.FaxesPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Assignments link","Succesfully able to Verify Admin portal side panel Assignments link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Assignments link","Failed to Verify Admin portal side panel Assignments link");
				}
				
				ahp.AssignmentRulesLink().click();
				Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(),testData.get(28));//FaxesAssignmentRules 
				Assert.assertTrue(apf.FaxesPageFindButton().isDisplayed());  
				//reporting
				if(apf.FaxesPageFindButton().isDisplayed())
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Assignment Rules link","Succesfully able to Verify Admin portal side panel Assignments Rules link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Assignments Rules link","Failed to Verify Admin portal side panel Assignments Rules link");
				}
					
			*/	
					
				//Click on Admin only link and then select each sub-link and verify the URLs and one web-element
				ahp.AdminOnlyLink().click();
				Thread.sleep(2000);
				ahp.HelpDeskLink().click();
				Thread.sleep(2000);
				//ahp.AdminListLink().click();
				Assert.assertEquals(ahp.GetCurrentURL(), testData.get(30));//AdminHelpdeskAdminListLink 
				//Assert.assertEquals(aap.AdminOnlyGridLabel().getText(), testData.get(42).trim());//AdminOnlyPageGridLabel 
				//reporting
				if(ahp.GetCurrentURL().equalsIgnoreCase(testData.get(30).trim()))
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Admin List link","Succesfully able to Verify Admin portal side panel Admin List link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Admin List link","Failed to Verify Admin portal side panel Admin List link");
				}
				
				
				
			// ******************************************************************************************************************************	
			
		   
			  //Click on Logout link and verify that it goes to Admin portal's login page
			  	AdminPortalLogoutButton().click();
			  	Thread.sleep(2000);
				Assert.assertEquals(ahp.GetCurrentURL(), testData.get(37));//AdminPortalLoginLink 
				//reporting
				if(ahp.GetCurrentURL().equalsIgnoreCase(testData.get(37)))
		        {
		        	TestBase.classAInstance.logReport("Pass","Verify Admin portal side panel Logout Link","Succesfully able to Verify Admin portal side panel Logout Link");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Verify Admin portal side panel Logout Link","Failed to Verify Admin portal side panel Logout Link");
				}
			}
		}

	
		


