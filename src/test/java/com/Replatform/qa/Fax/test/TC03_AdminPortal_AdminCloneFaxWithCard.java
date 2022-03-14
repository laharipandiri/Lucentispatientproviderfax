package com.Replatform.qa.Fax.test;
//Script is click on Clone with Card but not verifying anythings
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
import com.juno.qa.pages.AdminPortal_Faxes_IncomingFindPage;
import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.pages.HubUploadEOBPage;
//Click on Clone a Fax with card and wait for edit/assign- then declare as passed/failed
@Listeners(TestNGListner.class)
public class TC03_AdminPortal_AdminCloneFaxWithCard extends HubHomeLoginLogoutPage {

	TestUtil testUtil;
	HubHomeLoginLogoutPage eft=new HubHomeLoginLogoutPage();
	HubUploadEOBPage ryu= new HubUploadEOBPage();
	AdminPortalLoginLogoutPage ttt= new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	AdminPortal_Faxes_IncomingFindPage aff = new AdminPortal_Faxes_IncomingFindPage();
	
	//Regression excel sheet
		//String Key = "UploadDocument";

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

		}
	}

	
	@Test ( description = "Clone a Fax")

	public void SearchFax() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ttt.AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
	/*
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
	*/	
		ahp.FaxesLink().click();
			
		ahp.IncomingFaxesLink().click();
		Thread.sleep(3000);
		
		
	//	System.out.println("Test dat in 2 is:" +testData.get(1));
		//ahp.IncomingFaxesCardNumber().sendKeys(testData.get(1));
		ahp.IncomingFaxesUser().selectByVisibleText("ALL");
		Thread.sleep(5000);
		Assert.assertTrue(ahp.IncomingFaxesFindButton().isDisplayed());
		ahp.IncomingFaxesFindButton().click(); //click on search button in Incoming Fax page
		Thread.sleep(6000);
		Assert.assertTrue(aff.CloneFaxWithCardFirstRowLinkBeforeClone().isDisplayed());
		aff.CloneFaxWithCardFirstRowLinkBeforeClone().click(); //click on Clone fax with card
		Thread.sleep(5000);
		//aff.EditAssignLinkFirstRow().click();
		
		//aff.CloneFaxFirstRowLinkBeforeClone().click();
		wait.until(ExpectedConditions.visibilityOf(aff.EditAssignLinkFirstRow()));
		Assert.assertTrue(aff.EditAssignLinkFirstRow().isDisplayed());
		
		/*	
		Assert.assertTrue(aff.VerifyAfterCloneFunctionality(testData, testData1, newFaxID[1]));
		
		//go back to faxes-->Incoming and reverify that the cloned fax is displayed
		//Assert.assertTrue(aff.VerifyNewClonesFaxIsInIncomingPage(newFaxID[1], testData.get(2)));
		
		
		*/	
		//ttt.AdminPortalLogout();
	}		



	@AfterMethod
	public void CloseBrowser() {
		//closeBrowser();
		TestBase.classAInstance.endReport();
		closeBrowser();
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	

}
