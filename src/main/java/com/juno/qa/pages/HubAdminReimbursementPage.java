package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubAdminReimbursementPage extends TestBase {
	
	public HubAdminReimbursementPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement AdminReimbursementHomePageHeading()
	{
		return driver.findElement(By.xpath("//div[@id='eContainer']/article/h1"));
	}

}
