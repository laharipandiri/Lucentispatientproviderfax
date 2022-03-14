package com.juno.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;


public class PatientPage extends TestBase  {
	
	public PatientPage() {
		PageFactory.initElements(driver, this);
	}
//***************************************************************************************	
	public WebElement PatientsLink()
	{
		return driver.findElement(By.linkText("Patients"));
	}
	public WebElement SearchLink()
	{
		return driver.findElement(By.linkText("Patients"));
	}

	public WebElement SearchPatient()  //updated for express 2.0
	{
		return driver.findElement(By.linkText("Search Patient"));
	}
	
	public WebElement PatientSearch()
	{
		return driver.findElement(By.name("patient_list_button_find"));
	}

	//************************************Search patient*******************************************
	public WebElement PatientSearchLastName() //Search Patient-Last name field
	{
		return driver.findElement(By.name("last_name"));
	}
	
	/*
	@FindBy(xpath = "patient_other_id")
	public WebElement PatientSearchMemberID;

	public WebElement PatientSearchMemberID() {
		// TODO Auto-generated method stub
		return PatientSearchMemberID;
	}
		*/
	public WebElement PatientSearchMemberID() //Search Patient-Member ID field
	{
		//return driver.findElement(By.name("patient_other_id")); updated on 8/29/2021
		return driver.findElement(By.name("patient_list_button_find"));
		
	}

	public WebElement PatientSearchPartnerPatientID() //Search Patient-Partner Patient ID field
	{
		return driver.findElement(By.name("patient_referral_code"));
	}
	
	public WebElement PatientSearchShortCardID() //Search Patient-Short Card ID field
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	public WebElement PatientConfirmationNo() //Search Patient-Short Card ID field
	{
		return driver.findElement(By.name("patient_confirmation_id"));
	}
	
	
	public WebElement PatientSearchCity() //Search Patient-City field
	{
		return driver.findElement(By.name("city"));
	}
	
	public WebElement PatientSearchEnrollMaxDate() //Search Patient-Enroll Max Date field
	{
		return driver.findElement(By.name("enroll_max_date"));
	}
	
	
	public WebElement PatientSearchConfirmationID() //Search Patient-Confirmation ID field
	{
		return driver.findElement(By.name("patient_id"));
	}
	
	public WebElement PatientSearchEnrollmentGuid() //Search Patient-Enrollment Guid field
	{
		return driver.findElement(By.name("enrollmnet_guid"));
	}
	
	public WebElement PatientSearchPatientuid() //Search Patient-Patient uid field
	{
		return driver.findElement(By.name("patient_uid"));
	}
	
	public WebElement PatientSearchPatientStatus() //Search Patient-Patient Status field
	{
		return driver.findElement(By.name("status_id"));
	}
	
	public WebElement PatientSearchEnrollmentDateFrom() //Search Patient-enrollment date from field
	{
		return driver.findElement(By.name("enroll_min_date"));
	}
	
	//************************************Sorting*****************************************************
	
