package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_MerchantIDAndTerminalTabPage extends TestBase {
	
	public AdminPortal_PG_BO_MerchantIDAndTerminalTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement MerchantIDAndTerminalTab()
	{
		return driver.findElement(By.linkText("Merchant ID(s) & Terminal(s)"));
	}

}
