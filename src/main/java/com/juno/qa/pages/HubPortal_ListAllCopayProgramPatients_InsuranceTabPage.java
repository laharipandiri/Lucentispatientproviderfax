package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;

public class HubPortal_ListAllCopayProgramPatients_InsuranceTabPage extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	public HubPortal_ListAllCopayProgramPatients_InsuranceTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement InsuranceTab()
	{
		return driver.findElement(By.linkText("Insurance"));
	}
	
	public String InsuranceHistoryLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[2][@id='tabs-5']/p")).getText();
	}
	
	public List<WebElement> InsuranceTabGridCols()
	{
		return driver.findElements(By.xpath("//div[@class='display_list_insurance']/div/table/tbody/tr[1]/td"));
	}
	
	public WebElement InsuranceTabGridColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@class='display_list_insurance']/div/table/tbody/tr[1]/td["+i+"]"));
	}
	
	public WebElement InsuranceFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='display_list_insurance']/div/table/tbody/tr[2]/td[1]"));
	}
	
	public WebElement RecordStatusFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='display_list_insurance']/div/table/tbody/tr[2]/td[2]"));
	}
	
	public WebElement LastUpdatedDateFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='display_list_insurance']/div/table/tbody/tr[2]/td[3]"));
	}
	
	public String InsuranceInfo_Hub(List<String> testData)
	{
		String info = "Insurance Company Name : "+testData.get(0)+"\n"+"Insurance Payer Name : "+testData.get(0)+"\n"+"Insurance Plan Type : primary medical insurance"+"\n"+"Insurance Group Number : "+testData.get(1)+"\n"+
						"Insurance Member Number : "+testData.get(2)+"\n"+"Insurance Effective Date :"+"\n"+"Insurance Bin Number : "+testData.get(3)+"\n"
						+"Insurance Pcn Number : "+testData.get(4)+"\n"+"Rxinsurance Group Number : "+testData.get(1)+"\n"+"Rxinsurance Member Number : "+testData.get(2)+"\n"+"Rxinsurance Bin Number : "+
						testData.get(3)+"\n"+"Rxinsurance Pcn Number : "+testData.get(4);
		
		return info;
	}
	
	
	
	

}
