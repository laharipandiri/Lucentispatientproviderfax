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
import com.juno.qa.getandsetTestData.ProviderGroups_GroupPractice;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ListPage;
import com.juno.qa.pages.AdminPortal_PG_GP_NewPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC03_AdminPortal_PG_GP_FindGPTest extends AdminPortalLoginLogoutPage {

	TestUtil testUtil;

	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();
	ProviderGroups_GroupPractice dat = new ProviderGroups_GroupPractice();
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_NewPage agp = new AdminPortal_PG_GP_NewPage();
	AdminPortal_PG_GP_ListPage apl = new AdminPortal_PG_GP_ListPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage gpc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();

	String Key = "CreateNewGP";
	String Key1 = "PGGPFindPageSearchGrid";
	String Key2 = "PGGPFindPageFieldsDropdownDefault";

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

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

	@Test(description = "Verify the number of records displayed in Find page with no parameters passed and List(All) pages are the same")
	public void VerifyNumberOfRecordsBtwFindAndListAll() throws InterruptedException, IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPProviderLocationName().sendKeys("a");
		pgf.GPProviderTypeDropdown().selectByVisibleText("Group Practice");
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		String totalCount = apl.TotalCountLabel().getText().split(" ")[5];
		int count = Integer.valueOf(totalCount);
		Assert.assertTrue(count > 1);

		//AdminPortalLogout();
	}

	@Test(description = "verify ability to search by provider last name")
	public void SearchProviderGroupByLastName() throws InterruptedException, IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int  rowNum1 = etd.getKeyValuePair(Key2);
		List<String> dropdowndefaults = new ArrayList<String>();
		dropdowndefaults = dat.GetPGGPFindPageFieldsDropdownDefault(Key2, rowNum1);

		// The following is to get the row and col num of the last name test data in the
		// excel sheet
		List<Integer> existingrowColNum = etd.GetRowAndColNumOfTheFieldValue(Key, "Regression", "LastName");


		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(dropdowndefaults.get(1));
		pgf.GPProviderTypeDropdown().selectByVisibleText("Group Practice");
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		// verift PGGP Find page fields
		Assert.assertEquals(pgf.GPResidingStateDropdown().getFirstSelectedOption().getText(), dropdowndefaults.get(1));
		Assert.assertTrue(pgf.GPLastName().isDisplayed());
		Assert.assertTrue(pgf.GPProviderID().isDisplayed());
		Assert.assertTrue(pgf.GPTaxID().isDisplayed());
		Assert.assertTrue(pgf.GPProviderLocationName().isDisplayed());
		Assert.assertTrue(pgf.GPPartnerPracticeID().isDisplayed());
		Assert.assertTrue(pgf.GPNPI().isDisplayed());
		Assert.assertTrue(pgf.GPCity().isDisplayed());
		//Assert.assertEquals(pgf.GPProviderStatusDropdown().getFirstSelectedOption().getText(), dropdowndefaults.get(4));
		Assert.assertTrue(pgf.GPFindButton().isDisplayed());

		int rowNum = etd.getKeyValuePair(Key1);
		reader.setCellData("Regression", "LastNameTestData", rowNum + 1, null);
		gst.copyValueToDiffRow(Key1, existingrowColNum.get(1), existingrowColNum.get(0), rowNum, "LastNameTestData",
				"Regression");
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGroupPracticeFindTestData(Key1, rowNum);

		pgf.GPLastName().clear();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPFindButton().click();
		Thread.sleep(2000);

		List<WebElement> cols = new ArrayList<WebElement>();
		cols = pgf.FindPageGridCols();
		Assert.assertTrue(!cols.isEmpty());
		// verify all the column names are displayed
		for (int j = 1; j <= cols.size(); j++) {
			Assert.assertEquals(pgf.FindPageGridColNames(j).getText(), testData.get(j));
		}
		Assert.assertTrue(pgf.FirstReviewLinkInSearchGrid().isDisplayed());
		reader.setDataInNewRow("Regression", "PracticeLocationNameValue", rowNum, pgf.PracticeLocationNameColValue());// Firstname
		reader.setDataInNewRow("Regression", "ContactNameValue", rowNum, pgf.ContactNameColValue());
		reader.setDataInNewRow("Regression", "AddressValue", rowNum, pgf.AddressColValue());
		reader.setDataInNewRow("Regression", "CityValue", rowNum, pgf.CityColValue());
		String stateName = cf.GetResidingStateName(pgf.StateColValue());
		reader.setDataInNewRow("Regression", "StateValue", rowNum, stateName);
		reader.setDataInNewRow("Regression", "ZipValue", rowNum, pgf.ZipColValue());
		reader.setDataInNewRow("Regression", "PartnerPracticeID", rowNum, pgf.PartnerPracticeIDColValue());
		reader.setDataInNewRow("Regression", "ProviderTypeValue", rowNum, pgf.ProviderTypeColValue());
		reader.setDataInNewRow("Regression", "ProviderIDValue", rowNum, pgf.ProviderIDColValue());
		reader.setDataInNewRow("Regression", "ParentProviderID", rowNum, pgf.ParentProviderIDColValue());
		reader.setDataInNewRow("Regression", "NPI", rowNum, pgf.NPIColValue());
		reader.setDataInNewRow("Regression", "TaxIDValue", rowNum, pgf.TaxIDColValue());

		List<String> gpTestData = new ArrayList<String>();
		gpTestData = gst.GetGroupPracticeAndCardInfoData(Key1, rowNum);
		pgf.FirstReviewLinkInSearchGrid().click();
		Thread.sleep(2000);

		Assert.assertEquals(gpc.GroupPracticeNameFieldValue(), gpTestData.get(0));
		Assert.assertEquals(gpc.ProviderTypeDropDown().getFirstSelectedOption().getText(), gpTestData.get(7));
		Assert.assertEquals(gpc.NameFieldValue(), gpTestData.get(1));
		Assert.assertTrue(gpTestData.get(2).contains(gpc.AddressFieldValue()));
		Assert.assertEquals(gpc.CityFieldValue(), gpTestData.get(3));
		Assert.assertEquals(gpc.StateFieldValue(), gpTestData.get(4));
		Assert.assertEquals(gpc.ZipFieldValue().substring(0, 5), gpTestData.get(5));
		Assert.assertEquals(gpc.GroupPracticePartnerPracticeIDValue(), gpTestData.get(6));
		Assert.assertEquals(gpc.ProviderIDFieldValue(), gpTestData.get(8));
		Assert.assertEquals(gpc.NPIFieldValue(), gpTestData.get(10));

		Assert.assertTrue(gpc.UpdateButton().isDisplayed());

		//AdminPortalLogout();
	}
}
