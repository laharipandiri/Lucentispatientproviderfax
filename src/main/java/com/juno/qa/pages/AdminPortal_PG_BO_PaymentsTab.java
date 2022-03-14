package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_PaymentsTab extends TestBase {
	
	public AdminPortal_PG_BO_PaymentsTab () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PaymentsTab()
	{
		return driver.findElement(By.xpath("//*[@id='tabs']//*[text()='Payments']"));
	}
	
	public Select ProgramTypeDropdown()
	{
		Select ProgramType = new Select(driver.findElement(By.id("program")));
		return ProgramType;
	}
	
	public WebElement FromRequestDate()
	{
		return driver.findElement(By.name("request_from_date"));
	}
	
	public WebElement ToRequestDate()
	{
		return driver.findElement(By.name("request_to_date"));
	}
	
	public WebElement FindButton()
	{
		return driver.findElement(By.name("find_provider_payments"));
	}
	
	public WebElement ExportExcel()
	{
		return driver.findElement(By.linkText("Export to Excel"));
	}
	
	public List<WebElement> CheckToProviderTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabprovider_10']/div[3]/table/thead/tr[1]/th"));
	}
	
	public List<WebElement> EFTToProviderTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabprovider_10']/div[5]/table/thead/tr[1]/th"));
	}
	
	public List<WebElement> CheckToProviderTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr"));
	}
	
	public List<WebElement> EFTToProviderTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr"));
	}
	
	public WebElement CheckToProviderColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='check-list']//th[" + i + "]"));
	}
	
	public WebElement EFTToProviderColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='pch-list']//th[" + i + "]"));
	}
	
	public String ProgramNameColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[1]")).getText();
	}
	
	public String PatientNameColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String MemberIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
	}
	
	public String TreatmentIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public String DOSColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[5]")).getText();
	}
	
	public String CheckIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[6]")).getText();
	}
	
	public String PaymentIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[7]")).getText();
	}
	
	public String CheckStatusColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[8]")).getText();
	}
	
	public String PaidAmountColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[9]")).getText();
	}
	
	public String PaidDateColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[10]")).getText();
	}
	
	public String PartnerPracticeIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[3]/table/tbody/tr["+i+"]/td[11]")).getText();
	}
	
	public String EFTProgramNameColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[1]")).getText();
	}
	
	public String EFTPatientNameColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String EFTMemberIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[3]")).getText();
	}
	
	public String EFTTreatmentIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public String EFTDOSColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[5]")).getText();
	}
	
	public String EFTACHIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[6]")).getText();
	}
	
	public String EFTPaymentIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[7]")).getText();
	}
	
	public String EFTACHStatusColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[8]")).getText();
	}
	
	public String EFTPaidAmountColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[9]")).getText();
	}
	
	public String EFTPaidDateColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[10]")).getText();
	}
	
	public String EFTPartnerPracticeIDColValue(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[5]/table/tbody/tr["+i+"]/td[11]")).getText();
	}
	
	public String CheckToProviderTotal()
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[2]/table/tbody/tr[1]/td[2]")).getText();
	}
	
	public String EFTToProviderTotal()
	{
		return driver.findElement(By.xpath("//div[@id='tabprovider_10']/div[4]/table/tbody/tr[1]/td[2]")).getText();
	}
	
}
