package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_EFTTabPage extends TestBase {
	
	public AdminPortal_PG_BO_EFTTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement EFTTab()
	{
		return driver.findElement(By.linkText("EFT"));
	}

}
