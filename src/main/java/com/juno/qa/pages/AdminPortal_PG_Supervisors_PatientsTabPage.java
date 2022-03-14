package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_PatientsTabPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_PatientsTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PGSupervisorsPatientsTab()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div/ul[@id='tabs']/li[4]/a"));
	}
	
	public List<WebElement> PGSupervisorsPatientListTableColumns()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/thead/tr/th"));
	}
	
	public String PGSupervisorsPatientsTabActivationDateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[1]")).getText();
	}
	
	public String PGSupervisorsPatientsTabPatientNameColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String PGSupervisorsPatientsTabCityColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[3]")).getText();
	}
	
	public String PGSupervisorsPatientsTabStateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[4]")).getText();
	}
	
	public String PGSupervisorsPatientsTabZipColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[5]")).getText();
	}
	
	public String PGSupervisorsPatientsTabMemberIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[6]")).getText();
	}
	
	public String PGSupervisorsPatientsTabPartnerPatientIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[7]")).getText();
	}
	
	public String PGSupervisorsPatientsTabCardIDColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[9]")).getText();
	}
	
	public String PGSupervisorsPatientsTabProviderNameTypeColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[10]")).getText();
	}
	
	public WebElement PGSupervisorsPatientFirstReviewLink()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[11]/form/input[@name='Review']"));
	}

}
