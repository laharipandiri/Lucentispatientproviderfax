package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubUploadEOBPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC32_AdminPortal_VerifyShipToAddressUpdate_CTM extends AdminPortalLoginLogoutPage {
	
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	HubUploadEOBPage hup = new HubUploadEOBPage();
	AdminPortal_Faxes_IncomingFindPage aif = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	HubHomeLoginLogoutPage eft = new HubHomeLoginLogoutPage();
	HubUploadEOBPage ryu = new HubUploadEOBPage();

	String Key = "ShipToAddressUpdateForCTM";
	String Key1 = "UploadDocumentCTP";
	String Key2 = "CTPPatientEnrollment";
	public static String PaymentAmount;

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

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


	@Test(description = "verify ship to address update")
	public void VerifyShipToAddressUpdate_CTM() throws InterruptedException, IOException, AWTException {
		// Take a patient who already is enrolled
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetShipToAddressTestData(Key, rowNum);
		
		  
		  int rowNum2 = etd.getKeyValuePair(Key2); System.out.println("The rowNum is:"
		  + rowNum2); List<String> testData2 = new ArrayList<String>(); testData2 =
		  gst.E2ECTPRequiredFields(Key2, rowNum2); // Same method for all Provider
		  System.out.println("testdata1 is:" + testData2);
		  
		  eft.HCPLogin(); System.out.println("HCP login done"); Thread.sleep(9000);
		  
		  eft.SearchByMemberID().sendKeys(testData2.get(20).trim());
		  Thread.sleep(2000); eft.SearchButton().click();
		  System.out.println("Clicked on SearchButton"); Thread.sleep(9000); String
		  MemberID = eft.SearchButtonMemberId().getText();
		  System.out.println("Member ID:" + MemberID);
		  
		  // Write test data back to upload document test cases
		  System.out.println("The Key is:" + Key1); int rowNum1 =
		  etd.getKeyValuePair(Key1); System.out.println("The rowNum is:" + rowNum1);
		  List<String> testData1 = new ArrayList<String>(); testData1 =
		  gst.E2ECTPRequiredFields(Key1, rowNum1); // Same method for all Provider
		  System.out.println("testdata is:" + testData1);
		  
		  gst.setMemberIDInExcel_E2ECTP(Key1, MemberID, rowNum2); // Writing back themember ID in excel 
		  eft.UploadDocumentLink().click(); Thread.sleep(10000);
		  gst.setMemberIDInExcel(Key1, MemberID, rowNum2);
		  System.out.println("I am above to click Document type");
		  eft.DocumentType().click();
		  System.out.println("I already clicked Document type"); Thread.sleep(10000);
		  eft.DocumentUploadBrowse().click(); Thread.sleep(10000); 
		  String FAXDocument =ryu.GetFilepath().getPath(); // click on file upload button and select file
		  // Setting clipboard with file location 
		  setClipboardData(FAXDocument); //native key strokes for CTRL, V and ENTER keys 
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  System.out.println("File has been uploaded");
		  
		  Thread.sleep(3000); eft.DocumentUploadSubmit().click(); Thread.sleep(4000);
		  String tyu = eft.DocumentUploadSubmitNumber().getText();
		  System.out.println("Document upload number:" + tyu);
		  System.out.println("The uploaded document reference number is:" + tyu);
		 
		closeBrowser();

		// First upload EOB and then add the fax
		// Upload EOB
		// Assert.assertTrue(hup.UploadEOB(testData.get(1), testData.get(2),
		// testData.get(0), "Drug Reimbursement"));
		// Add Fax
		intializeAdminDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		//wait.until(ExpectedConditions.visibilityOf(aif.MemberID()));
		aif.EnrollFromDate().clear();
		aif.EnrollFromDate().sendKeys("2021-01-13");
		aif.CardID().sendKeys("EYE00044690");
		aif.FaxesPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(aif.PatientReviewLinkFirstRow()));
		aif.PatientReviewLinkFirstRow().click();

		if (aip.IncomingFaxCardID().getAttribute("value").isEmpty()) {
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		} else {
			aip.IncomingFaxCardID().clear();
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		}

		apt.AddFaxInformationAndTreatmentForShipToUpdate(testData, "CTM", Key, "Drug Reimbursement");

		// make sure that the treatment has been added succesfully
		//Assert.assertTrue(apt.TreatementAddConfirmation().isDisplayed());


		AdminPortalLogout();
		//CloseBrowser();
	}
	
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

}