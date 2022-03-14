package com.juno.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;
//import com.last.RegressionTestSet;


public class ProviderPage extends TestBase  {
	
	public ProviderPage() {
		PageFactory.initElements(driver, this);
	}
//***************************************************************************************	
	public WebElement Providers()
	{
		return driver.findElement(By.linkText("Providers"));
	}
	public WebElement SearchProvider()  //updated for express 2.0
	{
		return driver.findElement(By.linkText("Search Provider"));
	}
	public WebElement ProviderNPI()  //updated for express 2.0
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	
	
	public Select ProviderType() //updated for express 2.0
	{
		Select State = new Select(driver.findElement(By.id("provider_type")));
		return State;
		
	}
	public WebElement ProviderNameField() //updated for express 2.0
	{
		//return driver.findElement(By.id("provider_name"));
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement EnrollNewProvider()  //updated for express 2.0
	{
		return driver.findElement(By.linkText("Enroll New Provider"));
	}
	public WebElement NewProviderAddButton()  //updated for express 2.0
	{
		//return driver.findElement(By.xpath("//*[@id='add']"));
		return driver.findElement(By.xpath("//*[@id='provideradd2grp']/table/tbody/tr[5]/td/input[1]"));
		
	}
	
	public WebElement NewProviderError()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public WebElement NewProviderName()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public WebElement NewProviderFirstName()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public WebElement NewProviderLastName()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public WebElement NewProviderAddress1()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	public WebElement NewProviderCity()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public WebElement NewProviderState()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	public WebElement NewProviderNPI()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	public WebElement NewProviderZipcode()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	public WebElement NewProviderPhoneNumber()  //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
//********************************************************************************************
	public WebElement ProvidersSearchdButton() //updated for express 2.0
	{
		return driver.findElement(By.name("provider_list_button_find"));
	}
	
	public Select ProvidersType()  //updated for express 2.0
	{
		Select ProviderType = new Select(driver.findElement(By.name("provider_type")));
		return ProviderType;
	}

	
	public WebElement ProvidersSearchByNPI() //updated for express 2.0
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	public WebElement ProvidersSearchName() //updated for express 2.0
	{
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement ProvidersSearchReview() //updated for express 2.0
	{
		return driver.findElement(By.name("Review"));
	}
	public WebElement ProvidersSearchProviderTab() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//a[contains(@href,'#tabprovider_2')]"));
		
	}
	
	public WebElement ProvidersSearchParentProviderTab() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//a[contains(@href,'#tabprovider_9')]"));
		
	}
	
	public WebElement ProvidersSearchParentProviderPagination() //updated for express 2.0
	{
		return driver.findElement(By.name("provider-parentproviders-list_length"));
		
	}
	
	public WebElement ProviderAddshowproviderrow() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//a[contains(@href,'#tabprovider_2')]"));
	}
	
	public WebElement ProviderAddProviderName() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div/div/form[@id='provideradd2grp']/table/tbody/tr[2]/td/input[@id='provider_name']"));
	}
	public WebElement ProviderAddProviderLastName() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div/div/form[@id='provideradd2grp']/table/tbody/tr[3]/td/input[@id='provider_last_name']"));
	
	}
	
	public WebElement ProviderAddNPI() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div/div/form[@id='provideradd2grp']/table/tbody/tr[4]/td/input[@id='provider_npi']"));
		
	}
	
	public WebElement ProviderAddButton() //updated for express 2.0
	{
		return driver.findElement(By.name("add"));
		
	}
	public WebElement ProvidersSearchAddress1() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_2']"));
	}
		
	public Select ProvidersSearchdState() //updated for express 2.0
	{
		Select State = new Select(driver.findElement(By.id("state")));
		return State;
		
	}
	public WebElement ProvidersFindFirstReviewButton() //updated for express 2.0
	{
		return driver.findElement(By.name("Review"));
	}
	
	public WebElement ProviderNotesAddButton()
	{
		return driver.findElement(By.name("button Notes")); 
	}
	
	
	public WebElement GetPhysicanAndCardInfoTab() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//a[contains(@href,'#tabprovider_1')]"));
	}
	
	public WebElement PatientTab() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//a[contains(@href,'#tabprovider_4')]"));
	}
	public static List<WebElement> NumOfRowsPatient() {
		
		WebElement PatientTable = driver.findElement(By.xpath("//tbody"));
		//List<WebElement> noofRows = PatientTable.findElements(By.tagName("tr"));
		List<WebElement> noofRows = PatientTable.findElements(By.xpath("//*[@id='provider-patient-list']/tbody/tr"));
		return noofRows;
	}
	
	
	public WebElement PatientTabGetRow() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provider-patient-list']/tbody"));
	}
	public WebElement AddButton() //updated for express 2.0
	{
		return driver.findElement(By.id("add"));
	}
	
	
	
	
	public String ConfirmationIDValue() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[15]/td[2]")).getText();
	}
	public WebElement UpdateConfirmationMsg() //updated for express 2.0
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	
	public WebElement ProviderFieldsRequired()
	{
		//return driver.findElement(By.xpath("//*[@id='find-provider-search']/tbody/tr[6]"));
		
		return driver.findElement(By.xpath("//*[contains(text(),'Please enter Provider LastName or Provider Name or Provider NPI or Tax ID.')]"));
	}
	
}
