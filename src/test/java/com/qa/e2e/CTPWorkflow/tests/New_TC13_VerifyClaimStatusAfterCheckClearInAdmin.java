package com.qa.e2e.CTPWorkflow.tests;

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
import com.juno.qa.getandsetTestData.E2EWorkflow_TestData;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
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
import com.juno.qa.pages.E2EWorkflowPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.pages.ProviderPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.*;

//this is to collect all the locator information for search patient page


@Listeners(TestNGListner.class)
public class New_TC13_VerifyClaimStatusAfterCheckClearInAdmin extends AdminPortalLoginLogoutPage{
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderPage abc= new ProviderPage();
	PatientPage abd=new PatientPage();
	E2EWorkflow_TestData eet = new E2EWorkflow_TestData();
	E2EWorkflowPage efe = new E2EWorkflowPage();
	
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
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	//AdminPortal_Providers_FindPage app = new AdminPortal_Providers_FindPage();
	//AdminPortal_Providers_PhysicianAndCardInfoTabPage apc = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	
	//Regression excel sheet
	String Key = "StatusAfterCheckClear";
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			Thread.sleep(40000);
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			}
			catch(InterruptedException e) {
				
			}
	} 
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "E2E CTP Lucentis Enrollment Patient verified in admin", "Succesfully verified in  enrolled patient in admin");
			} else {
			TestBase.classAInstance.logReport("Fail", "E2E CTP Lucentis Enrollment Patient verified in admin", "Failed verified in  enrolled patient in admin");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	
	@Test ( description = "Verify the Search Provider")
	public void SearchPatient() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
		
		int rowNum = etd.getKeyValuePair(Key); 
		
		//get the memberID row and colnum from smoke sheet
		List<Integer> existingRCnum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "CardID");
		//copy the memberid to the e2e sheet
//		String MemberID = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingRCnum.get(1), existingRCnum.get(0), rowNum, "MemberID");
		String CardID = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingRCnum.get(1), existingRCnum.get(0), rowNum, "MemberID");
		
		
		//get the copay row and colnum from smoke sheet
		List<Integer> existingRCnumForCopay = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "Copay");
		//copy the memberid to the e2e sheet
		String copay = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingRCnumForCopay.get(1), existingRCnumForCopay.get(0), rowNum, "TotalUsage");

		double finalCopay = Double.parseDouble(copay)-5.0;
		reader.setDataInNewRow("e2e", "TransactionAmountIn$", rowNum, String.valueOf(finalCopay));
		
		List<Integer> existingDOSRCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "DateOfService");
		String DOS = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingDOSRCNum.get(1), existingDOSRCNum.get(0), rowNum, "DOS");
		
		List<Integer> existingBORCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "BillingProviderName");
		String BO = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingBORCNum.get(1), existingBORCNum.get(0), rowNum, "BillingProviderName");
			
		List<Integer> existingClaimIDRCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "ClaimID");
		String ClaimID = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusAfterCheckClear", "Smoke", "e2e", existingClaimIDRCNum.get(1), existingClaimIDRCNum.get(0), rowNum, "ClaimID");
		
		
		
		
		abd.PatientsLink().click(); //Click on  Patient link
		//abd.SearchPatient().click(); //Click on search Patient link
		ahp.FindLink().click();
//		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageMemberID()));
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageCardID()));
		Thread.sleep(9000);
		 if (app.PatientsFindPageCardID().isDisplayed()) {
				TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully verified the member ID in admin portal");
			} else {
				TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to verified the member ID in admin portal");
			}  
		
		CardID = app.MemberIDSearchInAdminPortal(CardID);	
		System.out.println("CardID is $$$$" +CardID);
		
		reader.setDataInNewRow("e2e", "CardID", rowNum, CardID); 
		
		List<String> testData = new ArrayList<String>();
		testData = eet.GetStatusAfterCheckClearData(Key, rowNum);
		System.out.println("Testdata is:" +testData);
		
		try {
				Assert.assertTrue(efe.VerifyStatusAcrossPagesAfterCheckClearInAdminPortal(testData, "CTM"));
				  
		}
		catch(InterruptedException e)
		{
			
		}
		
		AdminPortalLogout();
	}
		
	}		


