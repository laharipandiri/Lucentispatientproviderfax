package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
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
import com.juno.qa.pages.AdminPortal_Patients_BenefitsHisoryTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TransactionsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

// once a patient is enrolled and active, he/she will be assigned an amount and period and validates 
@Listeners(TestNGListner.class)
public class TC04_AdminPortal_VerifyBenefitsHistoryForPatientsTest extends AdminPortalLoginLogoutPage {
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_BenefitsHisoryTabPage abp = new AdminPortal_Patients_BenefitsHisoryTabPage();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	String Key = "SmokePatientEnrollment";//For now we are using transactions tab test data as we just need MemberID for this test case
	
	
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

	
	@Test ( description  = "Verify the benefits history tab for a patient account ")
	public void VerifyBenefitsHistoryPageForPatient_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetAdminPagesLinksTestData(Key, rowNum); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
	
		System.out.println("The testdat is:" +testData);
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		System.out.println("The Card ID is:" +testData.get(20));
		app.PatientsFindPageCardID().sendKeys(testData.get(20).trim());
		app.PatientsPageFindButton().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
		
		app.PatientsFindFirstReviewButton().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		abp.BenefitsHistoryTab().click();
		Thread.sleep(15000);
		//commented below 2 lines as replatform doesnt have header yet
		//wait.until(ExpectedConditions.visibilityOf(abp.BenefitsHistoryTableHeader()));
		
		//Assert.assertEquals(abp.BenefitsHistoryTableHeader().getText(), testData.get(1));
		
		int tableColCount = abp.BenefitsHistoryTable().size();
		System.out.println("Table columns count: "+tableColCount);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String s=String.valueOf(year); 
		System.out.println("year is:" +year);
		//verify that all columns are displayed
		String CurrentBenefitPeriod="N";
		String CurrentBenefitAmount="15000.00";
		
		for(int i=1 ; i<=tableColCount ; i++)//col headers
		{
			for(int k=i+1; k<=i+1 ;k++) {//starting the index from 2 because in the testData object, the col names start from that index
				 Assert.assertEquals(abp.BenefitsHistoryTableColCurrentBenefitPeriod().getText(),CurrentBenefitPeriod);
				Assert.assertEquals(abp.BenefitsHistoryTableColCurrentBenefitAmount().getText(),CurrentBenefitAmount);
				Assert.assertEquals(abp.BenefitsHistoryTableColBenefitPeriod().getText(),s);
				
				
			}
			
		} 
		
		//reporting
		if(!abp.BenefitsHistoryTable().isEmpty())
	     {
	    	TestBase.classAInstance.logReport("Pass","Benefits history tab for a patient account","Succesfully able to  Verify Benefits history tab for a patient account");
	     }
	     else
 	     {
	    	TestBase.classAInstance.logReport("Fail","Benefits history tab for a patient account","Failed to  Verify Benefits history tab for a patient account");
	     } 
		
		AdminPortalLogout();
		
	}
}
	
	