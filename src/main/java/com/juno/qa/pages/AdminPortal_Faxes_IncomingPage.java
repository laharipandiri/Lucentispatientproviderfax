package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_Faxes_IncomingPage extends TestBase {
	
	AdminPortal_Patients_PatientAndCardTabPage apc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Faxes_IncomingFindPage aif = new AdminPortal_Faxes_IncomingFindPage();
	
	public AdminPortal_Faxes_IncomingPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Fax information section */
	
	public WebElement FaxInformationLabel()
	{
		return driver.findElement(By.xpath("//*[@id='faxedit']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/th/strong"));
	}
	
	public Select ProgramDropdown()
	{
		Select programList = new Select(driver.findElement(By.id("program")));
		return programList;
	}
	
	public WebElement FaxIDField()
	{
		return driver.findElement(By.id("fax_id"));
	}
	
	public WebElement ANIField()
	{
		return driver.findElement(By.name("ani"));
	}
	
	public WebElement AmountField()
	{
		return driver.findElement(By.name("amount"));
	}
	
	public WebElement ReceivedDateField()
	{
		return driver.findElement(By.name("ani"));
	}
	
	public WebElement ReviewedDateField()
	{
		return driver.findElement(By.name("amount"));
	}
	
	public WebElement ApprovedDateField()
	{
		return driver.findElement(By.name("ani"));
	}
	
	public WebElement ServiceDateField()
	{
		return driver.findElement(By.name("amount"));
	}
	
	
	public Select FaxType()
	{
		Select faxType = new Select(driver.findElement(By.id("fax_type")));
		return faxType;
	}
	
	public Select FaxStatus()
	{
		Select faxStatus = new Select(driver.findElement(By.id("fax_status")));
		return faxStatus;
	}
	
	public Select EOBStatus() 
	{
		Select eobStatus = new Select(driver.findElement(By.id("eob_status")));
		return eobStatus;
	}
	
	public WebElement InsuranceCompanyField()
	{
		return driver.findElement(By.name("insurance_company"));
	}
	
	public WebElement PatientTreatmentIDField()
	{
		return driver.findElement(By.name("patient_treatment_id"));
	}
	
	/* Patient information section*/
	
	public WebElement PatientInformationLabel()
	{
		return driver.findElement(By.xpath("//*[@id='faxedit']/div/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/th/strong"));
	}
	
	public WebElement IncomingFaxMemberID()
	{
		return driver.findElement(By.name("patient_other_id"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.name("patient_referral_code"));
	}
	
	public WebElement IncomingFaxCardID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement ConfirmationRegistrationID()
	{
		return driver.findElement(By.name("patient_id"));
	}
	
	public WebElement FaxPatientFirstName()
	{
		return driver.findElement(By.name("patient_first_name"));
	}
	
	public WebElement FaxPatientLastName()
	{
		return driver.findElement(By.name("patient_last_name"));
	}
	
	public Select PatientResidingState() 
	{
		Select statesList = new Select(driver.findElement(By.id("patient_state")));
		return statesList;
	}
	
	public WebElement ReenrolledCheckBox()
	{
		return driver.findElement(By.id("patient_reenroll"));
	}
	
	public WebElement CurrentBenefitsPeriod()
	{
		return driver.findElement(By.id("patient_current_benefits_period"));
	}
	
	public WebElement RenerollmentDate()
	{
		return driver.findElement(By.id("patient_reenroll_date"));
	}
	
	public WebElement ClaimsDeadline()
	{
		return driver.findElement(By.id("claim_sub_deadline_date"));
	}
	
	public WebElement CurrentbenefitRetroPeriodDate()
	{
		return driver.findElement(By.name("patient_grace_date"));
	}
	
	public WebElement PatientSearchAutoSuggest()
	{
		return driver.findElement(By.id("patient_search"));
	}
	
	/* Provider Information */
	
	public WebElement ProviderInformationLabel()
	{
		return driver.findElement(By.xpath("//*[@id=\"faxedit\"]/div/table/tbody/tr[1]/td[2]/table/tbody/tr[17]/th/strong"));
	}
	
	public WebElement ProviderName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement ProviderContactLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement ProviderContactFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement ProviderAddress()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement ProviderAddressTwo()
	{
		return driver.findElement(By.id("provider_address_2"));
	}
	
	public WebElement ProviderCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public Select ProviderResidingState() 
	{
		Select statesList = new Select(driver.findElement(By.id("provider_state")));
		return statesList;
	}
	
	public WebElement ProviderZip()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement ProviderPhone()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement ProviderNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public WebElement ProviderFaxNumber()
	{
		return driver.findElement(By.id("fax_back_number"));
	}
	
	public WebElement ProviderNotesTextArea()
	{
		return driver.findElement(By.name("notes"));
	}
	
	
	public WebElement UpdateButton()
	{
		return driver.findElement(By.name("update"));
	}
	
	public WebElement CancelButton()
	{
		return driver.findElement(By.name("gobackcancel"));
	}
	
	public WebElement GoBackButton()
	{
		return driver.findElement(By.name("gobacklist"));
	}
	
	public WebElement ProcessEOBButton()
	{
		//return driver.findElement(By.className("button_go_edit"));// updated for Lucentis
		return driver.findElement(By.xpath("//*[@id='goedit']"));
		
	}
	
	public void GetAllFaxTypesReviewList(String EnrollFromDate, String FindPageFaxStatus)
	{
		String[] EnrollDate = EnrollFromDate.split("-");
        String YOD = EnrollDate[2];
        String MOD = EnrollDate[1];
        String DOD = EnrollDate[0];

        System.out.println(MOD);
        System.out.println(DOD);
        
        aif.EnrollFromDate().click();  
        
        System.out.println("after clicking enroll from date field");
        
        char[] dateDigits = DOD.toCharArray();
        if(dateDigits[0] == 0)
        {
        	String SingleDOD = apc.UpdateDateInDOBToOneDigit(dateDigits);
        	System.out.println("Single digit DOD: "+SingleDOD);
        	try {
        	apc.SelectDate(YOD, MOD, SingleDOD);
        	}
        	catch(InterruptedException e)
        	{
        		
        	}
        }
        else
        {
        	try {
        		apc.SelectDate(YOD, MOD, DOD);
        	}
        	catch(InterruptedException e)
        	{
        		
        	}
        }
        
        //change the fax status to all. By default its in pending and this might not show results some times
        FaxStatus().selectByVisibleText(FindPageFaxStatus);
    
		aif.FaxesPageFindButton().click();
		  
	}
	
	

	
}
