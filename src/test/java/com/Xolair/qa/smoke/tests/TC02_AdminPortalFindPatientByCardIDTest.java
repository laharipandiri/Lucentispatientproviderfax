package com.Xolair.qa.smoke.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.pages.AdminPortalHomePage;
import com.juno.qa.pages.AdminPortalLoginLogoutPage;
import com.juno.qa.pages.AdminPortalPatientsPage;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class TC02_AdminPortalFindPatientByCardIDTest extends AdminPortalLoginLogoutPage {
	
	TestUtil testutil;
	
	AdminPortalPatientsPage app = new AdminPortalPatientsPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd= new ExcelTestDataReader();
	
	Xls_Reader reader = new Xls_Reader(testutil.TESTDATA_SHEET_PATH);
	
	String Key = "SearchEnrolledPatient";
	String MemberID = "";
	String CardID = "";
	String sheetname = "Smoke";
	String ExistingRowKey = "EnrollPatient";
	
	@BeforeMethod
	public void OpenBrowser() {
		try {
		intializeAdminDriver();
		TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		}
		catch(InterruptedException e) {
			
		}
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		closeBrowser();
		TestBase.classAInstance.endReport();
	
	} 
	
	@Test ( description = "Find patient in Admin portal for Drug Reimbursement")
	public void AdminFindPatient_DrugReimbursement() throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		AdminPortalLogin();
		//wait.until(ExpectedConditions.visibilityOf(AdminPortalLogoutButton()));
		
		//click on patients link
		ahp.PatientsLink().click();
		wait.until(ExpectedConditions.visibilityOf(ahp.FindLink()));
		
		//click on find link in the patients drop down
		ahp.FindLink().click();
		wait.until(ExpectedConditions.visibilityOf(app.PatientsFindPageMemberID()));
		Thread.sleep(60000);
		//get the rowNum
		int rowNum = etd.getKeyValuePair(Key);
		//Go to the sheet that has the test data
		reader.getSheet(sheetname);
		System.out.println("The Sheet name is:" +sheetname);
		//Go to the specific row
		Row	row = Xls_Reader.sheet.getRow(rowNum);
		System.out.println("The row is:" +row);
		
		//Copy the CardID field value from enrollment test data row to this new row
		String colName = "MemberID";
		List<Integer> rcNum = new ArrayList<Integer>();
		rcNum = etd.GetRowAndColNumOfTheFieldValue(ExistingRowKey, sheetname, colName);//get row and col num of existing test data based off of key, sheetname and colname
		int existingColNum = rcNum.get(0);
		int existingRowNum = rcNum.get(1);
		
		MemberID = gst.copyValueToDiffRow(Key, existingRowNum, existingColNum, rowNum, colName, "Smoke");
		System.out.println("The card ID is:" +MemberID);
		
		
		CardID = app.AdminPortalMemberIDSearch(MemberID);		
			System.out.println("After CardID:"+CardID);
		
			reader.setDataInNewRow(sheetname, "CardID", rowNum, null); //41
			
			System.out.println("CardID: "+CardID);
			//Set the CardID value that you get from the above method
			//reader.setCellData(sheetname, "CardID", rowNum + 1, CardID);
	        reader.setDataInNewRow(sheetname, "CardID", rowNum, CardID);    
		
		 //Click on Logout
		 AdminPortalLogoutButton().click();
		 System.out.print("Clicked on Logout button"); 
	}
	
	

}
