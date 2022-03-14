package com.juno.qa.pages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;

public class HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	public HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientAndCardInfotab()
	{
		return driver.findElement(By.linkText("Patient/Card Info"));
	}
	
	public WebElement MemberIDSearchField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list_filter']/label/input"));
	}
	
	public WebElement FirstReviewLink()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[7]/form/input[@value='Review']"));
	}
	
	public WebElement PatientsListSearchResult()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody"));
		
		
	}
	
	public WebElement PatientsListSearchFirstNameField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[3]"));
		
	}
	
	public WebElement PatientsListSearchLastNameField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[2]"));
		
	}
	
	public WebElement PatientsListSearchPartnerPatientIDField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[5]"));
		
	}
	
	public WebElement PatientReviewPatientCardFirstName()
	{
		return driver.findElement(By.id("patient_firstName"));
	}
	
	public WebElement PatientReviewPatientCardLastName()
	{
		return driver.findElement(By.id("patient_lastName"));
	}
	
	public WebElement PatientReviewPatientCardDOB()
	{
		return driver.findElement(By.id("patient_dob"));
	}
	
	public WebElement PatientReviewPatientCardAddress()
	{
		return driver.findElement(By.id("patient_address1"));
	}
	
	public WebElement PatientReviewPatientCardCity()
	{
		return driver.findElement(By.id("patient_city"));
	}
	
	public Select PatientReviewPatientCardStates()
	{
		Select statesList = new Select(driver.findElement(By.id("patient_state")));
		return statesList;
		 
	}
	
	public WebElement PatientReviewPatientCardState()
	{
		return driver.findElement(By.id("patient_state"));
		 
	}
	
	public String PatientReviewPatientCardUpdateConfirmationMessage()
	{
		return driver.findElement(By.xpath("//article[@class='content patientProfile']//font[@color='green']")).getText();
	}
	
	public List<WebElement> GetListofStates()
	{
		List<WebElement> statesList = driver.findElements(By.xpath("//*[@id='patient_state']/option"));
		return statesList;
	}
	
	
	public WebElement PatientReviewPatientCardZipCode()
	{
		return driver.findElement(By.id("patient_postalCode"));
	}
	
