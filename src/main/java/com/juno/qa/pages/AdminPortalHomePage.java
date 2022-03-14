package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortalHomePage extends TestBase {
	
	public AdminPortalHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProgramTypeDropdown()
	{
		Select programs = new Select(driver.findElement(By.name("programs")));
		return programs;
	}
	
	public WebElement CardActivities() //updated for express 2.0 Provider
	{
		return driver.findElement(By.linkText("Card Activities"));
	}
	
	public WebElement FSVTransHistory()  //updated for express 2.0 Search Provider
	{
		return driver.findElement(By.linkText("FSV Trans History"));
	}
	public WebElement Providers() //updated for express 2.0 Provider
	{
		return driver.findElement(By.linkText("Providers"));
	}
	public WebElement SearchProvider()  //updated for express 2.0 Search Provider
	{
		return driver.findElement(By.linkText("Search Provider"));
	}
	public WebElement EnrollNewProvider()  //updated for express 2.0 Enroll a Provider
	{
		return driver.findElement(By.linkText("Enroll New Provider"));
	}
	
	
	public WebElement PatientsLink() //updated for express 2.0
	{
		return driver.findElement(By.linkText("Patients"));
	}
	
	public WebElement PatientSearch()//updated for express 2.0
	{
		return driver.findElement(By.linkText("Search Patient"));
		
	}
	
	public WebElement ProvidersLink()
	{
		return driver.findElement(By.linkText("Providers"));
	}
	
	public WebElement ProviderGroupsLink()
	{
		return driver.findElement(By.linkText("Provider Groups"));
	}
	
	public WebElement PaymentsLink()
	{
		return driver.findElement(By.linkText("Payments"));
	}
	
	public WebElement FaxesLink()
	{
		return driver.findElement(By.linkText("Faxes"));
	}
	
	public WebElement LinksLink()
	{
		return driver.findElement(By.linkText("Links"));
	}
	
	public WebElement AdminOnlyLink()
	{
		return driver.findElement(By.linkText("Admin Only"));
	}
	
	public WebElement IncomingFaxesLink()
	{
		return driver.findElement(By.linkText("Incoming"));
	}
		
	public WebElement IncomingFaxesHeaderName()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Select Fax Report Criteria')]"));
	}
	
	public WebElement IncomingFaxesCardNumber()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	

	public Select IncomingFaxesUser()
	{
		Select user = new Select(driver.findElement(By.name("assigned_user")));
		return user;
	}

	
	public WebElement IncomingFaxesFindButton()
	{
		return driver.findElement(By.name("find"));
	}
	public WebElement IncomingFaxesClone()
	{
		return driver.findElement(By.xpath("//*[@id=\"dtcol_7\"]/form[2]/input[12]"));
		//return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[10]/form[2]/input[14]"));
	}
	
	public WebElement IncomingFaxesCloneAssign()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[14]/form[1]/input[10]"));
	}
	
	
	//*[@id="reportTable"]/tbody/tr/td[10]/form[2]/input[14]
	public WebElement IncomingFaxesReview()
	{
		return driver.findElement(By.className("button_empty"));
	}
	
	public Select FaxType()
	{
		Select FaxType = new Select(driver.findElement(By.id("fax_type")));
		return FaxType;
	}
	public Select FaxStatus()
	{
		Select FaxStatus = new Select(driver.findElement(By.id("fax_status")));
		return FaxStatus;
	}
	public Select EOBStatus()
	{
		Select EOBStatus = new Select(driver.findElement(By.id("eob_status")));
		return EOBStatus;
	}
	public WebElement UploadEOBUpdateButton()
	{
		return driver.findElement(By.name("update"));
	}
	public WebElement UploadEOBProcessEOB()
	{
		return driver.findElement(By.id("goedit"));
	}
	public int SidePanelLinksCount()
	{
		List <WebElement> linksList = driver.findElements(By.xpath("//*[@id='acc3']/li"));
		return linksList.size();
	}
	
	public WebElement AdminPortalDrugReimbursementHomePageHeader()
	{
		return driver.findElement(By.xpath("//div[@style = 'background: url(https://wb-admin-qa.crxcopay.com/images/logo_juno_2.png);background-repeat: no-repeat;']"));
		
	}
	
	public WebElement AdminPortalAdminReimbursementHomePageHeader()
	{
		return driver.findElement(By.xpath("//div[@style = 'background: url(https://wb-admin-qa.crxcopay.com/images/logo_juno_1.png);background-repeat: no-repeat;']"));
	}
	
	public WebElement AdminPortalWelcomeMessage()
	{
		return driver.findElement(By.id("form-table"));
	}
	
	public WebElement AdminPortalConnectiverxHeaderImage()
	{
		return driver.findElement(By.id("logoDropDownClick"));
	}
	
	public WebElement AdminPortalConnectiverxFooterImage()
	{
		return driver.findElement(By.xpath("//*[@id='copyright']/span/img"));
	}
	
	public WebElement AdminPortalHelpdeskMessage()
	{
		//return driver.findElement(By.xpath("//*[@id='copyright']/span/text()[1]"));
		return driver.findElement(By.xpath("//div[contains(@id,'copyright') and contains(.,'This site is for ConnectiveRx BuyandBill helpdesk Users Only.')]"));
	}
	
	public WebElement AdminPortalRightsReservedMessage()
	{
		//return driver.findElement(By.xpath("//*[@id='copyright']/span/text()[2]"));
		return driver.findElement(By.xpath("//div[contains(@id,'copyright') and contains(., '© 2021 ConnectiveRx. All Rights Reserved. CRX-2021_V1.')]"));
	}
	
	public WebElement ActiveLink()
	{
		return driver.findElement(By.linkText("Active"));
	}
	
	public WebElement DuplicateLink()
	{
		return driver.findElement(By.linkText("Duplicate"));
	}
	
	public WebElement ExpiredEnrollmentsLink()
	{
		return driver.findElement(By.linkText("Expired Enrollments"));
	}
	
	public WebElement InactiveLink()
	{
		return driver.findElement(By.linkText("Inactive"));
	}
	public WebElement NewLink() //updated for Express 2.0 for Enroll new patient 
	{
		return driver.findElement(By.linkText("Enroll New Patient"));
	}
	public WebElement EnrollmentClickHere() //updated for Express 2.0 for Enroll new patient 
	{
		return driver.findElement(By.xpath("//*[@id='patient_links']/input[1]"));
	}
	
	public WebElement FindLink() //updated for Express 2.0 for search patient
	{
		return driver.findElement(By.linkText("Search Patient"));
	}
	
	public WebElement RepaymentNewLink() //updated for Express 2.0 for Repayment-NewLink 
	{
		return driver.findElement(By.linkText("New"));
	}
	
	
	
	public WebElement PhysicianLink()
	{
		return driver.findElement(By.linkText("Physician"));
	}
	
