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
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_GP_NewPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;

public class TC02_AdminPortal_PG_GP_VerifyAbilityToCreateNewGP extends AdminPortalLoginLogoutPage {

	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_NewPage agp = new AdminPortal_PG_GP_NewPage();

	String Key = "CreateNewGP";

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeAdminDriver();
		} catch (InterruptedException e) {

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

	@Test(description = "verify the ability to create a GP record", enabled = false)
	public void VerifyGPCreateRecord()// This test is disabled because NPI needs to be unique and correct
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGroupPracticeCreateTestData(Key, rowNum);

		ahp.ProviderGroupsLink().click();
		ahp.GroupPracticeLink().click();
		ahp.NewLink().click();
		wait.until(ExpectedConditions.visibilityOf(agp.GPNewAddbutton()));

		try {
			agp.VerifyAbilityToCreateNewGPRecord(testData);
		} catch (InterruptedException e) {

		}
		String confirmationMsgOne = testData.get(9);

		System.out.println("confirmation msg:" + agp.GPNewConfirmationMsgOne().getText());
		System.out.println("confirmation msg:" + agp.GPNewConfirmationMsgTwo().getText());
		confirmationMsgOne += agp.GPNewConfirmationID().getText();
		Assert.assertEquals(agp.GPNewConfirmationMsgOne().getText(), confirmationMsgOne);
		Assert.assertEquals(agp.GPNewConfirmationMsgTwo().getText(), testData.get(10));

		//AdminPortalLogout();

	}

}
