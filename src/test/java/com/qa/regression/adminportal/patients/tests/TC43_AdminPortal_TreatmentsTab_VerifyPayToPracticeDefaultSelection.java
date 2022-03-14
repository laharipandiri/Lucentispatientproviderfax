package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;

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
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC43_AdminPortal_TreatmentsTab_VerifyPayToPracticeDefaultSelection extends AdminPortalLoginLogoutPage {
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	

	
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
	@Test ( description = "Verify that Pay To Practice radio button is selected by default")
	public void VerifyPayToPracticeRadioButtonDefaultSelectionInTreatmentsTabForPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
			AdminPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
			app.PatientsFindPageCardID().sendKeys("EYE00000002");
			app.PatientsPageFindButton().click();
			Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
			
			//Go to treatments tab
			atp.TreatmentsTabOption().click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(atp.PracticeRadioButton()));
			
			Assert.assertTrue(atp.PracticeRadioButton().isSelected());
			
			//reporting
			 js.executeScript("window.scrollBy(0,1000)", "");
			
			AdminPortalLogout();
		}	

}
