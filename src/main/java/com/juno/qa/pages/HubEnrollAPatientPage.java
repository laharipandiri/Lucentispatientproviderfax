package com.juno.qa.pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;


public class HubEnrollAPatientPage extends TestBase{
	
	public HubEnrollAPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*  Patient Information Section Page Objects */
	
	public Select getProgramName()
	{
		Select programName = new Select(driver.findElement(By.className("brand_name")));
		return programName;
		
	}
	
	public WebElement Brand()
	{
		return driver.findElement(By.id("brand"));
	}
	
	public WebElement GroupNumber()
	{
		return driver.findElement(By.id("groupNumber"));
	}
	
	public WebElement ApplyButtons()
	{
		return driver.findElement(By.xpath("//button[contains(@class,'brand-button')]"));
	}
	
	public WebElement FirstName()
	{
		return driver.findElement(By.id("patient_firstName"));
	}
	
	public WebElement LastName()
	{
		return driver.findElement(By.id("patient_lastName"));
	}
	
	public WebElement PatientDB()
	{
		return driver.findElement(By.id("patient_dob"));
	}
	
	public WebElement PatientMale()
	{
		return driver.findElement(By.xpath("//input[@value='male']"));
	}
	
	public WebElement PatientFemale()
	{
		return driver.findElement(By.xpath("//input[@value='female']"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.id("patient_partnerId"));
	}
	
	public WebElement PatientAddress()
	{
		return driver.findElement(By.id("patient_address1"));
	}
	
	public WebElement PatientCity()
	{
		return driver.findElement(By.id("patient_city"));
	}
	
	public Select PatientState()
	{
		Select stateName = new Select(driver.findElement(By.name("patient_state")));
		return stateName;
	}
	
	public WebElement PatientZipCode()
	{
		return driver.findElement(By.id("patient_postalCode"));
	}
	
	public WebElement PatientCellNumber()
	{
		return driver.findElement(By.id("patient_mobilePhone"));
	}
	
	public Select PatientPreferredContactMethod()
	{
		Select method = new Select(driver.findElement(By.id("patient_preferredContactMethod")));
		return method;
	}
	
	public Select EnrollmentType()
	{
		Select type = new Select(driver.findElement(By.id("patient_enrollmentType")));
		return type;
	}
	
	/* Physician Information Section Page objects */
	
	public WebElement PhysicianNPI()
	{
		return driver.findElement(By.id("referringPhysician_npi"));
	}
	
	public Select PhysicianState()
	{
		Select stateName = new Select(driver.findElement(By.name("referringPhysician_state")));
		return stateName;
	}
	
	public WebElement PhysicianFirstName()
	{
		return driver.findElement(By.id("referringPhysician_firstName"));
	}
	
	public WebElement PhysicianLastName()
	{
		return driver.findElement(By.id("referringPhysician_lastName"));
	}
	
	public WebElement PhysicianAddress()
	{
		return driver.findElement(By.id("referringPhysician_address1"));
	}
	
	public WebElement PhysicianCity()
	{
		return driver.findElement(By.id("referringPhysician_city"));
	}
	
	public WebElement PartnerPhysicianID()
	{
		return driver.findElement(By.id("referringPhysician_partnerId"));
	}
	
	public WebElement PhysicianZipCode()
	{
		return driver.findElement(By.id("referringPhysician_postalCode"));
	}
	
	public WebElement PhysicianPhone()
	{
		return driver.findElement(By.id("referringPhysician_homePhone"));
	}
	
	public WebElement PhysicianWorkPhone()
	{
		return driver.findElement(By.id("referringPhysician_workPhone"));
	}
	public WebElement PhysicianFax()
	{
		return driver.findElement(By.id("referringPhysician_fax"));
	}
	
	public WebElement NPIAutoSuggest()
	{
		return driver.findElement(By.xpath("//p[@id='physician-npi-input']/div/div[@id='referringPhysician_npi']"));
	}
	
	public Select PreferredContactMethod()
	{
		Select method = new Select(driver.findElement(By.id("referringPhysician_preferredContactMethod")));
		return method;
	}
	
	public Select PreferredContactTime()
	{
		Select time = new Select(driver.findElement(By.id("referringPhysician_preferredContactTime")));
		return time;
	}
	
	
	/* Insurance Information Section Page objects */
	
	public Select InsuranceCompanyName()
	{
		Select insuranceCompanyName = new Select(driver.findElement(By.id("insurances_payerName")));
		return insuranceCompanyName;
	}
	
	public WebElement InsuranceGroupNumber()
	{
		return driver.findElement(By.id("insurances_groupNumber"));
	}
	
	public WebElement InsuranceMemberNumber()
	{
		return driver.findElement(By.id("insurances_memberId"));
	}
	
	public WebElement InsuranceBIN()
	{
		return driver.findElement(By.id("insurances_bin"));
	}
	
	public WebElement InsurancePCN()
	{
		return driver.findElement(By.id("insurances_pcn"));
	}
	
	/* Consent Information section page objects */
	
	public WebElement PatientConsentYes()
	{
		//return driver.findElement(By.id("Yes"));
		return driver.findElement(By.xpath("//input[@id='associations_consent_third-party-disclosure' and @value='yes']"));
	}
	
	public WebElement PatientConsentNo()
	{
		//return driver.findElement(By.id("No"));
		return driver.findElement(By.xpath("//input[@id='associations_consent_third-party-disclosure' and @value='no']"));
	}
	
	public WebElement HIPAADate()
	{
		return driver.findElement(By.id("associations_consent_hipaa-authorization"));
	}
	
	public WebElement EnrollButton()
	{
		return driver.findElement(By.name("Submit"));
	}
	
	public List<WebElement> MandatoryFieldsCount()
	{
		return driver.findElements(By.xpath("//*[@id='eContainer']/article/div/p"));
	}
	
	public WebElement MandatoryFields()
	{
		return driver.findElement(By.xpath("//*[@id='eContainer']/article/div/p"));
	}
	
	public WebElement MandatoryFieldsMsg(int i)
	{
		return driver.findElement(By.xpath("//*[@id='eContainer']/article/div/p[" + i +"]"));
	}
	
	/* Patient enrollment confirmation page */
	
	public String PatientEnrollmentSuccesfulMessage()
	{
		return driver.findElement(By.xpath("//article[@class='content enrollNewPatient']//h1[@class='green']")).getText();
	}
	
	public String RecordsMsg()
	{
		return driver.findElement(By.xpath("//*[@id='eContainer']/article/section")).getText();
	}
	
	public void ClickBrandButton(String brand)
	{
		String xpathText = "Apply for a " + brand + " Patient";
		driver.findElement(By.xpath("//*[text()='"+ xpathText + "']")).click();
	}
	
	public String[] EnrollAPatient(List<String> Field) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//The following String is for capturing the enrollment confirmation field values 
				String[] PatientEnrollmentInfo = new String[7];
				 
				//The following are the confirmation fields after enrollment
				 String PartPatientID = "";
				 String MemberID = "";
				 String GrpNumber = "";
				 String Bin = "";
				 String PCN = "";
				 String PatientName = "";
				 String EnrollmentDate = "";
				 
				 /* Patient Information section data load */
				 
				 FirstName().sendKeys(Field.get(2));
				// Thread.sleep(3000);
				 LastName().sendKeys(Field.get(3));
				// Thread.sleep(3000);
				 
				 //The following is for selecting the DOB
				 String[] DOB = Field.get(4).split("-");
		         String YOD = DOB[2];
		         String MOD = DOB[1];
		         String DOD = DOB[0];

		         System.out.println(MOD);
		         System.out.println(DOD);
		         
		         PatientDB().click(); 
		         
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
		         Thread.sleep(2000);
		         
		         //The following is for selecting the gender
		         if(Field.get(5).equalsIgnoreCase("Male"))//Gender
		         {
		        	 PatientMale().click();
		        //	 Thread.sleep(3000);
		         }
		         else
		         {
		        	 PatientFemale().click();
		        //	 Thread.sleep(3000);
		         }
		          
		         
		            PartnerPatientID().sendKeys(Field.get(6));
		      //   Thread.sleep(3000);
		            PatientAddress().sendKeys(Field.get(7));
		      //   Thread.sleep(3000);
		            PatientCity().sendKeys(Field.get(8));
		      //   Thread.sleep(3000);
		            PatientState().selectByVisibleText(Field.get(9));
		      //   Thread.sleep(3000);
		            PatientZipCode().click();
		         PatientZipCode().sendKeys(Field.get(10));
		      //   Thread.sleep(3000);
		         PatientCellNumber().sendKeys(Field.get(11));
		      //   Thread.sleep(3000);
		     //    PatientPreferredContactMethod().selectByVisibleText(Field.get(29));
		         EnrollmentType().selectByVisibleText(Field.get(30));
		         System.out.println("Finished patient information section");
		         
		         /* Physician Information section data load */
		         
		         PhysicianNPI().sendKeys(Field.get(12));
		         Thread.sleep(5000);
		         //click on the NPI search result
		         NPIAutoSuggest().click();
		       //  Thread.sleep(3000);
		         
		         //After auto suggest some fields are auto filled. So need to check if any of the mandatory fields in this section are still empty after auto suggest
		         
		         if(PartnerPhysicianID().getAttribute("value").isEmpty()) {
		        	 PartnerPhysicianID().sendKeys(Field.get(13));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianFirstName().getAttribute("value").isEmpty()) {
		        	 PhysicianFirstName().sendKeys(Field.get(14));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianLastName().getAttribute("value").isEmpty()) {
		        	 PhysicianLastName().sendKeys(Field.get(15));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianAddress().getAttribute("value").isEmpty()) {
		        	 PhysicianAddress().sendKeys(Field.get(16));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianCity().getAttribute("value").isEmpty()) {
		        	 PhysicianCity().sendKeys(Field.get(17));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianState().getFirstSelectedOption().getText().isEmpty()) {
		        	 PhysicianZipCode().sendKeys(Field.get(18));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianPhone().getAttribute("value").isEmpty()) {
		        	 PhysicianPhone().sendKeys(Field.get(20));
		        	 Thread.sleep(2000);
		         }
		         if(PhysicianFax().getAttribute("value").isEmpty()) {
		        	 PhysicianFax().sendKeys(Field.get(21));
		        	 Thread.sleep(2000);
		         }
		         
		    //     PreferredContactMethod().selectByVisibleText(Field.get(27));
		    //     PreferredContactTime().selectByVisibleText(Field.get(28));
		         PhysicianWorkPhone().sendKeys(Field.get(31));
		         
		         System.out.println("Finished Physician section");
		         
		         //	Insurance information section data load */
		         
		    /*     InsuranceCompanyName().selectByVisibleText(Field.get(22));
		      //   Thread.sleep(2000);
		         InsuranceGroupNumber().sendKeys(Field.get(23));
		      //   Thread.sleep(2000);
		         InsuranceMemberNumber().sendKeys(Field.get(24));
		      //   Thread.sleep(2000);
		         InsuranceBIN().sendKeys(Field.get(32));
		         InsurancePCN().sendKeys(Field.get(33)); */
		         
		         
		         
		         js.executeScript("window.scrollBy(0,1500)", "");
		         //The following is for selecting the HIPAA consent date
				 String[] CD = Field.get(26).split("-");
		         String YCD = CD[2];
		         String MCD = CD[1];
		         String DCD = CD[0];

		         System.out.println(MCD);
		         System.out.println(DCD); 
		         
		         HIPAADate().click();
		         
		         Select HYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		         HYear.selectByValue(YCD);
		     //    Thread.sleep(3000);
		         Select HMonthName = new Select(driver.findElement(By.className("ui-datepicker-month")));
		         HMonthName.selectByVisibleText(MCD);
		     //    Thread.sleep(3000);
		         //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
		         WebElement HDateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
		         
		         List<WebElement> Hcolumns = HDateWidget.findElements(By.tagName("td"));
		         System.out.println("HColumns size:"+Hcolumns.size());
		         for (WebElement col: Hcolumns)
		         { 
		            if (col.getText().equals(DCD))
		            {
		            	System.out.println(col.getText());
		            	System.out.println("Found matching date");
		               col.findElement(By.linkText(DCD)).click();
		               break;
		            }
		         } 
		         Thread.sleep(2000);
		         
		         /* Consent Information section */
		         
		/*		 if(Field.get(25).equalsIgnoreCase("yes")) //Patient consent
				  {
			       	 PatientConsentYes().click();
				  } */
		       
		        // click on Enroll button
		         EnrollButton().click();
		         System.out.println("Enrollment button clicked");
		         Thread.sleep(4000);
		         
		         
		         
		         try {
		        	
		        	 

		             Thread.sleep(2000);
		             for (int j = 1; j <= 7; j++) {
		                 String PatientConfirmationText = driver
		                         .findElement(By.xpath("//*[@id='eContainer']/article/section/p[" + j + "]")).getText();
		                 if(j==4)
		                 {
		                	 Assert.assertEquals(driver
			                         .findElement(By.xpath("//*[@id='eContainer']/article/section/p[" + j + "]")).getText(), "BIN: 600426");
		                 }
		                 if(j==5)
		                 {
		                	 Assert.assertEquals(driver
			                         .findElement(By.xpath("//*[@id='eContainer']/article/section/p[" + j + "]")).getText(), "PCN: 54");
		                 }
		                 
		                 String array1[] = PatientConfirmationText.split(":");
		                 String z = Integer.toString(j);
		                 switch (z) {
		                     case "1":

		                         PartPatientID = array1[1].trim();
		                         System.out.println("PartPatientID:"+PartPatientID);

		                         break;
		                     case "2":

		                    	 MemberID = array1[1].trim();

		                         break;

		                     case "3":

		                    	 GrpNumber = array1[1].trim();

		                         break;

		                     case "4":

		                    	 Bin = array1[1].trim();

		                         break;
		                     case "5":

		                    	 PCN = array1[1].trim();

		                         break;
		                     case "6":
		                    	 PatientName = array1[1].trim();
		                    	 
		                    	 break;
		                    	 
		                     case "7":
		                    	 EnrollmentDate = array1[1].trim();
		                    	 
		                    	 break;
		                    	 

		                 }

		             }
		         } catch (Exception e) {

		             e.printStackTrace();
		         }

		        
		         
		         PatientEnrollmentInfo[0] = PartPatientID;
		         PatientEnrollmentInfo[1] = MemberID;
		         PatientEnrollmentInfo[2] = GrpNumber;
		         PatientEnrollmentInfo[3] = Bin;
		         PatientEnrollmentInfo[4] = PCN;
		         PatientEnrollmentInfo[5] = PatientName;
		         PatientEnrollmentInfo[6] = EnrollmentDate;
		         
		         try {
						Assert.assertEquals(PatientEnrollmentSuccesfulMessage(), "Patient Successfully Enrolled");
						Assert.assertFalse(MemberID.isEmpty());
						Assert.assertFalse(PartPatientID.isEmpty());
						Assert.assertFalse(GrpNumber.isEmpty());
						Assert.assertFalse(Bin.isEmpty());
						Assert.assertFalse(PCN.isEmpty());
						Assert.assertFalse(PatientName.isEmpty());
						Assert.assertFalse(EnrollmentDate.isEmpty());
						Assert.assertTrue(RecordsMsg().contains("Please keep the above information for your records"));
					}
					catch(Exception e) {

						e.printStackTrace();
					}
		     
		        
		         return PatientEnrollmentInfo;
	}
	
	
	/* *********************************************************************************************************************************************************************************************** */
	
