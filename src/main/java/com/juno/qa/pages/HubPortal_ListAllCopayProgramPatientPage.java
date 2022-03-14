package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class HubPortal_ListAllCopayProgramPatientPage extends TestBase {
	
	public HubPortal_ListAllCopayProgramPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement MemberIDSearchField()
	{
		return driver.findElement(By.xpath("//*[@id='patients-list_filter']/label/input"));
	}
	
	public WebElement ListAllCopayProgramPatientsPageHeading()
	{
		return driver.findElement(By.xpath("//div[@id='eContainer']/article/h1[@class='green']"));
	}
	
	public WebElement ShowingLabel()
	{
		return driver.findElement(By.xpath("//div[@id='patients-list_wrapper']/div[1]/div[@id='patients-list_info']"));
	}
	
	public Select ShowDropdown()
	{
		Select showList = new Select(driver.findElement(By.name("patients-list_length")));
		return showList;
	}
	
	public WebElement ShowDropdownElement()
	{
		return driver.findElement(By.name("patients-list_length"));
		
	}
	
	public WebElement PaginationLinks()
	{
		return driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_full_numbers']/span"));
	}
	
	public List<WebElement> ListAllCopayPageTableCols()
	{
		return driver.findElements(By.id("patients-list"));
	}
	
	public WebElement ListAllCopayPageTableColName(int i)
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> ListAllCopayPageTableRows()
	{
		return driver.findElements(By.xpath("//table[@id='patients-list']/tbody/tr"));
	}
	
	public WebElement ActionColReviewLink()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[7]/form/input[2][@id='card_payment']"));
	}
	
	public WebElement ActionColUploadFileLink()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[7]/form[2]/input[2][@id='upload_file']"));
	}
	
	public String MemberIDFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[1]")).getText();
	}
	
	public String LastNameFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[2]")).getText();
	}
	
	public String FirstNameFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[3]")).getText();
	}
	
	public String AddressFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[4]")).getText();
	}
	
	public String PartnerPatientIDFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[5]")).getText();
	}
	
	public String StatusFirstRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr/td[6]")).getText();
	}
	
	public String MemberIDLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[1]")).getText();
	}
	
	public String LastNameLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[2]")).getText();
	}
	
	public String FirstNameLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[3]")).getText();
	}
	
	public String AddressLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[4]")).getText();
	}
	
	public String PartnerLastIDLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[5]")).getText();
	}
	
	public String StatusLastRowValue()
	{
		return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+ListAllCopayPageTableRows().size()+"]/td[6]")).getText();
	}
	
	

}
