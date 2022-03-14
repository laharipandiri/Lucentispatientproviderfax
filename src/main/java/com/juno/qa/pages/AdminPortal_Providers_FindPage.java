package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Providers_FindPage extends TestBase {
	
	public AdminPortal_Providers_FindPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> ProvidersFindPageSearchResultGridColHeader()
	{
		return driver.findElements(By.xpath("//*[@id='sortTable']/thead/tr/th"));
	}
	
	public int numOfColsInSearchResultGrid()
	{
		return driver.findElements(By.xpath("//*[@id='sortTable']/thead/tr/th")).size();
	}
	
	public WebElement ProvidersPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	
	public WebElement ProvidersFindFirstReviewButton()
	{
		return driver.findElement(By.name("Review"));
	}
	
	public WebElement ProvidersFindFirstReviewButtonByName(String providerName)
	{
		return driver.findElement(By.xpath("//*[text()='" + providerName  + "']/ancestor::tr//*[@value='Review']"));
	}
	
	public WebElement ProvidersFindFirstUngroupButtonByName(String providerName)
	{
		return driver.findElement(By.xpath("//*[text()='" + providerName  + "']/ancestor::tr//*[@value='Ungroup']"));
	}
	
	public WebElement ProvidersFindProviderNPIField()
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	
	public WebElement ProviderNameField()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement ProviderLastNameField()
	{
		return driver.findElement(By.name("last_name"));
	}
	
	public String ProviderNameColValue()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_0']")).getText();
	}
	
	public String ContactNameColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[2]")).getText();
	}
	
	public String AddressColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[3]")).getText();
	}
	
	public String CityColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String StateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[5]")).getText();
	}
	
	public String ZipColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[6]")).getText();
	}
	
	public String PartnerPracticeIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[7]")).getText();
	}
	
	public String CRXPhysicianIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[8]")).getText();
	}
	
	public String ProviderTypeColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[9]")).getText();
	}
	
	public String ProviderIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[10]")).getText();
	}
	
	public String ParentProviderIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[11]")).getText();
	}
	
	public String NPIColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[12]")).getText();
	}
	
	public String TaxIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[13]")).getText();
	}

}