/*	public WebElement PendingLink()
	{
		return driver.findElement(By.linkText("Pending"));
	}*/
	
    public WebElement GroupPracticeLink()
	{
		return driver.findElement(By.linkText("Group Practice"));
	}
    
    public WebElement ListLink()
   	{
   		return driver.findElement(By.linkText("List"));
   	}
  //*[@id="current"]/a
  //*[@id="checkfind"]/table/tbody/tr[11]/td/input
    
    public WebElement ListLinkFindButton()
   	{
   		return driver.findElement(By.name("find"));
   	}
  //*[@id="eft_find"]/table/tbody/tr[3]/td/input[1]
    public WebElement RepaymentAddButton()
   	{
   		return driver.findElement(By.name("add_update"));
   	}
    
    
    public WebElement SupervisorsLink()
   	{
   		return driver.findElement(By.linkText("Supervisors"));
   	}
   
    public WebElement  BillingOfficeLink()
   	{
   		return driver.findElement(By.linkText("Billing Office"));
   	}
    
    public WebElement  ChecksLink()
   	{
   		return driver.findElement(By.linkText("Checks"));
   	}
   
    public WebElement  RepaymentsLink()
   	{
   		return driver.findElement(By.linkText("Re-Payments"));
   	}
    
    public WebElement  EFTLink()
   	{
   		return driver.findElement(By.linkText("EFTs"));
   	}
    
    public WebElement OutgoingFaxLink()
    {
    	return driver.findElement(By.linkText("OutGoing"));
    }
    
    public WebElement ListAllLink()
    {
    	return driver.findElement(By.linkText("List All"));
    }
    
    public WebElement AssignmentsLink()
    {
    	return driver.findElement(By.linkText("Assignments"));
    }
    
    public WebElement AssignmentRulesLink()
    {
    	return driver.findElement(By.linkText("Assignment Rules"));
    }
    public WebElement AssignmentRulesLinkAddButton()
    {
    	return driver.findElement(By.name("find"));
    }
    public WebElement PortalsLink()
    {
    	return driver.findElement(By.linkText("Portals"));
    }
    
    public WebElement HelpDeskLink()
    {
    	return driver.findElement(By.linkText("Help Desk"));
    }
    public WebElement SearchHelpDeskUser()
    {
    	return driver.findElement(By.linkText("Search Helpdesk Users"));
    }
    public WebElement SearchHelpDeskUserFindButton()
    {
    	return driver.findElement(By.name("find"));
    }
    public WebElement NewHelpdeskUser()
    {
    	return driver.findElement(By.linkText("New Helpdesk User"));
    }
    public WebElement NewHelpdeskUserAddButton()
    {
    	return driver.findElement(By.name("add_update"));
    }
    public WebElement SettingsLink()
    {
    	return driver.findElement(By.linkText("Settings"));
    }
    
    public WebElement AdminListLink()
    {
    	return driver.findElement(By.linkText("Admin list"));
    }
    
    public WebElement CompanyAdminListLink()
    {
    	return driver.findElement(By.linkText("Company Admin list"));
    }
    
    public WebElement ProgramAdminListLink()
    {
    	return driver.findElement(By.linkText("Program Admin list"));
    }
    
    public WebElement HelpDeskRestrictedListLink()
    {
    	return driver.findElement(By.linkText("Help Desk Restricted list"));
    }
    
    public WebElement ProgramLink()
    {
    	return driver.findElement(By.linkText("Program"));
    }
    
    public String GetCurrentURL()
    {
    	return driver.getCurrentUrl();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
