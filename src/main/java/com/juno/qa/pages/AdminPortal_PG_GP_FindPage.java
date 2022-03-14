package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_FindPage extends TestBase {
	
	public AdminPortal_PG_GP_FindPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement GPFindButton()
	{
		return driver.findElement(By.name("provider_list_button_find"));
	}
	
	public WebElement GPLastName()
	{
		return driver.findElement(By.name("last_name"));
	}
	
	public WebElement GPFirstName()
	{
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement GPCRXPhysicianID()
	{
		return driver.findElement(By.name("provider_other_id"));
	}
	
	public WebElement GPProviderID()
	{
		return driver.findElement(By.name("provider_id"));
	}
	
	public Select GPResidingStateDropdown()
	{
		Select state = new Select(driver.findElement(By.name("state")));
		return state;
	}
	
/*	public Select GPResidingTerritoryDropdown()
	{
		Select territory = new Select(driver.findElement(By.name("territory")));
		return territory;
	} 
	
	public WebElement GPCardID()
	{
		return driver.findElement(By.name("short_card_id"));
	} */
	
	public WebElement GPTaxID()
	{
		return driver.findElement(By.name("tax_id"));
	}
	
	public WebElement GPProviderLocationName()
	{
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement GPPartnerPracticeID()
	{
		return driver.findElement(By.name("provider_referral_code"));
	}
	
	public WebElement GPNPI()
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	public Select GPProviderTypeDropdown()
	{
		Select providerType = new Select(driver.findElement(By.name("provider_type")));
		return providerType;
	}
	
	public Select GPProviderStatusDropdown()
	{
		Select providerStatus = new Select(driver.findElement(By.name("provider_status_id")));
		return providerStatus;
	}
	
	public WebElement GPCity()
	{
		return driver.findElement(By.name("city"));
	}
	
	public WebElement GPFindTotalCount()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]"));
	}
	
	public List<WebElement> FindPageGridCols()
	{
		return driver.findElements(By.xpath("//table[@id='providers-list']//th"));
	}
	
	public WebElement FindPageGridColNames(int i)
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//th["+i+"]"));
	}
	
	public String PracticeLocationNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[1]")).getText();
	}
	
	public String ContactNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[2]")).getText();
	}
	
	public String AddressColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[3]")).getText();
	}
	
	public String  CityColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[4]")).getText();
	}
	
	public String  StateColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[5]")).getText();
	}
	
	public String  ZipColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[6]")).getText();
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
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[7]")).getText();
	}
	
	public String CrxPhysicianIDColValue()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[8]")).getText();
	}
	
	public String ProviderTypeColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[9]")).getText();
	}
	
	public String ProviderIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[10]")).getText();
	}
	
	public String ParentProviderIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[11]")).getText();
	}
	
	public String NPIColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[12]")).getText();
	}
	
	public String TaxIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='providers-list']//tbody//td[13]")).getText();
	}
	
	public String ActionColValue()
	{
		return driver.findElement(By.xpath("//*[@id=' sortTable']/tbody/tr/td[14]/form/input[7]")).getAttribute("value");
	}
	
	public WebElement FirstReviewLinkInSearchGrid()
	{
		return driver.findElement(By.xpath("//*[@id='providers-list']/tbody/tr//*[@name='Review']"));
	}
	
	
	

}
