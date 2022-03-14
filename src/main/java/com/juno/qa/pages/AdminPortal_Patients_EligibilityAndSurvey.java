package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;

public class AdminPortal_Patients_EligibilityAndSurvey extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	AdminPortalLoginLogoutPage all = new AdminPortalLoginLogoutPage();
	AdminPortal_Patients_FaxInfoTabPage apf = new AdminPortal_Patients_FaxInfoTabPage();
	HubHomeLoginLogoutPage hll = new HubHomeLoginLogoutPage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubPortal_ListAllCopayProgramPatientPage hlc = new HubPortal_ListAllCopayProgramPatientPage();
	HubPortal_ListAllCopayProgramPatients_CommunicationsTabPage lcc = new HubPortal_ListAllCopayProgramPatients_CommunicationsTabPage();
	HubHomePage hhp = new HubHomePage();
	
	public HashMap<String, String> GetRejectionReason()
	{
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("Zero Copay", "The Explanation of Benefits indicates that the patient has $0 responsibility for eligible expenses.");
		
		return testData;
	}
	
	public AdminPortal_Patients_EligibilityAndSurvey() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement EligibilityTab()
	{
		return driver.findElement(By.linkText("Eligibility & Survey"));
	}
	
	public WebElement EligibilityQuestions()
	{
		return driver.findElement(By.xpath("//*[@id='tab_8']/div[2]"));
	}	
	
}
