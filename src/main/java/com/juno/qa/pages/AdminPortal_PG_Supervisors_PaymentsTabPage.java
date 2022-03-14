package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_PaymentsTabPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_PaymentsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PaymentsTab()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div/ul[@class='provider_tabs']/li[6]/a"));
	}

}
