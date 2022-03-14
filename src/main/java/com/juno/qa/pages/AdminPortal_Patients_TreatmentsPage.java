	package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class AdminPortal_Patients_TreatmentsPage extends TestBase {
	
	AdminPortal_Faxes_IncomingPage aip = new AdminPortal_Faxes_IncomingPage();
	CommonFunctions cf = new CommonFunctions();
	GetAndSetTestData dat = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	public AdminPortal_Patients_TreatmentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement TreatmentsTabOption()
	{
		return driver.findElement(By.linkText("Create Treatment"));
	}
	
	public WebElement ProgramField()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_form']/table/tbody/tr[1]/td[1]/table[1]/tbody/tr[1]/td[2]/input"));
	}
	public WebElement TreatmentStatusReject()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_status']/option[2]"));
	}
	
	public WebElement TreatmentStatusRejectOptions()
	{
		return driver.findElement(By.id("treatment_reject_reason"));
	}
	
	
	public WebElement ShortCardID()
	{
		//return driver.findElement(By.id("patient_short_card_id"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_2']/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/span"));
	}
	
	public WebElement MemberID()
	{
		return driver.findElement(By.id("patient_other_id"));
	}
	
	public WebElement RequestPatientReleaseForm()
	{
		return driver.findElement(By.id("received_release_form"));
	}
	
	public WebElement BirthDate()
	{
		return driver.findElement(By.id("patient_dob"));
	}
	
	public Select PatientStatus()
	{
		Select patientStatus = new Select(driver.findElement(By.id("patient_status")));
		return patientStatus;
	}
	
	public WebElement PatientStatusField()
	{
		return driver.findElement(By.id("patient_status"));
	}
	
	public WebElement BenefitsBalanceRemaining()
	{
		return driver.findElement(By.id("benifit_balance"));
	}
	
	public WebElement EnrollmentDate()
	{
		return driver.findElement(By.id("last_date_of_service"));
	}
	
	public Select RejectReasonDropdown()
	{
		Select rejectReason = new Select(driver.findElement(By.id("treatment_reject_reason")));
		return rejectReason;
	}
	
	public List<WebElement> RejectReasonDropdownValues()
	{
		return driver.findElements(By.id("treatment_reject_reason"));
	}
	
	public WebElement RejectReasonDropdownOption()
	{
		return driver.findElement(By.id("treatment_reject_reason"));
	}
	
	public WebElement RejectReasonDropdownNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='treatment_reject_reason']/option["+i+"]"));
	}
	
	public WebElement RejectReasonField()
	{
		return driver.findElement(By.id("treatment_reject_reason"));
	}
	
	public WebElement BenefitsBalanceExpirationDate()
	{
		return driver.findElement(By.id("patient_expiration_date"));
	}
		
	public WebElement DrugReimbursement()
	{
		return driver.findElement(By.id("drug_reimbursement"));
	}
	
	public WebElement ProcedureReimbursement()
	{
		return driver.findElement(By.id("procedure_reimbursement"));
	}
	
	public Select TreatmentStatus()
	{
		Select treatmentStatus = new Select(driver.findElement(By.id("treatment_status")));
		return treatmentStatus;
	}
	public Select TreatmentRejectionStatus()
	{
		Select treatmentStatus = new Select(driver.findElement(By.id("treatment_reject_reason")));
		return treatmentStatus;
	}
	public WebElement EOBFaxes()
	{
		return driver.findElement(By.id("eob_faxes"));
	}
	
	public WebElement EOBFaxOptionToSelect()
	{
		return driver.findElement(By.xpath("//*[@id='eob_faxes']/option[2]"));
	}
	
	public WebElement OutgoingFaxNumber()
	{
		//return driver.findElement(By.name("search_fax")); //updated for Replatform
		return driver.findElement(By.name("outgoing_fax"));
	}
	
	public WebElement DateOfService()
	{
		return driver.findElement(By.id("date_of_service_1"));
	}
	
	public WebElement InsuranceNameOnEOB()
	{
		return driver.findElement(By.id("primary_payer_name")); //updated 10262021
	}
	
	public Select CPTCodeDropdown()
	{
		Select ctpCodes = new Select(driver.findElement(By.id("cptcode")));
		return ctpCodes;
	}
	
	public WebElement CPTCodedropdownOption()
	{
		return driver.findElement(By.id("cptcode"));
	}
	
	public WebElement CPTCodedropdownOptionOne()
	{
		return driver.findElement(By.xpath("//*[@id='cptcode']/option[2]"));
	}

	
	public WebElement CPTCodeDropdownNoCode()
	{
		return driver.findElement(By.xpath("//*[@id=\"cptcode\"]/option[3]"));
	}
	
	public WebElement Quantity()
	{
		return driver.findElement(By.id("quantity"));
	}
	
	public WebElement Copay()
	{
		return driver.findElement(By.id("jcode_copay"));
	}
	
	public WebElement Copay_AdminReimbursement()
	{
		return driver.findElement(By.id("cptcode_copay"));
	}
	
	public WebElement PatientPays()
	{
		return driver.findElement(By.id("jcode_patient_required_copay"));
	}
	
	public WebElement EOBDate()
	{
		return driver.findElement(By.id("eob_date"));
	}
	
	public WebElement BillingName()
	{
		return driver.findElement(By.name("search_billing_provider_name"));
	}
	
	public WebElement SearchDisplayBox()
	{
		return driver.findElement(By.className("search_display_box"));
	}
	
	public WebElement PracticeName()
	{
		return driver.findElement(By.id("search_treating_provider_name"));
	}
	
	public WebElement PracticeNPI()
	{
		return driver.findElement(By.name("search_treating_npi"));
	}
	
	public WebElement PhysicianLastName()
	{
		return driver.findElement(By.name("search_physician_last_name"));
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.xpath("//*[@id='button_add']"));
	}
	
	public WebElement TreatementAddConfirmation()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/div/font[(text()=' Added Patient Treatment Extra.')]"));
	}
	public WebElement TreatementConfirmation()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/div"));
	}
	
	
	public WebElement GetTheAmount()
	{
		return driver.findElement(By.xpath("//*[@id='jcode_patient_requested_copay']"));
	}
	public WebElement GetTheCard()
	{
		return driver.findElement(By.xpath("//*[@id='patient_short_card_id']"));
	}
		
	public WebElement TreatmentRejectedDuplicate()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/font[2][(text()[5]='Treatment Status:Rejected-Duplicate')]"));
	}
	
