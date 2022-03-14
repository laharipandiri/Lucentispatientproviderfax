package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.ProvideGroups_BillingOffice_Find;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ListPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC13_AdminPortal_PG_BO_VerifyFindPageTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	
	ProvideGroups_BillingOffice_Find dat = new ProvideGroups_BillingOffice_Find();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	GetAndSetTestData gst = new GetAndSetTestData();
	CommonFunctions cf = new CommonFunctions();
	
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_BO_FindPage pbf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_ListPage pbl = new AdminPortal_PG_BO_ListPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage pbc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	
	String Key = "PGBOFindPageFieldsDropdownDefault";
	String Key1 = "PGBOFindPageSearchGridCols";
	String Key2 = "PGBOFindPageSearchGrid";
	String Key3 = "CreateNewBO";

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
	
	@Test ( description = "Verify PG-->BO-->Find page content")
	public void VerifyPGBOFindPageContent() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(alp.AdminPortalLogoutButton()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBOFindPageFieldsDropdownDefault(Key, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		List<String> searchGridCols = new ArrayList<String>();
		searchGridCols = dat.GetPGBOFindPageSearchgridCols(Key1, rowNum1);
		
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPFirstName().sendKeys(testData.get(1));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(4));
		pbf.BOProviderStatusDropdown().selectByVisibleText("ALL");
		pgf.GPFindButton().click();
		
		//verift PGBOFind page fields
		Assert.assertTrue(pbf.BOLastName().isDisplayed());
		Assert.assertTrue(pbf.BOProviderID().isDisplayed());
		Assert.assertTrue(pbf.BOTaxID().isDisplayed());
		Assert.assertTrue(pbf.BOBillingOfficeName().isDisplayed());
		Assert.assertTrue(pbf.BOPartnerPracticeID().isDisplayed());
		Assert.assertTrue(pbf.BONPI().isDisplayed());
		Assert.assertTrue(pbf.BOCity().isDisplayed());
		Assert.assertEquals(pbf.BOResidingStateDropdown().getFirstSelectedOption().getText(), testData.get(2));
		Assert.assertEquals(pbf.BOProviderStatusDropdown().getFirstSelectedOption().getText(), testData.get(5));
		
		//verify the search grid cols
		for(int i=1; i<=pbf.FindPageGridCols().size(); i++)
		{
			Assert.assertEquals(pbf.FindPageGridColNames(i).getText(), searchGridCols.get(i));
		}
		Assert.assertTrue(!pbf.FindPageGridCols().isEmpty());
		//AdminPortalLogout();
	}		

	@Test (description = "Verify the number of records displayed in Find page with no parameters passed and List(All) pages are the same for BO")
	public void VerifyNumberOfRecordsBtwFindAndListAllForBO() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBOFindPageFieldsDropdownDefault(Key, rowNum);
				
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPFirstName().sendKeys(testData.get(1));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(4));
		pgf.GPFindButton().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		//First get the count from the List All link and cross verify with Find page
		String[] totalCount = pbl.BOListTotalCountLabel().getText().split(" ");
		int count = Integer.valueOf(totalCount[5]);
		Assert.assertEquals(count, pbl.BOGetTotalNoOfRows());
		//AdminPortalLogout();
	}		
 
	
	@Test ( description = "verify ability to search by provider last name in BO")
	public void SearchProviderGroupByLastNameInBO() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		//The following is to get the row and col num of the last name test data in the excel sheet
		int rowNum = etd.getKeyValuePair(Key2);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetBillingOfficeFindTestData(Key2, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		Thread.sleep(2000);
		
		Assert.assertTrue(pbf.FirstReviewLinkInSearchGrid().isDisplayed());
		//capture the col values onto excel - some are commented in the following as the UI does not display values for these now since during the enrollment no value was provided for these
		reader.setDataInNewRow("Regression", "ProviderNameValue", rowNum, pbf.getColValueByNumber(1));//Firstname of GP
		reader.setDataInNewRow("Regression", "ContactNameValue", rowNum, pbf.getColValueByNumber(2));
		reader.setDataInNewRow("Regression", "AddressValue", rowNum, pbf.getColValueByNumber(3));
		reader.setDataInNewRow("Regression", "CityValue", rowNum, pbf.getColValueByNumber(4));
		String stateName = cf.GetResidingStateName(pbf.getColValueByNumber(5));
		reader.setDataInNewRow("Regression", "StateValue", rowNum, stateName);
		reader.setDataInNewRow("Regression", "ZipValue", rowNum, pbf.getColValueByNumber(6));
		reader.setDataInNewRow("Regression", "PartnerPracticeIDValue", rowNum, pbf.getColValueByNumber(7));
		reader.setDataInNewRow("Regression", "StatusValue", rowNum, pbf.getColValueByNumber(8));
		reader.setDataInNewRow("Regression", "ProviderTypeValue", rowNum, pbf.getColValueByNumber(9));
		reader.setDataInNewRow("Regression", "ProviderIDValue", rowNum, pbf.getColValueByNumber(10));
		reader.setDataInNewRow("Regression", "ParentProviderIDValue", rowNum, pbf.getColValueByNumber(11));
		reader.setDataInNewRow("Regression", "NPIValue", rowNum, pbf.getColValueByNumber(12));
		reader.setDataInNewRow("Regression", "TAXIDValue", rowNum, pbf.getColValueByNumber(13));
		//not copying CardIDValue, PartnerPracticeIDValue, NPIcolvalue and CRXPhysicianIDValue because they have no values in PG-->GP-->Find page. While enrollment we do not specify these values for now
		
		List<String> boTestData = new ArrayList<String>();
		boTestData = dat.GetBillingOfficeAndCardInfoData(Key2, rowNum);
		//cross check excel values and group practice info and card info tab field values are the same
		pbf.FirstReviewLinkInSearchGrid().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(pbc.BillingOfficeNameFieldValue(), boTestData.get(0));
		Assert.assertEquals(pbc.ProviderTypeDropDown().getFirstSelectedOption().getText(), boTestData.get(8));
		Assert.assertEquals(pbc.AddressFieldValue(), boTestData.get(2));
		Assert.assertEquals(pbc.CityFieldValue(), boTestData.get(3));
		Assert.assertEquals(pbc.StateFieldValue(), boTestData.get(4));
		Assert.assertEquals(pbc.ZipFieldValue().substring(0, 5), boTestData.get(5));
		Assert.assertEquals(pbc.TaxIDFieldValue(), boTestData.get(12));
		Assert.assertTrue(pbc.UpdateButton().isDisplayed());

		//AdminPortalLogout(); 
	}		

}
