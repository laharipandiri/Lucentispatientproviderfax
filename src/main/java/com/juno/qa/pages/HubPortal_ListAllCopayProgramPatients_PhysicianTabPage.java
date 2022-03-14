package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubPortal_ListAllCopayProgramPatients_PhysicianTabPage extends TestBase {
	
	public HubPortal_ListAllCopayProgramPatients_PhysicianTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PhysiciansTab()
	{
		return driver.findElement(By.linkText("Provider(s)"));
	}
	
	public String Physicianlabelvalue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/p")).getText();
	}
	
	public List<WebElement> PhysicianTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[1]/td"));
	}
	
	public WebElement PhysicianTableColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr/td["+i+"]"));
	}
	
	public List<WebElement> PhysicianNestedTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/thead/tr/th"));
	}
	
	public WebElement PhysicianNestedTableColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/thead/tr/th["+i+"]"));
	}
	
	public String NestedTableTypeValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[1]")).getText();
	}
	
	public String NestedTableLocationNameValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[2]")).getText();
	}
	
	public String NestedTableNameValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[3]")).getText();
	}
	
	public String NestedTableAddressValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[4]")).getText();
	}
	
	public String NestedTableInfoValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[5]")).getText();
	}
	
	public WebElement NestedTableType()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[1]"));
	}
	
	public WebElement NestedTableLocationName()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[2]"));
	}
	
	public WebElement NestedTableName()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[3]"));
	}
	
	public WebElement NestedTableAddress()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[4]"));
	}
	
	public WebElement NestedTableInfo()
	{
		return driver.findElement(By.xpath("//div[@id='tabs-2']/table[@class='reportTable']/tbody/tr[3]/td/table/tbody/tr/th[5]"));
	}
	
	

}
