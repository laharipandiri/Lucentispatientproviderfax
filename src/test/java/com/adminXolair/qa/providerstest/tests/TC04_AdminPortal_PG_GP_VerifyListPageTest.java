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
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ListPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC04_AdminPortal_PG_GP_VerifyListPageTest extends AdminPortalLoginLogoutPage {
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_ListPage pgl = new AdminPortal_PG_GP_ListPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_ListPage apl = new AdminPortal_PG_GP_ListPage();

	String Key = "PGGPListPageContent";

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

	@Test(description = "verify the table header cols")
	public void verify_PG_GP_ListPageContent() throws IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGPPGListPageTestData(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPProviderLocationName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		List<WebElement> headerCols = pgl.HeaderColumns();
		Assert.assertEquals(headerCols.size() > 0, true);

		for (int j = 0; j < headerCols.size(); j++) {
			Assert.assertEquals(headerCols.get(j).getText(), testData.get(j + 2));
		}

		//AdminPortalLogout();
	}

	@Test(description = "Varify the total count after searching with GP")
	public void CrossVerifyGPCountsBetweenAlphabetListAndFindPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys("a");
		pgf.GPProviderTypeDropdown().selectByVisibleText("Group Practice");
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		String totalCount = apl.TotalCountLabel().getText().split(" ")[5];
		int count = Integer.valueOf(totalCount);

		Assert.assertTrue(count > 1);

		//AdminPortalLogout();
	}

}
