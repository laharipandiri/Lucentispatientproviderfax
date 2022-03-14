package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_FindPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_FindPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement SupervisorsFindButton()
	{
		return driver.findElement(By.name("find"));
	}
	
	public WebElement SupervisorsLastName()
	{
		return driver.findElement(By.name("last_name"));
	}
	
	public WebElement SupervisorsCRXPhysicianID()
	{
		return driver.findElement(By.name("provider_other_id"));
	}
	
	public WebElement SupervisorsProviderID()
	{
		return driver.findElement(By.name("provider_id"));
	}
	
	public Select SupervisorsResidingStateDropdown()
	{
		Select state = new Select(driver.findElement(By.name("state")));
		return state;
	}
	
	public Select SupervisorsResidingTerritoryDropdown()
	{
		Select territory = new Select(driver.findElement(By.name("territory")));
		return territory;
	}
	
	public WebElement SupervisorsCardID()
	{
		return driver.findElement(By.name("short_card_id"));
	}
	
	public WebElement SupervisorsTaxID()
	{
		return driver.findElement(By.name("tax_id"));
	}
	
	public WebElement SupervisorsGroupPracticeSupervisorsName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement SupervisorsPartnerPracticeID()
	{
		return driver.findElement(By.name("provider_referral_code"));
	}
	
	public WebElement SupervisorsNPI()
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	public Select SupervisorsProviderTypeDropdown()
	{
		Select providerType = new Select(driver.findElement(By.name("provider_type")));
		return providerType;
	}
	
	public Select SupervisorsProviderStatusDropdown()
	{
		Select providerStatus = new Select(driver.findElement(By.name("provider_status")));
		return providerStatus;
	}
	
	public WebElement SupervisorsCity()
	{
		return driver.findElement(By.name("city"));
	}
	
	public WebElement SupervisorsFindTotalCount()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]"));
	}
	
	public List<WebElement> FindPageGridCols()
	{
		return driver.findElements(By.xpath("//*[@id='sortTable']/thead/tr/th"));
	}
	
	public WebElement FindPageGridColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/thead/tr/th["+i+"]"));
	}
	
	public String GroupPracticeSupervisorNameColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[1]")).getText();
	}
	
	public String ContactNameColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[2]")).getText();
	}
	
	public String AddressColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[3]")).getText();
	}
	
	public String  CityColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[4]")).getText();
	}
	
	public String  StateColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[5]")).getText();
	}
	
	public String  ZipColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[6]")).getText();
	}
	
	public String TerritoryColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[7]")).getText();
	}
	
	public String CardIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[8]")).getText();
	}
	
	public String PartnerPracticeIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[9]")).getText();
	}
	
	public String CrxPhysicianIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[10]")).getText();
	}
	
	public String ProviderTypeColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[9]")).getText();
	}
	
	public String ProviderIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[10]")).getText();
	}
	
	public String NPIColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[12]")).getText();
	}
	
	public String TaxIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[13]")).getText();
	}
	
	public String ActionColValue()
	{
		return driver.findElement(By.xpath("//*[@id=' sortTable']/tbody/tr/td[14]/form/input[7]")).getAttribute("value");
	}
	
	public WebElement FirstReviewLinkInSearchGrid()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[14]/form/input[7]"));
	}

}
