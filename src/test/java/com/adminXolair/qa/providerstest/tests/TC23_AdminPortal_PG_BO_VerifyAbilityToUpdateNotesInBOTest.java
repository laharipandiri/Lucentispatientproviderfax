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
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NotesTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC23_AdminPortal_PG_BO_VerifyAbilityToUpdateNotesInBOTest extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_NotesTab dat = new ProviderGroups_BillingOffice_NotesTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_NotesTabPage pgn = new AdminPortal_PG_BO_NotesTabPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage pac = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	
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
	
	@Test ( description = "verify the ability to update notes for a BO")
	public void VerifyUpdatingNotesToBO() throws InterruptedException, IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		  
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
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
		
		pgn.getPGBOLatestRowActionsColmunValue().click();//Clicking on the edit link of the latest notes - which is the last row in the table
		Thread.sleep(5000);
		
		Assert.assertEquals(pgn.PGBONotesTextArea().getText(), testData.get(6));//verify the text area displays previously specified value after you click on Edit
		Assert.assertTrue(pgn.PGBONotesUpdateButton().isDisplayed());//make sure now the update button is displayed
		
		pgn.PGBONotesCallerDropdown().selectByVisibleText(testData.get(18));
		pgn.PGBONotesReasonDropdown().selectByVisibleText(testData.get(19));
		pgn.PGBONotesTextArea().clear();
		pgn.PGBONotesTextArea().sendKeys(testData.get(17));
		
		pgn.PGBONotesUpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertEquals(pgn.PGBONotesUpdatedConfirmationMsg().getText(), testData.get(20));
		
		Assert.assertEquals(pgn.getPGBOLatestRowReasonColmunValue(), testData.get(19));
		Assert.assertEquals(pgn.getPGBOLatestRowNotesColmunValue(), testData.get(17));
//		Assert.assertEquals(apn.getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(pgn.getPGBOLatestRowOriginatedFromColmunValue(), testData.get(18));
		//Assert.assertEquals(pgn.getPGBOLatestRowCreatedByColmunValue(), prop.getProperty("username"));
		//Assert.assertTrue(pgn.getPGBOLatestRowCreatedDateColmunValue().contains(currentDate));
		//Assert.assertEquals(pgn.getPGBOLatestRowModifiedByColmunValue(), prop.getProperty("username"));
		//Assert.assertTrue(pgn.getPGBOLatestRowModifiedDateColmunValue().contains(currentDate));
		Assert.assertTrue(pgn.getPGBOLatestRowActionsColmunValue().isDisplayed());
		Assert.assertTrue(pgn.PGBONotesUpdatedConfirmationMsg().getText().equalsIgnoreCase(testData.get(20)));
		//AdminPortalLogout();
	}		

}
