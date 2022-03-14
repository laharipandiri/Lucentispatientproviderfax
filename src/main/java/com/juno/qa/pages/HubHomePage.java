package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubHomePage extends TestBase {
	
	public HubHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Hub Portal Home Page - page objects */
	
	public WebElement HubTravelProgramButton()
	{
		return driver.findElement(By.xpath("//button[text()='Admin Reimbursement']"));
	}
	
	public WebElement HubCarTDrugProgramButton()
	{
		return driver.findElement(By.xpath("//button[text()='Drug Reimbursement']"));
	}
	
	
	
}
