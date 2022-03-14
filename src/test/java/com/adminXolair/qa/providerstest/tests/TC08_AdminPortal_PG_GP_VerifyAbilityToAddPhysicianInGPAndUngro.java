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
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_ParentProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
 class TC08_AdminPortal_PG_GP_VerifyAbilityToAddPhysicianInGPAndUngroupGPInPhysicianParentProvidersTabTest
		extends AdminPortalLoginLogoutPage {
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	String Key = "PGGPProvidersTabTestData";

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage gpc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_ProvidersTabPage pgt = new AdminPortal_PG_GP_ProvidersTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgtbo = new AdminPortal_PG_BO_ProvidersTabPage();
	AdminPortal_Providers_PhysicianAndCardInfoTabPage pct = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	AdminPortal_Providers_ParentProvidersTabPage ppt = new AdminPortal_Providers_ParentProvidersTabPage();
	AdminPortal_Providers_FindPage apf =  new AdminPortal_Providers_FindPage();

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

	@Test(description = "Verify the ability to add and ungroup a provider using ProviderName in PG-->GP-->Review-->ProvidersTab")
	public void Verify_PG_GP_ProvidersTab_AddAndUngroupProviderByProviderName()
			throws InterruptedException, IOException, AWTException {
		// This test searches for a provider by provider name, adds it to the GP and
		// then goes to that provider details page's Parent providers tab and ungroups
		// the provider from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPGGPProvidersTabTestData(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		Thread.sleep(2000);

		// Get the GP details to cross verify in ParentProviders tab in Physician
		// details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.PracticeLocationNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		pgt.ProvidersTab().click();
		Thread.sleep(2000);

		int totalProvidersBeforeCount = pgtbo.TotalProvidersCountFromTable();

		pgt.ProviderName().sendKeys(testData.get(2));// specify provider name
		Thread.sleep(3000);

		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());

		int attempts = 0;
		while (attempts < 2) {
			try {
				pgt.ProviderNameAutoSuggest().click();
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
			}
			attempts++;
		}
		Thread.sleep(2000);
		pgt.AddButton().click();
		Thread.sleep(3000);

		Assert.assertEquals(pgt.ProviderAddConfirmationMsg().getText(), testData.get(5));

		try {
			VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		} catch (InterruptedException e) {

		} catch (IOException ie) {

		} catch (AWTException awt) {

		}

		//AdminPortalLogout();
	}

	@Test(description = "Verify the ability to add and ungroup a provider using ProviderLastName in PG-->GP-->Review-->ProvidersTab")
	public void Verify_PG_GP_ProvidersTab_AddAndUngroupProviderByProviderLastName()
			throws InterruptedException, IOException, AWTException {
		// This test searches for a provider by provider name, adds it to the GP and
		// then goes to that provider details page's Parent providers tab and ungroups
		// the provider from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPGGPProvidersTabTestData(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		Thread.sleep(2000);

		// Get the GP details to cross verify in ParentProviders tab in Physician
		// details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.PracticeLocationNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		pgt.ProvidersTab().click();
		Thread.sleep(2000);

		int totalProvidersBeforeCount = pgtbo.TotalProvidersCountFromTable();

		pgt.ProviderContactLastName().sendKeys(testData.get(14));// specify provider last name
		Thread.sleep(3000);

		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());

		int attempts = 0;
		while (attempts < 2) {
			try {
				pgt.ProviderNameAutoSuggest().click();
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
			}
			attempts++;
		}
		Thread.sleep(2000);
		pgt.AddButton().click();
		Thread.sleep(3000);

		Assert.assertEquals(pgt.ProviderAddConfirmationMsg().getText(), testData.get(5));

		try {
			VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		} catch (InterruptedException e) {

		} catch (IOException ie) {

		} catch (AWTException awt) {

		}

		//AdminPortalLogout();
	}

	@Test(description = "Verify the ability to add and ungroup a provider using ProviderNPI in PG-->GP-->Review-->ProvidersTab")
	public void Verify_PG_GP_ProvidersTab_AddAndUngroupProviderByProviderNPI()
			throws InterruptedException, IOException, AWTException {
		// This test searches for a provider by provider name, adds it to the GP and
		// then goes to that provider details page's Parent providers tab and ungroups
		// the provider from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPGGPProvidersTabTestData(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		Thread.sleep(2000);

		// Get the GP details to cross verify in ParentProviders tab in Physician
		// details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.PracticeLocationNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());

		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));

		pgt.ProvidersTab().click();
		Thread.sleep(2000);

		int totalProvidersBeforeCount = pgtbo.TotalProvidersCountFromTable();

		pgt.ProviderNPI().sendKeys(testData.get(4));// specify provider NPI
		Thread.sleep(3000);

		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());

		int attempts = 0;
		while (attempts < 2) {
			try {
				pgt.ProviderNameAutoSuggest().click();
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
			}
			attempts++;
		}
		Thread.sleep(2000);
		pgt.AddButton().click();
		Thread.sleep(3000);

		Assert.assertEquals(pgt.ProviderAddConfirmationMsg().getText(), testData.get(5));

		try {
			VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		} catch (InterruptedException e) {

		} catch (IOException ie) {

		} catch (AWTException awt) {

		}

		//AdminPortalLogout();
	}

	public void VerifyAddedProviderAndUngroupingProvider(List<String> testData, List<String> GPtestDataFromUI,
			int totalProvidersBeforeCount) throws InterruptedException, IOException, AWTException {
		int totalProvidersAfterCount = pgtbo.TotalProvidersCountFromTable();
		// Now verify the total count has increased by one
		Assert.assertEquals(totalProvidersAfterCount, totalProvidersBeforeCount + 1);

		// the new record is added to the bottom of the list
		Assert.assertEquals(pgtbo.getLatestRowProviderNameColmunValue(), testData.get(6));
		Assert.assertEquals(pgtbo.getLatestRowContactNameColmunValue(), testData.get(7));
		Assert.assertEquals(pgtbo.getLatestRowAddressColmunValue(), testData.get(8));
		Assert.assertEquals(pgtbo.getLatestRowCityColmunValue(), testData.get(9));
		Assert.assertEquals(pgtbo.getLatestRowStateColmunValue(), testData.get(10));
		Assert.assertEquals(pgtbo.getLatestRowZipColmunValue(), testData.get(11));
		Assert.assertEquals(pgtbo.getLatestRowProviderTypeColmunValue(), testData.get(13));

		// click on review
		apf.ProvidersFindFirstReviewButtonByName(testData.get(2)).click();
		Thread.sleep(5000);
		Assert.assertTrue(pct.GetParentProvidersTab().isDisplayed());
		pct.GetParentProvidersTab().click();
		Thread.sleep(5000);
		List<WebElement> tablerows = ppt.ParentProvidersTabtableRows();
		Assert.assertTrue(!tablerows.isEmpty());
		for (int i = 0; i < tablerows.size(); i++) {
			int rowNum = i+1;
			String providerName = driver
					.findElement(
							By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[1]"))
					.getText();
			if (providerName.equalsIgnoreCase(GPtestDataFromUI.get(0)))// Practice location name/provider name are the
																		// same
			{
				int providersBeforeCount = tablerows.size();
				Assert.assertEquals(driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[2]"))
						.getText(), GPtestDataFromUI.get(1));// ContactName
				String address = driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[3]"))
						.getText();
				Assert.assertTrue(GPtestDataFromUI.get(2).contains(address));// Address
				Assert.assertEquals(driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[4]"))
						.getText(), GPtestDataFromUI.get(3));// City
				Assert.assertEquals(driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[5]"))
						.getText(), GPtestDataFromUI.get(4));// state
				Assert.assertEquals(driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[6]"))
						.getText(), GPtestDataFromUI.get(5));// zip
				Assert.assertEquals(driver
						.findElement(By
								.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum + "]//td[9]"))
						.getText(), GPtestDataFromUI.get(6));// providertype

				// reporting
				Assert.assertTrue(providerName.equalsIgnoreCase(GPtestDataFromUI.get(0)));

				// click on Ungroup
				driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + rowNum
						+ "]//td[10]//*[@value='Ungroup']")).click();
				Thread.sleep(2000);

				int providersAfterCount = ppt.ParentProvidersTabtableRows().size();
				Assert.assertEquals(providersAfterCount, providersBeforeCount - 1);

				break;
			}

		}

		// navigate back to PG-->GP-->GP details-->ProvidersTab: count should be reduced
		// by 1
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPLastName().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		Thread.sleep(2000);

		pgf.FirstReviewLinkInSearchGrid().click();
		Thread.sleep(2000);

		pgt.ProvidersTab().click();
		Thread.sleep(2000);

		int totalCountAfterUngroup = pgtbo.TotalProvidersCountFromTable();
		Assert.assertTrue(totalCountAfterUngroup < totalProvidersAfterCount);// totalProvidersAfterCount is the count
																				// after we added a provider to the
																				// group
	}

}
