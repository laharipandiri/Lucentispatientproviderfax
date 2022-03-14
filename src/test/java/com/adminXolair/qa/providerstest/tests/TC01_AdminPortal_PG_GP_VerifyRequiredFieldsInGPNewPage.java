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
import com.juno.qa.pages.AdminPortal_PG_GP_NewPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC01_AdminPortal_PG_GP_VerifyRequiredFieldsInGPNewPage extends AdminPortalLoginLogoutPage {

	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_PG_GP_NewPage agp = new AdminPortal_PG_GP_NewPage();

	String Key = "GPRequiredFields";
	String Key1 = "MaxCharFieldValuesGPNew";
	String Key2 = "VerifyStatesDropdown";
	String Key3 = "GPNewSpecialCharTestData";

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
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

	@Test(description = "Verify the display of required fields in Provider Groups-->Group Practice--> New page")
	public void VerifyRequiredFieldsInNewGroupPracticePage() throws IOException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGroupPracticeRequiredFields(Key, rowNum);

		ahp.ProvidersLink().click();
		ahp.EnrollNewProvider().click();
		wait.until(ExpectedConditions.visibilityOf(agp.GPNewAddbutton()));
		agp.GPNewProgramName().selectByVisibleText(testData.get(12));
		// Now click on Add button and verify the required field messages
		agp.GPNewAddbutton().click();
		// make sure the warning msg is displayed under the add button
		//Assert.assertEquals(agp.GPNewRequiredFieldsValidationMsgUnderAddButton().getText(), testData.get(10));
		// scroll down to capture the screenshot at the correct location
		js.executeScript("window.scrollBy(0,850)", "");

		//AdminPortalLogout();
	}

	@Test(description = "Verify the max number of chars for the required fields in Provider Groups --> Group Practice --> New")
	public void VerifyMaxCharLimitForRequiredFieldsInGroupPracticeNewPage() throws IOException, AWTException {
		// The test is written assuming that the UI fields will not display/consider
		// chars after the max length applicable to them as per WB
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key1);
		List<String> testData = new ArrayList<String>();
		testData = gst.GetGroupPracticeMaxCharTestData(Key1, rowNum);

		for (String data : testData) {
			System.out.println("Data :" + data);
		}

		ahp.ProvidersLink().click();
		ahp.EnrollNewProvider().click();
		wait.until(ExpectedConditions.visibilityOf(agp.GPNewAddbutton()));

		VerifyMaxCharLimitForRequiredFieldsInGPNew(testData);

		// verify the states dropdown list has the states mentioned as per the
		// requirement
		int rowNum1 = etd.getKeyValuePair(Key2);
		List<String> statesList = new ArrayList<String>();
		statesList = gst.GetStatesList(Key2, rowNum1);// Get test data from excel

		List<WebElement> statesFromUI = new ArrayList<WebElement>();
		statesFromUI = agp.GPNewStatesList();// Get list of webelements for states dropdown options
		System.out.println("States count: " + statesFromUI.size());
		Assert.assertTrue(!agp.GPNewStatesList().isEmpty());
		for (int i = 1; i <= statesFromUI.size(); i++) {
			System.out.println("xpath value: "
					+ driver.findElement(By.xpath("//*[@id='provider_state']/option[" + i + "]")).getText());
			System.out.println("from excel: " + statesList.get(i));
			Assert.assertEquals(agp.GPNewStatesListNames(i).getText(), statesList.get(i));
		}

		//AdminPortalLogout();
	}

	public void VerifyMaxCharLimitForRequiredFieldsInGPNew(List<String> testData) {
		// First specify data for all fields and then verify that the fields accepted
		// only their max limits
		agp.GPNewPracticeName().sendKeys(testData.get(1));
		agp.GPNewFirstName().sendKeys(testData.get(2));
		agp.GPNewLastName().sendKeys(testData.get(3));
		agp.GPNewAddressOne().sendKeys(testData.get(4));
		agp.GPNewCity().sendKeys(testData.get(5));
		agp.GPNewZipCode().sendKeys(testData.get(6));
		agp.GPNewPhoneNumber().sendKeys(testData.get(7));
		agp.GPNewTaxField().sendKeys(testData.get(8));

		Assert.assertEquals(agp.GPNewPracticeName().getAttribute("maxlength"), testData.get(10));
		Assert.assertEquals(agp.GPNewFirstName().getAttribute("maxlength"), testData.get(11));
		Assert.assertEquals(agp.GPNewLastName().getAttribute("maxlength"), testData.get(11));
		Assert.assertEquals(agp.GPNewAddressOne().getAttribute("maxlength"), testData.get(12));
		Assert.assertEquals(agp.GPNewCity().getAttribute("maxlength"), testData.get(13));
	}
}