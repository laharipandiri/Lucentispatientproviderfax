package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NewPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;


@Listeners(TestNGListner.class)
public class TC31_AdminPortal_TreatmentsTab_VerifyAddNewBillingOfficeLink extends AdminPortalLoginLogoutPage {

	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_PG_BO_NewPage apb = new AdminPortal_PG_BO_NewPage();
	

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
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestBase.classAInstance.logReport(testStatusRef.get(result.getStatus()),
					result.getMethod().getDescription(),
					"Succesfully able to " + result.getMethod().getDescription());
		} else {
			result.getThrowable().printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			TestBase.classAInstance.logReport(testStatusRef.get(result.getStatus()),
					result.getMethod().getDescription(), "Failed to " + result.getMethod().getDescription());
		}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the Add New Billing Office Link in treatments tab for a patient")
	public void VerifyAddNewBOLinkInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsPageFindButton().click();
		Thread.sleep(40000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to treatments tab
		atp.TreatmentsTabOption().click();
		Thread.sleep(25000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		String currentTab = driver.getWindowHandle();
		
		//click on the Add New Billing Office Link
		atp.AddNewBillingOfficeLink().click();
		
		 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 newTab.remove(currentTab);
		 // change focus to new tab
		 driver.switchTo().window(newTab.get(0));
		 Assert.assertTrue(driver.getCurrentUrl().contains("https://xbbadmin.connectiverx-qa.com/provider-add/new/13/?patient_id=114&program_id=1"));
		 Assert.assertEquals(apb.BONewProviderType().getFirstSelectedOption().getText(), "Select a Provider Type");
		 
		//reporting
		if(driver.getCurrentUrl().contains("https://xbbadmin.connectiverx-qa.com/provider-add/new/13/?patient_id=114&program_id=1"))
		{
			TestBase.classAInstance.logReport("Pass","Add New Billing Office Link in treatments tab for a patient","Succesfully able to  Verify Add New Billing Office Link in treatments tab for a patient");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Add New Billing Office Link in treatments tab for a patient","Failed able to  Verify Add New Billing Office Link in treatments tab for a patient");
		}	
			
		 // Do what you want here, you are in the new tab

	     driver.close();
		 // change focus back to old tab
		 driver.switchTo().window(currentTab);
		    
		AdminPortalLogout();
	}		
		
	/*
	@Test ( description = "Verify the Add New Billing Office Link in treatments tab for a patient for Both type enrollment", enabled = false)
	public void VerifyAddNewBOLinkInTreatmentsTabForPatient_BothTypeEnrollment() throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for(int i=1; i<=2; i++)
		{
			if(i==1)
			{
				AdminPortalLogin();
			}
			else
			{
				AdminReimbursementPortalLogin();
			}
			
			wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			if(i==1)
			{
				app.PatientsFindPageMemberID().sendKeys("09552025196");
			}
			else if(i==2)
			{
				app.PatientsFindPageMemberID().sendKeys("49520276020");
			}
			app.PatientsPageFindButton().click();
			wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
			
			//Go to treatments tab
			atp.TreatmentsTabOption().click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
			
			String currentTab = driver.getWindowHandle();
			
			//click on the Add New Billing Office Link
			atp.AddNewBillingOfficeLink().click();
			
			 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			 newTab.remove(currentTab);
			 // change focus to new tab
			 driver.switchTo().window(newTab.get(0));
			 Assert.assertTrue(driver.getCurrentUrl().contains("https://wb-admin-qa.crxcopay.com/provider-add/new"));
			 Assert.assertEquals(apb.BONewProviderType().getFirstSelectedOption().getText(), "Billing Office");
			 
			//reporting
			if(driver.getCurrentUrl().contains("https://wb-admin-qa.crxcopay.com/provider-add/new"))
			{
				TestBase.classAInstance.logReport("Pass","Add New Billing Office Link in treatments tab for a patient","Succesfully able to  Verify Add New Billing Office Link in treatments tab for a patient");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Add New Billing Office Link in treatments tab for a patient","Failed able to  Verify Add New Billing Office Link in treatments tab for a patient");
			}	
				
			 // Do what you want here, you are in the new tab

		     driver.close();
			 // change focus back to old tab
			 driver.switchTo().window(currentTab);
			    
			AdminPortalLogout();
		}
		
		
		
		
		
	}
*/
}
