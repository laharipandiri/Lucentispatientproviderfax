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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_New;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NewPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.TestNGListner;
import com.juno.qa.util.TestUtil;

@Listeners(TestNGListner.class)
public class TC15_AdminPortal_PG_BO_VerifyRequiredFieldsInBONewPage extends AdminPortalLoginLogoutPage {
	
	ExcelTestDataReader etd = new ExcelTestDataReader();
	ProviderGroups_BillingOffice_New dat = new ProviderGroups_BillingOffice_New();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_NewPage pbn = new AdminPortal_PG_BO_NewPage();
	
	String Key = "BORequiredFields";

	
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
	@Test ( description = "Verify the display of required fields in Provider Groups-->BillingOffice--> New page")
	public void VerifyRequiredFieldsInNewBillingOfficePage() throws IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetBillingOfficeRequiredFields(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.EnrollNewProvider().click();
		wait.until(ExpectedConditions.visibilityOf(pbn.BONewAddbutton()));
		
		Assert.assertEquals(pbn.BONewProgramName().getFirstSelectedOption().getText(), testData.get(12));
		//Now click on Add button and verify the required field messages
		pbn.BONewAddbutton().click();
		//make sure the warning msg is displayed under the fields
		String errorMsg = pbn.BOErrorMessageFull().getText();
		//make sure the warning msg is displayed under the add button
		//Assert.assertEquals(errorMsg,testData.get(11));
		
		 //scroll down to capture the screenshot at the correct location
        js.executeScript("window.scrollBy(0,1000)", "");
		//Assert.assertTrue(errorMsg.equalsIgnoreCase(testData.get(11)));

		//AdminPortalLogout();
	}		

}
