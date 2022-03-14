package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortalPatientsPage extends TestBase {
	
	public AdminPortalPatientsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Patients --> Find Page page objects */
	
	public WebElement PatientsFindPageMemberID()
	{
		return driver.findElement(By.name("patient_other_id"));
	}
	
	public WebElement PatientsFindPageCardID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	//The following page object is same for all Find buttons in all Patients related pages
	public WebElement PatientsPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	
	public WebElement PatientsFindPageCardIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[11]"));
	}
	
	public Select PatientsFindPagePatientStatusDropDown()
	{
		Select status=new Select(driver.findElement(By.name("status_id")));
		return status;
	}
	
	
	
	public List<WebElement> PatientsFindPageSearchResultGrid()
	{
		//This page object is for returning the memberID locator for the Member ID field value in the Find results
		 WebElement resultTable = driver.findElement(By.id("sortTable"));
		 List<WebElement> columns = resultTable.findElements(By.tagName("td"));
		 return columns;
	}
	
	public WebElement PatientsFindpageMemberIDFieldValueInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[4]")); //updated 10262021
		
	}
	
	public WebElement PatientsFindpageCardIDFieldValueInGrid() //Added for Xolair
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_3']"));
	}
	/* Patients Active Page page objects */
	
	public WebElement PatientsNewHubPortalText()
	{
		return driver.findElement(By.xpath("//*[@id='cccardholderAdd']/font/strong"));
	}
	
	public WebElement PatientsNewHubPortalTextInPortals()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div/div/table/tbody/tr[2]/td[1]"));
	}
	
	public WebElement PatientsNewPageClickHereLink()
	{
		//return driver.findElement(By.linkText("Click here"));
		return driver.findElement(By.xpath("//input[@class='button_empty' and @value='Click here']"));
	}
	
	public WebElement PatientsFindReviewButton()
	{
		return driver.findElement(By.name("Review"));
	}
	
	public WebElement PatientsFindFirstReviewButton()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_15']/form[1]/input[3]"));
	}
	
	/* The following are Patients -->Active page page objects*/
	
	public WebElement PatientsActiveFindButton()
	{
		return driver.findElement(By.name("patient_list_button_find"));
	}
	
	public WebElement PatientsActiveFirstReviewButton()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_15']/form[1]/input[3]")); //updated 10262021
	}
	
	public String PatientsFindLastNameValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[1]")).getText();
	}
	
	public String PatientsFindFirstNameValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[2]")).getText();
	}
	
	public String PatientsFindContactValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[9]")).getText(); //updated 10262021
	}
	
	
	public String AdminPortalMemberIDSearch(String MemberID) throws InterruptedException, IOException, AWTException
	{
		//PatientsFindPageMemberID().sendKeys(MemberID); //Xolair has card ID not member ID
		PatientsFindPageCardID().sendKeys(MemberID);
		Thread.sleep(3000);
		
		PatientsPageFindButton().click();
		Thread.sleep(5000);
		//making sure that atleast one record is displayed before making sure that the correct result is returned
		Assert.assertTrue((driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr")).isDisplayed()));
		
		//The following verifies if correct result is returned by navigating through each and every single element in the result table grid
		
        Assert.assertEquals(PatientsFindpageCardIDFieldValueInGrid().getText(), MemberID);
            	//String CardID = PatientsFindPageCardIDInGrid().getText();//Updated for Xolair
        String CardID = PatientsFindpageCardIDFieldValueInGrid().getText(); 
            	System.out.println("Inside method CardID:"+CardID);
                System.out.println("Patient results for matching member ID is found");
                System.out.println("The MemberID is:" +MemberID);
                //Reporting
       		 if(PatientsFindpageCardIDFieldValueInGrid().getText().equalsIgnoreCase(MemberID))
                {
                	TestBase.classAInstance.logReport("Pass","Able to find the enrolled patient in the Admin Portal","Succesfully able to find the enrolled patient in the Admin Portal");
        		 }
       		 else
        	     {
        		    TestBase.classAInstance.logReport("Fail","Not able to find the enrolled patient in the Admin Portal","Failed to find the enrolled patient in the Admin Portal");
        	     }      
       			
       
                return CardID;
      
	}
	
	public String AdminPortalShortCardIDSearch(String MemberID) throws InterruptedException, IOException, AWTException
	{
		PatientsFindPageMemberID().sendKeys(MemberID);
		Thread.sleep(3000);
		
		PatientsPageFindButton().click();
		Thread.sleep(5000);
		//making sure that atleast one record is displayed before making sure that the correct result is returned
		Assert.assertTrue((driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr")).isDisplayed()));
		
		//The following verifies if correct result is returned by navigating through each and every single element in the result table grid
		
            	Assert.assertEquals(PatientsFindpageMemberIDFieldValueInGrid().getText(), MemberID);
            	String CardID = PatientsFindPageCardIDInGrid().getText();
            	System.out.println("Inside method CardID:"+CardID);
                System.out.println("Patient results for matching member ID is found");
              
                //Reporting
       		 if(PatientsFindpageMemberIDFieldValueInGrid().getText().equalsIgnoreCase(MemberID))
                {
                	TestBase.classAInstance.logReport("Pass","Able to find the enrolled patient in the Admin Portal","Succesfully able to find the enrolled patient in the Admin Portal");
        		 }
       		 else
        	     {
        		    TestBase.classAInstance.logReport("Fail","Not able to find the enrolled patient in the Admin Portal","Failed to find the enrolled patient in the Admin Portal");
        	     }      
       			
       
                return CardID;
      
	}
	public String MemberIDSearchInAdminPortal(String CardID) throws InterruptedException 
	{
		PatientsFindPageCardID().sendKeys(CardID);
		Thread.sleep(3000);
		
		PatientsPageFindButton().click();
		Thread.sleep(5000);
		//making sure that atleast one record is displayed before making sure that the correct result is returned
		Assert.assertTrue((driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr")).isDisplayed()));
		
		//The following verifies if correct result is returned by navigating through each and every single element in the result table grid
		
            	Assert.assertEquals(PatientsFindpageMemberIDFieldValueInGrid().getText(), CardID);
            	CardID = PatientsFindPageCardIDInGrid().getText();
            	System.out.println("Inside method CardID:"+CardID);
                System.out.println("Patient results for matching member ID is found");
              
               return CardID;
      
	}
	
	
	
	
	
	
	
	
	
	

}
