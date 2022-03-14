package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;

public class AdminPortal_Patients_PatientAndCardTabPage extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	AdminPortal_Patients_InsuranceTabPage aip = new AdminPortal_Patients_InsuranceTabPage();
	AdminPortalLoginLogoutPage all = new AdminPortalLoginLogoutPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage apf = new AdminPortal_Patients_FindPage();
//	AdminPortal_Patients_PatientAndCardTabPage app = new AdminPortal_Patients_PatientAndCardTabPage();
	
	public AdminPortal_Patients_PatientAndCardTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientAndCardTab()
	{
		return driver.findElement(By.linkText("Patient & Card"));
	} 
	
	public WebElement PatientAndCardTabUpdateButton()
	{
		return driver.findElement(By.name("update"));
	}
	
	public WebElement PatientAndCardTabTitle()
	{
		return driver.findElement(By.name("patient_name_title"));
	}
	
	
	public WebElement PatientAndCardTabFirstName()
	{
		return driver.findElement(By.name("corp_api_field[patient][firstName]"));
	}
	
	public WebElement PatientAndCardTabMiddleInitial()
	{
		return driver.findElement(By.name("corp_api_field[patient][middleName]"));
	}
	
	public WebElement PatientAndCardTabLastName()
	{
		return driver.findElement(By.name("corp_api_field[patient][lastName]"));
	}
	
	public Select PatientAndCardTabGender()
	{
		Select gender = new Select(driver.findElement(By.id("gender")));
		return gender;
	}
	
	public WebElement PatientAndCardTabGenderDropDown()
	{
		return driver.findElement(By.id("gender"));
	}
	
	public WebElement PatientAndCardTabLoginID()
	{
		return driver.findElement(By.name("patient_login_id"));
	}
	
	public WebElement PatientAndCardTabMemberID()
	{
		//return driver.findElement(By.name("patient_other_id"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_1']/form/div/table/tbody/tr/td/table/tbody/tr[17]/td[2]"));
	}
	
	public WebElement PatientAndCardTabPartnerPatientID()
	{
		return driver.findElement(By.name("corp_api_field[patient][partnerId]"));
	}
	
	public Select PatientAndCardTabPatientStatus()
	{
		//This is patient status/status drop down
		Select patientStatus = new Select(driver.findElement(By.name("patient_status")));
		return patientStatus;
	}
	
	public WebElement PatientAndCardTabDOB()
	{
		return driver.findElement(By.name("corp_api_field[patient][dob]"));
	}
	
	public WebElement PatientAndCardTabEnrollmentGroupNumber()
	{
		return driver.findElement(By.name("enrollment_group_number"));
	}
	
	public WebElement PatientAndCardTabActivationDate()
	{
		return driver.findElement(By.id("enroll_date"));
	}
	
	public WebElement PatientAndCardTabAddress1()
	{
		return driver.findElement(By.name("corp_api_field[patient][address1]"));
	}
	
	public WebElement PatientAndCardTabCity()
	{
		return driver.findElement(By.name("corp_api_field[patient][city]"));
	}
	
	public WebElement PatientAndCardTabZip()
	{
		return driver.findElement(By.name("corp_api_field[patient][postalCode]"));
	}
	
	public WebElement PatientAndCardCellNumber()
	{
		return driver.findElement(By.name("corp_api_field[patient][mobilePhone]"));
	}
	
	public WebElement AuthorizationDate()
	{
		return driver.findElement(By.name("consents[hipaa-authorization]"));
	}
	
	public Select PatientAndCardTabState()
	{
		Select statesList = new Select(driver.findElement(By.name("corp_api_field[patient][state]")));
		return statesList;
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
		//return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[16]/td[2]")).getText();//updatde 10252021
		return driver.findElement(By.name("corp_api_field[patient][shortcardId]")).getAttribute("value");
		
	}
	
	public String PatientAndCardTabActivationDateValue()
	{
		return driver.findElement(By.id("enroll_date")).getAttribute("value");
	}
	
	public String PatientAndCardTabEnrollmentGroupNumberValue()
	{
		//return driver.findElement(By.name("enrollment_group_number")).getAttribute("value");
		//return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[17]/td[2]")).getText(); updated for replatform
		return driver.findElement(By.name("corp_api_field[patient][groupNumber]")).getAttribute("value");
		
	}
	
	public String PatientAndCardTabPatientStatusValue()
	{
		return PatientAndCardTabPatientStatus().getFirstSelectedOption().getText();
	}
	
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
	
	public String PatientAndCardCellNumberValue()
	{
		return PatientAndCardCellNumber().getAttribute("value");
	}
	
	public String PatientAndCardUpdateConfirmationMessage()
	{
		return driver.findElement(By.xpath("//*[@id='patient_form']/div/table/tbody/tr[3]/td/font")).getText();
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
	
	public String MobilePhoneValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][mobilePhone]")).getAttribute("value");
	}
	
	public String HomePhoneValue()
	{
		return driver.findElement(By.name("corp_api_field[patient][homePhone]")).getAttribute("value");
	}
	
	public String CardIDValue()
	{
		return driver.findElement(By.name("patient_short_card_id")).getAttribute("value");
	}
	
	public String EnrollmentTypeValue()
	{
		Select enrollmentList = new Select(driver.findElement(By.name("patient_enrollment_type")));
		return enrollmentList.getFirstSelectedOption().getText();
	}
	
	public String DrugReimbursementValue()
	{
		return driver.findElement(By.name("drug_reimbursement")).getAttribute("value");
	}
	
	public String ProcedureReimbursementValue()
	{
		return driver.findElement(By.name("procedure_reimbursement")).getAttribute("value");
	}
	
	public String AuthorizationDateValue()
	{
		return driver.findElement(By.name("authorization_date")).getAttribute("value");
	}
	
	public String ConfirmationNumberValue()
	{
		return driver.findElement(By.name("patient_confirmation_id")).getAttribute("value");
	}
	
	/* ************************************** Program and benefit balances *********************************************** */
	public String AvailableCopayValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr[7]/td[2]")).getText();
	}
	
	
	public static void SelectDate(String YOD, String MOD, String DOD) throws InterruptedException
	{
		 Select Year = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        Year.selectByValue(YOD);
	      //  Thread.sleep(3000);
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
	       // Thread.sleep(3000);
	}
	
	public String[] UpdatePatientInfoInAdmin(List<String> testData) throws InterruptedException, ParseException
	{
		LocalDate todayDate = java.time.LocalDate.now();
		String currentDate = todayDate.toString();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(currentDate);
	    String todaysDate = new SimpleDateFormat("dd-MMM-yyyy").format(date);
		int today = todayDate.getDayOfMonth();
		String todayNum = String.valueOf(today);
		System.out.println("Today num:"+todayNum);
		String[] PatientEnrollmentInfo = new String[5];
		
		String PartnerPatientID = "";
		String DateOfBirth = "";
		String State = "";
		String MemberID = "";
		String GroupNumber = "";
	    String EnrollmentStatus = "";
	    String Gender = "";
	    
		
	    PatientAndCardTabFirstName().clear();
	    PatientAndCardTabFirstName().sendKeys(testData.get(1));
	    PatientAndCardTabLastName().clear();
	    PatientAndCardTabLastName().sendKeys(testData.get(2));
	    
	  /*  //The following is for selecting the DOB
	    System.out.println("DOB:"+testData.get(3));
		String[] DOB = testData.get(2).split(" ");
        String YOD = DOB[5];
        String MOD = DOB[1];
        String DOD = DOB[2];

        System.out.println(MOD);
        System.out.println(DOD);
        
        PatientAndCardTabDOB().click(); 
        
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
        */
        Thread.sleep(2000);
        
        PatientAndCardTabAddress1().clear();
        PatientAndCardTabAddress1().sendKeys(testData.get(4));
        PatientAndCardTabCity().clear();
        PatientAndCardTabCity().sendKeys(testData.get(5));
        Thread.sleep(2000);
        //Select a state name in the state drop down randomly
       // PatientReviewPatientCardState().click();
        int randomStateNum = cf.SelectRandomState(GetStatesList());
        GetStatesList().get(randomStateNum).click();
        Thread.sleep(2000);
        
        //zipcode 
        /*PatientAndCardTabZip().click();
        Thread.sleep(2000);
   
        for(int i=1;i<=5;i++)
        {
        	PatientAndCardTabZip().sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        }
        Thread.sleep(2000);
        System.out.println("Before Zip update:"+testData.get(7));
        PatientAndCardTabZip().sendKeys(testData.get(7));
        System.out.println("After Zip update:");
        */
        
        if(PatientAndCardTabGender().getFirstSelectedOption().getText().equalsIgnoreCase("Male"))
        {
        	PatientAndCardTabGenderDropDown().click();
        	PatientAndCardTabGender().selectByVisibleText("Female");
        	Gender = "Female";
        }
        else
        {
        	PatientAndCardTabGenderDropDown().click();
        	PatientAndCardTabGender().selectByVisibleText("Male");
        	Gender = "Male";
        }
       
        PatientAndCardCellNumber().click();
        Thread.sleep(2000);
        for(int i=1;i<=10;i++)
        {
        	PatientAndCardCellNumber().sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        }
        PatientAndCardCellNumber().sendKeys(testData.get(11));
        
        //AuthorizationDate().click();
		Thread.sleep(1000);
		/*WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	        	if (col.getText().equals(todayNum)) {
	                col.click();
	                break;
	            }
	        } */
	//	cf.SelectDate(todaysDate);
	        Thread.sleep(3000);
     
        
   //     PatientAndCardTabPartnerPatientID().clear();
   //     PatientAndCardTabPartnerPatientID().sendKeys(testData.get(9));
        
        
        PatientAndCardTabUpdateButton().click();
        Thread.sleep(10000);
 
        //Assert.assertTrue(PatientAndCardUpdateConfirmationMessage().contains("Patient Update Response: Success"));
        
        //PartnerPatientID = PatientAndCardTabPartnerPatientIDValue(); //its not there in Replatform
        //System.out.println("PartnerPatientID: "+PartnerPatientID);
        
        DateOfBirth = PatientAndCardTabDOBValue();
        System.out.println("DateOfBirth: "+DateOfBirth);
        
        //State = PatientAndCardTabPatientResidingStateValue();//its not there in Replatform
        //System.out.println("State: "+State);
        
        MemberID = PatientAndCardTabMemberIDValue();
        System.out.println("The MemberID is:" +MemberID);
        GroupNumber = PatientAndCardTabEnrollmentGroupNumberValue();
        System.out.println("The GroupNumber is:" +GroupNumber);
        EnrollmentStatus = PatientAndCardTabPatientStatusValue();
        System.out.println("The EnrollmentStatus is:" +EnrollmentStatus);
       
        
     //   PatientEnrollmentInfo[0] = PartnerPatientID;
        PatientEnrollmentInfo[0] = GroupNumber;
        PatientEnrollmentInfo[1] = EnrollmentStatus;
        PatientEnrollmentInfo[2] = DateOfBirth;	   
        PatientEnrollmentInfo[3] = State;
        PatientEnrollmentInfo[4] = Gender;
    //    PatientEnrollmentInfo[6] = Gender;	
		 
		return PatientEnrollmentInfo;
	}
	
	public void VerifyInfoInPatientAndCardTab(List<String> testData) throws InterruptedException, IOException, AWTException
	{
			String GrpNum = prop.getProperty("GenentechGroupNumber").trim();
			System.out.println(testData.get(2));
			Assert.assertEquals(PatientAndCardTabEnrollmentGroupNumberValue(), GrpNum); //group number
			Assert.assertTrue( testData.get(1).equalsIgnoreCase(PatientAndCardTabFirstNameValue())); //first name
			//Assert.assertTrue(testData.get(2).equalsIgnoreCase(PatientAndCardTabLastNameValue())); //last name
			
			String[] dateFromUI = PatientAndCardTabDOBValue().split("-");//0-yr,1-mon, 2-day
			int monNum = Integer.parseInt(dateFromUI[1]);
			dateFromUI[1] = cf.ConvertToMonthString(monNum);
			String updatedDOB = dateFromUI[2]+"-"+dateFromUI[1]+"-"+dateFromUI[0];
			System.out.println("updateddob: "+updatedDOB);
		//	Assert.assertEquals(updatedDOB, testData.get(3)); 		//DOB

			
			
			//Assert.assertEquals(PatientAndCardTabGenderValue(), testData.get(5)); //Gender
			//Assert.assertEquals(PatientAndCardTabPartnerPatientIDValue(), testData.get(6)); //partner patient ID
			Assert.assertEquals(PatientAndCardTabAddress1Value(), testData.get(4)); //address
			Assert.assertEquals(PatientAndCardTabCityValue(), testData.get(5)); //city
			//Assert.assertEquals(PatientAndCardTabPatientResidingStateValue(), testData.get(6)); //state
			Assert.assertEquals(PatientAndCardTabZipValue().substring(0, 5), testData.get(7).substring(0, 5)); //zipcode
//			String[] cellFromUI = PatientAndCardCellNumberValue().split("-"); //mobile number
//			String updatedCellFromUI = cellFromUI[0]+cellFromUI[1]+cellFromUI[2]; 
//			System.out.println("Updated cell number: "+updatedCellFromUI);
//			Assert.assertEquals(updatedCellFromUI, testData.get(11));
			//Assert.assertEquals(PatientAndCardTabMemberIDValue(), testData.get(0)); //member ID
			
			//reporting
			
			
			aip.InsuranceTab().click();
			Thread.sleep(5000);
			//Assert.assertEquals(aip.InsuranceTabInsuranceCompanyNameValue(), testData.get(12));
			Assert.assertEquals(aip.InsuranceTabInsuranceGroupNumberValue(), testData.get(9));
			Assert.assertEquals(aip.InsuranceTabInsuranceMemberNumberValue(), testData.get(10));
			//Assert.assertEquals(aip.InsuranceTabInsuranceBINValue(), testData.get(15));
			//Assert.assertEquals(aip.InsuranceTabInsurancePCNValue(), testData.get(16));
			//reporting
			if(aip.InsuranceTabInsuranceMemberNumberValue().equalsIgnoreCase(testData.get(10)))
		    {
		    	TestBase.classAInstance.logReport("Pass","insurance tab verification","Succesfully able to verify insurance tab verification");
		    }
		    else
		    {
		    	TestBase.classAInstance.logReport("Fail","insurance tab verification","Failed to verify insurance tab verification");
		    } 
			
	
	}
	
	public boolean VerifyZipCodeUpdateInAdmin(String MemberID, String ZipCode) throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean verify = true;
		if(verify)
		{
			try
			{
				intializeAdminDriver();
			}
			catch(InterruptedException ie)
			{
				
			}
			all.AdminPortalLogin();
			wait.until(ExpectedConditions.visibilityOf(ahp.PatientsLink()));	
			
			ahp.PatientsLink().click();
			Thread.sleep(1000);
			ahp.FindLink().click();
			Thread.sleep(1000);
			apf.PatientsFindPageMemberID().sendKeys(MemberID);
			apf.PatientsPageFindButton().click();
			Thread.sleep(2000);
			apf.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(PatientAndCardTab()));
			System.out.println("Admin Zip value:"+PatientAndCardTabZipValue().substring(0, 5));
			//reporting
				if(PatientAndCardTabZipValue().substring(0, 5).equalsIgnoreCase(ZipCode))
				{
					TestBase.classAInstance.logReport("Pass","Verify ZipCode from enrollment/update in AdminPortal","Succesfully able to  Verify ZipCode from enrollment/update in AdminPortal");
				 }
				 else
				 {
				    TestBase.classAInstance.logReport("Fail","Verify ZipCode from enrollment/update in AdminPortal","Failed to  Verify ZipCode from enrollment/update in AdminPortal");
				 }
			
				all.AdminPortalLogoutButton().click();
				driver.quit();
			
			return verify;
		}
		verify = false;
		return verify;
	}
	
