package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortalAdminOnlyPage extends TestBase {
	
	public AdminPortalAdminOnlyPage() {
		PageFactory.initElements(driver, this);
	}
		
	public WebElement AdminOnlyPageAddButton()
	{
		return driver.findElement(By.id("add_update"));
	} 
	
	public WebElement AdminOnlyPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	} 
	
	public WebElement AdminOnlyGridLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b"));
	}
	
	public WebElement AdminOnlyPageUpdateButton()
	{
		return driver.findElement(By.name("update"));
	}

}
