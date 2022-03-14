package com.Replatform.qa.Fax.test;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.Faxes_AssignmentRules;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_AssignmentRulesPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC12_AdminPortal_Faxes_AssignmentRules_AddNewAssignmentRuleTest  extends AdminPortalLoginLogoutPage
{
	
	Faxes_AssignmentRules dat = new Faxes_AssignmentRules();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentRulesPage afa = new AdminPortal_Faxes_AssignmentRulesPage();
	
	
	String Key = "AssignmentRulesCreateTestData";
	
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
		//closeBrowser();
		TestBase.classAInstance.endReport();
	}
	} 
	@Test ( description = "Verify ability to create assignment rules with Catch outside hours as N")
	public void Verify_AssignmentRules_CreateAssignmentRule_OustisdeHoursN() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesNCreateTestData(Key, rowNum);
		
		List<String> gridLabels = new ArrayList<String>();
		gridLabels = dat.GetAssignmentRulesGridLabels(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		Assert.assertTrue(afa.UserDropdown().getFirstSelectedOption().isDisplayed());
		Assert.assertTrue(afa.StartTime().isDisplayed());
		Assert.assertTrue(afa.EndTime().isDisplayed());
		Assert.assertTrue(afa.DailyMax().isDisplayed());
		Assert.assertTrue(afa.CatchOutsideHours().isDisplayed());
		Assert.assertTrue(afa.AddButton().isDisplayed());
		
		String[] totalBeforeCount = afa.TotalCountLabelAndValue().split(": ");
		int beforeCount = Integer.parseInt(totalBeforeCount[1]);
		
		//We will remove the user after adding so that the same test data can be used again and every time the test is run
		Assert.assertTrue(afa.VerifyAbilityToAddNewAssignmentRules_N(testData));
		
		String[] totalAfterCount = afa.TotalCountLabelAndValue().split(": ");
		int afterCount = Integer.parseInt(totalAfterCount[1]);
		
	//	Assert.assertTrue(afterCount == beforeCount+1);
		
		Assert.assertTrue(afa.VerifyNewlyCreatedRules_N(testData, gridLabels));
		//Dynamically find the row of the newly added record and then click on remove
		for(int i=2;i<=afa.AssignmentRulesGridRows().size();i++)//we starting the loop from #2 because the first row has no data
		{
			if(afa.UsernameLabelInGrid(i).equalsIgnoreCase(testData.get(0)))
			{
				afa.RemoveLinkInGrid(i).click();
			}
		}
		
		
		AdminPortalLogout();
	}
		
				
		
	 
	
	@Test ( description = "Verify ability to create assignment rules with Catch outside hours as Y")
	public void Verify_AssignmentRules_CreateAssignmentRule_OustisdeHoursY() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesYCreateTestData(Key, rowNum);
		
		List<String> gridLabels = new ArrayList<String>();
		gridLabels = dat.GetAssignmentRulesGridLabels(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		Assert.assertTrue(afa.UserDropdown().getFirstSelectedOption().isDisplayed());
		Assert.assertTrue(afa.StartTime().isDisplayed());
		Assert.assertTrue(afa.EndTime().isDisplayed());
		Assert.assertTrue(afa.DailyMax().isDisplayed());
		Assert.assertTrue(afa.CatchOutsideHours().isDisplayed());
		Assert.assertTrue(afa.AddButton().isDisplayed());
		
		String[] totalBeforeCount = afa.TotalCountLabelAndValue().split(": ");
		int beforeCount = Integer.parseInt(totalBeforeCount[1]);
		
		//We will remove the user after adding so that the same test data can be used again and every time the test is run
		Assert.assertTrue(afa.VerifyAbilityToAddNewAssignmentRules_Y(testData));
		
		String[] totalAfterCount = afa.TotalCountLabelAndValue().split(": ");
		int afterCount = Integer.parseInt(totalAfterCount[1]);
		
//		Assert.assertTrue(afterCount == beforeCount+1);
		
		Assert.assertTrue(afa.VerifyNewlyCreatedRules_Y(testData, gridLabels));
		for(int i=2;i<=afa.AssignmentRulesGridRows().size();i++)//we starting the loop from #2 because the first row has no data
		{
			if(afa.UsernameLabelInGrid(i).equalsIgnoreCase(testData.get(0)))
			{
				afa.RemoveLinkInGrid(i).click();
			}
		}
		
		AdminPortalLogout();
	}		
				
	
}
