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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_ProvidersTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_ProvidersTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_ParentProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC24_AdminPortal_PG_BO_VerifyAbilityToAddAndUngroupPhysicianInBOTest extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_ProvidersTab dat = new ProviderGroups_BillingOffice_ProvidersTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	String Key = "PGBOProvidersTabTestData";
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage gpc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_ProvidersTabPage pgt = new AdminPortal_PG_BO_ProvidersTabPage();
	AdminPortal_Providers_PhysicianAndCardInfoTabPage pct = new AdminPortal_Providers_PhysicianAndCardInfoTabPage();
	AdminPortal_Providers_ParentProvidersTabPage ppt = new AdminPortal_Providers_ParentProvidersTabPage();
	AdminPortal_Providers_FindPage apf =  new AdminPortal_Providers_FindPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	
	WebDriverWait wait;
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
	
	@Test ( description = "Verify the ability to add and ungroup a provider in PG-->BO-->Review-->ProvidersTab ")
	public void Verify_Providers_ParentProvidersTab_AddAndUngroupProvider() throws InterruptedException, IOException, AWTException
	{
/*		This test searches for a provider by provider name, adds it to the BO and then goes to that provider details page's 
		Parent providers tab and reviews the provider and then navigates back to BO and ungroups the Provider from BO */
		
		wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBOProvidersTabTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPLastName().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		//Get the GP details to cross verify in ParentProviders tab in Physician details page
		List<String> GPtestDataFromUI = new ArrayList<String>();
		GPtestDataFromUI.add(0, pgf.BillingOfficeNameColValue());
		GPtestDataFromUI.add(1, pgf.ContactNameColValue());
		GPtestDataFromUI.add(2, pgf.AddressColValue());
		GPtestDataFromUI.add(3, pgf.CityColValue());
		GPtestDataFromUI.add(4, pgf.StateColValue());
		GPtestDataFromUI.add(5, pgf.ZipColValue());
		GPtestDataFromUI.add(6, pgf.ProviderTypeColValue());
		
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		
		int totalProvidersBeforeCount = pgt.TotalProvidersCountFromTable();
		
		pgt.ProviderName().sendKeys(testData.get(2));//specify provider name
		Thread.sleep(3000);
		
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
		
		Assert.assertEquals(pgt.ProviderAddConfirmationMsg().getText(), testData.get(5));
		
		int totalProvidersAfterCount = pgt.TotalProvidersCountFromTable();
		//Now verify the total count has increased by one
		//Assert.assertEquals(totalProvidersAfterCount, totalProvidersBeforeCount+1);
		
		//Now go to Providers-->Find and search for the above added provider and navigate to the Parent providers tab
		Thread.sleep(2000);
		
		apf.ProvidersFindFirstReviewButton().click();
		wait.until(ExpectedConditions.visibilityOf(pct.GetPhysicanAndCardInfoTab()));
		
		pct.GetParentProvidersTab().click();
		Thread.sleep(2000);
		List<WebElement> tablerows = ppt.ParentProvidersTabtableRows();
		Assert.assertTrue(!tablerows.isEmpty());
		//verify the data between providers tab grid in GP and providers tab in Physician after clicking on review
		for(int i=0; i<tablerows.size(); i++)
		{	
			int row = i+1;
			if(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[1]")).getText().equalsIgnoreCase(GPtestDataFromUI.get(0)))//Practice location name/provider name are the same
			{
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[2]")).getText(), GPtestDataFromUI.get(1));//ContactName
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[3]")).getText(), GPtestDataFromUI.get(2));//Address
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[4]")).getText(), GPtestDataFromUI.get(3));//City
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[5]")).getText(), GPtestDataFromUI.get(4));//state
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[6]")).getText(), GPtestDataFromUI.get(5));//zip
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[9]")).getText(), GPtestDataFromUI.get(6));//providertype
				Assert.assertTrue(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[1]")).getText().equalsIgnoreCase(GPtestDataFromUI.get(0)));
				//click on review link
				driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + row + "]//td[10]//*[@value='Review']")).click();
				Thread.sleep(2000);
				break;
				
			}
		}
		
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		pgt.ProvidersTab().click();
		pgt.ClickArrowDownToDisplayTable("showproviderrow");
		WebElement ungroupLink = apf.ProvidersFindFirstUngroupButtonByName(testData.get(2));
		wait.until(ExpectedConditions.visibilityOf(ungroupLink));
		ungroupLink.click();
		int afterUngroupCount = pgt.TotalProvidersCountFromTable();
		Assert.assertTrue(afterUngroupCount<totalProvidersAfterCount);
		
		//AdminPortalLogout();
	}		
	
	public boolean VerifyUngroupOfGroupPractice(String providerNPI, String groupPracticeName) throws InterruptedException, IOException, AWTException
	{
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(providerNPI);
		apgf.GPProviderTypeDropdown().selectByVisibleText("Billing Office");
		apgf.GPFindButton().click();
		Thread.sleep(2000);
		
		pgf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(gpc.BillingOfficeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		Thread.sleep(2000);
		apf.ProvidersFindFirstReviewButton().click();
		pct.GetParentProvidersTab().click();
		
		//verify the data between providers tab grid in GP and providers tab in Physician after clicking on review
		for(int i=1; i<=ppt.ParentProvidersTabtableRows().size(); i++)
		{
			if(driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tabprovider_9']/div[2]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase(groupPracticeName))//Practice location name/provider name are the same
			{
				return false;
			}
		}
		Thread.sleep(3000);
		Assert.assertTrue(!ppt.ParentProvidersTabtableRows().isEmpty());
		return true;
	}
}
