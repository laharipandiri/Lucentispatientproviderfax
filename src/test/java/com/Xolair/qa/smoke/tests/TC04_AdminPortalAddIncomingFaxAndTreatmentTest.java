package com.Xolair.qa.smoke.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingPage;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.AdminPortal_Patients_TreatmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC04_AdminPortalAddIncomingFaxAndTreatmentTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testutil;
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	AdminPortal_Faxes_IncomingFindPage afp = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	String sheetname = "Smoke";
	String Key = "FaxAndTreatment";
	String Key1 = "EnrollPatient";
	String Key2 = "SearchEnrolledPatient";
	String Key3 = "CTMData";
 
	
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
	public void CloseBrowser()
	{
		closeBrowser();
		TestBase.classAInstance.endReport();
	} 
	
	@Test ( description = "Verify adding Incoming Fax")
	public void AddIncomingFaxAndTreatment() throws InterruptedException, IOException, AWTException
	{
		//String enrollFromDate = "10-Jan-2020";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		Thread.sleep(2000);
		
		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		wait.until(ExpectedConditions.visibilityOf(afp.EnrollFromDate()));
		Thread.sleep(2000);
		
		int rowNum = etd.getKeyValuePair(Key);
		
		String[] newColName = {"MemberID","PatientFirstName", "PartnerPatientID", "CardID"};
		List<Integer> rcNum = new ArrayList<Integer>();
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[0]);//get MemberID row & col from original row
		String MemberID = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[0], "Smoke");
		rcNum.clear();//Remove elements from the list
		
		
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[1]);//get PatientFirstName row & col from original row
		String PatientFirstName = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[1], "Smoke");
		rcNum.clear();
		
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key1, sheetname, newColName[2]);
		String PartnerPatientID = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[2], "Smoke");
		rcNum.clear();
		
		rcNum = etd.GetRowAndColNumOfTheFieldValue(Key2, sheetname, newColName[3]);
		//This cardID is from the recently enrolled patient. If there is a req. that an adhoc fax and treatment needs to be added for a cardID, we need t come up with diff test
		String CardID = gst.copyValueToDiffRow(Key, rcNum.get(1), rcNum.get(0), rowNum, newColName[3], "Smoke");
         
       
 		
 		afp.CardID().sendKeys(CardID);
         
        afp.FaxesPageFindButton().click();
        Thread.sleep(2000);
         
        //click on review link on the first search result
        afp.PatientReviewLinkFirstRow().click();
 		
 		if(aip.IncomingFaxMemberID().getAttribute("value").isEmpty())
 		{
 			aip.IncomingFaxMemberID().sendKeys(MemberID);
 		}
 		else
 		{
 			aip.IncomingFaxMemberID().clear();
 			aip.IncomingFaxMemberID().sendKeys(MemberID);
 		}
 		Thread.sleep(5000);
 		System.out.println("IncomingFaxMemberID"+aip.IncomingFaxMemberID().getAttribute("value"));
 		List<String> testData = new ArrayList<String>();
 		testData = gst.GetFaxAndTreatmentTestData(Key,rowNum);
 		atp.AddFaxInformationAndTreatmentToEnrolledPatients(testData, rowNum, "CTM");
		
 		  
        //make sure that the treatment has been added succesfully
        Assert.assertTrue(atp.TreatementAddConfirmation().isDisplayed());
       
        
        //Now write memberid, programname and amount to CTM sheet
        
        List<Integer> existingRCForAmount = etd.GetRowAndColNumOfTheFieldValue("FaxAndTreatment", "Smoke", "Copay");
        
        int ctmRowNum = etd.getKeyValuePair(Key3);
        
        //copy cardID value to CTM sheet for payment processing
        reader.setDataInNewRow("Smoke", "CardID", ctmRowNum, atp.ShortCardID().getText());
        
      //copy programname value to CTM sheet for payment processing
        reader.setDataInNewRow("Smoke", "ProgramName", ctmRowNum, atp.ProgramField().getAttribute("value"));
        
      //copy amount value to CTM sheet for payment processing
        String copay = gst.copyValueToDiffRow("CTMData", existingRCForAmount.get(1), existingRCForAmount.get(0), ctmRowNum, "Amount", "Smoke");
        
      //  System.out.println("atp.TreatementAddConfirmation().getText() : "+atp.TreatementAddConfirmation().getText());
        System.out.println("Patient's Treatment has been added successfully.");
        
        //verify that the status is accepted in the grid after adding a treatment
        int numOfRows = atp.TreatmentRequestsGridRows().size();
        for(int i=1; i<=numOfRows; i++)
        {
        	Assert.assertEquals(atp.GetTreatmentRequestsGridLatestRowStatusCol().getText(), testData.get(15));
        }
        
        //Reporting
        js.executeScript("window.scrollBy(0,1000)", "");
        if(atp.TreatementAddConfirmation().isDisplayed())
        {
        	TestBase.classAInstance.logReport("Pass","Add Fax and Treatment","Succesfully able to add fax and treatment");
		}
	   else
	   {
		    TestBase.classAInstance.logReport("Fail","Add Fax and Treatment","Failed to add fax and treatment");
	   }
        
        AdminPortalLogout();
		
		
	}
	
}
