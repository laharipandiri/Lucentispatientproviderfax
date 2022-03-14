package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_NotesTabPage extends TestBase {
	
	public AdminPortal_PG_BO_NotesTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement NotesTab()
	{
		return driver.findElement(By.linkText("Notes"));
	}
	
	public WebElement PaymentsTab()
	{
		return driver.findElement(By.xpath("//*[@id='provider_providers_list']//*[text()='Payments']"));
	}
	
	public WebElement GetTabElement(String tabName)
	{
		return driver.findElement(By.xpath("//a[contains(@href,'tabprovider') and text()='" + tabName + "']"));
	}
	
	public WebElement PGBONotesRequiredFieldMsg()
	{
		return driver.findElement(By.xpath("//*[@id='replaceErr']/font"));
	}
	
	public WebElement PGBONotesAddButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_add']"));
	}
	
	public WebElement PGBONotesUpdateButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_update']"));
	}
	
	public Select PGBONotesCallerDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_origination")));
		return callerList;
	}
	
	public Select PGBONotesReasonDropdown()
	{
		Select reasonList = new Select(driver.findElement(By.id("notes_reason")));
		return reasonList;
	}
	
	public WebElement PGBONotesTextArea()
	{
		return driver.findElement(By.id("notes_text"));
	}
	
	public int PGBONotesTableHeaderColumnsCount()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th")).size();
	}
	
	public WebElement PGBONotesTableColumnNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> PGBOGetNotesTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr"));
	}
	
	public int PGBOGetNotesTableRowsCount()
	{
		int rowCount = PGBOGetNotesTableRows().size();
		return rowCount;
	}
	
	public WebElement PGBONotesAddedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	public WebElement PGBONotesUpdatedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	/* The following locators will help identify rows and col values of the latest row */
	public WebElement PGBOGetLatestRowColumns()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td"));
	}
	
	public String getPGBOLatestRowReasonColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[1]")).getText();
	}
	
	public String getPGBOLatestRowNotesColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[2]/textarea")).getText();
	}
	
	public String getPGBOLatestRowCardLoadColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[3]")).getText();
	}
	
	public String getPGBOLatestRowOriginatedFromColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[4]")).getText();
	}
	
	public String getPGBOLatestRowCreatedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[5]")).getText();
	}
	
	public String getPGBOLatestRowCreatedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[6]")).getText();
	}
	
	public String getPGBOLatestRowModifiedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[7]")).getText();
	}
	
	public String getPGBOLatestRowModifiedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[8]")).getText();
	}
	
	public WebElement getPGBOLatestRowActionsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGBOGetNotesTableRowsCount()+"]/td[9]/form/input[@name='edit_provider_notes']"));
	}
	
	
	
	public boolean PGBOAddNotesInNotesTab(List<String> testData) throws InterruptedException
	{
		//before you add notes verify whats the row count is for the notes table
				int beforeCount = PGBOGetNotesTableRowsCount();
				System.out.println("before adding count: "+beforeCount);
				PGBONotesCallerDropdown().selectByVisibleText(testData.get(4));
				PGBONotesReasonDropdown().selectByVisibleText(testData.get(5));
				
				PGBONotesTextArea().sendKeys(testData.get(6));
				Thread.sleep(1000);
				PGBONotesAddButton().click();
				
				//First make sure that the rows count has been increased by 1
				int afterCount = PGBOGetNotesTableRowsCount();
				System.out.println("after adding count: "+afterCount);
				System.out.println("getLatestRowEnrollmentsColmunValue: "+getPGBOLatestRowReasonColmunValue());
				System.out.println("getLatestRowNotesColmunValue: "+getPGBOLatestRowNotesColmunValue());
				System.out.println("getLatestRowOriginatedFromColmunValue: "+getPGBOLatestRowOriginatedFromColmunValue());
				System.out.println("getLatestRowCreatedByColmunValue: "+getPGBOLatestRowCreatedByColmunValue());
				System.out.println("getLatestRowCreatedDateColmunValue: "+getPGBOLatestRowCreatedDateColmunValue());
				System.out.println("getLatestRowModifiedByColmunValue: "+getPGBOLatestRowModifiedByColmunValue());
				System.out.println("getLatestRowModifiedDateColmunValue: "+getPGBOLatestRowModifiedDateColmunValue());
			//	System.out.println("today's date: "+currentDate);  
				
				
				
				if(afterCount == (beforeCount+1))
				{
					System.out.println("Notes has been added scucesfully");
					//Now verify the added notes in the table
					Assert.assertTrue(PGBOGetLatestRowColumns().isDisplayed());//Verify a row is getting displayed
					
					return true;
					
					
				}
				
				return false;
	}

}
