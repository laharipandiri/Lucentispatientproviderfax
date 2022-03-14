package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC25_AdminPortal_TreatmentsTab_VerifyDOSAndEOBDateFieldsWithNonNumericCharsTest extends AdminPortalLoginLogoutPage {

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	
	CommonFunctions cf = new CommonFunctions();
	
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
	@Test ( description = "Verify the DOS & EOB date fields do not accept non-numeric chars")
	public void VerifyDOSAndEOBNotAcceptNonNumeric() throws InterruptedException, IOException, AWTException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			
		ahp.PatientsLink().click();
		wait.until(ExpectedConditions.visibilityOf(ahp.FindLink()));
		
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys("EYE00000002");
		app.PatientsPageFindButton().click();
		Thread.sleep(60000);
		//Assert.assertTrue((driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr")).isDisplayed()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Now click on Treatments tab to get the retro period and calculate DateOfService
		atp.TreatmentsTabOption().click();
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.visibilityOf(atp.AddButton()));
		
		atp.DateOfService().sendKeys("abc$#^%");
		
		boolean dosValue = cf.getTextofInputBox(By.id("date_of_service_1"));
		//reporting
		if(dosValue)
		{
			TestBase.classAInstance.logReport("Pass","DOS date field do not accept non-numeric chars","Succesfully able to  Verify DOS date field do not accept non-numeric chars");
        }
	     else
  	     {
	    	TestBase.classAInstance.logReport("Fail","DOS date field do not accept non-numeric chars","Failed to  Verify DOS date field do not accept non-numeric chars");
	     } 
		
		atp.EOBDate().sendKeys("abc$#^%");
		//reporting
		boolean eobValue = cf.getTextofInputBox(By.id("eob_date"));
	
		if(eobValue)
		{
			TestBase.classAInstance.logReport("Pass","EOB date field do not accept non-numeric chars","Succesfully able to  Verify EOB date field do not accept non-numeric chars");
        }
	     else
  	     {
	    	TestBase.classAInstance.logReport("Fail","EOB date field do not accept non-numeric chars","Failed to  Verify EOB date field do not accept non-numeric chars");
	     } 
		
		AdminPortalLogout(); 
	}	
	
		
	
	

}
