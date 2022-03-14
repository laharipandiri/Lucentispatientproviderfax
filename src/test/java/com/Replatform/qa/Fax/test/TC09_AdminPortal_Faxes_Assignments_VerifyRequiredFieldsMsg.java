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
public class TC09_AdminPortal_Faxes_Assignments_VerifyRequiredFieldsMsg extends AdminPortalLoginLogoutPage
{
	
	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "AssigmentsPageRequiredFieldMsgs";
	
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
		
	@Test ( description = "Verify the required fields message")
	public void Verify_Assignments_RequiredFieldsMsg() throws IOException, AWTException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetReqFieldsMsgTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		
		//Fax count and ID are left empty
		
		afa.ReassignFaxesFirstRow().click();
		afa.FaxCountField().clear();
		
		afa.ReassignLink().click();
		Assert.assertEquals(afa.FaxCountWrongErrorMsg().getText(), testData.get(0));
		
		//From and to users are the same
		
		afa.ReassignFaxesFirstRow().click();
		//not specifying fax count as there is a default value of 1
		afa.FaxIDListField().sendKeys(testData.get(2));
		
		String fromUser = afa.FromUserDropdown().getFirstSelectedOption().getText();
		afa.ToUserDropdown().selectByVisibleText(fromUser);
		afa.FaxIDListField().clear();
		afa.ReassignLink().click();
		Assert.assertEquals(afa.FaxCountWrongErrorMsg().getText(), testData.get(1));
		
		AdminPortalLogout();
	}
}		
				
