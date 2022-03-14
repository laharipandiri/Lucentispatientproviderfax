package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.Xolairadmin.qa.SmokeScript.FSV;
//import com.Xolairadmin.qa.SmokeScript.Transaction;
import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;

public class AdminPortal_CardActivities_FSVTranHistory extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	HubHomeLoginLogoutPage hll = new HubHomeLoginLogoutPage();
	HubHomePage hhp = new HubHomePage();
	HubPortal_ListAllCopayProgramPatientPage hlp = new HubPortal_ListAllCopayProgramPatientPage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubPortal_ListAllCopayProgramPatients_InsuranceTabPage hlc = new HubPortal_ListAllCopayProgramPatients_InsuranceTabPage();
	HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage pct = new HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage();
	
	public AdminPortal_CardActivities_FSVTranHistory() {
		PageFactory.initElements(driver, this);
	}
	public WebElement FindFSVStatusnTransactions()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Find FSV Status and Transactions')]"));
	}
	
	public WebElement FSVVDATA()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]"));
	}
	
	
	public WebElement FSVCardTransactionHistory()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'FSV Card Transaction History')]"));
	}
	public WebElement FSVTranHistorySearch()
	{
		return driver.findElement(By.name("Search"));
	}
	public WebElement FSVTranHistorySearchErrorMessage()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Unable to retrieve fsv_card_id , Check if it is OLD bin card')]"));
	}
	
}
