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
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_NotesTabPage;
import com.juno.qa.pages.AdminPortal_Providers_NotesTabPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC12_AdminPortal_PG_GP_VerifyAbilityToUpdateNotesInGPTest extends AdminPortalLoginLogoutPage {

	ProviderGroups_GroupPractice dat = new ProviderGroups_GroupPractice();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_NotesTabPage pgn = new AdminPortal_PG_GP_NotesTabPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage pac = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	
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
	
	@Test ( description = "verify the ability to update notes for a GP")
	public void VerifyUpdatingNotesToGP() throws InterruptedException, IOException, AWTException
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		  
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
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
		Assert.assertTrue(colCount>0);
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
		
		pgn.getPGGPLatestRowActionsColmunValue().click();//Clicking on the edit link of the latest notes - which is the last row in the table
		Thread.sleep(5000);
		
		Assert.assertEquals(pgn.PGGPNotesTextArea().getText(), testData.get(7));//verify the text area displays previously specified value after you click on Edit
		Assert.assertTrue(pgn.PGGPNotesUpdateButton().isDisplayed());//make sure now the update button is displayed
		
		pgn.PGGPNotesCallerDropdown().selectByVisibleText(testData.get(19));
		pgn.PGGPNotesReasonDropdown().selectByVisibleText(testData.get(20));
		pgn.PGGPNotesTextArea().clear();
		pgn.PGGPNotesTextArea().sendKeys(testData.get(18));
		
		pgn.PGGPNotesUpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertEquals(pgn.PGGPNotesUpdatedConfirmationMsg().getText(), testData.get(21));
		
		Assert.assertEquals(pgn.getPGGPLatestRowReasonColmunValue(), testData.get(20));
		Assert.assertEquals(pgn.getPGGPLatestRowNotesColmunValue(), testData.get(18));
//		Assert.assertEquals(apn.getLatestRowCardLoadColmunValue(), expected);//For now this is commented because we do not know what gets displayed here
		Assert.assertEquals(pgn.getPGGPLatestRowOriginatedFromColmunValue(), testData.get(19));
		Assert.assertEquals(pgn.getPGGPLatestRowCreatedByColmunValue().trim(), prop.getProperty("username").trim());
		//Assert.assertTrue(pgn.getPGGPLatestRowCreatedDateColmunValue().contains(currentDate));
		Assert.assertEquals(pgn.getPGGPLatestRowModifiedByColmunValue().trim(), prop.getProperty("username").trim());
		//Assert.assertTrue(pgn.getPGGPLatestRowModifiedDateColmunValue().contains(currentDate));
		Assert.assertTrue(pgn.getPGGPLatestRowActionsColmunValue().isDisplayed());
		
		Assert.assertTrue(pgn.PGGPNotesUpdatedConfirmationMsg().getText().equalsIgnoreCase(testData.get(21)));

		
		//AdminPortalLogout();
	}		
			
}
