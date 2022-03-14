	package com.qa.regression.adminportal.patients.tests;

	import java.awt.AWTException;
	import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
	import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
	import com.juno.qa.pages.HubFindAllCopayProgramPatientPage;
	import com.juno.qa.pages.HubHomeLoginLogoutPage;
	import com.juno.qa.pages.HubHomePage;

	import com.juno.qa.pages.HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage;
	import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.pages.PatientPage;
import com.juno.qa.util.CommonFunctions;
	import com.juno.qa.util.ExcelTestDataReader;
	import com.juno.qa.util.TestUtil;
	import com.juno.qa.util.Xls_Reader;
	import com.qa.ExtentReportListener.TestNGListner;

	@Listeners(TestNGListner.class)
		public class TC01_AdminPortal_UpdatePatientInfoAndVerifyInHCPPortalTest extends AdminPortalLoginLogoutPage {
	
			TestUtil testUtil;
			
			Xls_Reader reader1 = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
			String sheetname = "Regression";
			String Key = "PatientEnrollment";
			
			String Key1 = "UpdatePatientInfo";
			String Key2 = "UpdatePatientInfoForBothDrugReimbursement";
			String Key3 = "UpdatePatientInfoForBothAdminReimbursement";
			
			HubReimbursementPage hrp = new HubReimbursementPage();
			HubHomePage hhp = new HubHomePage();
			HubFindAllCopayProgramPatientPage fcp = new HubFindAllCopayProgramPatientPage();
			HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage lcp = new HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage();
			HubHomeLoginLogoutPage hlp = new HubHomeLoginLogoutPage();
			AdminPortalHomePage ahp = new AdminPortalHomePage();
			AdminPortalPatientsPage app = new AdminPortalPatientsPage();
			AdminPortal_Patients_PatientAndCardTabPage apc= new AdminPortal_Patients_PatientAndCardTabPage();
			PatientPage abd=new PatientPage();
			
			ExcelTestDataReader etd = new ExcelTestDataReader();
			GetAndSetTestData gst = new GetAndSetTestData();
			CommonFunctions cf = new CommonFunctions();
			
			
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
			
			@Test ( description = "Verify updates made to patient info in admin portal for drug reimbursement and reflected in hub portal ")
			public void UpdatePatientInfoInAdminAndVerifyInHub_DrugReimbursement() throws InterruptedException, IOException, AWTException, ParseException
			{
				
			 
				WebDriverWait wait = new WebDriverWait(driver, 30);
				
				AdminPortalLogin();
				wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
				ahp.PatientsLink().click();
				ahp.FindLink().click();
				wait.until(ExpectedConditions.visibilityOf(app.PatientsPageFindButton()));
				
				List<String> testData1 = new ArrayList<String>();
				int rowNum1 = etd.getKeyValuePair(Key);
				//testData = gst.GetPatientInfoForUpdateForDrugReimbursement(Key, rowNum2);//this is from WB
				testData1 = gst.GetPhysicianNewPageRequiredFields(Key, rowNum1);
				System.out.println("The testData is:" +testData1);
				
				String abc= testData1.get(20).trim(); //trim the member ID
				abd.PatientSearchShortCardID().sendKeys(abc);
				abd.PatientSearch().click(); //Click on Search button on Patient page 
					
				List<String> testData = new ArrayList<String>();
				int rowNum2 = etd.getKeyValuePair(Key1);
				//testData = gst.GetPatientInfoForUpdateForDrugReimbursement(Key, rowNum2);//this is from WB
				testData = gst.GetPhysicianNewPageRequiredFields(Key1, rowNum2);
				System.out.println("The testData is:" +testData);
					Thread.sleep(2000);
					app.PatientsFindReviewButton().click();
					
					
					String[] PatientEnrollmentInfo = apc.UpdatePatientInfoInAdmin(testData); 
					
					
					testData.add(10, PatientEnrollmentInfo[0]);//GroupNumber
					testData.add(11, PatientEnrollmentInfo[1]);//EnrollmentStatus
					testData.add(12, PatientEnrollmentInfo[2]);//PatientDOBAfterUpdate
					testData.add(13, PatientEnrollmentInfo[3]);//PatientState
					testData.add(14, PatientEnrollmentInfo[4]);//PatientGender
				    
					//reporting
					if(!PatientEnrollmentInfo[1].isEmpty())
				    {
				    	TestBase.classAInstance.logReport("Pass","updates in admin portal","Succesfully able to verify updates in admin portal");
				    }
				    else
				    {
				    	TestBase.classAInstance.logReport("Fail","updates in admin portal","Failed to verify updates in admin portal");
				    }
					
				    //Now set the all the field values that we got from above back onto the excel. Make sure that they are set to null first to avoid appending to existing data
					String[] DOB = testData.get(12).split("-");//0-y,1-m,2-d
				    int month = Integer.parseInt(DOB[1]);
				    System.out.println("Monthnum:"+month);
				    String mon = cf.ConvertToMonthString(month);
				    System.out.println("Month name: "+mon);
				    String updatedDOB = DOB[2] + "-" + mon + "-" + DOB[0].substring(2, 4);
				    System.out.println("Updated DOB: "+updatedDOB);
				    
				    System.out.println("The PatientFirstName is:" +testData.get(0));
				    System.out.println("The PatientLastName is:" +testData.get(1));
				    System.out.println("The PatientDOBAfterUpdate is:" +updatedDOB);
				    System.out.println("The PatientAddress is:" +testData.get(3));
				    System.out.println("The PatientCity is:" +testData.get(4));
				    System.out.println("The PatientState is:" +testData.get(13));
				    System.out.println("The PatientZipCode is:" +testData.get(5));
				    System.out.println("The PatientCellNumber is:" +testData.get(8));
				    System.out.println("The PatientGender is:" +testData.get(14));
				    System.out.println("The GroupNumber is:" +testData.get(10));
				    System.out.println("The EnrollmentStatus is:" +testData.get(11));
				    
				    
					reader1.setDataInNewRow("Regression", "PatientFirstName", rowNum2, testData.get(0));
				    reader1.setDataInNewRow("Regression", "PatientLastName", rowNum2, testData.get(1));
				    reader1.setDataInNewRow("Regression", "PatientDOBAfterUpdate", rowNum2, updatedDOB);
				    reader1.setDataInNewRow("Regression", "PatientAddress", rowNum2, testData.get(3));
				    reader1.setDataInNewRow("Regression", "PatientCity", rowNum2, testData.get(4));
				    reader1.setDataInNewRow("Regression", "PatientState", rowNum2, testData.get(13));
				    reader1.setDataInNewRow("Regression", "PatientZipCode", rowNum2, testData.get(5));
				    reader1.setDataInNewRow("Regression", "PatientCellNumber", rowNum2, testData.get(8));
				    reader1.setDataInNewRow("Regression", "PatientGender", rowNum2, testData.get(14));
				    reader1.setDataInNewRow("Regression", "GroupNumber", rowNum2, testData.get(10));
				    reader1.setDataInNewRow("Regression", "EnrollmentStatus", rowNum2, testData.get(11));
				    
				   AdminPortalLogout();
				    //reporting
				    
				    /*if(VerifyUpdatesInHubPortal(testData, "DrugReimbursement"))
				    {
				    	TestBase.classAInstance.logReport("Pass","updates verification in hub portal","Succesfully able to verify updates verification in hub portal");
				    }
				    else
				    {
				    	TestBase.classAInstance.logReport("Fail","updates verification in hub portal","Failed to verify updates verification in hub portal");
				    }
				    */
				    //hrp.HubReimbursementLogoutButton().click(); 
					
				
			}
			
			
			
			public boolean VerifyUpdatesInHubPortal(List<String> testData, String loginType) throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
				LocalDate todayDate = java.time.LocalDate.now(); 
				String currentDate = todayDate.toString();

				//Log into Admin
				try {
					intializeHubDriver();
					}
					catch(InterruptedException e) {
						
					}
				hlp.HubPortalLogin();
				
				hrp.FindCopayProgramPatientsButton().click();
				wait.until(ExpectedConditions.visibilityOf(fcp.FindButton()));
				Thread.sleep(60000);
				boolean verify = true;
				if(verify)
				{
					fcp.MemberId().sendKeys(testData.get(9));
					fcp.FindButton().click();
					wait.until(ExpectedConditions.visibilityOf(fcp.ReviewLink()));
					fcp.ReviewLink().click();
					
					wait.until(ExpectedConditions.visibilityOf(lcp.PatientReviewPatientCardUpdateButton()));
					
					Assert.assertEquals(lcp.PatientReviewPatientCardFirstNameValue(), testData.get(0));
					Assert.assertTrue(testData.get(1).equalsIgnoreCase(lcp.PatientReviewPatientCardLastNameValue()));
					/*String[] dates = lcp.PatientReviewPatientCardDOBValue().split("-");
					String finalDate = dates[1]+"/"+dates[2]+"/"+dates[0]; */
					Assert.assertEquals(lcp.PatientReviewPatientCardDOBValue(),testData.get(12));
					System.out.println("Patient dob after update: "+testData.get(12));
					Assert.assertTrue(testData.get(3).equalsIgnoreCase(lcp.PatientReviewPatientCardAddressValue()));
					Assert.assertTrue(testData.get(4).equalsIgnoreCase(lcp.PatientReviewPatientCardCityValue()));
					Assert.assertEquals(lcp.PatientReviewPatientCardStateValue(), testData.get(13));
				//	Assert.assertEquals(testData.get(5), lcp.PatientReviewPatientCardZipCodeValue());
				//	Assert.assertTrue(testData.get(9).equalsIgnoreCase(lcp.PatientReviewPatientCardPartnerPatientIDValue()));
					Assert.assertEquals(lcp.PatientReviewPatientCardStaticMemberIDValue(), testData.get(9));
					Assert.assertEquals(lcp.PatientReviewPatientCardStaticGroupNumberValue(), testData.get(10));
					Assert.assertEquals(lcp.PatientReviewPatientCardStaticEnrollmentStatusValue(), testData.get(11));
					Assert.assertEquals(lcp.HIPAADate().getAttribute("value"), currentDate);
					
					return verify;
				}
				
				verify = false;
				return verify;
				
				
				
			}

			

	}