	public WebElement PatientSearchLastNameSorting() //Sorting Last name in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[1]"));
		
	}
	
	public WebElement PatientSearchFirstNameSorting() //Sorting First name in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[2]"));
		
	}
	public WebElement PatientSearchProgramNameSorting() //Sorting Program name in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[3]"));
		
	}
	public WebElement PatientSearchShortCardIDSorting() //Sorting ShortCardID in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[4]"));
		
	}
	
	public WebElement PatientSearchMemberIDSorting() //Sorting MemberID in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[5]"));
		
	}
	
	public WebElement PatientSearchActivationDateSorting() //Sorting ActivationDate in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[5]"));
		
	}
	
	public WebElement PatientSearchStatusSorting() //Sorting Status in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[6]"));
	}
	
	public WebElement PatientSearchContactSorting() //Sorting Contact in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[7]"));
	}
	public WebElement PatientSearchPartnerPatientIDSorting() //Sorting PartnerPatientID in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[8]"));
	}
	
	public WebElement PatientSearchProviderNameSorting() //Sorting ProviderName in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[9]"));
	}
	public WebElement PatientSearchProviderTypeSorting() //Sorting ProviderType in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[10]"));
	}
	public WebElement PatientSearchConfirmationNoSorting() //Sorting ConfirmationNo in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[11]"));
	}
	public WebElement PatientSearchActionSorting() //Sorting Action in Search patient screen
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/thead/tr/th[12]"));
	}
	public Select PatientSearchPagination()
	{
		Select Pagination = new Select(driver.findElement(By.xpath("//*[@id='patients-list_length']/label/select")));
		return Pagination;
	}
	public WebElement Loading()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Loading. Please wait...')]"));
	}
	
	
	
	public WebElement PatientReview()
	{
		return driver.findElement(By.name("Review"));
	}
	
	public WebElement PatientAndCardTab()
	{
		return driver.findElement(By.linkText("Patient & Card"));
	} 
	
	
	public Select PatientStatus()
	{
		Select PatientStatus = new Select(driver.findElement(By.id("patient_status")));
		return PatientStatus;
	}
	public Select NewPatientStatus()
	{
		Select PatientStatusALL = new Select(driver.findElement(By.id("status_id")));
		return PatientStatusALL;
	}
	public WebElement InsuranceReprocessTab()
	{
		return driver.findElement(By.linkText("Insurance & Reprocess"));
	} 
	public WebElement RefreshDataLink()
	{
		return driver.findElement(By.id("RefreshData"));
	}
	
	public WebElement PatientAndCardTabTitle()
	{
		return driver.findElement(By.name("patient_name_title"));
	}
	
	public WebElement PatientFirstName()
	{
		return driver.findElement(By.name("corp_api_field[patient][firstName]"));
	}
	public WebElement PatientLastName()
	{
		return driver.findElement(By.name("corp_api_field[patient][lastName]"));
	}
	
	public WebElement PatientAddress()
	{
		return driver.findElement(By.name("corp_api_field[patient][address1]"));
	}
	
	public WebElement PatientAddress2()
	{
		return driver.findElement(By.name("corp_api_field[patient][address2]"));
	}
	
	public WebElement PatientCity()
	{
		return driver.findElement(By.name("corp_api_field[patient][city]"));
	}
	
	public Select PatientState()
	{
		Select statesList = new Select(driver.findElement(By.name("corp_api_field[patient][state]")));
		return statesList;
	}
	
	public WebElement PatientZip()
	{
		return driver.findElement(By.name("corp_api_field[patient][postalCode]"));
	}
	public WebElement PatientAndCardTabGenderDropDown()
	{
		return driver.findElement(By.id("gender"));
	}
	
	public Select PatientGender()
	{
		Select gender = new Select(driver.findElement(By.id("gender")));
		return gender;
	}
	public WebElement PatientDOB()
	{
		return driver.findElement(By.name("corp_api_field[patient][dob]"));
	}
	
	public WebElement PatientPartnerPatientID()
	{
		return driver.findElement(By.name("corp_api_field[patient][partnerId]"));
	}
	
	public WebElement PatientLoginID()
	{
		return driver.findElement(By.name("patient_login_id"));
	}
	
	public WebElement PatientAndCardTabUpdateButton()
	{
		return driver.findElement(By.name("update"));
	}
	public WebElement PatientAndCardTabUpdateConfirm()
	{
		return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[4]/td/font"));
	}
	
	public WebElement PatientAndCardTabCancelButton()
	{
		return driver.findElement(By.name("cancel"));
	}
	public WebElement PatientAndCardTabGoBackButton()
	{
		return driver.findElement(By.name("gobacklist"));
	}
	public WebElement PatientAndCardTabFSVDATAExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='5']"));
	}
	public WebElement PatientAndCardTabCurrentYearProgramBnBExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='1']"));
	}
	public WebElement PatientAndCardTabDebitCardInfoExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='2']"));
	}
	
	public WebElement PatientAndCardTabCardReplacementExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='replace_card']/table/thead/tr[1]/td"));
	}
	public WebElement PatientAndCardTabCardReplacementHistoryExpandable()
	{
	
		return driver.findElement(By.xpath("//*[@id='hideTable2']/table"));
		
	}
	public WebElement PatientAndCardTabCardAuthAmountExpandable()
	{
		//return driver.findElement(By.xpath("//*[@id='hideTable3']/table")); updated on July 20th 2021
		return driver.findElement(By.xpath("//*[@id='hideTable5']/table")); 
	}
	public WebElement PatientAndCardTabCardSwipeInfoExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='hideTable4']/table"));
	}
	public WebElement PatientAndCardTabFSVSystemStatusExpandable()
	{
		return driver.findElement(By.xpath("//*[@id='hideTable6']/table"));
	}
	//**************************Card Information*****************************	
	public String ShortCardID()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr[1]/td[1]")).getText();
	}	
	
	
	
	
	
	
	/* ************************************** Program and benefit balances *********************************************** */
	public String AvailableCopayValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr[7]/td[2]")).getText();
	}	
	
	
	
