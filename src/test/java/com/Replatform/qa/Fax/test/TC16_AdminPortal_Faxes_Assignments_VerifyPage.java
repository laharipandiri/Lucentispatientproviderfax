package com.Replatform.qa.Fax.test;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
public class TC16_AdminPortal_Faxes_Assignments_VerifyPage extends AdminPortalLoginLogoutPage {

	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "AssignmentsPageGridCols";
	
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
		
	@Test ( description = "Verify assignments page content test")
	public void Verify_Assignments_PageContent() throws InterruptedException, IOException, AWTException
	{
		
		//Have test data that is already assigned to a User say A, then re-assign that fax to another User say B, now verify things and then reassign the fax back to User A so that the test can run smoothly next time
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String both = etd.getBothValue(Key);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetAssignmentsPageColsTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		Assert.assertEquals(afa.ProgramDropdown().getFirstSelectedOption().getText(), testData.get(12));
		
		
		Assert.assertTrue(afa.FromDateField().isDisplayed());
		Assert.assertTrue(afa.ToDateField().isDisplayed());
		Assert.assertTrue(afa.FindButton().isDisplayed());
		
		//verify the col names
		for(int i=1;i<=afa.AssignmentsPageTableCols().size();i++)
		{
			if(i<8)
			{
				Assert.assertEquals(afa.AssignmentPageTableColNames(i).getText(), testData.get(i));
			}
			else if(i==8)
			{
				for(int j=1; j<=afa.NestedTableDataCols().size(); j++)
		 		{
					if(j==1)
					{
						Assert.assertEquals(afa.NestedTableDataColNames(j).getText(), testData.get(j+7));
					}
					else if(j==2)
					{
						for(int k=1;k<=afa.SubNestedCols().size();k++)
						{
							Assert.assertEquals(afa.SubNestedColNames(j,k).getText(), testData.get(j+k+6));
						}
					}
		 			
		 			
		 		}
			}
			
		}
		
		
		Assert.assertTrue(afa.ReassignFaxesFirstRow().isDisplayed());
		Assert.assertTrue(afa.MarkOutFromDate().isDisplayed());
		Assert.assertTrue(afa.MarkOutToDate().isDisplayed());
		Assert.assertTrue(afa.MarkCancelOutLink().isDisplayed());
		Assert.assertEquals(afa.FaxAssignmentsLabel().getText(), testData.get(18));
		Assert.assertTrue(afa.TotalCountLabel().getText().contains(testData.get(19)));
		//reporting
		if(!afa.AssignmentsPageTableCols().isEmpty())
		{
			TestBase.classAInstance.logReport("Pass","assignments page content","Succesfully able to verify assignments page content");
		}
		else
		{
		    TestBase.classAInstance.logReport("Fail","assignments page content","Failed to verify assignments page content");
		}
		
		//verify the Re-assign section in the table
		afa.ReassignFaxesFirstRow().click();
		Assert.assertEquals(afa.FaxReassignLabel().getText(), testData.get(13));
		Assert.assertEquals(afa.FromLabel().getText(), testData.get(14));
		Assert.assertTrue(afa.FromUserDropdown().getFirstSelectedOption().isDisplayed());
		Assert.assertEquals(afa.ToLabel().getText(), testData.get(15));
		Assert.assertTrue(afa.ToUserDropdown().getFirstSelectedOption().isDisplayed());
		Assert.assertEquals(afa.FaxCountLabel().getText(), testData.get(16));
		Assert.assertTrue(afa.FaxCountField().isDisplayed());
		Assert.assertEquals(afa.FaxIDListLabel().getText(), testData.get(17));
		Assert.assertTrue(afa.FaxIDListField().isDisplayed());
		Assert.assertTrue(afa.ReassignLink().isDisplayed());
		
		//reporting
		if(afa.FaxReassignLabel().isDisplayed())
		{
			TestBase.classAInstance.logReport("Pass","assignments page content","Succesfully able to verify re-assignment section content");
		}
		else
		{
		    TestBase.classAInstance.logReport("Fail","assignments page content","Failed to verify re-assignment section content");
		}
		
		AdminPortalLogout();
	}
	
				
}


