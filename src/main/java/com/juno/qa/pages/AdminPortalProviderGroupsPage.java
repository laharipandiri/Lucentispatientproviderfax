package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortalProviderGroupsPage extends TestBase {
	
	public AdminPortalProviderGroupsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//The following locator can be used for all table grid labels in all pages under providergroups-->grouppractice except for New
	public WebElement ProviderGroupsPageGridLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b"));
	}
	
	public WebElement PGNewPageAddButton()
	{
		return driver.findElement(By.className("button_add"));
	}
	
	public WebElement PGFindPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}

}
