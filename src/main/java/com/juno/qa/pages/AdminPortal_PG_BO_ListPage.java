package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_ListPage extends TestBase {
	
	public AdminPortal_PG_BO_ListPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement BOListAllLink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[27]/form/input[8]"));
	}
	
	public WebElement BOListTotalCountLabel()
	{
		return driver.findElement(By.xpath("//*[@id='providers-list_info']"));
	}
	
	public List<WebElement> BOListHeaderAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td"));
	}
	
	public List<WebElement> BOListFooterAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[4]/table/tbody/tr/td"));
	}
	
	public List<WebElement> BOListHeaderColumns()
	{
		return driver.findElements(By.xpath("//*[@id='sortTable']/thead/tr/th"));
	}
	
	public WebElement BOListALink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[1]/form/input[8]"));
	}
	
	public int BOGetTotalNoOfRows()
	{
		return driver.findElements(By.xpath("//*[@id='providers-list']//tbody//tr")).size();
	}

}
