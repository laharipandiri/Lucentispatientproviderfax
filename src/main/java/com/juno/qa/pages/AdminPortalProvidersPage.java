package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortalProvidersPage extends TestBase {
	
	public AdminPortalProvidersPage() {
		PageFactory.initElements(driver, this);
	}
	
	//The following locator can be used for all table grid labels in all pages under providers-->physician except for New
	public WebElement ProvidersPhysicianPageGridLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b"));
	}
	
	//Providers-->Physician-->New page page objects
	public WebElement ProviderPhysicianNewPageAddButton()
	{
		return driver.findElement(By.id("add"));
	}
	
	public WebElement ProvidersPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	

}
