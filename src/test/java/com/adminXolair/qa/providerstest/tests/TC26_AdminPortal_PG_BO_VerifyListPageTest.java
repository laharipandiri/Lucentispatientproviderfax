package com.adminXolair.qa.providerstest.tests;

import static org.testng.Assert.assertEquals;

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
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_ListPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC26_AdminPortal_PG_BO_VerifyListPageTest extends AdminPortalLoginLogoutPage {
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_GP_ListPage pgl = new AdminPortal_PG_GP_ListPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	
	String Key = "PGBOListPageContent";
	
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
	
	@Test ( description = "verify the show entries drop down")
	public void verify_PG_Supervisors_ListPageContent() throws IOException, AWTException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGPPGListPageTestData(Key, rowNum);
				
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPLastName().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		apgf.GPFindButton().click();
		
		List<String> ddlist = pgl.GetShowEntriesDropDownOptions();
		for(String ddoption: ddlist) {
			pgl.ShowEntriesDD().selectByVisibleText(ddoption);
			Thread.sleep(2000);
			if(Integer.valueOf(ddoption) < pgl.GetTotalTableEntries()) {
				assertEquals(pgl.GetTableEntriesDisplayMsg().contains("Showing 1 to " + ddoption), true);
			}else {
				assertEquals(pgl.GetTableEntriesDisplayMsg().contains("Showing 1 to " + pgl.GetTotalTableEntries()), true);
			}
		}
		
		Assert.assertTrue(!ddlist.isEmpty());
		//AdminPortalLogout();
	}
	
	@Test ( description = "verify pagination on provider search")
	public void CrossVerifyGPCountsBetweenAlphabetListAndFindPage() throws Exception, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGPPGListPageTestData(Key, rowNum);
				
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPLastName().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		apgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		wait.until(ExpectedConditions.visibilityOf(pgl.GetCurrentPageElement()));
		int before = pgl.GetCurrentPageNo();
		Assert.assertEquals(before, 1);
		pgl.GetPaginationElement("2").click();
		Thread.sleep(2000);
		int after2 = pgl.GetCurrentPageNo();
		Assert.assertEquals(after2, before + 1);
		pgl.GetPaginationElement("Next").click();
		Thread.sleep(2000);
		int afterNext = pgl.GetCurrentPageNo();
		Assert.assertEquals(afterNext, after2 + 1);
		//AdminPortalLogout();
	}		
	
	public void CrossVerifyCountsBetweenListAndFindPageForAlphabetLinks(int headerAlphabets, String[] lastNameAlphabets) throws InterruptedException, IOException, AWTException
	{
		List<Integer> allCountList = new ArrayList<Integer>();
		//click on each alphabet link in List page, get the total count and go to find page and search by that alphabet in the last name and get the count and compare both the counts
		for(int i=1; i<=headerAlphabets-1; i++)//considering headerAlphabets-1 because the last one is All link and we are considering only A-Z for the following assertion
		{
			driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td["+i+"]/form/input[8]")).click();//click on the alphabet
			String[] total = pgl.TotalCountLabel().getText().split(" ");
			int totalCount = Integer.parseInt(total[2]);//List alphabet count
			allCountList.add(i-1, totalCount);
			
			ahp.FindLink().click();
			Thread.sleep(2000);
			pgf.GPProviderLocationName().sendKeys(lastNameAlphabets[i-1]);
			pgf.GPFindButton().click();
			Thread.sleep(2000);
			
			//Now get the count of search resultset
			String[] findTotalCount = pgf.GPFindTotalCount().getText().split(" ");
			int totalFindCount = Integer.parseInt(findTotalCount[2]);
			
			Assert.assertEquals(totalCount, totalFindCount);
			ahp.ListLink().click();//go back to list page
			
		}
		
		ahp.ListLink().click();
		pgl.AllLink().click();
		String[] allCount = pgl.TotalCountLabel().getText().split(" ");
		int total = Integer.parseInt(allCount[2]);
		int allCountListPage = 0;
		for(int count: allCountList)
		{
			allCountListPage += count; 
		}
		System.out.println("Total from UI: "+total);
		System.out.println("Total from all alphabet pages: "+allCountListPage);
		Assert.assertEquals(total, allCountListPage);
		Assert.assertTrue(total == allCountListPage);
	} 

}
