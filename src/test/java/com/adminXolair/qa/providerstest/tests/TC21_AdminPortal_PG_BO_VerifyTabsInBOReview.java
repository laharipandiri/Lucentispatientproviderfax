package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_EFTTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FaxesTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_MerchantIDAndTerminalTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NotesTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_PatientsTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC21_AdminPortal_PG_BO_VerifyTabsInBOReview extends AdminPortalLoginLogoutPage {
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage gpc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgt = new AdminPortal_PG_BO_ProvidersTabPage();
	AdminPortal_PG_BO_PatientsTabPage pbp = new AdminPortal_PG_BO_PatientsTabPage();
	AdminPortal_PG_BO_NotesTabPage pbn = new AdminPortal_PG_BO_NotesTabPage();
	AdminPortal_PG_BO_EFTTabPage apb = new AdminPortal_PG_BO_EFTTabPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	
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
	@Test ( description = "Verify the tabs in PG-->BO-->Review")
	public void Verify_PG_BO_Review_TabsAvailableVerification() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		String lastNameToSearch = "Jackson";
		String providerType = "Billing Office";
				
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPLastName().sendKeys(lastNameToSearch);
		apgf.GPProviderTypeDropdown().selectByVisibleText(providerType);
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		List<String> tabslistBO = new ArrayList<String>();
		tabslistBO.add("Billing Office Info & Card Info");
		tabslistBO.add("Providers");
		tabslistBO.add("Parent Providers");
		tabslistBO.add("Patients");
		tabslistBO.add("Merchant ID(s) & Terminal(s)");
		tabslistBO.add("Notes");
		tabslistBO.add("Payments");
		tabslistBO.add("Preferences");
		tabslistBO.add("Transactions");
		tabslistBO.add("Users");
		
		for(String tabName: tabslistBO) {
			Assert.assertTrue(pbn.GetTabElement(tabName).isDisplayed());
		}
		
		Assert.assertTrue(gpc.BillingOfficeAndCardInfoTab().isDisplayed());

		
		//AdminPortalLogout();
	}		
	
		
}
		
		