/*	public WebElement PatientReviewPatientCardEnrollmentDate()
	{
		return driver.findElement(By.id("enrollmentDate"));
	} */

	public WebElement PatientReviewPatientCardPartnerPatientID()
	{
		return driver.findElement(By.id("patient_partnerId"));
	}
	
	public WebElement PatientReviewPatientCardUpdateButton()
	{
		return driver.findElement(By.xpath("//input[@name = 'Submit']"));
	}
	
	public WebElement PatientReviewPatientCardStaticMemberID()
	{
		return driver.findElement(By.xpath("//article[@class='content patientProfile']/section/div[2][@id='tabs']/div[@id='tabs-1']/form/div[@class='pi_tab1 left']/p[1]/label[2]"));
	}
	
	public WebElement PatientReviewPatientCardStaticGroupNumber()
	{
		return driver.findElement(By.xpath("//article[@class='content patientProfile']/section/div[2][@id='tabs']/div[@id='tabs-1']/form/div[@class='pi_tab1 left']/p[3]/label[2]"));
	}
	
	public WebElement PatientReviewPatientCardStaticEnrollmentStatus()
	{
		return driver.findElement(By.xpath("//article[@class='content patientProfile']/section/div[2][@id='tabs']/div[@id='tabs-1']/form/div[2][@class='pi_tab1 left second_row']/p[3]/label[2]"));
	}
	
	public String PatientReviewPatientCardFirstNameValue()
	{
		return driver.findElement(By.id("patient_firstName")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardLastNameValue()
	{
		return driver.findElement(By.id("patient_lastName")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardDOBValue()
	{
		return driver.findElement(By.id("patient_dob")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardAddressValue()
	{
		return driver.findElement(By.id("patient_address1")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardCityValue()
	{
		return driver.findElement(By.id("patient_city")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardStateValue()
	{
		return PatientReviewPatientCardStates().getFirstSelectedOption().getText();
	}
	
	public String PatientReviewPatientCardZipCodeValue()
	{
		return driver.findElement(By.id("patient_postalCode")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardPartnerPatientIDValue()
	{
		return driver.findElement(By.id("patient_partnerId")).getAttribute("value");
	}
	
	public String PatientReviewPatientCardStaticMemberIDValue()
	{
		return PatientReviewPatientCardStaticMemberID().getText();
	}
	
	public String PatientReviewPatientCardStaticGroupNumberValue()
	{
		return PatientReviewPatientCardStaticGroupNumber().getText();
	}
	
	public String PatientReviewPatientCardStaticEnrollmentStatusValue()
	{
		return PatientReviewPatientCardStaticEnrollmentStatus().getText();
	}
	
	public String EnrollmentTypeValue()
	{
		Select enrollmentType = new Select(driver.findElement(By.name("patient_enrollmentType")));
		return enrollmentType.getFirstSelectedOption().getText();
	}
	
	public WebElement PatientReviewPatientCardMobileNumber()
	{
		return driver.findElement(By.id("patient_mobilePhone"));
	}
	
	public WebElement RadioButtonMale()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs']/div[@id='tabs-1']/form/div[3]/section[5]/div[13]/p/input[1]"));
		return driver.findElement(By.xpath("//input[@id='patient_gender'][@value = 'male']"));
	}
	
	public WebElement RadioButtonFemale()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs']/div[@id='tabs-1']/form/div[3]/section[5]/div[13]/p/input[2]"));
		return driver.findElement(By.xpath("//input[@id='patient_gender'][@value = 'female']"));
	}
	
	public WebElement RadioButtonOther()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[@id='tabs-1']/form/div[3]/section[5]/div[13]/p/input[3]"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.id("patient_partnerId"));
	}
	
	public List<WebElement> InsuranceNamesInDropdown()
	{
		return driver.findElements(By.xpath("//select[@id='insurances_payerName']/option"));
	}
	
	public Select InsurancesPayerNameDropdown()
	{
		Select insPayerName = new Select(driver.findElement(By.id("insurances_payerName")));
		return insPayerName;
	}
	
	public WebElement InsuranceGroupNumber()
	{
		return driver.findElement(By.id("insurances_groupNumber"));
	}
	
	public WebElement InsuranceMemberID()
	{
		return driver.findElement(By.id("insurances_memberId"));
	}
	
	public WebElement InsuranceBINNumber()
	{
		return driver.findElement(By.id("insurances_bin"));
	}
	
	public WebElement InsurancePCNNumber()
	{
		return driver.findElement(By.id("insurances_pcn"));
	}
	
	public WebElement HIPAADate()
	{
		return driver.findElement(By.id("associations_consent_hipaa-authorization"));
	}
	
	
	
	public static String UpdateDateInDOBToOneDigit(char[] dateDigits)
	{
		String DOD = Character.toString(dateDigits[1]);
		return DOD;
	}
	
	public static void SelectDate(String YOD, String MOD, String DOD)
	{
		 Select Year = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        Year.selectByValue(YOD);
	       // Thread.sleep(3000);
	        Select monthName = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        monthName.selectByVisibleText(MOD);
	      //  Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
	        for (WebElement col: columns)
	        { 
	           if (col.getText().equals(DOD))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DOD)).click();
	              break;
	           }
	        }
	}
	
	public String[] UpdatePatientInfoInHub(List<String> testData) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LocalDate todayDate = java.time.LocalDate.now();
		int today = todayDate.getDayOfMonth();
		String todayNum = String.valueOf(today);
		String[] PatientEnrollmentInfo = new String[5];
		
		String EnrollDate = "";
		String PartnerPatientID = "";
		String DateOfBirth = "";
		String State = "";
		String GroupNumber = "";
	    String EnrollmentStatus = "";
	    String Gender = "";
	 //   String InsGrpName = "";
		
		PatientReviewPatientCardFirstName().clear();
	    PatientReviewPatientCardFirstName().sendKeys(testData.get(0));
	    Thread.sleep(1000);
	    PatientReviewPatientCardLastName().clear();
	    PatientReviewPatientCardLastName().sendKeys(testData.get(1));
	    Thread.sleep(1000);
	    //The following is for selecting the DOB
	    System.out.println("DOB:"+testData.get(2));
		String[] DOB = testData.get(2).split(" ");
        String YOD = DOB[5];
        String MOD = DOB[1];
        String DOD = DOB[2];

        System.out.println(MOD);
        System.out.println(DOD);
        
        PatientReviewPatientCardDOB().click(); 
        
        char[] dateDigits = DOD.toCharArray();
        if(dateDigits[0] == '0')
        {
        	String SingleDOD = UpdateDateInDOBToOneDigit(dateDigits);
        	System.out.println("Single digit DOD: "+SingleDOD);
        	SelectDate(YOD, MOD, SingleDOD);
        }
        else
        {
        	SelectDate(YOD, MOD, DOD);
        }
        
        Thread.sleep(2000);
        
        PatientReviewPatientCardAddress().clear();
        PatientReviewPatientCardAddress().sendKeys(testData.get(3));
        Thread.sleep(1000);
        PatientReviewPatientCardCity().clear();
        PatientReviewPatientCardCity().sendKeys(testData.get(4));
        Thread.sleep(1000);
        int randomStateNum = cf.SelectRandomState(GetListofStates());
        GetListofStates().get(randomStateNum).click();
        
  
        PatientReviewPatientCardZipCode().click();
        Thread.sleep(2000);
        for(int i=1;i<=5;i++)
        {
        	PatientReviewPatientCardZipCode().sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        }
        
        System.out.println("Before Zip update:"+testData.get(5));
        PatientReviewPatientCardZipCode().sendKeys(testData.get(5));
        System.out.println("After Zip update:");
        //phone, partnerpatientid, gender, payername, insgrpnum, insmemnum, hippadate
        PatientReviewPatientCardMobileNumber().clear();
        Thread.sleep(1000);
        PatientReviewPatientCardMobileNumber().sendKeys(testData.get(8));
        Thread.sleep(1000);
     /*   PartnerPatientID().clear();
        PartnerPatientID().sendKeys(testData.get(9));
        Thread.sleep(3000); */
        
        if(RadioButtonMale().isSelected())
        {
        	RadioButtonFemale().click();
        	Gender = "Female";
        }
        else
        {
        	RadioButtonMale().click();
        	Gender = "Male";
        }
        
    /*    int randomInsNum = cf.SelectRandomInsuranceName(InsuranceNamesInDropdown());
        InsuranceNamesInDropdown().get(randomInsNum).click();
        
        InsuranceGroupNumber().clear();
        InsuranceGroupNumber().sendKeys(testData.get(10));
        
        InsuranceMemberID().clear();
        InsuranceMemberID().sendKeys(testData.get(11));
      
        HIPAADate().click();
		Thread.sleep(1000);
		WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	        	if (col.getText().equals(todayNum)) {
	                col.click();
	                break;
	            }
	        }
	        Thread.sleep(3000);
        Thread.sleep(2000); */
       
        PatientReviewPatientCardUpdateButton().click();
        Thread.sleep(10000);
        Assert.assertEquals(PatientReviewPatientCardUpdateConfirmationMessage(), testData.get(6));
        
        PartnerPatientID = PatientReviewPatientCardPartnerPatientID().getAttribute("value");
        System.out.println("PartnerPatientID: "+PartnerPatientID);
        DateOfBirth = PatientReviewPatientCardDOB().getAttribute("value");
        System.out.println("DateOfBirth: "+DateOfBirth);
        State = PatientReviewPatientCardStates().getFirstSelectedOption().getText();
        System.out.println("State: "+State);
        GroupNumber = PatientReviewPatientCardStaticGroupNumber().getText();
        EnrollmentStatus = PatientReviewPatientCardStaticEnrollmentStatus().getText();
        
     //   PatientEnrollmentInfo[0] = PartnerPatientID;
        PatientEnrollmentInfo[0] = GroupNumber;
        PatientEnrollmentInfo[1] = EnrollmentStatus;
        PatientEnrollmentInfo[2] = DateOfBirth;	   
        PatientEnrollmentInfo[3] = State;
        PatientEnrollmentInfo[4] = Gender;
      //  PatientEnrollmentInfo[6] = InsurancesPayerNameDropdown().getFirstSelectedOption().getText();
		 
		return PatientEnrollmentInfo;
	} 
	


}
