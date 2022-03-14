package com.Replatform.qa.Fax.test;

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
import com.juno.qa.getandsetTestData.Faxes_Assignments;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_AssignmentsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC08_AdminPortal_Faxes_Assignments_VerifyFaxCountWrongErrorTest  extends AdminPortalLoginLogoutPage
{
	
	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "FaxCountWrongTestData";
	
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
		
	@Test ( description = "Verify the fax count wrong message")
	public void Verify_Assignments_FaxCountWrongMsg() throws IOException, AWTException
	{ 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetFaxCountWrongMsgTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		
		//case-1: Faxcount 1 and FaxIDList more than one
		
		afa.ReassignFaxesFirstRow().click();
		afa.FaxCountField().clear();
		afa.FaxCountField().sendKeys(testData.get(0));
		afa.FaxIDListField().sendKeys(testData.get(1));
		
		afa.ReassignLink().click();
		Assert.assertEquals(afa.FaxCountWrongErrorMsg().getText(), testData.get(4));
		
		//reporting
		if(afa.FaxCountWrongErrorMsg().getText().equalsIgnoreCase(testData.get(4)))//if the method returns true
		{
			TestBase.classAInstance.logReport("Pass","fax count wrong message","Succesfully able to verify fax count wrong message");
		}
		else
		{
		    TestBase.classAInstance.logReport("Fail","fax count wrong message","Failed to verify fax count wrong message");
		}		
		
		
		//case-1: Faxcount 1 and FaxIDList more than one
		
		afa.ReassignFaxesFirstRow().click();
		afa.FaxCountField().clear();
		afa.FaxCountField().sendKeys(testData.get(2));
		afa.FaxIDListField().sendKeys(testData.get(3));
		
		afa.ReassignLink().click();
		Assert.assertEquals(afa.FaxCountWrongErrorMsg().getText(), testData.get(4));	
		
		//reporting
		if(afa.FaxCountWrongErrorMsg().getText().equalsIgnoreCase(testData.get(4)))//if the method returns true
		{
			TestBase.classAInstance.logReport("Pass","Faxes List All FindPage content","Succesfully able to verify Faxes List All FindPage content");
		}
		else
		{
		    TestBase.classAInstance.logReport("Fail","Faxes List All FindPage content","Failed to verify Faxes List All FindPage content");
		}		
		
		AdminPortalLogout();
	}
}		
				
		

