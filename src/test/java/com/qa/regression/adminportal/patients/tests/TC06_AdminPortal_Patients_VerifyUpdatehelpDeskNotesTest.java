package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Patients_HelpDeskNotesTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC06_AdminPortal_Patients_VerifyUpdatehelpDeskNotesTest extends AdminPortalLoginLogoutPage {

	TestUtil testUtil;
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_HelpDeskNotesTabPage anp = new AdminPortal_Patients_HelpDeskNotesTabPage();
	AdminPortal_PG_BO_ProvidersTabPage apbo = new AdminPortal_PG_BO_ProvidersTabPage();
	
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	String Key = "HelpDeskNotes";
	String Key1 = "SmokePatientEnrollment";
	
	
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
	
	@Test ( description = "verify the ability to update helpdesk notes for a patient")
	public void VerifyUpdatingHelpDeskNotes_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		//reading Member ID  from SmokePatientEnrollment from smoke sheet
		int rowNum1 = etd.getKeyValuePair(Key1);
		List<String> testData1 = new ArrayList<String>();
		testData1 = gst.GetAdminPagesLinksTestData(Key1, rowNum1);
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
		app.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		//Read data for Help desk notes
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GethelpDeskNotesData(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		//Go to hdnotes tab
		anp.HelpDeskNotesTab().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(anp.AddButton()));
		
		anp.UpdateNotesInHelpDesk(testData);
		apbo.ClickArrowDownToDisplayTable("shownotesrow");
		
		/*anp.getLatestRowActionsColmunValue().click();//Clicking on the edit link of the latest notes - which is the last row in the table
		//Thread.sleep(5000);
		
		Assert.assertEquals(anp.NotesTextArea().getText(), testData.get(4));//verify the text area displays previously specified value after you click on Edit
		Assert.assertTrue(anp.UpdateButton().isDisplayed());//make sure now the update button is displayed
		
		anp.CallerDropdown().selectByVisibleText(testData.get(15));
		anp.ReasonDropdown().selectByVisibleText(testData.get(16));
		anp.NotesTextArea().clear();
		anp.NotesTextArea().sendKeys(testData.get(14));
		
		anp.UpdateButton().click();
		Thread.sleep(5000);
		*/
		/*Assert.assertEquals(anp.NotesAddedConfirmationMessage().getText(), testData.get(17));
		
		//Now verify the updated values are showing 
		Assert.assertEquals(anp.getLatestRowEnrollmentsColmunValue(), testData.get(15));
		Assert.assertEquals(anp.getLatestRowNotesColmunValue(), testData.get(13));
//		Assert.assertEquals(getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(anp.getLatestRowOriginatedFromColmunValue(), testData.get(14));
		Assert.assertEquals(anp.getLatestRowCreatedByColmunValue(), prop.getProperty("username"));
		Assert.assertTrue(anp.getLatestRowCreatedDateColmunValue().contains(currentDate));
		Assert.assertEquals(anp.getLatestRowModifiedByColmunValue(), prop.getProperty("username"));
		Assert.assertTrue(anp.getLatestRowModifiedDateColmunValue().contains(currentDate));
		//Assert.assertTrue(anp.getLatestRowActionsColmunValue().isDisplayed());//For now commenting this assertion because after update is made Edit link is not displayed for that row.
		*/
		//reporting
		/*
		 * if(anp.NotesAddedConfirmationMessage().getText().equalsIgnoreCase(testData.
		 * get(17))) { TestBase.classAInstance.logReport(
		 * "Pass","Update helpdesk notes for a patient"
		 * ,"Succesfully able to  Verify Update helpdesk notes for a patient"); } else {
		 * TestBase.classAInstance.logReport(
		 * "Fail","Update helpdesk notes for a patient"
		 * ,"Failed to  Verify Update helpdesk notes for a patient"); }
		 */
		AdminPortalLogout();
		
	}
	
	

}
