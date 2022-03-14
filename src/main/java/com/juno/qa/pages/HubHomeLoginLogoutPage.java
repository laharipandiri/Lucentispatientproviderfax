package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.juno.qa.base.TestBase;
import com.juno.qa.getandsetTestData.GetAndSetTestData;
import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class HubHomeLoginLogoutPage extends TestBase {

	// Patient Portal Page Objects
	String uname = prop.getProperty("HCPusername");
	String pwd = prop.getProperty("HCPpassword").trim();
	String tit = prop.getProperty("ExpectedHCPPageTitle");

	String unamePatient = prop.getProperty("Patientusername");
	String pwdPatient = prop.getProperty("Patientpassword").trim();
	
	GetAndSetTestData gst = new GetAndSetTestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();

	public HubHomeLoginLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	/* Hub Portal Login Page - page objects */
	
	public WebElement UserID() // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='username']"));
	}
	public WebElement Password()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='password']"));
	}

	public WebElement SubmitButton()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
	}
	
	public WebElement UserMenuButton()  // External Portal
	{
		return driver.findElement(By.cssSelector(".mat-menu-trigger"));
	}
	
	public String UnsuccessfulLoginMsg() // External Portal
	
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Incorrect username or password. Please try again or call (855) 965-2472 for assitance.')]")).getText();
	}
	
	public WebElement PatientSearch()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patient Search')]"));
	}
	public WebElement SearchByMemberID()  // External Portal
	{System.out.println("Inside Member ID");
		//return driver.findElement(By.id("mat-input-5")); updated on1082021
		//return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-search/form/div/mat-form-field[4]/div/div[1]/div[3]"));
		return driver.findElement(By.xpath("//input[@formcontrolname='memberId']"));
	}
	
	public WebElement SearchButton()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Search')]//ancestor::button"));
	}
	public WebElement SearchPatientName()  // External Portal
	{System.out.println("Click on Patient Name");
		//return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-search/div/app-patient-search-table/div/table/tbody/tr[1]/td[1]"));
		//return driver.findElement(By.xpath("//app-patient-search/div/app-patient-search-table/div/table/tbody/tr[1]/td[1]"));
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/view-patient')]"));
	}										
	
	public WebElement SearchFullName()  // External Portal
	{	
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-viewer/app-patient-info/mat-card[1]/mat-card-content/div[1]/div[1]/div[2]"));
	}
	
	public WebElement SearchDOB()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-viewer/app-patient-info/mat-card[1]/mat-card-content/div[1]/div[2]/div[2]"));
	}
	public WebElement SearchPhoneNumber()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-viewer/app-patient-info/mat-card[1]/mat-card-content/div[2]/div[2]/div[1]/div/div[2]"));
	}
	public WebElement SearchByMemberId()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-input-5']"));
	}
	
	public WebElement SearchButtonMemberId()  // External Portal
	{
		return driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr[1]/td[3]/span"));
	}
	
	public WebElement ViewPatientLink()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(@href,'view-patient')]"));
	}
	
	public WebElement UpdatePatientDetailsLink()  // External Portal
	{
		return driver.findElement(By.xpath("//*[text()='Update Patient Details']"));
	}
	
	public WebElement PopUpCloseBttn()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Close')]"));
	}
	
	public WebElement Address2TextBox()  // External Portal
	{
		return driver.findElement(By.id("mat-input-9"));
	}
	
	public WebElement SaveButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[text()='Save']"));
	}
	
	public WebElement PopUpWithMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[text()='Are you sure, you want to save changes?']"));
	}
	
	public WebElement OKButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'OK')]"));
	}
	
	public WebElement SavedSuccessfullyMsg()  // External Portal
	{
		return driver.findElement(By.xpath("//*[text()='Patient's info saved successfully.']"));
	}
	
	public WebElement UploadDocumentLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Upload Document')]"));
	}
	public WebElement ResetButton()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Reset')]"));
		
	}
	public WebElement SearchTable()  // External Portal
	{
		return driver.findElement(By.xpath("//app-patient-search-table"));
	}
	
	public WebElement ProgramDetailsDropDown()  // External Portal
	{
		//return driver.findElement(By.xpath("//div[contains(text(),'Program Details')]"));
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[4]/div/strong")); //updated 8/30/2021
		//return driver.findElement(By.xpath("//app-nav-list/div/ul/li[2]/div/strong")); updated on 10112021
		//*[@id="font-size-control"]/app-layout/div/div[1]/div/div[1]/app-nav-list/div/ul/li[2]/div/strong
		
		
	}
	public WebElement HCPProgramDetailsDropDown()  // External Portal
	{
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[2]/div/strong")); //updated on 10122021
	}
	public WebElement HCPUsingProgramLink()  // External Portal
	{
			return driver.findElement(By.xpath("//a[contains(@href,'/hcp/using-the-card')]"));
	}
	
	public WebElement HCPOfferingEligibility()  // External Portal
	{
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/eligibility')]"));
	}
	
	public WebElement HCPTermsAndConditions()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Terms and Conditions')]"));updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/terms-and-conditions')]"));
	}
	
 
	public WebElement UsingProgramLink()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Using the Program')]")); updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'/using-the-card')]"));
	}
	
	public WebElement OfferingEligibility()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Offering/Eligibility')]")); updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'/eligibility')]"));
	}
	
	public WebElement TermsAndConditions()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Terms and Conditions')]"));updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'/terms-and-conditions')]"));
	}
	
	public WebElement FormsLink()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Forms')]")); //updated on 8112021
		//return driver.findElement(By.xpath("//app-nav-list/div/ul/li[3]/a/span/strong")); //updated 8/30/2021
		//return driver.findElement(By.xpath("//app-nav-list/div/ul/li[3]/a")); updated 10112021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[5]/a"));
	}
	
	public WebElement HCPFormsLink()  // External Portal
	{
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[3]/a")); //updated 10112021
	}
	public WebElement FormsLinkHCP()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Forms')]")); //updated on 8112021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[3]/a/span/strong")); 
			
	}
	public WebElement DashboardLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
	}
	
	public String GetFieldValueAfterEnrolment(String fieldName) {
		return driver.findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]/parent::p")).getText().split(":")[1].trim();
	}
	
	public WebElement ProfileLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Profle')]"));
	}
	public WebElement ActivityLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Activity')]"));
	} 
	
	public WebElement MessagesLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Messages')]"));
	}
	
	public WebElement ProviderInfrLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Provider Information')]"));
	}
	
	public WebElement ProviderProfileLink()  // External Portal
	{
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/profile')]"));
	}
	
	public WebElement PracticeName()  // External Portal
	{
		return driver.findElement(By.xpath("/html/body/app-root/div/app-layout/div/div[1]/div/div[2]/div/app-hcp-profile/mat-card/mat-card-content/form/div[1]/mat-form-field[1]/div/div[1]/div[3]/input"));
		
		
	}
	public WebElement PracticeCity()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-input-10']"));
	}
	public WebElement Whole()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-hcp-profile/mat-card/mat-card-content/form"));
	}
	
	
	public WebElement ProviderProfileAddress()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='address1']"));
		//return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-hcp-profile/mat-card/mat-card-content/form/div[2]/mat-form-field[1]/div/div[1]/div[3]"));
		
	}
	
	public WebElement ProviderProfileUpdate()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Update')]//ancestor::button"));
	}
	public WebElement PatientsLink()  // External Portal
	{
		//return driver.findElement(By.xpath("//div[contains(text(),'Patient')]"));//updated 8122021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[5]/div/strong"));
		
	}
	public WebElement EnrollLink()  // External Portal
	{
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/enroll/select')]"));
		
	}
	
	public WebElement PatientSearchLink()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Patient Search')]"));
	}
	public WebElement HCPPatientSearchLink()  // External Portal
	{
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/patient-search')]"));
	}
	
	
	public WebElement ReportsLink()  // External Portal
	{
		//return driver.findElement(By.xpath("//div[contains(text(),'Reports')]"));//updated 8122021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[6]/div/strong"));
	}
	public WebElement PaymentReportLink()  // External Portal
	{
			//return driver.findElement(By.xpath("//span[contains(text(),'Payment Report')]")); updated 1062021
		return driver.findElement(By.xpath("//a[contains(@href,'/hcp/payment-report')]"));
	}
	
	public WebElement PaymentReportLinkSearchButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-payment-report/div/form/button/span[1]"));
	}
	
	public WebElement PaymentReportLinkSortByDate()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/app-check/div[2]/table/thead/tr/th[4]/div"));
	}
	
	
	public static List<WebElement> NumOfRowsPayment() 
	{
		List<WebElement> noofRows = driver.findElements(By.xpath("//*[@id='mat-tab-content-0-0']/div/app-check/div[2]/table/tbody/tr"));
		return noofRows;
	}
	
	public WebElement PaymentReportBody()  // External Portal
	{
		//return driver.findElement(By.xpath("//h2[contains(text(),'Payment Report')]")); //updated 1012021
		return driver.findElement(By.xpath("//*[contains(text(),'Payment Report')]"));	
		}
	
	public WebElement PaymentReportTableBody()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/app-check/div[2]/table"));
	}
	
	
	public WebElement UsingProgramBody()  // External Portal
	{
		return driver.findElement(By.className("using-hcp"));
	}
	
	public WebElement UsingProgramPatientBody()  // External Portal
	{
		//return driver.findElement(By.className("using-the-program")); //updated 8/30/2021
		return driver.findElement(By.className("using"));
		
	}
	public WebElement OfferingEligibilityBody()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='provider-eligibility']/h2"));
		
	}
	
	public WebElement OfferingEligibilityPatientBody()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='patient-eligibility']/h2")); //updated 8/30/2021
		return driver.findElement(By.xpath("//*[@id='provider-eligibility']/h2"));		
	}
	
	public WebElement TermsAndConditionsBody()  // External Portal
	{
		//return driver.findElement(By.xpath("//app-static-content/div/h2[1]")); updated 10112021
		return driver.findElement(By.xpath("//app-static-content/div/div/h1[1]"));
		
	}
	
	public WebElement FormsBody()  // External Portal
	{
		return driver.findElement(By.xpath("//h2[contains(text(),'Downloadable Forms')]"));
																 
	}
	
	public WebElement ProviderProfileBody()  // External Portal
	{
		return driver.findElement(By.xpath("//app-hcp-profile/mat-card"));
	}
	
	public WebElement EnrollBody()  // External Portal
	{
		//return driver.findElement(By.xpath("//h2[contains(text(),'Identify Yourself')]")); //updated 7/26/2021
		//*[@id="cdk-step-content-0-0"]/app-identify/div/label/span
		return driver.findElement(By.xpath("//p[contains(text(),'Please select the OPHTHALMOLOGY brand below to begin the enrollment process on behalf of your patient:')]"));
	}
	public WebElement EnrollBodyPatient()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Apply for the Genentech Ophthalmology Co-pay Program')]"));
	}
	
	public WebElement PatientSearchBody()  // External Portal
	{
		return driver.findElement(By.xpath("//h2[contains(text(),'Patient Search')]"));
	}
	
	
	public WebElement EFTCheckBody()  // External Portal
	{
		return driver.findElement(By.xpath("//h2[contains(text(),'EFT/Check Reports')]"));
	}
	
	public WebElement Home()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Home')]")); //updated 8112021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[1]/a/span/strong"));
	}
	
	public WebElement EnrollButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Enroll')]")); updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'enroll/select')]"));
		
	}
	public WebElement ApplyNowButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'APPLY NOW')]"));
	}
	
	
	public WebElement BrandButton()  // External Portal
	{System.out.println("I am inside Susvimo Brand Button");
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-select-brand/div/div[2]/button/span[1]/strong"));
	}
	
	public WebElement LucentisBrandButton()  // External Portal
	{System.out.println("I am inside Lucentis Brand Button");
//		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-select-brand/div/div[2]/button/span[1]/strong"));
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-select-brand/div/div[3]/button/span[1]/strong"));//updated after 2.0
									
	}
	public WebElement SusvimoBrandButton()  // External Portal
	{
		System.out.println("I am inside Susvimo Brand Button");
		return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-select-brand/div/div[2]/button/span[1]/strong"));//updated after 2.0
									
	}

	public WebElement PatientRadioButton()  // External Portal
	{
//		return driver.findElement(By.id("mat-radio-2"));
		return driver.findElement(By.xpath("//*[@id=\"mat-radio-2\"]/label/div[1]/div[1]")); //updated for 2.0
	}
	
	public WebElement LAPRadioButton()  // External Portal
	{
		return driver.findElement(By.id("mat-radio-3"));
	}
	
	public WebElement PatientRadioNextButton()  // External Portal
	{
		return driver.findElement(By.xpath(" //*[@id=\"cdk-step-content-0-0\"]/form/app-identify/div/div/button"));
		//*[@id="cdk-step-content-0-1"]/app-support-option/div/div[2]/div[2]/button[2]
	}
	public WebElement NewPatientNORadioButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='mat-radio-6']/label"));//updated on 10/4/2021
		return driver.findElement(By.xpath("//*[@id='mat-radio-8']/label")); //updated on 10/7/2021 //updated back on 10152021
	
	}
	public WebElement HCPNewPatientNORadioButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-6']/label"));//updated on 10/19/2021
	}
	public WebElement NewPatientYESRadioButton()  // External Portal
	{
		System.out.println("I am inside PatientYESRadioButton");
		return driver.findElement(By.xpath("//*[@id='mat-radio-7']/label"));//updated on 10/19/2021
		
		

	}
	public WebElement ExistingMemberID()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='memberId']"));//updated on 10/19/2021
		
	}
	public WebElement ExistingDOB()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='dobOne']"));//updated on 10/19/2021

	}
	public WebElement ExistingMemberIDSubmitButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']/form/app-support-option/div/div[2]/div/button/span[1]"));
			
	}
	
	
	
	public WebElement LucentisCheckBox()  // External Portal
	{
		//*[@id="mat-checkbox-4"]/label/div
		return driver.findElement(By.id("mat-checkbox-4"));
		
		//return driver.findElement(By.xpath("//*[@id='mat-checkbox-6']/label"));
	}
	
	public WebElement OphthalmologyCheckBoxtButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-checkbox-5']/label/div"));
	}
	
	public WebElement LAPLucentisCheckBox()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-checkbox-5']/label"));
	}
	
	public WebElement LucentisCheckBoxNextButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']/form/app-support-option/div/div[2]/div[2]/button[2]/span[1]"));
			
	}
	public WebElement SusvimoCheckBoxNextButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']/form/app-support-option/div/div[2]/div[2]/div/div[2]/button[2]"));
			
	}
	
	
	public WebElement data()  // External Portal
	{
		return driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div[1]/div/div[2]/div/app-enrollment/div/h2/span"));
	}
	
	
	//Lucentis Questions
		public WebElement LucentisQuestion1()  // External Portal
		{
			System.out.println("inside Lucentis question1");
			boolean ati= driver.findElement(By.xpath("//*[@id='mat-radio-42']/label")).isDisplayed();
			System.out.println("UUUUUUUU" +ati);
			return driver.findElement(By.xpath("//*[@id='mat-radio-42']/label")); //updated for 2.0
			
		}
		public WebElement LucentisQuestion2()  // External Portal
		{
			System.out.println("inside Lucentis question2");
			return driver.findElement(By.xpath("//*[@id='mat-radio-13']/label")); //updated for 2.0
		}
		public WebElement LucentisQuestion3()  // External Portal
		{
			System.out.println("inside Lucentis question3");
			return driver.findElement(By.xpath("//*[@id='mat-radio-16']/label"));//updated for 2.0
		}
		public WebElement LucentisQuestion4()  // External Portal
		{
			System.out.println("inside Lucentis question4");
			return driver.findElement(By.xpath("//*[@id='mat-radio-24']/label"));  //updated for 2.0
		}
		public WebElement LucentisQuestion5()  // External Portal
		{
			System.out.println("inside Lucentis question5");
			return driver.findElement(By.xpath("//*[@id='mat-radio-28']/label"));//updated for 2.0
		}
		public WebElement Question6DropDownSelect()  // External Portal
		{
			System.out.println("I am inside Lucentis Question6DropDownSelect");
			//return driver.findElement(By.xpath("//*[@id='mat-select-16']/div/div[2]"));//updated for admin/HCP //updated 10152021
			return driver.findElement(By.xpath("//*[@id='mat-select-18']/div/div[2]")); //updated for 2.0
		}
		public WebElement Question6select()  // External Portal
		{
			System.out.println("I am inside Lucentis Question6select");
			return driver.findElement(By.xpath("//*[@id='mat-option-380']/span")); //updated for 2.0
		
			
		}
		
		public WebElement LucentisQuestion7()  // External Portal
		{
			System.out.println("inside Lucentis question7");
			return driver.findElement(By.xpath("//*[@id='mat-radio-46']/label"));//updated for 2.0
		}
		public WebElement LucentisQuestion8()  // External Portal
		{
			System.out.println("inside Lucentis question8");
			return driver.findElement(By.xpath("//*[@id='mat-radio-34']/label")); //updated for 2.0
		}
		public WebElement LucentisQuestion9()  // External Portal
		{
			System.out.println("inside Lucentis question9");
			return driver.findElement(By.xpath("//*[@id='mat-radio-36']/label")); //updated for 2.0
		}
		
		public WebElement LucentisQuestion10()  // External Portal
		{
			System.out.println("inside Lucentis question 10");
			return driver.findElement(By.xpath("//*[@id='mat-radio-48']/label")); //updated for 2.0
		}
		
	
	
	
	public WebElement Question1()  // External Portal
	{
		System.out.println("inside question1");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-39']/label")); //updated for admin/HCP updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-38']/label"));
	}
	public WebElement HCPQuestion1()  // External Portal
	{
		System.out.println("inside question1");
		return driver.findElement(By.xpath("//*[@id='mat-radio-36']/label"));
	}
	public WebElement AddingSusvimoQuestion1()  // External Portal
	{
		System.out.println("inside question1");
		return driver.findElement(By.xpath("//*[@id='mat-radio-38']/label"));
	}
	public WebElement LucentisHCPQuestion1()  // External Portal
	{
		System.out.println("inside question1");
		return driver.findElement(By.xpath("//*[@id='mat-radio-40']/label"));
	}
	
	
	
	public WebElement Question2() throws InterruptedException  // External Portal
	{	Thread.sleep(4000);
		System.out.println("I am inside question2");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-42']")); //updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-11']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-13']/label")); 
	
	}
	public WebElement HCPQuestion2() throws InterruptedException  // External Portal
	{	
		System.out.println("I am inside question2");
		return driver.findElement(By.xpath("//*[@id='mat-radio-11']/label")); //updated 10192021
	}
	
	
	public WebElement AddingSusvimoQuestion2()  // External Portal
	{
		System.out.println("inside question2");
		return driver.findElement(By.xpath("//*[@id='mat-radio-13']/label"));
	}
	
	public WebElement Question3() throws InterruptedException  // External Portal
	{ Thread.sleep(4000);
	System.out.println("I am inside question3");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-45']/label/div[2]")); //updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-14']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-16']/label")); 
	}
	public WebElement HCPQuestion3() throws InterruptedException  // External Portal
	{ 
		System.out.println("I am inside question3");
		return driver.findElement(By.xpath("//*[@id='mat-radio-14']/label")); //updated 10192021
	}
	//*[@id="mat-radio-14"]/label
	
	
	public WebElement AddingSusvimoQuestion3()  // External Portal
	{
		System.out.println("inside question3");
		return driver.findElement(By.xpath("//*[@id='mat-radio-16']/label"));
	}
	
	public WebElement Question4()  // External Portal
	{System.out.println("I am inside question4");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-52']/label"));//updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-21']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-20']/label"));
	}
	public WebElement HCPQuestion4()  // External Portal
	{	System.out.println("I am inside question4");
		return driver.findElement(By.xpath("//*[@id='mat-radio-18']/label"));
	} //*[@id="mat-radio-22"]/label
	
	public WebElement LucentisHCPQuestion4()  // External Portal
	{	System.out.println("I am inside question4");
		return driver.findElement(By.xpath("//*[@id='mat-radio-22']/label"));
	} 
	
	public WebElement AddingSusvimoQuestion4()  // External Portal
	{
		System.out.println("inside question4");
		return driver.findElement(By.xpath("//*[@id='mat-radio-20']/label"));  
	}
	
	public WebElement Question5()  // External Portal
	{System.out.println("I am inside question5");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-56']/label"));//updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-25']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-24']/label"));
	}
	
	public WebElement HCPQuestion5()  // External Portal
	{	System.out.println("I am inside question5");
		return driver.findElement(By.xpath("//*[@id='mat-radio-22']/label"));
	}//*[@id="mat-radio-26"]/label
	
	public WebElement LucentisHCPQuestion5()  // External Portal
	{	System.out.println("I am inside question5");
		return driver.findElement(By.xpath("//*[@id='mat-radio-26']/label"));
	}
	
	public WebElement AddingSusvimoQuestion5()  // External Portal
	{
		System.out.println("inside question5");
		return driver.findElement(By.xpath("//*[@id='mat-radio-24']/label"));  
	}
	
	
	public WebElement LAPQuestion6DropDownSelect()  // External Portal
	{
		System.out.println("I am inside Question6DropDownSelect");
		return driver.findElement(By.xpath("//*[@id='mat-select-20']/div/div[2]")); 
	}
	public WebElement HCPQuestion6DropDownSelect()  // External Portal
	{	System.out.println("I am inside Question6DropDownSelect");
		return driver.findElement(By.xpath("//*[@id='mat-select-16']/div/div[2]"));//updated 10192021
	}
	
	
	public WebElement LAPQuestion6select()  // External Portal
	{
		System.out.println("I am inside Question6select");
		return driver.findElement(By.xpath("//*[@id='mat-option-438']/span")); //updated for admin/HCP  
	}

	public WebElement HCPQuestion6select()  // External Portal
	{	System.out.println("I am inside Question6select");
		return driver.findElement(By.xpath("//*[@id='mat-option-275']/span")); //updated for admin/HCP
	}
	
	public WebElement AddingSusvimoQuestion6DropDownSelect()  // External Portal
	{System.out.println("I am inside Question6DropDownSelect");
		return driver.findElement(By.xpath("//*[@id='mat-select-18']/div/div[2]")); 
	}
	
	public WebElement AddingSusvimoQuestion6select()  // External Portal
	{	System.out.println("I am inside Question6select");
		return driver.findElement(By.xpath("//*[@id='mat-option-382']/span")); //updated for admin/HCP
		
	}
	public WebElement Question7()  // External Portal
	{System.out.println("I am inside Question7");
		//return driver.findElement(By.xpath("//*[@id='mat-radio-59']/label")); //updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-43']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-42']/label")); 
	}
	
	public WebElement HCPQuestion7()  // External Portal
	{	System.out.println("I am inside Question7");
		return driver.findElement(By.xpath("//*[@id='mat-radio-40']/label")); 
	}
	//*[@id="mat-radio-44"]/label
	
	public WebElement LucentisHCPQuestion7()  // External Portal
	{	System.out.println("I am inside Question7");
		return driver.findElement(By.xpath("//*[@id='mat-radio-44']/label")); 
	}

	public WebElement AddingSusvimoQuestion7()  // External Portal
	{
		System.out.println("inside question7");
		return driver.findElement(By.xpath("//*[@id='mat-radio-42']/label"));   //*[@id="mat-radio-42"]/label
	}
	public WebElement AddingSusvimoQuestion8()  // External Portal
	{
		System.out.println("inside question8");
		return driver.findElement(By.xpath("//*[@id='mat-radio-30']/label"));   //*[@id="mat-radio-30"]/label
	}
	public WebElement AddingSusvimoQuestion9()  // External Portal
	{
		System.out.println("inside question9");
		return driver.findElement(By.xpath("//*[@id='mat-radio-32']/label"));    //*[@id="mat-radio-32"]/label
	}
	public WebElement AddingSusvimoQuestion10()  // External Portal
	{
		System.out.println("inside question10");
		return driver.findElement(By.xpath("//*[@id='mat-radio-44']/label"));  //*[@id="mat-radio-44"]/label
	}
	public WebElement Question8()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='mat-radio-62']/label")); //updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-31']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-30']/label")); 
	}
	public WebElement HCPQuestion8()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-28']/label"));
	}
	
	
	public WebElement LucentisHCPQuestion8()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-32']/label"));
	}
	public WebElement Question9()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='mat-radio-64']/label"));//updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-33']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-32']/label"));
	}
	public WebElement HCPQuestion9()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-30']/label"));
	} //*[@id="mat-radio-34"]/label
	
	public WebElement LucentisHCPQuestion9()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-34']/label"));
	} //*[@id="mat-radio-34"]/label
	public WebElement Question10()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='mat-radio-67']/label"));//updated for admin/HCP 1082021
		//return driver.findElement(By.xpath("//*[@id='mat-radio-45']/label")); //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-radio-44']/label"));
	}
	public WebElement HCPQuestion10()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-42']/label"));
	} //*[@id="mat-radio-46"]/label
	
	public WebElement LucentisHCPQuestion10()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-46']/label"));
	} //*[@id="mat-radio-46"]/label
	public WebElement Question11()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-radio-70']/label"));//updated for admin/HCP
		
	}
	public WebElement EligibilityNextButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/form/app-eligibility/div[2]/button/span[1]")); updated 1082021
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/form/app-eligibility/form/div/button"));
		
	}
	
	public WebElement PIFirstName()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-6")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
		
	}
	
	public WebElement LAPPIFirstName()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
	}
	
	public WebElement LAPPILastName()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
	}
	public WebElement LAPPIAddress()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='address1']"));
	}
	public WebElement LAPPICity()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='city']"));
	}
	
	public WebElement LAPPIFirstNameForPatient()  // External Portal
	{
		return driver.findElement(By.id("mat-input-2"));
	}
	
	public WebElement LAPPILastNameForPatient()  // External Portal
	{
		return driver.findElement(By.id("mat-input-3"));
	}
	public WebElement LAPPIAddressSameCheckBox()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-checkbox-4']/label/span"));
	}
	
	public WebElement PILastName()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-7")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
	}
	public WebElement PIGenderSelect()  // External Portal
	{
		//*[@id="mat-select-0"]/div/div[2]	
		//return driver.findElement(By.xpath("//*[@id='mat-select-2']/div/div[2]")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//*[@id='mat-select-0']/div/div[2]"));
		//*[@id="mat-select-2"]/div/div[2]
	
	}
	
	public WebElement HCPPIGenderSelect()  // External Portal
	{ 
		return driver.findElement(By.xpath("//*[@id='mat-select-2']/div/div[2]")); //updated 10192021
	}
	public WebElement PIGenderSelectFemale()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Female')]//ancestor::mat-option"));
		//*[@id="mat-option-0"]/span
	}
	
	public Select PIGender()
	{
		Select PIGender = new Select(driver.findElement(By.xpath("//*[@id='mat-select-2-panel']"))); //updated for admin/HCP
		return PIGender;
	}
	
	public WebElement PIGenderSelection()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-option-29']/span"));
	}
	public WebElement PIBirthDate()  // External Portal
	{
		//return driver.findElement(By.xpath("//input[@data-mat-calendar='mat-datepicker-1']")); //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='dob']"));
		
	}
	public WebElement PIAddress1()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-9")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='address1']"));
	}
	public WebElement PICity()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-11"));//updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='city']"));
	}
	public WebElement PIStateSelect()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-select-4']/div/div[2]")); //updated for admin/HCP
	}
	public WebElement PIStateAlaska()  // External Portal
	{System.out.println("I am insied PIStateAlaska");
		return driver.findElement(By.xpath("//span[contains(text(),'Alaska')]//ancestor::mat-option"));
	}
	
	
	public WebElement PIZipCode()  // External Portal
	{System.out.println("I am insied PIZipCode");
		//return driver.findElement(By.id("mat-input-12")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='postalCode']"));
	}
	public WebElement PIPhoneNumber()  // External Portal
	{System.out.println("I am insied PIPhoneNumber");
		//return driver.findElement(By.id("mat-input-13")); //updated for admin/HCP //updated 10152021
		return driver.findElement(By.xpath("//input[@formcontrolname='homePhone']"));
	}
	
	public WebElement PIInsuranceCompanyNameSelect()  // External Portal
	{System.out.println("I am insied PIInsuranceCompanyNameSelect");
		//return driver.findElement(By.xpath("//*[@id='mat-select-6']/div/div[2]")); //updated for admin/HCP
		return driver.findElement(By.xpath("//*[@id='mat-select-4']/div/div[2]")); //updated 10182021
	
		//return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-3']/form/app-patient-information/mat-card[2]/mat-card-content/div[1]/mat-form-field[1]/div/div[1]/div[3]"));
		//*[@id="mat-select-6"]/div/div[2]
	}
	public WebElement HCPPIInsuranceCompanyNameSelect()  // External Portal
	{System.out.println("I am insied HCPPIInsuranceCompanyNameSelect");
		return driver.findElement(By.xpath("//*[@id='mat-select-6']/div/div[2]")); //updated for admin/HCP
	}
	public WebElement PIInsuranceCompanyNameAllianceHealth()  // External Portal
	{
		System.out.println("I am insied PIInsuranceCompanyNameAllianceHealth");
		return driver.findElement(By.xpath("//span[contains(text(),'Alliance Health')]//ancestor::mat-option")); //updated 10172021
		//return driver.findElement(By.id("mat-option-296"));
	}
	public WebElement PIInsurancePlanTypeSelect()  // External Portal  
	{
		System.out.println("I am insied PIInsurancePlanTypeSelect");
		//return driver.findElement(By.xpath("//*[@id='mat-select-8']/div/div[2]")); //updated for admin/HCP //updated 10172021
		return driver.findElement(By.xpath("//*[@id='mat-select-6']/div/div[2]")); 
	}
	public WebElement HCPPIInsurancePlanTypeSelect()  // External Portal  
	{
		System.out.println("I am insied PIInsurancePlanTypeSelect");
		return driver.findElement(By.xpath("//*[@id='mat-select-8']/div/div[2]")); 
	}
	public WebElement PIInsurancePlanTypeEPO()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'EPO Exclusive Provider Organization')]//ancestor::mat-option"));
	}
	public WebElement PIInsuranceGroupNumber()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-14")); //updated for admin/HCP //updated 10172021
		return driver.findElement(By.id("mat-input-10")); 
	}
	public WebElement HCPPIInsuranceGroupNumber()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='groupNumber']"));
	}
	
	
	public WebElement PIInsuranceMemberNumber()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-15")); //updated for admin/HCP//updated 10172021
		return driver.findElement(By.id("mat-input-11")); 
	}
	public WebElement HCPPIInsuranceMemberNumber()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='memberId']"));
	}
	public WebElement PIInsuranceEffDate()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-16")); //updated for admin/HCP //updated 10172021
		return driver.findElement(By.id("mat-input-12")); 
	}
	public WebElement HCPPIInsuranceEffDate()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='effectiveDate']"));
	}
	public WebElement PIInsuranceCheckBox()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-checkbox-1']/label/div"));
	
	}
	public WebElement PIPII()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-checkbox-2']/label/div"));
	}
	public WebElement PINextButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-3']/form/app-patient-information/div/button[2]/span[1]"));
	}
	//provider information page
	
	public WebElement PINPI()  // External Portal
	{
		//return driver.findElement(By.id("mat-input-34")); //updated for admin/HCP //updated 10182021
		return driver.findElement(By.id("mat-input-30"));
		
	}
	public WebElement HCPPINPI()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='npi']"));
	}
	public WebElement PINPIFindButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/app-provider-search[1]/form/div[4]/button/span[1]"));
		
	}
	public WebElement PINPISelect()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/app-provider-search[1]/div/table/tbody/tr/td[10]/span/span"));//updated 10182021
		//return driver.findElement(By.xpath("//*[@id='cdk-step-content-1-4']/form/app-provider-information/app-provider-search/div/table/tbody/tr/td[10]/span/span"));
		
	}
	
	public WebElement AddingSusvimoPIProviderNextButton()  // External Portal
	{
	return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/div[3]/button[2]"));
	}
	
	public WebElement PINPIPhoneNumber()  // External Portal
	{
	//	return driver.findElement(By.xpath("//*[@id='mat-input-30']")); //updated for admin/HCP//updated 10182021
		return driver.findElement(By.xpath("//*[@id='mat-input-26']")); //updated for admin/HCP
	}
	public WebElement HCPPINPIPhoneNumber()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='workPhone']"));
	}
	
	//Search for the patient's site of care
	
	public WebElement PIPracticeLastName()  // External Portal
	{
		return driver.findElement(By.id("mat-input-39"));
	}
	public WebElement PISiteOfCareCity()  // External Portal
	{
		return driver.findElement(By.id("mat-input-38"));
	}
	
	public WebElement PISiteOfCareStateSelect()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-select-14']/div/div[2]"));
	}
	public WebElement PISiteOfCareStateConnecticut()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Connecticut')]//ancestor::mat-option"));
	}
	public WebElement PISiteOfCareFindButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/app-provider-search[2]/form/div[2]/button/span[1]"));
	}
	public WebElement PISiteOfCareSELECTButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/app-provider-search[2]/div/table/tbody/tr/td[9]"));
	}

	public WebElement PISiteOfCarePhoneNumber()  // External Portal
	{
			return driver.findElement(By.xpath("//*[@id='mat-input-36']")); //updated for admin/HCP
	}
	
	//site of care info
	public WebElement PIPracticeName()  // External Portal
	{
		return driver.findElement(By.id("mat-input-30"));
	}
	public WebElement PIPracticeAddress()  // External Portal
	{
		return driver.findElement(By.id("mat-input-31"));
	}
	public WebElement PIPracticeCity()  // External Portal
	{
		return driver.findElement(By.id("mat-input-33"));
	}
	public WebElement PIPracticeStateSelect()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-select-12']/div/div[2]"));
	}
	public WebElement PIPracticeStateAlaska()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Alaska')]//ancestor::mat-option"));
	}
	public WebElement PIPracticeZipcode()  // External Portal
	{
		return driver.findElement(By.id("mat-input-34"));
	}
	
	
	public WebElement PIProviderNextButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/div[2]/button[2]/span[1]"));  //updated for admin/HCP //updated 10182021
		return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/div[3]/button[2]"));  //updated for admin/HCP
	}
	public WebElement HCPPIProviderNextButton()  // External Portal
	{
	return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-4']/form/app-provider-information/div[2]/button[2]"));
	}
	
	public WebElement VerifyAllCheckBox()  // External Portal
	{
		return driver.findElement(By.id("mat-checkbox-3"));
		//return driver.findElement(By.xpath("//*[@id=\"mat-checkbox-3\"]/label/div"));
	}
	
	public WebElement ConfirmButton()  // External Portal
	{
		
		//return driver.findElement(By.xpath("//*[@id='cdk-step-content-0-5']/form/app-verify/div[4]/button[2]/span[1]"));//updated 1102022
		return driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-5\"]/form/app-verify/div[5]/button[2]/span[1]"));
										
	}
	public WebElement GetMemberId()  // External Portal
	{
		return driver.findElement(By.xpath("//app-enrollment-success/p[5]"));
	}
	public WebElement GetReferenceNo()  // External Portal
	{
		return driver.findElement(By.xpath("//app-enrollment-error/p[2]"));
	}
	
	public WebElement MyAccountButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));//updated on 8132021
		return driver.findElement(By.xpath("//app-nav-list/div/ul/li[3]/a/span/strong"));
		
	}
	
	public WebElement PatientClaims()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'Claims')]")); //updated 8132021
		return driver.findElement(By.xpath("//a[contains(@href,'profile/claims')]"));
		
		
	}
	
	public WebElement Patientcommunications()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'communications')]")); //updated 8132021
		return driver.findElement(By.xpath("//a[contains(@href,'profile/communications')]"));
		
	}
	
	public WebElement NameOfPractice()  // External Portal
	{
		return driver.findElement(By.id("mat-input-2"));
	}
	
		
	public WebElement TermsSubmit()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'I Agree')]"));
	}
	
	public WebElement MyAccount()  // External Portal
	{
		//return driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
	//return driver.findElement(By.xpath("//span[contains(text(),'My Account')]//ancestor::button")); //updated for Patient portal
	//updated 10112021
		return driver.findElement(By.xpath("//a[contains(@href,'/profile')]"));
	
	}
	
	public WebElement PatientSearchFirstName()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
	}
	
	public WebElement PatientSearchLastName()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
	}
	
	public WebElement PatientSearchDate()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@data-mat-calendar='mat-datepicker-0']"));
	}
	
	public WebElement PatientSearchMemberID()  // External Portal
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='memberId']"));
	}
	public WebElement PatientSearchDateData()  // External Portal
	{
		return driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr[1]/td[2]"));
	}
	
	public WebElement PatientSearchMemberIDData()  // External Portal
	{
		return driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr[1]/td[3]"));
	}
	
	public Select PatientSearchProduct()
	{
		Select Product = new Select(driver.findElement(By.xpath("//input[@formcontrolname='programs']")));
		return Product;
	}
	
	public WebElement PatientPopUpMsgOKButton()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'OK')]"));
	}
	
	public WebElement HCPPopUpMsgOKButton()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[@id='mat-dialog-1']/app-notification-dialog/mat-dialog-actions/button[1]")); //updated 10112021
		return driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-notification-dialog/mat-dialog-actions/button[1]"));
			
	}
	
	public boolean isPopupOpen() {
		try {
			if(driver.findElement(By.xpath("//*[contains(@id,'mat-dialog')]")).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public WebElement HCPPopUpMsgCloseButton()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
		
	}
	public WebElement HCPWelcomeMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Log in to Your Account')]"));
	}
	
	public WebElement WelcomeMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patient Profile Details')]"));
	}
	
	public WebElement ClaimsMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patient Claims History')]"));
	}
		
	/*boolean patientClaims = false;
	public boolean WrapperClaimsMessage() {
		System.out.println("Web element for claims message ######### @@@@@ ");
		ClaimsMessage(false);
		return patientClaims;
	}
	
	public WebElement ClaimsMessage(boolean patientClaims)  // External Portal
	{	
		WebElement weObj = null;
		try {
			weObj = driver.findElement(By.xpath("//*[contains(text(),'Patient Claims History')]"));
		//return driver.findElement(By.xpath("//*[contains(text(),'Patient Claims History')]"));
			patientClaims = true;
		
	    } catch(Exception e){
	    	System.out.println("Error*****************" +e.getMessage());
	    }
		
		return weObj;
	}*/
	
	public WebElement communicationsMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patient Communications History')]"));
	}
	
	public WebElement HCPFooterMessage()  // External Portal
	{
		//return driver.findElement(By.xpath("//app-login/div/div[2]/p[1]"));
		return driver.findElement(By.xpath("//app-layout/div/div[3]/app-footer/footer"));
		
	}
	public WebElement PatientFooterMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//app-login/div/div[2]"));
		
	}
	
	public WebElement PatientMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//app-login/div/div[2]"));
	}
	
	public WebElement Cookie()  // External Portal
	{
		return driver.findElement(By.id("onetrust-accept-btn-handler"));
	}
	
	public boolean isPopupPresent() {
		try {
			return driver.findElement(By.xpath("//*[contains(@id,'mat-dialog')]")).isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void ClickClose()  // External Portal
	{
		if(isPopupPresent()) {
			driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
		}
	}
	
	public void ClickCloseBtn()  // External Portal
	{
		if(isPopupPresent()) {
			driver.findElement(By.xpath("//*[text()='Close']")).click();
		}
	}
	
	public WebElement PatientPopUpMsg()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-notification-dialog/mat-dialog-content/p"));
	}

	public WebElement HCPLink()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[contains(text(),'For Healthcare Professionals/Specialty Pharmacies')]")); updated after screen changes sep 2021
		return driver.findElement(By.xpath("//*[contains(text(),'Health Care Professionals Site')]"));
		
	}
	public WebElement PatientLink()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patients and Caregivers Site')]"));
	}
	
	public WebElement HCPPopUpMsgOK()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-dialog-1']/app-notification-dialog/mat-dialog-content/p"));
	}
	
	public WebElement HCPPopUpMsgCancle()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
											
	}
	
	public WebElement PatientVerificationMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Have a temporary reference number and want to return to the confirmation screen?')]"));
		
	}
	
	public WebElement LoginLogo()  // External Portal
	{
		return driver.findElement(By.xpath("//img[contains(@alt,'logo')]"));
	}
	
	public WebElement EnrollNow()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]"));
	}
	
	public WebElement DontHaveAccount()  // External Portal
	{
	return driver.findElement(By.xpath("//*[contains(text(),'have an account')]"));
	}
	 
	public WebElement CreateOneHere()  // External Portal
	{
		return driver.findElement(By.partialLinkText("Create one here."));
	}
	
	public WebElement ReferenceNumberTable()  // External Portal
	{
		return driver.findElement(By.className("mat-card mat-focus-indicator"));
	}
	
	
	public WebElement IAndILink()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Indications and Important Safety Information')]"));
	}
	
	public WebElement IAndILinkVerification()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='isi']/app-isi/div/div[2]/div/div"));
	}
	public WebElement PrescribingInfoLink()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Prescribing Information')]"));
	}
	public String PrescribingInfoVerification()  // External Portal
	{
		return driver.getCurrentUrl();
	}
	public WebElement HCPHeader()  // External Portal
	{
		return driver.findElement(By.xpath("//header"));
	}
	public WebElement HCPFooter()  // External Portal
	{
		return driver.findElement(By.xpath("//footer"));
	}
	
	public WebElement PatientSearchWelcomeMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Enter one or more criteria to search your patients. “First Name” and “Last Name” provides partial text search')]"));
	}
	
	public WebElement PatientSearchPagination()  // External Portal
	{
		return driver.findElement(By.xpath("//mat-paginator/div/div/div[1]/mat-form-field/div"));

	}
	
	public WebElement PatientSearchPaginationSelection20()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-option-5']/span"));

	}
	public WebElement PatientSearchPaginationSelection50()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-option-6']/span"));
	
	}
	public WebElement PatientSearchPaginationSelection100()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-option-7']/span"));
	
	}
	
	
	
	public WebElement AccountInfo() // External Portal
	{
		
		return driver.findElement(By.xpath("//button[@mattooltip='Account Information']"));
	}
	
	public WebElement HubHomePageLogoutButton()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Sign out')]//ancestor::button"));
	}
		
	public WebElement HCPHomePageMyProfileButton()  // External Portal
	{ 
		return driver.findElement(By.xpath("//span[contains(text(),'My Profile')]//ancestor::button"));
	}
	public WebElement HCPMyProfileLandingMessage()  // External Portal
	{
		//return driver.findElement(By.xpath("//*[contains(text(),'User Profile')]")); //updated on 7/26/2021
		return driver.findElement(By.xpath("//*[contains(text(),'My Profile')]"));
		
	}
	
	public WebElement HCPHomePageChangePasswordButton() {
		return driver.findElement(By.xpath("//span[contains(text(),'Change Password')]//ancestor::button"));
	}

	public WebElement HCPChangePasswordLandingMessage()  // External Portal
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Your new password must be')]"));
	}
	public WebElement ProductSlection()  // External Portal
	{
		return driver.findElement(By.xpath("//*[@id='mat-select-4']/div/div[2]"));
	
	}
	
	  public WebElement ProductSlectionLucentis()  // External Portal
		{
			return driver.findElement(By.xpath("//span[contains(text(),'LUCENTIS')]//ancestor::mat-option"));
		
		}

	public WebElement DocumentType()  // External Portal
	{
		return driver.findElement(By.id("mat-radio-3"));
	
	}
	public WebElement DocumentUploadBrowse()  // External Portal
	{
		return driver.findElement(By.xpath("//label[contains(text(),'Browse')]//ancestor::button"));
	}
	public WebElement DocumentUploadSubmit()  // External Portal
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Submit')]//ancestor::button"));
	}
	

	public WebElement DocumentUploadSubmitNumber()  // External Portal
	{
		return driver.findElement(By.xpath("//app-upload-documents/div/form/mat-card[2]/mat-card-content/div[1]/div"));
	}
	
	//****************************************************************************************************
	
	
	
	
	
	public void SearchPatient() throws IOException, AWTException {
		try {
			Thread.sleep(3000);
			SearchButton().click();
			Thread.sleep(3000);
			boolean table= SearchTable().isDisplayed();
			System.out.println("The table value is:" +table);
			// reporting
			//scroll down to capture the screenshot at the correct location
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)", "");
			if (table=true) {
				TestBase.classAInstance.logReport("Pass", "Search Patient", "Search Patient button is successful");
			} else {
				TestBase.classAInstance.logReport("Fail", "Search Patient", "Search Patient button is not displaying the data");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SearchPatientByProduct() throws IOException, AWTException {
		try {
			Thread.sleep(3000);
			PatientSearchProduct().selectByVisibleText("Xolair RX Replatform");
			Thread.sleep(1000);
			SearchButton().click();
			Thread.sleep(3000);
			/*//To get the number of rows in the table and check if it matched with the filter criteria
			int TotalRows = NumOfRows().size();
			System.out.println("TotalRows is:" +TotalRows);
		
			for (int loop1 = 1; loop1 <= TotalRows; loop1++) {	
				
				String DateOnScreen =driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr["+loop1+"]/td[2]")).getText();
				System.out.println("Screen member id amount ####"+DateOnScreen);
								 
			  	if (DateOnScreen.matches(data)) {
			  		TestBase.classAInstance.logReport("Pass","Patient Search by Date","Date on the screen match with the Filter");
			  	}else {
				 TestBase.classAInstance.logReport("Fail","Patient Search by Date","Date on the screen doesnt match with the Filter");
					}
			  Thread.sleep(4000);*/ 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				  


	public void SearchPatientByDate() throws IOException, AWTException {
		try {
			Thread.sleep(3000);
			SearchButton().click();
			Thread.sleep(3000);
			String data= PatientSearchDateData().getText();
			System.out.println("The date data is:" +data);
			PatientSearchDate().sendKeys(data);
			Thread.sleep(1000);
			SearchButton().click();
			Thread.sleep(3000);
			//To get the number of rows in the table and check if it matched with the filter criteria
			int TotalRows = NumOfRows().size();
			System.out.println("TotalRows is:" +TotalRows);
		
			for (int loop1 = 1; loop1 <= TotalRows; loop1++) {	
				
				String DateOnScreen =driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr["+loop1+"]/td[2]")).getText();
				System.out.println("Screen member id amount ####"+DateOnScreen);
								 
			  	if (DateOnScreen.matches(data)) {
			  		TestBase.classAInstance.logReport("Pass","Patient Search by Date","Date on the screen match with the Filter");
			  	}else {
				 TestBase.classAInstance.logReport("Fail","Patient Search by Date","Date on the screen doesnt match with the Filter");
					}
			  Thread.sleep(4000);
				  }

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SearchPatientByMemberID() throws IOException, AWTException {
		try {
			Thread.sleep(3000);
			SearchButton().click();
			Thread.sleep(3000);
			String data= PatientSearchMemberIDData().getText();
			System.out.println("The date data is:" +data);
			PatientSearchMemberID().sendKeys(data);
			Thread.sleep(1000);
			SearchButton().click();
			Thread.sleep(3000);
			//To get the number of rows in the table and check if it matched with the filter criteria
			int TotalRows = NumOfRows().size();
			System.out.println("TotalRows is:" +TotalRows);
		
			for (int loop1 = 1; loop1 <= TotalRows; loop1++) {	
				
				String MemberIDScreen =driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr["+loop1+"]/td[3]")).getText();
				System.out.println("Screen member id amount ####"+MemberIDScreen);
								 
			  	if (MemberIDScreen.matches(data)) {
			  		TestBase.classAInstance.logReport("Pass","Patient Search by Member ID","Member ID on the screen match with the Filter");
			  	}else {
				 TestBase.classAInstance.logReport("Fail","Patient Search by Member ID","Member ID on the screen doesnt match with the Filter");
					}
			  Thread.sleep(4000);
				  }

		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<WebElement> NumOfRows() {
		
		WebElement faxTable = driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody"));
		List<WebElement> noofRows = faxTable.findElements(By.tagName("tr"));
		return noofRows;
	}
	
	
public void SearchPatientByFirstName() throws IOException, AWTException {
	try {
		System.out.println("Before PatientSearchFirstName");
		PatientSearchFirstName().sendKeys("m");
		Thread.sleep(3000);
		System.out.println("After PatientSearchFirstName");
		SearchButton().click();
		Thread.sleep(3000);
		boolean table2= SearchTable().isDisplayed();
		System.out.println("The table2 value is:" +table2);
		// reporting
		//scroll down to capture the screenshot at the correct location
		if (table2=true) {
			TestBase.classAInstance.logReport("Pass", "Search Patient", "Searched using PatientSearchFirstName was successful");
		} else {
			TestBase.classAInstance.logReport("Fail", "Search Patient", "Searched using PatientSearchFirstName was not successful");
		}
		
		PatientSearchResetButton();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void SearchPatientByLastName() throws IOException, AWTException {
	try {
		System.out.println("Before PatientSearchLastName");
		PatientSearchLastName().sendKeys("m");
		Thread.sleep(3000);
		System.out.println("After PatientSearchLastName");
		SearchButton().click();
		Thread.sleep(3000);
		boolean table3= SearchTable().isDisplayed();
		System.out.println("The table3 value is:" +table3);
		// reporting
		//scroll down to capture the screenshot at the correct location
		if (table3=true) {
			TestBase.classAInstance.logReport("Pass", "Search Patient", "Searched using PatientSearchLastName was successful");
		} else {
			TestBase.classAInstance.logReport("Fail", "Search Patient", "Searched using PatientSearchLastName was not successful");
		}
		
		PatientSearchResetButton();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void PatientSearchResetButton() throws IOException, AWTException{
		try {
			ResetButton().click();
			System.out.println("Clicked on Reset button");
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void HCPLogin() throws IOException, AWTException {
		
		try {
			if(isPopupOpen()) {
				HCPPopUpMsgCloseButton().click();
				Thread.sleep(2000);
			}
			UserID().clear();
			UserID().sendKeys(uname);
			Thread.sleep(2000);
			Password().clear();
			Password().sendKeys(pwd);
			Thread.sleep(3000);
			
			// click on submit button
			SubmitButton().click();
			Thread.sleep(2000);
					
			String title = driver.getTitle();
			System.out.println("the title is:" +title);

			//Assert.assertEquals(title,tit);
			// reporting
									
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public void PatientLoginVerify() throws IOException, AWTException {
	
	try {

		//PatientPopUpMsgOKButton().click();
		//Thread.sleep(2000);
		
		MyAccount().click();
		Thread.sleep(4000);
		
		
		if (HCPWelcomeMessage().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "HCP Welcome Message Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "HCP Welcome Message Field is not available");
		}
		
		String ttt= PatientFooterMessage().getText();
		System.out.println("ttt is:" +ttt);
		
		if (PatientFooterMessage().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "HCP Footer Message Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "HCP Footer Message Field is not available");
		}
		
				
		UserID().clear();
		UserID().sendKeys(unamePatient);
		Thread.sleep(2000);
		if (UserID().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "UserID Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "UserID Field is not available");
		}
		
		
		Password().clear();
		Password().sendKeys(pwdPatient);
		if (Password().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "Password Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "Password Field is not available");
		}
		Thread.sleep(3000);
		
		if (SubmitButton().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "SubmitButton Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "Password Field is not available");
		}
		
		
		String ttt1= PatientMessage().getText();
		System.out.println("ttt1 is:" +ttt1);
		
		if (PatientMessage().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "Patient Message Field is available");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "Patient Message Field is not available");
		}
		
		
		// click on submit button
		SubmitButton().click();
		Thread.sleep(2000);
				
		String title = driver.getTitle();
		System.out.println("the title is:" +title);

		Assert.assertEquals(title,tit);
		// reporting
		if (title.equalsIgnoreCase(tit)) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "Succesfully able to login-7");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "Failed to login-7");
		}
					
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void PatientLogin() throws IOException, AWTException {
	
	try {

		//PatientPopUpMsgOKButton().click();
		//Thread.sleep(2000);
		
		MyAccount().click();
		Thread.sleep(4000);
		
			
		UserID().clear();
		UserID().sendKeys(unamePatient);
		Thread.sleep(2000);
				
		Password().clear();
		Password().sendKeys(pwdPatient);
		Thread.sleep(3000);
		
		
		// click on submit button
		SubmitButton().click();
		Thread.sleep(3000);
		
		//HCPPopUpMsgCloseButton().click();
		//Thread.sleep(1000);	
		
		String title = driver.getTitle();
		System.out.println("the title is:" +title);

		Assert.assertEquals(title,tit);
		// reporting
		if (title.equalsIgnoreCase(tit)) {
			TestBase.classAInstance.logReport("Pass", "Able to login", "Succesfully able to login-1");
		} else {
			TestBase.classAInstance.logReport("Fail", "Not able to login", "Failed to login-1");
		}
					
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public void HCPLoginPageContent() throws IOException, AWTException, InterruptedException {
		
		
		HCPPopUpMsgCloseButton().click();
		Thread.sleep(2000);
		
		
		if (LoginLogo().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the logo");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the logo");
		}
				
		System.out.println("HCPHeader:" +HCPHeader().getText());
		
		
		if (HCPHeader().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the Header");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the Header");
		}
		
		System.out.println("HCPFooter:" +HCPFooter().getText());
		
		if (HCPFooter().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Verify the Footer");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Verify the Footer");
		}
		
		IAndILink().click();
		Thread.sleep(3000);
		
		if (IAndILinkVerification().isDisplayed()== true) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Click on Indications and Important Safety Information");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Click on Indications and Important Safety Information");
		}
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		System.out.println("parentHandle:" +parentHandle);
		Thread.sleep(1000);
		System.out.println("Before CLicked on Prescribing Info Link");
		PrescribingInfoLink().click();
		System.out.println("CLicked on Prescribing Info Link");
		Thread.sleep(10000);
			
		Set<String> ggg= driver.getWindowHandles();
		System.out.println("ggg:" +ggg);
		
		
	

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    String abc= PrescribingInfoVerification();
			System.out.println("abc is:" +abc);
		}
		String ttt= PrescribingInfoVerification(); 
		System.out.println("#########:" +ttt);
		if (ttt!=null) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Click on Prescribing Information-5");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Click on Prescribing Information-5");
		}
		
		driver.switchTo().window(parentHandle); // switch back to the original window
		
	}
	
public void PatientLoginPageContent() throws IOException, AWTException, InterruptedException {
	
		PatientPopUpMsgOKButton().click();
		Thread.sleep(1000);
		
		if (LoginLogo().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the logo");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the logo");
		}
	
		
		if (EnrollNow().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the Enroll Now Button");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the Enroll Now Button");
		}
		
		if (MyAccount().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the MyAccount Button");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the MyAccount Button");
		}
						
		if (DontHaveAccount().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify Dont have an account");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify Dont have an account");
		}
		
		if (CreateOneHere().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify Create One Here");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify Create One Here");
		}
		
		if (ReferenceNumberTable().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify Reference Number Table");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify Reference Number Table");
		}
		
	
		
		if (HCPHeader().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the Header");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the Header");
		}
		
		if (HCPFooter().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Verify the Footer");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Verify the Footer");
		}
		
		IAndILink().click();
		
		if (IAndILinkVerification().isDisplayed()) {
			TestBase.classAInstance.logReport("Pass", "Patient Login screen content", "Succesfully able to Click on Indications and Important Safety Information");
		} else {
			TestBase.classAInstance.logReport("Fail", "Patient Login screen content", "Failed to Click on Indications and Important Safety Information");
		}
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		System.out.println("parentHandle:" +parentHandle);
		Thread.sleep(1000);
		System.out.println("Before CLicked on Prescribing Info Link");
		PrescribingInfoLink().click();
		System.out.println("CLicked on Prescribing Info Link");
		Thread.sleep(10000);
			
		Set<String> ggg= driver.getWindowHandles();
		System.out.println("ggg:" +ggg);
		
		
	

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    String abc= PrescribingInfoVerification();
			System.out.println("abc is:" +abc);
		}
		String ttt= PrescribingInfoVerification(); 
		System.out.println("#########:" +ttt);
		if (ttt!=null) {
			TestBase.classAInstance.logReport("Pass", "HCP Login screen content", "Succesfully able to Click on Prescribing Information-10");
		} else {
			TestBase.classAInstance.logReport("Fail", "HCP Login screen content", "Failed to Click on Prescribing Information-10");
		}
		
		driver.switchTo().window(parentHandle); // switch back to the original window
		
	}
	
	public void HCPPopUpVerification() throws IOException, AWTException {
		
		try {
			//Patient portal pop up message
			String abc= PatientPopUpMsg().getText();
			System.out.println("PatientPopUpMsg is:" +abc);
			if ( PatientPopUpMsg().getText() != null) {
				TestBase.classAInstance.logReport("Pass", "Patient Portal Pop Up Message", "Succesfully verified the pop up message in Patient Portal:" +abc);
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Portal Pop Up Message", "Failed verified the pop up message in Patient Portal");
			}
			
			//Patient paortal pop up messgae OK Button
			PatientPopUpMsgOKButton().click();
			Thread.sleep(1000);
			
			//Click on HCP portal Link
			HCPLink().click();
			
			//HCP link error message Verify
			String abd= HCPPopUpMsgOK().getText();
			System.out.println("HCPPopUpMsgOK is:" +abd);
			if ( HCPPopUpMsgOK().getText() != null) {
				TestBase.classAInstance.logReport("Pass", "HCP Portal Pop Up Message", "Succesfully verified the pop up message in HCP portal:" +abd);
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Portal Pop Up Message", "Failed verified the pop up message in HCP portal");
			}
		
			//HCP link error message click on OK
			HCPPopUpMsgOKButton().click();
			Thread.sleep(5000);
			HCPPopUpMsgCloseButton().click();
			
						
			//HCP portal landing page message
			String afd= HCPWelcomeMessage().getText();
			System.out.println("HCPWelcomeMessage is:" +afd);
			if (HCPWelcomeMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP Welcome Message", "Succesfully verified the HCP Welcome Message after clicking OK");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP Welcome Message", "Failed verified the HCP Welcome Message after clicking OK");
			}
			
			//Click on patient link- ok- then click on HCP link
			PatientLink().click();
			System.out.println("Clicked on Patient link");
			Thread.sleep(4000);
			if ( PatientPopUpMsgOKButton().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Patient Portal Pop Up Message", "Succesfully verified the pop up message in Patient Portal");
			} else {
				TestBase.classAInstance.logReport("Fail", "Patient Portal Pop Up Message", "Failed verified the pop up message in Patient Portal");
			}
			
			PatientPopUpMsgOKButton().click();
			Thread.sleep(1000);
			HCPLink().click();
			Thread.sleep(1000);
			
			//Click on Cancle on HCP portal pop up message
			if ( HCPPopUpMsgCancle().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP portal Pop Up Message", "Succesfully verified the pop up message in HCP portal before clicking cancle button");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP portal Pop Up Message", "Failed verified the pop up message in HCP portal before clicking cancle button");
			}
			
			HCPPopUpMsgCancle().click();
			Thread.sleep(1000);
			if ( PatientVerificationMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "Back to Patient Portal", "Succesfully User is able to go back to Patient portal by clicking on Cancle button-6");
			} else {
				TestBase.classAInstance.logReport("Fail", "Back to Patient Portal", "Failed as User is not able to go back to Patient portal by clicking on Cancle button-6");
			}
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void PatientPopUpVerification() throws IOException, AWTException {
		
		try {
			//Cookie().click();
			//Thread.sleep(4000);
			//System.out.println("Clicked on ok button in Cookie");
			
			//Patient portal pop up message
			HCPPopUpMsgCloseButton().click();
			Thread.sleep(3000);
			//HCPPopUpMsgCloseButton().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void SusvimoOphthalmologyEnrollment() throws IOException, AWTException {
	//Regression excel sheet

	System.out.println("I am inside enrollment");
	String Key = "SmokePatientEnrollment";
	System.out.println("The Key is:" +Key);
	int rowNum = etd.getKeyValuePair(Key);
	System.out.println("The rowNum is:" +rowNum);
	List<String> testData = new ArrayList<String>();
	testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
	System.out.println("testdata is:" +testData);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	try {	
		wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
		EnrollButton().click();
		System.out.println("CLicked on Enroll button");
		Thread.sleep(8000);
		
		System.out.println("Before BrandButton");
		SusvimoBrandButton().click(); //Select Susvimo brand
	 	Thread.sleep(4000);
	 	
	 	wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
	 	JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PatientRadioButton());
//		PatientRadioButton().click();
		Thread.sleep(2000);
		PatientRadioNextButton().click();
		Thread.sleep(6000);
	//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
	
		NewPatientYESRadioButton().click();
		System.out.println("After clicking Yes Button");
		Thread.sleep(3000);
		System.out.println("Member ID is:" +testData.get(20));
		ExistingMemberID().sendKeys(testData.get(20).trim());
		Thread.sleep(3000);
		System.out.println("DOB is:" +testData.get(3));
		ExistingDOB().sendKeys(testData.get(3));
		Thread.sleep(2000);
		ExistingMemberIDSubmitButton().click();
		Thread.sleep(5000);
		
		LucentisCheckBox().click();
		Thread.sleep(2000);
		OphthalmologyCheckBoxtButton().click(); //CheckBox for Susvimo
		Thread.sleep(2000);
		SusvimoCheckBoxNextButton().click(); 
		
		Thread.sleep(6000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		//Eligibility screen
		//String abs=data().getText();
		System.out.println("I am inside Eligibility screen");
		AddingSusvimoQuestion1().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion2().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion3().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion4().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion5().click();
		Thread.sleep(2000);
		
		AddingSusvimoQuestion7().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion8().click();
		Thread.sleep(2000);
		AddingSusvimoQuestion9().click();
		Thread.sleep(1000);
		AddingSusvimoQuestion10().click();
		Thread.sleep(1000);
		
//		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
//		EligibilityNextButton().click();
		Actions action = new Actions(driver);

		action.moveToElement(EligibilityNextButton()).doubleClick().perform();
//		ndEnrollmentEligibilityNextButton().click();
		System.out.println("After clicking on next button");
		
//		PIInsuranceCheckBox().click();
		Thread.sleep(4000);
		PIPII().click();
		System.out.println("After Selecting the Check box");
		Thread.sleep(2000);
		PINextButton().click();
		
		//Provider information
		HCPPINPI().sendKeys(testData.get(12));
		Thread.sleep(2000);
		PINPIFindButton().click();
		System.out.println("After Selecting the NPI number");
		Thread.sleep(2000);
		PINPISelect().click();
		Thread.sleep(6000);
	
		//Search for the patient's site of care
		/*
		PIPracticeLastName().sendKeys(testData.get(13));
		PISiteOfCareCity().sendKeys(testData.get(14));
		PISiteOfCareStateSelect().click();
		Thread.sleep(1000);
		PISiteOfCareStateAlaska().click();
		Thread.sleep(1000);
		PISiteOfCareFindButton().click();
		//site of care info
		
		PIPracticeName().sendKeys("Test");
		PIPracticeAddress().sendKeys("345 test ave");
		PIPracticeCity().sendKeys("Whippany");
		PIPracticeStateSelect().click();
		Thread.sleep(2000);
		PIPracticeStateAlaska().click();
		Thread.sleep(2000);
		PIPracticeZipcode().sendKeys("67356");*/
//		Thread.sleep(2000);
//		HCPPINPIPhoneNumber().clear();
//		Thread.sleep(4000);
//		System.out.println("The phone number is:" +testData.get(19));
//		HCPPINPIPhoneNumber().sendKeys(testData.get(19));
//		Thread.sleep(2000);
		AddingSusvimoPIProviderNextButton().click();
		
		//Verify information
		Thread.sleep(10000);
		VerifyAllCheckBox().click();
		Thread.sleep(3000);
		ConfirmButton().click();
		System.out.println("After Confirming button");

	/*	boolean load = true;
		while(load == true) {
		   if(ConfirmButton().isDisplayed() == true) {
			   System.out.println("Waiting for Member ID");
		      	Thread.sleep(1000);
		    }
		   load= ConfirmButton().isDisplayed();
		 }
*/
		Thread.sleep(15000);

		
		System.out.println("I am going to take the MemberID ");
		String retval=GetMemberId().getText();
		System.out.println("The MemberID is:" +retval);
		//Split function
		for (String MemberID:retval.split(":")) {
	         System.out.println(MemberID);
	         gst.E2EScenariossetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
	         if (MemberID!=null) {
	        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
				} else {
					System.out.println("The member ID is null");
					TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
				}  }
				
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<String> LucentisEnrollInPateintPortal() throws IOException, AWTException {
	//Regression excel sheet

	System.out.println("I am inside enrollment");
	String Key = "SmokePatientEnrollment";
	System.out.println("The Key is:" +Key);
	int rowNum = etd.getKeyValuePair(Key);
	System.out.println("The rowNum is:" +rowNum);
	List<String> testData = new ArrayList<String>();
	testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
	System.out.println("testdata is:" +testData);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	List<String> patientData = new ArrayList<String>();
	//PatientPopUpVerification();
	
	try {
		wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
		EnrollButton().click();
		System.out.println("CLicked on Enroll button");
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOf(BrandButton()));
		LucentisBrandButton().click();
		System.out.println("CLicked on Brand Button");
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
		//PatientRadioButton().click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PatientRadioButton());
	
		System.out.println("CLicked on Patient Radio Button");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(PatientRadioNextButton()));
		PatientRadioNextButton().click();
		System.out.println("CLicked on Patient Radio Next Button");
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", NewPatientNORadioButton());
		//NewPatientNORadioButton().click();
		System.out.println("CLicked on New Patient NO Radio Button");
		Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.visibilityOf(LucentisCheckBox()));

		LucentisCheckBox().click();
		System.out.println("CLicked on Lucentis Check Box");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(LucentisCheckBoxNextButton()));
		LucentisCheckBoxNextButton().click();
		Thread.sleep(6000);
		
		//Eligibility screen
		//String abs=data().getText();
		//wait.until(ExpectedConditions.visibilityOf(Question1()));
		System.out.println("I am inside Eligibility screen");
		LucentisQuestion1().click();
		//Thread.sleep(2000);
		LucentisQuestion2().click();
		//Thread.sleep(2000);
		LucentisQuestion3().click();
		//Thread.sleep(2000);
		LucentisQuestion4().click();
		//Thread.sleep(2000);
		LucentisQuestion5().click();
		//Thread.sleep(2000);
		
		Question6DropDownSelect().click();
		Thread.sleep(3000);
		Question6select().click();
		//Thread.sleep(2000);
		
		LucentisQuestion7().click();
		//Thread.sleep(2000);
		LucentisQuestion8().click();
		//Thread.sleep(2000);
		LucentisQuestion9().click();
		//Thread.sleep(1000);
		LucentisQuestion10().click();
		//Thread.sleep(1000);

		EligibilityNextButton().click();
		
		//Patient information screen
		
		PIFirstName().sendKeys(testData.get(1));
		patientData.add(testData.get(1));
		//Set patient last name into excel
		
		String randomPatientLastName = TestUtil.randomAlpha(3);
		System.out.println("The randomPatientLastName is:" +randomPatientLastName);
		testData.set(2,randomPatientLastName);
		PILastName().sendKeys(randomPatientLastName);
		PIGenderSelect().click();
		Thread.sleep(2000);
		PIGenderSelectFemale().click();
		Thread.sleep(2000);
		//PIGender().selectByIndex(1);
		PIBirthDate().sendKeys(testData.get(3));
		PIAddress1().sendKeys(testData.get(4));
		patientData.add(testData.get(4));
		PICity().sendKeys(testData.get(5));
		patientData.add(testData.get(5));
		//PIStateSelect().click();
		Thread.sleep(2000);
		System.out.println("Before selecting state");
		//PIStateAlaska().click();
		System.out.println("After selecting state");
		PIZipCode().sendKeys(testData.get(7));
		patientData.add(testData.get(7));
		System.out.println("After selecting PIZipCode");
		PIPhoneNumber().sendKeys(testData.get(8));
		patientData.add(testData.get(8));
		//Commercial Medical Insurance Information
		PIInsuranceCompanyNameSelect().click();
		Thread.sleep(4000);
		PIInsuranceCompanyNameAllianceHealth().click();
		PIInsurancePlanTypeSelect().click();
		Thread.sleep(2000);
		PIInsurancePlanTypeEPO().click();
		PIInsuranceGroupNumber().sendKeys(testData.get(9));
		PIInsuranceMemberNumber().sendKeys(testData.get(10));
		PIInsuranceEffDate().sendKeys(testData.get(11));
		Thread.sleep(2000);
		PIInsuranceCheckBox().click();
		Thread.sleep(2000);
		PIPII().click();
		Thread.sleep(2000);
		PINextButton().click();
		
		//Provider information
		PINPI().sendKeys(testData.get(12));
		patientData.add(testData.get(12));
		Thread.sleep(2000);
		PINPIFindButton().click();
		System.out.println("Clicked on find button");
		Thread.sleep(4000);
		PINPISelect().click();
		System.out.println("Clciking on find NPI Select");
		Thread.sleep(6000);
		System.out.println("Clciked on find NPI Select");
	
		//Search for the patient's site of care
		
		PIPracticeLastName().sendKeys(testData.get(13));
		PISiteOfCareCity().sendKeys(testData.get(14));
		PISiteOfCareStateSelect().click();
		Thread.sleep(1000);
		PISiteOfCareStateConnecticut().click();
		Thread.sleep(1000);
		PISiteOfCareFindButton().click();
		Thread.sleep(4000);
		PISiteOfCareSELECTButton().click();
		PISiteOfCarePhoneNumber().clear();
		Thread.sleep(4000);
		System.out.println("The phone number is:" +testData.get(19));
		PISiteOfCarePhoneNumber().sendKeys(testData.get(19));
		/*	//site of care info
		
		PIPracticeName().sendKeys("Test");
		PIPracticeAddress().sendKeys("345 test ave");
		PIPracticeCity().sendKeys("Whippany");
		PIPracticeStateSelect().click();
		Thread.sleep(2000);
		PIPracticeStateAlaska().click();
		Thread.sleep(2000);
		PIPracticeZipcode().sendKeys("67356");*/
		
		Thread.sleep(2000);
		PINPIPhoneNumber().clear();
		Thread.sleep(4000);
		System.out.println("The phone number is:" +testData.get(19));
		PINPIPhoneNumber().sendKeys(testData.get(19));
		Thread.sleep(2000);
		System.out.println("Updated the phone number");
		PIProviderNextButton().click();
		System.out.println("Clciked on Next button in Provicer information screen");
		
		
		//Verify information
		Thread.sleep(4000);
		VerifyAllCheckBox().click();
		Thread.sleep(2000);
		ConfirmButton().click();
		Thread.sleep(25000);
		System.out.println("I am going to take the MemberID ");
		String retval=GetMemberId().getText();
		System.out.println("The MemberID is:" +retval);
		//Split function
		for (String MemberID:retval.split(":")) {
	         System.out.println(MemberID);
	         gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
	         if (MemberID!=null) {
					TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
				} else {
					TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
				}  }
		return testData;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
	public void Susvimo2ndEnrollmentWithDOB1930() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "SmokePatientEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			System.out.println("Before BrandButton");
			BrandButton().click(); //Select Susvimo brand
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			NewPatientYESRadioButton().click();
			System.out.println("After clicking Yes Button");
			Thread.sleep(3000);
			System.out.println("Member ID is:" +testData.get(20));
			ExistingMemberID().sendKeys(testData.get(20).trim());
			Thread.sleep(3000);
			System.out.println("DOB is:" +testData.get(3));
			ExistingDOB().sendKeys(testData.get(3));
			Thread.sleep(2000);
			ExistingMemberIDSubmitButton().click();
			Thread.sleep(5000);
			
			LucentisCheckBox().click();
			Thread.sleep(2000);
			
			SusvimoCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			AddingSusvimoQuestion1().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion2().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion3().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion4().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion5().click();
			Thread.sleep(2000);
			
			AddingSusvimoQuestion7().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion8().click();
			Thread.sleep(2000);
			AddingSusvimoQuestion9().click();
			Thread.sleep(1000);
			AddingSusvimoQuestion10().click();
			Thread.sleep(1000);
			
//			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(1000);
//			EligibilityNextButton().click();
			Actions action = new Actions(driver);

			PIBirthDate().sendKeys("7/5/1930"); //Change DOB to 1930
			
			action.moveToElement(EligibilityNextButton()).doubleClick().perform();
//			ndEnrollmentEligibilityNextButton().click();
			System.out.println("After clicking on next button");
			
//			PIInsuranceCheckBox().click();
			Thread.sleep(4000);
			PIPII().click();
			System.out.println("After Selecting the Check box");
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			System.out.println("After Selecting the NPI number");
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
//			Thread.sleep(2000);
//			HCPPINPIPhoneNumber().clear();
//			Thread.sleep(4000);
//			System.out.println("The phone number is:" +testData.get(19));
//			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
//			Thread.sleep(2000);
			AddingSusvimoPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(10000);
			VerifyAllCheckBox().click();
			Thread.sleep(3000);
			ConfirmButton().click();
			System.out.println("After Confirming button");

		/*	boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
				   System.out.println("Waiting for Member ID");
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }
	*/
			Thread.sleep(15000);

			
			System.out.println("I am going to take the MemberID ");
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.E2EScenariossetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void e2eCTPLucentisEnrollmentPatient() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "SmokePatientEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisBrandButton()));
			LucentisBrandButton().click();
			System.out.println("CLicked on Brand Button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			System.out.println("before CLicking on Patient Radio Button");
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PatientRadioButton());
//			PatientRadioButton().click();
			System.out.println("CLicked on Patient Radio Button");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioNextButton()));
			PatientRadioNextButton().click();
			System.out.println("CLicked on Patient Radio Next Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
			NewPatientNORadioButton().click();
			System.out.println("CLicked on New Patient NO Radio Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBox()));
			LucentisCheckBox().click();
			System.out.println("CLicked on Lucentis Check Box");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBoxNextButton()));
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			//wait.until(ExpectedConditions.visibilityOf(Question1()));
			System.out.println("I am inside Eligibility screen");
			LucentisQuestion1().click();
			//Thread.sleep(2000);
			LucentisQuestion2().click();
			//Thread.sleep(2000);
			LucentisQuestion3().click();
			//Thread.sleep(2000);
			LucentisQuestion4().click();
			//Thread.sleep(2000);
			LucentisQuestion5().click();
			//Thread.sleep(2000);
			
			Question6DropDownSelect().click();
			Thread.sleep(3000);
			Question6select().click();
			//Thread.sleep(2000);
			
			LucentisQuestion7().click();
			//Thread.sleep(2000);
			LucentisQuestion8().click();
			//Thread.sleep(2000);
			LucentisQuestion9().click();
			//Thread.sleep(1000);
			LucentisQuestion10().click();
			//Thread.sleep(1000);

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			PIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			System.out.println("Before selecting state");
			//PIStateAlaska().click();
			System.out.println("After selecting state");
			PIZipCode().sendKeys(testData.get(7));
			System.out.println("After selecting PIZipCode");
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			PIInsuranceCompanyNameSelect().click();
			Thread.sleep(4000);
			PIInsuranceCompanyNameAllianceHealth().click();
			PIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			PIInsuranceGroupNumber().sendKeys(testData.get(9));
			PIInsuranceMemberNumber().sendKeys(testData.get(10));
			PIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			PINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			System.out.println("Clicked on find button");
			Thread.sleep(4000);
			PINPISelect().click();
			System.out.println("Clciking on find NPI Select");
			Thread.sleep(6000);
			System.out.println("Clciked on find NPI Select");
		
			//Search for the patient's site of care
			
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateConnecticut().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			Thread.sleep(4000);
			PISiteOfCareSELECTButton().click();
			PISiteOfCarePhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PISiteOfCarePhoneNumber().sendKeys(testData.get(19));
			/*	//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			
			Thread.sleep(2000);
			PINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			System.out.println("Updated the phone number");
			PIProviderNextButton().click();
			System.out.println("Clciked on Next button in Provicer information screen");
			
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();
			Thread.sleep(15000);
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
						TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  
		         String Key1 = "FaxAndTreatmentUpdated";
		         gst.setMemberIDInExcel_OtherInsurance(Key1, MemberID, rowNum); //Writing back the member ID in excel     
			}
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LAPLucentisEnrollmentPatient() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "LAPPatientEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(BrandButton()));
			LucentisBrandButton().click();
			System.out.println("CLicked on Brand Button");
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			LAPRadioButton().click();
			System.out.println("CLicked on Patient Radio Button");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioNextButton()));
			PatientRadioNextButton().click();
			System.out.println("CLicked on Patient Radio Next Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
			NewPatientNORadioButton().click();
			System.out.println("CLicked on New Patient NO Radio Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(LAPLucentisCheckBox()));
			LAPLucentisCheckBox().click();
			System.out.println("CLicked on Lucentis Check Box");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBoxNextButton()));
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			  
			  
			wait.until(ExpectedConditions.visibilityOf(LucentisQuestion1()));
			System.out.println("I am inside Eligibility screen");
			LucentisQuestion1().click();
			Thread.sleep(2000);
			LucentisQuestion2().click();
			Thread.sleep(2000);
			LucentisQuestion3().click();
			Thread.sleep(2000);
			LucentisQuestion4().click();
			Thread.sleep(2000);
			LucentisQuestion5().click();
			Thread.sleep(2000);
			
			LAPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			LAPQuestion6select().click();
			//Thread.sleep(2000);
			
			LucentisQuestion7().click();
			//Thread.sleep(2000);
			LucentisQuestion8().click();
			//Thread.sleep(2000);
			LucentisQuestion9().click();
			//Thread.sleep(1000);
			LucentisQuestion10().click();
			Thread.sleep(1000);

			EligibilityNextButton().click();
			
			Thread.sleep(5000);		
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			//Legally Authorization person's information
			
			
			LAPPIFirstName().sendKeys("LAP Parent");
			LAPPILastName().sendKeys(randomPatientLastName);
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			PIZipCode().sendKeys(testData.get(7));
			System.out.println("After selecting PIZipCode");
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Patient information
			LAPPIFirstNameForPatient().sendKeys(testData.get(1));
			LAPPILastNameForPatient().sendKeys(randomPatientLastName);
			PIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			
			//address same as Parent
			LAPPIAddressSameCheckBox().click();
			
			//Commercial Medical Insurance Information
			PIInsuranceCompanyNameSelect().click();
			Thread.sleep(4000);
			PIInsuranceCompanyNameAllianceHealth().click();
			PIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			PIInsuranceGroupNumber().sendKeys(testData.get(9));
			PIInsuranceMemberNumber().sendKeys(testData.get(10));
			PIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			PINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			System.out.println("Clicked on find button");
			Thread.sleep(4000);
			PINPISelect().click();
			System.out.println("Clciking on find NPI Select");
			Thread.sleep(6000);
			System.out.println("Clciked on find NPI Select");
		
			//Search for the patient's site of care
			
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateConnecticut().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			Thread.sleep(4000);
			PISiteOfCareSELECTButton().click();
			PISiteOfCarePhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PISiteOfCarePhoneNumber().sendKeys(testData.get(19));
			/*	//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			
			Thread.sleep(2000);
			PINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			System.out.println("Updated the phone number");
			PIProviderNextButton().click();
			System.out.println("Clciked on Next button in Provicer information screen");
			
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();
			Thread.sleep(15000);
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
						TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  
		         String Key1 = "FaxAndTreatmentUpdated";
		         gst.setMemberIDInExcel_OtherInsurance(Key1, MemberID, rowNum); //Writing back the member ID in excel     
			}
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void e2eCTPLucentisEnrollmentPatientGKReject() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "SmokePatientEnrollmentGKReject";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(BrandButton()));
			LucentisBrandButton().click();
			System.out.println("CLicked on Brand Button");
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PatientRadioButton());
			System.out.println("CLicked on Patient Radio Button");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioNextButton()));
			PatientRadioNextButton().click();
			System.out.println("CLicked on Patient Radio Next Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
			NewPatientNORadioButton().click();
			System.out.println("CLicked on New Patient NO Radio Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBox()));
			LucentisCheckBox().click();
			System.out.println("CLicked on Lucentis Check Box");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBoxNextButton()));
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			//wait.until(ExpectedConditions.visibilityOf(Question1()));
			System.out.println("I am inside Eligibility screen");
			LucentisQuestion1().click();
			//Thread.sleep(2000);
			LucentisQuestion2().click();
			//Thread.sleep(2000);
			LucentisQuestion3().click();
			//Thread.sleep(2000);
			LucentisQuestion4().click();
			//Thread.sleep(2000);
			LucentisQuestion5().click();
			//Thread.sleep(2000);
			
			Question6DropDownSelect().click();
			Thread.sleep(3000);
			Question6select().click();
			//Thread.sleep(2000);
			
			LucentisQuestion7().click();
			//Thread.sleep(2000);
			LucentisQuestion8().click();
			//Thread.sleep(2000);
			LucentisQuestion9().click();
			//Thread.sleep(1000);
			LucentisQuestion10().click();
			//Thread.sleep(1000);

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			PIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			System.out.println("Before selecting state");
			//PIStateAlaska().click();
			System.out.println("After selecting state");
			PIZipCode().sendKeys(testData.get(7));
			System.out.println("After selecting PIZipCode");
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			PIInsuranceCompanyNameSelect().click();
			Thread.sleep(4000);
			PIInsuranceCompanyNameAllianceHealth().click();
			PIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			PIInsuranceGroupNumber().sendKeys(testData.get(9));
			PIInsuranceMemberNumber().sendKeys(testData.get(10));
			PIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			PINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			System.out.println("Clicked on find button");
			Thread.sleep(4000);
			PINPISelect().click();
			System.out.println("Clciking on find NPI Select");
			Thread.sleep(6000);
			System.out.println("Clciked on find NPI Select");
		
			//Search for the patient's site of care
			
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateConnecticut().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			Thread.sleep(4000);
			PISiteOfCareSELECTButton().click();
			PISiteOfCarePhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PISiteOfCarePhoneNumber().sendKeys(testData.get(19));
			/*	//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			
			Thread.sleep(2000);
			PINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			System.out.println("Updated the phone number");
			PIProviderNextButton().click();
			System.out.println("Clciked on Next button in Provicer information screen");
			
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();
			Thread.sleep(15000);
			String retval=GetReferenceNo().getText();
			System.out.println("The Reference NO is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
						TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EnrollInPateintPortal() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "PatientSusvimoEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.HCPGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			wait.until(ExpectedConditions.visibilityOf(BrandButton()));
			BrandButton().click();
			System.out.println("CLicked on Brand Button");
			Thread.sleep(4000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PatientRadioButton());
//			PatientRadioButton().click();
			System.out.println("CLicked on Patient Radio Button");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(PatientRadioNextButton()));
			PatientRadioNextButton().click();
			System.out.println("CLicked on Patient Radio Next Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
			NewPatientNORadioButton().click();
			System.out.println("CLicked on New Patient NO Radio Button");
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBox()));
			LucentisCheckBox().click();
			System.out.println("CLicked on Lucentis Check Box");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOf(LucentisCheckBoxNextButton()));
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			wait.until(ExpectedConditions.visibilityOf(Question1()));
			System.out.println("I am inside Eligibility screen");
			Question1().click();
			//Thread.sleep(2000);
			Question2().click();
			//Thread.sleep(2000);
			Question3().click();
			//Thread.sleep(2000);
			Question4().click();
			//Thread.sleep(2000);
			Question5().click();
			//Thread.sleep(2000);
			
			Question6DropDownSelect().click();
			Thread.sleep(3000);
			Question6select().click();
			//Thread.sleep(2000);
			
			Question7().click();
			//Thread.sleep(2000);
			Question8().click();
			//Thread.sleep(2000);
			Question9().click();
			//Thread.sleep(1000);
			Question10().click();
			//Thread.sleep(1000);

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			PIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			System.out.println("Before selecting state");
			//PIStateAlaska().click();
			System.out.println("After selecting state");
			PIZipCode().sendKeys(testData.get(7));
			System.out.println("After selecting PIZipCode");
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			PIInsuranceCompanyNameSelect().click();
			Thread.sleep(4000);
			PIInsuranceCompanyNameAllianceHealth().click();
			PIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			PIInsuranceGroupNumber().sendKeys(testData.get(9));
			PIInsuranceMemberNumber().sendKeys(testData.get(10));
			PIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			PINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			System.out.println("Clicked on find button");
			Thread.sleep(4000);
			PINPISelect().click();
			System.out.println("Clciking on find NPI Select");
			Thread.sleep(6000);
			System.out.println("Clciked on find NPI Select");
		
			//Search for the patient's site of care
			
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateConnecticut().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			Thread.sleep(4000);
			PISiteOfCareSELECTButton().click();
			PISiteOfCarePhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PISiteOfCarePhoneNumber().sendKeys(testData.get(19));
			/*	//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			
			Thread.sleep(2000);
			PINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			System.out.println("Updated the phone number");
			PIProviderNextButton().click();
			System.out.println("Clciked on Next button in Provicer information screen");
			
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();
			Thread.sleep(15000);
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.HCPsetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
						TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void EnrollInAdminPortal() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "HCPSusvimoEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.HCPGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	Thread.sleep(4000);
			System.out.println("Before BrandButton");
			BrandButton().click();
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PatientRadioButton());
		
			//PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", HCPNewPatientNORadioButton());
			//HCPNewPatientNORadioButton().click();
			Thread.sleep(1000);
			LucentisCheckBox().click();
			Thread.sleep(2000);
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			HCPQuestion1().click();
			Thread.sleep(2000);
			HCPQuestion2().click();
			Thread.sleep(2000);
			HCPQuestion3().click();
			Thread.sleep(2000);
			HCPQuestion4().click();
			Thread.sleep(2000);
			HCPQuestion5().click();
			Thread.sleep(2000);
			
			HCPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			HCPQuestion6select().click();
			Thread.sleep(2000);
			
			HCPQuestion7().click();
			Thread.sleep(2000);
			HCPQuestion8().click();
			Thread.sleep(2000);
			HCPQuestion9().click();
			Thread.sleep(1000);
			HCPQuestion10().click();
			Thread.sleep(1000);
			

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			HCPPIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			//PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			System.out.println("Before clicking HCPPIInsuranceCompanyNameSelect");
			HCPPIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			System.out.println("Before clicking PIInsuranceCompanyNameAllianceHealth");
			PIInsuranceCompanyNameAllianceHealth().click();
			HCPPIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			HCPPIInsuranceGroupNumber().sendKeys(testData.get(9));
			HCPPIInsuranceMemberNumber().sendKeys(testData.get(10));
			HCPPIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			HCPPINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			HCPPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(3000);
			ConfirmButton().click();

		/*	boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
				   System.out.println("Waiting for Member ID");
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }
	*/
			Thread.sleep(15000);

			
			System.out.println("I am going to take the MemberID ");
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.HCPsetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CancelTreatmentEnrollInAdminPortal() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "CancelTreatmentSusvimoEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.E2EScenariosGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	Thread.sleep(4000);
			System.out.println("Before BrandButton");
			BrandButton().click();
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			HCPNewPatientNORadioButton().click();
			Thread.sleep(1000);
			LucentisCheckBox().click();
			Thread.sleep(2000);
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			HCPQuestion1().click();
			Thread.sleep(2000);
			HCPQuestion2().click();
			Thread.sleep(2000);
			HCPQuestion3().click();
			Thread.sleep(2000);
			HCPQuestion4().click();
			Thread.sleep(2000);
			HCPQuestion5().click();
			Thread.sleep(2000);
			
			HCPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			HCPQuestion6select().click();
			Thread.sleep(2000);
			
			HCPQuestion7().click();
			Thread.sleep(2000);
			HCPQuestion8().click();
			Thread.sleep(2000);
			HCPQuestion9().click();
			Thread.sleep(1000);
			HCPQuestion10().click();
			Thread.sleep(1000);
			

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			HCPPIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			//PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			System.out.println("Before clicking HCPPIInsuranceCompanyNameSelect");
			HCPPIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			System.out.println("Before clicking PIInsuranceCompanyNameAllianceHealth");
			PIInsuranceCompanyNameAllianceHealth().click();
			HCPPIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			HCPPIInsuranceGroupNumber().sendKeys(testData.get(9));
			HCPPIInsuranceMemberNumber().sendKeys(testData.get(10));
			HCPPIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			HCPPINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			HCPPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(3000);
			ConfirmButton().click();

		/*	boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
				   System.out.println("Waiting for Member ID");
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }
	*/
			Thread.sleep(15000);

			
			System.out.println("I am going to take the MemberID ");
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.E2EScenariossetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Susvimo2ndEnrollment() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "SmokePatientEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.SmokeGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	
			wait.until(ExpectedConditions.visibilityOf(EnrollButton()));
			EnrollButton().click();
			System.out.println("CLicked on Enroll button");
			Thread.sleep(8000);
			
			Thread.sleep(4000);
			System.out.println("Before BrandButton");
			BrandButton().click(); //Select Susvimo brand
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PatientRadioButton());
//			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			NewPatientYESRadioButton().click();
			System.out.println("After clicking Yes Button");
			Thread.sleep(1000);
			System.out.println("Member ID is:" +testData.get(20));
			ExistingMemberID().sendKeys(testData.get(20).trim());
			Thread.sleep(2000);
			System.out.println("DOB is:" +testData.get(3));
			ExistingDOB().sendKeys(testData.get(3));
			Thread.sleep(2000);
			ExistingMemberIDSubmitButton().click();
			Thread.sleep(2000);
			
			LucentisCheckBox().click();
			Thread.sleep(2000);
			SusvimoCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			HCPQuestion1().click();
			Thread.sleep(2000);
			HCPQuestion2().click();
			Thread.sleep(2000);
			HCPQuestion3().click();
			Thread.sleep(2000);
			HCPQuestion4().click();
			Thread.sleep(2000);
			HCPQuestion5().click();
			Thread.sleep(2000);
			
			HCPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			HCPQuestion6select().click();
			Thread.sleep(2000);
			
			HCPQuestion7().click();
			Thread.sleep(2000);
			HCPQuestion8().click();
			Thread.sleep(2000);
			HCPQuestion9().click();
			Thread.sleep(1000);
			HCPQuestion10().click();
			Thread.sleep(1000);
			

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			HCPPIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			//PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			System.out.println("Before clicking HCPPIInsuranceCompanyNameSelect");
			HCPPIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			System.out.println("Before clicking PIInsuranceCompanyNameAllianceHealth");
			PIInsuranceCompanyNameAllianceHealth().click();
			HCPPIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			HCPPIInsuranceGroupNumber().sendKeys(testData.get(9));
			HCPPIInsuranceMemberNumber().sendKeys(testData.get(10));
			HCPPIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			HCPPINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			HCPPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(3000);
			ConfirmButton().click();

		/*	boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
				   System.out.println("Waiting for Member ID");
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }
	*/
			Thread.sleep(15000);

			
			System.out.println("I am going to take the MemberID ");
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.E2EScenariossetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void TreatmentRejectLucentisEnrollInAdminPortal() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "HCPLucentisEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.HCPGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	Thread.sleep(4000);
			System.out.println("Before BrandButton");
			LucentisBrandButton().click();
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			HCPNewPatientNORadioButton().click();
			Thread.sleep(1000);
			LucentisCheckBox().click();
			Thread.sleep(2000);
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			LucentisHCPQuestion1().click();
			Thread.sleep(2000);
			HCPQuestion2().click();
			Thread.sleep(2000);
			HCPQuestion3().click();
			Thread.sleep(2000);
			LucentisHCPQuestion4().click();
			Thread.sleep(2000);
			LucentisHCPQuestion5().click();
			Thread.sleep(2000);
			
			HCPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			HCPQuestion6select().click();
			Thread.sleep(2000);
			
			LucentisHCPQuestion7().click();
			Thread.sleep(2000);
			LucentisHCPQuestion8().click();
			Thread.sleep(2000);
			LucentisHCPQuestion9().click();
			Thread.sleep(1000);
			LucentisHCPQuestion10().click();
			Thread.sleep(1000);
			

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			HCPPIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			//PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			System.out.println("Before clicking HCPPIInsuranceCompanyNameSelect");
			HCPPIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			System.out.println("Before clicking PIInsuranceCompanyNameAllianceHealth");
			PIInsuranceCompanyNameAllianceHealth().click();
			HCPPIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			HCPPIInsuranceGroupNumber().sendKeys(testData.get(9));
			HCPPIInsuranceMemberNumber().sendKeys(testData.get(10));
			HCPPIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			HCPPINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			HCPPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();

			/*boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }*/
			
			Thread.sleep(15000);
	


			
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.HCPsetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  
		         String Key1 = "HCPFaxAndTreatment";
		         gst.HCPsetMemberIDInExcel_OtherInsurance(Key1, MemberID, rowNum); //Writing back the member ID in excel     
			}
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LucentisEnrollInAdminPortal() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "HCPLucentisEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.HCPGetPhysicianNewPageRequiredFields(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	Thread.sleep(4000);
			System.out.println("Before BrandButton");
			LucentisBrandButton().click();
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(6000);
		//	wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			HCPNewPatientNORadioButton().click();
			Thread.sleep(1000);
			LucentisCheckBox().click();
			Thread.sleep(2000);
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			LucentisHCPQuestion1().click();
			Thread.sleep(2000);
			HCPQuestion2().click();
			Thread.sleep(2000);
			HCPQuestion3().click();
			Thread.sleep(2000);
			LucentisHCPQuestion4().click();
			Thread.sleep(2000);
			LucentisHCPQuestion5().click();
			Thread.sleep(2000);
			
			HCPQuestion6DropDownSelect().click();
			Thread.sleep(3000);
			HCPQuestion6select().click();
			Thread.sleep(2000);
			
			LucentisHCPQuestion7().click();
			Thread.sleep(2000);
			LucentisHCPQuestion8().click();
			Thread.sleep(2000);
			LucentisHCPQuestion9().click();
			Thread.sleep(1000);
			LucentisHCPQuestion10().click();
			Thread.sleep(1000);
			

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			HCPPIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			//PIStateSelect().click();
			Thread.sleep(2000);
			//PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			System.out.println("Before clicking HCPPIInsuranceCompanyNameSelect");
			HCPPIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			System.out.println("Before clicking PIInsuranceCompanyNameAllianceHealth");
			PIInsuranceCompanyNameAllianceHealth().click();
			HCPPIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			HCPPIInsuranceGroupNumber().sendKeys(testData.get(9));
			HCPPIInsuranceMemberNumber().sendKeys(testData.get(10));
			HCPPIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			HCPPINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			HCPPINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			HCPPINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			HCPPIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();

			/*boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }*/
			
			Thread.sleep(15000);
	


			
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.HCPsetMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EnrollInHCP() throws IOException, AWTException {
		//Regression excel sheet
	
		System.out.println("I am inside enrollment");
		String Key = "HCPEnrollment";
		System.out.println("The Key is:" +Key);
		int rowNum = etd.getKeyValuePair(Key);
		System.out.println("The rowNum is:" +rowNum);
		List<String> testData = new ArrayList<String>();
		testData = gst.RegressionHCP(Key, rowNum); //Same method for all Provider
		System.out.println("testdata is:" +testData);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			System.out.println("Before BrandButton");
			BrandButton().click();
		 	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(PatientRadioButton()));
			
			PatientRadioButton().click();
			Thread.sleep(2000);
			PatientRadioNextButton().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(NewPatientNORadioButton()));
		
			NewPatientNORadioButton().click();
			Thread.sleep(1000);
			LucentisCheckBox().click();
			Thread.sleep(2000);
			LucentisCheckBoxNextButton().click();
			Thread.sleep(6000);
			
			//Eligibility screen
			//String abs=data().getText();
			System.out.println("I am inside Eligibility screen");
			Question1().click();
			Thread.sleep(2000);
			Question2().click();
			Thread.sleep(2000);
			Question3().click();
			Thread.sleep(2000);
			Question4().click();
			Thread.sleep(2000);
			Question5().click();
			Thread.sleep(2000);
			
			Question6DropDownSelect().click();
			Thread.sleep(3000);
			Question6select().click();
			Thread.sleep(2000);
			
			Question7().click();
			Thread.sleep(2000);
			Question8().click();
			Thread.sleep(2000);
			Question9().click();
			Thread.sleep(1000);
			Question10().click();
			Thread.sleep(1000);
		//	Question11().click();

			EligibilityNextButton().click();
			
			//Patient information screen
			
			PIFirstName().sendKeys(testData.get(1));
			
			//Set patient last name into excel
			
			String randomPatientLastName = TestUtil.randomAlpha(3);
			System.out.println("The randomPatientLastName is:" +randomPatientLastName);
			
			PILastName().sendKeys(randomPatientLastName);
			PIGenderSelect().click();
			Thread.sleep(2000);
			PIGenderSelectFemale().click();
			Thread.sleep(2000);
			//PIGender().selectByIndex(1);
			PIBirthDate().sendKeys(testData.get(3));
			PIAddress1().sendKeys(testData.get(4));
			PICity().sendKeys(testData.get(5));
			PIStateSelect().click();
			Thread.sleep(2000);
			PIStateAlaska().click();
			PIZipCode().sendKeys(testData.get(7));
			PIPhoneNumber().sendKeys(testData.get(8));
			
			//Commercial Medical Insurance Information
			PIInsuranceCompanyNameSelect().click();
			Thread.sleep(2000);
			PIInsuranceCompanyNameAllianceHealth().click();
			PIInsurancePlanTypeSelect().click();
			Thread.sleep(2000);
			PIInsurancePlanTypeEPO().click();
			PIInsuranceGroupNumber().sendKeys(testData.get(9));
			PIInsuranceMemberNumber().sendKeys(testData.get(10));
			PIInsuranceEffDate().sendKeys(testData.get(11));
			Thread.sleep(2000);
			PIInsuranceCheckBox().click();
			Thread.sleep(2000);
			PIPII().click();
			Thread.sleep(2000);
			PINextButton().click();
			
			//Provider information
			PINPI().sendKeys(testData.get(12));
			Thread.sleep(2000);
			PINPIFindButton().click();
			Thread.sleep(2000);
			PINPISelect().click();
			Thread.sleep(6000);
		
			//Search for the patient's site of care
			/*
			PIPracticeLastName().sendKeys(testData.get(13));
			PISiteOfCareCity().sendKeys(testData.get(14));
			PISiteOfCareStateSelect().click();
			Thread.sleep(1000);
			PISiteOfCareStateAlaska().click();
			Thread.sleep(1000);
			PISiteOfCareFindButton().click();
			//site of care info
			
			PIPracticeName().sendKeys("Test");
			PIPracticeAddress().sendKeys("345 test ave");
			PIPracticeCity().sendKeys("Whippany");
			PIPracticeStateSelect().click();
			Thread.sleep(2000);
			PIPracticeStateAlaska().click();
			Thread.sleep(2000);
			PIPracticeZipcode().sendKeys("67356");*/
			Thread.sleep(2000);
			PINPIPhoneNumber().clear();
			Thread.sleep(4000);
			System.out.println("The phone number is:" +testData.get(19));
			PINPIPhoneNumber().sendKeys(testData.get(19));
			Thread.sleep(2000);
			PIProviderNextButton().click();
			
			//Verify information
			Thread.sleep(4000);
			VerifyAllCheckBox().click();
			Thread.sleep(2000);
			ConfirmButton().click();

			boolean load = true;
			while(load == true) {
			   if(ConfirmButton().isDisplayed() == true) {
			      	Thread.sleep(1000);
			    }
			   load= ConfirmButton().isDisplayed();
			 }
	
			String retval=GetMemberId().getText();
			System.out.println("The MemberID is:" +retval);
			//Split function
			for (String MemberID:retval.split(":")) {
		         System.out.println(MemberID);
		         gst.setMemberIDInExcel_OtherInsurance(Key, MemberID, rowNum); //Writing back the member ID in excel
		         if (MemberID!=null) {
		        		TestBase.classAInstance.logReport("Pass", "Enrollment through Patient portal", "Succesfully enrolled a patient:" +MemberID);
					} else {
						System.out.println("The member ID is null");
						TestBase.classAInstance.logReport("Fail", "Enrollment through Patient portal", "Failed to enrolled a patient");
					}  }
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	// *************************************************************************************************
	

	 public  void HCPLogout() throws InterruptedException, IOException, AWTException {
		 System.out.println("I am inside Logout method");
			AccountInfo().click();
			Thread.sleep(2000);
			System.out.println("I clicked on Account info");
			HubHomePageLogoutButton().click();
			Thread.sleep(2000);
			System.out.println("I clicked on logout");
			if(isPopupOpen()) {
				HCPPopUpMsgCloseButton().click();
				Thread.sleep(2000);
			}
			Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	 }
	
	 public  void HCPUserAccount() throws InterruptedException, IOException, AWTException {
		
			AccountInfo().click();
			Thread.sleep(2000);
			
			HCPHomePageMyProfileButton().click();
			Thread.sleep(4000);
			System.out.println("HCPMyProfileLandingMessage i am in");
			if (HCPMyProfileLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP User Account", "Succesfully able to verify My profile in User Account");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP User Account", "Failed to verify My profile in User Account");
			}
			
			AccountInfo().click();
			Thread.sleep(2000);
			HCPHomePageChangePasswordButton().click();
			System.out.println("HCPHomePageChangePasswordButton i am in");
			Thread.sleep(4000);
			if (HCPChangePasswordLandingMessage().isDisplayed()== true) {
				TestBase.classAInstance.logReport("Pass", "HCP User Account", "Succesfully able to verify Change Password in User Account");
			} else {
				TestBase.classAInstance.logReport("Fail", "HCP User Account", "Failed to verify Change Password in User Account");
			}
			
			AccountInfo().click();
			Thread.sleep(2000);
			HubHomePageLogoutButton().click();
			Thread.sleep(2000);
			String welcomeMsg = driver.findElement(By.xpath(("//*[contains(text(),'Log in to Your Account')]"))).getText();
			System.out.println("The welcomeMsg is $$$$$$$$$$$$$:" +welcomeMsg); 

			//Assert.assertEquals(title, ExpectedTitle);
			Assert.assertTrue(welcomeMsg.contains("Log in to Your Account"));
			if (welcomeMsg.equalsIgnoreCase("Log in to Your Account")) {
				TestBase.classAInstance.logReport("Pass", "Able to logout", "Succesfully able to logout-3");
			} else {
				TestBase.classAInstance.logReport("Fail", "Not able to logout", "Failed to logout-3");
			}
				
	 }
	

	
	 public boolean HubPortalLogin() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, 60);

		 HCPPopUpMsgCloseButton().click();
		Thread.sleep(2000);
			
		boolean result = false;
		String uname = prop.getProperty("HCPusername");
		String pwd = prop.getProperty("HCPpassword").trim();

		String ExpectedTitle = prop.getProperty("ExpectedHubPageTitleAfterLogin");
	//	String ProgramForLogin = prop.getProperty("programforLogin"); 

		try {
			UserID().clear();
			UserID().sendKeys(uname);
			Thread.sleep(1000);
			Password().clear();
			Password().sendKeys(pwd);
			Thread.sleep(1000);

		//	Select Program = new Select(ProgramSelect());

			// Program.selectByVisibleText("Alecensa");
		//	Program.selectByVisibleText(ProgramForLogin);
			SubmitButton().click();
		//	Thread.sleep(1000);

			String title = driver.getTitle();
			System.out.println(title);
			wait.until(ExpectedConditions.visibilityOf(UserMenuButton()));

		//	String welcomeMsg = driver.findElement(By.xpath("//div[@class='form-container']")).getText();
		//	System.out.println(welcomeMsg); 

			//Assert.assertEquals(title, ExpectedTitle);
		//	Assert.assertTrue(welcomeMsg.contains("Welcome"));
			result = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	 
	 public boolean HubPortalHomePageLogout()
	 {
		 boolean result = false;
		 HubHomePageLogoutButton().click();
		 result=true;
		 return result;
	 }
}