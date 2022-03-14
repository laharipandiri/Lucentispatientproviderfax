package com.Replatform.qa.Fax.test;

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
import com.juno.qa.getandsetTestData.Faxes_Assignments;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_AssignmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC10_AdminPortal_Faxes_Assignments_VerifyFaxIDDoesNotExistMsg extends AdminPortalLoginLogoutPage
{
	
	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "FaxIDDoesNotExistTestData";
	
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
	{
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
		//Close the driver
		closeBrowser();
		TestBase.classAInstance.endReport();
	}
	} 
	@Test ( description = "Verify the FaxID does not exist message")
	public void Verify_Assignments_FaxIDDoesNotExistMsg() throws IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetFaxIDDoesNotExistMsgTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		//afa.FromDateField().clear();
		wait.until(ExpectedConditions.visibilityOf(afa.FromDateField()));
		//afa.FromDateField().clear();
		//afa.FromDateField().sendKeys("2021-01-15");
		afa.ReassignFaxesFirstRow().click();
		afa.FromUserDropdown().selectByVisibleText(testData.get(2));
		afa.ToUserDropdown().selectByVisibleText(testData.get(3));
//		afa.FromUserDropdown().selectByVisibleText(testData.get(2));
//		afa.ToUserDropdown().selectByVisibleText(testData.get(3));
		//Since faxCount already has default value of 1, we are not specifying any values
		afa.FaxIDListField().sendKeys(testData.get(1));
		afa.ReassignLink().click();
		
		Assert.assertEquals(afa.FaxCountWrongErrorMsg().getText(), testData.get(0));
		
		AdminPortalLogout();
	}
}		
				

