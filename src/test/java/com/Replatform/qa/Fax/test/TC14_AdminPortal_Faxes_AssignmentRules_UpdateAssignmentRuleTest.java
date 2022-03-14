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
import com.juno.qa.getandsetTestData.Faxes_AssignmentRules;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_Faxes_AssignmentRulesPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC14_AdminPortal_Faxes_AssignmentRules_UpdateAssignmentRuleTest extends AdminPortalLoginLogoutPage
{
	
	Faxes_AssignmentRules dat = new Faxes_AssignmentRules();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentRulesPage afa = new AdminPortal_Faxes_AssignmentRulesPage();
	
	
	String Key = "AssignmentRulesCreateTestData";
	String Key1 = "AssignmentRulesUpdateTestData";
	
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
		
	@Test ( description = "Verify ability to update assignment rules for OutsideHoursN")
	public void Verify_AssignmentRules_UpdateAssignmentRule_OustisdeHoursN() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesNCreateTestData(Key, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		System.out.println("RowNum: "+rowNum1);
		List<String> updateData = new ArrayList<String>();
		updateData = dat.GetAssignmentRulesUpdateTestData(Key1, rowNum1);
		
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		//We will remove the user after adding so that the same test data can be used again and every time the test is run
		Assert.assertTrue(afa.VerifyAbilityToAddNewAssignmentRules_N(testData));
		Assert.assertTrue(afa.VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursN(updateData));
		
		//Assert.assertTrue(afa.VerifyRemoveLink(updateData.get(4), testData.get(0)));
		
		AdminPortalLogout();
	}
		
				
		
	
	
	@Test ( description = "Verify ability to update assignment rules for OutsideHoursY to OutsideHoursN")
	public void Verify_AssignmentRules_UpdateAssignmentRule_OustisdeHoursYToOutsideHoursN() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesNCreateTestData(Key, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		System.out.println("RowNum: "+rowNum1);
		List<String> updateData = new ArrayList<String>();
		updateData = dat.GetAssignmentRulesUpdateTestData(Key1, rowNum1);
		
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		//We will remove the user after adding so that the same test data can be used again and every time the test is run
		Assert.assertTrue(afa.VerifyAbilityToAddNewAssignmentRules_N(testData));
		Assert.assertTrue(afa.VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursY(updateData));
		
		//Assert.assertTrue(afa.VerifyRemoveLink(updateData.get(4), testData.get(0)));
		
		AdminPortalLogout();
	}		
				
	
	@Test ( description = "Verify ability to update assignment rules for OutsideHoursY to OutsideHoursN")
	public void Verify_AssignmentRules_UpdateAssignmentRule_OutsideHoursYToOutsideHoursN() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesYCreateTestData(Key, rowNum);
		
		int rowNum1 = etd.getKeyValuePair(Key1);
		System.out.println("RowNum: "+rowNum1);
		List<String> updateData = new ArrayList<String>();
		updateData = dat.GetAssignmentRulesUpdateTestData(Key1, rowNum1);
		
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		//We will remove the user after adding so that the same test data can be used again and every time the test is run
		Assert.assertTrue(afa.VerifyAbilityToAddNewAssignmentRules_Y(testData));
		Assert.assertTrue(afa.VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursYToN(updateData));
		
		//Assert.assertTrue(afa.VerifyRemoveLink(updateData.get(4), testData.get(0)));
		
		AdminPortalLogout();
	}
}		
				
		
	


