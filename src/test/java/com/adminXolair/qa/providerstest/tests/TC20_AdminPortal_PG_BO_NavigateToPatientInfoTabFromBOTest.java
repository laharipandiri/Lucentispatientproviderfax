package com.adminXolair.qa.providerstest.tests;

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
import com.juno.qa.getandsetTestData.ProviderGroups_BillingOffice_PatientsTab;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_BO_FindPage;
import com.juno.qa.pages.AdminPortal_PG_BO_PatientsTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC20_AdminPortal_PG_BO_NavigateToPatientInfoTabFromBOTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testUtil;
	
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	
	ProviderGroups_BillingOffice_PatientsTab dat = new ProviderGroups_BillingOffice_PatientsTab();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();
	
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	AdminPortal_PG_BO_FindPage pgf = new AdminPortal_PG_BO_FindPage();
	AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage pac = new AdminPortal_PG_BO_BillingOfficeAndCardInfoTabPage();
	AdminPortal_PG_BO_PatientsTabPage ptp = new AdminPortal_PG_BO_PatientsTabPage();
	AdminPortal_Patients_ProviderTabPage ppt = new AdminPortal_Patients_ProviderTabPage();
	AdminPortal_PG_GP_FindPage apgf = new AdminPortal_PG_GP_FindPage();
	
	
	
	String Key = "PGBOAndPatientMapping";
	String Key1 = "PGBOAndPatientMappingInAdminReimbursement";
	
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
		//AdminPortalLogout();
		//closeBrowser();
		TestBase.classAInstance.endReport();
	} 
	@Test ( description = "verify the ability to view patient info in patients tab of PG-->BO in DrugReimbursement")
	public void VerifyPatientsTabContentInBO_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGBOAndPatientMappingTestData(Key, rowNum);
		
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		apgf.GPNPI().sendKeys(testData.get(0));
		apgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(12));
		apgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));
		
		pgf.FirstReviewLinkInSearchGrid().click();//Click on the Review link for the first 
		Assert.assertTrue(pac.BillingOfficeAndCardInfoTab().isDisplayed());
		Thread.sleep(2000);
		
		ptp.PGBOPatientsTab().click();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOf(ptp.PGBOPatientFirstReviewLink()));
		
		int colSize = ptp.PGBOPatientListTableColumns().size();
		//verify the col names are matching between UI and excel
		Assert.assertTrue(colSize > 0);
		for(int i=1; i<=colSize; i++)
		{
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='provider-patient-list']//th["+i+"]")).getText(), testData.get(i));
		}
		
		Assert.assertTrue(ptp.PGBOPatientFirstReviewLink().isDisplayed());
	
		
		//Capture the field values of the columns from UI and add it to excel and then cross check with the values in Patient & Card info tab
		String activationDate = ptp.PGBOPatientsTabActivationDateColValue().substring(0, 10);
		reader.setDataInNewRow("Regression", "ActivationDateValue", rowNum, activationDate);
		reader.setDataInNewRow("Regression", "PatientNameValue", rowNum, ptp.PGBOPatientsTabPatientNameColValue());
		reader.setDataInNewRow("Regression", "CityValue", rowNum, ptp.PGBOPatientsTabCityColValue());
		String stateName = cf.GetResidingStateName(ptp.PGBOPatientsTabStateColValue());
		reader.setDataInNewRow("Regression", "StateValue", rowNum, stateName);
		reader.setDataInNewRow("Regression", "ZipValue", rowNum, ptp.PGBOPatientsTabZipColValue());
		reader.setDataInNewRow("Regression", "PatientPartnerIDValue", rowNum, ptp.PGBOPatientsTabPartnerPatientIDColValue());
		reader.setDataInNewRow("Regression", "CardIDValue", rowNum, ptp.PGBOPatientsTabCardIDColValue());
		reader.setDataInNewRow("Regression", "ProviderNameTypeValue", rowNum, ptp.PGBOPatientsTabProviderNameTypeColValue());
		
		List<String> patientTestData = new ArrayList<String>();
		patientTestData = dat.GetPGBOPatientDataForPatientAndCardInfo(Key, rowNum);
		
		ptp.PGBOPatientFirstReviewLink().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		String fullname = apc.PatientAndCardTabFirstNameValue()+", "+apc.PatientAndCardTabLastNameValue();
		Assert.assertEquals(fullname, patientTestData.get(1));
		Assert.assertEquals(apc.PatientAndCardTabCityValue(), patientTestData.get(2));
		Assert.assertEquals(apc.PatientAndCardTabPatientResidingStateValue(), patientTestData.get(3));
		Assert.assertEquals(apc.PatientAndCardTabZipValue().substring(0, 5), patientTestData.get(4).substring(0, 5));
		
		//navigate to providers tab and verify the provider/practice name
		ppt.PatientProviderTab().click();
		Thread.sleep(20000);
		Assert.assertEquals(ppt.ProviderPracticeNameTypeValue(), patientTestData.get(7).split(",")[0].strip()); 
		//AdminPortalLogout();
		
	} 

}
