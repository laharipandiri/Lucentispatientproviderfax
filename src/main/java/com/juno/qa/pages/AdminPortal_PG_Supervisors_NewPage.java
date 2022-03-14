package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_NewPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_NewPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement SupervisorsNewAddbutton()
	{
		return driver.findElement(By.className("button_add"));
	}
	
	public Select SupervisorsNewProgramName()
	{
		Select programNames = new Select(driver.findElement(By.id("program")));
		return programNames;
	}
	
	public Select SupervisorsNewProviderType()
	{
		Select programNames = new Select(driver.findElement(By.id("provider_type")));
		return programNames;
	}
	
	public WebElement SupervisorsNewPhysicianNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public WebElement SupervisorsNewBillingOfficeName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement SupervisorsNewFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement SupervisorsNewLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement SupervisorsNewAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement SupervisorsNewCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public Select SupervisorsNewState()
	{
		Select states = new Select(driver.findElement(By.id("provider_state")));
		return states;
	}
	
	public List<WebElement> SupervisorsNewStatesList()
	{
		return driver.findElements(By.xpath("//*[@id='provider_state']/option"));
	}
	
	public WebElement SupervisorsNewStatesListNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='provider_state']/option["+i+"]"));
	}
	
	public WebElement SupervisorsNewZipCode()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement SupervisorsNewPhoneNumber()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement SupervisorsNewTaxField()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement SupervisorsNewFaxField()
	{
		return driver.findElement(By.id("provider_fax_number"));
	}
	
	public WebElement SupervisorsNewConfirmationID()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[22]/td[2]"));
	}
	
	/*public String GPNewNPIRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[1]/span")).getText();
	}*/
	
	public String SupervisorsNewPracticeNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewFirstNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[12]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewLastNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[14]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewAddressOneRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewCityRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewResidingStateRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewZipCodeRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewPhoneNumberRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[1]/span")).getText();
	}
	
	public String SupervisorsNewTaxFieldRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[11]/td[1]/span")).getText();
	}
	
	public WebElement SupervisorsNewRequiredFieldsValidationMsgUnderAddButton()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[(text()[1] = \"Validation Error.The ' Name' field is required.\")]"));
	}
	
	public WebElement SupervisorsNewConfirmationMsgOne()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[1]"));
	}
	
	public WebElement SupervisorsNewConfirmationMsgTwo()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[2]"));
	}
	
	public void VerifyAbilityToCreateNewSupervisorsRecord(List<String> testData) throws InterruptedException
	{
		
		SupervisorsNewFirstName().sendKeys(testData.get(0));
		SupervisorsNewLastName().sendKeys(testData.get(1));
		SupervisorsNewBillingOfficeName().sendKeys(testData.get(2));
		SupervisorsNewAddressOne().sendKeys(testData.get(3));
		SupervisorsNewCity().sendKeys(testData.get(4));
		SupervisorsNewState().selectByVisibleText(testData.get(5));
		SupervisorsNewZipCode().click();
		SupervisorsNewZipCode().sendKeys(testData.get(6));
		SupervisorsNewPhoneNumber().click();
		SupervisorsNewPhoneNumber().sendKeys(testData.get(7));
		SupervisorsNewTaxField().click();
		SupervisorsNewTaxField().sendKeys(testData.get(8));
		
		SupervisorsNewAddbutton().click();
		Thread.sleep(2000);
		
	} 

}
