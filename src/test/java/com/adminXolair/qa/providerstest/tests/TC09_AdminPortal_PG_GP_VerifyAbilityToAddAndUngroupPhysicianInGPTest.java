package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.juno.qa.pages.AdminPortal_Providers_ParentProvidersTabPage;
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC09_AdminPortal_PG_GP_VerifyAbilityToAddAndUngroupPhysicianInGPTest extends AdminPortalLoginLogoutPage {

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
	
	@Test ( description = "Verify the ability to add and ungroup a provider in PG-->GP-->Review-->ProvidersTab")
	public void Verify_Providers_ParentProvidersTab_AddAndUngroupProvider() throws InterruptedException, IOException, AWTException
	{
/*		This test searches for a provider by provider name, adds it to the GP and then goes to that provider details page's 
		Parent providers tab and reviews the provider and then navigates back to GP and ungroups the Provider from GP */
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
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
		
		//Get the GP details to cross verify in ParentProviders tab in Physician details page
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
		
		int totalProvidersAfterCount = pgtbo.TotalProvidersCountFromTable();
		//Now verify the total count has increased by one
		Assert.assertEquals(totalProvidersAfterCount, totalProvidersBeforeCount+1);
		pgtbo.ClickArrowDownToDisplayTable("showproviderrow");
		apf.ProvidersFindFirstReviewButtonByName(testData.get(2)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(pct.GetParentProvidersTabByID()));
		
		pct.GetParentProvidersTabByID().click();
		Thread.sleep(5000);
		List<WebElement> tablerows = ppt.ParentProvidersTabtableRows();
		Assert.assertTrue(!tablerows.isEmpty());
		
		//verify the data between providers tab grid in GP and providers tab in Physician after clicking on review
		boolean flag = false;
		for(int i=1; i<=tablerows.size(); i++)
		{
			if(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[1]")).getText().equalsIgnoreCase(GPtestDataFromUI.get(0)))//Practice location name/provider name are the same
			{
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[2]")).getText(), GPtestDataFromUI.get(1));//ContactName
				Assert.assertTrue(GPtestDataFromUI.get(2).contains(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[3]")).getText())); //Address
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[4]")).getText(), GPtestDataFromUI.get(3));//City
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[5]")).getText(), GPtestDataFromUI.get(4));//state
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[6]")).getText(), GPtestDataFromUI.get(5));//zip
				Assert.assertEquals(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[9]")).getText(), GPtestDataFromUI.get(6));//providertype
				//click on review link
				apf.ProvidersFindFirstReviewButtonByName(GPtestDataFromUI.get(1)).click();
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
		wait.until(ExpectedConditions.visibilityOf(gpc.GroupPracticeAndCardInfoTab()));
		
		pgt.ProvidersTab().click();
		pgtbo.ClickArrowDownToDisplayTable("showproviderrow");
		apf.ProvidersFindFirstUngroupButtonByName(testData.get(2)).click();
		int afterUngroupCount = pgtbo.TotalProvidersCountFromTable();
		
		Assert.assertTrue(afterUngroupCount<totalProvidersAfterCount);
		Thread.sleep(2000);
		//Now go back to Providers-->Review-->ParentProviders Tab and verify the GP is not there anymore
		try {
				Assert.assertTrue(VerifyUngroupOfGroupPractice(testData.get(4),GPtestDataFromUI.get(0)));//providerNPI & group practice name
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
	
	
	public boolean VerifyUngroupOfGroupPractice(String providerNPI, String groupPracticeName) throws InterruptedException, IOException, AWTException
	{
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPNPI().sendKeys(providerNPI);
		pgf.GPProviderTypeDropdown().selectByVisibleText("Physician");
		pgf.GPFindButton().click();
		Thread.sleep(2000);
		
		apf.ProvidersFindFirstReviewButton().click();
		pct.GetParentProvidersTab().click();
		Assert.assertTrue(!ppt.ParentProvidersTabtableRows().isEmpty());
		//verify the data between providers tab grid in GP and providers tab in Physician after clicking on review
		for(int i=1; i<=ppt.ParentProvidersTabtableRows().size(); i++)
		{
			if(driver.findElement(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr[" + i + "]//td[1]")).getText().equalsIgnoreCase(groupPracticeName))//Practice location name/provider name are the same
			{
				return false;
			}
		}
		Thread.sleep(2000);
		return true;
	}
}
