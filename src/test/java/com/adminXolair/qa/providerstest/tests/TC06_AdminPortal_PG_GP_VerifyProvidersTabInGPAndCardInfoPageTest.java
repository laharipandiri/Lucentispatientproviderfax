package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ProvidersTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC06_AdminPortal_PG_GP_VerifyProvidersTabInGPAndCardInfoPageTest extends AdminPortalLoginLogoutPage {

	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	String Key = "PGGPProvidersTabListGridCols";

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage gpc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_ProvidersTabPage pgt = new AdminPortal_PG_GP_ProvidersTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgtbo = new AdminPortal_PG_BO_ProvidersTabPage();

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

	@Test(description = "Verify the Providers tab page content in PG-->GP-->Review-->GP&CardInfo details page-->Providers tab")
	public void Verify_PG_GP_ProvidersTab() throws InterruptedException, IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPGGPProvidersTabHeaderCols(Key, rowNum);
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys("t");
		pgf.GPProviderTypeDropdown().selectByVisibleText("Group Practice");
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		Thread.sleep(2000);

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		pgtbo.ClickArrowDownToDisplayTable("showproviderrow");
		Thread.sleep(2000);
		Assert.assertTrue(pgt.ProviderName().isDisplayed());
		Assert.assertTrue(pgt.ProviderContactLastName().isDisplayed());
		Assert.assertTrue(pgt.ProviderNPI().isDisplayed());
		
		// Assert the display of the list grid header cols
		int numCols = pgt.ProviderstabListGridHeaderCols().size();
		Assert.assertTrue(numCols > 0);
		for (int i = 1; i <= numCols; i++) {
			Assert.assertEquals(pgt.ProviderstabListGridHeaderColNames(i).getText(), testData.get(i - 1));
		}

		//AdminPortalLogout();
	}

}
