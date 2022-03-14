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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_Payments;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_PaymentsTab;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC29_AdminPortal_PG_BO_VerifyPaymentsTab extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	CommonFunctions cf = new CommonFunctions();
	
	ProviderGroups_BillingOffice_Payments dat = new ProviderGroups_BillingOffice_Payments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_FindPage apf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage apc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_PaymentsTab pbp = new AdminPortal_PG_BO_PaymentsTab();
	AdminPortal_PG_GP_FindPage gpf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_BO_ProvidersTabPage pgt = new AdminPortal_PG_BO_ProvidersTabPage();
	
	String Key = "BOPaymentsTab";
	String Key1 = "CheckToProviderCols";
	String Key2 = "EFTToProviderCols";

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
	
	@Test ( description = "Verify BO Payments tab content")
	public void VerifyBOPaymentsTabContent() throws IOException, AWTException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		int rowNum1 = etd.getKeyValuePair(Key1);
		int rowNum2 = etd.getKeyValuePair(Key2);
		
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPaymentsSearchFields(Key, rowNum);
		
		List<String> testData1 = new ArrayList<String>();
		testData1 = dat.GetCheckToProviderCols(Key1, rowNum1);
		
		List<String> testData2 = new ArrayList<String>();
		testData2 = dat.GetEFTToProviderCols(Key2, rowNum2);

		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		gpf.GPNPI().sendKeys(testData.get(0));
		gpf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		gpf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(apf.FirstReviewLinkInSearchGrid()));
		
		apf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(apc.BillingOfficeAndCardInfoTab()));
		
		pbp.PaymentsTab().click();
		wait.until(ExpectedConditions.visibilityOf(pbp.FindButton()));
		Thread.sleep(2000);
		System.out.println("Program name from UI:"+pbp.ProgramTypeDropdown().getFirstSelectedOption().getText());
		Assert.assertTrue(pbp.FromRequestDate().isDisplayed());
		Assert.assertTrue(pbp.ToRequestDate().isDisplayed());
		pgt.ClickArrowDownToDisplayTable("showcheckrow");
		//verify check to provider cols
		for(int i=1; i<=pbp.CheckToProviderTableCols().size(); i++)
		{
			Assert.assertEquals(pbp.CheckToProviderColNames(i).getText(), testData1.get(i));
		}
		pgt.ClickArrowDownToDisplayTable("showeftrow");
		//verify EFT to provider cols
		for(int i=1; i<=pbp.EFTToProviderTableCols().size(); i++)
		{
			Assert.assertEquals(pbp.EFTToProviderColNames(i).getText(), testData2.get(i));
		}
	}
	
}