package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_FaxInfoTabPage extends TestBase {
	
	public AdminPortal_Patients_FaxInfoTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> FaxInfoGridCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th"));
	}
	
	public List<WebElement> FaxInfoGridRows()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/tbody/tr"));
	}
	
	public WebElement FaxInfoGridColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th["+i+"]"));
	}
	
	public WebElement FaxInfoTab()
	{
		return driver.findElement(By.linkText("Fax Info"));
	}
	
	public List<WebElement> NestedFaxInfoGridCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th[4]/table/tbody/tr/th"));
	}
	
	public WebElement NestedFaxInfoGridColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th[4]/table/tbody/tr/th["+i+"]"));
	}
	
	/****** Non-nested columns for first and latest row ******/
	
	public String CardIDValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[1]")).getText();
	}
	
	public String FaxTypeValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[2]")).getText();
	}
	
	public String ANIValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[3]")).getText();
	}
	
	public String ReviewedDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[5]")).getText();
	}
	
	public String ApprovedAmountFirstRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[6]")).getText();
	}
	
	public String ApprovedDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[7]")).getText();
	}
	
	public String AssignedToValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[8]")).getText();
	}
	
	public String AssignedDateValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[9]")).getText();
	}
	
	public String NotesValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[10]")).getText();
	}
	
	public WebElement EditAssignLinkFirstRow()
	{
		//return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[11]/form/input[7]")); //updated for replatform
		return driver.findElement(By.xpath("//*[@id='dtcol_10']/form/input[6]"));
		
	}
	
	public String CardIDValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[1]")).getText();
	}
	
	public String FaxTypeValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[2]")).getText();
	}
	
	public String ANIValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[3]")).getText();
	}
	
	public String ReviewedDateLatestRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[5]")).getText();
	}
	
	public String ApprovedAmountLatestRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[6]")).getText();
	}
	
	public String ApprovedDateLatestRowValue()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[7]")).getText();
	}
	
	public String AssignedToValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[8]")).getText();
	}
	
	public String AssignedDateValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[9]")).getText();
	}
	
	public String NotesValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[10]")).getText();
	}
	
	public WebElement EditAssignLinkLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[11]/form/input[7]"));
	}
	
	
	/********* Incoming fax First and Latest row page objects ********/
	
	
	
	public String IncomingTypeValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[1]")).getText();
	}
	
	public String IncomingIDValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[2]")).getText();
	}
	
	public WebElement IncomingFileFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[3]"));
	}
	
	public String IncomingFileValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[3]")).getText();
	}
	
	public String IncomingTimeValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String IncomingStatusValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[5]")).getText();
	}
	
	public String IncomingOutANIValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[6]")).getText();
	}
	
	public String IncomingAmountValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[7]")).getText();
	}
	
	public WebElement IncomingActionViewLinkFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[1]/td[8]/a"));
	}
	
	public String IncomingTypeValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[1]")).getText();
	}
	
	public String IncomingIDValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[2]")).getText();
	}
	
	public WebElement IncomingFileLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[3]"));
	}
	
	public String IncomingTimeValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String IncomingStatusValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[5]")).getText();
	}
	
	public String IncomingOutANIValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[6]")).getText();
	}
	
	public String IncomingAmountValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[7]")).getText();
	}
	
	public WebElement IncomingActionViewLinkLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[1]/td[8]/a"));
	}



	/********* Outgoing fax First and Latest row page objects ********/
	
	public String OutgoingTypeValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String OutgoingIDValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public WebElement OutgoingFileFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[3]"));
	}
	
	public String OutgoingTimeValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[4]/table/tbody/tr[2]/td[4]")).getText();
	}
	
	public String OutgoingStatusValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[5]")).getText();
	}
	
	public String OutgoingANIOutANIFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[4]/table/tbody/tr[2]/td[6]")).getText();
	}
	
	public String OutgoingAmountValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[7]")).getText();
	}
	
	public String OutgoingFaxTextBoxValueFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[4]/table/tbody/tr[2]/td[8]/div/input[1][@name='destination']")).getAttribute("value");
	}
	
	public WebElement OutgoingFaxActionViewLinkFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]/table/tbody/tr[2]/td[8]/a"));
	}
	
	public String OutgoingTypeValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String OutgoingIDValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public WebElement OutgoingFileLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[3]"));
	}
	
	public String OutgoingTimeValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[4]")).getText();
	}
	
	public String OutgoingStatusValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[5]")).getText();
	}
	
	public String OutgoingANIOutANILatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[6]")).getText();
	}
	
	public String OutgoingAmountValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[7]")).getText();
	}
	
	public String OutgoingFaxTextBoxValueLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[8]/div/input[1][@name='destination']")).getAttribute("value");
	}
	
	public WebElement OutgoingFaxActionViewLinkLatestRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+FaxInfoGridRows().size()+"]/td[4]/table/tbody/tr[2]/td[8]/a"));
	}
	
	
}
