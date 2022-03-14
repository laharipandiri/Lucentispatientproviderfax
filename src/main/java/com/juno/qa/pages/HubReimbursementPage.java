package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubReimbursementPage extends TestBase {
	
	//The page objects in this class are for both admin & drug reimbursement details pages
	
	public HubReimbursementPage() {
		PageFactory.initElements(driver, this);
	}

	/* Hub DrugReimbursement Page - page objects */
	
	public WebElement HubReimbursementHomePageHeading()
	{
		return driver.findElement(By.xpath("//div[@id='eContainer']/article/h1"));
	}
	
	public WebElement EnrollAPatientButton()
	{
		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//*[text()='Patient']")).click();
		return driver.findElement(By.linkText("Enroll a Patient"));
	}
	
	public void ClickEnrollAPatientButton()
	{
		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//*[text()='Patient']")).click();
		driver.findElement(By.linkText("Enroll a Patient")).click();
	}
	
	public WebElement FindCopayProgramPatientsButton()
	{
		return driver.findElement(By.linkText("Find Copay Program Patients"));
	}
	
	
	public WebElement ListAllCopayProgramPatientsButton()
	{
		return driver.findElement(By.linkText("List All Copay Program Patients"));
	}
	
	public WebElement DownloadableFormsButton()
	{
		return driver.findElement(By.linkText("Downloadable Forms"));
	}
	
	
	public WebElement SelectAProgramButton()
	{
		return driver.findElement(By.linkText("Select a Program"));
	}
	
	public WebElement CopaySupportContactButton()
	{
		return driver.findElement(By.linkText("Copay Support Contact"));
	}
	
	public WebElement HubReimbursementLogoutButton()
	{
		return driver.findElement(By.linkText("Log Out"));
		
	}
	
	public WebElement UploadEOBButton()
	{
		return driver.findElement(By.linkText("Upload EOB"));
	}
	
	public WebElement ConnectiveRXHeaderImage()
	{
		return driver.findElement(By.xpath("//*[@id='header']/div/a/img"));
	}
	
	public WebElement TherapyHeaderImage()
	{
		return driver.findElement(By.xpath("//*[@id='header']/div/ul/img"));
	}
	
	public WebElement ConnectiveRXFooterImage()
	{ 
		return driver.findElement(By.xpath("//*[@id='footer-bottom']/div/div[2]/div/a/img"));
	}
	
	public WebElement PrivacyPolicyFooterMessage()
	{
		return driver.findElement(By.linkText("PRIVACY POLICY"));
	}
	
	public WebElement CopyrightFooterMessage()
	{
		/* The following locator returns Privacy Policy line as well and works to verify the copyright as well */
		return driver.findElement(By.xpath("//div[contains(@class,'isi-footer-bottom-middle') and contains(.,'Copyright © 2021 ConnectiveRx. All rights reserved.')]"));
		
	}
	
	public String HubAdminReimbursementDetailsPage()
	{
		return driver.getTitle();
	}
	
	public String AdminReimbursementPageHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content']//h1[@class='green']")).getText();
	}
	
	public String DrugReimbursementPageHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content']//h1[@class='green']")).getText();
	}
	
	
	public String EnrollAPatientPageHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content enrollNewPatient']//h1[@class='green']")).getText();
	}
		
	public String FindCopayProgramPatientsHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content findAPatient']//h1[@class='green']")).getText();
	}
	
	public String ListAllCopayProgramPatientsHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content findAPatient']//h1[@class='green']")).getText();
	}
	
	public String UploadEOBHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content enrollNewPatient']//h1[@id='page_heading']")).getText();
	}
	
	public String DownloadableFormsHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content  privacy']//h1[@class='green']")).getText();
	}
	
	public String CopaySupportContactHeading()
	{
		return driver.findElement(By.xpath("//article[@class='content  contact']//h1[@class='green']")).getText();
	}
	
	public String SidePanelButtonsCount()
	{
		//The count is being returned as String since the comparison testData from excel is of type String
		List <WebElement> buttonsList = driver.findElements(By.xpath("//*[@class='nav']/li"));
		String count = String.valueOf(buttonsList.size());
		return count;
	}
	
	
	
	
	
	
	
	
}
