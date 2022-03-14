package com.last.RegressionTestSet;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.commandhandler.UploadFile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubUploadEOBPage;

@Listeners(TestNGListner.class)
public class TC05_HCPPortal_UploadDocument extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	HubUploadEOBPage ryu= new HubUploadEOBPage();
	AdminPortalLoginLogoutPage ttt= new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	//Regression excel sheet
		String Key = "UploadDocument";
		String Key1 = "SmokePatientEnrollment";
		

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeHubDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	@Test(description = "HCP Upload document")
	public void HCPUpload() throws InterruptedException

	{		String title = driver.getTitle();
		
		try {
			//Get member ID from smoke script enrollment test case
			System.out.println("I am inside enrollment");
			
			System.out.println("The Key is:" +Key1);
			int rowNum1 = etd.getKeyValuePair(Key1);
			System.out.println("The rowNum is:" +rowNum1);
			List<String> testData1 = new ArrayList<String>();
			testData1 = gst.SmokeGetPhysicianNewPageRequiredFields(Key1, rowNum1); //Same method for all Provider
			System.out.println("testdata1 is:" +testData1);
			
			
			
			eft.HCPLogin();
			System.out.println("HCP login done");
			Thread.sleep(9000);
			
			eft.SearchByMemberID().sendKeys(testData1.get(20).trim());
			Thread.sleep(2000);
			eft.SearchButton().click();
			System.out.println("Clicked on SearchButton");
			Thread.sleep(9000);
			String MemberID= eft.SearchButtonMemberId().getText();
			if(MemberID!=null)
			{
				TestBase.classAInstance.logReport("Pass","HCP Upload Document","Succesfully able to click on the member ID in HCP portal");
		     }
		     else
		     {
		    	TestBase.classAInstance.logReport("Fail","HCP Upload Document","Failed to  click on the member ID in HCP portal");
		     }
			System.out.println("Member ID:" +MemberID);
			
			//Write test data back to upload document test cases
			System.out.println("The Key is:" +Key);
			int rowNum = etd.getKeyValuePair(Key);
			System.out.println("The rowNum is:" +rowNum);
			List<String> testData = new ArrayList<String>();
			testData = gst.GetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
			System.out.println("testdata is:" +testData);
			
			
			gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
			eft.UploadDocumentLink().click();
			Thread.sleep(10000);
			gst.setMemberIDInExcel(Key, MemberID, rowNum);
			System.out.println("I am above to click Document type");
			eft.DocumentType().click();
			System.out.println("I already clicked Document type");
			Thread.sleep(10000);
			eft.DocumentUploadBrowse().click();
			Thread.sleep(10000);
			 String FAXDocument = ryu.GetFilepath().getPath();
			//click on file upload button and select file
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
			String tyu= eft.DocumentUploadSubmitNumber().getText();
			System.out.println("Document upload number:" +tyu);
			if(tyu!=null)
			{
				TestBase.classAInstance.logReport("Pass","HCP Upload Document","Succesfully uploaded Fax in HCP portal and the referece number is:" +tyu);
		     }
		     else
		     {
		    	TestBase.classAInstance.logReport("Fail","HCP Upload Document","Failed to uploaded Fax in HCP portal");
		     }
			System.out.println("The uploaded document reference number is:" +tyu);
			closeBrowser();
					
		} catch (Exception e) {

		}

	}
	/*
	@Test ( description = "Verify the Uploaded Fax")
	public void SearchFax() throws InterruptedException, IOException, AWTException
	{
		intializeAdminDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ttt.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
	
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		
		ahp.FaxesLink().click();
			
		ahp.IncomingFaxesLink().click();
		Thread.sleep(3000);
		
		
		System.out.println("Test dat in 2 is:" +testData.get(1));
		ahp.IncomingFaxesCardNumber().sendKeys(testData.get(1));
		ahp.IncomingFaxesFindButton().click();
		Thread.sleep(5000);
		ahp.IncomingFaxesReview().click();
		Thread.sleep(3000);
		ahp.FaxType().selectByVisibleText("EOB");
		ahp.FaxStatus().selectByVisibleText("Reviewed");
		ahp.EOBStatus().selectByVisibleText("Approved");
		ahp.UploadEOBUpdateButton().click();
		Thread.sleep(3000);
		ahp.UploadEOBProcessEOB().click();
		if(ahp.UploadEOBProcessEOB().isDisplayed()==true)
		{
			TestBase.classAInstance.logReport("Pass","Admin Upload Document","Succesfully attached Fax in admin portal");
	     }
	     else
	     {
	    	TestBase.classAInstance.logReport("Fail","Admin Upload Document","Failed to attached Fax in admin portal");
	     }
			
		ttt.AdminPortalLogout();
	}		*/


	@AfterMethod
	public void CloseBrowser() {
		closeBrowser();
		TestBase.classAInstance.endReport();
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	

}
