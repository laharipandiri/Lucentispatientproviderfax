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
import com.juno.qa.getandsetTestData.Faxes_ListAll;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_ListAllFindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC06_AdminPortal_Faxes_ListAll_FindPageTest extends AdminPortalLoginLogoutPage {
	
	Faxes_ListAll dat = new Faxes_ListAll();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_ListAllFindPage afl = new AdminPortal_Faxes_ListAllFindPage();
	
	
	String Key = "ListAllFaxesFindPageContent";
	
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
		
	@Test ( description = "Verify the Faxes List All FindPage content")
	public void Verify_Outgoing_FindPageContent() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetListAllFaxesFindPageSearchGridCols(Key, rowNum);
		
		ahp.FaxesLink().click();
		
		ahp.IncomingFaxesLink().click();
		
		Assert.assertEquals(afl.ProgramDropdown().getFirstSelectedOption().getText(), testData.get(22));
		
		
		Assert.assertEquals(afl.HelpDeskUserDropdown().getFirstSelectedOption().getText(), testData.get(23));
		Assert.assertEquals(afl.FaxTYpeDropdown().getFirstSelectedOption().getText(), testData.get(24));
		Assert.assertEquals(afl.FaxStatusDropdown().getFirstSelectedOption().getText(), testData.get(25));
		Assert.assertTrue(afl.EnrollFromDate().isDisplayed());
		Assert.assertTrue(afl.EnrollToDate().isDisplayed());
		Assert.assertTrue(afl.CardID().isDisplayed());
		//The following is set to Equals for now as there is not data. Once data is available, we need to change these assertions to AssertTrue and contains()
		//grid cols
		for(int i=1; i<=afl.ListAllFaxesSearchGridCols().size();i++ )
		{
			if(i<7) {
						Assert.assertEquals(afl.ListAllFaxesSearchGridColNames(i).getText(), testData.get(i));
					 }	
					 else if(i==7)
					 		{
						 		for(int j=1; j<=afl.NestedTableDataCols().size(); j++)
						 		{
						 			Assert.assertEquals(afl.NestedTableDataColNames(j).getText(), testData.get(j+6));
						 		}
					 		}
					 else if(i>7)
					 {
						 Assert.assertEquals(afl.ListAllFaxesSearchGridColNames(i).getText(), testData.get(i+7));
					 }
			
		}
		
		//reporting
		
		
		AdminPortalLogout();
	}
}		
				
		
