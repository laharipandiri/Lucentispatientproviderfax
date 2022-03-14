package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;

public class AdminPortal_Patients_New extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	public AdminPortal_Patients_New() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement BrandName()
	{
		return driver.findElement(By.id("brand"));
	}
	
	public WebElement GroupNumber()
	{
		return driver.findElement(By.id("groupNumber"));
	}
	
	public WebElement Channel()
	{
		return driver.findElement(By.id("channel"));
	}
	
	public WebElement Name()
	{
		return driver.findElement(By.id("name"));
	}
	
	public WebElement PatientTitle()
	{
		return driver.findElement(By.name("patient_salutation"));
	}
	
	public WebElement FirstName()
	{
		return driver.findElement(By.id("patient_firstName"));
	}
	
	public WebElement MiddleName()
	{
		return driver.findElement(By.id("patient_middleName"));
	}
	
	public WebElement LastName()
	{
		return driver.findElement(By.id("patient_lastName"));
	}
	
	public WebElement AddressOne()
	{
		return driver.findElement(By.id("patient_address1"));
	}
	
	public WebElement AddressTwo()
	{
		return driver.findElement(By.id("patient_address2"));
	}
	
	public WebElement City()
	{
		return driver.findElement(By.id("patient_city"));
	}
	
	public Select State()
	{
		Select states = new Select(driver.findElement(By.id("patient_state")));
		return states;
	}
	
	public WebElement Zip()
	{
		return driver.findElement(By.id("patient_postalCode"));
	}
	
	public WebElement MobilePhone()
	{
		return driver.findElement(By.id("patient_mobilePhone"));
	}
	
	public Select EnrollmentType()
	{
		Select enrollmentType = new Select(driver.findElement(By.id("patient_enrollmentType")));
		return enrollmentType;
	}
		
	public WebElement GenderMale()
	{
		return driver.findElement(By.xpath("//input[@id='patient_gender'][@value='male']"));
	}
	
	public WebElement GenderFemale()
	{
		return driver.findElement(By.xpath("//input[@id='patient_gender'][@value='female']"));
	}
	
	public WebElement GenderOther()
	{
		return driver.findElement(By.xpath("//input[@id='patient_gender'][@value='other']"));
	}
	
	public WebElement DOB()
	{
		return driver.findElement(By.id("patient_dob"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.id("patient_partnerId"));
	}
	
	public WebElement HIPAA()
	{
		return driver.findElement(By.id("associations_consent_hipaa-authorization"));
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.name("Submit"));
	}
	public WebElement ClickOnNewEnrollment()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div/div/div/table/tbody/tr/td[2]/a"));
	}
	
	public String PatientEnrollmentSuccesfulMessage()
	{
		return driver.findElement(By.xpath("//*[@id='wrapper']/div[3]/article/h1")).getText();
	
	}
	
	public String RecordsMsg()
	{
		return driver.findElement(By.xpath("//*[@id='wrapper']/div[3]/article/section/h1")).getText();
	}
	
	public List<WebElement> MandatoryFieldsCount()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/article/div/p"));
	}
	
	public WebElement MandatoryFieldsMsg(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/article/div/p[" + i +"]"));
	}
	
	public WebElement MandatoryFields()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/article/div/p"));
	}
	
	//Express 2.0
	
	public WebElement PhysicianNPI()
	{
		return driver.findElement(By.name("referringPhysician_npi"));
	}
	
	public WebElement NPIAutoSuggest()
	{
		return driver.findElement(By.xpath("//div[@id='physician-npi-input']/div/div[@id='referringPhysician_npi']"));
	}
	
	public WebElement PhysicianPartnerId()
	{
		return driver.findElement(By.id("referringPhysician_partnerId"));
	}
	
	public WebElement PhysicianWorkPhone()
	{
		return driver.findElement(By.id("referringPhysician_workPhone"));
	}
	
	public WebElement PhysicianFax()
	{
		return driver.findElement(By.id("referringPhysician_fax"));
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
				 
				 System.out.println("Field ######### "+Field.toString());
				 
				 /* Patient Information section data load */
				 PatientTitle().sendKeys(Field.get(4));
				 FirstName().sendKeys(Field.get(5));
				// Thread.sleep(3000);
				 MiddleName().sendKeys(Field.get(6));
				 LastName().sendKeys(Field.get(7));
				// Thread.sleep(3000);
				 
				 
				 AddressOne().sendKeys(Field.get(8));
				 AddressTwo().sendKeys(Field.get(9));
				 City().sendKeys(Field.get(10));
				 State().selectByVisibleText(Field.get(11));
				 
				 Zip().click();
				 Zip().sendKeys(Field.get(12));
				 //MobilePhone().sendKeys(Field.get(13));
				 
				 EnrollmentType().selectByVisibleText(Field.get(14));
				 
				 //The following is for selecting the gender
		         if(Field.get(15).equalsIgnoreCase("Male"))//Gender
		         {
		        	 GenderMale().click(); 
		        //	 Thread.sleep(3000);
		         }
		         else
		         {
		        	 GenderFemale().click();
		        //	 Thread.sleep(3000);
		         }
		        
		         //The following is for selecting the DOB
				 String[] DOB = Field.get(16).split("-");
		         String YOD = DOB[2];
		         String MOD = DOB[1];
		         String DOD = DOB[0];

		               
		         DOB().click(); 
		         cf.SelectDate(Field.get(16));
		         
		          PartnerPatientID().sendKeys(Field.get(17));
		      //   Thread.sleep(3000);
		      
		         js.executeScript("window.scrollBy(0,1500)", "");
		         //The following is for selecting the HIPAA consent date
				 String[] CD = Field.get(18).split("-");
		         String YCD = CD[2];
		         String MCD = CD[1];
		         String DCD = CD[0];

		         HIPAA().click();
		         cf.SelectDate(Field.get(18));
		         
		        //Added for Express 2.0
				 PhysicianNPI().sendKeys(Field.get(19));// PhysicianNPI  
				 Thread.sleep(8000);
				 NPIAutoSuggest().click();
				 
				 PhysicianPartnerId().sendKeys(Field.get(20));//PhysicianPartnerId
				 PhysicianWorkPhone().sendKeys(Field.get(21)); //PhysicianWorkPhone
				 PhysicianFax().sendKeys(Field.get(22)); //PhysicianFax
								 
		         AddButton().click();
		         System.out.println("Add button clicked");
		         Thread.sleep(4000);
		         
		   try {
		        	
		             Thread.sleep(2000);
		             for (int j = 1; j <= 7; j++) {
		                 String PatientConfirmationText = driver
		                         .findElement(By.xpath("//*[@id='wrapper']/div[3]/article/section/p["+ j + "]")).getText();
		                 if(j==4)
		                 {
		                	 Assert.assertEquals(driver
			                         .findElement(By.xpath("//*[@id='wrapper']/div[3]/article/section/p[" + j + "]")).getText(), "BIN: 0000");
		                 }
		                 if(j==5)
		                 {
		                	 Assert.assertEquals(driver
			                         .findElement(By.xpath("//*[@id='wrapper']/div[3]/article/section/p[" + j + "]")).getText(), "PCN: 00");
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
	
	
	
	
}