	//DO NOT REMOVE THIS METHOD  AS BULK TEST DATA CREATION USES THIS METHOD
	
	public String[] PatientEnrollmentForDrug(String Program, String	GroupNumber, String	PatientFirstName, String PatientLastName, String PatientMD, String PatientDOB, String	PatientGender,
			String PartnerPatientID,String	PatientAddress,String PatientCity,String PatientState, String PatientZipCode, String PatientCellNumber, String PhysicianNPI,
			String PartnerPhysicianID, String PhysicianFirstName, String PhysicianLastName, String PhysicianAddress, String	PhysicianCity, String PhysicianState, String PhysicianZipCode,
			String PhysicianPhone, String PhysicianFax, String InsCompanyName, String InsGroupNumber, String InsMemberNumber, String PatientConsent, String	HIPPAConsentDate, 
			String PhysicianPreferredContactMethod, String PhysicianPreferredContactTime, String PatientPreferredContactMethod, String EnrollmentType, String PhysicianWorkPhone) throws InterruptedException
	{
		//The following String is for capturing the enrollment confirmation field values 
		String[] PatientEnrollmentInfo = new String[7];
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//The following are the confirmation fields after enrollment
		 String PartPatientID = "";
		 String MemberID = "";
		 String GrpNumber = "";
		 String Bin = "";
		 String PCN = "";
		 String PatientName = "";
		 String EnrollmentDate = "";
		 
		 /* Patient Information section data load */
		 
		 FirstName().sendKeys(PatientFirstName);
		// Thread.sleep(3000);
		 LastName().sendKeys(PatientLastName);
		// Thread.sleep(3000);
		 
		 //The following is for selecting the DOB
		 String[] DOB = PatientDOB.split("-");
         String YOD = DOB[2];
         String MOD = DOB[1];
         String DOD = DOB[0];

         System.out.println(MOD);
         System.out.println(DOD);
         
         PatientDB().click(); 
         
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
         Thread.sleep(2000);
         
         //The following is for selecting the gender
         if(PatientGender.equalsIgnoreCase("Male"))
         {
        	 PatientMale().click();
        //	 Thread.sleep(3000);
         }
         else
         {
        	 PatientFemale().click();
        //	 Thread.sleep(3000);
         }
         
         PartnerPatientID().sendKeys(PartnerPatientID);
      //   Thread.sleep(3000);
         PatientAddress().sendKeys(PatientAddress);
      //   Thread.sleep(3000);
         PatientCity().sendKeys(PatientCity);
      //   Thread.sleep(3000);
         PatientState().selectByVisibleText(PatientState);
      //   Thread.sleep(3000);
         PatientZipCode().click();
         PatientZipCode().sendKeys(PatientZipCode);
      //   Thread.sleep(3000);
         PatientCellNumber().sendKeys(PatientCellNumber);
      //   Thread.sleep(3000);
       //  PatientPreferredContactMethod().selectByVisibleText(PatientPreferredContactMethod);
         EnrollmentType().selectByVisibleText(EnrollmentType);
         
         System.out.println("Finished patient information section");
         
         /* Physician Information section data load */
         
         PhysicianNPI().sendKeys(PhysicianNPI);
         Thread.sleep(5000);
         //click on the NPI search result
         NPIAutoSuggest().click();
       //  Thread.sleep(3000);
         
         //After auto suggest some fields are auto filled. So need to check if any of the mandatory fields in this section are still empty after auto suggest
         
         if(PartnerPhysicianID().getAttribute("value").isEmpty()) {
        	 PartnerPhysicianID().sendKeys(PartnerPhysicianID);
        	 Thread.sleep(2000);
         }
         if(PhysicianFirstName().getAttribute("value").isEmpty()) {
        	 PhysicianFirstName().sendKeys(PhysicianFirstName);
        	 Thread.sleep(2000);
         }
         if(PhysicianLastName().getAttribute("value").isEmpty()) {
        	 PhysicianLastName().sendKeys(PhysicianLastName);
        	 Thread.sleep(2000);
         }
         if(PhysicianAddress().getAttribute("value").isEmpty()) {
        	 PhysicianAddress().sendKeys(PhysicianAddress);
        	 Thread.sleep(2000);
         }
         if(PhysicianCity().getAttribute("value").isEmpty()) {
        	 PhysicianCity().sendKeys(PhysicianCity);
        	 Thread.sleep(2000);
         }
         if(PhysicianState().getFirstSelectedOption().getText().isEmpty()) {
        	 PhysicianZipCode().sendKeys(PhysicianZipCode);
        	 Thread.sleep(2000);
         }
         if(PhysicianPhone().getAttribute("value").isEmpty()) {
        	 PhysicianPhone().sendKeys(PhysicianPhone);
        	 Thread.sleep(2000);
         }
         if(PhysicianFax().getAttribute("value").isEmpty()) {
        	 PhysicianFax().sendKeys(PhysicianFax);
        	 Thread.sleep(2000);
         }
         
    /*     PreferredContactMethod().selectByVisibleText(PhysicianPreferredContactMethod);
         PreferredContactTime().selectByVisibleText(PhysicianPreferredContactTime);*/
         PhysicianWorkPhone().sendKeys(PhysicianWorkPhone); 
         
         System.out.println("Finished Physician section");
         
         //	Insurance information section data load */
         
    /*     InsuranceCompanyName().selectByVisibleText(InsCompanyName);
      //   Thread.sleep(2000);
         InsuranceGroupNumber().sendKeys(InsGroupNumber);
      //   Thread.sleep(2000);
         InsuranceMemberNumber().sendKeys(InsMemberNumber); */
      //   Thread.sleep(2000);
         
         /* Consent Information section */
         
  /*       if(PatientConsent.equalsIgnoreCase("yes"))
         {
        	 PatientConsentYes().click();
         } */
         
         
         //The following is for selecting the HIPAA consent date
		 String[] CD = HIPPAConsentDate.split("-");
         String YCD = CD[2];
         String MCD = CD[1];
         String DCD = CD[0];

         System.out.println(MCD);
         System.out.println(DCD); 
         js.executeScript("window.scrollBy(0,1500)", "");
         HIPAADate().click();
         
         Select HYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
         HYear.selectByValue(YCD);
     //    Thread.sleep(3000);
         Select HMonthName = new Select(driver.findElement(By.className("ui-datepicker-month")));
         HMonthName.selectByVisibleText(MCD);
     //    Thread.sleep(3000);
         //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
         WebElement HDateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
         
         List<WebElement> Hcolumns = HDateWidget.findElements(By.tagName("td"));
         for (WebElement col: Hcolumns)
         { 
            if (col.getText().equals(DCD))
            {
               col.findElement(By.linkText(DCD)).click();
               break;
            }
         } 
         Thread.sleep(2000);
       
        // click on Enroll button
         EnrollButton().click();
         System.out.println("Enrollment button clicked");
         Thread.sleep(4000);
         
         
         
         try {
        	

             Thread.sleep(2000);
             for (int j = 1; j < 7; j++) {
                 String PatientConfirmationText = driver
                         .findElement(By.xpath("//*[@id=\"eContainer\"]/article/section/p[" + j + "]")).getText();
                 if(j==4)
                 {
                	 Assert.assertEquals(driver
	                         .findElement(By.xpath("//*[@id='eContainer']/article/section/p[" + j + "]")).getText(), "BIN: 600426");
                 }
                 if(j==5)
                 {
                	 Assert.assertEquals(driver
	                         .findElement(By.xpath("//*[@id='eContainer']/article/section/p[" + j + "]")).getText(), "PCN: 54");
                 }
                 
                 String array1[] = PatientConfirmationText.split(":");
                 String z = Integer.toString(j);
                 switch (z) {
                     case "1":

                         PartPatientID = array1[1].trim();
                         System.out.println("PartPatientID:"+PartPatientID);

                         break;
                     case "2":

                    	 MemberID = array1[1].trim();

                         break;

                     case "3":

                    	 GrpNumber = array1[1].trim();

                         break;

                     case "4":

                    	 Bin = array1[1].trim();

                         break;
                     case "5":

                    	 PCN = array1[1].trim();

                         break;
                     case "6":
                    	 PatientName = array1[1].trim();
                    	 
                    	 break;
                    	 
                     case "7":
                    	 EnrollmentDate = array1[1].trim();
                    	 
                    	 break;
                    	 

                 }

             }
         } catch (Exception e) {

             e.printStackTrace();
         }

         PatientEnrollmentInfo[0] = PartPatientID;
         PatientEnrollmentInfo[1] = MemberID;
         PatientEnrollmentInfo[2] = GrpNumber;
         PatientEnrollmentInfo[3] = Bin;
         PatientEnrollmentInfo[4] = PCN;
         PatientEnrollmentInfo[5] = PatientName;
         PatientEnrollmentInfo[6] = EnrollmentDate;
         
         return PatientEnrollmentInfo;
	}

}
