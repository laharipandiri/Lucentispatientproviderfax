package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_ListPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_ListPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement SupervisorsListAllLink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[27]/form/input[8]"));
	}
	
	public WebElement SupervisorsListTotalCountLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]"));
	}
	
	public List<WebElement> SupervisorsListHeaderAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td"));
	}
	
	public List<WebElement> SupervisorsListFooterAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[4]/table/tbody/tr/td"));
	}
	
	public List<WebElement> SupervisorsListHeaderColumns()
	{
		return driver.findElements(By.xpath("//*[@id='sortTable']/thead/tr/th"));
	}
	
	public WebElement SupervisorsListALink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[1]/form/input[8]"));
	}

}
