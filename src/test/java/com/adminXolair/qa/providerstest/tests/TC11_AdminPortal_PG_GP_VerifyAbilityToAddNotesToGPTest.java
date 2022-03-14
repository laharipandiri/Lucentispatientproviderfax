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
import com.juno.qa.getandsetTestData.ProviderGroups_GroupPractice;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_NotesTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC11_AdminPortal_PG_GP_VerifyAbilityToAddNotesToGPTest extends AdminPortalLoginLogoutPage {

	ProviderGroups_GroupPractice dat = new ProviderGroups_GroupPractice();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage pac = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_NotesTabPage pgn = new AdminPortal_PG_GP_NotesTabPage();
	
	String Key = "GPNotes";
	
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
	public void CloseBrowser(ITestResult result) throws IOException, AWTException
	{
		

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
		//Close the driver
		AdminPortalLogout();
		closeBrowser();
		TestBase.classAInstance.endReport();
	} 
	
	@Test ( description = "Verify the field value required message and default value for Caller and Reason dropdowns for Notes tab fields in GP")
	public void VerifyFieldRequiredMsgForNotesInGP() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGGPNotesTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPNPI().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		
		pgf.FirstReviewLinkInSearchGrid().click();//Click on the Review link for the first 
		Assert.assertTrue(pac.GroupPracticeAndCardInfoTab().isDisplayed());
		
		pgn.PGGPNotesTab().click();
		wait.until(ExpectedConditions.visibilityOf(pgn.PGGPNotesAddButton()));
		
		Assert.assertEquals(pgn.PGGPNotesCallerDropdown().getFirstSelectedOption().getText(), testData.get(3));
		Assert.assertEquals(pgn.PGGPNotesReasonDropdown().getFirstSelectedOption().getText(), testData.get(4));
		
		pgn.PGGPNotesAddButton().click();
		Assert.assertEquals(pgn.PGGPNotesRequiredFieldMsg().getText(), testData.get(2));
		Assert.assertTrue(pgn.PGGPNotesRequiredFieldMsg().getText().equalsIgnoreCase(testData.get(2)));
		//AdminPortalLogout();
	}		

	@Test ( description = "Verify ability to add notes in Notes tab in GP")
	public void VerifyAbilityToAddNotesInGP() throws IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGGPNotesTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPNPI().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		
		pgf.FirstReviewLinkInSearchGrid().click();//Click on the Review link for the first 
		Assert.assertTrue(pac.GroupPracticeAndCardInfoTab().isDisplayed());
		
		pgn.PGGPNotesTab().click();
		wait.until(ExpectedConditions.visibilityOf(pgn.PGGPNotesAddButton()));
		
		//verify the table header column names
		int colCount = pgn.PGGPNotesTableHeaderColumnsCount();
		for(int i=1; i<=colCount; i++)
		{
			for(int j=i+7 ; j<=i+7 ; j++)//starting with this index because testData object list has col names from that index
			{
				Assert.assertEquals(driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th["+i+"]")).getText(), testData.get(j));
			}
		}
		
		try {
				Assert.assertTrue(pgn.PGGPAddNotesInNotesTab(testData));
		}
		catch(InterruptedException e)
		{
			
		}
		
		Assert.assertEquals(pgn.PGGPNotesAddedConfirmationMsg().getText(), testData.get(17));
		
		Assert.assertEquals(pgn.getPGGPLatestRowReasonColmunValue(), testData.get(6));
		Assert.assertEquals(pgn.getPGGPLatestRowNotesColmunValue(), testData.get(7));
//		Assert.assertEquals(apn.getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(pgn.getPGGPLatestRowOriginatedFromColmunValue(), testData.get(5));
		Assert.assertEquals(pgn.getPGGPLatestRowCreatedByColmunValue().trim(), prop.getProperty("username").trim());
		//Assert.assertTrue(pgn.getPGGPLatestRowCreatedDateColmunValue().contains(currentDate));
		Assert.assertEquals(pgn.getPGGPLatestRowModifiedByColmunValue().trim(), prop.getProperty("username").trim());
		//Assert.assertTrue(pgn.getPGGPLatestRowModifiedDateColmunValue().contains(currentDate));
		Assert.assertTrue(pgn.getPGGPLatestRowActionsColmunValue().isDisplayed());
		
		Assert.assertTrue(pgn.PGGPNotesAddedConfirmationMsg().getText().equalsIgnoreCase(testData.get(17)));
			
		
		try {
			Assert.assertTrue(PGGPAddNotesAgainAndVerify(testData));
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

	
	public boolean PGGPAddNotesAgainAndVerify(List<String> testData) throws InterruptedException, IOException, AWTException
	{
		int beforeCount = pgn.PGGPGetNotesTableRowsCount();
		System.out.println("before adding count: "+beforeCount);
		pgn.PGGPNotesCallerDropdown().selectByVisibleText(testData.get(5));
		pgn.PGGPNotesReasonDropdown().selectByVisibleText(testData.get(6));
		
		pgn.PGGPNotesTextArea().sendKeys(testData.get(7));
		Thread.sleep(1000);
		pgn.PGGPNotesAddButton().click();
		
		Assert.assertEquals(pgn.PGGPNotesAddedConfirmationMsg().getText(), testData.get(17));
		
		//reporting
		Assert.assertTrue(pgn.PGGPNotesAddedConfirmationMsg().getText().equalsIgnoreCase(testData.get(17)));
		
		//First make sure that the rows count has been increased by 1
		int afterCount = pgn.PGGPGetNotesTableRowsCount();
		
		if(afterCount == (beforeCount+1))
		{
			return true;
		}
		
		return false;
	}		
}
