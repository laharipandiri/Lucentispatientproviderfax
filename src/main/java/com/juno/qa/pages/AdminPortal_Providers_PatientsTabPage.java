package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Providers_PatientsTabPage extends TestBase {
	
	public AdminPortal_Providers_PatientsTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientListLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div/table/tbody/tr/td/b"));
	}
	
	public List<WebElement> PatientListTableColumns()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/thead/tr/th"));
	}
	
	public WebElement PatientListTableColumnNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public String PatientNameValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String CityValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[3]")).getText();
	}
	
	public String ResidingStateValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[4]")).getText();
	}
	
	public String ZipValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[5]")).getText();
	}
	
	public String MemberIDValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[6]")).getText();
	}
	
	public String PartnerPatientIDValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[7]")).getText();
	}
	
	public String CardIDValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[9]")).getText();
	}
	
	public String ProviderNameTypeValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_4']/div[2]/table/tbody/tr/td[10]")).getText();
	}
	
	public WebElement PatientFirstReviewLink()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr/td[11]/form/input[7]"));
	}
	
	
	
	

}
