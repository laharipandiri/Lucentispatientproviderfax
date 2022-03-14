package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_FaxesTabPage extends TestBase {
	
	public AdminPortal_PG_BO_FaxesTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement FaxesTab()
	{
		//return driver.findElement(By.linkText("Faxes"));
		return driver.findElement(By.xpath("//*[@id='tab_button_6']/a"));
	}
	public WebElement FaxesTabVerification()
	{
		return driver.findElement(By.xpath("//*[@id='tab_6']/div[1]/table/tbody/tr/td/font/strong"));
	}
	
}
