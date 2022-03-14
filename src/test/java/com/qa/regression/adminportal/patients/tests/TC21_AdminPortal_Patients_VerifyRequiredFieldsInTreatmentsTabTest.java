package com.qa.regression.adminportal.patients.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC21_AdminPortal_Patients_VerifyRequiredFieldsInTreatmentsTabTest extends AdminPortalLoginLogoutPage {

	Patients_TreatmentsTab dat = new Patients_TreatmentsTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage apt = new AdminPortal_Patients_TreatmentsPage();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	
	String Key = "VerifyRequiredFieldsInTreatments";
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
	
	@Test ( description = "Verify required Fields In Treatments Tab")
	public void VerifyRequiredFieldsInTreatmentsTab_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
				int rowNum1 = etd.getKeyValuePair(Key1);
				List<String> testData1 = new ArrayList<String>();
				testData1 = gst.GetAdminPagesLinksTestData(Key1, rowNum1); //GetBenefitsHistoryTabTestData_DrugReimbursement updated for replatform
				
				int rowNum = etd.getKeyValuePair(Key);
				List<String> testData = new ArrayList<String>();
				testData = dat.GetVerifyRequiredFieldsInTreatmentsTestData(Key, rowNum);
				System.out.println("The testData is:" +testData);
				
				ahp.PatientsLink().click();
				ahp.FindLink().click();
				app.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
				app.PatientsFindPageCardID().sendKeys(testData1.get(20).trim());
				app.PatientsPageFindButton().click();
				wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
				
				app.PatientsFindFirstReviewButton().click();
				wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
				
				apt.TreatmentsTabOption().click();
				Thread.sleep(20000);
				
				apt.Copay().sendKeys(testData.get(1));
				apt.AddButton().click();
				
				Assert.assertEquals(apt.EOBFaxesRequiredMsg(), testData.get(2));
				Assert.assertEquals(apt.OutgoingFaxRequiredMsg(), testData.get(3));
				Assert.assertEquals(apt.DOSRequiredMsg(), testData.get(4));
		//		Assert.assertEquals(apt.JCodeRequiredMsg(), testData.get(5));
				Assert.assertEquals(apt.QuantityRequiredMsg(), testData.get(6));
				Assert.assertEquals(apt.NDCRequiredMsg(), testData.get(7));
				
				Assert.assertEquals(apt.EOBDateRequiredMsg(), testData.get(8));
				
				//Below are commented for Treatment
				//Assert.assertEquals(apt.PayeeNameRequiredMsg(), testData.get(9));
				//Assert.assertEquals(apt.PayeeAddressRequiredMsg(), testData.get(10));
				//Assert.assertEquals(apt.PayeeCityRequiredMsg(), testData.get(11));
				//Assert.assertEquals(apt.PayeeStateRequiredMsg(), testData.get(12));
				//Assert.assertEquals(apt.PayeeZipRequiredMsg(), testData.get(13));
			//	Assert.assertEquals(apt.PayeePhoneRequiredMsg(), testData.get(14));
				
				Assert.assertEquals(apt.BillingProviderRequiredMsg(), testData.get(15));
				Assert.assertEquals(apt.TreatingPracticeRequiredMsg(), testData.get(16));
				Assert.assertEquals(apt.PhysicianRequiredMsg(), testData.get(17));
				
				System.out.println("UI1:"+apt.FieldRequiredMsgUnderAddButton());
				System.out.println("UI2:"+testData.get(18));
				//Assert.assertTrue(apt.FieldRequiredMsgUnderAddButton().contains(testData.get(18)));
				
				//reporting
				//scroll down to capture the screenshot at the correct location
		        js.executeScript("window.scrollBy(0,1080)", "");
				if(apt.BillingProviderRequiredMsg().contains(testData.get(15)))
			     {
			    	TestBase.classAInstance.logReport("Pass","Required Fields In Treatments Tab","Succesfully able to  Verify required Fields In Treatments Tab");
			     }
			     else
			     {
			    	TestBase.classAInstance.logReport("Fail","Required Fields In Treatments Tab","Failed to  Verify  required Fields In Treatments Tab");
			     }
				
				AdminPortalLogout();
	
	}
	}
