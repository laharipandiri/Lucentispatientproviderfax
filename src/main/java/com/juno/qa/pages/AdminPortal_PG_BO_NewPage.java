package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_NewPage extends TestBase {
	
	public AdminPortal_PG_BO_NewPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement BONewAddbutton()
	{
		return driver.findElement(By.className("button_search"));
	}
	
	public Select BONewProgramName()
	{
		Select programNames = new Select(driver.findElement(By.id("program")));
		return programNames;
	}
	
	public Select BONewProviderType()
	{
		Select programNames = new Select(driver.findElement(By.id("provider_type")));
		return programNames;
	}
	
	public WebElement BONewPhysicianNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public WebElement BONewBillingOfficeName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement BONewFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement BONewLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement BONewAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement BONewCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public Select BONewState()
	{
		Select states = new Select(driver.findElement(By.id("provider_state")));
		return states;
	}
	
	public List<WebElement> BONewStatesList()
	{
		return driver.findElements(By.xpath("//*[@id='provider_state']/option"));
	}
	
	public WebElement BONewZipCode()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement BONewPhoneNumber()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement BONewTaxField()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement BONewConfirmationID()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[22]/td[2]"));
	}
	
	public String BONewNPIRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[1]/span")).getText();
	}
	
	public String BONewPracticeNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String BONewFirstNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[12]/td[1]/span")).getText();
	}
	
	public String BONewLastNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[14]/td[1]/span")).getText();
	}
	
	public String BONewAddressOneRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/span")).getText();
	}
	
	public String BONewCityRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String BONewResidingStateRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[1]/span")).getText();
	}
	
	public String BONewZipCodeRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[1]/span")).getText();
	}
	
	public String BONewPhoneNumberRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[1]/span")).getText();
	}
	
	public String BONewTaxFieldRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[11]/td[1]/span")).getText();
	}
	
	public WebElement BONewRequiredFieldsValidationMsgUnderAddButton()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[(text()[1] = \"Validation Error.The NPI field is required.\")]"));
	}
	
	public WebElement BONewConfirmationMsgOne()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[1]"));
	}
	
	public WebElement BONewConfirmationMsgTwo()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[2]"));
	}
	
	public WebElement BOErrorMessageFull()
	{
		return driver.findElement(By.xpath("//font[@color='red']"));
	}
	
	
	public void VerifyAbilityToCreateNewBORecord(List<String> testData) throws InterruptedException
	{
		
		BONewFirstName().sendKeys(testData.get(0));
		BONewLastName().sendKeys(testData.get(1));
		BONewBillingOfficeName().sendKeys(testData.get(2));
		BONewAddressOne().sendKeys(testData.get(3));
		BONewCity().sendKeys(testData.get(4));
		BONewState().selectByVisibleText(testData.get(5));
		BONewZipCode().click();
		BONewZipCode().sendKeys(testData.get(6));
		BONewPhoneNumber().click();
		BONewPhoneNumber().sendKeys(testData.get(7));
		BONewTaxField().click();
		BONewTaxField().sendKeys(testData.get(8));
		
		BONewAddbutton().click();
		Thread.sleep(2000);
		
	} 

}
