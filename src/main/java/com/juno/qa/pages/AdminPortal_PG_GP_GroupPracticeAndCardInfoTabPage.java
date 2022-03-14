package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage extends TestBase {
	
	public AdminPortal_PG_GP_GroupPracticeAndCardInfoTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProviderTypeDropDown()
	{
		Select providerType = new Select(driver.findElement(By.id("provider_type")));
		return providerType;
	}
	
	public WebElement GroupPracticeAndCardInfoTab()
	{
		return driver.findElement(By.linkText("Group Practice Info & Card Info"));
	}
	
	public WebElement GPRefreshLink()
	{
		return driver.findElement(By.xpath("//*[@name='add']"));
	}
	
	public Select ResidingStateDropDown()
	{
		Select providerState = new Select(driver.findElement(By.id("provider_state")));
		return providerState;
	}
	
	public WebElement GPAndCardFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement GPAndCardLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement GPAndCardGPName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement GPAndCardLoginID()
	{
		return driver.findElement(By.id("provider_login_id"));
	}
	
	public WebElement GPAndCardConfirmLoginID()
	{
		return driver.findElement(By.id("login_id2"));
	}
	
	public WebElement GPAndCardAddress()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement GPAndCardCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public List<WebElement> GPAndCardState()
	{
		return driver.findElements(By.xpath("//*[@id='provider_state']/option"));
	}
	
	public WebElement GPAndCardZip()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement GPAndCardPhone()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement GPAndCardTax()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement GPAndCardEmail()
	{
		return driver.findElement(By.xpath("//*[@name='provider_email_address' and @type='text']"));
	}
	
	public WebElement GPFaxNumber()
	{
		return driver.findElement(By.name("fax_back_number"));
	}
	
	public WebElement GPAndCardConfirmEmail()
	{
		return driver.findElement(By.name("provider_email_address2"));
	}
	
	public WebElement GPUpdateConfirmationMessage()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font"));
	}
	
	public String GroupPracticeNameFieldValue()
	{
		return driver.findElement(By.id("provider_name")).getAttribute("value");
	}
	
	public String GroupPracticePartnerPracticeIDValue()
	{
		return driver.findElement(By.name("provider_referral_code")).getAttribute("value");
	}
	
	public String ContactNameFieldValue()
	{
		return driver.findElement(By.id("provider_location_name")).getAttribute("value");
	}
	
	public String NameFieldValue()
	{
		String firstName = driver.findElement(By.id("provider_first_name")).getAttribute("value");
		String middleName = driver.findElement(By.name("provider_middle_initial")).getAttribute("value");
		String lastName = driver.findElement(By.id("provider_last_name")).getAttribute("value");
		String fullname = "";
		if(middleName.isBlank()) {
			fullname = firstName + " " + lastName; 
		}else {
			fullname = firstName + " " + middleName + ". " + lastName;
		}
		return fullname;
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
		return driver.findElement(By.xpath("//*[text()='Confirmation ID']/parent::tr//*[@class='dataform']")).getText().trim();
	}
	
	public String NPIFieldValue()
	{
		//return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[22]/td[2]")).getText();
		return driver.findElement(By.id("provider_npi")).getAttribute("value");
	}
	
	public String TaxIDFieldValue()
	{
		return driver.findElement(By.id("tax_id")).getAttribute("value");
	}
	
	public WebElement UpdateButton()
	{
		return driver.findElement(By.className("button_search"));
	}
	
	public WebElement GPAndCardPassword()
	{
		return driver.findElement(By.id("password"));
	}
	
	public WebElement GPAndCardConfirmPassword()
	{
		return driver.findElement(By.id("re_password"));
	}
	
	
	
	
	

}
