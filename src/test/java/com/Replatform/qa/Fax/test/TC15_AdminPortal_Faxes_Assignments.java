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
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC15_AdminPortal_Faxes_Assignments extends AdminPortalLoginLogoutPage {
	
	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();
	
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "ReassignFax";
	String Key1 = "ReassignFaxInAdminReimbursement";
	
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
		
	@Test ( description = "Verify ability to assign fax from one user to another in DrugReimbursement")
	public void Verify_Assignments_AssignFaxFromOneUserToAnother_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		//Have test data that is already assigned to a User say A, then re-assign that fax to another User say B, now verify things and then reassign the fax back to User A so that the test can run smoothly next time
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetReassignFaxTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		
		//Get the row of the ToUser 
int fromUserRow = afa.GetUserRowNum(testData.get(3));
		System.out.println(testData.get(3) + testData.get(4));
		int toUserRow = afa.GetUserRowNum(testData.get(4));
		System.out.println("From User row: "+fromUserRow);
		System.out.println("To User row: "+toUserRow);
		
		
		Assert.assertTrue(afa.VerifyAbilityToReassignFax(testData, fromUserRow, toUserRow, rowNum));
		
		
		
		//Now go to incoming faxes page and verify the fax is assigned to correct user
		ahp.FaxesLink().click();
		ahp.IncomingFaxesLink().click();
		
		//reporting
		try
		{
			if(afa.VerifyAssignedToInIncomingFaxesPage(testData))
			{
				TestBase.classAInstance.logReport("Pass","assign fax from one user to another","Succesfully able to verify assign fax from one user to another");
			}
			else
			{
			    TestBase.classAInstance.logReport("Fail","assign fax from one user to another","Failed to verify assign fax from one user to another");
			}
		}
		catch(InterruptedException e)
		{
			
		}
		
		//Now assign the fax back to the original Fromuser so that the data can be reused when the test runs again
		List<String> newtestData = new ArrayList<String>();
		newtestData = dat.GetReassignFaxTestData(Key, rowNum);
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		
		//Get the row of the ToUser 
		int fromRow = afa.GetUserRowNum(newtestData.get(3));
		//int toRow = afa.GetUserRowNum(newtestData.get(4));
		int toRow = afa.GetUserRowNum(newtestData.get(4));
		
		Assert.assertTrue(afa.VerifyAbilityToReassignFax(newtestData, fromRow, toRow, rowNum));
		
		AdminPortalLogout();
		
	} 
	
	
}
