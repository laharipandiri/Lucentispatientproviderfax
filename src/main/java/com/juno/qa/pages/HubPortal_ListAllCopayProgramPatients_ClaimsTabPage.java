package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;


public class HubPortal_ListAllCopayProgramPatients_ClaimsTabPage extends TestBase {
	
	public HubPortal_ListAllCopayProgramPatients_ClaimsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement ClaimsTab()
	{
		return driver.findElement(By.linkText("Claims"));
	}
	
	public WebElement TransactionDateFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[1]"));
	}
	
	public WebElement AmountFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[2]"));
	}
	
	public WebElement DateOfServiceFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[3]"));
	}
	
	public WebElement PhysicianFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[4]"));
	}
	
	public WebElement PaymentTypeFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[5]"));
	}
	
	public WebElement PaymentStatusFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[6]"));
	}
	
	public WebElement ActionFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[7]/input"));
	}
	
	public WebElement ClaimIDFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[1]"));
	}
	
	public WebElement CheckNumberFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[2]"));
	}
	
	public WebElement CheckStatusFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[3]"));
	}
	
	public WebElement CheckDateFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[4]"));
	}
	
	public WebElement RequestedDateFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[5]"));
	}
	
	public WebElement ShippedToFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[6]"));
	}
	
	public WebElement ShippingAddressFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[3]/td/table[@class='historical_claims']/tbody/tr[1]/th[7]"));
	}
	
	public WebElement NoClaimsFoundRow()
	{
		return driver.findElement(By.xpath("//div[@id='claims-treatments-accepted']/div/table/tbody/tr[2]/td[1]"));
	}
	
	

}
