package com.adminXolair.qa.providerstest.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.getandsetTestData.ProviderGroups_GroupPractice;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.pages.AdminPortal_PG_GP_FindPage;
import com.juno.qa.pages.AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage;
import com.juno.qa.pages.AdminPortal_PG_GP_PatientsTabPage;
import com.juno.qa.pages.AdminPortal_Patients_PatientAndCardTabPage;
import com.juno.qa.pages.AdminPortal_Patients_ProviderTabPage;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC10_AdminPortal_PG_GP_NavigateToPatientInfoTabFromGPTest extends AdminPortalLoginLogoutPage {

	TestUtil testUtil;

	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);

	ProviderGroups_GroupPractice dat = new ProviderGroups_GroupPractice();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	CommonFunctions cf = new CommonFunctions();

	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	AdminPortal_PG_GP_FindPage pgf = new AdminPortal_PG_GP_FindPage();
	AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage pac = new AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage();
	AdminPortal_PG_GP_PatientsTabPage ptp = new AdminPortal_PG_GP_PatientsTabPage();
	AdminPortal_Patients_ProviderTabPage ppt = new AdminPortal_Patients_ProviderTabPage();

	String Key = "PGGPAndPatientMapping";
	String Key1 = "PGGPAndPatientMappingInAdminReimbursement";

	@BeforeMethod
	public void OpenBrowser() {
		try {
			intializeAdminDriver();
			TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		} catch (InterruptedException e) {

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

	@Test(description = "verify the ability to view patient info in patients tab of PG-->GP in DrugReimbursement")
	public void VerifyPatientsTabContentInGP_DrugReimbursement()
			throws InterruptedException, IOException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));

		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetPGGPAndPatientMappingTestData(Key, rowNum);
		// updated to provide link
		ahp.ProvidersLink().click();
		ahp.SearchProvider().click();
		pgf.GPFirstName().sendKeys(testData.get(1));
		pgf.GPProviderTypeDropdown().selectByVisibleText(testData.get(2));
		pgf.GPFindButton().click();
		wait.until(ExpectedConditions.visibilityOf(pgf.FirstReviewLinkInSearchGrid()));

		pgf.FirstReviewLinkInSearchGrid().click();// Click on the Review link for the first
		Assert.assertTrue(pac.GroupPracticeAndCardInfoTab().isDisplayed());

		ptp.PGGPPatientsTab().click();
		Thread.sleep(20000);

		wait.until(ExpectedConditions.visibilityOf(ptp.PGGPPatientsTab()));

		int colSize = ptp.PGGPPatientListTableColumns().size();
		System.out.println("Col size: " + colSize);
		Assert.assertTrue(!ptp.PGGPPatientListTableColumns().isEmpty());
		// verify the col names are matching between UI and excel
		for (int i = 1; i <= colSize; i++) {
			String colName = driver.findElement(By.xpath("//table[@id='provider-patient-list']//th[" + i + "]"))
					.getText();
			Assert.assertEquals(colName, testData.get(i + 2));
		}

		// Capture the field values of the columns from UI and add it to excel and then
		// cross check with the values in Patient & Card info tab
		String activationDate = ptp.PGGPPatientsTabActivationDateColValue().substring(0, 10);
		reader.setDataInNewRow("Regression", "ActivationDateValue", rowNum, activationDate);
		reader.setDataInNewRow("Regression", "PatientNameValue", rowNum, ptp.PGGPPatientsTabPatientNameColValue());
		reader.setDataInNewRow("Regression", "CityValue", rowNum, ptp.PGGPPatientsTabCityColValue());
		String stateName = cf.GetResidingStateName(ptp.PGGPPatientsTabStateColValue());
		reader.setDataInNewRow("Regression", "StateValue", rowNum, stateName);
		reader.setDataInNewRow("Regression", "ZipValue", rowNum, ptp.PGGPPatientsTabZipColValue());
		reader.setDataInNewRow("Regression", "PatientPartnerIDValue", rowNum,
				ptp.PGGPPatientsTabPartnerPatientIDColValue());
		reader.setDataInNewRow("Regression", "CardIDValue", rowNum, ptp.PGGPPatientsTabCardIDColValue());
		String[] providerNameTypeValues = ptp.PGGPPatientsTabProviderNameTypeColValue().split(",");
		String providerNameTypeValueAdjusted = providerNameTypeValues[0];
		reader.setDataInNewRow("Regression", "ProviderName/TypeValue", rowNum, providerNameTypeValueAdjusted);
		reader.setDataInNewRow("Regression", "ProgramNameValue", rowNum, ptp.PGGPPatientsTabProgramNameColValue());

		List<String> patientTestData = new ArrayList<String>();
		patientTestData = dat.GetPGGPPatientDataForPatientAndCardInfo(Key, rowNum);

		ptp.PGGPPatientFirstReviewLink().click();
		wait.until(ExpectedConditions.visibilityOf(apc.PatientAndCardTab()));
		
		String fullname = apc.PatientAndCardTabFirstNameValue() + ", " + apc.PatientAndCardTabLastNameValue();
		Assert.assertEquals(fullname, patientTestData.get(1));
		// Known Issue
		// Assert.assertEquals(apc.PatientAndCardTabActivationDateValue().trim(),
		// patientTestData.get(0));
		Assert.assertEquals(apc.PatientAndCardTabCityValue(), patientTestData.get(2));
		Assert.assertEquals(apc.PatientAndCardTabPatientResidingStateValue(), patientTestData.get(3));
		Assert.assertEquals(apc.PatientAndCardTabZipValue().substring(0, 5), patientTestData.get(4).substring(0, 5));
		Assert.assertEquals(apc.PatientAndCardTabCardIDValue(), patientTestData.get(6));
		// navigate to providers tab and verify the provider/practice name
		ppt.PatientProviderTab().click();
		Thread.sleep(20000);

		//AdminPortalLogout();

	}
}
