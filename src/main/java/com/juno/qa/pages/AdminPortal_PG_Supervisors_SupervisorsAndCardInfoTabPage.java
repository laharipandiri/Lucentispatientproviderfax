package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_SupervisorsAndCardInfoTabPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_SupervisorsAndCardInfoTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProviderTypeDropDown()
	{
		Select providerType = new Select(driver.findElement(By.id("provider_type")));
		return providerType;
	}
	
	public WebElement SupervisorsAndCardInfoTab()
	{
		return driver.findElement(By.linkText("Supervisors Info & Card Info"));
	}
	
	public WebElement RefreshLink()
	{
		return driver.findElement(By.xpath("//*[@name='add']"));
	}
	
	public Select ResidingStateDropDown()
	{
		Select providerState = new Select(driver.findElement(By.id("provider_state")));
		return providerState;
	}
	
	public WebElement SupervisorsAndCardFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement SupervisorsAndCardLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement SupervisorsAndCardSupervisorsName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement SupervisorsAndCardLoginID()
	{
		return driver.findElement(By.id("provider_login_id"));
	}
	
	public WebElement SupervisorsAndCardConfirmLoginID()
	{
		return driver.findElement(By.id("login_id2"));
	}
	
	public WebElement SupervisorsAndCardAddress()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement SupervisorsAndCardCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public List<WebElement> SupervisorsAndCardState()
	{
		return driver.findElements(By.xpath("//*[@id='provider_state']/option"));
	}
	
	public WebElement SupervisorsAndCardZip()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement SupervisorsAndCardPhone()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement SupervisorsAndCardTax()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement SupervisorsAndCardEmail()
	{
		return driver.findElement(By.name("provider_email_address"));
	}
	
	public WebElement SupervisorsAndCardConfirmEmail()
	{
		return driver.findElement(By.name("provider_email_address2"));
	}
	
	public WebElement SupervisorsUpdateConfirmationMessage()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public String SupervisorsNameFieldValue()
	{
		return driver.findElement(By.id("provider_name")).getAttribute("value");
	}
	
	public String ContactNameFieldValue()
	{
		return driver.findElement(By.id("provider_location_name")).getAttribute("value");
	}
	
	public String AddressFieldValue()
	{
		return driver.findElement(By.id("provider_address_1")).getAttribute("value");
	}
	
	public String CityFieldValue()
	{
		return driver.findElement(By.id("provider_city")).getAttribute("value");
	}
	
	public String StateFieldValue()
	{
		return ResidingStateDropDown().getFirstSelectedOption().getText();
	}
	
	public String ZipFieldValue()
	{
		return driver.findElement(By.id("provider_zip")).getAttribute("value");
	}
	
	public Select TerritoryDropDown()
	{
		Select territoryValues = new Select(driver.findElement(By.id("territories")));
		return territoryValues;
	}
	
	public String ProviderIDFieldValue()//confirmationID
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[22]/td[2]")).getText();
	}
	
	public String TaxIDFieldValue()
	{
		return driver.findElement(By.id("tax_id")).getAttribute("value");
	}
	
	public WebElement UpdateButton()
	{
		return driver.findElement(By.className("button_update"));
	}
	
	public WebElement SupervisorsAndCardPassword()
	{
		return driver.findElement(By.id("password"));
	}
	
	public WebElement SupervisorsAndCardConfirmPassword()
	{
		return driver.findElement(By.id("re_password"));
	}
	
	public WebElement ConfirmLoginIDRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[17]/td[1]/span"));
	}
	
	public WebElement ConfirmEmailRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[15]/td[1]/span"));
	}

}
