package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class HubFindAllCopayProgramPatientPage extends TestBase {
	
	public HubFindAllCopayProgramPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement FindButton()
	{
		return driver.findElement(By.name("find"));
	}
	
	public String RequiredFieldsMsg()
	{
		return driver.findElement(By.xpath("//div[@class='required']/p")).getText();
	}
	
	public String NoDataFoundMsg() 
	{
		return driver.findElement(By.xpath("//article[@class='content findAPatient']/section/div[@class='leftSpace']/div/p")).getText();
	}
	
	public WebElement LastName()
	{
		return driver.findElement(By.id("last_name"));
	}
	
	public WebElement PartnerPatientId()
	{
		return driver.findElement(By.id("partner_patient_id"));
	}
	
	public WebElement MemberId()
	{
		return driver.findElement(By.id("member_id"));
	}
	
	public WebElement PatientsListSearch()
	{
		return driver.findElement(By.id("patients-list"));
		
	}
	
	public WebElement PatientsListSearchMemberIDField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[1]"));
		
	}
	
	public WebElement PatientsListSearchLastNameField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[2]"));
		
	}
	
	public WebElement PatientsListSearchPartnerPatientIDField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[5]"));
		
	}
	
	public WebElement PatientsListSearchFirstNameField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[3]"));
		
	}
	
	public WebElement PatientsListSearchAddressField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[4]"));
		
	}
	
	public WebElement ReviewLink()
	{
		return driver.findElement(By.id("card_payment"));
	}
	
	public WebElement UploadFileLink()
	{
		return driver.findElement(By.id("upload_file"));
	}
	
	public boolean VerifySearchByLastNameResults(String PatientLastName, String PartnerPatientID, String MemberID, String PatientFirstName, String address)
	{
		WebElement searchResultList = PatientsListSearch();
        
        List<WebElement> rows = searchResultList.findElements(By.tagName("tr"));
        boolean verify = true;
        if(verify)
        {
	        for (WebElement row: rows)
	        { 
	        	List<WebElement> fieldvalues = row.findElements(By.tagName("td"));
	        	for(WebElement fieldValue: fieldvalues)
	            if (fieldValue.getText().equals(PatientLastName))
	            {
	            	Assert.assertEquals(PatientsListSearchMemberIDField().getText(), MemberID);
	            	Assert.assertEquals(PatientsListSearchPartnerPatientIDField().getText(), PartnerPatientID);
	            	Assert.assertEquals(PatientsListSearchFirstNameField(), PatientFirstName);
	            	Assert.assertEquals(PatientsListSearchAddressField(), address);
	            	break;
	           }
	        }
	        
	        return verify;
        }
        verify = false;
        return verify;
	}
	
	public boolean VerifySearchByPartnerPatientID(String PatientLastName, String PartnerPatientID, String MemberID, String PatientFirstName, String address)
	{
		WebElement searchResultList = PatientsListSearch();
        
        List<WebElement> rows = searchResultList.findElements(By.tagName("tr"));
        boolean verify = true;
        if(verify)
        {
	        for (WebElement row: rows)
	        { 
	        	List<WebElement> fieldvalues = row.findElements(By.tagName("td"));
	        	for(WebElement fieldValue: fieldvalues)
	            if (fieldValue.getText().equals(PartnerPatientID))
	            {
	            	Assert.assertEquals(PatientsListSearchMemberIDField().getText(), MemberID);
	            	Assert.assertEquals(PatientsListSearchLastNameField().getText(), PartnerPatientID);
	            	Assert.assertEquals(PatientsListSearchFirstNameField(), PatientFirstName);
	            	Assert.assertEquals(PatientsListSearchAddressField(), address);
	            	break;
	           }
	        }
	        return verify;
        }
        verify = false;
        return verify;
	}
	
	public boolean VerifySearchByMemberID(String PatientLastName, String PartnerPatientID, String MemberID, String PatientFirstName, String address)
	{
		WebElement searchResultList = PatientsListSearch();
        
        List<WebElement> rows = searchResultList.findElements(By.tagName("tr"));
        boolean verify = true;
        if(verify)
        {
	        for (WebElement row: rows)
	        { 
	        	List<WebElement> fieldvalues = row.findElements(By.tagName("td"));
	        	for(WebElement fieldValue: fieldvalues)
	            if (fieldValue.getText().equals(MemberID))
	            {
	            	Assert.assertEquals(PatientsListSearchLastNameField().getText(), PartnerPatientID);
	            	Assert.assertEquals(PatientsListSearchPartnerPatientIDField().getText(), PartnerPatientID);
	            	Assert.assertEquals(PatientsListSearchFirstNameField(), PatientFirstName);
	            	Assert.assertEquals(PatientsListSearchAddressField(), address);
	            	break;
	           }
	        }
	        return verify;
        }
        verify = false;
        return verify;
	}
	
	
	
	

}
