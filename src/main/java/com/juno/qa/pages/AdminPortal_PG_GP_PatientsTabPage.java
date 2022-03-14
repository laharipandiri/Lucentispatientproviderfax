package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_PatientsTabPage extends TestBase {
	
	public AdminPortal_PG_GP_PatientsTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PGGPPatientsTab()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div/ul[@id='tabs']/li[4]/a"));
	}
	
	public List<WebElement> PGGPPatientListTableColumns()
	{
		return driver.findElements(By.xpath("//table[@id='provider-patient-list']//th"));
	}
	
	public String PGGPPatientsTabActivationDateColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[1]")).getText();
	}
	
	public String PGGPPatientsTabPatientNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[2]")).getText();
	}
	
	public String PGGPPatientsTabCityColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[3]")).getText();
	}
	
	public String PGGPPatientsTabStateColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[4]")).getText();
	}
	
	public String PGGPPatientsTabZipColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[5]")).getText();
	}
	
	public String PGGPPatientsTabMemberIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[6]")).getText();
	}
	
	public String PGGPPatientsTabPartnerPatientIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[6]")).getText();
	}
	
	public String PGGPPatientsTabCardIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[7]")).getText();
	}
	
	public String PGGPPatientsTabProviderNameTypeColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[8]")).getText();
	}
	
	public String PGGPPatientsTabProgramNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td[9]")).getText();
	}
	
	public WebElement PGGPPatientFirstReviewLink()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//*[@name='Review']"));
	}

}
