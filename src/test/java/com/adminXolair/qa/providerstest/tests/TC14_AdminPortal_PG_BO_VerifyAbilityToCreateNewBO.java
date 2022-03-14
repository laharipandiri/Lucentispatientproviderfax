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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_New;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_NewPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_NewPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC14_AdminPortal_PG_BO_VerifyAbilityToCreateNewBO extends AdminPortalLoginLogoutPage {
	
	ProviderGroups_BillingOffice_New dat = new ProviderGroups_BillingOffice_New();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_BO_NewPage pbn = new AdminPortal_PG_BO_NewPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	
	String Key = "CreateNewBO";
	
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
	@Test (description = "verify the ability to create a BO record", enabled = false)//disabling the test because NPI is mandatory
	public void VerifyBOCreateRecord()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetBillingOfficeCreateTestData(Key, rowNum); 
		
		ahp.ProvidersLink().click();
		ahp.EnrollNewProvider().click();
		wait.until(ExpectedConditions.visibilityOf(pbn.BONewAddbutton()));
		
		try {
			pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(11));
			pbn.VerifyAbilityToCreateNewBORecord(testData);
		}
		catch(InterruptedException e)
		{
			
		}
		String confirmationMsgOne = testData.get(9);
		
		System.out.println("confirmation msg:"+ pbn.BONewConfirmationMsgOne().getText());
		System.out.println("confirmation msg:"+ pbn.BONewConfirmationMsgTwo().getText());
		confirmationMsgOne += pbn.BONewConfirmationID().getText();
		Assert.assertEquals(pbn.BONewConfirmationMsgOne().getText(), confirmationMsgOne);
		Assert.assertEquals(pbn.BONewConfirmationMsgTwo().getText(), testData.get(10)); 
		
	}

}
