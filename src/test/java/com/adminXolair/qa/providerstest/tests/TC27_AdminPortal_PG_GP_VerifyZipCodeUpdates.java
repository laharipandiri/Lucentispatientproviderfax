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
import com.juno.qa.pages.AdminPortal_Providers_FindPage;
import com.juno.qa.pages.AdminPortal_Providers_PhysicianAndCardInfoTabPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC27_AdminPortal_PG_GP_VerifyZipCodeUpdates extends AdminPortalLoginLogoutPage {

	TestUtil testUtil;
	CommonFunctions cf = new CommonFunctions();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_GP_FindPage apf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage apc = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	
	String Key = "UpdateZipCodeForGP";

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
	
	@Test ( description = "Verify ability to update Zipcode in GP and card info tab")
	public void verifyUpdatesToZipCodeInGPAndCardInfoTab() throws IOException, AWTException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetPhysicianInfoTestDataForUpdate(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apf.GPNPI().sendKeys(testData.get(0));
		apf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		apf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(apf.FirstReviewLinkInSearchGrid()));
		
		apf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(apc.GroupPracticeAndCardInfoTab()));
		
		//update zipcode from 5 to 9 digits
		System.out.println("Zip code before update:"+apc.ZipFieldValue().substring(0, 5));
		apc.GPAndCardZip().click();
	        Thread.sleep(2000);
	        for(int i=1;i<=5;i++)
	        {
	        	apc.GPAndCardZip().sendKeys(Keys.BACK_SPACE);
	        	Thread.sleep(2000);
	        }
	        String nineZip = TestUtil.randomNumeric(9);
		apc.GPAndCardZip().sendKeys(nineZip);
		Thread.sleep(1000);
		apc.UpdateButton().click();
		wait.until(ExpectedConditions.visibilityOf(apc.GPUpdateConfirmationMessage()));
		Assert.assertTrue(apc.GPUpdateConfirmationMessage().getText().contains(testData.get(2)));
		driver.navigate().refresh();
		String fieldNineZipValue = nineZip.substring(0, 5);
		System.out.println("nine:"+fieldNineZipValue);
		Assert.assertEquals(apc.ZipFieldValue(), fieldNineZipValue);
		//scroll down to capture the screenshot at the correct location
        js.executeScript("window.scrollBy(0,350)", "");
        Assert.assertTrue(apc.ZipFieldValue().contains(fieldNineZipValue));
		//update zipcode from 9 to 5 digits
		System.out.println("Zip code before update:"+apc.ZipFieldValue());
		driver.navigate().refresh();
        Thread.sleep(2000);
        for(int i=1;i<=5;i++)
        {
        	apc.GPAndCardZip().sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        }
        String fiveZip = TestUtil.randomNumeric(5);
		apc.GPAndCardZip().sendKeys(fiveZip);
		Thread.sleep(1000);
		apc.UpdateButton().click();
		Assert.assertTrue(apc.GPUpdateConfirmationMessage().getText().contains(testData.get(2)));
		apc.GPRefreshLink().click();
		Thread.sleep(3000);
		Assert.assertEquals(apc.ZipFieldValue().substring(0, 5), fiveZip);
		//scroll down to capture the screenshot at the correct location
        js.executeScript("window.scrollBy(0,350)", "");
		
		//AdminPortalLogout();
	}	
}
