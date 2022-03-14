package com.Replatform.qa.Fax.test;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
public class TC11_AdminPortal_Faxes_Assignments_VerifyMarkAsOutTest  extends AdminPortalLoginLogoutPage {
	
	Faxes_Assignments dat = new Faxes_Assignments();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Faxes_AssignmentsPage afa = new AdminPortal_Faxes_AssignmentsPage();
	
	
	String Key = "MarkAsOutData";
	
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
		
	@Test ( description = "Verify Mark As Out And Cancel Out features")
	public void Verify_Assignments_MarkAsOutAndCancelOut() throws InterruptedException, IOException, AWTException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("RowNum: "+rowNum);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetMarkAsOutTestData(Key, rowNum);
		
		ahp.FaxesLink().click();
		ahp.AssignmentsLink().click();
		
		
		afa.FromDateField().click();
		cf.SelectDate(testData.get(0));
		afa.FindButton().click();
		Thread.sleep(6000);
		Assert.assertEquals(afa.MarkCancelOutLink().getAttribute("value"), testData.get(3));
		
		afa.MarkOutFromDate().click();
		cf.SelectDate(testData.get(0));
		System.out.println("from date: "+testData.get(0));
		System.out.println("to date: "+testData.get(1));
		
		String[] toDate = testData.get(1).split(" ");
		String MarkOutToDate = toDate[2]+"-"+toDate[1]+"-"+toDate[5];
		System.out.println("MarkOutToDate: "+MarkOutToDate);
		String[] day = toDate[2].split("");
		if(day[0].equalsIgnoreCase("0"))
		{
			toDate[2] = day[1];
		}
		String MarkOutToDateForDateMethod = toDate[2]+"-"+toDate[1]+"-"+toDate[5];
		System.out.println("MarkOutToDateForDateMethod: "+MarkOutToDateForDateMethod);
		afa.MarkOutToDate().click();
		cf.SelectDate(MarkOutToDateForDateMethod);
		
		afa.MarkCancelOutLink().click();
		Thread.sleep(2000);
		
		String[] fDate = afa.MarkOutFromDate().getAttribute("value").split("-");
		System.out.println("Mark as out from date UI: "+afa.MarkOutFromDate().getAttribute("value"));
		String from = fDate[2]+"-"+cf.ConvertToMonthString(Integer.parseInt(fDate[1]))+"-"+fDate[0];
		
		String[] tDate = afa.MarkOutToDate().getAttribute("value").split("-");
		String to = tDate[2]+"-"+cf.ConvertToMonthString(Integer.parseInt(tDate[1]))+"-"+tDate[0];
		
		Assert.assertEquals(afa.MarkCancelOutLink().getAttribute("value"), testData.get(2));
		Assert.assertEquals(from, testData.get(0));
		Assert.assertEquals(to, MarkOutToDate);
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down to capture the screenshot at the correct location
		
		
		//Now click on CancelOut as we can use the same data again for this test
		afa.MarkCancelOutLink().click();
		
		Assert.assertEquals(afa.MarkCancelOutLink().getAttribute("value"), testData.get(3));
		Assert.assertTrue(afa.MarkOutFromDate().getAttribute("value").isEmpty());
		Assert.assertTrue(afa.MarkOutToDate().getAttribute("value").isEmpty());
		
		AdminPortalLogout();
	}
}		
				
		
		
	