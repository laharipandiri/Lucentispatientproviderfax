package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
import com.juno.qa.getandsetTestData.Patients_TreatmentsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.pages.AdminPortal_Patients_MessagesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsListTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.pages.HubUploadEOBPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC44_AdminPortal_TreatmentsTab_VerifyClaimCreationF extends HubHomeLoginLogoutPage {
	
	TestUtil testUtil;
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	GetAndSetTestData gst = new GetAndSetTestData();
	CommonFunctions cf = new CommonFunctions();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_Faxes_IncomingFindPage afp = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortalLoginLogoutPage all = new AdminPortalLoginLogoutPage();
	AdminPortal_Patients_TreatmentsListTabPage alt = new AdminPortal_Patients_TreatmentsListTabPage();
	AdminPortal_Patients_MessagesTabPage apm = new AdminPortal_Patients_MessagesTabPage();

	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	HubHomeLoginLogoutPage hlp = new HubHomeLoginLogoutPage();
	HubHomePage hhp = new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubUploadEOBPage hup = new HubUploadEOBPage();
	HubHomeLoginLogoutPage eft = new HubHomeLoginLogoutPage();
	HubUploadEOBPage ryu = new HubUploadEOBPage();
	AdminPortalLoginLogoutPage allo = new AdminPortalLoginLogoutPage();

	String Key1 = "FaxAndTreatment";
	String Key2 = "SearchEnrolledPatient";
	String Key3 = "CTPPatientEnrollment";
	String Key4 = "UploadDocumentCTP";

	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);

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
		//closeBrowser();
		TestBase.classAInstance.endReport();
	}

	// https://jira.connectiverx.com/browse/STORY-18883
	@Test(description = "Rule#2; case#2: Verify that the treatment claim is accepted if patient's available benefits is greater than or equal to patient's responsibility for ACH")
	public void VerifyClaimForMaxBalanceAvailable_DrugReimbursement_ACH()
			throws InterruptedException, IOException, AWTException, ParseException {
		String maxCopay = "805";
		WebDriverWait wait = new WebDriverWait(driver, 60);
		int rowNum3 = etd.getKeyValuePair(Key3);
		System.out.println("The rowNum is:" + rowNum3);
		List<String> testData3 = new ArrayList<String>();
		testData3 = gst.E2ECTPRequiredFields(Key3, rowNum3); // Same method for all Provider
		System.out.println("testdata1 is:" + testData3);

		eft.HCPLogin();
		System.out.println("HCP login done");
		Thread.sleep(9000);

		eft.SearchByMemberID().sendKeys(testData3.get(20).trim());
		Thread.sleep(2000);
		eft.SearchButton().click();
		System.out.println("Clicked on SearchButton");
		Thread.sleep(9000);
		String MemberID = eft.SearchButtonMemberId().getText();
		System.out.println("Member ID:" + MemberID);

		// Write test data back to upload document test cases
		System.out.println("The Key is:" + Key4);
		int rowNum4 = etd.getKeyValuePair(Key4);
		System.out.println("The rowNum is:" + rowNum4);
		List<String> testData = new ArrayList<String>();
		testData = gst.E2ECTPRequiredFields(Key4, rowNum4); // Same method for all Provider
		System.out.println("testdata is:" + testData);

		gst.setMemberIDInExcel_E2ECTP(Key4, MemberID, rowNum4); // Writing back the member ID in excel
		eft.UploadDocumentLink().click();
		Thread.sleep(10000);
		gst.setMemberIDInExcel(Key4, MemberID, rowNum4);
		System.out.println("I am above to click Document type");
		eft.DocumentType().click();
		System.out.println("I already clicked Document type");
		Thread.sleep(10000);
		eft.DocumentUploadBrowse().click();
		Thread.sleep(10000);
		String FAXDocument = ryu.GetFilepath().getPath();
		// click on file upload button and select file
		// Setting clipboard with file location
		setClipboardData(FAXDocument);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("File has been uploaded");

		Thread.sleep(3000);
		eft.DocumentUploadSubmit().click();
		Thread.sleep(4000);
		String tyu = eft.DocumentUploadSubmitNumber().getText();
		System.out.println("Document upload number:" + tyu);
		System.out.println("The uploaded document reference number is:" + tyu);
		closeBrowser();
		// Now log into Admin Portal
		try {
			intializeAdminDriver();
		} catch (InterruptedException ie) {

		}
		all.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum1 = etd.getKeyValuePair(Key1);
		int rowNum2 = etd.getKeyValuePair(Key2);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetFaxAndTreatmentTestData(Key1, rowNum1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		ahp.FaxesLink().click();
		Thread.sleep(1000);
		ahp.IncomingFaxesLink().click();
		wait.until(ExpectedConditions.visibilityOf(afp.EnrollFromDate()));
		Thread.sleep(2000);
        afp.EnrollFromDate().clear();
        afp.EnrollFromDate().sendKeys("2021-01-13");
		afp.CardID().sendKeys("EYE00044690");
		afp.FaxesPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(afp.PatientReviewLinkFirstRow()));

		// click on review link on the first search result
		afp.PatientReviewLinkFirstRow().click();

		if (aip.IncomingFaxCardID().getAttribute("value").isEmpty()) {
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		} else {
			aip.IncomingFaxCardID().clear();
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		}
		Thread.sleep(5000);
		System.out.println("IncomingFaxMemberID" + aip.IncomingFaxMemberID().getAttribute("value"));

		atp.AddFaxInformationAndTreatmentToEnrolledPatientForMaxPatientResponsibility(testData1, "ACH", maxCopay);
		// Assert that the treatment got added
		Assert.assertTrue(atp.TreatementAddConfirmation().isDisplayed());
		System.out.println("Patient's Treatment has been added successfully.");
		alt.TreatmentsListTab().click();
		Thread.sleep(8000);
		// Assert.assertEquals(alt.MTAmountLoadedColFirstRow().getText(), "$800.00");
		// Assert.assertEquals(alt.MTStatusColFirstRow().getText(), "Accepted");
		allo.AdminPortalLogout();
	}

	@Test(description = "Rule#2; case#2: Verify that the treatment claim is accepted if patient's available benefits is greater than or equal to patient's responsibility for CTP")
	public void VerifyClaimForMaxBalanceAvailable_DrugReimbursement_CTP()
			throws InterruptedException, IOException, AWTException, ParseException {
		String maxCopay = "805";
		WebDriverWait wait = new WebDriverWait(driver, 60);
		int rowNum3 = etd.getKeyValuePair(Key3);
		System.out.println("The rowNum is:" + rowNum3);
		List<String> testData3 = new ArrayList<String>();
		testData3 = gst.E2ECTPRequiredFields(Key3, rowNum3); // Same method for all Provider
		System.out.println("testdata1 is:" + testData3);

		eft.HCPLogin();
		System.out.println("HCP login done");
		Thread.sleep(9000);

		eft.SearchByMemberID().sendKeys(testData3.get(20).trim());
		Thread.sleep(2000);
		eft.SearchButton().click();
		System.out.println("Clicked on SearchButton");
		Thread.sleep(9000);
		String MemberID = eft.SearchButtonMemberId().getText();
		System.out.println("Member ID:" + MemberID);

		// Write test data back to upload document test cases
		System.out.println("The Key is:" + Key4);
		int rowNum4 = etd.getKeyValuePair(Key4);
		System.out.println("The rowNum is:" + rowNum4);
		List<String> testData = new ArrayList<String>();
		testData = gst.E2ECTPRequiredFields(Key4, rowNum4); // Same method for all Provider
		System.out.println("testdata is:" + testData);

		gst.setMemberIDInExcel_E2ECTP(Key4, MemberID, rowNum4); // Writing back the member ID in excel
		eft.UploadDocumentLink().click();
		Thread.sleep(10000);
		gst.setMemberIDInExcel(Key4, MemberID, rowNum4);
		System.out.println("I am above to click Document type");
		eft.DocumentType().click();
		System.out.println("I already clicked Document type");
		Thread.sleep(10000);
		eft.DocumentUploadBrowse().click();
		Thread.sleep(10000);
		String FAXDocument = ryu.GetFilepath().getPath();
		// click on file upload button and select file
		// Setting clipboard with file location
		setClipboardData(FAXDocument);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("File has been uploaded");

		Thread.sleep(3000);
		eft.DocumentUploadSubmit().click();
		Thread.sleep(4000);
		String tyu = eft.DocumentUploadSubmitNumber().getText();
		System.out.println("Document upload number:" + tyu);
		System.out.println("The uploaded document reference number is:" + tyu);
		closeBrowser();

		// Logout after enrollment hrp.HubReimbursementLogoutButton().click();
		try {
			intializeAdminDriver();
		} catch (InterruptedException ie) {

		}
		all.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum1 = etd.getKeyValuePair(Key1);
		int rowNum2 = etd.getKeyValuePair(Key2);

		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetFaxAndTreatmentTestData(Key1, rowNum1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		ahp.FaxesLink().click();
		Thread.sleep(1000);
		ahp.IncomingFaxesLink().click();
		wait.until(ExpectedConditions.visibilityOf(afp.EnrollFromDate()));
		Thread.sleep(2000);
        afp.EnrollFromDate().clear();
        afp.EnrollFromDate().sendKeys("2021-01-13");
		afp.CardID().sendKeys("EYE00044690");
		afp.FaxesPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(afp.PatientReviewLinkFirstRow()));

		// click on review link on the first search result
		afp.PatientReviewLinkFirstRow().click();

		if (aip.IncomingFaxCardID().getAttribute("value").isEmpty()) {
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		} else {
			aip.IncomingFaxCardID().clear();
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		}
		Thread.sleep(5000);
		System.out.println("IncomingFaxMemberID" + aip.IncomingFaxMemberID().getAttribute("value"));

		atp.AddFaxInformationAndTreatmentToEnrolledPatientForMaxPatientResponsibility(testData1, "CTP", maxCopay); // Assert
																													// that
																													// the
																													// treatment
																													// got
																													// added
		Assert.assertTrue(atp.TreatementAddConfirmation().isDisplayed());
		System.out.println("Patient's Treatment has been added successfully.");
		alt.TreatmentsListTab().click();
		Thread.sleep(8000);

		// reporting //scroll down to capture the screenshot at the correct location
		// js.executeScript("window.scrollBy(0,500)", "");
		allo.AdminPortalLogout();

	}

	@Test(description = "Rule#2; case#2: Verify that the treatment claim is accepted if patient's available benefits is greater than or equal to patient's responsibility for CTM")
	public void VerifyClaimForMaxBalanceAvailable_DrugReimbursement_CTM()
			throws InterruptedException, IOException, AWTException, ParseException {
		// String FAXDocument = hup.GetFilepath().getPath();
		String maxCopay = "805";
		WebDriverWait wait = new WebDriverWait(driver, 60);
		int rowNum3 = etd.getKeyValuePair(Key3);
		System.out.println("The rowNum is:" + rowNum3);
		List<String> testData3 = new ArrayList<String>();
		testData3 = gst.E2ECTPRequiredFields(Key3, rowNum3); // Same method for all Provider
		System.out.println("testdata1 is:" + testData3);

		eft.HCPLogin();
		System.out.println("HCP login done");
		Thread.sleep(9000);

		eft.SearchByMemberID().sendKeys(testData3.get(20).trim());
		Thread.sleep(2000);
		eft.SearchButton().click();
		System.out.println("Clicked on SearchButton");
		Thread.sleep(9000);
		String MemberID = eft.SearchButtonMemberId().getText();
		System.out.println("Member ID:" + MemberID);

		// Write test data back to upload document test cases
		System.out.println("The Key is:" + Key4);
		int rowNum4 = etd.getKeyValuePair(Key4);
		System.out.println("The rowNum is:" + rowNum4);
		List<String> testData = new ArrayList<String>();
		testData = gst.E2ECTPRequiredFields(Key4, rowNum4); // Same method for all Provider
		System.out.println("testdata is:" + testData);

		gst.setMemberIDInExcel_E2ECTP(Key4, MemberID, rowNum4); // Writing back the member ID in excel
		eft.UploadDocumentLink().click();
		Thread.sleep(10000);
		gst.setMemberIDInExcel(Key4, MemberID, rowNum4);
		System.out.println("I am above to click Document type");
		eft.DocumentType().click();
		System.out.println("I already clicked Document type");
		Thread.sleep(10000);
		eft.DocumentUploadBrowse().click();
		Thread.sleep(10000);
		String FAXDocument = ryu.GetFilepath().getPath();
		// click on file upload button and select file
		// Setting clipboard with file location
		setClipboardData(FAXDocument);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("File has been uploaded");

		Thread.sleep(3000);
		eft.DocumentUploadSubmit().click();
		Thread.sleep(4000);
		String tyu = eft.DocumentUploadSubmitNumber().getText();
		System.out.println("Document upload number:" + tyu);
		System.out.println("The uploaded document reference number is:" + tyu);
		closeBrowser();
		// Now log into Admin Portal try { intializeAdminDriver(); }
		try {
			intializeAdminDriver();
		} catch (InterruptedException ie) {

		}
		all.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum1 = etd.getKeyValuePair(Key1);
		int rowNum2 = etd.getKeyValuePair(Key2);

		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetFaxAndTreatmentTestData(Key1, rowNum1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		ahp.FaxesLink().click();
		Thread.sleep(1000);
		ahp.IncomingFaxesLink().click();
		wait.until(ExpectedConditions.visibilityOf(afp.EnrollFromDate()));
		Thread.sleep(2000);
        afp.EnrollFromDate().clear();
        afp.EnrollFromDate().sendKeys("2021-01-13");
		afp.CardID().sendKeys("EYE00044690");
		afp.FaxesPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(afp.PatientReviewLinkFirstRow()));

		// click on review link on the first search result
		afp.PatientReviewLinkFirstRow().click();

		if (aip.IncomingFaxCardID().getAttribute("value").isEmpty()) {
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		} else {
			aip.IncomingFaxCardID().clear();
			aip.IncomingFaxCardID().sendKeys("EYE00044690");
		}
		Thread.sleep(5000);
		System.out.println("IncomingFaxMemberID" + aip.IncomingFaxMemberID().getAttribute("value"));

		atp.AddFaxInformationAndTreatmentToEnrolledPatientForMaxPatientResponsibility(testData1, "CTM", maxCopay); // Assert
																													// added
		Assert.assertTrue(atp.TreatementAddConfirmation().isDisplayed());
		System.out.println("Patient's Treatment has been added successfully.");
		alt.TreatmentsListTab().click();
		Thread.sleep(8000);
		//Assert.assertEquals(alt.MTAmountLoadedColFirstRow().getText(), "$800.00");
		//Assert.assertEquals(alt.MTStatusColFirstRow().getText(), "Accepted");
		allo.AdminPortalLogout();
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

}
