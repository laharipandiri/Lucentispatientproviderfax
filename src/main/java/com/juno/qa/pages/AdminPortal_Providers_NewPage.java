package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;
import com.juno.qa.pages.HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage;

public class AdminPortal_Providers_NewPage extends TestBase {
	
	HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage hpp = new HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage();
	
	public AdminPortal_Providers_NewPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.id("add"));
	}
	
	public Select ProgramName()
	{
		Select programNames = new Select(driver.findElement(By.id("program")));
		return programNames;
	}
	
	public Select ProviderType()
	{
		Select programNames = new Select(driver.findElement(By.id("provider_type")));
		return programNames;
	}
	
	public WebElement PhysicianName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement ProviderFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement ProviderLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement ProviderAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement ProviderCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public WebElement ProviderZipCode()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement ProviderPhoneNumber()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public String ProviderNPIRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[1]/span")).getText();
	}
	
	public String PhysicianNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String FirstNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[12]/td[1]/span")).getText();
	}
	
	public String LastNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[14]/td[1]/span")).getText();
	}
	
	public String AddressOneRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/span")).getText();
	}
	
	public String CityRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String ResidingStateRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[1]/span")).getText();
	}
	
	public String ZipCodeRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[1]/span")).getText();
	}
	
	public String PhoneNumberRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[1]/span")).getText();
	}
	
	public String FaxNumberRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[12]/td[1]/span")).getText();
	}
	
	public WebElement RequiredFieldsValidationMsgUnderAddButton()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[(text()[1] = 'Validation Error.The NPI field is required.')]"));
	}
	
	
}
