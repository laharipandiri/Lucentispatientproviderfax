package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC05_AdminPortal_PG_GP_VerifyUpdatesToGPAndCardInfoPageTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	CommonFunctions cf = new CommonFunctions();

	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage gpc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();

	String Key = "GroupPracticeAndCardInfoUpdate";

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

	@Test(description = "Verify ability to update required fields in Group practice and card info tab")
	public void verifyUpdatesToGPAndCardInfoTab() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGPAndCardInfoTestDataForUpdate(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPNPI().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		try {
			VerifyUpdatesToGPAndCardInfo(testData, rowNum);
		} catch (InterruptedException e) {

		} catch (IOException ie) {

		} catch (AWTException awt) {

		}

		//AdminPortalLogout();
	}

	public void VerifyUpdatesToGPAndCardInfo(List<String> testData, int rowNum)
			throws InterruptedException, IOException, AWTException {
		// Now update the fields
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String firstname = TestUtil.randomAlpha(5);
		String lastname = TestUtil.randomAlpha(5);

		String practicename = lastname + " " + firstname;

		gpc.GPAndCardFirstName().clear();
		gpc.GPAndCardFirstName().sendKeys(firstname);

		gpc.GPAndCardLastName().clear();
		gpc.GPAndCardLastName().sendKeys(lastname);

		gpc.GPAndCardGPName().clear();
		gpc.GPAndCardGPName().sendKeys(practicename);

		gpc.GPAndCardAddress().clear();
		gpc.GPAndCardAddress().sendKeys(TestUtil.randomAlphaNumeric(8));

		gpc.GPAndCardCity().clear();
		gpc.GPAndCardCity().sendKeys(TestUtil.randomAlpha(8));

		int stateNum = cf.SelectRandomState(gpc.GPAndCardState());
		gpc.GPAndCardState().get(stateNum).click();

		gpc.GPAndCardZip().click();
		Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			gpc.GPAndCardZip().sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
		}
		gpc.GPAndCardZip().sendKeys(TestUtil.randomNumeric(5));

		gpc.GPAndCardPhone().click();
		Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			gpc.GPAndCardPhone().sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
		}
		gpc.GPAndCardPhone().sendKeys(TestUtil.randomNumeric(10));

		gpc.GPAndCardTax().clear();
		gpc.GPAndCardTax().sendKeys(TestUtil.randomNumeric(12));

		String email = firstname + "." + lastname + "@connectiverx.com";
		gpc.GPAndCardEmail().clear();
		gpc.GPAndCardEmail().sendKeys(email);

		gpc.GPAndCardConfirmEmail().sendKeys(email);

		gpc.UpdateButton().click();
		Thread.sleep(2000);
		String updateConfirmationMsg = "Processed: ID = " + gpc.ProviderIDFieldValue();
		// scroll down to capture the screenshot at the correct location
		js.executeScript("window.scrollBy(0,800)", "");
		Assert.assertTrue(gpc.GPUpdateConfirmationMessage().getText().equalsIgnoreCase(updateConfirmationMsg));

	}

}
