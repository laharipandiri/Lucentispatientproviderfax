package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Providers_NotesTabPage extends TestBase {
	
	public AdminPortal_Providers_NotesTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int ProviderNotesTableHeaderColumnsCount()
	{
		return driver.findElements(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/thead/tr/th")).size();
	}
	
	public WebElement ProviderNotesTableHeaderColumnNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public WebElement ProviderNotesAddButton()
	{
		return driver.findElement(By.className("button_add"));
	}
	
	public List<WebElement> ProviderGetNotesTableRows()
	{
		return driver.findElements(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr"));
	}
	
	public int ProviderGetNotesTableRowsCount()
	{
		int rowCount = ProviderGetNotesTableRows().size();
		return rowCount;
	}
	
	public Select ProviderNotesCallerDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_origination")));
		return callerList;
	}
	
	public Select ProviderNotesReasonDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_reason")));
		return callerList;
	}
	
	public WebElement ProviderNotesTextArea()
	{
		return driver.findElement(By.id("notes_text"));
	}
	
	public WebElement ProviderNotesAddedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='replaceErr']/font"));
	}
	
	/* The following locators will help identify rows and col values of the latest row */
	public WebElement GetLatestRowColumns()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td"));
	}
	
	public String getLatestRowEnrollmentsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[1]")).getText();
	}
	
	public String getLatestRowNotesColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[2]/textarea")).getText();
	}
	
	public String getLatestRowCardLoadColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[3]")).getText();
	}
	
	public String getLatestRowOriginatedFromColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[4]")).getText();
	}
	
	public String getLatestRowCreatedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[5]")).getText();
	}
	
	public String getLatestRowCreatedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[6]")).getText();
	}
	
	public String getLatestRowModifiedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[7]")).getText();
	}
	
	public String getLatestRowModifiedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[8]")).getText();
	}
	
	public WebElement getLatestRowActionsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id= 'tabs_content_container']/div[5]/div[2]/table/tbody/tr["+ProviderGetNotesTableRows().size()+"]/td[9]/form/input[@name='edit_provider_notes']"));
	}
	
	public WebElement ProviderNotesUpdateButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[5]/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_update']"));
	}
	
	public void AddNotesInNotesTab(List<String> testData) throws InterruptedException
	{
		//before you add notes verify whats the row count is for the notes table
				int beforeCount = ProviderGetNotesTableRowsCount();
				System.out.println("before adding count: "+beforeCount);
				ProviderNotesCallerDropdown().selectByVisibleText(testData.get(1));
				ProviderNotesReasonDropdown().selectByVisibleText(testData.get(2));
				
				ProviderNotesTextArea().sendKeys(testData.get(3));
				Thread.sleep(1000);
				ProviderNotesAddButton().click();
				
				//First make sure that the rows count has been increased by 1
				int afterCount = ProviderGetNotesTableRowsCount();
			/*	System.out.println("after adding count: "+afterCount);
				System.out.println("getLatestRowEnrollmentsColmunValue: "+getLatestRowEnrollmentsColmunValue());
				System.out.println("getLatestRowNotesColmunValue: "+getLatestRowNotesColmunValue());
				System.out.println("getLatestRowOriginatedFromColmunValue: "+getLatestRowOriginatedFromColmunValue());
				System.out.println("getLatestRowCreatedByColmunValue: "+getLatestRowCreatedByColmunValue());
				System.out.println("getLatestRowCreatedDateColmunValue: "+getLatestRowCreatedDateColmunValue());
				System.out.println("getLatestRowModifiedByColmunValue: "+getLatestRowModifiedByColmunValue());
				System.out.println("getLatestRowModifiedDateColmunValue: "+getLatestRowModifiedDateColmunValue());
				System.out.println("today's date: "+currentDate);  */
				
				
				
				if(afterCount == (beforeCount+1))
				{
					System.out.println("Notes has been added scucesfully");
					//Now verify the added notes in the table
					Assert.assertTrue(GetLatestRowColumns().isDisplayed());//Verify a row is getting displayed
					
					
				}
	}
	
	
	
	
	
	
}
