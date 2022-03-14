package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_FindPage extends TestBase {
	
	public AdminPortal_Patients_FindPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientsFindPageMemberID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement PatientsFindPageCardID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement PatientsPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	
	public WebElement PatientsFindPageCardIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr/td[13]"));
	}
	
	public Select PatientsFindPagePatientStatusDropDown()
	{
		Select status=new Select(driver.findElement(By.name("status_id")));
		return status;
	}
	
	public Select PatientsFindPageProgramDropDown()
	{
		Select program=new Select(driver.findElement(By.name("program")));
		return program;
	}
	
	public WebElement PatientsFindPagePatientLastName()
	{
		return driver.findElement(By.name("last_name"));
	}
	
	public Select PatientsFindPageResidingStateDropDown()
	{
		Select state=new Select(driver.findElement(By.name("state")));
		return state;
	}
	
	public WebElement PatientsFindPageEnrollDateFrom()
	{
		return driver.findElement(By.name("enroll_min_date"));
	}
	
	public WebElement EnrollDateToday()
	{
		return driver.findElement(By.cssSelector(".ui-datepicker-today"));
	}
	
	public WebElement PatientsFindPageConfirmationID()
	{
		return driver.findElement(By.name("patient_id"));
	}
	
	public Select PatientsFindPageActivationTypeDropDown()
	{
		Select activationType=new Select(driver.findElement(By.id("activation_type_id"))); //updated for replatform
		return activationType;
	}
	
	public WebElement PatientsFindPageProviderName()
	{
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement PatientsFindPagePartnerPatientID()
	{
		return driver.findElement(By.name("patient_referral_code"));
	}
	
	public WebElement PatientsFindPageMasterCardNum()
	{
		return driver.findElement(By.name("long_card_id"));
	}
	
	public Select PatientsFindPageProviderTypeDropDown()
	{
		Select providerType=new Select(driver.findElement(By.name("provider_type")));
		return providerType;
	}
	
	public WebElement PatientsFindPageCity()
	{
		return driver.findElement(By.name("city"));
	}
	
	public WebElement PatientsFindPageEnrollDateTo()
	{
		return driver.findElement(By.name("enroll_max_date"));
	}
	
	public List<WebElement> PatientsFindPageSearchResultGridCols()
	{
		return driver.findElements(By.xpath("//div[@id='form-table']/div[@class='table_head']/table/thead/tr/th"));
	}
	
	public WebElement PatientsFindPageSearchResultGridColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[@class='table_head']/table/thead/tr/th["+i+"]"));
	}
	
	public WebElement PatientsFindFirstReviewButton()
	{
		//return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[15]/form[1]/input[3]")); replatform updated
		return driver.findElement(By.xpath("//*[@id='dtcol_15']/form[1]/input[3]"));
		
	}
	
	public WebElement PatientsFindFirstMatchButton()
	{
		//return driver.findElement(By.xpath("//*[@id='patients-list']/tbody/tr[1]/td[15]/form[2]/input[3]")); updated for replatform
		return driver.findElement(By.xpath("//*[@id='dtcol_15']/form[2]/input[3]"));
		
	}
	
	public List<WebElement> PatientsFindPageSearchResultGrid()
	{
		//This page object is for returning the memberID locator for the Member ID field value in the Find results
		 WebElement resultTable = driver.findElement(By.id("sortTable"));
		 List<WebElement> columns = resultTable.findElements(By.tagName("td"));
		 return columns;
	}
	
	public String LastNameValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[1]")).getText();
	}
	
	public String FirstNameValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[2]")).getText();
	}
	public String ProgramNameValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[3]")).getText();
	}
	
	public String ActivationDateValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[4]")).getText();
	}
	public String CreatedDateValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[5]")).getText();
	}
	
	public String StatusValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[7]")).getText();
	}
	public String ConatctValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[8]")).getText();
	}
	
	public String MemberIDValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[9]")).getText();
	}
	
	public String PartnerPatientIDValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[10]")).getText();
	}
	
	public String CardIDValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[11]")).getText();
	}
	public String ProviderNameValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[12]")).getText();
	}
	
	public String ProviderTypeValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[13]")).getText();
	}
	
	public String ConfirmationNumberValueInFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[14]")).getText();
	}
	
	public WebElement ProviderNameCol()
	{
		return driver.findElement(By.xpath("//div[@id='patients-list_wrapper']/div/div[5]/table/thead/tr/th[12]"));
	}

}
