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
public class TC13_AdminPortal_Faxes_AssignmentRules_VerifyFieldValidationMsgTest extends AdminPortalLoginLogoutPage
{
	
	Faxes_AssignmentRules dat = new Faxes_AssignmentRules();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentRulesPage afa = new AdminPortal_Faxes_AssignmentRulesPage();
	
	
	String Key = "AssignmentRulesFieldValidationMsgs";
	
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
		
	@Test ( description = "Verify field validation messages displayed for Assigment Rules Page")
	public void Verify_AssignmentRules_FieldValidationMsgs() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentRulesFieldValidationMsgs(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentRulesLink().click();
		
		//verify the msg "Start Time and End Time are required if catch outside hours is 'N' "
		afa.AddButton().click();
		Assert.assertEquals(afa.FieldValidationMsg().getText(), testData.get(1));
		
		//verify the msg "Start Time and End Time should be empty if catch outside hours is 'Y' "
		afa.StartTime().click();
		afa.StartTime().sendKeys("09:00:00");
		afa.EndTime().click();
		afa.EndTime().sendKeys("17:00:00");
		afa.CatchOutsideHours().clear();
		afa.CatchOutsideHours().sendKeys("Y");
		afa.AddButton().click();
		Assert.assertEquals(afa.FieldValidationMsg().getText(), testData.get(2));
		
		AdminPortalLogout();
	}	
}
				
		
		

