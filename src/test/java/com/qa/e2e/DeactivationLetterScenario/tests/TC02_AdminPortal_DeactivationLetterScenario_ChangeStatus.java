package com.qa.e2e.DeactivationLetterScenario.tests;

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
import com.juno.qa.pages.AdminPortal_PG_BO_FaxesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_BenefitsHisoryTabPage;
import com.juno.qa.pages.AdminPortal_Patients_EligibilityAndSurvey;
import com.juno.qa.pages.AdminPortal_Patients_HelpDeskNotesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_InsuranceTabPage;
import com.juno.qa.pages.AdminPortal_Patients_MessagesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PaymentsTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TransactionsTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsListTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.pages.ProviderPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.*;
import org.openqa.selenium.support.ui.Select;

//this is to collect all the locator information for search patient page


@Listeners(TestNGListner.class)
public class TC02_AdminPortal_DeactivationLetterScenario_ChangeStatus extends AdminPortalLoginLogoutPage{
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderPage abc= new ProviderPage();
	PatientPage abd=new PatientPage();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Patients_InsuranceTabPage aty= new AdminPortal_Patients_InsuranceTabPage();
	AdminPortal_Patients_TreatmentsPage afg= new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Patients_ProviderTabPage afh= new AdminPortal_Patients_ProviderTabPage();
	AdminPortal_Patients_TreatmentsListTabPage afi= new AdminPortal_Patients_TreatmentsListTabPage();
	AdminPortal_Patients_TransactionsTabPage afj= new AdminPortal_Patients_TransactionsTabPage();
	AdminPortal_Patients_PaymentsTabPage afk= new AdminPortal_Patients_PaymentsTabPage();
	AdminPortal_PG_BO_FaxesTabPage afl= new AdminPortal_PG_BO_FaxesTabPage();
	AdminPortal_Patients_MessagesTabPage afm= new AdminPortal_Patients_MessagesTabPage();
	AdminPortal_Patients_EligibilityAndSurvey afn= new AdminPortal_Patients_EligibilityAndSurvey();
	AdminPortal_Patients_BenefitsHisoryTabPage afo= new AdminPortal_Patients_BenefitsHisoryTabPage();
	AdminPortal_Patients_HelpDeskNotesTabPage afp= new AdminPortal_Patients_HelpDeskNotesTabPage();
	AdminPortal_Patients_InsuranceTabPage yui=new AdminPortal_Patients_InsuranceTabPage();
	
	//AdminPortal_Providers_FindPage app = new AdminPortal_Providers_FindPage();
	//AdminPortal_Providers_PhysicianAndCardInfoTabPage apc = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	
	//Regression excel sheet
	String Key = "SmokePatientEnrollment";
	
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
			TestBase.classAInstance.logReport("Pass", "Deactivation letter scenario", "Succesfully upload Fax for Deactivation letter scenario");
			} else {
			TestBase.classAInstance.logReport("Fail", "Deactivation letter scenario", "Failed to upload Fax for Deactivation letter scenario");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	
	
	@Test ( description = "Verify the Search Provider")
	public void SearchPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider  
		System.out.println("The testdata is:" +testData);
		abd.PatientsLink().click(); //Click on  Patient link
		abd.SearchPatient().click(); //Click on search Patient link
		Thread.sleep(9000);
		//abd.PatientSearchShortCardID().sendKeys(testData.get(20));
		String abc= testData.get(20).trim();
		abd.PatientSearchShortCardID().sendKeys(abc);
		Thread.sleep(6000);
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		Thread.sleep(9000);
		
		 if (abd.PatientReview().isDisplayed()) {
				TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully verified the member ID in admin portal");
			} else {
				TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to verified the member ID in admin portal");
			}  
		abd.PatientReview().click(); //Click on Review button for 1st patient
		Thread.sleep(7000);
		
		abd.PatientStatus().selectByVisibleText("Inactive");
		abd.PatientAndCardTabUpdateButton().click();
		Thread.sleep(3000);
		String yuiyiu=abd.PatientAndCardTabUpdateConfirm().getText();
		
		
		
		if (abd.PatientAndCardTabUpdateConfirm().getText().equalsIgnoreCase("Patient Update Response: Success")) {
			TestBase.classAInstance.logReport("Pass", "Patient status-Inactive", "Succesfully changed the Patient status-Inactive:" +yuiyiu);
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient status-Inactive", "Failed to change the Patient status-Inactive");
		}  
	}		

}
