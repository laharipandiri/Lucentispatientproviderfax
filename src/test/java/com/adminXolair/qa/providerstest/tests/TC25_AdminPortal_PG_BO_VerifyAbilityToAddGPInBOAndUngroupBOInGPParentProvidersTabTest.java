package com.adminXolair.qa.providerstest.tests;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_ProvidersTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ParentProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC25_AdminPortal_PG_BO_VerifyAbilityToAddGPInBOAndUngroupBOInGPParentProvidersTabTest extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_ProvidersTab dat = new ProviderGroups_BillingOffice_ProvidersTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	String Key = "PGBOProvidersTabGPTestData";
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage gpc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgt = new AdminPortal_PG_BO_ProvidersTabPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage pct = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_ParentProvidersTabPage ppt = new AdminPortal_PG_GP_ParentProvidersTabPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_Providers_FindPage apf =  new AdminPortal_Providers_FindPage();
	
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
	
	@Test ( description = "Verify the ability to add and ungroup a provider using ProviderName in PG-->BO-->Review-->ProvidersTab")
	public void Verify_PG_BO_ProvidersTab_AddAndUngroupProviderByProviderName() throws InterruptedException, IOException, AWTException
	{
		//This test searches for a provider by provider name, adds it to the BO and then goes to that GP details page's Parent providers tab and ungroups the BO from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.PGBOProvidersTabGPTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(12));
		apgf.GPProviderTypeDropdown().selectByVisibleText("Billing Office");
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		//Get the GP details to cross verify in ParentProviders tab in Physician details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.BillingOfficeNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
	//	GPtestDataFromUI.add(6, pgf.TerritoryColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());
		
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		int totalProvidersBeforeCount = pgt.TotalProvidersCountFromTable();
		
		pgt.ProviderName().sendKeys(testData.get(0));//specify GP name
		Thread.sleep(1000);
		
		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	pgt.ProviderNameAutoSuggest().click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);

		pgt.AddButton().click();
		Thread.sleep(3000);
		
		Assert.assertTrue(pgt.ProviderAddConfirmationMsg().getText().equalsIgnoreCase(testData.get(3)));
		
		try {
				VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		//AdminPortalLogout();
	}		
	
	
	@Test ( description = "Verify the ability to add and ungroup a provider using ProviderLastName in PG-->BO-->Review-->ProvidersTab")
	public void Verify_PG_BO_ProvidersTab_AddAndUngroupProviderByProviderLastName() throws InterruptedException, IOException, AWTException
	{
		//This test searches for a provider by provider name, adds it to the BO and then goes to that GP details page's Parent providers tab and ungroups the BO from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.PGBOProvidersTabGPTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(12));
		apgf.GPProviderTypeDropdown().selectByVisibleText("Billing Office");
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		//Get the GP details to cross verify in ParentProviders tab in Physician details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.BillingOfficeNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
	//	GPtestDataFromUI.add(6, pgf.TerritoryColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());
		
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		int totalProvidersBeforeCount = pgt.TotalProvidersCountFromTable();
		
		pgt.ProviderContactLastName().sendKeys(testData.get(1));//specify GP name
		Thread.sleep(1000);
		
		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	pgt.ProviderNameAutoSuggest().click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);

		pgt.AddButton().click();
		Thread.sleep(3000);
		
		Assert.assertTrue(pgt.ProviderAddConfirmationMsg().getText().equalsIgnoreCase(testData.get(3)));
		
		try {
				VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		//AdminPortalLogout();
	}		
	
	@Test ( description = "Verify the ability to add and ungroup a provider using ProviderNPI in PG-->BO-->Review-->ProvidersTab")
	public void Verify_PG_BO_ProvidersTab_AddAndUngroupProviderByProviderNPI() throws InterruptedException, IOException, AWTException
	{
		//This test searches for a provider by provider name, adds it to the BO and then goes to that GP details page's Parent providers tab and ungroups the BO from GP
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.PGBOProvidersTabGPTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(12));
		apgf.GPProviderTypeDropdown().selectByVisibleText("Billing Office");
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		//Get the GP details to cross verify in ParentProviders tab in Physician details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.BillingOfficeNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
	//	GPtestDataFromUI.add(6, pgf.TerritoryColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());
		
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		int totalProvidersBeforeCount = pgt.TotalProvidersCountFromTable();
		
		pgt.ProviderNPI().sendKeys(testData.get(2));//specify GP name
		Thread.sleep(1000);
		
		Assert.assertTrue(pgt.ProviderNameAutoSuggest().isDisplayed());
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	pgt.ProviderNameAutoSuggest().click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);

		pgt.AddButton().click();
		Thread.sleep(3000);
		
		Assert.assertTrue(pgt.ProviderAddConfirmationMsg().getText().equalsIgnoreCase(testData.get(3)));
		
		try {
				VerifyAddedProviderAndUngroupingProvider(testData, GPtestDataFromUI, totalProvidersBeforeCount);
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		//AdminPortalLogout();
	}		
	
	public void VerifyAddedProviderAndUngroupingProvider(List<String> testData, List<String> GPtestDataFromUI, int totalProvidersBeforeCount) throws InterruptedException, IOException, AWTException
	{
		int totalProvidersAfterCount = pgt.TotalProvidersCountFromTable();
		//Now verify the total count has increased by one
		Assert.assertEquals(totalProvidersAfterCount, totalProvidersBeforeCount+1);
		
		//the new record is added to the bottom of the list
		Map<String, String> tableRowData = pgt.getProviderRowsDataByName(testData.get(4));
		Assert.assertEquals(tableRowData.get("Provider Name"), testData.get(4));
		Assert.assertEquals(tableRowData.get("Contact Name"), testData.get(5));
		Assert.assertEquals(tableRowData.get("Address"), testData.get(6));
		Assert.assertEquals(tableRowData.get("City"), testData.get(7));
		Assert.assertEquals(tableRowData.get("State"), testData.get(8));
		Assert.assertEquals(tableRowData.get("Zip"), testData.get(9));
		Assert.assertEquals(tableRowData.get("Provider Type"), testData.get(11));
		
		//click on review
		apf.ProvidersFindFirstReviewButtonByName(testData.get(4)).click();
		Thread.sleep(5000);
		Assert.assertTrue(ppt.ParentProvidersTab().isDisplayed());
		ppt.ParentProvidersTab().click();
		int noOfRowsBefore = ppt.ParentProvidersTabtableRows().size();
		assertTrue(noOfRowsBefore > 0);
		//verify the data between providers tab grid in GP and providers tab in Physician after clicking on review
		for(int i=1; i<=noOfRowsBefore; i++)
		{
			if(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[1]")).getText().equalsIgnoreCase(GPtestDataFromUI.get(0)))//Practice location name/provider name are the same
			{
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[2]")).getText(), GPtestDataFromUI.get(1));//ContactName
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[3]")).getText(), GPtestDataFromUI.get(2));//Address
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[4]")).getText(), GPtestDataFromUI.get(3));//City
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[5]")).getText(), GPtestDataFromUI.get(4));//state
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[6]")).getText(), GPtestDataFromUI.get(5));//zip
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[9]")).getText(), GPtestDataFromUI.get(6));//providertype
				
				Assert.assertTrue(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[1]")).getText().equalsIgnoreCase(GPtestDataFromUI.get(0)));
				
				driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//*[@value='Ungroup']")).click();
				Thread.sleep(2000);
				
				int providersAfterCount = ppt.ParentProvidersTabtableRows().size();
				Assert.assertEquals(providersAfterCount, noOfRowsBefore-1);
				break;

			}
		}
		
		//navigate back to PG-->GP-->GP details-->ProvidersTab: count should be reduced by 1
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(12));
		apgf.GPProviderTypeDropdown().selectByVisibleText("Billing Office");
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		pgf.FirstReviewLinkInSearchGrid().click();
		Thread.sleep(2000);
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		int totalCountAfterUngroup = pgt.TotalProvidersCountFromTable();
		Assert.assertTrue(totalCountAfterUngroup < totalProvidersAfterCount);//totalProvidersAfterCount is the count after we added a provider to the group
	}

}
