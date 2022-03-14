package com.qa.regression.adminportal.patients.tests;


import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebElement;
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
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_InsuranceTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
//import com.juno.qa.smoke.tests.TC01_JunoWorkflow_HubEnrollPatientTestX;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

//Verify Patient and Card tab and Insurance tab information after enrollment in DrugReimbursement
@Listeners(TestNGListner.class)
public class TC02_AdminPortal_VerifyPatientAndInsuranceInfoAfterEnrollmentTest extends AdminPortalLoginLogoutPage {


	TestUtil testUtil;
	
	//String Key = "EnrollPatient";
	String Key = "SmokePatientEnrollment";
	//String Key1 = "EnrollAdminReimbursementPatient";
//	String sheetname = "Smoke";
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_InsuranceTabPage aip = new AdminPortal_Patients_InsuranceTabPage();

	HubHomePage hhp=new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();
	PatientPage abd=new PatientPage();
	
	

//	 Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	@BeforeMethod
	public void OpenBrowser() {
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

	
	@Test(groups = {"Patients"},description = "Verify Patient and Card tab and Insurance tab information after enrollment in DrugReimbursement")
	public void VeriftPatientCardAndInsuranceAfterEnrollment_DrugReimbursement() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(alp.AdminPortalLogoutButton()));
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		//wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageMemberID())); //updated for Replatform as there is no member ID
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageCardID())); 
		
		int rowNum = etd.getKeyValuePair(Key);
		
		List<String> testData = new ArrayList<String>();
		//testData = gst.GetPatientAndInsuranceInfoTestData(Key, rowNum);
		testData = gst.GetAdminPagesLinksTestData(Key, rowNum);
		
		System.out.println("The testdata is:" +testData);
		Thread.sleep(4000);
		System.out.println("The Card ID excel data is:" +testData.get(0));
		abd.NewPatientStatus().selectByVisibleText("ALL");
		abd.PatientSearchShortCardID().sendKeys(testData.get(20).trim());//CardID	
		abd.PatientSearchShortCardID().click();
		
		abd.PatientSearch().click(); //Click on Search button on Patient page 
		Thread.sleep(50000);
			//wait.until(ExpectedConditions.visibilityOf(app.PatientsFindReviewButton()));
			
			app.PatientsFindReviewButton().click();
			
			Assert.assertTrue(apc.PatientAndCardTab().isDisplayed());
			
			//Now get all the fields values from UI and cross check with the excel data after enrolling a patient
			
			try
			{
				apc.VerifyInfoInPatientAndCardTab(testData);
				//Assert.assertTrue(apc.PatientAndCardTabMemberIDValue().equalsIgnoreCase(testData.get(0)));
				
			}
			
			catch(IOException ie)
			{
				
			}
			catch(AWTException awt)
			{
				
			}
			
			
			AdminPortalLogout();
		
	
		
	} 
	
	
}
