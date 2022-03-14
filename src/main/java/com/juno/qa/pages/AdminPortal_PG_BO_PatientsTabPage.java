package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_PatientsTabPage extends TestBase {
	
	public AdminPortal_PG_BO_PatientsTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PGBOPatientsTab()
	{
		return driver.findElement(By.xpath("//*[@id='provider_patients_list']//*[text()='Patients']"));
	}
	
	public List<WebElement> PGBOPatientListTableColumns()
	{
		return driver.findElements(By.xpath("//table[@id='provider-patient-list']//tbody//tr[1]//td"));
	}
	
	public String PGBOPatientsTabActivationDateColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[1]")).getText();
	}
	
	public String PGBOPatientsTabPatientNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[2]")).getText();
	}
	
	public String PGBOPatientsTabCityColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[3]")).getText();
	}
	
	public String PGBOPatientsTabStateColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[4]")).getText();
	}
	
	public String PGBOPatientsTabZipColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[5]")).getText();
	}
	
	public String PGBOPatientsTabMemberIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[6]")).getText();
	}
	
	public String PGBOPatientsTabPartnerPatientIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[6]")).getText();
	}
	
	public String PGBOPatientsTabCardIDColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[7]")).getText();
	}
	
	public String PGBOPatientsTabProviderNameTypeColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[8]")).getText();
	}
	
	public String PGBOPatientsTabProviderNameColValue()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//tr//td[9]")).getText();
	}
	
	public WebElement PGBOPatientFirstReviewLink()
	{
		return driver.findElement(By.xpath("//table[@id='provider-patient-list']//td//*[@value='Review']"));
	}

}