/*	public String[] UpdatePatientInfoInAdmin(String PatientFirstName, String PatientLastName, String PatientDOB, String PatientAddress, String PatientCity, String PatientZipCode) throws InterruptedException
	{
		String[] PatientEnrollmentInfo = new String[6];
		
		String PartnerPatientID = "";
		String DateOfBirth = "";
		String State = "";
		String MemberID = "";
		String GroupNumber = "";
	    String EnrollmentStatus = "";
		
	    PatientAndCardTabFirstName().clear();
	    PatientAndCardTabFirstName().sendKeys(PatientFirstName);
	    PatientAndCardTabLastName().clear();
	    PatientAndCardTabLastName().sendKeys(PatientLastName);
	    
	    //The following is for selecting the DOB
	    System.out.println("DOB:"+PatientDOB);
		String[] DOB = PatientDOB.split(" ");
        String YOD = DOB[5];
        String MOD = DOB[1];
        String DOD = DOB[2];

        System.out.println(MOD);
        System.out.println(DOD);
        
        PatientAndCardTabDOB().click(); 
        
        char[] dateDigits = DOD.toCharArray();
        if(dateDigits[0] == 0)
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
        
        PatientAndCardTabAddress1().clear();
        PatientAndCardTabAddress1().sendKeys(PatientAddress);
        PatientAndCardTabCity().clear();
        PatientAndCardTabCity().sendKeys(PatientCity);
        Thread.sleep(2000);
        //Select a state name in the state drop down randomly
       // PatientReviewPatientCardState().click();
       int stateNum = cf.SelectRandomState(statesList)
        Thread.sleep(2000);
        PatientAndCardTabZip().click();
      //  PatientAndCardTabZip().clear();
        Thread.sleep(2000);
        System.out.println("Zip code value before send keys: "+PatientZipCode);
        PatientAndCardTabZip().sendKeys(PatientZipCode);
        System.out.println("patient zip code entered in admin: "+PatientAndCardTabZip().getAttribute("value"));
        Thread.sleep(2000); 
        PatientAndCardTabUpdateButton().click();
        Thread.sleep(10000);
        
        Assert.assertEquals(PatientAndCardUpdateConfirmationMessage(), "updated patient Information");
        
        PartnerPatientID = PatientAndCardTabPartnerPatientIDValue();
        System.out.println("PartnerPatientID: "+PartnerPatientID);
        DateOfBirth = PatientAndCardTabDOBValue();
        System.out.println("DateOfBirth: "+DateOfBirth);
        State = PatientAndCardTabPatientResidingStateValue();
        System.out.println("State: "+State);
        MemberID = PatientAndCardTabMemberIDValue();
        GroupNumber = PatientAndCardTabEnrollmentGroupNumberValue();
        EnrollmentStatus = PatientAndCardTabPatientStatusValue();
       
        
        PatientEnrollmentInfo[0] = PartnerPatientID;
        PatientEnrollmentInfo[1] = MemberID;
        PatientEnrollmentInfo[2] = GroupNumber;
        PatientEnrollmentInfo[3] = EnrollmentStatus;
        PatientEnrollmentInfo[4] = DateOfBirth;
        PatientEnrollmentInfo[5] = State;	   
		
		 
		return PatientEnrollmentInfo;
	} */
	
	
}
