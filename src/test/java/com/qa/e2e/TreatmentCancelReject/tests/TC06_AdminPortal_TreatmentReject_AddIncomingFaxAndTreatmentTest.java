package com.qa.e2e.TreatmentCancelReject.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC06_AdminPortal_TreatmentReject_AddIncomingFaxAndTreatmentTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testutil;
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	AdminPortal_Faxes_IncomingFindPage afp = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Patients_TreatmentsListTabPage ptl = new AdminPortal_Patients_TreatmentsListTabPage();
	
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetname = "Smoke";
	String Key0 = "SmokePatientEnrollment";
	String Key = "FaxAndTreatment";
	String Key1 = "EnrollPatient";
	String Key2 = "SearchEnrolledPatient";
	String Key3 = "CTMData";
	String Key4 = "StatusBeforePaymentApproval";
	String Key5 = "PaymentsInBOBeforePaymentApproval";
	String Key6 = "PaymentsInBOAfterPaymentApproval";
	String Key7 = "PaymentsInBOAfterCheckAll";
	String Key8 = "PaymentsInBOAfterCheckClear";
 
	
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
	public void CloseBrowser()
	{
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
		
		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		wait.until(ExpectedConditions.visibilityOf(afp.EnrollFromDate()));
		Thread.sleep(2000);
		
		int rowNum = etd.getKeyValuePair(Key);
		
		String[] newColName = {"MemberID","PatientFirstName", "PartnerPatientID", "CardID"};
		List<Integer> rcNum = new ArrayList<Integer>();
		//rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[0]);//get MemberID row & col from original row
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key, sheetname, newColName[0]);//get MemberID row & col from original row
		
		String MemberID = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[0], "Smoke");
		rcNum.clear();//Remove elements from the list
		
		
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[1]);//get PatientFirstName row & col from original row
		String PatientFirstName = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[1], "Smoke");
		rcNum.clear();
		
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[2]);
		String PartnerPatientID = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[2], "Smoke");
		rcNum.clear();
		
//		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key0, sheetname, newColName[3]);
//		System.out.println("The rcNum is:" +rcNum);
//		//This cardID is from the recently enrolled patient. If there is a req. that an adhoc fax and treatment needs to be added for a cardID, we need t come up with diff test
//		String CardID = gst.copyValueToDiffRow(Key0, rcNum.get(1), rcNum.get(0), rowNum, newColName[3], "Smoke");

		
		System.out.println("I am inside enrollment");
		String Key1 = "SmokePatientEnrollment";
		System.out.println("The Key is:" +Key1);
		int rowNum1 = etd.getKeyValuePair(Key1);
		System.out.println("The rowNum is:" +rowNum1);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.SmokeGetPhysicianNewPageRequiredFields(Key1, rowNum1); //Same method for all Provider
		System.out.println("testdata1 is:" +testData1);
		
 		
 		//afp.CardID().sendKeys(testData1.get(20).trim());
		System.out.println("CardID is:" +testData1.get(20).trim());
         String CardID=testData1.get(20).trim();
//        afp.FaxesPageFindButton().click();
        Thread.sleep(8000);
        
        //capture the fax id and put it in the before and after approval test data
//        String faxID = afp.FirstFaxIDInGrid().getText();
//        int row = etd.getKeyValuePair("StatusBeforePaymentApproval");
//        int row1 = etd.getKeyValuePair("StatusAfterCheckClear");
//        int row2 = etd.getKeyValuePair("StatusAfterCheckAll");
//        int row3 = etd.getKeyValuePair("StatusAfterPaymentApproval");
//        reader.setDataInNewRow("e2e", "FaxID", row, faxID);
//        reader.setDataInNewRow("e2e", "FaxID", row1, faxID);
//        reader.setDataInNewRow("e2e", "FaxID", row2, faxID);
//        reader.setDataInNewRow("e2e", "FaxID", row3, faxID);
         
        //click on review link on the first search result
        afp.PatientReviewLinkFirstRow().click();
        Thread.sleep(4000);
        
        if(aip.IncomingFaxCardID().getAttribute("value").isEmpty())
 		{
 			aip.IncomingFaxCardID().sendKeys(CardID);
 		}
 		else
 		{
 			aip.IncomingFaxCardID().clear();
 			aip.IncomingFaxCardID().sendKeys(CardID);
 		}
        
        if(aip.IncomingFaxCardID().isDisplayed())
        {
        	TestBase.classAInstance.logReport("Pass","Add Fax and Treatment","Succesfully entered Card ID in fax incoming screen");
		}
	   else
	   {
		    TestBase.classAInstance.logReport("Fail","Add Fax and Treatment","Failed to enter Card ID in fax incoming screen");
	   }	
      
 		Thread.sleep(5000);
 		System.out.println("IncomingFaxMemberID"+aip.IncomingFaxMemberID().getAttribute("value"));
 		List<String> testData = new ArrayList<String>();
 		testData = gst.GetFaxAndTreatmentTestData(Key,rowNum);
 		System.out.println("GetFaxAndTreatmentTestData test data are:" +testData );
 		atp.RejectTreatmentAddFaxInformationAndTreatmentToEnrolledPatients(testData, rowNum, "CTM");
 		
 		
 		

        //scroll down to capture the screenshot at the correct location
     //   js.executeScript("window.scrollBy(0,350)", "");
        //Reporting
 		
 		String trp= "Select a Reject Reason\nMaximum Benefit Reached\nDuplicate claim\nNo Patient Responsibility\nNo Eligible Charges\nTimely Filing\nGovernment Payer\nMissing Info EOB\nMissing Info Check Request Form\nPrimary Payer Denial\nDOS outside eligibility Period\nMissing Info Claim Form Provider\nMissing info Patient Receipt";
 		
 		String iop= atp.TreatmentStatusRejectOptions().getText();
        if(atp.TreatmentStatusRejectOptions().getText().equalsIgnoreCase(trp))
        {
        	TestBase.classAInstance.logReport("Pass","Treatment Reject options","Succesfully able to verify Treatment Reject options:" +trp +iop);
		}
	   else
	   {
		    TestBase.classAInstance.logReport("Fail","Treatment Reject options","Failed to verify Treatment Reject options:" +trp +iop);
	   }	
      
       // AdminPortalLogout();
		
		
	}
	
}
