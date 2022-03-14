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
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.Patients_Match;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_MatchPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC29_AdminPortal_TreatmentsTab_VerifyBOAvailabilityInDropdown extends HubHomeLoginLogoutPage {

	String Key = "EnrollPatient";
	String Key1 = "MatchBOWithPatient";
	String Key2 = "EnrollAdminReimbursementPatient";
	String Key3 = "EnrollBothTypePatient";
	
	HubHomePage hhp=new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd= new ExcelTestDataReader();
	AdminPortalLoginLogoutPage all = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage app = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_MatchPage apm = new AdminPortal_Patients_MatchPage();
	AdminPortal_Patients_PatientAndCardTabPage ppc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	Patients_Match dat = new Patients_Match();
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			intializePatientDriverPopUp();
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
	
	@Test(description = "Verify the availability of Primary BO after patient is matched with a BO ")
	public void verifyPrimaryBOAfterPatientMatchedWithBO_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);
		eft.LucentisEnrollInPateintPortal(); //Enroll Patient 
		String memberId = eft.GetFieldValueAfterEnrolment("Member ID");
		driver.quit();
		//Now log into Admin Portal and match the above enrolled patient to a BO
		try
		{
			intializeAdminDriver();
		}
		catch(InterruptedException ie)
		{
			
		}
		all.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPatientMatchWithBOTestData(Key1, rowNum1);
		testData.set(0, memberId);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageMemberID()));
		app.PatientsFindPageMemberID().sendKeys(testData.get(0));
		app.PatientsPageFindButton().click();
		//wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		//click on match link
		app.PatientsFindFirstMatchButton().click();
		//User should be navigated to Patient Information, Provider information tables with 'ASSIGN' button at the bottom of the page.

		try
		{
			//BO as ProviderType and by ProviderName for autosuggest
			Assert.assertTrue(apm.VerifyAbilityToMatchProviderWithPatientAndBOAvailableInTreatmentsTab(testData, testData.get(12)));
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		all.AdminPortalLogout();
			
	} 

}
