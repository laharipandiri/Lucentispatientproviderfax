package com.Replatform.qa.Fax.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.Faxes_Outgoing;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_OutgoingFindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC07_AdminPortal_Faxes_Outgoing_FindPageTest extends AdminPortalLoginLogoutPage {
	
	Faxes_Outgoing dat = new Faxes_Outgoing();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_OutgoingFindPage aff = new AdminPortal_Faxes_OutgoingFindPage();
	
	
	String Key = "OutgoingFaxesFindPageContent";
	
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
		
	@Test ( description = "Verify the Faxes Outgoing FindPage content")
	public void Verify_Outgoing_FindPageContent() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetOutgoingFaxesFindPageSearchGridCols(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.OutgoingFaxLink().click();
		Assert.assertEquals(aff.ProgramDropdown().getFirstSelectedOption().getText(), testData.get(16));

		Assert.assertEquals(aff.HelpDeskUserDropdown().getFirstSelectedOption().getText(), testData.get(17));
		Assert.assertEquals(aff.FaxTYpeDropdown().getFirstSelectedOption().getText(), testData.get(18));
		Assert.assertEquals(aff.FaxStatusDropdown().getFirstSelectedOption().getText(), testData.get(19));
		Assert.assertTrue(aff.EnrollFromDate().isDisplayed());
		Assert.assertTrue(aff.EnrollToDate().isDisplayed());
		Assert.assertTrue(aff.CardID().isDisplayed());
		Assert.assertTrue(aff.FaxID().isDisplayed());
		
		//grid cols
		for(int j=1; j<=aff.OutgoingFaxesSearchGridCols().size(); j++)
		{
			Assert.assertEquals(aff.OutgoingFaxesSearchGridColNames(j).getText(), testData.get(j));
		}
		
	
		
		AdminPortalLogout();
	}
}		
				
		

