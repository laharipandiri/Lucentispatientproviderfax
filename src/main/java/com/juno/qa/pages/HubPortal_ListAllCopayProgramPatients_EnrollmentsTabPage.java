package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubPortal_ListAllCopayProgramPatients_EnrollmentsTabPage extends TestBase {
	
	public HubPortal_ListAllCopayProgramPatients_EnrollmentsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement EnrollmentsTab()
	{
		return driver.findElement(By.linkText("Enrollment(s)"));
	}
	
	public String EnrollmentsHistoryLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/p")).getText();
	}
	
	public List<WebElement> EnrollmentsTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[1]/td"));
	}
	
	public WebElement EnrollmentTableColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[1]/td["+i+"]"));
	}
	
	public String ActiveColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String EnrollDateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public String ExpirationDateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[2]/td[3]")).getText();
	}
	
	public String LookBackDateColValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[6][@id='tabs-6']/table/tbody/tr[2]/td[4]")).getText();
	}
	
	
	
	
	
	

}
