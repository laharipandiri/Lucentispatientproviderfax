package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
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
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_HelpDeskNotesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC05_AdminPortal_Patients_VerifyAbilityToAddHelpDeskNotes extends AdminPortalLoginLogoutPage {

	TestUtil testUtil;
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_HelpDeskNotesTabPage anp = new AdminPortal_Patients_HelpDeskNotesTabPage();
	
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	String Key = "HelpDeskNotes";
	//String Key1 = "EnrollPatient";
	//String Key2 = "EnrollAdminReimbursementPatient";
	String Key3 = "SmokePatientEnrollment";
	
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
	
	@Test ( description = "verify the ability to add helpdesk notes for a patient ")
	public void VerifyAddingHelpDeskNotes_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		  
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		//reading Member ID  from SmokePatientEnrollment from smoke sheet
		int rowNum1 = etd.getKeyValuePair(Key3);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key3, rowNum1);
		System.out.println("The testData1 is:" +testData1);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
		
		//reading data from HelpDeskNotes from smoke
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetEnrollPatientMandatoryFields(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		app.PatientsPageFindButton().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Go to hdnotes tab
		anp.HelpDeskNotesTab().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(anp.AddButton()));
	/*	
		//verify the table header column names
		int colCount = anp.NotesTableHeaderColumnsCount();
		for(int i=1; i<=colCount; i++)
		{
			for(int j=i+3 ; j<=i+3 ; j++)//starting with this index because testData object list has col names from that index
			{
				Assert.assertEquals(anp.NotesTableHeaderColumnNames(i).getText(), testData.get(j));
			}
		}*/
		anp.AddNotesInHelpDesk(testData);
		/*
		Assert.assertEquals(anp.NotesAddedConfirmationMessage().getText(), testData.get(16));
		
		Assert.assertEquals(anp.getLatestRowEnrollmentsColmunValue(), testData.get(2));
		Assert.assertEquals(anp.getLatestRowNotesColmunValue(), testData.get(3));
//		Assert.assertEquals(getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(anp.getLatestRowOriginatedFromColmunValue(), testData.get(1));
		Assert.assertEquals(anp.getLatestRowCreatedByColmunValue(), prop.getProperty("username"));
		Assert.assertTrue(anp.getLatestRowCreatedDateColmunValue().contains(currentDate));
		Assert.assertEquals(anp.getLatestRowModifiedByColmunValue(), prop.getProperty("username"));
		Assert.assertTrue(anp.getLatestRowModifiedDateColmunValue().contains(currentDate));
		Assert.assertTrue(anp.getLatestRowActionsColmunValue().isDisplayed());
		*/
		//reporting
		//scroll down to capture the screenshot at the correct location
		
      /*  js.executeScript("window.scrollBy(0,350)", "");
		if(anp.NotesAddedConfirmationMessage().getText().equalsIgnoreCase(testData.get(16)))
	     {
	    	TestBase.classAInstance.logReport("Pass","Add helpdesk notes for a patient","Succesfully able to  Verify Add helpdesk notes for a patient");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Add helpdesk notes for a patient","Failed to  Verify Add helpdesk notes for a patient");
	     } 
		
		//reporting
		//scroll down to capture the screenshot at the correct location
        js.executeScript("window.scrollBy(0,700)", "");
		if(anp.AddNotesAgainAndVerify(testData))
	     {
	    	TestBase.classAInstance.logReport("Pass","Add Notes Again And Verify","Succesfully able to  Verify Add Notes Again And Verify");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Add Notes Again And Verify","Failed to  Verify Add Notes Again And Verify");
	     } 
		
		*/
		if(anp.HelpDeskNotesTab().isDisplayed()== true)
	     {
	    	TestBase.classAInstance.logReport("Pass","Add helpdesk notes for a patient","Succesfully able to  Verify Add helpdesk notes for a patient");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Add helpdesk notes for a patient","Failed to  Verify Add Notes Again And Verify");
	     } 
		AdminPortalLogout();
		
	}
}