//********************* Extra***********************************************	
	public WebElement PatientAndCardTabMemberID()
	{
		//return driver.findElement(By.name("patient_other_id"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_1']/form/div/table/tbody/tr/td/table/tbody/tr[17]/td[2]"));
	}
	
	
	public Select PatientAndCardTabPatientStatus()
	{
		//This is patient status/status drop down
		Select patientStatus = new Select(driver.findElement(By.name("patient_status")));
		return patientStatus;
	}
	
	
	public WebElement PatientAndCardTabEnrollmentGroupNumber()
	{
		return driver.findElement(By.name("enrollment_group_number"));
	}
	
	public WebElement PatientAndCardTabActivationDate()
	{
		return driver.findElement(By.id("enroll_date"));
	}
	
	public WebElement PatientAndCardTabRequestedDate()
	{
		return driver.findElement(By.name("patient_created_dt"));
	}
	
	public WebElement PatientAndCardTabAuthorizationDate()
	{
		return driver.findElement(By.name("authorization_date"));
	}
	
	public WebElement PatientAndCardTabAddress1()
	{
		return driver.findElement(By.name("corp_api_field[patient][address1]"));
	}
	
	public WebElement PatientAndCardTabCity()
	{
		return driver.findElement(By.name("corp_api_field[patient][city]"));
	}
	
	
	public WebElement PatientAndCardCellNumber()
	{
		return driver.findElement(By.name("corp_api_field[patient][mobilePhone]"));
	}
	
	
	
	public String PatientAndCardTabCardIDValue()
	{
		return driver.findElement(By.id("patient_short_card_id")).getAttribute("value");
	}
	
	public String PatientAndCardTabTitleValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][salutation]")).getAttribute("value");
	}
	
	public String PatientAndCardTabFirstNameValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][firstName]")).getAttribute("value");
	}
	
	public String PatientAndCardTabMiddleInitialValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][middleName]")).getAttribute("value");
	}
	
	public String PatientAndCardTabLastNameValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][lastName]")).getAttribute("value");
	}
	
	public String PatientAndCardTabAddress1Value()
	{
		return driver.findElement(By.name("corp_api_field[patient][address1]")).getAttribute("value");
	}
	
	public String PatientAndCardTabAddress2Value()
	{
		return driver.findElement(By.name("corp_api_field[patient][address2]")).getAttribute("value");
	}
	
	public String PatientAndCardTabCityValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][city]")).getAttribute("value");
	}
	
	public String PatientAndCardTabLoginIDValue()
	{
		return driver.findElement(By.name("patient_login_id")).getAttribute("value");
	}
	
	public String PatientAndCardTabPartnerPatientIDValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][partnerId]")).getAttribute("value");
	}
	
	public String PatientAndCardTabMemberIDValue()
	{
		//return driver.findElement(By.name("patient_other_id")).getAttribute("value");
		return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[16]/td[2]")).getText();
	}
	
	public String PatientAndCardTabActivationDateValue()
	{
		return driver.findElement(By.id("enroll_date")).getAttribute("value");
	}
	
	public String PatientAndCardTabEnrollmentGroupNumberValue()
	{
		//return driver.findElement(By.name("enrollment_group_number")).getAttribute("value");
		return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[17]/td[2]")).getText();
	}
	
	public String PatientAndCardTabPatientStatusValue()
	{
		return PatientAndCardTabPatientStatus().getFirstSelectedOption().getText();
	}
/*	
	public String PatientAndCardTabPatientResidingStateValue()
	{
		return PatientAndCardTabState().getFirstSelectedOption().getText();
	}
	
	public String PatientAndCardTabDOBValue()
	{
		return PatientAndCardTabDOB().getAttribute("value");
	}
	
	public String PatientAndCardTabGenderValue()
	{
		return PatientAndCardTabGender().getFirstSelectedOption().getText();
	}
	
	public String PatientAndCardTabZipValue()
	{
		return PatientAndCardTabZip().getAttribute("value");
	}
	*/
	public String PatientAndCardCellNumberValue()
	{
		return PatientAndCardCellNumber().getAttribute("value");
	}
	
	public String PatientAndCardUpdateConfirmationMessage()
	{
		return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[3]/td/font")).getText();
	}
	
	public String RegisteredThruValue() 
	{
		return driver.findElement(By.name("patient_activation_type_name")).getAttribute("value");
	}
	
	public List<WebElement> GetStatesList()
	{
		List<WebElement> statesList = driver.findElements(By.xpath("//*[@id='state']/option"));
		return statesList;
	}
	
	public static String UpdateDateInDOBToOneDigit(char[] dateDigits)
	{
		String DOD = Character.toString(dateDigits[1]);
		return DOD;
	}
	
	public WebElement ProgramLabelValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']//div[@id='tab_1']/form/div/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]"));
	}
	
	public String EnrollmentTypeValue()
	{
		Select enrollmentList = new Select(driver.findElement(By.name("patient_enrollment_type")));
		return enrollmentList.getFirstSelectedOption().getText();
	}
	
	public String MobilePhoneValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][mobilePhone]")).getAttribute("value");
	}
	
	public String CardIDValue()
	{
		return driver.findElement(By.name("patient_short_card_id")).getAttribute("value");
	}
	
	public String DrugReimbursementValue()
	{
		return driver.findElement(By.name("drug_reimbursement")).getAttribute("value");
	}
	
	public String ProcedureReimbursementValue()
	{
		return driver.findElement(By.name("procedure_reimbursement")).getAttribute("value");
	}
	
	public String ConfirmationNumberValue()
	{
		return driver.findElement(By.name("confimation_number")).getAttribute("value");
	}
	
	public String ExpirationDateValue()
	{
		return driver.findElement(By.name("patient_expiration_date")).getAttribute("value");
	}
	
	public String ReenrollmentDateValue()
	{
		return driver.findElement(By.name("reenrollsdate")).getAttribute("value");
	}
	
	public String PatientTypeValue()
	{
		Select patient = new Select(driver.findElement(By.name("patient_type")));
		return patient.getFirstSelectedOption().getText();
	}
}
