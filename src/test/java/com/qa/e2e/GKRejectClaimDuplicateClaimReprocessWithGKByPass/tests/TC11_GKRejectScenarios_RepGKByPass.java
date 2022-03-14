package com.qa.e2e.GKRejectClaimDuplicateClaimReprocessWithGKByPass.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.dom.DOMDocument;
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
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsListTabPage;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC11_GKRejectScenarios_RepGKByPass extends AdminPortalLoginLogoutPage {
	
	TestUtil testutil;
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	AdminPortal_Faxes_IncomingFindPage afp = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Patients_TreatmentsListTabPage ptl = new AdminPortal_Patients_TreatmentsListTabPage();
	PatientPage abd=new PatientPage();
	
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetname = "E2EScenarios";
//	String Key0 = "SmokePatientEnrollment";
	String Key = "FaxAndTreatmentUpdated";
	
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
//		if(result.getStatus()== ITestResult.SUCCESS){
//			TestBase.classAInstance.logReport("Pass", "E2E CTP Lucentis Enrollment Patient", "Succesfully enrolled a patient");
//			} else {
//			TestBase.classAInstance.logReport("Fail", "E2E CTP Lucentis Enrollment Patient", "Failed to enrolled a patient");
//			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify adding Incoming Fax")
	public void AddIncomingFaxAndTreatment() throws InterruptedException, IOException, AWTException
	{
		//String enrollFromDate = "10-Jan-2020";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		Thread.sleep(2000);
		
		Thread.sleep(9000);
		

		System.out.println("I am inside enrollment");
		String Key1 = "SmokePatientEnrollment";
		System.out.println("The Key is:" +Key1);
		int rowNum1 = etd.getKeyValuePair(Key1);
		System.out.println("The rowNum is:" +rowNum1);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.SmokeGetPhysicianNewPageRequiredFields(Key1, rowNum1); //Same method for all Provider
		System.out.println("testdata1 is:" +testData1);
		
		System.out.println("CardID is:" +testData1.get(20).trim());
        String CardID=testData1.get(20).trim();
        Thread.sleep(8000);
        
        abd.PatientsLink().click(); //Click on  Patient link
		Thread.sleep(9000);
		abd.SearchPatient().click(); //Click on search Patient link
		abd.PatientSearchShortCardID().sendKeys(CardID);
		abd.PatientSearch().click(); //Click on Search button on Patient page
		
		Thread.sleep(40000);
		abd.PatientReview().click(); //Click on Review button for 1st patient
        
        
        
        //verify that the status is accepted in the grid after adding a treatment
          ptl.TreatmentsListTab().click();
        Thread.sleep(5000);
        ptl.TreatmentsListShowTreatmentInfo().click();
        Thread.sleep(8000);
        
        
        ptl.TreatmentsListReprocesWithGKByPass().click();
        
        js.executeScript("window.scrollBy(150,750)", "");
        
        if( ptl.TreatmentsListReprocesWithGKByPassNote().isDisplayed())
        {
        	TestBase.classAInstance.logReport("Pass","GK reject Treatment-Reprocess GK By Pass","Succesfully Verify Reprocess GK By Pass");
 		}
 	   else
 	   {
 		    TestBase.classAInstance.logReport("Fail","GK reject Treatment-Reprocess GK By Pass","Failed to Verify Reprocess GK By Pass");
 	   }	
        
        ptl.TreatmentsListReprocesWithGKByPassNote().sendKeys("Automation");
        ptl.TreatmentsListReprocesWithGKByPassSubmit().click();
        Thread.sleep(8000);
        
        String uru= ptl.TreatmentsListReprocesWithGKByPassConfirmationMsg().getText();
        System.out.println("%%%%%%%" +uru);

//	   String tru= ptl.TreatmentsListGKRejectReason().getText();
//       System.out.println("%%%%%%%" +tru);
//       
////        scroll down to capture the screenshot at the correct location
      
//	   
//	   
       // AdminPortalLogout();
		
		
	}
	
}
