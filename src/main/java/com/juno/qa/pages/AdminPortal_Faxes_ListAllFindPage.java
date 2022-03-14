package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_Faxes_ListAllFindPage extends TestBase {
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	
	public AdminPortal_Faxes_ListAllFindPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProgramDropdown()
	{
		Select programList = new Select(driver.findElement(By.id("program")));
		return programList;
	}
	
	public Select HelpDeskUserDropdown()
	{
		Select HDUserList = new Select(driver.findElement(By.id("assigned_user")));
		return HDUserList;
	}
	
	public WebElement EnrollFromDate()
	{
		return driver.findElement(By.name("request_date_from"));
	}
	
	public WebElement EnrollToDate()
	{
		return driver.findElement(By.name("request_date_to"));
	}
	
	public WebElement CardID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement FaxID()
	{
		return driver.findElement(By.name("fax_id"));
	}
	
	public WebElement MemberID()
	{
		return driver.findElement(By.name("patient_other_id"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.name("patient_referral_code"));
	}
	
	public Select FaxTYpeDropdown()
	{
		Select faxTypeList = new Select(driver.findElement(By.id("fax_type")));
		return faxTypeList;
	}
	
	public Select FaxStatusDropdown()
	{
		Select faxStatusList = new Select(driver.findElement(By.id("fax_status")));
		return faxStatusList;
	}
	
	public WebElement FaxesPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	
	public String FaxListLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b")).getText();
	}
	
	public String TotalFaxesLabelAndValue()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String CountLabelAndValue()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[3]")).getText();
	
		//return driver.findElement(By.xpath("//*[@id='form-table']/div[2]//table/tbody/tr/td[3]")).getText();
	}
	
	public List<WebElement> ListAllFaxesSearchGridCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th"));
	}
	
	public WebElement ListAllFaxesSearchGridColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> NestedTableDataCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th[5]/table/tbody/tr/th"));
	}
	
	public WebElement NestedTableDataColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th[5]/table/tbody/tr/th["+i+"]"));
	}
}
