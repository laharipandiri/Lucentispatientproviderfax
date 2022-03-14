package com.Xolairadmin.qa.SmokeScript;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Patients_New;
import com.juno.qa.pages.HubEnrollAPatientPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

//Create a Patient and then attach a provider STORY-27181

@Listeners(TestNGListner.class)
public class TC04_XolairAdminPortal_VerifyEnrollPatientField extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	ExcelTestDataReader etd= new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_New apn = new AdminPortal_Patients_New();
	
	
	
	
	//String Key = "EnrollPatientForProvider";
	
	
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
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "Enroll Patient content in Admin Portal", "Succesfully verified Enroll Patient content in Admin Portal");
			} else {
			TestBase.classAInstance.logReport("Fail", "Enroll Patient content in Admin Portal", "Failed to verified Enroll Patient content in Admin Portal");
			}
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test(description = "Enroll Patient in Admin Portal")
	public void EnrollPatient_AdminPortal() throws Exception

	{ try {
		WebDriverWait wait = new WebDriverWait(driver,30);
		AdminPortalLogin();
		
		ahp.PatientsLink().click();
		ahp.NewLink().click();
//		wait.until(ExpectedConditions.visibilityOf(apn.AddButton()));
		wait.until(ExpectedConditions.visibilityOf(apn.ClickOnNewEnrollment()));
	
		//Assert.assertTrue(apn.PatientTitle().isDisplayed()); //Patient title
		
		boolean hhh1= driver.getPageSource().contains("Error");
		//System.out.println("hhh12:" +hhh1);
		
		 if (hhh1 == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-Enroll Patient" );
			 
			}
			else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-HelpDesk Notes");
			}
	
		
		if(apn.ClickOnNewEnrollment().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the New Enrollment link","New Enrollment is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the New Enrollment link","New Enrollmentis not available");
		}
		/*
		 * if(apn.PatientTitle().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Patient Title field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Patient Title field is not available");
		}
		 Assert.assertTrue(apn.FirstName().isDisplayed());//FirstName
		
		if(apn.FirstName().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","First Name field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","First Name field is not available");
		}
		Assert.assertTrue(apn.MiddleName().isDisplayed());//MiddleName
		if(apn.MiddleName().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Middle Name field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Middle Name field is not available");
		}
		Assert.assertTrue(apn.LastName().isDisplayed()); //LastName
		if(apn.LastName().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Last Name field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Last Name field is not available");
		}
		Assert.assertTrue(apn.AddressOne().isDisplayed()); //AddressOne
		if(apn.AddressOne().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Address One field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Address One field is not available");
		}
		Assert.assertTrue(apn.AddressTwo().isDisplayed()); //AddressTwo
		if(apn.AddressTwo().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Address Two field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Address Two field is not available");
		}
		Assert.assertTrue(apn.City().isDisplayed()); //City
		if(apn.City().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","City field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","City field is not available");
		}
		//Couldnt check availablity of state as its a drop down value
		Assert.assertTrue(apn.Zip().isDisplayed()); //Zip
		if(apn.Zip().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Zip field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Zip field is not available");
		}
		//Couldnt check availablity of EnrollmentType as its a drop down value
		Assert.assertTrue(apn.DOB().isDisplayed()); //DOB
		if(apn.DOB().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","DOB field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","DOB field is not available");
		}
		Assert.assertTrue(apn.PartnerPatientID().isDisplayed()); //PartnerPatientID
		if(apn.PartnerPatientID().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","PartnerPatientID field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","PartnerPatientID field is not available");
		}
		Assert.assertTrue(apn.HIPAA().isDisplayed()); //HIPAA
		if(apn.HIPAA().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","HIPAA field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","HIPAA field is not available");
		}
		Assert.assertTrue(apn.PhysicianNPI().isDisplayed()); //PhysicianNPI
		if(apn.PhysicianNPI().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","PhysicianNPI field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","PhysicianNPI field is not available");
		}
		Assert.assertTrue(apn.PhysicianPartnerId().isDisplayed()); //PhysicianPartnerId
		if(apn.PhysicianPartnerId().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","PhysicianPartnerId field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","PhysicianPartnerId field is not available");
		}
		Assert.assertTrue(apn.PhysicianWorkPhone().isDisplayed()); //PhysicianWorkPhone
		if(apn.PhysicianWorkPhone().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","PhysicianWorkPhone field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","PhysicianWorkPhone field is not available");
		}
		Assert.assertTrue(apn.PhysicianFax().isDisplayed()); //PhysicianFax
		if(apn.PhysicianFax().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","PhysicianFax field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","PhysicianFax field is not available");
		}
		Assert.assertTrue(apn.AddButton().isDisplayed()); //AddButton
		if(apn.AddButton().isDisplayed()== true)
        {
        	TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","AddButton field is available");
		}
		else
		{
			TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","AddButton field is not available");
		}
		Assert.assertTrue(apn.AddButton().isDisplayed());
		boolean add= apn.AddButton().isDisplayed();
				
		 //Reporting
		if(add= true)
		{
			//TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			TestBase.classAInstance.logReport("Pass","Verified the Enrollment page content","Succesfully verified the enrollment page content-18");
		}
	   else
	   {
		    TestBase.classAInstance.logReport("Fail","Verified the Enrollment page content","Failed to verified the enrollment page content-18");
	   }
		
		 */
		AdminPortalLogout();
		
	}
		
		
		catch(AssertionError e)
        {
            System.out.println("Assertion error. ");
        }

	}

}
