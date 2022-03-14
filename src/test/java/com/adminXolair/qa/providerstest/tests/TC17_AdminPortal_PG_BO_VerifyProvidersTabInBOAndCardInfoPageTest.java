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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_ProvidersTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC17_AdminPortal_PG_BO_VerifyProvidersTabInBOAndCardInfoPageTest extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_ProvidersTab dat = new ProviderGroups_BillingOffice_ProvidersTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	String Key = "PGBOProvidersTabListGridCols";
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage gpc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgt = new AdminPortal_PG_BO_ProvidersTabPage();
	
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
	
	@Test ( description = "Verify the Providers tab page content in PG-->BO-->Review-->BO&CardInfo details page-->Providers tab")
	public void Verify_PG_GP_ProvidersTab() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBOProvidersTabHeaderCols(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPLastName().sendKeys(testData.get(1));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(2));
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		Assert.assertTrue(pgt.ProviderName().isDisplayed());
		Assert.assertTrue(pgt.ProviderContactLastName().isDisplayed());
		Assert.assertTrue(pgt.ProviderNPI().isDisplayed());
		Assert.assertTrue(pgt.AddButton().isDisplayed());
		pgt.ClickArrowDownToDisplayTable("showproviderrow");
		Thread.sleep(1000);
		//Assert the display of the list grid header cols
		int numCols = pgt.ProviderstabListGridHeaderCols().size(); 
		for(int i=1; i<=numCols; i++)
		{
			Assert.assertEquals(pgt.ProviderstabListGridHeaderColNames(i).getText(), testData.get(i+2));
		}
		
		Assert.assertTrue(!pgt.ProviderstabListGridHeaderCols().isEmpty());
		//AdminPortalLogout();
	}		

}
