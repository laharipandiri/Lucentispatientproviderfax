package com.qa.e2e.CTPWorkflow.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.E2EWorkflow_TestData;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.E2EWorkflowPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class New_TC07_CTP_VerifyClaimStatusAfterTreatmentInAdmin extends AdminPortalLoginLogoutPage {
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd= new ExcelTestDataReader();
	E2EWorkflow_TestData eet = new E2EWorkflow_TestData();
	
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage apf = new AdminPortal_Patients_FindPage();
	E2EWorkflowPage efe = new E2EWorkflowPage();
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String Key = "StatusBeforePaymentApproval";
	
	
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
	
	@Test ( description = "Verify claim and payment status in Admin portal before Payment approval in transaction tab,payment tab, benefit history tab and payment check list")
	public void VerifyClaimAndPaymentStatusBeforePaymentApprovalInAdminPortal() throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
		
		int rowNum = etd.getKeyValuePair(Key); 
		
		//get the memberID row and colnum from smoke sheet
		List<Integer> existingRCnum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "CardID");
		//copy the memberid to the e2e sheet
		String CardID = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusBeforePaymentApproval", "Smoke", "e2e", existingRCnum.get(1), existingRCnum.get(0), rowNum, "MemberID");
		
		List<Integer> existingCopayRCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "Copay");
		String AmountInDollars = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusBeforePaymentApproval", "Smoke", "e2e", existingCopayRCNum.get(1), existingCopayRCNum.get(0), rowNum, "TransactionAmountIn$");

		double finalCopay = Double.parseDouble(AmountInDollars)-5.0;
		reader.setDataInNewRow("e2e", "TransactionAmountIn$", rowNum, String.valueOf(finalCopay));
		
		List<Integer> existingDOSRCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "DateOfService");
		String DOS = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusBeforePaymentApproval", "Smoke", "e2e", existingDOSRCNum.get(1), existingDOSRCNum.get(0), rowNum, "DOS");
		System.out.println("The DOS is:" +DOS);
		
		List<Integer> existingBORCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "BillingProviderName");
		String BO = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusBeforePaymentApproval", "Smoke", "e2e", existingBORCNum.get(1), existingBORCNum.get(0), rowNum, "BillingProviderName");
		System.out.println("The BO is:" +BO);

		List<Integer> existingClaimIDRCNum = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "ClaimID");
		String ClaimID = gst.copyValueToDiffRowAndDiffSheet("FaxAndTreatment", "StatusBeforePaymentApproval", "Smoke", "e2e", existingClaimIDRCNum.get(1), existingClaimIDRCNum.get(0), rowNum, "ClaimID");
		System.out.println("The ClaimID is:" +ClaimID);
		
		//click on patients link
		ahp.PatientsLink().click();
		wait.until(ExpectedConditions.visibilityOf(ahp.FindLink()));
		
		//click on find link in the patients drop down
		ahp.FindLink().click();
		//wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageMemberID()));
		Thread.sleep(3000);
		
//		String CardID = "";
		CardID = app.MemberIDSearchInAdminPortal(CardID);	
		
		reader.setDataInNewRow("e2e", "CardID", rowNum, CardID); 
		
		List<String> testData = new ArrayList<String>();
		testData = eet.GetStatusBeforePaymentApprovalData(Key, rowNum);
		System.out.println("The testdata is:" +testData);
		
		try {
				Assert.assertTrue(efe.VerifyStatusAcrossPagesBeforePaymentApprovalInAdminPortal(testData, "CTP"));
				boolean toy=(efe.VerifyStatusAcrossPagesBeforePaymentApprovalInAdminPortal(testData, "CTP"));
				if(toy == true)
				{
					TestBase.classAInstance.logReport("Pass","Claim Status After Treatment In Admin","Succesfully verified Claim Status After Treatment In Admin");
			     }
			     else
			     {
			    	TestBase.classAInstance.logReport("Fail","Claim Status After Treatment In Admin","verified Claim Status After Treatment In Admin");
			     }
		}
		catch(InterruptedException e)
		{
			
		}
		
		AdminPortalLogout();
		
		
	}

}
