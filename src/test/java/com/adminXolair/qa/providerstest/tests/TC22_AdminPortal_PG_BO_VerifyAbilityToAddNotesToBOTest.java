package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_NotesTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NotesTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC22_AdminPortal_PG_BO_VerifyAbilityToAddNotesToBOTest extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_NotesTab dat = new ProviderGroups_BillingOffice_NotesTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage pac = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_NotesTabPage pgn = new AdminPortal_PG_BO_NotesTabPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	
	String Key = "BONotes";
	
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
		// Close the driver
		AdminPortalLogout();
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	
	@Test ( description = "Verify the field value required message and default value for Caller and Reason dropdowns for Notes tab fields in BO")
	public void VerifyFieldRequiredMsgForNotesInBO() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBONotesTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(21));
		apgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		
		pgf.FirstReviewLinkInSearchGrid().click();//Click on the Review link for the first 
		Assert.assertTrue(pac.BillingOfficeAndCardInfoTab().isDisplayed());
		
		pgn.NotesTab().click();
		wait.until(ExpectedConditions.visibilityOf(pgn.PGBONotesAddButton()));
		
		Assert.assertEquals(pgn.PGBONotesCallerDropdown().getFirstSelectedOption().getText(), testData.get(2));
		Assert.assertEquals(pgn.PGBONotesReasonDropdown().getFirstSelectedOption().getText(), testData.get(3));
		
		pgn.PGBONotesAddButton().click();
		Assert.assertEquals(pgn.PGBONotesRequiredFieldMsg().getText(), testData.get(1));
		Assert.assertTrue(pgn.PGBONotesRequiredFieldMsg().getText().equalsIgnoreCase(testData.get(1)));
		
		//AdminPortalLogout();
	}		
	
	@Test ( description = "Verify ability to add notes in Notes tab in BO")
	public void VerifyAbilityToAddNotesInBO() throws IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBONotesTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(21));
		apgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		
		pgf.FirstReviewLinkInSearchGrid().click();//Click on the Review link for the first 
		Assert.assertTrue(pac.BillingOfficeAndCardInfoTab().isDisplayed());
		
		pgn.NotesTab().click();
		wait.until(ExpectedConditions.visibilityOf(pgn.PGBONotesAddButton()));
		
		//verify the table header column names
		int colCount = pgn.PGBONotesTableHeaderColumnsCount();
		Assert.assertTrue(colCount > 0);
		for(int i=1; i<=colCount; i++)
		{
			for(int j=i+6 ; j<=i+6 ; j++)//starting with this index because testData object list has col names from that index
			{
				Assert.assertEquals(pgn.PGBONotesTableColumnNames(i).getText(), testData.get(j));
			}
		}
		
		try {
				Assert.assertTrue(pgn.PGBOAddNotesInNotesTab(testData));
		}
		catch(InterruptedException e)
		{
			
		}
		
		Assert.assertEquals(pgn.PGBONotesAddedConfirmationMsg().getText(), testData.get(16));
		
		Assert.assertEquals(pgn.getPGBOLatestRowReasonColmunValue(), testData.get(5));
		Assert.assertEquals(pgn.getPGBOLatestRowNotesColmunValue(), testData.get(6));
//		Assert.assertEquals(apn.getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(pgn.getPGBOLatestRowOriginatedFromColmunValue(), testData.get(4));
		//Assert.assertEquals(pgn.getPGBOLatestRowCreatedByColmunValue(), prop.getProperty("username"));
		//Assert.assertTrue(pgn.getPGBOLatestRowCreatedDateColmunValue().contains(currentDate)); Possible bug
		//Assert.assertEquals(pgn.getPGBOLatestRowModifiedByColmunValue(), prop.getProperty("username"));
		//Assert.assertTrue(pgn.getPGBOLatestRowModifiedDateColmunValue().contains(currentDate)); Possible bug
		Assert.assertTrue(pgn.getPGBOLatestRowActionsColmunValue().isDisplayed());
		
		Assert.assertTrue(pgn.PGBONotesAddedConfirmationMsg().getText().equalsIgnoreCase(testData.get(16)));

		
		try {
			Assert.assertTrue(PGBOAddNotesAgainAndVerify(testData));
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		
		//AdminPortalLogout();
	}		
	
	public boolean PGBOAddNotesAgainAndVerify(List<String> testData) throws InterruptedException, IOException, AWTException
	{
		int beforeCount = pgn.PGBOGetNotesTableRowsCount();
		System.out.println("before adding count: "+beforeCount);
		pgn.PGBONotesCallerDropdown().selectByVisibleText(testData.get(4));
		pgn.PGBONotesReasonDropdown().selectByVisibleText(testData.get(5));
		
		pgn.PGBONotesTextArea().sendKeys(testData.get(6));
		Thread.sleep(1000);
		pgn.PGBONotesAddButton().click();
		
		Assert.assertEquals(pgn.PGBONotesAddedConfirmationMsg().getText(), testData.get(16));
		//First make sure that the rows count has been increased by 1
		int afterCount = pgn.PGBOGetNotesTableRowsCount();
		
		if(afterCount == (beforeCount+1))
		{
			return true;
		}
		
		Assert.assertTrue(pgn.PGBONotesAddedConfirmationMsg().getText().equalsIgnoreCase(testData.get(16)));
		return false;
		
	}	

}