/*	public WebElement DateOfServicingLessThanRetroDateMessageHeadingUnderDOS()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[2]/td[1][(text() = 'Date of Service:')]"));
		//*[@id="form_cardload_inner"]/tbody/tr[2]/td[1]/text()
	} */
	
	public WebElement DateOfServicingLessThanRetroDateMessageUnderDOS()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[2]/td[1]/font[(text() = 'Date of Service cannot be before Retro Period/Lookback Date.')]"));
	}
	
	public WebElement DateOfServicingLessThanRetroDateValidationHeadingUnderAddButton()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/font[(text()[1] = 'Validation Error.')]"));
	}
	
	public WebElement DateOfServicingLessThanRetroDateMessageUnderAddButton()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/font[(text()[2] = 'Date of Service cannot be before Retro Period/Lookback Date.')]"));
	}
	
	public String RetroPeriodDateValue()
	{
		return driver.findElement(By.name("retro_period_date")).getAttribute("value");
	}
	
	
	public WebElement Jcodedropdown()
	{
		return driver.findElement(By.id("jcode"));
	}
	
	public Select JcodeList()
	{
		Select jcode = new Select(driver.findElement(By.id("jcode")));
		return jcode;
	}
	
	public boolean isElementVisible(WebElement locator){
	    return AddButton().isDisplayed();
	}
	
	public WebElement JcodeOption()
	{
		//This Page object is hardcoded to select the first option in the drop down. Depending on the requirement, this can be updated to select by the option name.
	/*	Select jCodeList = new Select(driver.findElement(By.id("jcode")));
		return jCodeList; */
		return driver.findElement(By.xpath("//*[@id='jcode']/option[2]"));
	}
	public WebElement JcodeOptionOne()
	{
		//This Page object is hardcoded to select the first option in the drop down. Depending on the requirement, this can be updated to select by the option name.
		return driver.findElement(By.xpath("//*[@id='jcode']/option[1]"));

	}
	
	public WebElement JcodeOptionTwo()
	{
		//This Page object is hardcoded to select the first option in the drop down. Depending on the requirement, this can be updated to select by the option name.
		return driver.findElement(By.xpath("//*[@id='jcode']/option[3]"));
	}
	
	public WebElement JcodeOptionThree()
	{
		return driver.findElement(By.xpath("//*[@id='jcode']/option[4]"));
	}
	
	public WebElement NDCDropdown()
	{
		return driver.findElement(By.id("ndc"));
	}
	
	public Select NDCList()
	{
		Select ndc = new Select(driver.findElement(By.id("ndc")));
		return ndc;
	}
	
	public WebElement NDCDropdownOption()
	{
		return driver.findElement(By.xpath("//*[@id='ndc']/option[2]"));
	}
	
	public WebElement CheckRadioButton()
	{
		return driver.findElement(By.id("payment_method"));
	}
	
	public WebElement PatientRadioButton()
	{
		return driver.findElement(By.id("pay_patient_check_1"));
	}
	
	public WebElement PracticeRadioButton()
	{
		return driver.findElement(By.id("pay_patient_check_2"));
	}
	
	public WebElement ACHRadioButton()
	{
		return driver.findElement(By.id("payment_method_1"));
	}
	
	public WebElement ShipToAddressYesCheckbox()
	{
		return driver.findElement(By.name("ship_to_address_check"));
	}
	
	public WebElement PayeeName()
	{
		return driver.findElement(By.name("shipping_name"));
	}
	
	public WebElement PayeeAddress()
	{
		return driver.findElement(By.name("shipping_address_1"));
	}
	
	public WebElement PayeeAddress2()
	{
		return driver.findElement(By.name("shipping_address_2"));
	}
	
	public WebElement PayeeCity()
	{
		return driver.findElement(By.name("shipping_city"));
	}
	
	public Select PayeeState()
	{
		Select statesList = new Select(driver.findElement(By.name("shipping_state")));
		return statesList;
	}
	
	public List<WebElement> PayeeStatesList()
	{
		return driver.findElements(By.xpath("//*[@id='shipping_state']/option"));
		
	}
	
	public WebElement PayeeZip()
	{
		return driver.findElement(By.name("shipping_zip"));
	}
	
	public WebElement PayeePhone()
	{
		return driver.findElement(By.name("shipping_phone_number"));
	}
	
	public WebElement UpdateRejectPopUp()
	{
		//return driver.findElement(By.className("ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable ui-resizable"));
		return driver.findElement(By.xpath("/html/body/div[4]"));
	}
	
	public WebElement UpdateRejectPopUpUpdateButton()
	{
		return driver.findElement(By.xpath("//span[contains(@class, 'ui-button-text') and text()='Update']"));
	}
	
	public WebElement UpdateRejectPopUpRejectButton()
	{
		return driver.findElement(By.xpath("//span[contains(@class, 'ui-button-text') and text()='Reject']"));
	}
	
	public WebElement ReachedMaxBenefitsErrorMessage()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_err']/font[(text()[2] = 'Total maximum benefit allowed for this eligibility period has been reached. Please reduce the patient responsibility to equal the remaining benefit balance or reject the claim using reject reason \"Max Benefit Reached\".')]"));
	}
	
	public Select SelectBillingProviderDropdownList()
	{
		Select BOList = new Select(driver.findElement(By.id("billing_provider_id")));
		return BOList;
	}
	
	public WebElement SelectBillingProviderDropdown()
	{
		return driver.findElement(By.id("billing_provider_id"));
	}
	
	public WebElement SelectBillingProviderDropdownFirstValidOption()
	{
		return driver.findElement(By.xpath("//*[@id='billing_provider_id']/option[2]"));
	}
	
	public WebElement BillingContactLastName()
	{
		return driver.findElement(By.id("search_billing_last_name"));
	}
	
	public WebElement BillingNPI()
	{
		return driver.findElement(By.id("search_billing_npi"));
	}
	
	public Select SelectTreatingPracticeDropdownList()
	{
		Select BOList = new Select(driver.findElement(By.id("treating_provider_id")));
		return BOList;
	}
	
	public WebElement SelectTreatingPracticeDropdown()
	{
		return driver.findElement(By.id("treating_provider_id"));
	}
	
	public WebElement SelectTreatingPracticeDropdownFirstValidOption()
	{
		return driver.findElement(By.xpath("//*[@id='treating_provider_id']/option[2]"));
	}
	
	public WebElement TreatingNPI()
	{
		return driver.findElement(By.id("search_treating_npi"));
	}
	
	public WebElement PhysicianNPI()
	{
		return driver.findElement(By.id("search_physician_npi"));
	}
	
	public WebElement BOResetSearchButton()
	{
		return driver.findElement(By.xpath("//button[text()='Reset Search']"));
	}
	
	public WebElement GPResetSearchButton()
	{
		return driver.findElement(By.xpath("//div[@id='tab_2']/div/form/table/tbody/tr/td[3]/table[4]/tbody/tr/td/button"));
	}
	
	public WebElement AddNewBillingOfficeLink()
	{
		return driver.findElement(By.linkText("Add New Billing Office"));
	}
	
	public WebElement AddNewPracticeLocationLink()
	{
		return driver.findElement(By.linkText("Add New Practice Location"));
	}
	
	public String EOBFaxesRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_form']/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[5]/td[1]/font")).getText();
	}
	
	public String OutgoingFaxRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='treatment_form']/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[8]/td[1]/font")).getText();
	}
	
	public String DOSRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[2]/td[1]/font")).getText();
	}
	
	public String JCodeRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[8]/td[1]/font")).getText();
	}
	
	public String QuantityRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[9]/td[1]/font")).getText();
	}
	
	public String NDCRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload_inner']/tbody/tr[10]/td[1]/font")).getText();
	}
	
	public String EOBDateRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='eob_date_txt']/font")).getText();
	}
	
	public String PayeeNameRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[3]/td[1]/font")).getText();
	}
	
	public String PayeeAddressRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[4]/td[1]/font")).getText();
	}
	
	public String PayeeCityRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[6]/td[1]/font")).getText();
	}
	
	public String PayeeStateRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[7]/td[1]/font")).getText();
	}
	
	public String PayeeZipRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[8]/td[1]/font")).getText();
	}
	
	public String PayeePhoneRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form_cardload']/table[3]/tbody/tr[9]/td[1]/font")).getText();
	}
	
	public String BillingProviderRequiredMsg()
	{
		//return driver.findElement(By.xpath("//*[@id='billing_provider_group']/tbody/tr[2]/td[2]/span")).getText(); //updated for replatform
		return driver.findElement(By.xpath("//*[@id='billing_provider_group']/tbody/tr[2]/td[1]")).getText();
		
	}
	
	public String TreatingPracticeRequiredMsg()
	{
		//return driver.findElement(By.xpath("//*[@id='treating_provider_group']/tbody/tr[2]/td[2]/span")).getText(); //updated for replatform
		return driver.findElement(By.xpath("//*[@id='treating_provider_group']/tbody/tr[2]/td[1]")).getText();
		
	}
	
	public String PhysicianRequiredMsg()
	{
		//return driver.findElement(By.xpath("//*[@id='physician_provider_group']/tbody/tr[2]/td[2]/span")).getText(); //updated for replatform
		return driver.findElement(By.xpath("//*[@id='physician_provider_group']/tbody/tr[2]/td[1]")).getText();
	}
	
	public String FieldRequiredMsgUnderAddButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_2']/div/form/table/tbody/tr[3]/td[@id='treatment_err']/div/font")).getText();
	}
	
	public String EOBDatePriorToDOS()
	{
		return driver.findElement(By.xpath("//*[@id='eob_date_txt']/font")).getText();
	}
	
	public WebElement ShortCardIDInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_patient_short_card_id"));
	}
	
	public WebElement RequirePatientReleaseFormInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_received_release_form"));
	}
	
	public WebElement MemberIDInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_patient_other_id"));
	}
	
	public WebElement BenefitsBalanceExpirationInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_patient_expiration_date"));
	}
	
	public Select EnrollmentType()
	{
		Select enrollmentType = new Select(driver.findElement(By.name("patient_enrollment_type")));
		return enrollmentType;
	}
	
	public WebElement DrugReimbursementInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_drug_reimbursement"));
	}
	
	public WebElement ProcedureReimbursementInputTypeHidden()
	{
		return driver.findElement(By.id("chosen_procedure_reimbursement"));
	}
	
	public List<WebElement> TreatmentRequestsGridRows()
	{
		return driver.findElements(By.xpath("//table[@id='sortTable1']/tbody/tr"));
	}
	
	public WebElement GetTreatmentRequestsGridLatestRowStatusCol()
	{
		return driver.findElement(By.xpath("//table[@id='sortTable1']/tbody/tr["+TreatmentRequestsGridRows().size()+"]/td[14]"));
	}
	
	public WebElement GetTreatmentReasonForHoldGridLatestRowStatusCol()
	{
		return driver.findElement(By.xpath("//table[@id='sortTable1']/tbody/tr["+TreatmentRequestsGridRows().size()+"]/td[21]"));
	}
	
	public String BillingNameValue()
	{
		//return driver.findElement(By.id("provider_name")).getText(); updated for replatform
		return driver.findElement(By.id("billing_provider_name")).getText();
		
	}
	
	public String ContactFirstNameValue()
	{
		//return driver.findElement(By.id("provider_first_name")).getText(); updated for replatform
		return driver.findElement(By.id("billing_first_name")).getText();
	}
	
	public String ContactLastNameValue()
	{
		//return driver.findElement(By.id("provider_last_name")).getText();updated for replatform
		return driver.findElement(By.id("billing_last_name")).getText();
	}
	
	public String AddressValue()
	{
		//return driver.findElement(By.id("provider_address_1")).getText(); updated for replatform
		return driver.findElement(By.id("billing_address_1")).getText();
		
	}
	
	public String CityValue()
	{
		//return driver.findElement(By.id("provider_city")).getText(); updated for replatform
		return driver.findElement(By.id("billing_city")).getText();
	}
	
	public String StateValue()
	{
		//return driver.findElement(By.id("provider_state")).getText();updated for replatform
		return driver.findElement(By.id("billing_state")).getText();
	}
	
	public String ZipValue()
	{
		//return driver.findElement(By.id("provider_zip")).getText(); updated for replatform
		return driver.findElement(By.id("billing_zip")).getText();
	}
	
	public String PhoneNumberValue()
	{
		//return driver.findElement(By.id("provider_phone_number")).getText(); updated for replatform
		return driver.findElement(By.id("billing_phone_number")).getText(); 
	}
	
	public String FaxNumberValue()
	{
		//return driver.findElement(By.id("provider_fax_number")).getText(); updated for replatform
		return driver.findElement(By.id("billing_fax_back_number")).getText(); 
	}
	
	public String NPIValue()
	{
		//return driver.findElement(By.id("provider_npi")).getText(); updated for replatform
		return driver.findElement(By.id("billing_physician_npi")).getText(); 
	}
	
	public String ProviderIDValue()
	{
		//return driver.findElement(By.xpath("//table[@id='billing_provider_group']/tbody/tr[18]/td[2]/span[@id='billing_provider_id']")).getText(); updated for replatform
		return driver.findElement(By.xpath("//*[@id='billing_provider_id' and contains(@class,'provider_field_default_hide')]")).getText(); 
	}
	
	public String TreatingPracticeNameValue()
	{
		return driver.findElement(By.id("treating_provider_name")).getText();
	}
	
	public String TreatingAddressValue()
	{
		return driver.findElement(By.id("treating_address_1")).getText();
	}
	
	public String TreatingCityValue()
	{
		return driver.findElement(By.id("treating_city")).getText();
	}
	
	public String TreatingStateValue()
	{
		return driver.findElement(By.id("treating_state")).getText();
	}
	
	public String TreatingZipValue()
	{
		return driver.findElement(By.id("treating_zip")).getText();
	}
	
	public String TreatingPhoneNumberValue()
	{
		return driver.findElement(By.id("treating_phone_number")).getText();
	}
	
	public String TreatingFaxNumberValue()
	{
		return driver.findElement(By.id("treating_fax_back_number")).getText();
	}
	
	public String TreatingTaxNumberValue()
	{
		return driver.findElement(By.id("treating_tax_id")).getText();
	}
	
	public String TreatingNPIValue()
	{
		return driver.findElement(By.id("treating_physician_npi")).getText();
	}
	
	public String TreatingProviderIDValue()
	{
		return driver.findElement(By.xpath("//*[@id='treating_provider_id' and contains(@class,'provider_field_default_hide')]")).getText();
	}
	
	public String PhysicianFirstNameValue()
	{
		return driver.findElement(By.id("physician_provider_first_name")).getText();
	}
	
	public String PhysicianLastNameValue()
	{
		return driver.findElement(By.id("physician_provider_last_name")).getText();
	}
	
	public String PhysicianAddressValue()
	{
		return driver.findElement(By.id("physician_provider_address")).getText();
	}
	
	public String PhysicianCityValue()
	{
		return driver.findElement(By.id("physician_provider_city")).getText();
	}
	
	public String PhysicianStateValue()
	{
		return driver.findElement(By.id("physician_provider_state")).getText();
	}
	
	public String PhysicianZipValue()
	{
		return driver.findElement(By.id("physician_provider_zip")).getText();
	}
	
	public String PhysicianPhoneNumberValue()
	{
		return driver.findElement(By.id("physician_provider_phone")).getText();
	}
	
	public String PhysicianFaxNumberValue()
	{
		return driver.findElement(By.id("physician_provider_fax")).getText();
	}
	
	public String PhysicianProviderIDValue()
	{
		return driver.findElement(By.id("physician_provider_id")).getText();
	}
	
	public String MaxBenefitsExceededvalidationMsgAdmin()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_2']/div/form/table/tbody/tr[3]/td/div/font")).getText();
	}
	
	
	public String CalculatePreviousDateOfCurrentDate(String date)
	{
		try {
	 		 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	         // Get a Date object from the date string
	         Date myDate = dateFormat.parse(date);

	      
	         Date oneDayBefore = new Date(myDate.getTime() - 2);
	         String result = dateFormat.format(oneDayBefore);
	         
	         return result;
	       
	 		}
	 		catch(ParseException p)
	 		{
	 		
	 		}
		return null;
		
	}
	
	public void RejectedAddFaxInformationAndTreatmentToEnrolledPatients(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		//Get the short card ID from UI and add it to excel for payment processing
		String cardID = ShortCardID().getText();
		System.out.println("CardID: "+cardID);
		reader.copyCellData("Smoke", "CardID", rowNum, cardID);
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        
        CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        System.out.println("I am clicking on wait");
        Thread.sleep(80000);
 		
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatients(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest 
 		//commenting this for lucentis
 		/*Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		*/
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		//Get the short card ID from UI and add it to excel for payment processing
		String cardID = ShortCardID().getText();
		System.out.println("CardID: "+cardID);
		reader.copyCellData("Smoke", "CardID", rowNum, cardID);
				
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		//OutgoingFaxNumber().click();
		//OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
			System.out.println("%%%" +DS[2]);
	       
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
	        System.out.println("Insurance EOB" +testData.get(6));
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
        
        Thread.sleep(3000);
        NDCDropdown().click();
     
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
        Copay().clear();
        Copay().sendKeys(testData.get(8));
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
    	System.out.println("Billing name:" +testData.get(10));
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        System.out.println("Practice Name:" +testData.get(11));
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        System.out.println("Physician Last Name:" +testData.get(12));
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        System.out.println("Before click add button");
      // Thread.sleep(5000);
        AddButton().click();
        System.out.println("I am clicking on 1st wait");
        Thread.sleep(10000);
        System.out.println("1st wait");
    }
	
	public void MaxAccumAddFaxInformationAndTreatmentToEnrolledPatients(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest 
 		//commenting this for lucentis
 		/*Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		*/
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		//Get the short card ID from UI and add it to excel for payment processing
		String cardID = ShortCardID().getText();
		System.out.println("CardID: "+cardID);
		reader.copyCellData("Smoke", "CardID", rowNum, cardID);
				
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		//OutgoingFaxNumber().click();
		//OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
			System.out.println("%%%" +DS[2]);
	       
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
	        System.out.println("Insurance EOB" +testData.get(6));
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
        
        Thread.sleep(3000);
        NDCDropdown().click();
     
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
        Copay().clear();
        Copay().sendKeys("12000");
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
    	System.out.println("Billing name:" +testData.get(10));
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        System.out.println("Practice Name:" +testData.get(11));
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        System.out.println("Physician Last Name:" +testData.get(12));
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(4000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        System.out.println("Before click add button");
      // Thread.sleep(5000);
        AddButton().click();
        System.out.println("I am clicking on 1st wait");
        Thread.sleep(10000);
        System.out.println("1st wait");
    }
	
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientsForAdminReimbursement(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		//Get the short card ID from UI and add it to excel for payment processing
		String cardID = ShortCardID().getText();
		System.out.println("CardID: "+cardID);
		reader.copyCellData("Smoke", "CardID", rowNum, cardID);
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        
        CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        System.out.println("I am clicking on wait");
        Thread.sleep(80000);
 		
       
        
       
	}
	
		
	public void AddFaxInformationAndTreatmentToEnrolledPatientsForRepaymentClaim(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(14));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(16));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(18));//.substring(4, 10));
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(0));
		aip.FaxStatus().selectByVisibleText(testData.get(1));
		aip.EOBStatus().selectByVisibleText(testData.get(2));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(3));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(4));//DOS
		 DateOfService().click();
			cf.SelectDate(testData.get(4));
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(5));
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
        
        NDCDropdown().click();
     //   Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(6));
        Copay().clear();
        Copay().sendKeys("10");
        System.out.println("test data copay:"+testData.get(7));
        
        //EOB Date
        EOBDate().click();
		cf.SelectDate(testData.get(8));
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
      
        AddButton().click();
        
       
	}
	
	public void RejectedAddFaxInformationAndTreatmentToEnrolledPatientsForAdminReimbursement(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Get the program name from UI and add it to excel for payment processing
		String programName = ProgramField().getAttribute("value");
		reader.copyCellData("Smoke", "ProgramName", rowNum, programName);
		
		//Get the short card ID from UI and add it to excel for payment processing
		String cardID = ShortCardID().getText();
		System.out.println("CardID: "+cardID);
		reader.copyCellData("Smoke", "CardID", rowNum, cardID);
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        
        CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        System.out.println("I am clicking on wait");
        Thread.sleep(80000);
 		
       
        
       
	}
	public void AddFaxInformationAndTreatmentToEnrolledPatients(List<String> testData, String TreatmentType, String Key, String ReimbursementType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(14));
 	
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(8));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			String[] DS = testData.get(9).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(10));
        
        if(ReimbursementType.equalsIgnoreCase("Drug Reimbursement"))
        {
	        Jcodedropdown().click();
	     //   Thread.sleep(3000);
	        JcodeOptionTwo().click();
	        
	        NDCDropdown().click();
	     //   Thread.sleep(3000);
	        NDCDropdownOption().click();
	        
	        Quantity().sendKeys(testData.get(6));
       
	        Copay().clear();
	        Copay().sendKeys(testData.get(11));
        }
        else if(ReimbursementType.equalsIgnoreCase("Admin Reimbursement"))
        {
        	  CPTCodeDropdown().selectByVisibleText(testData.get(6));
              Copay_AdminReimbursement().clear();
              Copay_AdminReimbursement().sendKeys(testData.get(11));
        }
        
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(4).split("-");//EOB Date
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        if(Key.equalsIgnoreCase("SelectBOFromDropdownForTreatment") || Key.equalsIgnoreCase("SelectBOFromDropdownForTreatmentForAdminReimbursement"))
        {
	       //Select Billing Provider from dropdown
	        SelectBillingProviderDropdown().click();
	        SelectBillingProviderDropdownFirstValidOption().click();
        }
        else
        {
        	//Billing Provider search
            BillingName().sendKeys(testData.get(16));
            Thread.sleep(2000);
            SearchDisplayBox().click();
        }
        
        if(Key.equalsIgnoreCase("SelectGPFromDropdownForTreatment") || Key.equalsIgnoreCase("SelectGPFromDropdownForTreatmentForAdminReimbursement"))
        {
	       //Select Billing Provider from dropdown
	        SelectTreatingPracticeDropdown().click();
	        SelectTreatingPracticeDropdownFirstValidOption().click();
        }
        else
        {
        	//Practice Information
	        PracticeName().sendKeys(testData.get(12));
	        Thread.sleep(2000);
	        SearchDisplayBox().click();
        }
	        
       
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(13));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(8000);
 		
       
        
       
	}
	
	public boolean VerifySpecificRequiredFieldInTreatmentsTab(List<String> testData, WebElement webelement) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			boolean eobSpecified = false;
			boolean jcodeSpecified = false;
			boolean qtySpecified = false;
			boolean ndcSpecified = false;
			if(!webelement.equals(EOBDate()))
			{
				System.out.println("Inside EOB if");
				EOBDate().click();
				cf.SelectDate(testData.get(1));
				eobSpecified = true;
				
			}
			if(!webelement.equals(Jcodedropdown()))
			{
				System.out.println("Inside Jcode if");
				 Jcodedropdown().click();
				 JcodeOptionTwo().click();
			     jcodeSpecified = true;
			}
			if(!webelement.equals(Quantity()))
			{
				System.out.println("Inside qty if");
				 Quantity().sendKeys(testData.get(3));
				 qtySpecified = true;
			}
			if(!webelement.equals(NDCDropdown()))
			{
				System.out.println("Inside npi if");
				 NDCDropdown().click();
			     NDCDropdownOption().click();
			     ndcSpecified = true;
			}
			System.out.println("Outside if");
			
			EOBFaxes().click();
			EOBFaxOptionToSelect().click();
			Thread.sleep(1000);
			//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
			OutgoingFaxNumber().click();
			OutgoingFaxNumber().sendKeys(testData.get(5));
			//Thread.sleep(10000);
			
			//date of service
			System.out.println("date of service from excel:"+testData.get(6));//DOS
			 DateOfService().click();
				cf.SelectDate(testData.get(6));
		        Thread.sleep(2000);
		  
	        InsuranceNameOnEOB().sendKeys(testData.get(7));
	       
	        Copay().clear();
	        Copay().sendKeys(testData.get(8));
	        
	        //Billing Provider search
	        BillingName().sendKeys(testData.get(9));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Practice Information
	        PracticeName().sendKeys(testData.get(10));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Provider Information
	        PhysicianLastName().sendKeys(testData.get(11));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	      //  Thread.sleep(5000);
	        AddButton().click();
	        Thread.sleep(8000);
	        
	        if(!eobSpecified)
	        {
	        	 Assert.assertEquals(EOBDateRequiredMsg(), testData.get(12));
	        //	 Assert.assertEquals(DOSRequiredMsg(), testData.get(16));
	        	 Assert.assertEquals(FieldRequiredMsgUnderAddButton(), testData.get(17));
	        }
	        else if(!jcodeSpecified)
	        {
	        	Assert.assertEquals(JCodeRequiredMsg(), testData.get(13));
	        }
	        else if(!qtySpecified)//Quantity().getText().isEmpty())
	        {
	        	Assert.assertEquals(QuantityRequiredMsg(), testData.get(14));
	        }
	        else if(!ndcSpecified)//NDCList().getFirstSelectedOption().getText().equalsIgnoreCase("Select NDC Code"))
	        {
	        	Assert.assertEquals(NDCRequiredMsg(), testData.get(15));
	        }
	        
	        return true;
		}
		verify = false;
		return verify;
        
	}
	
	public boolean VerifySpecificRequiredFieldInTreatmentsTabAdminReimbursement(List<String> testData, WebElement webelement) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			boolean eobSpecified = false;
			boolean jcodeSpecified = false;
			boolean qtySpecified = false;
			boolean ndcSpecified = false;
			if(!webelement.equals(EOBDate()))
			{
				System.out.println("Inside EOB if");
				EOBDate().click();
				cf.SelectDate(testData.get(1));
				eobSpecified = true;
				
			}
			
			EOBFaxes().click();
			EOBFaxOptionToSelect().click();
			Thread.sleep(1000);
			//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
			OutgoingFaxNumber().click();
			OutgoingFaxNumber().sendKeys(testData.get(2));
			//Thread.sleep(10000);
			
			//date of service
			System.out.println("date of service from excel:"+testData.get(3));//DOS
			 DateOfService().click();
				cf.SelectDate(testData.get(3));
		        Thread.sleep(2000);
		  
	        InsuranceNameOnEOB().sendKeys(testData.get(4));
	       
	        CPTCodeDropdown().selectByVisibleText(testData.get(5));
	        
	        Copay_AdminReimbursement().clear();
	        Copay_AdminReimbursement().sendKeys(testData.get(6));
	        
	        //Billing Provider search
	        BillingName().sendKeys(testData.get(7));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Practice Information
	        PracticeName().sendKeys(testData.get(8));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Provider Information
	        PhysicianLastName().sendKeys(testData.get(9));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	      //  Thread.sleep(5000);
	        AddButton().click();
	        Thread.sleep(8000);
	        
	        if(!eobSpecified)
	        {
	        	 Assert.assertEquals(EOBDateRequiredMsg(), testData.get(10));
	        //	 Assert.assertEquals(DOSRequiredMsg(), testData.get(16));
	        	 Assert.assertEquals(FieldRequiredMsgUnderAddButton(), testData.get(12));
	        }
	        
	        
	        return true;
		}
		verify = false;
		return verify;
        
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatient(List<String> testData, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	       cf.SelectDate(testData.get(12));
	       Thread.sleep(3000);
	       System.out.println("Clicked on DOS date");
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
     //   Thread.sleep(3000);
        NDCDropdown().click();
     //  Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
    //    Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForMaxPatientResponsibility(List<String> testData, String TreatmentType, String maxCopay ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		//Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
     //   Thread.sleep(3000);
        NDCDropdown().click();
     //  Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
    //    Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(maxCopay);
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(9).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientWithNoJcode(List<String> testData, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOption().click();
        
        //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept(); //ACCEPT ACTION
        
     //   Thread.sleep(3000);
        NDCDropdown().click();
     //  Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
    //    Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void RejectTreatmentAddFaxInformationAndTreatmentToEnrolledPatients(List<String> testData, int rowNum, String TreatmentType ) throws InterruptedException, IOException, AWTException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest 
 		//commenting this for lucentis
 		/*Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(13));
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), testData.get(14));//.substring(4, 10));
		*/
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		
		//Verify the Reject options
		
		TreatmentStatusReject().click();
		Thread.sleep(3000);
		String trp= "Select a Reject Reason\nMaximum Benefit Reached\nDuplicate claim\nNo Patient Responsibility\nNo Eligible Charges\nTimely Filing\nGovernment Payer\nMissing Info EOB\nMissing Info Check Request Form\nPrimary Payer Denial\nDOS outside eligibility Period\nMissing Info Claim Form Provider\nMissing info Patient Receipt";
		String tri= TreatmentStatusRejectOptions().getText();
		System.out.println("Treatment Reject options I gave:" +trp);
		System.out.println("Treatment Reject options from screen:" +tri);
		
		if(TreatmentStatusRejectOptions().getText().equals(trp))
			
        {
        	TestBase.classAInstance.logReport("Pass","Treatment Reject options","Succesfully able to verify Treatment Reject options:" +trp);
		}
	   else
	   {
		    TestBase.classAInstance.logReport("Fail","Treatment Reject options","Failed to verify Treatment Reject options");
	   }	
		
//		assert tri==trp;
		
		Assert.assertEquals(tri,trp); 
		
    }
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForAdminReimbursement(List<String> testData, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
        CPTCodeDropdown().selectByVisibleText(testData.get(7));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursement(List<String> testData, String ReimbursementType, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Jcodedropdown().click();
        //   Thread.sleep(3000);
           JcodeOptionTwo().click();
        //   Thread.sleep(3000);
           NDCDropdown().click();
        //  Thread.sleep(3000);
           NDCDropdownOption().click();
        Quantity().sendKeys(testData.get(7));
        //    Thread.sleep(3000);
            Copay().clear();
            Copay().sendKeys(testData.get(8));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4711");
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
        
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursement(List<String> testData, int i, String caseType, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Jcodedropdown().click();
        //   Thread.sleep(3000);
        if((i==1) && caseType.equalsIgnoreCase("case5Drug"))
        {
           JcodeOptionTwo().click();
        }
        else if((i==2) && caseType.equalsIgnoreCase("case5Drug"))
        {
        	JcodeOptionThree().click();
        }
        else if(((i==1)||(i==2)) && caseType.equalsIgnoreCase("case5Admin"))
        {
        	JcodeOptionTwo().click();
  		}
        //   Thread.sleep(3000);
           NDCDropdown().click();
        //  Thread.sleep(3000);
           NDCDropdownOption().click();
        Quantity().sendKeys(testData.get(7));
        //    Thread.sleep(3000);
            Copay().clear();
            Copay().sendKeys(testData.get(8));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        if(((i==1)||(i==2)) && caseType.equalsIgnoreCase("case5Drug"))
        {
	       	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
        else if((i==1) && caseType.equalsIgnoreCase("case5Admin"))
        {
	       	CPTCodeDropdown().selectByVisibleText("");
        }
        else if((i==2) && caseType.equalsIgnoreCase("case5Admin"))
        {
        	CPTCodeDropdown().selectByVisibleText("");
        }
        
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForAdminReimbursementNoCPTCode(List<String> testData, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
     //   CPTCodeDropdown().selectByVisibleText(testData.get(7));
        CPTCodedropdownOption().click();
        CPTCodeDropdownNoCode().click();
        //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept(); //ACCEPT ACTION
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(20000);
 		
      
       
	}
	
	public boolean AddFaxForTreatment(String FaxType, String FaxStatus, String EOBStatus) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			aip.PatientSearchAutoSuggest().click();
	 		Thread.sleep(1000);
			
			aip.FaxType().selectByVisibleText(FaxType);
			aip.FaxStatus().selectByVisibleText(FaxStatus);
			aip.EOBStatus().selectByVisibleText(EOBStatus);
			Thread.sleep(1000);
			
			aip.UpdateButton().click();
			Thread.sleep(5000);
			
			Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
			
			//click on Process EOB button
			aip.ProcessEOBButton().click();
			Thread.sleep(5000);
			
			//Verify that the application has navigated to the Treatments tab of the patient
			Assert.assertTrue(TreatmentsTabOption().isDisplayed());
			
			return verify;
		}
		
		verify = false;
		return verify;
	}

	
	// DO NOT DELETE THE FOLLOWING METHOD
	
	
	public void AddFaxInformationAndTreatmentToEnrolledPatient(String MemberID, String FaxType, String FaxStatus, String EOBStatus, String PartnerPatientID, String PatientFirstName, String OutgoingFaxNumber, String InsuranceNameOnEOB, 
			String Quantity, String Copay, String BillingProviderName, String GroupPraticeName, String PhysicianLastName, String DateOfService, String EOBDate ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), MemberID);
 		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(FaxType);
		aip.FaxStatus().selectByVisibleText(FaxStatus);
		aip.EOBStatus().selectByVisibleText(EOBStatus);
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(OutgoingFaxNumber);
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+DateOfService);
		 DateOfService().click();
			String[] DS = DateOfService.split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(InsuranceNameOnEOB);
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOption().click();
        
        NDCDropdown().click();
     //   Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(Quantity);
        Copay().clear();
        Copay().sendKeys(Copay);
        
        //EOB Date
        EOBDate().click();
		String[] EBDate = EOBDate.split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(BillingProviderName);
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(GroupPraticeName);
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(PhysicianLastName);
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(8000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForRejectReason(List<String> testData, int i, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		TreatmentStatus().selectByVisibleText(testData.get(14));
		Thread.sleep(2000);
		RejectReasonDropdownOption().click();
		Thread.sleep(2000);
		RejectReasonDropdownNames(i).click();
		System.out.println("Rejection Reason#:"+i);
		System.out.println("Rejection Reason:"+RejectReasonDropdownNames(i).getText());
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
        Jcodedropdown().click();
     //   Thread.sleep(3000);
        JcodeOptionTwo().click();
     //   Thread.sleep(3000);
        NDCDropdown().click();
     //  Thread.sleep(3000);
        NDCDropdownOption().click();
        
        Quantity().sendKeys(testData.get(7));
    //    Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForAdminReimbursementForRejectReason(List<String> testData, int i , String TreatmentType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		TreatmentStatus().selectByVisibleText(testData.get(14));
		Thread.sleep(2000);
		RejectReasonDropdownOption().click();
		Thread.sleep(2000);
		RejectReasonDropdownNames(i).click();
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursementForRejectReason(List<String> testData, int i, String ReimbursementType, String TreatmentType ) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		TreatmentStatus().selectByVisibleText(testData.get(14));
		Thread.sleep(2000);
		RejectReasonDropdownOption().click();
		Thread.sleep(2000);
		RejectReasonDropdownNames(i).click();
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(9));
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {  
        	CPTCodeDropdown().selectByVisibleText(testData.get(25));
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
    	  Jcodedropdown().click();
          JcodeOptionTwo().click();
          //Thread.sleep(3000);
          NDCDropdown().click();
          //Thread.sleep(3000);
          NDCDropdownOption().click();
             
          Quantity().sendKeys(testData.get(7));
          //Thread.sleep(3000);
          Copay().clear();
          Copay().sendKeys(testData.get(8));
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursementNoCPTCode(List<String> testData, int i) throws InterruptedException, IOException, AWTException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
           Jcodedropdown().click();
           Thread.sleep(1000);
           JcodeOptionTwo().click();
           Thread.sleep(1000);
           NDCDropdown().click();
           Thread.sleep(1000);
           NDCDropdownOption().click();
           Quantity().sendKeys(testData.get(7));
           Thread.sleep(1000);
           Copay().clear();
           Copay().sendKeys(testData.get(8));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
        CPTCodeDropdown().selectByVisibleText("NoCode");
        if(i==1)//we are selecting ok in the alert pop up
        {
	      //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	       
	      //reporting
	        if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		     {
		    	TestBase.classAInstance.logReport("Pass","Pop up is displayed for No Code for CPTCode in BothReimbursement","Succesfully able to  VerifyPop up is displayed for No Code for CPTCode in BothReimbursement");
	        }
		     else
	  	     {
		    	TestBase.classAInstance.logReport("Fail","Pop up is displayed for No Code for CPTCode in BothReimbursement","Failed to  Verify Pop up is displayed for No Code for CPTCode in BothReimbursement");
		     } 
	        Thread.sleep(2000);
	        alert.accept(); //ACCEPT ACTION
	      //we cannot verify the data that the copay for Procedure changed to "0" nor the total reimbursement copay because whether there is non-zero value or not, the value attribute will always be '0'
	        
        }
        else if(i==2)
        {
        	//WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	      //reporting
	        if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		     {
		    	TestBase.classAInstance.logReport("Pass","Pop up is displayed for No Code for CPTCode in BothReimbursement","Succesfully able to  VerifyPop up is displayed for No Code for CPTCode in BothReimbursement");
		     }
		     else
	  	     {
		    	TestBase.classAInstance.logReport("Fail","Pop up is displayed for No Code for CPTCode in BothReimbursement","Failed to  Verify Pop up is displayed for No Code for CPTCode in BothReimbursement");
		     } 
	        Thread.sleep(2000);
	        
	        alert.dismiss(); //cancel ACTION
	      }
        
	    //    Thread.sleep(3000);
	        //EOB Date
	        EOBDate().click();
			String[] EBDate = testData.get(13).split("-");
	        String EBY = EBDate[2];
	        String EBM = EBDate[1];
	        String EBD = EBDate[0];
	
	        System.out.println(EBM);
	        System.out.println(EBD);
	        
	        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearEB.selectByValue(EBY);
	      //  Thread.sleep(3000);
	        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthEB.selectByVisibleText(EBM);
	      //  Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
	        for (WebElement col: columnsEB)
	        { 
	           if (col.getText().equals(EBD))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(EBD)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
	        
	        //Billing Provider search
	        BillingName().sendKeys(testData.get(9));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Practice Information
	        PracticeName().sendKeys(testData.get(10));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	        //Provider Information
	        PhysicianLastName().sendKeys(testData.get(11));
	        Thread.sleep(2000);
	        
	        SearchDisplayBox().click();
	        
	      //  Thread.sleep(5000);
	        AddButton().click();
	        Thread.sleep(15000);
        
	 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursementNoJCode(List<String> testData, int i, String ReimbursementType) throws InterruptedException, IOException, AWTException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
        
        Copay().clear();
        Copay().sendKeys(testData.get(8));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Jcodedropdown().click();
        //   Thread.sleep(3000);
        JcodeList().selectByVisibleText("NoCode");
        if(i==1)//we are selecting ok in the alert pop up
        {
	      //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        
	      //reporting
	        if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		     {
		    	TestBase.classAInstance.logReport("Pass","Pop up is displayed for No Code for JCode in BothReimbursement","Succesfully able to  VerifyPop up is displayed for No Code for JCode in BothReimbursement");
	        }
		     else
	  	     {
		    	TestBase.classAInstance.logReport("Fail","Pop up is displayed for No Code for JCode in BothReimbursement","Failed to  Verify Pop up is displayed for No Code for JCode in BothReimbursement");
		     } 
	        Thread.sleep(2000);
	        alert.accept(); //ACCEPT ACTION
	      //we cannot verify the data that the copay for Procedure changed to "0" nor the total reimbursement copay because whether there is non-zero value or not, the value attribute will always be '0'
	        
        }
        else if(i==2)
        {
        	//WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	      //reporting
	        if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		     {
		    	TestBase.classAInstance.logReport("Pass","Pop up is displayed for No Code for JCode in BothReimbursement","Succesfully able to  VerifyPop up is displayed for No Code for JCode in BothReimbursement");
		     }
		     else
	  	     {
		    	TestBase.classAInstance.logReport("Fail","Pop up is displayed for No Code for JCode in BothReimbursement","Failed to  Verify Pop up is displayed for No Code for JCode in BothReimbursement");
		     } 
	        Thread.sleep(2000);
	        alert.dismiss(); //cancel ACTION
	      }
        //   Thread.sleep(3000);
           NDCDropdown().click();
        //  Thread.sleep(3000);
           NDCDropdownOption().click();
        Quantity().sendKeys(testData.get(7));
        //    Thread.sleep(3000);
           
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4711");
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
        
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForMaxBenefitsExceeded(List<String> testData , String ReimbursementType) throws InterruptedException
	{
		String key = "ShipToAddressUpdateForCTM";
		String key1 = "ShipToAddressUpdateForCTP";
		int rowNum = etd.getKeyValuePair(key);
		int rowNum1 = etd.getKeyValuePair(key1);
		
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		//Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		//Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(1));
 	
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(9));
		aip.FaxStatus().selectByVisibleText(testData.get(10));
		aip.EOBStatus().selectByVisibleText(testData.get(11));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(7));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(13));
		 DateOfService().click();
			String[] DS = testData.get(13).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {
	        Copay_AdminReimbursement().clear();
	        Copay_AdminReimbursement().sendKeys(testData.get(9));
	        
	        CPTCodeDropdown().selectByVisibleText(testData.get(15));
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	  Jcodedropdown().click();
              JcodeOptionTwo().click();
              //Thread.sleep(3000);
              NDCDropdown().click();
              //Thread.sleep(3000);
              NDCDropdownOption().click();
                 
              Quantity().sendKeys(testData.get(15));
              //Thread.sleep(3000);
              Copay().clear();
              Copay().sendKeys(testData.get(9));
        }
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(14).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForMaxBenefitsExceededBothReimbursement(List<String> testData , String ReimbursementType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(4));
		aip.FaxStatus().selectByVisibleText(testData.get(5));
		aip.EOBStatus().selectByVisibleText(testData.get(6));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(7));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(13));
		 DateOfService().click();
			String[] DS = testData.get(13).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(9));
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {  
        	CPTCodeDropdown().selectByVisibleText(testData.get(15));
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
    	  Jcodedropdown().click();
          JcodeOptionTwo().click();
          //Thread.sleep(3000);
          NDCDropdown().click();
          //Thread.sleep(3000);
          NDCDropdownOption().click();
             
          Quantity().sendKeys(testData.get(15));
          //Thread.sleep(3000);
          Copay().clear();
          Copay().sendKeys(testData.get(9));
        
	        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(14).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForMaxBenefitsExceededRejectionLetter(List<String> testData , String ReimbursementType, String TreatmentType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(4));
		aip.FaxStatus().selectByVisibleText(testData.get(5));
		aip.EOBStatus().selectByVisibleText(testData.get(6));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(7));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(13));
		 DateOfService().click();
			String[] DS = testData.get(13).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {
	        Copay_AdminReimbursement().clear();
	        Copay_AdminReimbursement().sendKeys(testData.get(9));
	        
	        CPTCodeDropdown().selectByVisibleText(testData.get(25));
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	  Jcodedropdown().click();
              JcodeOptionTwo().click();
              //Thread.sleep(3000);
              NDCDropdown().click();
              //Thread.sleep(3000);
              NDCDropdownOption().click();
                 
              Quantity().sendKeys(testData.get(26));
              //Thread.sleep(3000);
              Copay().clear();
              Copay().sendKeys(testData.get(9));
        }
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(14).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForMaxBenefitsExceededRejectionLetterBothReimbursement(List<String> testData , String ReimbursementType, String TreatmentType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(4));
		aip.FaxStatus().selectByVisibleText(testData.get(5));
		aip.EOBStatus().selectByVisibleText(testData.get(6));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(7));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(13));
		 DateOfService().click();
			String[] DS = testData.get(13).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(8));
    //    Thread.sleep(3000);
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(9));
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {  
        	CPTCodeDropdown().selectByVisibleText(testData.get(25));
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
    	  Jcodedropdown().click();
          JcodeOptionTwo().click();
          //Thread.sleep(3000);
          NDCDropdown().click();
          //Thread.sleep(3000);
          NDCDropdownOption().click();
             
          Quantity().sendKeys(testData.get(26));
          //Thread.sleep(3000);
          Copay().clear();
          Copay().sendKeys(testData.get(9));
        
	        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(14).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(12));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentForZeroCopayClaimForBothReimbursement(List<String> testData , String ReimbursementType, String TreatmentType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(2));
		aip.FaxStatus().selectByVisibleText(testData.get(3));
		aip.EOBStatus().selectByVisibleText(testData.get(4));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(5));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(12));
		 DateOfService().click();
			String[] DS = testData.get(12).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
    //    Thread.sleep(3000);
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(8));
        if(ReimbursementType.equalsIgnoreCase("AdminReimbursement"))
        {  
        	CPTCodeDropdown().selectByVisibleText("AK4711");
        }
        else if(ReimbursementType.equalsIgnoreCase("DrugReimbursement"))
        {
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        }
    	  Jcodedropdown().click();
          JcodeOptionTwo().click();
          //Thread.sleep(3000);
          NDCDropdown().click();
          //Thread.sleep(3000);
          NDCDropdownOption().click();
             
          Quantity().sendKeys(testData.get(7));
          //Thread.sleep(3000);
          Copay().clear();
          Copay().sendKeys(testData.get(8));
        
	        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(9));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(10));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(11));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(30000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForEndToEndBothReimbursement(List<String> testData, String TreatmentType, String loginType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(4));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));
		 DateOfService().click();
			String[] DS = testData.get(5).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(6));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Quantity().sendKeys(testData.get(8));
        NDCList().selectByVisibleText(testData.get(9));
        if(loginType.equalsIgnoreCase("AdminReimbursement"))
        {
        	JcodeList().selectByVisibleText(testData.get(7));
        	
        	CPTCodeDropdown().selectByVisibleText(testData.get(11));
        }
        else if(loginType.equalsIgnoreCase("DrugReimbursement"))
        {
        	Jcodedropdown().click();
        	Thread.sleep(1000);
        	JcodeOptionTwo().click();
        	
        	CPTCodedropdownOption().click();
        	CPTCodedropdownOptionOne().click();
        	
        }
       
        
        // Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(testData.get(10));
        
        
            
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(12));
        
      
        
        
    //    Thread.sleep(3000);
        //EOB Date
        EOBDate().click();
		String[] EBDate = testData.get(13).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingName().sendKeys(testData.get(14));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(15));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(16));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	
	public void AddFaxInformationAndTreatmentToEnrolledPatientForBothReimbursement(List<String> testData, String TreatmentType, String Key, String loginType) throws InterruptedException
	{
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(2000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 //		Assert.assertEquals(aip.PartnerPatientID().getAttribute("value"), PartnerPatientID);
//		Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), PatientFirstName);
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(1));
		aip.FaxStatus().selectByVisibleText(testData.get(2));
		aip.EOBStatus().selectByVisibleText(testData.get(3));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
	//	Assert.assertEquals(((WebElement) PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(7));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(8));
		 DateOfService().click();
			String[] DS = testData.get(8).split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];

	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(9));
      //  Thread.sleep(3000);
      //  CPTCodeDropdown().selectByVisibleText(testData.get(7));
        Quantity().sendKeys(testData.get(5));
        NDCList().selectByVisibleText(testData.get(6));
        if(loginType.equalsIgnoreCase("AdminReimbursement"))
        {
        	JcodeList().selectByVisibleText("J1AK47");
        	
        	CPTCodeDropdown().selectByVisibleText("AK4711");
        }
        else if(loginType.equalsIgnoreCase("DrugReimbursement"))
        {
        	JcodeList().selectByVisibleText("J2AK47");
        	
        	CPTCodeDropdown().selectByVisibleText("AK4712");
        	
        }
       
        
        // Thread.sleep(3000);
        Copay().clear();
        Copay().sendKeys(testData.get(10));
        
        Copay_AdminReimbursement().clear();
        Copay_AdminReimbursement().sendKeys(testData.get(11));
        
        EOBDate().click();
		String[] EBDate = testData.get(4).split("-");
        String EBY = EBDate[2];
        String EBM = EBDate[1];
        String EBD = EBDate[0];

        System.out.println(EBM);
        System.out.println(EBD);
        
        Select YearEB = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearEB.selectByValue(EBY);
      //  Thread.sleep(3000);
        Select MonthEB = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthEB.selectByVisibleText(EBM);
      //  Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetEB = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsEB = dateWidgetEB.findElements(By.tagName("td"));
        for (WebElement col: columnsEB)
        { 
           if (col.getText().equals(EBD))
           {
           	System.out.println(col.getText());
              col.findElement(By.linkText(EBD)).click();
              break;
           }
        }
        Thread.sleep(2000);
        
        if(Key.equalsIgnoreCase("SelectBOFromDropdownForTreatmentForBothDrugReimbursement") || Key.equalsIgnoreCase("SelectBOFromDropdownForTreatmentForAdminDrugReimbursement"))
        {
	       //Select Billing Provider from dropdown
	        SelectBillingProviderDropdown().click();
	        SelectBillingProviderDropdownFirstValidOption().click();
        }
        else
        {
        	//Billing Provider search
            BillingName().sendKeys(testData.get(16));
            Thread.sleep(2000);
            SearchDisplayBox().click();
        }
        
        if(Key.equalsIgnoreCase("SelectGPFromDropdownForTreatmentForBothDrugReimbursement") || Key.equalsIgnoreCase("SelectGPFromDropdownForTreatmentForBothAdminReimbursement"))
        {
	       //Select Billing Provider from dropdown
	        SelectTreatingPracticeDropdown().click();
	        SelectTreatingPracticeDropdownFirstValidOption().click();
        }
        else
        {
        	//Practice Information
	        PracticeName().sendKeys(testData.get(12));
	        Thread.sleep(2000);
	        SearchDisplayBox().click();
        }
	        
       
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(13));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        }
        else if(TreatmentType.equalsIgnoreCase("ACH"))
        {
        	Assert.assertTrue(ACHRadioButton().isSelected());//we are just asserting because when we specify the BO for treatment addition, and if the checkbox is selected in BO for copay, then ACH is selected by default
        }
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(15000);
 		
      
       
	}
	
	public void AddFaxInformationAndTreatmentForShipToUpdate(List<String> testData, String TreatmentType, String Key, String ReimbursementType ) throws InterruptedException
	{
		String key = "ShipToAddressUpdateForCTM";
		String key1 = "ShipToAddressUpdateForCTP";
		int rowNum = etd.getKeyValuePair(key);
		int rowNum1 = etd.getKeyValuePair(key1);
		
		aip.PatientSearchAutoSuggest().click();
 		Thread.sleep(1000);
 		//Making sure the following fields are auto filled after clicking on the auto suggest
 		//Assert.assertEquals(aip.IncomingFaxMemberID().getAttribute("value"), testData.get(0));
 		//Assert.assertEquals(aip.FaxPatientFirstName().getAttribute("value"), testData.get(1));
 	
		
	//	Assert.assertEquals(aip.FaxPatientLastName().getAttribute("value"), PatientLastName);
		
		aip.FaxType().selectByVisibleText(testData.get(9));
		aip.FaxStatus().selectByVisibleText(testData.get(10));
		aip.EOBStatus().selectByVisibleText(testData.get(11));
		Thread.sleep(1000);
		
		aip.UpdateButton().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(aip.ProcessEOBButton().isDisplayed());
		
		//click on Process EOB button
		aip.ProcessEOBButton().click();
		Thread.sleep(5000);
		
		//Verify that the application has navigated to the Treatments tab of the patient
		Assert.assertTrue(TreatmentsTabOption().isDisplayed());
		
		//Assert.assertEquals((PatientStatus()).getAttribute("class"), "selects patient_status_disable");
		Assert.assertEquals(PatientStatusField().getAttribute("disabled"), "true");
		
		Assert.assertEquals(TreatmentStatus().getFirstSelectedOption().getText(), "Accepted"); 
		
		EOBFaxes().click();
		EOBFaxOptionToSelect().click();
		Thread.sleep(1000);
		//System.out.println("Outgoing fax num:"+OutgoingFaxNumber);
		OutgoingFaxNumber().click();
		OutgoingFaxNumber().sendKeys(testData.get(12));
		//Thread.sleep(10000);
		
		//date of service
		System.out.println("date of service from excel:"+testData.get(5));//DOS
		 DateOfService().click();
			cf.SelectDate(testData.get(13));
	        Thread.sleep(2000);
        
        InsuranceNameOnEOB().sendKeys(testData.get(14));
        
        if(ReimbursementType.equalsIgnoreCase("Drug Reimbursement"))
        {
	        Jcodedropdown().click();
	     //   Thread.sleep(3000);
	        JcodeOptionTwo().click();
	        
	        NDCDropdown().click();
	     //   Thread.sleep(3000);
	        NDCDropdownOption().click();
	        
	        Quantity().sendKeys(testData.get(15));
	        
	        System.out.println("Copay:"+testData.get(16));
	        Copay().clear();
	        Copay().sendKeys(testData.get(16));
        }
        else if(ReimbursementType.equalsIgnoreCase("Admin Reimbursement"))
        {
        	  CPTCodeDropdown().selectByVisibleText(testData.get(6));
              Copay_AdminReimbursement().clear();
              Copay_AdminReimbursement().sendKeys(testData.get(11));
        }
        
        
        //EOB Date
        EOBDate().click();
		cf.SelectDate(testData.get(17));
        Thread.sleep(2000);
        
        //Billing Provider search
        BillingContactLastName().sendKeys(testData.get(18));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Practice Information
        PracticeName().sendKeys(testData.get(19));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
        
        //Provider Information
        PhysicianLastName().sendKeys(testData.get(20));
        Thread.sleep(2000);
        
        SearchDisplayBox().click();
         
        if(TreatmentType.equalsIgnoreCase("CTM"))
        {
        //Now select Check in Confirm Payment Information
        	CheckRadioButton().click();
        	ShipToAddressYesCheckbox().click();
        	Thread.sleep(2000);
        	//Now enter the new ship to address update values
        	
        //	PayeeName().clear();
        //	PayeeName().sendKeys(testData.get(3));
        	
        	PayeeAddress().clear();
        	PayeeAddress().sendKeys(testData.get(4));
        	
        	PayeeAddress2().clear();
        	PayeeAddress2().sendKeys(testData.get(5));
        	
        	PayeeCity().clear();
        	PayeeCity().sendKeys(testData.get(6));
        	
        	int stateNum = cf.SelectRandomState(PayeeStatesList());
        	System.out.println("StateNum:"+stateNum);
        	PayeeStatesList().get(stateNum).click();
        	
        	String statename = PayeeState().getFirstSelectedOption().getText();
        	reader.setDataInNewRow("Regression", "State", rowNum, statename);
        	
        	PayeeZip().click();
            Thread.sleep(2000);
      
            for(int i=1;i<=5;i++)
            {
            	PayeeZip().sendKeys(Keys.BACK_SPACE);
            	Thread.sleep(2000);
            }
            Thread.sleep(2000);
        	
        	PayeeZip().sendKeys(testData.get(7));
        	Thread.sleep(1000);
        	
        	
        	PayeePhone().click();
            Thread.sleep(2000);
       
            for(int i=1;i<=10;i++)
            {
            	PayeePhone().sendKeys(Keys.BACK_SPACE);
            	Thread.sleep(2000);
            }
            Thread.sleep(2000);
        	
        	PayeePhone().sendKeys(testData.get(8));
        	  Thread.sleep(2000);
        	
        	
        }
        else if(TreatmentType.equalsIgnoreCase("CTP"))
        {
        	CheckRadioButton().click();
        	PatientRadioButton().click();
        	
        	ShipToAddressYesCheckbox().click();
        	Thread.sleep(2000);
        	//Now enter the new ship to address update values
        	
        	PayeeName().clear();
        	PayeeName().sendKeys(testData.get(3));
        	
        	PayeeAddress().clear();
        	PayeeAddress().sendKeys(testData.get(4));
        	
        	PayeeAddress2().clear();
        	PayeeAddress2().sendKeys(testData.get(5));
        	
        	PayeeCity().clear();
        	PayeeCity().sendKeys(testData.get(6));
        	
        	int stateNum = cf.SelectRandomState(PayeeStatesList());
        	PayeeStatesList().get(stateNum).click();
        	
        	String statename = PayeeState().getFirstSelectedOption().getText();
        	reader.setDataInNewRow("Regression", "State", rowNum1, statename);
        	
        	
        	PayeeZip().click();
            Thread.sleep(2000);
      
            for(int i=1;i<=5;i++)
            {
            	PayeeZip().sendKeys(Keys.BACK_SPACE);
            	Thread.sleep(2000);
            }
            Thread.sleep(2000);
        	
        	PayeeZip().sendKeys(testData.get(7));
        	Thread.sleep(1000);
        	
        	
        	PayeePhone().click();
            Thread.sleep(2000);
        /*    PatientAndCardTabZip().sendKeys(Keys.CLEAR);
            Thread.sleep(2000);
            PatientAndCardTabZip().click();
            Thread.sleep(2000); */
            for(int i=1;i<=10;i++)
            {
            	PayeePhone().sendKeys(Keys.BACK_SPACE);
            	Thread.sleep(2000);
            }
            Thread.sleep(2000);
        	
        	PayeePhone().sendKeys(testData.get(8));
        	  Thread.sleep(2000);
        }
        
        
      //  Thread.sleep(5000);
        AddButton().click();
        Thread.sleep(8000);
 		
       
        
       
	}
	
	
}
