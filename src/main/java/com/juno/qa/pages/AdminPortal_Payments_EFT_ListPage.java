package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Payments_EFT_ListPage extends TestBase {
	
	public AdminPortal_Payments_EFT_ListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> ACHDetailsTableCols()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/thead/tr"));
	}
	
	public List<WebElement> ACHDetailsTableRows()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr"));
	}
	
	public WebElement ACHDetailsCardIDTableCol()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/thead/tr/th[7]"));
	}
	
	public WebElement SummaryProgramFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[1]"));
	}
	
	public WebElement SummaryACHStatusFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/th[1]"));
	}
	
	public WebElement SummaryTotalCountFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[2]"));
	}
	
	public WebElement SummaryTotalAmountFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[3]"));
	}
	
	public WebElement SummaryPaymentPeriodFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[4]"));
	}
	
	public WebElement SummaryStateDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[5]"));
	}
	
	public WebElement SummaryEndDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/div/table/tbody/tr/td[6]"));
	}
	
	public WebElement DetailProgramLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[1]"));
	}
	
	public WebElement DetailACHIDLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/th[1]"));
	}
	
	public WebElement DetailACHStatusInGridLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[2]"));
	}
	
	public WebElement DetailLoadCountLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[3]"));
	}
	
	public WebElement DetailTotalAmountLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[4]"));
	}
	
	public WebElement DetailAmountInGridLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[5]"));
	}
	
	public WebElement DetailCardIDInGridLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[6]"));
	}
	
	public WebElement DetailCreatedDateLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[7]"));
	}
	
	public WebElement DetailPaymentPeriodInGridLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[8]"));
	}
	
	public WebElement DetailStateDateLatestRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[9]"));
	}
	
	public WebElement DetailEndDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[10]"));
	}
	
	public WebElement DetailFileNameInGridFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[11]"));
	}
	
	public WebElement DetailHeaderFilenameInGridFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+ACHDetailsTableRows().size()+"]/td[12]"));
	}
	
	
	
	
	
	public WebElement DetailProgramMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[1]"));
	}
	
	public WebElement DetailACHIDMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/th[1]"));
	}
	
	public WebElement DetailACHStatusInGridMatchingRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[2]"));
	}
	
	public WebElement DetailLoadCountMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[3]"));
	}
	
	public WebElement DetailTotalAmountMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[4]"));
	}
	
	public WebElement DetailAmountInGridMatchingRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[5]"));
	}
	
	public WebElement DetailCardIDInGridMatchingRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[6]"));
	}
	
	public WebElement DetailCreatedDateMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[7]"));
	}
	
	public WebElement DetailPaymentPeriodInGridMatchingRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[8]"));
	}
	
	public WebElement DetailStateDateMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[9]"));
	}
	
	public WebElement DetailEndDateMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[10]"));
	}
	
	public WebElement DetailFileNameMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[11]"));
	}
	
	public WebElement HeaderFileNameMatchingRowValue(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div[3]/div/table/tbody/tr["+i+"]/td[12]"));
	}
	
	
}
