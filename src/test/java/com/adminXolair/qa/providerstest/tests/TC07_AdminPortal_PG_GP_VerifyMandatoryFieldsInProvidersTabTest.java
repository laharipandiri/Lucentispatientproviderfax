package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ProvidersTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC07_AdminPortal_PG_GP_VerifyMandatoryFieldsInProvidersTabTest extends AdminPortalLoginLogoutPage {
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	String Key = "PGGPProviderstabMandatoryFields";

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage gpc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_ProvidersTabPage pgt = new AdminPortal_PG_GP_ProvidersTabPage();

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

	@Test(description = "Verify the required fields error msg in PG-->GP-->Review-->ProvidersTab")
	public void Verify_PG_GP_ProvidersTab_RequiredFieldsMsg() throws InterruptedException, IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetProvidersTabRequiredFieldsTestData(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys("a");
		pgf.GPProviderTypeDropdown().selectByVisibleText("Group Practice");
		pgf.GPFindButton().click();

		Thread.sleep(2000);

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		pgt.ProvidersTab().click();
		Thread.sleep(2000);

		pgt.AddButton().click();
		Assert.assertEquals(pgt.RequiredFieldsMsg().getText(), testData.get(0));

		//AdminPortalLogout();

	}

}
