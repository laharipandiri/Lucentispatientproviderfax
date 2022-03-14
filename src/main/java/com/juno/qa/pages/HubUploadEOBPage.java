package com.juno.qa.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class HubUploadEOBPage extends TestBase {
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();
	
	HubHomeLoginLogoutPage hll = new HubHomeLoginLogoutPage();
	HubHomePage hhp = new HubHomePage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubFindAllCopayProgramPatientPage fcp = new HubFindAllCopayProgramPatientPage();
	HubPortal_ListAllCopayProgramPatientPage lcp = new HubPortal_ListAllCopayProgramPatientPage();

	public HubUploadEOBPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement UploadEOBFileButton()
	{
		return driver.findElement(By.id("userfile"));
	}
	
	public WebElement UploadEOBPatientFirstname()
	{
		return driver.findElement(By.id("first_name"));
	}
	
	public WebElement UploadEOBPatientLastname()
	{
		return driver.findElement(By.id("last_name"));
	}
	
	public WebElement UploadEOBMemberID()
	{
		return driver.findElement(By.id("other_id"));
	}
	
	public WebElement UploadEOBFaxBackNumber()
	{
		return driver.findElement(By.id("fax_number"));
	}
	
	public WebElement UploadEOBRetypeFaxBackNumber()
	{
		return driver.findElement(By.id("re_fax_number"));
	}
	
	public WebElement UploadEOBRadioEOBButton()
	{
		return driver.findElement(By.cssSelector("input[value = 'EOB']"));
	}
	
	public WebElement UploadInsuranceCardRadioButton()
	{
		return driver.findElement(By.cssSelector("input[value = 'insurance']"));
	}
	
	public WebElement UploadOtherRadioButton()
	{
		return driver.findElement(By.cssSelector("input[value = 'other']"));
	}
	
	public WebElement UploadEOBSubmitButton()
	{
		return driver.findElement(By.name("Submit"));
	}
	
	public String UploadEOBConfirmationMessage()
	{
		return driver.findElement(By.xpath("//article[@class='content enrollNewPatient']//font[@color='green']")).getText();
	}
	
	
	
	public static File GetFilepath() {

        File dir = new File(System.getProperty("user.dir") + "\\EOB_Files");

        File[] files = dir.listFiles();

        Random randomFile = new Random();

        File file = files[randomFile.nextInt(files.length)];

        System.out.println(file);

        return file;

    }
	
	public boolean UploadEOB(String firstname, String lastname, String memberID, String ReimbursementType) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				}
			 String FAXDocument = GetFilepath().getPath();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				 
				//Login to the hub portal
				hll.HubPortalLogin();
				
				wait.until(ExpectedConditions.visibilityOf(hll.UserMenuButton()));
				//Thread.sleep(3000);
				
				
				//click on Upload EOB button on the left panel
				hrp.UploadEOBButton().click();
				Thread.sleep(1000);
				
				//click on EOB radio button
				UploadEOBRadioEOBButton().click();
			//	Thread.sleep(2000);
				
				//click on file upload button and select file
				UploadEOBFileButton().sendKeys(FAXDocument);
				System.out.println("File has been uploaded");
				
				UploadEOBPatientFirstname().sendKeys(firstname);
				UploadEOBPatientLastname().sendKeys(lastname);
				UploadEOBMemberID().sendKeys(memberID);				
					
				
				
				Thread.sleep(2000);
				
				UploadEOBSubmitButton().click();
				Thread.sleep(2000);
			
				Assert.assertEquals("Patient File Uploaded", UploadEOBConfirmationMessage());
				
				hrp.HubReimbursementLogoutButton().click();
				
				driver.quit();
				
				return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean UploadInsuranceCard(String firstname, String lastname, String memberID, String faxNum, String ReimbursementType, String Page) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				}
			 String FAXDocument = GetFilepath().getPath();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				 
				//Login to the hub portal
				hll.HubPortalLogin();
				
				wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
				//Thread.sleep(3000);
			
				
				if(Page.equalsIgnoreCase("FindAllCopayProgramPatients"))
				{
					hrp.FindCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					fcp.MemberId().sendKeys(memberID);
					fcp.FindButton().click();
					Thread.sleep(3000);
					fcp.UploadFileLink().click();
					Thread.sleep(5000);
					UploadInsuranceCardRadioButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
					
				}
				else if(Page.equalsIgnoreCase("ListAllCopayProgramPatients"))
				{
					hrp.ListAllCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					lcp.MemberIDSearchField().sendKeys(memberID);
					Thread.sleep(2000);
					lcp.ActionColUploadFileLink().click();
					Thread.sleep(2000);
					UploadInsuranceCardRadioButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
				}
				else if(Page.equalsIgnoreCase("UploadEOB"))
				{
				//click on Upload EOB button on the left panel
				hrp.UploadEOBButton().click();
				Thread.sleep(1000);
				
				//click on Upload Insurance radio button
				UploadInsuranceCardRadioButton().click();
			//	Thread.sleep(2000);
				
				//click on file upload button and select file
				UploadEOBFileButton().sendKeys(FAXDocument);
				System.out.println("File has been uploaded");
				
				UploadEOBPatientFirstname().sendKeys(firstname);
				UploadEOBPatientLastname().sendKeys(lastname);
				UploadEOBMemberID().sendKeys(memberID);				
					
			
				UploadEOBFaxBackNumber().sendKeys(faxNum);
				UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
			
				
				Thread.sleep(2000);
				
				UploadEOBSubmitButton().click();
				Thread.sleep(2000);
				}
			
				Assert.assertEquals("Patient File Uploaded", UploadEOBConfirmationMessage());
				
				hrp.HubReimbursementLogoutButton().click();
				
				driver.quit();
				
				return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean UploadOtherFile(String firstname, String lastname, String memberID, String faxNum, String ReimbursementType, String Page) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				}
			 String FAXDocument = GetFilepath().getPath();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				 
				//Login to the hub portal
				hll.HubPortalLogin();
				
				wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
				//Thread.sleep(3000);
			
				
				if(Page.equalsIgnoreCase("FindAllCopayProgramPatients"))
				{
					hrp.FindCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					fcp.MemberId().sendKeys(memberID);
					fcp.FindButton().click();
					Thread.sleep(3000);
					fcp.UploadFileLink().click();
					Thread.sleep(5000);
					UploadOtherRadioButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
					
				}
				else if(Page.equalsIgnoreCase("ListAllCopayProgramPatients"))
				{
					hrp.ListAllCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					lcp.MemberIDSearchField().sendKeys(memberID);
					Thread.sleep(2000);
					lcp.ActionColUploadFileLink().click();
					Thread.sleep(2000);
					UploadOtherRadioButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
				}
				else if(Page.equalsIgnoreCase("UploadEOB"))
				{
				//click on Upload EOB button on the left panel
				hrp.UploadEOBButton().click();
				Thread.sleep(1000);
				
				//click on Upload other radio button
				UploadOtherRadioButton().click();
			//	Thread.sleep(2000);
				
				//click on file upload button and select file
				UploadEOBFileButton().sendKeys(FAXDocument);
				System.out.println("File has been uploaded");
				
				UploadEOBPatientFirstname().sendKeys(firstname);
				UploadEOBPatientLastname().sendKeys(lastname);
				UploadEOBMemberID().sendKeys(memberID);				
					
			
				UploadEOBFaxBackNumber().sendKeys(faxNum);
				UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
			
				
				Thread.sleep(2000);
				
				UploadEOBSubmitButton().click();
				Thread.sleep(2000);
				}
			
				Assert.assertEquals("Patient File Uploaded", UploadEOBConfirmationMessage());
				
				hrp.HubReimbursementLogoutButton().click();
				
				driver.quit();
				
				return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean UploadEOBFax(String firstname, String lastname, String memberID, String faxNum, String ReimbursementType, String Page) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				}
			 String FAXDocument = GetFilepath().getPath();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				 
				//Login to the hub portal
				hll.HubPortalLogin();
				
				wait.until(ExpectedConditions.visibilityOf(hll.HubHomePageLogoutButton()));
				//Thread.sleep(3000);
				
				if(Page.equalsIgnoreCase("FindAllCopayProgramPatients"))
				{
					hrp.FindCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					fcp.MemberId().sendKeys(memberID);
					fcp.FindButton().click();
					Thread.sleep(3000);
					fcp.UploadFileLink().click();
					Thread.sleep(5000);
					UploadEOBRadioEOBButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
					
				}
				else if(Page.equalsIgnoreCase("ListAllCopayProgramPatients"))
				{
					hrp.ListAllCopayProgramPatientsButton().click();
					Thread.sleep(2000);
					lcp.MemberIDSearchField().sendKeys(memberID);
					Thread.sleep(2000);
					lcp.ActionColUploadFileLink().click();
					Thread.sleep(2000);
					UploadEOBRadioEOBButton().click();
					//	Thread.sleep(2000);
						
						//click on file upload button and select file
						UploadEOBFileButton().sendKeys(FAXDocument);
						System.out.println("File has been uploaded");
						
					UploadEOBFaxBackNumber().sendKeys(faxNum);
					UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
					Thread.sleep(2000);
					UploadEOBSubmitButton().click();
					Thread.sleep(2000);
				}
				else if(Page.equalsIgnoreCase("UploadEOB"))
				{
				//click on Upload EOB button on the left panel
				hrp.UploadEOBButton().click();
				Thread.sleep(1000);
				
				//click on Upload Insurance radio button
				UploadEOBRadioEOBButton().click();
			//	Thread.sleep(2000);
				
				//click on file upload button and select file
				UploadEOBFileButton().sendKeys(FAXDocument);
				System.out.println("File has been uploaded");
				
				UploadEOBPatientFirstname().sendKeys(firstname);
				UploadEOBPatientLastname().sendKeys(lastname);
				UploadEOBMemberID().sendKeys(memberID);				
					
			
				UploadEOBFaxBackNumber().sendKeys(faxNum);
				UploadEOBRetypeFaxBackNumber().sendKeys(faxNum);
			
				
				Thread.sleep(2000);
				
				UploadEOBSubmitButton().click();
				Thread.sleep(2000);
				}
			
				Assert.assertEquals("Patient File Uploaded", UploadEOBConfirmationMessage());
				
				hrp.HubReimbursementLogoutButton().click();
				
				driver.quit();
				
				return verify;
		}
		
		verify = false;
		return verify;
	}
}
