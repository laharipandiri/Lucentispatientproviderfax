package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_NewPage extends TestBase {
	
	public AdminPortal_PG_GP_NewPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement GPNewAddbutton()
	{
		return driver.findElement(By.className("button_search"));
	}
	
	public Select GPNewProgramName()
	{
		Select programNames = new Select(driver.findElement(By.id("provider_type")));
		return programNames;
	}
	
	public Select GPNewProviderType()
	{
		Select programNames = new Select(driver.findElement(By.id("provider_type")));
		return programNames;
	}
	
	public WebElement GPNewPhysicianNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public WebElement GPNewPracticeName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement GPNewFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement GPNewLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement GPNewAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement GPNewCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public Select GPNewState()
	{
		Select states = new Select(driver.findElement(By.id("provider_state")));
		return states;
	}
	
	public List<WebElement> GPNewStatesList()
	{
		return driver.findElements(By.xpath("//*[@id='provider_state']/option"));
	}
	
	public WebElement GPNewStatesListNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='provider_state']/option["+i+"]"));
	}
	
	public WebElement GPNewZipCode()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement GPNewPhoneNumber()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement GPNewFaxField()
	{
		return driver.findElement(By.id("provider_fax_number"));
	}
	
	public WebElement GPNewTaxField()
	{
		return driver.findElement(By.id("tax_id"));
	}
	
	public WebElement GPNewConfirmationID()
	{
		return driver.findElement(By.xpath("//*[@id=\"provideradd\"]/table/tbody/tr[1]/td[1]/table/tbody/tr[22]/td[2]"));
	}
	
	public String GPNewNPIRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[1]/span")).getText();
	}
	
	public String GPNewPracticeNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String GPNewFirstNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[12]/td[1]/span")).getText();
	}
	
	public String GPNewLastNameRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[14]/td[1]/span")).getText();
	}
	
	public String GPNewAddressOneRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/span")).getText();
	}
	
	public String GPNewCityRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[1]/span")).getText();
	}
	
	public String GPNewResidingStateRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[1]/span")).getText();
	}
	
	public String GPNewZipCodeRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[1]/span")).getText();
	}
	
	public String GPNewPhoneNumberRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[1]/span")).getText();
	}
	
	public String GPNewTaxFieldRequired()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[2]/table/tbody/tr[11]/td[1]/span")).getText();
	}
	
	public WebElement GPNewRequiredFieldsValidationMsgUnderAddButton()
	{
		return driver.findElement(By.xpath("//font[@color='red']"));
	}
	
	public WebElement GPNewConfirmationMsgOne()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[1]"));
	}
	
	public WebElement GPNewConfirmationMsgTwo()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[3]/td/font[2]"));
	}
	
	public void VerifyAbilityToCreateNewGPRecord(List<String> testData) throws InterruptedException
	{
		
		GPNewFirstName().sendKeys(testData.get(0));
		GPNewLastName().sendKeys(testData.get(1));
		GPNewPracticeName().sendKeys(testData.get(2));
		GPNewAddressOne().sendKeys(testData.get(3));
		GPNewCity().sendKeys(testData.get(4));
		GPNewState().selectByVisibleText(testData.get(5));
		GPNewZipCode().sendKeys(testData.get(6));
		GPNewPhoneNumber().click();
		GPNewPhoneNumber().sendKeys(testData.get(7));
		GPNewTaxField().click();
		GPNewTaxField().sendKeys(testData.get(8));
		
		GPNewAddbutton().click();
		Thread.sleep(2000);
		
	}
	
}
