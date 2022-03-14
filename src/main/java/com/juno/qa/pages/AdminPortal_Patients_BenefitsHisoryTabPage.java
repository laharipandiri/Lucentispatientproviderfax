package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_BenefitsHisoryTabPage extends TestBase {
	
	public AdminPortal_Patients_BenefitsHisoryTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement BenefitsHistoryTab()
	{
		return driver.findElement(By.linkText("Benefits History"));
	}
	
	public WebElement BenefitsHistoryTableHeader()
	{
		return driver.findElement(By.xpath("//*[@id='tab_9']/div[1]/table/tbody/tr/td/font/strong"));
	}
	
	public List<WebElement> BenefitsHistoryTable()
	{
		return driver.findElements(By.xpath("//*[@id='enrollment-list']"));
	}
	
	public WebElement BenefitsHistoryTableColNames(int i)
	{
		//return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/thead/tr/th["+i+"]"));
		return driver.findElement(By.xpath("//*[@id='enrollment-list']/tbody/tr["+i+"]"));
	}
	public WebElement BenefitsHistoryTableColBenefitPeriod()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_1']"));
	}
	public WebElement BenefitsHistoryTableColCurrentBenefitPeriod()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_2']"));
	}
	public WebElement BenefitsHistoryTableColCurrentBenefitAmount()
	{
		return driver.findElement(By.xpath("//*[@id='dtcol_6']")); //updated for replatform
	}
	
	public WebElement BenefitsPeriodColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[1]"));
	}
	
	public WebElement ActiveBenefitsPeriodColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[2]"));
	}
	
	public WebElement EnrollDateColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[3]"));
	}
	
	public WebElement ExpirationDateColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[4]"));
	}
	
	public WebElement RetroDateColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[5]"));
	}
	
	public WebElement TotalUsageColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[6]"));
	}
	
	public WebElement BalanceColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[7]"));
	}
	
	public WebElement UseNumberColumn()
	{
		return driver.findElement(By.xpath("//div[@id = 'tabs_content_container']/div[@id = 'tab_9']/div[2]/table/tbody/tr[1]/td[8]"));
	}
	
	

}
