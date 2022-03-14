package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_Providers_PhysicianAndCardInfoTabPage extends TestBase {
	
	public AdminPortal_Providers_PhysicianAndCardInfoTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement RefreshLink()
	{
		return driver.findElement(By.xpath("//*[@name='add']"));
	}
	
	public WebElement GetPhysicanAndCardInfoTab()
	{
		return driver.findElement(By.linkText("Physician Info & Card Info"));
	}
	
	public WebElement GetParentProvidersTab()
	{
		return driver.findElement(By.linkText("Parent Providers"));
	}
	
	public WebElement GetParentProvidersTabByID()
	{
		return driver.findElement(By.id("provider_parentproviders_list"));
	}
	
	public String ClickParentProvidersTabUsingJS()
	{
		return "document.getElementById('provider_parentproviders_list').click()";
	}
	
	public WebElement GetPhysicianPatientsTab()
	{
		return driver.findElement(By.xpath("//div[@class = 'form-container']/div[@id='tabs_wrapper']/div/ul[@id='tabs']/li[3]/a[text() = 'Patients']"));
	}
	
/*	public WebElement GetMerchantTerminalTab()
	{
		return driver.findElement(By.linkText("Merchant ID(s) & Terminal(s)"));
	} */
	
	public WebElement GetNotesTab()
	{
		return driver.findElement(By.linkText("Notes"));
	}
	
	public WebElement PaymentsTab()
	{
		return driver.findElement(By.linkText("Payments"));
	}
	//
	public WebElement PhysicianNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public Select ProviderType()
	{
		Select ProviderTypeList = new Select(driver.findElement(By.id("provider_type")));
		return ProviderTypeList;
	}
	
	public WebElement ProviderPhysicianName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement PartnerPracticeID()
	{
		return driver.findElement(By.id("provider_referral_code"));
	}
	
	public WebElement ProviderFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement ProviderLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement ProviderLoginID()
	{
		return driver.findElement(By.id("provider_login_id"));
	}
	
	public WebElement ProviderConfirmLoginID()
	{
		return driver.findElement(By.id("login_id2"));
	}
	
	public Select Territory()
	{
		Select TerritoryList = new Select(driver.findElement(By.id("territories")));
		return TerritoryList;
	}
	
	public Select Status()
	{
		Select StatusList = new Select(driver.findElement(By.id("provider_status")));
		return StatusList;
	}
	
	public WebElement ProviderContactName()
	{
		return driver.findElement(By.id("provider_location_name"));
	}
	
	public WebElement ProviderAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement ProviderCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public Select ResidingState()
	{
		Select StatesList = new Select(driver.findElement(By.id("provider_state")));
		return StatesList;
	}
	
	public List<WebElement> ProviderState()
	{
		return driver.findElements(By.xpath("//*[@id = 'provider_state']/option"));
	}
	
	public WebElement ProviderZip()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement ProviderTaxID()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement ProviderPhone()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement ProviderFax()
	{
		return driver.findElement(By.id("provider_fax_number"));
	}
	
	public WebElement ProviderEmail()
	{
		return driver.findElement(By.name("provider_email_address"));
	}
	
	public WebElement ProviderConfirmEmail()
	{
		return driver.findElement(By.id("provider_email_address2"));
	}
	
	public WebElement UpdateButton() //updated for express 2.0
	{
		return driver.findElement(By.id("add"));
	}
	
	public WebElement UpdateConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[1]"));
	}
	
	public String ConfirmationIDValue()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table[1]/tbody/tr[1]/td[1]/table/tbody/tr[15]/td[2]")).getText();
		
	}
	
	

}
