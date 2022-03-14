package com.Replatform.qa.Fax.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.Faxes_Incoming;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC05_AdminPortal_Faxes_IncomingFaxesReviewPageContentTest extends AdminPortalLoginLogoutPage {
	
	Faxes_Incoming dat = new Faxes_Incoming();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_IncomingFindPage aff = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Faxes_IncomingPage aif = new AdminPortal_Faxes_IncomingPage();
	
	
	String Key = "IncomingFaxesReviewPageDropdownDefaults";
	
	
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
		public void CloseBrowser()
		{
			//Close the driver
			closeBrowser();
			TestBase.classAInstance.endReport();
		} 
		
	@Test ( description = "Verify the Faxes Incoming ReviewPage content")
	public void Verify_Incoming_ReviewPageContent() throws IOException, AWTException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetIncomingFaxesReviewPageDefaultDropdown(Key, rowNum);
		System.out.println("The testData is:" +testData);
		
		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		Thread.sleep(9000);
		aff.EnrollFromDate().click();
		Thread.sleep(9000);
		String[] DS = testData.get(9).split("-");
        String YDS = DS[2];
        String MDS = DS[1];
        String DDS = DS[0];

        System.out.println(MDS);
        System.out.println(DDS);
        
        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearDS.selectByValue(YDS);
    //    Thread.sleep(3000);
        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthDS.selectByVisibleText(MDS);
    //    Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
        for (WebElement col: columnsDS)
        { 
           if (col.getText().equals(DDS))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(DDS)).click();
              break;
           }
        }
        
        aff.FaxTYpeDropdown().selectByVisibleText("Other");
      
		aff.FaxesPageFindButton().click();
	//	wait.until(ExpectedConditions.visibilityOf(aff.PatientReviewLinkFirstRow()));
		Thread.sleep(25000);
		aff.PatientReviewLinkFirstRow().click();
		
		Assert.assertEquals(aif.ProgramDropdown().getFirstSelectedOption().getText(), testData.get(0));
		
		Assert.assertEquals(aif.FaxType().getFirstSelectedOption().getText(), testData.get(1));
		Assert.assertEquals(aif.FaxStatus().getFirstSelectedOption().getText(), testData.get(2));
		Assert.assertEquals(aif.EOBStatus().getFirstSelectedOption().getText(), testData.get(3));
		Assert.assertEquals(aif.PatientResidingState().getFirstSelectedOption().getText(), testData.get(4));
		Assert.assertEquals(aif.ProviderResidingState().getFirstSelectedOption().getText(), testData.get(5));
		
		Assert.assertEquals(aif.FaxInformationLabel().getText(), testData.get(6).trim());
		Assert.assertTrue(aif.FaxIDField().isDisplayed());
		Assert.assertTrue(aif.ANIField().isDisplayed());
		Assert.assertTrue(aif.AmountField().isDisplayed());
		Assert.assertTrue(aif.ReceivedDateField().isDisplayed());
		Assert.assertTrue(aif.ReviewedDateField().isDisplayed());
		Assert.assertTrue(aif.ApprovedDateField().isDisplayed());
		Assert.assertTrue(aif.ServiceDateField().isDisplayed());
		Assert.assertTrue(aif.InsuranceCompanyField().isDisplayed());
		Assert.assertTrue(aif.PatientTreatmentIDField().isDisplayed());
		
		Assert.assertEquals(aif.PatientInformationLabel().getText(), testData.get(7).trim());
		Assert.assertTrue(aif.IncomingFaxMemberID().isDisplayed());
		Assert.assertTrue(aif.PartnerPatientID().isDisplayed());
		Assert.assertTrue(aif.IncomingFaxCardID().isDisplayed());
		Assert.assertTrue(aif.ConfirmationRegistrationID().isDisplayed());
		Assert.assertTrue(aif.FaxPatientFirstName().isDisplayed());
		Assert.assertTrue(aif.FaxPatientLastName().isDisplayed());
		Assert.assertTrue(aif.ReenrolledCheckBox().isDisplayed());
		Assert.assertTrue(aif.CurrentBenefitsPeriod().isDisplayed());
		Assert.assertTrue(aif.RenerollmentDate().isDisplayed());
		Assert.assertTrue(aif.ClaimsDeadline().isDisplayed());
		Assert.assertTrue(aif.CurrentbenefitRetroPeriodDate().isDisplayed());
		
		Assert.assertEquals(aif.ProviderInformationLabel().getText(), testData.get(8));
		Assert.assertTrue(aif.ProviderName().isDisplayed());
		Assert.assertTrue(aif.ProviderContactLastName().isDisplayed());
		Assert.assertTrue(aif.ProviderContactFirstName().isDisplayed());
		Assert.assertTrue(aif.ProviderAddress().isDisplayed());
		Assert.assertTrue(aif.ProviderAddressTwo().isDisplayed());
		Assert.assertTrue(aif.ProviderCity().isDisplayed());
		Assert.assertTrue(aif.ProviderZip().isDisplayed());
		Assert.assertTrue(aif.ProviderPhone().isDisplayed());
		Assert.assertTrue(aif.ProviderNPI().isDisplayed());
		Assert.assertTrue(aif.ProviderFaxNumber().isDisplayed());
		Assert.assertTrue(aif.ProviderNotesTextArea().isDisplayed());
		
		System.out.println("column 10 data is:" +testData.get(10));
		System.out.println(driver.getCurrentUrl());
		//reporting
		if(driver.getCurrentUrl().equalsIgnoreCase(testData.get(10)))
		{
			//TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
			TestBase.classAInstance.logReport("Pass","Faxes Incoming ReviewPage content","Succesfully able to verify Faxes Incoming ReviewPage content");
		}
	    else
	    {
		    TestBase.classAInstance.logReport("Fail","Faxes Incoming ReviewPage content","Failed to verify Faxes Incoming ReviewPage content");
	    }
		AdminPortalLogout();
	}
}		
				

