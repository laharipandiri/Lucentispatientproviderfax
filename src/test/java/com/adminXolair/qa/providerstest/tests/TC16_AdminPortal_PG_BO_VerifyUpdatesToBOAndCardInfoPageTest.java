package com.adminXolair.qa.providerstest.tests;

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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_New;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC16_AdminPortal_PG_BO_VerifyUpdatesToBOAndCardInfoPageTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	CommonFunctions cf = new CommonFunctions();
	
	ProviderGroups_BillingOffice_New dat = new ProviderGroups_BillingOffice_New();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_BO_FindPage pbf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage pbc = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	
	String Key = "BillingOfficeAndCardInfoUpdate";
	
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
	@Test ( description = "Verify ability to update required fields in Billing office and card info tab")
	public void verifyUpdatesToBOAndCardInfoTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
				
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetBOAndCardInfoTestDataForUpdate(Key, rowNum);
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPNPI().sendKeys(testData.get(0));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(1));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pbf.FirstReviewLinkInSearchGrid()));
		
		pbf.FirstReviewLinkInSearchGrid().click();
		wait.until(ExpectedConditions.visibilityOf(pbc.BillingOfficeAndCardInfoTab()));
		
		try {
			VerifyUpdatesToBOAndCardInfo(testData, rowNum);
		}
		catch(InterruptedException e)
		{
			
		}
		catch(IOException ie)
		{
			
		}
		catch(AWTException awt)
		{
			
		}
		
		//AdminPortalLogout();
	}		

	
	public void VerifyUpdatesToBOAndCardInfo(List<String> testData, int rowNum) throws InterruptedException, IOException, AWTException
	{
		//Now update the fields
				String firstname = TestUtil.randomAlpha(5);
				String lastname = TestUtil.randomAlpha(5);
				String practicename = lastname+" "+firstname;
				String updateConfirmationMsg = "Processed: ID = "+pbc.ProviderIDFieldValue();
				
				pbc.BOAndCardFirstName().clear();
				pbc.BOAndCardFirstName().sendKeys(firstname);
				
				pbc.BOAndCardLastName().clear();
				pbc.BOAndCardLastName().sendKeys(lastname);
				
				pbc.BOAndCardBOName().clear();
				pbc.BOAndCardBOName().sendKeys(practicename);
				
				
				pbc.BOAndCardAddress().clear();
				pbc.BOAndCardAddress().sendKeys(TestUtil.randomAlphaNumeric(8));
			
				
				pbc.BOAndCardCity().clear();
				pbc.BOAndCardCity().sendKeys(TestUtil.randomAlpha(8));
				
				
				int stateNum = cf.SelectRandomState(pbc.BOAndCardState());
				pbc.BOAndCardState().get(stateNum).click();
				
				
				pbc.BOAndCardZip().clear();
				pbc.BOAndCardZip().sendKeys(TestUtil.randomNumeric(5));
				
				pbc.BOAndCardPhone().clear();
				pbc.BOAndCardPhone().sendKeys("2"+TestUtil.randomNumeric(9));
				
				pbc.BOAndCardFax().clear();
				pbc.BOAndCardFax().sendKeys("2"+TestUtil.randomNumeric(9));
				
				pbc.BOAndCardTax().clear();
				pbc.BOAndCardTax().sendKeys(TestUtil.randomNumeric(12));
				
				
				String email = firstname+"."+lastname+"@connectiverx.com";
				pbc.BOAndCardEmail().clear();
				pbc.BOAndCardEmail().sendKeys(email);
				pbc.BOAndCardConfirmEmail().clear();
				pbc.BOAndCardConfirmEmail().sendKeys(email);
				
				pbc.UpdateButton().click();
				Thread.sleep(2000);
				
				//Assert.assertEquals(pbc.BOUpdateConfirmationMessage().getText(), updateConfirmationMsg);
				
	}

}
