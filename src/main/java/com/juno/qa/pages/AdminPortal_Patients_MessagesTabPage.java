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

public class AdminPortal_Patients_MessagesTabPage extends TestBase {
	
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
	
	public AdminPortal_Patients_MessagesTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement MessagesTab()
	{
		return driver.findElement(By.linkText("Messages"));
	}
	public WebElement EnrollmentApproval()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_0']"));
	}
	
	public WebElement EnrollmentDeactivation()
	{
		return driver.findElement(By.xpath("//*[@id='message-list']/tbody/tr[2]/td[1]"));
	}
	public String MessagesLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div/table/tbody/tr/td/font/strong")).getText();
	}
	
	public List<WebElement> MessagesTabTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/thead/tr/th"));
	}
	
	public List<WebElement> MessagesTabTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr"));
	}
	
	public int MessagesTabTableRowsNum()
	{
		//we need to do "-1" because the last row is an empty row in the table
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr")).size()-1;
	}
	
	public WebElement SubjectColLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+MessagesTabTableRowsNum()+"]/td[1]/a"));
	}
	
	public WebElement CreatedDateColLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+MessagesTabTableRowsNum()+"]/td[2]"));
	}
	
	public WebElement ProcessedDateColLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+MessagesTabTableRowsNum()+"]/td[3]"));
	}
	
	public WebElement SentToColLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+MessagesTabTableRowsNum()+"]/td[4]"));
	}
	
	public WebElement SubjectColLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+(MessagesTabTableRowsNum()-1)+"]/td[1]/a"));
	}
	
	public WebElement CreatedDateColLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+(MessagesTabTableRowsNum()-1)+"]/td[2]"));
	}
	
	public WebElement ProcessedDateColLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+(MessagesTabTableRowsNum()-1)+"]/td[3]"));
	}
	
	public WebElement SentToColLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[10][@id='tab_7']/div[2]/table/tbody/tr["+(MessagesTabTableRowsNum()-1)+"]/td[4]"));
	}
	
	public boolean VerifyClaimRejectionLetterInAdminAndHub(List<String> testData, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside method");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		        
			String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			String state = cf.GetResidingStateCode(testData.get(22));
			String patientfullinfo = testData.get(18)+" "+testData.get(19)+"\n"+testData.get(20)+"\n"+testData.get(21)+","+state+" "+testData.get(23);
			
			//go to fax info tab and verify the outgoing fax that got generated for claim rejection
			apf.FaxInfoTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(apf.OutgoingFaxActionViewLinkLatestRow().isDisplayed());
			Assert.assertTrue(apf.OutgoingTypeValueLatestRow().equalsIgnoreCase(testData.get(24)));
			Assert.assertTrue(apf.OutgoingTimeValueLatestRow().contains(createdDate));
			Assert.assertTrue(apf.OutgoingStatusValueLatestRow().equalsIgnoreCase(testData.get(26)));
			String[] outgoingANI = apf.OutgoingANIOutANILatestRow().split("-");
			String OutANI = outgoingANI[0]+outgoingANI[1]+outgoingANI[2];
			Assert.assertEquals(OutANI, testData.get(5));
			System.out.println("After outani");
			String[] outAniTextBox = apf.OutgoingFaxTextBoxValueLatestRow().split("-");
			String outTextANI = outAniTextBox[0]+outAniTextBox[1]+outAniTextBox[2];
			Assert.assertEquals(outTextANI, testData.get(5));
			Assert.assertTrue(apf.ReviewedDateLatestRowValue().contains(createdDate));
			System.out.println("reviewed date");
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			apf.OutgoingFaxActionViewLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in admin portal","Succesfully able to  Verify Outgoing rejection fax in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in admin portal","Failed to  Verify Outgoing rejection fax in admin portal");
			 }
			String OutgoingRejectionFaxURL = driver.getCurrentUrl();
			String OutgoingRejectionURL = OutgoingRejectionFaxURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
			
		
			
			
			//go to messages tab
			MessagesTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(MessagesTabTableRowsNum()==2);
			System.out.println("Clicked on messages tab");
			//verify the col values in messages tab
			Assert.assertTrue(SubjectColLatestRow().isDisplayed());
			Assert.assertTrue(CreatedDateColLatestRow().getText().contains(createdDate));
			Assert.assertTrue(ProcessedDateColLatestRow().getText().contains(createdDate));
			System.out.println("patient1:"+SentToColLatestRow().getText());
			System.out.println("patient2:"+patientfullinfo);
			Assert.assertTrue(SentToColLatestRow().getText().equalsIgnoreCase(patientfullinfo));
			
			String createdDateInAdmin = CreatedDateColLatestRow().getText();
			String processedDateInAdmin = ProcessedDateColLatestRow().getText();
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore1 = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in admin portal","Succesfully able to  Verify Claim rejection letter in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in admin portal","Failed to  Verify  Claim rejection letter in admin portal");
			 }
			String AdminRejectionLetterURL = driver.getCurrentUrl();
			String AdminRejectionURL = AdminRejectionLetterURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore1);	
			
			try
			{
				//verify the content of the letter
				Assert.assertTrue(VerifyRejectionLetterContent(testData, "Zero Copay", "Admin"));
			}
			catch(ParseException e)
			{
				
			}
			
			//logout of admin
			all.AdminPortalLogout();
			driver.quit();
			
			//Now log into hub portal and verify the claim rejection letter
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				} 
			
			Thread.sleep(2000);
			hll.HubPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
			
			
			hrp.ListAllCopayProgramPatientsButton().click();
			hlc.MemberIDSearchField().sendKeys(testData.get(0));
			Thread.sleep(2000);
			hlc.ActionColReviewLink().click();
			wait.until(ExpectedConditions.visibilityOf(lcc.CommunicationsTab()));
			
			lcc.CommunicationsTab().click();
			Thread.sleep(3000);
			
			System.out.println("Clicked on comm tab");
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			 Date date1 = sdf1.parse(createdDateInAdmin);
			 Date date2 = sdf1.parse(processedDateInAdmin);
			 
			 String formattedCreatedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date1);
			 String formattedProcessedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date2);
			
			 System.out.println("formattedCreatedDateFromAdmin-1:"+formattedCreatedDateFromAdmin);
			 System.out.println("formattedCreatedDateFromAdmin-2:"+lcc.LettersTableCreatedDatevalueLatestRow());
			 
			 System.out.println("formattedProcessedDateFromAdmin-1:"+formattedProcessedDateFromAdmin);
			 System.out.println("formattedProcessedDateFromAdmin-2:"+lcc.LettersTableSentDatevalueLatestRow());
			 
			//make sure that the following are displayed
			 Assert.assertTrue(lcc.LettersTableRows().size()==3);//need to give 3, because dev implemented the table in a manner that header also is a tag tr
			Assert.assertTrue(lcc.LettersTableSubjectLetterLinkLatestRow().isDisplayed());
			Assert.assertTrue(lcc.LettersTableCreatedDatevalueLatestRow().contains(formattedCreatedDateFromAdmin));
			Assert.assertTrue(lcc.LettersTableSentDatevalueLatestRow().contains(formattedProcessedDateFromAdmin));
			System.out.println("patient-f:"+lcc.LettersTableSentTovalueLatestRow());
			System.out.println("patient-e:"+patientfullinfo);
			
			Assert.assertTrue(lcc.LettersTableSentTovalueLatestRow().equalsIgnoreCase(patientfullinfo));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore2 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in hub portal","Succesfully able to  Verify Claim rejection letter in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in hub portal","Failed to  Verify  Claim rejection letter in hub portal");
			 }
			String HubClaimRejectionLetterURL = driver.getCurrentUrl();
			String HubClaimRejectionURL = HubClaimRejectionLetterURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore2);	
			Assert.assertEquals(AdminRejectionURL, HubClaimRejectionURL);
			
			try
			{
				//verify the content of the letter
				Assert.assertTrue(VerifyRejectionLetterContent(testData, "Zero Copay", "Hub"));
			}
			catch(ParseException e)
			{
				
			}
			
			
			//Now verify the outgoing rejection fax
			
			
		    Date date3 = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date3));
		        
			String outgoingFaxDate = new SimpleDateFormat("MM/dd/yyyy").format(date3);
		
			Assert.assertEquals(lcc.TypevalueFourthRow(), testData.get(25));
			Assert.assertTrue(lcc.DatevalueFourthRow().contains(outgoingFaxDate));
			Assert.assertTrue(lcc.FaxStatusvalueSecondRow().contains(testData.get(26)));
			String[] outgoingFaxNum = lcc.FaxNumbervalueFourthRow().split("-");
			String outFaxNum = outgoingFaxNum[0]+outgoingFaxNum[1]+outgoingFaxNum[2];
			Assert.assertEquals(outFaxNum, testData.get(5));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore3 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.ViewLinkFourthRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in hub portal","Succesfully able to  Verify Outgoing rejection fax in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in hub portal","Failed to  Verify  Claim Outgoing rejection fax in hub portal");
			 }
			String HubOutgoingRejectionFaxURL = driver.getCurrentUrl();
			String HubOutgoingRejectionURL = HubOutgoingRejectionFaxURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore3);	
			
			Assert.assertEquals(OutgoingRejectionURL, HubOutgoingRejectionURL);
			
			
			hrp.HubReimbursementLogoutButton().click();
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	
	
	public boolean VerifyClaimRejectionLetterForDuplicateClaimInAdminAndHub(List<String> testData, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside method");
		
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*    Date date = sdf.parse(currentDate); 
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		        
		    String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date); */
			
			String state = cf.GetResidingStateCode(testData.get(22));
			String patientfullinfo = testData.get(18)+" "+testData.get(19)+"\n"+testData.get(20)+"\n"+testData.get(21)+","+state+" "+testData.get(23);
			
			//go to fax info tab and verify the outgoing fax that got generated for claim rejection
			apf.FaxInfoTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(apf.OutgoingFaxActionViewLinkLatestRow().isDisplayed());
			Assert.assertTrue(apf.OutgoingTypeValueLatestRow().equalsIgnoreCase(testData.get(25)));
			Assert.assertTrue(apf.OutgoingTimeValueLatestRow().contains(currentDate));
			Assert.assertTrue(apf.OutgoingStatusValueLatestRow().equalsIgnoreCase(testData.get(27)));
			String[] outgoingANI = apf.OutgoingANIOutANILatestRow().split("-");
			String OutANI = outgoingANI[0]+outgoingANI[1]+outgoingANI[2];
			Assert.assertEquals(OutANI, testData.get(5));
			System.out.println("After outani");
			String[] outAniTextBox = apf.OutgoingFaxTextBoxValueLatestRow().split("-");
			String outTextANI = outAniTextBox[0]+outAniTextBox[1]+outAniTextBox[2];
			Assert.assertEquals(outTextANI, testData.get(5));
			Assert.assertTrue(apf.ReviewedDateLatestRowValue().contains(currentDate));
			System.out.println("reviewed date");
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			apf.OutgoingFaxActionViewLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in admin portal","Succesfully able to  Verify Outgoing rejection fax in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in admin portal","Failed to  Verify Outgoing rejection fax in admin portal");
			 }
			String OutgoingRejectionFaxURL = driver.getCurrentUrl();
			String OutgoingRejectionURL = OutgoingRejectionFaxURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
			
		
			
			
			//go to messages tab
			MessagesTab().click();
			Thread.sleep(5000);
			System.out.println("Clicked on messages tab");
			//verify the col values in messages tab
			Assert.assertTrue(MessagesTabTableRowsNum()==2);
			Assert.assertTrue(SubjectColLatestRow().isDisplayed());
			Assert.assertTrue(CreatedDateColLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ProcessedDateColLatestRow().getText().contains(currentDate));
			System.out.println("patient1:"+SentToColLatestRow().getText());
			System.out.println("patient2:"+patientfullinfo);
			Assert.assertTrue(SentToColLatestRow().getText().equalsIgnoreCase(patientfullinfo));
			
			String createdDateInAdmin = CreatedDateColLatestRow().getText();
			String processedDateInAdmin = ProcessedDateColLatestRow().getText();
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore1 = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in admin portal","Succesfully able to  Verify Claim rejection letter in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in admin portal","Failed to  Verify  Claim rejection letter in admin portal");
			 }
			String AdminRejectionLetterURL = driver.getCurrentUrl();
			String AdminRejectionURL = AdminRejectionLetterURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore1);	
			
			//logout of admin
			all.AdminPortalLogout();
			driver.quit();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//Now log into hub portal and verify the claim rejection letter
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				} 
			
			Thread.sleep(2000);
			hll.HubPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
			
			hrp.ListAllCopayProgramPatientsButton().click();
			hlc.MemberIDSearchField().sendKeys(testData.get(0));
			Thread.sleep(2000);
			hlc.ActionColReviewLink().click();
			wait.until(ExpectedConditions.visibilityOf(lcc.CommunicationsTab()));
			
			lcc.CommunicationsTab().click();
			Thread.sleep(3000);
			
			System.out.println("Clicked on comm tab");
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			 Date date1 = sdf1.parse(createdDateInAdmin);
			 Date date2 = sdf1.parse(processedDateInAdmin);
			 
			 String formattedCreatedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date1);
			 String formattedProcessedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date2);
			
			 System.out.println("formattedCreatedDateFromAdmin-1:"+formattedCreatedDateFromAdmin);
			 System.out.println("formattedCreatedDateFromAdmin-2:"+lcc.LettersTableCreatedDatevalueLatestRow());
			 
			 System.out.println("formattedProcessedDateFromAdmin-1:"+formattedProcessedDateFromAdmin);
			 System.out.println("formattedProcessedDateFromAdmin-2:"+lcc.LettersTableSentDatevalueLatestRow());
			 
			//make sure that the following are displayed
			 Assert.assertTrue(lcc.LettersTableRows().size()==3);
			Assert.assertTrue(lcc.LettersTableSubjectLetterLinkLatestRow().isDisplayed());
			Assert.assertTrue(lcc.LettersTableCreatedDatevalueLatestRow().contains(formattedCreatedDateFromAdmin));
			Assert.assertTrue(lcc.LettersTableSentDatevalueLatestRow().contains(formattedProcessedDateFromAdmin));
			System.out.println("patient-f:"+lcc.LettersTableSentTovalueLatestRow());
			System.out.println("patient-e:"+patientfullinfo);
			
			Assert.assertTrue(lcc.LettersTableSentTovalueLatestRow().equalsIgnoreCase(patientfullinfo));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore2 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in hub portal","Succesfully able to  Verify Claim rejection letter in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in hub portal","Failed to  Verify  Claim rejection letter in hub portal");
			 }
			String HubClaimRejectionLetterURL = driver.getCurrentUrl();
			String HubClaimRejectionURL = HubClaimRejectionLetterURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore2);	
			Assert.assertEquals(AdminRejectionURL, HubClaimRejectionURL);
			
			
			//Now verify the outgoing rejection fax
			
			
		    Date date3 = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date3));
		        
			String outgoingFaxDate = new SimpleDateFormat("MM/dd/yyyy").format(date3);
			
			Assert.assertEquals(lcc.TypevalueFourthRow(), testData.get(26));
			Assert.assertTrue(lcc.DatevalueFourthRow().contains(outgoingFaxDate));
			Assert.assertTrue(lcc.FaxStatusvalueFourthRow().contains(testData.get(27)));
			String[] outgoingFaxNum = lcc.FaxNumbervalueFourthRow().split("-");
			String outFaxNum = outgoingFaxNum[0]+outgoingFaxNum[1]+outgoingFaxNum[2];
			Assert.assertEquals(outFaxNum, testData.get(5));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore3 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.ViewLinkFourthRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in hub portal","Succesfully able to  Verify Outgoing rejection fax in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in hub portal","Failed to  Verify  Claim Outgoing rejection fax in hub portal");
			 }
			String HubOutgoingRejectionFaxURL = driver.getCurrentUrl();
			String HubOutgoingRejectionURL = HubOutgoingRejectionFaxURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore3);	
			
			Assert.assertEquals(OutgoingRejectionURL, HubOutgoingRejectionURL);
			
			
			hrp.HubReimbursementLogoutButton().click();
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyClaimRejectionLetterForDOSPriorLookBackDateAndNoEligibleChargesInAdminAndHub(List<String> testData, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside method");
			
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*    Date date = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		        
			String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date); */
			
			String state = cf.GetResidingStateCode(testData.get(22));
			String patientfullinfo = testData.get(18)+" "+testData.get(19)+"\n"+testData.get(20)+"\n"+testData.get(21)+","+state+" "+testData.get(23);
			
			//go to fax info tab and verify the outgoing fax that got generated for claim rejection
			apf.FaxInfoTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(apf.OutgoingFaxActionViewLinkLatestRow().isDisplayed());
			Assert.assertTrue(apf.OutgoingTypeValueLatestRow().equalsIgnoreCase(testData.get(25)));
			Assert.assertTrue(apf.OutgoingTimeValueLatestRow().contains(currentDate));
			Assert.assertTrue(apf.OutgoingStatusValueLatestRow().equalsIgnoreCase(testData.get(27)));
			String[] outgoingANI = apf.OutgoingANIOutANILatestRow().split("-");
			String OutANI = outgoingANI[0]+outgoingANI[1]+outgoingANI[2];
			Assert.assertEquals(OutANI, testData.get(5));
			System.out.println("After outani");
			String[] outAniTextBox = apf.OutgoingFaxTextBoxValueLatestRow().split("-");
			String outTextANI = outAniTextBox[0]+outAniTextBox[1]+outAniTextBox[2];
			Assert.assertEquals(outTextANI, testData.get(5));
			Assert.assertTrue(apf.ReviewedDateLatestRowValue().contains(currentDate));
			System.out.println("reviewed date");
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			apf.OutgoingFaxActionViewLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in admin portal","Succesfully able to  Verify Outgoing rejection fax in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in admin portal","Failed to  Verify Outgoing rejection fax in admin portal");
			 }
			String OutgoingRejectionFaxURL = driver.getCurrentUrl();
			String OutgoingRejectionURL = OutgoingRejectionFaxURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
			
		
			
			
			//go to messages tab
			MessagesTab().click();
			Thread.sleep(5000);
			System.out.println("Clicked on messages tab");
			//verify the col values in messages tab
			Assert.assertTrue(MessagesTabTableRowsNum()==2);
			Assert.assertTrue(SubjectColLatestRow().isDisplayed());
			Assert.assertTrue(CreatedDateColLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ProcessedDateColLatestRow().getText().contains(currentDate));
			System.out.println("patient1:"+SentToColLatestRow().getText());
			System.out.println("patient2:"+patientfullinfo);
			Assert.assertTrue(SentToColLatestRow().getText().equalsIgnoreCase(patientfullinfo));
			
			String createdDateInAdmin = CreatedDateColLatestRow().getText();
			String processedDateInAdmin = ProcessedDateColLatestRow().getText();
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore1 = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in admin portal","Succesfully able to  Verify Claim rejection letter in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in admin portal","Failed to  Verify  Claim rejection letter in admin portal");
			 }
			String AdminRejectionLetterURL = driver.getCurrentUrl();
			String AdminRejectionURL = AdminRejectionLetterURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore1);	
			
			//logout of admin
			all.AdminPortalLogout();
			driver.quit();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//Now log into hub portal and verify the claim rejection letter
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				} 
			
			Thread.sleep(2000);
			hll.HubPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
			
			
			hrp.ListAllCopayProgramPatientsButton().click();
			hlc.MemberIDSearchField().sendKeys(testData.get(0));
			Thread.sleep(2000);
			hlc.ActionColReviewLink().click();
			wait.until(ExpectedConditions.visibilityOf(lcc.CommunicationsTab()));
			
			lcc.CommunicationsTab().click();
			Thread.sleep(3000);
			
			System.out.println("Clicked on comm tab");
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			 Date date1 = sdf1.parse(createdDateInAdmin);
			 Date date2 = sdf1.parse(processedDateInAdmin);
			 
			 String formattedCreatedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date1);
			 String formattedProcessedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date2);
			
			 System.out.println("formattedCreatedDateFromAdmin-1:"+formattedCreatedDateFromAdmin);
			 System.out.println("formattedCreatedDateFromAdmin-2:"+lcc.LettersTableCreatedDatevalueLatestRow());
			 
			 System.out.println("formattedProcessedDateFromAdmin-1:"+formattedProcessedDateFromAdmin);
			 System.out.println("formattedProcessedDateFromAdmin-2:"+lcc.LettersTableSentDatevalueLatestRow());
			 
			//make sure that the following are displayed
			 Assert.assertTrue(lcc.LettersTableRows().size()==3);
			Assert.assertTrue(lcc.LettersTableSubjectLetterLinkLatestRow().isDisplayed());
			Assert.assertTrue(lcc.LettersTableCreatedDatevalueLatestRow().contains(formattedCreatedDateFromAdmin));
			Assert.assertTrue(lcc.LettersTableSentDatevalueLatestRow().contains(formattedProcessedDateFromAdmin));
			System.out.println("patient-f:"+lcc.LettersTableSentTovalueLatestRow());
			System.out.println("patient-e:"+patientfullinfo);
			
			Assert.assertTrue(lcc.LettersTableSentTovalueLatestRow().equalsIgnoreCase(patientfullinfo));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore2 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in hub portal","Succesfully able to  Verify Claim rejection letter in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in hub portal","Failed to  Verify  Claim rejection letter in hub portal");
			 }
			String HubClaimRejectionLetterURL = driver.getCurrentUrl();
			String HubClaimRejectionURL = HubClaimRejectionLetterURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore2);	
			Assert.assertEquals(AdminRejectionURL, HubClaimRejectionURL);
			
			
			//Now verify the outgoing rejection fax
			
			
		    Date date3 = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date3));
		        
			String outgoingFaxDate = new SimpleDateFormat("MM/dd/yyyy").format(date3);
			
			Assert.assertEquals(lcc.TypevalueFourthRow(), testData.get(26));
			Assert.assertTrue(lcc.DatevalueFourthRow().contains(outgoingFaxDate));
			Assert.assertTrue(lcc.FaxStatusvalueFourthRow().contains(testData.get(27)));
			String[] outgoingFaxNum = lcc.FaxNumbervalueFourthRow().split("-");
			String outFaxNum = outgoingFaxNum[0]+outgoingFaxNum[1]+outgoingFaxNum[2];
			Assert.assertEquals(outFaxNum, testData.get(5));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore3 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.ViewLinkFourthRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in hub portal","Succesfully able to  Verify Outgoing rejection fax in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in hub portal","Failed to  Verify  Claim Outgoing rejection fax in hub portal");
			 }
			String HubOutgoingRejectionFaxURL = driver.getCurrentUrl();
			String HubOutgoingRejectionURL = HubOutgoingRejectionFaxURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore3);	
			
			Assert.assertEquals(OutgoingRejectionURL, HubOutgoingRejectionURL);
			
			
			hrp.HubReimbursementLogoutButton().click();
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyClaimRejectionLetterForRejectReasonInAdminAndHub(List<String> testData, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside method");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*    Date date = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		        
			String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date); */
			
			String state = cf.GetResidingStateCode(testData.get(20));
			String patientfullinfo = testData.get(16)+" "+testData.get(17)+"\n"+testData.get(18)+"\n"+testData.get(19)+","+state+" "+testData.get(21);
			
			//go to fax info tab and verify the outgoing fax that got generated for claim rejection
			apf.FaxInfoTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(apf.OutgoingFaxActionViewLinkLatestRow().isDisplayed());
			Assert.assertTrue(apf.OutgoingTypeValueLatestRow().equalsIgnoreCase(testData.get(22)));
			Assert.assertTrue(apf.OutgoingTimeValueLatestRow().contains(currentDate));
			Assert.assertTrue(apf.OutgoingStatusValueLatestRow().equalsIgnoreCase(testData.get(24)));
			String[] outgoingANI = apf.OutgoingANIOutANILatestRow().split("-");
			String OutANI = outgoingANI[0]+outgoingANI[1]+outgoingANI[2];
			Assert.assertEquals(OutANI, testData.get(5));
			System.out.println("After outani");
			String[] outAniTextBox = apf.OutgoingFaxTextBoxValueLatestRow().split("-");
			String outTextANI = outAniTextBox[0]+outAniTextBox[1]+outAniTextBox[2];
			Assert.assertEquals(outTextANI, testData.get(5));
			Assert.assertTrue(apf.ReviewedDateLatestRowValue().contains(currentDate));
			System.out.println("reviewed date");
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			apf.OutgoingFaxActionViewLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in admin portal","Succesfully able to  Verify Outgoing rejection fax in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in admin portal","Failed to  Verify Outgoing rejection fax in admin portal");
			 }
			String OutgoingRejectionFaxURL = driver.getCurrentUrl();
			String OutgoingRejectionURL = OutgoingRejectionFaxURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
			
		
			
			
			//go to messages tab
			MessagesTab().click();
			Thread.sleep(5000);
			System.out.println("Clicked on messages tab");
			//verify the col values in messages tab
			Assert.assertTrue(MessagesTabTableRowsNum()==2);
			Assert.assertTrue(SubjectColLatestRow().isDisplayed());
			Assert.assertTrue(CreatedDateColLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ProcessedDateColLatestRow().getText().contains(currentDate));
			System.out.println("patient1:"+SentToColLatestRow().getText());
			System.out.println("patient2:"+patientfullinfo);
			Assert.assertTrue(SentToColLatestRow().getText().equalsIgnoreCase(patientfullinfo));
			
			String createdDateInAdmin = CreatedDateColLatestRow().getText();
			String processedDateInAdmin = ProcessedDateColLatestRow().getText();
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore1 = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in admin portal","Succesfully able to  Verify Claim rejection letter in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in admin portal","Failed to  Verify  Claim rejection letter in admin portal");
			 }
			String AdminRejectionLetterURL = driver.getCurrentUrl();
			String AdminRejectionURL = AdminRejectionLetterURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore1);	
			
			//logout of admin
			all.AdminPortalLogout();
			driver.quit();
			
			//Now log into hub portal and verify the claim rejection letter
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				} 
			
			Thread.sleep(2000);
			hll.HubPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
		
			
			hrp.ListAllCopayProgramPatientsButton().click();
			hlc.MemberIDSearchField().sendKeys(testData.get(0));
			Thread.sleep(2000);
			hlc.ActionColReviewLink().click();
			wait.until(ExpectedConditions.visibilityOf(lcc.CommunicationsTab()));
			
			lcc.CommunicationsTab().click();
			Thread.sleep(3000);
			
			System.out.println("Clicked on comm tab");
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			 Date date1 = sdf1.parse(createdDateInAdmin);
			 Date date2 = sdf1.parse(processedDateInAdmin);
			 
			 String formattedCreatedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date1);
			 String formattedProcessedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date2);
			
			 System.out.println("formattedCreatedDateFromAdmin-1:"+formattedCreatedDateFromAdmin);
			 System.out.println("formattedCreatedDateFromAdmin-2:"+lcc.LettersTableCreatedDatevalueLatestRow());
			 
			 System.out.println("formattedProcessedDateFromAdmin-1:"+formattedProcessedDateFromAdmin);
			 System.out.println("formattedProcessedDateFromAdmin-2:"+lcc.LettersTableSentDatevalueLatestRow());
			 
			//make sure that the following are displayed
			 Assert.assertTrue(lcc.LettersTableRows().size()==3);
			Assert.assertTrue(lcc.LettersTableSubjectLetterLinkLatestRow().isDisplayed());
			Assert.assertTrue(lcc.LettersTableCreatedDatevalueLatestRow().contains(formattedCreatedDateFromAdmin));
			Assert.assertTrue(lcc.LettersTableSentDatevalueLatestRow().contains(formattedProcessedDateFromAdmin));
			System.out.println("patient-f:"+lcc.LettersTableSentTovalueLatestRow());
			System.out.println("patient-e:"+patientfullinfo);
			
			Assert.assertTrue(lcc.LettersTableSentTovalueLatestRow().equalsIgnoreCase(patientfullinfo));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore2 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in hub portal","Succesfully able to  Verify Claim rejection letter in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in hub portal","Failed to  Verify  Claim rejection letter in hub portal");
			 }
			String HubClaimRejectionLetterURL = driver.getCurrentUrl();
			String HubClaimRejectionURL = HubClaimRejectionLetterURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore2);	
			Assert.assertEquals(AdminRejectionURL, HubClaimRejectionURL);
			
			
			//Now verify the outgoing rejection fax
			
			
		    Date date3 = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date3));
		        
			String outgoingFaxDate = new SimpleDateFormat("MM/dd/yyyy").format(date3);
			
			Assert.assertEquals(lcc.TypevalueFourthRow(), testData.get(23));
			Assert.assertTrue(lcc.DatevalueFourthRow().contains(outgoingFaxDate));
			Assert.assertTrue(lcc.FaxStatusvalueFourthRow().contains(testData.get(24)));
			String[] outgoingFaxNum = lcc.FaxNumbervalueFourthRow().split("-");
			String outFaxNum = outgoingFaxNum[0]+outgoingFaxNum[1]+outgoingFaxNum[2];
			Assert.assertEquals(outFaxNum, testData.get(5));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore3 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.ViewLinkFourthRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in hub portal","Succesfully able to  Verify Outgoing rejection fax in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in hub portal","Failed to  Verify  Claim Outgoing rejection fax in hub portal");
			 }
			String HubOutgoingRejectionFaxURL = driver.getCurrentUrl();
			String HubOutgoingRejectionURL = HubOutgoingRejectionFaxURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore3);	
			
			Assert.assertEquals(OutgoingRejectionURL, HubOutgoingRejectionURL);
			
			
			hrp.HubReimbursementLogoutButton().click();
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyMaxBenefitsExceededClaimRejectionLetterInAdminAndHub(List<String> testData, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside method");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*    Date date = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
		        
			String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date); */
			
			String state = cf.GetResidingStateCode(testData.get(19));
			String patientfullinfo = testData.get(1)+" "+testData.get(2)+"\n"+testData.get(17)+"\n"+testData.get(18)+","+state+" "+testData.get(20);
			
			//go to fax info tab and verify the outgoing fax that got generated for claim rejection
			apf.FaxInfoTab().click();
			Thread.sleep(5000);
			Assert.assertTrue(apf.OutgoingFaxActionViewLinkLatestRow().isDisplayed());
			Assert.assertTrue(apf.OutgoingTypeValueLatestRow().equalsIgnoreCase(testData.get(22)));
			Assert.assertTrue(apf.OutgoingTimeValueLatestRow().contains(currentDate));
			Assert.assertTrue(apf.OutgoingStatusValueLatestRow().equalsIgnoreCase(testData.get(24)));
			String[] outgoingANI = apf.OutgoingANIOutANILatestRow().split("-");
			String OutANI = outgoingANI[0]+outgoingANI[1]+outgoingANI[2];
			Assert.assertEquals(OutANI, testData.get(7));
			System.out.println("After outani");
			String[] outAniTextBox = apf.OutgoingFaxTextBoxValueLatestRow().split("-");
			String outTextANI = outAniTextBox[0]+outAniTextBox[1]+outAniTextBox[2];
			Assert.assertEquals(outTextANI, testData.get(7));
			Assert.assertTrue(apf.ReviewedDateLatestRowValue().contains(currentDate));
			System.out.println("reviewed date");
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			apf.OutgoingFaxActionViewLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in admin portal","Succesfully able to  Verify Outgoing rejection fax in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in admin portal","Failed to  Verify Outgoing rejection fax in admin portal");
			 }
			String OutgoingRejectionFaxURL = driver.getCurrentUrl();
			String OutgoingRejectionURL = OutgoingRejectionFaxURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);	
			
		
			
			
			//go to messages tab
			MessagesTab().click();
			Thread.sleep(5000);
			System.out.println("Clicked on messages tab");
			//verify the col values in messages tab
			Assert.assertTrue(MessagesTabTableRowsNum()==2);
			Assert.assertTrue(SubjectColLatestRow().isDisplayed());
			Assert.assertTrue(CreatedDateColLatestRow().getText().contains(currentDate));
			Assert.assertTrue(ProcessedDateColLatestRow().getText().contains(currentDate));
			System.out.println("patient1:"+SentToColLatestRow().getText());
			System.out.println("patient2:"+patientfullinfo);
			Assert.assertTrue(SentToColLatestRow().getText().equalsIgnoreCase(patientfullinfo));
			
			String createdDateInAdmin = CreatedDateColLatestRow().getText();
			String processedDateInAdmin = ProcessedDateColLatestRow().getText();
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore1 = driver.getWindowHandle();
			
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in admin portal","Succesfully able to  Verify Claim rejection letter in admin portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in admin portal","Failed to  Verify  Claim rejection letter in admin portal");
			 }
			String AdminRejectionLetterURL = driver.getCurrentUrl();
			String AdminRejectionURL = AdminRejectionLetterURL.substring(0, 146);
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore1);	
			
			//logout of admin
			all.AdminPortalLogout();
			driver.quit();
			
			//Now log into hub portal and verify the claim rejection letter
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				} 
			
			Thread.sleep(2000);
			hll.HubPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
			
		
			
			hrp.ListAllCopayProgramPatientsButton().click();
			hlc.MemberIDSearchField().sendKeys(testData.get(0));
			Thread.sleep(2000);
			hlc.ActionColReviewLink().click();
			wait.until(ExpectedConditions.visibilityOf(lcc.CommunicationsTab()));
			
			lcc.CommunicationsTab().click();
			Thread.sleep(3000);
			
			System.out.println("Clicked on comm tab");
			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			 Date date1 = sdf1.parse(createdDateInAdmin);
			 Date date2 = sdf1.parse(processedDateInAdmin);
			 
			 String formattedCreatedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date1);
			 String formattedProcessedDateFromAdmin = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").format(date2);
			
			 System.out.println("formattedCreatedDateFromAdmin-1:"+formattedCreatedDateFromAdmin);
			 System.out.println("formattedCreatedDateFromAdmin-2:"+lcc.LettersTableCreatedDatevalueLatestRow());
			 
			 System.out.println("formattedProcessedDateFromAdmin-1:"+formattedProcessedDateFromAdmin);
			 System.out.println("formattedProcessedDateFromAdmin-2:"+lcc.LettersTableSentDatevalueLatestRow());
			 
			//make sure that the following are displayed
			 Assert.assertTrue(lcc.LettersTableRows().size()==3);
			Assert.assertTrue(lcc.LettersTableSubjectLetterLinkLatestRow().isDisplayed());
			Assert.assertTrue(lcc.LettersTableCreatedDatevalueLatestRow().contains(formattedCreatedDateFromAdmin));
			Assert.assertTrue(lcc.LettersTableSentDatevalueLatestRow().contains(formattedProcessedDateFromAdmin));
			System.out.println("patient-f:"+lcc.LettersTableSentTovalueLatestRow());
			System.out.println("patient-e:"+patientfullinfo);
			
			Assert.assertTrue(lcc.LettersTableSentTovalueLatestRow().equalsIgnoreCase(patientfullinfo));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore2 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Claim rejection letter in hub portal","Succesfully able to  Verify Claim rejection letter in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Claim rejection letter in hub portal","Failed to  Verify  Claim rejection letter in hub portal");
			 }
			String HubClaimRejectionLetterURL = driver.getCurrentUrl();
			String HubClaimRejectionURL = HubClaimRejectionLetterURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore2);	
			Assert.assertEquals(AdminRejectionURL, HubClaimRejectionURL);
			
			
			//Now verify the outgoing rejection fax
			
			
		    Date date3 = sdf.parse(currentDate);
		 
		    System.out.println("MM/dd/yyyy formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date3));
		        
			String outgoingFaxDate = new SimpleDateFormat("MM/dd/yyyy").format(date3);
			
			Assert.assertEquals(lcc.TypevalueFourthRow(), testData.get(23));
			Assert.assertTrue(lcc.DatevalueFourthRow().contains(outgoingFaxDate));
			Assert.assertTrue(lcc.FaxStatusvalueFourthRow().contains(testData.get(24)));
			String[] outgoingFaxNum = lcc.FaxNumbervalueFourthRow().split("-");
			String outFaxNum = outgoingFaxNum[0]+outgoingFaxNum[1]+outgoingFaxNum[2];
			Assert.assertEquals(outFaxNum, testData.get(7));
			
			//now click on the enrollment letter and capture the url
			String winHandleBefore3 = driver.getWindowHandle();

			// Perform the click operation that opens new window
			lcc.ViewLinkFourthRow().click();
			Thread.sleep(12000);
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			    
			}

			// Perform the actions on new window
			//reporting
			if(driver.getWindowHandles().size() >1)
			 {
				TestBase.classAInstance.logReport("Pass","Outgoing rejection fax in hub portal","Succesfully able to  Verify Outgoing rejection fax in hub portal");
			 }
			 else
			 {
			    TestBase.classAInstance.logReport("Fail","Outgoing rejection fax in hub portal","Failed to  Verify  Claim Outgoing rejection fax in hub portal");
			 }
			String HubOutgoingRejectionFaxURL = driver.getCurrentUrl();
			String HubOutgoingRejectionURL = HubOutgoingRejectionFaxURL.substring(0, 146);
			
			
			
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(4000);

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore3);	
			
			Assert.assertEquals(OutgoingRejectionURL, HubOutgoingRejectionURL);
			
			
			hrp.HubReimbursementLogoutButton().click();
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
		
	}
	
	public boolean VerifyRejectionLetterContent(List<String> testData, String rejectReason, String portal) throws ParseException 
	{
		boolean verify = true;
		if(verify)
		{
			String expectedAddress = "PO Box 7613"+"\n"+ 
					"Overland Park, KS 66207"+"\n"+ 
					"Phone: 1-800-887-8100"+"\n"+ 
					"Fax: 1-844-257-6127";
			
			//For static content the bullet points that convert to ? after PDF read and the space associated with it are both removed
			String letterStaticContent = "We will be happy to reprocess the request if the claim is valid and all required information and materials are" + 
					"resubmitted to the following:" + 
					"Mail: ConnectiveRx" + 
					"Attn: AJOVY Cost Support Program" + 
					"PO Box 10664" + 
					"Fairfield, NJ 07004" + 
					"Fax: 1-866-642-9975" + 
					"Please see full Terms and Conditions at the end of this letter. If you have questions about the AJOVY Cost Support" + 
					"Program, or if there are any changes to your doctor, administering provider, insurance coverage, or contact information," + 
					"please call us at 1-800-887-8100. We are available Monday–Friday, 9 AM–7 PM ET." + 
					"Sincerely," + 
					"AJOVY Cost Support Program" + 
					"© November 2020 Teva Pharmaceuticals USA, Inc." + 
					"Patient Savings Program Terms and Conditions" + 
					"This Patient Savings Program for AJOVY® (fremanezumab-vfrm) injection (the “Program”) helps commercially" + 
					"insured patients in the United States (including the United States territories) who are administered AJOVY pay" + 
					"for their eligible out-of-pocket costs for the drug." + 
					"Eligible Patients must have commercial insurance coverage for AJOVY. Uninsured and cash-paying patients are" + 
					"NOT eligible for this Program nor are patients with commercial insurance coverage that does not provide" + 
					"formulary coverage for AJOVY." + 
					"Patients enrolled in any state or federally funded healthcare program, including but not limited to, Medicare," + 
					"Medicare Advantage Plans, Medicare Part D, Medicaid, Medigap, VA, DoD, TRICARE, and the Puerto Rico" + 
					"Government Health Insurance Plan are NOT eligible for this Program." + 
					"Patients who are Medicare eligible and enrolled in an employer-sponsored health plan or prescription drug" + 
					"benefit program for retirees (i.e., you are eligible for Medicare Part D but receive a prescription drug benefit" + 
					"through a former employer) are NOT eligible for this Program." + 
					"Patients who move from commercial to state or federally funded insurance will no longer be eligible for the" + 
					"Program." + 
					"Eligible Patients may pay as little as [$5] dollars on each fill. Maximum Program assistance per prescription and" + 
					"annual benefit limits apply. Each Eligible Patient is responsible for their out-of-pocket costs for AJOVY above the" + 
					"Program limits. Eligible Patients enrolled in the Program will be automatically enrolled in the Program for the" + 
					"next calendar year unless they opt out of the Program or their insurance coverage changes." + 
					"Eligible Patients must have an out-of-pocket cost for AJOVY and be administered the product prior to the" + 
					"expiration date of the Program. The benefit available under the Program is valid for the Eligible Patient’s out-of-" + 
					"pocket cost for the product only. It is not valid for any other out-of-pocket costs (for example, office visit" + 
					"charges or medication administration charges, evaluations or diagnostic testing) even if such costs are" + 
					"associated with the administration of AJOVY. Claims for AJOVY must be submitted by provider to the Eligible" + 
					"Patient’s private health insurance separately from other services and products." + 
					"An Eligible Patient must submit the Explanation of Benefits from their commercial insurance plan detailing their" + 
					"out-of-pocket costs for AJOVY within 180 days of insurance payment to receive payment from the Program." + 
					"The Program may apply to eligible out-of-pocket costs incurred by the patient for AJOVY within 120 days prior" + 
					"to the date an Eligible Patient is enrolled in the Program, subject to per prescription and annual Program" + 
					"maximum and the applicable Terms and Conditions based on AJOVY administration date. Patient or provider" + 
					"may contact [the AJOVY Patient Savings Program at 1-800-887-8100] for more information." + 
					"All coverage requirements mandated by the insurance company of the Eligible Patient must be satisfied in order" + 
					"for the Program to take effect. When submitting claims under this Program, Eligible Patients and their treating" + 
					"providers are certifying that they understand the Program rules, regulations and terms and conditions and" + 
					"comply with the Program terms as set forth herein. Specifically, you, as an Eligible Patient, are certifying that a" + 
					"claim has not been submitted under a state or federally funded healthcare program, including but not limited" + 
					"to, Medicare, Medicare Advantage Plans, Medicare Part D, Medicaid, Medigap, VA, DoD, TRICARE, and the" + 
					"Puerto Rico Government Health Insurance Plan." + 
					"All applicable information requested by the Program must be provided, and all certifications must be signed." + 
					"Any requests for Program assistance which do not contain all the necessary information will not be eligible for" + 
					"benefits under the Program." + 
					"The Program is not insurance." + 
					"Void if copied, transferred, purchased, altered or traded, and where prohibited and restricted by law. The" + 
					"Program is not transferable. No substitutions are permitted." + 
					"The Program form may not be sold, purchased, traded, or counterfeited. Void if reproduced." + 
					"The Program benefit cannot be combined with any other financial assistance program, free trial, discount," + 
					"prescription savings card, or other offer." + 
					"Data related to an Eligible Patient’s receipt of Program benefits may be collected, analyzed, and shared with" + 
					"© November 2020 Teva Pharmaceuticals USA, Inc." + 
					"Teva Pharmaceuticals USA, Inc. and its affiliates, for conducting data analytics, market research, and Program" + 
					"related business activities." + 
					"Teva Pharmaceuticals USA, Inc. and its affiliates reserves the right to make eligibility determinations, to set" + 
					"Program benefit maximums, to monitor participation, and to change, rescind, revoke, or discontinue this" + 
					"Program at any time without notice. Limit one Program enrollment per individual. If you have any questions" + 
					"regarding this Program, your eligibility or benefits or if you wish to discontinue your participation, call the AJOVY" + 
					"Patient Savings Program at [1-800-887-8100] (9:00am-7:00pm EST, Monday-Friday)." + 
					"These Terms and Conditions are valid for AJOVY administered between [January 7, 2021] and December 31," + 
					"2021." + 
					"Expiration Date: 12/31/2021";
			
			String expectedSubject = "Re: AJOVY Cost Support Program Claim Status";
			
			HashMap<String, String> rejections = new HashMap<String, String>();
			rejections = GetRejectionReason();
			
			String letterContent = "";
			String state = cf.GetResidingStateCode(testData.get(22));
			
			// Perform the actions on new window
			//reporting
			try
			{
				 letterContent = GetLetterContent(portal);
				 System.out.println("letter conent:"+letterContent);
			}
			catch(Exception e)
			{
				
			}
			
			letterContent = letterContent.replace("We will be happy to reprocess", "~We will be happy to reprocess");
			String[] mainContent = letterContent.split("~");
			
			for(int i=0; i<mainContent.length; i++)
			{
				System.out.println("Main content["+i+"]:"+mainContent[i]);
			}
			
			String beforeStaticConent = mainContent[0].replace("reason(s):", "reason(s):~");
			String[] dynamicContent = beforeStaticConent.split("~");
			
			String[] beforeReason = dynamicContent[0].split("\n");//dynamicContent[1] is the reason
			for(int i=0; i<beforeReason.length; i++)
			{
				System.out.println("Content["+i+"]:"+beforeReason[i]);
			}
			//client address
			String fullAddress = beforeReason[1].trim()+"\n"+beforeReason[2].trim()+"\n"+beforeReason[3].trim()+"\n"+beforeReason[4].trim();
			System.out.println("Full address:"+fullAddress);
			
			System.out.println("Expected address:"+expectedAddress);
			Assert.assertTrue(fullAddress.equalsIgnoreCase(expectedAddress));
			
			//patient full address
			Assert.assertTrue(beforeReason[5].trim().equalsIgnoreCase(testData.get(18)+" "+testData.get(19)));
			Assert.assertTrue(beforeReason[6].trim().equalsIgnoreCase(testData.get(20)));
			Assert.assertTrue(beforeReason[7].trim().equalsIgnoreCase(testData.get(21)+", "+state+", "+testData.get(23))); 
			
			//date and subject
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();

			DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    Date date1 = sdf1.parse(currentDate);
		    String formattedDate = new SimpleDateFormat("MMMMM d, yyyy").format(date1);
			
		    
		    
		    Assert.assertTrue(beforeReason[8].trim().equalsIgnoreCase(formattedDate));
		    Assert.assertTrue(beforeReason[9].trim().equalsIgnoreCase(expectedSubject));
			
			//salutation
			String salutation = "Dear "+testData.get(18)+" "+testData.get(19);
			System.out.println("Salutation:"+salutation);
			Assert.assertTrue(beforeReason[10].trim().equalsIgnoreCase(salutation));
			
			//Thank you message
			DateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date2 = sdf2.parse(testData.get(12));
		    String formattedDOS = new SimpleDateFormat("yyyy-MM-dd").format(date1);

			String expectedThankYou = "Thank you for participating in the AJOVY Cost Support Program. We have received and reviewed the AJOVY Cost Support Program claim Date of Service 2020-12-12 submitted on your behalf. Unfortunately, we are unable to process " + 
					"the claim for the following reason(s):";
			System.out.println("Expected thank you:"+expectedThankYou.trim()+"jkjkj");
			
			String actualThankYou = beforeReason[11].trim()+" "+beforeReason[12].trim()+" "+beforeReason[13].trim();
			System.out.println("actual thank you:"+actualThankYou.trim()+"ooooooo");
			System.out.println("Test");
			Assert.assertTrue(actualThankYou.contains(expectedThankYou));
			
			System.out.println("content 12:"+dynamicContent[1]);
			System.out.println("rejection reason:"+rejections.get(rejectReason));
			Assert.assertTrue(dynamicContent[1].trim().contains(rejections.get(rejectReason)));
			
			//verify rest of the static content
			 String[] mainSplit = mainContent[1].split("\n");
			    
			    for(int i=0;i<mainSplit.length;i++)
			    {
			    	System.out.println("mainsplit:"+i+":"+mainSplit[i]);
			    }
			    
			    char[] character = mainSplit[69].substring(0, 1).toCharArray();//getting the ? special char that is converted to this from being a bullet point in the PDF
			    
			    System.out.println("Char0:"+character[0]);
			    int ascii = (int) character[0];
			    System.out.println("ascii:"+ascii);
			    
			    String str = Character.toString((char)ascii);
			    System.out.println("Str:"+str);
			    
			    
			    
				
			    String mainContentReplace = mainContent[1].replaceAll(str, "");
			    
			    System.out.println("Main content replace:"+mainContentReplace);
			    String[] staticContent = mainContentReplace.split("\n");
			    String fullStaticContent = "";
			    for(int i=0; i< staticContent.length;i++)
			    {
			    	System.out.println("main split: "+i+":"+staticContent[i].trim());
			    	
			    	 fullStaticContent = fullStaticContent+staticContent[i].trim();
			    	 
			    }
		
			    System.out.println("content1:"+fullStaticContent+"yyyy");
				System.out.println("content2:"+letterStaticContent+"yyyy");
			
				Assert.assertTrue(fullStaticContent.equalsIgnoreCase(letterStaticContent)); 
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
	}
	
	public String GetLetterContent(String portal) throws InterruptedException, IOException
	{
		//now click on the enrollment letter and capture the url
		String winHandleBefore1 = driver.getWindowHandle();
		
		if(portal.equalsIgnoreCase("Admin"))
		{
			// Perform the click operation that opens new window
			SubjectColLatestRow().click();
			Thread.sleep(12000);
		}
		else if(portal.equalsIgnoreCase("Hub"))
		{
			// Perform the click operation that opens new window
			lcc.LettersTableSubjectLetterLinkLatestRow().click();
			Thread.sleep(12000);			
		}
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    
		}
		
		String url = driver.getCurrentUrl();
		String filename = url.substring(105, 145);
		URL link = new URL(url);
		System.out.println("Filename:"+filename);
		
// Read the content of the letter and create a file with the content copies to it
		InputStream in = link.openStream();
		FileOutputStream fos = new FileOutputStream(new File(filename));

		System.out.println("reading from resource and writing to file...");
		int length = -1;
		byte[] buffer = new byte[1024];// buffer for portion of data from connection
		while ((length = in.read(buffer)) > -1) {
		    fos.write(buffer, 0, length);
		}
		fos.close();
		in.close();
		System.out.println("File downloaded");
		System.out.println("Download complete");
		
		// Close the new window, if that window no more required
		driver.close();
		Thread.sleep(4000);

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);	

		
	
		//Loading an existing document
	     File file = new File("C:\\Users\\bhanu.bangalore\\Documents\\Automation\\Teva Ajovy\\Teva-Ajovy\\"+filename);
	      PDDocument document = PDDocument.load(file);
	      //Instantiate PDFTextStripper class
	      PDFTextStripper pdfStripper = new PDFTextStripper();
	      //Retrieving text from PDF document
	      String text = pdfStripper.getText(document);
	      System.out.println(text);
	      //Closing the document
	      document.close();
	      
	      return text;
	}
	
	

}
