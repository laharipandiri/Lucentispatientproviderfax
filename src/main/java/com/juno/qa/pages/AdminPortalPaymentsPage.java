package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortalPaymentsPage extends TestBase {
	
	public AdminPortalPaymentsPage() {
		PageFactory.initElements(driver, this);
	}
		
	public WebElement PaymentsPageAddButton()
	{
		return driver.findElement(By.className("button_add"));
	} 
	
	public WebElement PaymentsPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}

}
