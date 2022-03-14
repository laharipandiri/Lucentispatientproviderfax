package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_TransactionsPage extends TestBase {
	
	public AdminPortal_Patients_TransactionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement TransactionsTab()
	{
		return driver.findElement(By.linkText("Transactions"));
	}
	
	public WebElement ShowProviderText()
	{
		return driver.findElement(By.xpath("//*[@id='show_provider_0'][text()[1] = 'Aristacare Health Inc(Billing Office)']"));
		//*[@id="show_provider_0"]/text()[1]
	}
	
	public WebElement ShowPatientText()
	{
		return driver.findElement(By.xpath("//*[@id='show_patient_0'][text()[1] = 'AutoCrx QBR']"));
	}
	
	public WebElement ShowPatientTextForAdminReimbursement()
	{
		return driver.findElement(By.xpath("//*[@id='show_patient_0'][text()[1] = 'AutoCrx OOM']"));
	}
	
	public WebElement DetailsColumnOthersGridTable()
	{
		return driver.findElement(By.xpath("//*[@id='show_trans_detail_0']"));
	}
	
	public WebElement ShowProviderLink()
	{
		return driver.findElement(By.linkText("show provider"));
	}
	
	public WebElement ShowPatientLink()
	{
		return driver.findElement(By.linkText("show patient"));
	}
	
	public WebElement ShowTransactionDetailLink()
	{
		return driver.findElement(By.linkText("show transaction detail"));
	}
}
