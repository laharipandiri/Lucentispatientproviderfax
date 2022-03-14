package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PaymentsPage extends TestBase {
	
	public AdminPortal_PaymentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CardID()
	{
		return driver.findElement(By.name("short_card_id"));
	}
	
	public WebElement FindButton()
	{
		//return driver.findElement(By.className("button_find"));//updated 01102022
		return driver.findElement(By.className("btn_update"));
		
	}
	
	public List<WebElement> PaymentsCheckListPageGridRows()
	{
		return driver.findElements(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr"));
	}
	
	public WebElement CardIDCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/thead/tr/th[4]"));
	}
	
	public WebElement FirstRowPaymentStatusCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[1]"));
	}
	
	public WebElement FirstRowCheckNumCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[2]"));
	}
	
	public WebElement FirstRowAmountCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[3]"));
	}
	
	public WebElement FirstRowCardIDCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[4]"));
	}
	
	public WebElement FirstRowMemberIDCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[5]"));
	}
	
	public WebElement FirstRowRequestDateCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[6]"));
	}
	
	public WebElement FirstRowDateIssuedCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[7]"));
	}
	
	public WebElement FirstRowDateSentCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[8]"));
	}
	
	public WebElement FirstRowCheckStatusCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[9]"));
	}
	
	public WebElement FirstRowPayeeInfoCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[10]"));
	}
	
	public WebElement FirstRowFaxIDCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[11]"));
	}
	
	public WebElement FirstRowPayPatientCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[12]"));
	}
	
	public WebElement FirstRowNotesCol()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr[1]/td[13]/textarea"));
	}
	
	

}
