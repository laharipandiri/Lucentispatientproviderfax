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
import com.juno.qa.getandsetTestData.Patients_Find;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Patients_ActivePage;
import com.juno.qa.pages.AdminPortal_Patients_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubHomePage;
import com.juno.qa.pages.HubReimbursementPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC35_AdminPortal_Verify_Address2Update extends AdminPortalLoginLogoutPage {

	Patients_Find dat = new Patients_Find();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_ActivePage pfp = new AdminPortal_Patients_ActivePage();
	AdminPortal_Patients_PatientAndCardTabPage app = new AdminPortal_Patients_PatientAndCardTabPage();
	HubHomeLoginLogoutPage hlp = new HubHomeLoginLogoutPage();
	HubHomePage hhp=new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubEnrollAPatientPage hap = new HubEnrollAPatientPage();
	GetAndSetTestData gst = new GetAndSetTestData();
	CommonFunctions cf = new CommonFunctions();
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	AdminPortal_Patients_FindPage apps = new AdminPortal_Patients_FindPage();
	
	String Key = "FindPageFields";
	String Key1 = "PatientsFindPageSearchgridCols";
	String Key2 = "EnrollPatient";
	String Key3 = "EnrollAdminReimbursementPatient";
	String Key4 = "EnrollBothTypePatient";
	
	@BeforeMethod
	public void OpenBrowser()  
	{
		try {
			intializePatientDriverPopUp();
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
	
	
	@Test ( description = "Verify Patients-->Find page -->MemberID Search in DrugReimbursement")
	public void VerifyPatientsFindPage_SearchByMemberID_DrugReimbursement() throws IOException, AWTException, InterruptedException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<String> patientData = eft.LucentisEnrollInPateintPortal(); //Enroll Patient 
		String memberId = eft.GetFieldValueAfterEnrolment("Member ID");
		driver.quit();
		
		//Now log into Admin Portal and match the above enrolled patient to a BO
		try
		{
			intializeAdminDriver();
		}
		catch(InterruptedException ie)
		{
			
		}
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		//apps.PatientsFindPagePatientStatusDropDown().selectByVisibleText("ALL");
		wait.until(ExpectedConditions.visibilityOf(apps.PatientsFindPageMemberID()));
		apps.PatientsFindPageMemberID().sendKeys(memberId);
		apps.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(apps.PatientsFindFirstReviewButton()));
		
		//Now verify the values displayed in the columns are the values that were specified during enrollment
		//Get the confirmation#, cardID & Status value from here and then cross verify with the patient and card info tab details
		String confirmationNum = pfp.ConfirmationNumberValueInFirstRow();
		String Status = pfp.StatusValueInFirstRow();
		String CardID = pfp.CardIDValueInFirstRow();
		String ProgramName = pfp.ProgramNameValueInFirstRow();
		//MemberID	LastName	FirstName	ProgramName	ActivationDate	CreatedDate	ActivationType	Status	Contact	PartnerPatientID	CardID	ProviderName	ProviderType	Confirmation#
		Assert.assertEquals(pfp.LastNameValueInFirstRow(), patientData.get(2));
		Assert.assertEquals(pfp.FirstNameValueInFirstRow(), patientData.get(1));
		Assert.assertTrue(pfp.ActivationDateValueInFirstRow().contains(currentDate));
		Assert.assertEquals(pfp.MemberIDValueInFirstRow(), memberId);
		Assert.assertEquals(pfp.ProviderNameValueInFirstRow(), "Lena Chu");
		Assert.assertEquals(pfp.ProviderTypeValueInFirstRow(), "Physician");
		
		//Now click on review link and verify the values in patient and info card tab
		pfp.PatientsActiveFirstReviewButton().click();
		Thread.sleep(2000);
		Assert.assertEquals(app.ProgramLabelValue().getText(), ProgramName);
		Assert.assertEquals(app.PatientAndCardTabFirstName().getAttribute("value"), patientData.get(1));
		Assert.assertEquals(app.PatientAndCardTabAddress1Value(), patientData.get(4));
		Assert.assertEquals(app.PatientAndCardTabCityValue(), patientData.get(5));
		String[] mobilephone = app.HomePhoneValue().split("-");
		String mobileNum = mobilephone[0]+mobilephone[1]+mobilephone[2];
		Assert.assertEquals(mobileNum, patientData.get(8));
		Assert.assertEquals(app.PatientAndCardTabGenderValue(), "Female");
		Assert.assertEquals(app.PatientAndCardTabDOBValue(), "1986-07-05");
		Assert.assertEquals(app.PatientAndCardTabMemberIDValue(), memberId);
		Assert.assertEquals(app.EnrollmentTypeValue(), "drug");
		Assert.assertEquals(app.PatientAndCardTabPatientStatusValue(), Status);
		Assert.assertEquals(app.ConfirmationNumberValue(), confirmationNum);
		AdminPortalLogout();
		driver.quit();
		String address2 = "Address 2 updated";
		intializeHubDriver();
		eft.HCPLogin();
		System.out.println("HCP login done");
		Thread.sleep(9000);

		eft.SearchByMemberID().sendKeys(memberId);
		Thread.sleep(2000);
		eft.SearchButton().click();
		System.out.println("Clicked on SearchButton");
		Thread.sleep(9000);
		String MemberID = eft.SearchButtonMemberId().getText();
		System.out.println("Member ID:" + MemberID);
		
		eft.ViewPatientLink().click();
		eft.UpdatePatientDetailsLink().click();
		try {
			eft.PopUpCloseBttn().click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		eft.Address2TextBox().sendKeys(address2);
		eft.SaveButton().click();
		wait.until(ExpectedConditions.visibilityOf(eft.PopUpWithMessage()));
		eft.OKButton().click();
		//wait.until(ExpectedConditions.visibilityOf(eft.SavedSuccessfullyMsg()));
		Thread.sleep(8000);
		driver.quit();
		
		//Now log into Admin Portal and match the above enrolled patient to a BO
		try
		{
			intializeAdminDriver();
		}
		catch(InterruptedException ie)
		{
			
		}
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		ahp.PatientsLink().click();
		ahp.FindLink().click();
		wait.until(ExpectedConditions.visibilityOf(apps.PatientsFindPageMemberID()));
		apps.PatientsFindPageMemberID().sendKeys(memberId);
		apps.PatientsPageFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(apps.PatientsFindFirstReviewButton()));
		
		//Now verify the values displayed in the columns are the values that were specified during enrollment
		//Get the confirmation#, cardID & Status value from here and then cross verify with the patient and card info tab details
		confirmationNum = pfp.ConfirmationNumberValueInFirstRow();
		Status = pfp.StatusValueInFirstRow();
		CardID = pfp.CardIDValueInFirstRow();
		ProgramName = pfp.ProgramNameValueInFirstRow();
		//MemberID	LastName	FirstName	ProgramName	ActivationDate	CreatedDate	ActivationType	Status	Contact	PartnerPatientID	CardID	ProviderName	ProviderType	Confirmation#
		Assert.assertEquals(pfp.LastNameValueInFirstRow(), patientData.get(2));
		Assert.assertEquals(pfp.FirstNameValueInFirstRow(), patientData.get(1));
		Assert.assertTrue(pfp.ActivationDateValueInFirstRow().contains(currentDate));
		Assert.assertEquals(pfp.MemberIDValueInFirstRow(), memberId);
		Assert.assertEquals(pfp.ProviderNameValueInFirstRow(), "Lena Chu");
		Assert.assertEquals(pfp.ProviderTypeValueInFirstRow(), "Physician");
		Assert.assertTrue(pfp.PatientAddressFromGrid().getText().contains(address2));
		
		//Now click on review link and verify the values in patient and info card tab
		pfp.PatientsActiveFirstReviewButton().click();
		Thread.sleep(2000);
		Assert.assertEquals(app.ProgramLabelValue().getText(), ProgramName);
		Assert.assertEquals(app.PatientAndCardTabFirstName().getAttribute("value"), patientData.get(1));
		//Assert.assertEquals(app.PatientAndCardTabAddress1Value(), patientData.get(4));
		Assert.assertEquals(app.PatientAndCardTabCityValue(), patientData.get(5));
		mobilephone = app.HomePhoneValue().split("-");
		mobileNum = mobilephone[0]+mobilephone[1]+mobilephone[2];
		Assert.assertEquals(mobileNum, patientData.get(8));
		Assert.assertEquals(app.PatientAndCardTabGenderValue(), "Female");
		Assert.assertEquals(app.PatientAndCardTabDOBValue(), "1986-07-05");
		Assert.assertEquals(app.PatientAndCardTabMemberIDValue(), memberId);
		Assert.assertEquals(app.EnrollmentTypeValue(), "drug");
		Assert.assertEquals(app.PatientAndCardTabPatientStatusValue(), Status);
		Assert.assertEquals(app.ConfirmationNumberValue(), confirmationNum);
		//Assert.assertEquals(app.PatientAndCardTabAddress2Value(), address2);
		AdminPortalLogout();
		
	}
	
}
