package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_NotesTabPage extends TestBase {
	
	public AdminPortal_PG_GP_NotesTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PGGPNotesRequiredFieldMsg()
	{
		return driver.findElement(By.xpath("//*[@id='replaceErr']/font"));
	}
	
	public WebElement PGGPNotesAddButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_add']"));
	}
	
	public WebElement PGGPNotesUpdateButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_update']"));
	}
	
	public WebElement PGGPNotesTab()
	{
		return driver.findElement(By.linkText("Notes"));
	}
	
	public Select PGGPNotesCallerDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_origination")));
		return callerList;
	}
	
	public Select PGGPNotesReasonDropdown()
	{
		Select reasonList = new Select(driver.findElement(By.id("notes_reason")));
		return reasonList;
	}
	
	public WebElement PGGPNotesTextArea()
	{
		return driver.findElement(By.id("notes_text"));
	}
	
	public int PGGPNotesTableHeaderColumnsCount()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th")).size();
	}
	
	public List<WebElement> PGGPGetNotesTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr"));
	}
	
	public int PGGPGetNotesTableRowsCount()
	{
		int rowCount = PGGPGetNotesTableRows().size();
		return rowCount;
	}
	
	public WebElement PGGPNotesAddedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	public WebElement PGGPNotesUpdatedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	/* The following locators will help identify rows and col values of the latest row */
	public WebElement PGGPGetLatestRowColumns()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td"));
	}
	
	public String getPGGPLatestRowReasonColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[1]")).getText();
	}
	
	public String getPGGPLatestRowNotesColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[2]/textarea")).getText();
	}
	
	public String getPGGPLatestRowCardLoadColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[3]")).getText();
	}
	
	public String getPGGPLatestRowOriginatedFromColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[4]")).getText();
	}
	
	public String getPGGPLatestRowCreatedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[5]")).getText();
	}
	
	public String getPGGPLatestRowCreatedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[6]")).getText();
	}
	
	public String getPGGPLatestRowModifiedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[7]")).getText();
	}
	
	public String getPGGPLatestRowModifiedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[8]")).getText();
	}
	
	public WebElement getPGGPLatestRowActionsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGGPGetNotesTableRowsCount()+"]/td[9]/form/input[@name='edit_provider_notes']"));
	}
	
	
	
	public boolean PGGPAddNotesInNotesTab(List<String> testData) throws InterruptedException
	{
		//before you add notes verify whats the row count is for the notes table
				int beforeCount = PGGPGetNotesTableRowsCount();
				System.out.println("before adding count: "+beforeCount);
				PGGPNotesCallerDropdown().selectByVisibleText(testData.get(5));
				PGGPNotesReasonDropdown().selectByVisibleText(testData.get(6));
				
				PGGPNotesTextArea().sendKeys(testData.get(7));
				Thread.sleep(1000);
				PGGPNotesAddButton().click();
				
				//First make sure that the rows count has been increased by 1
				int afterCount = PGGPGetNotesTableRowsCount();
				System.out.println("after adding count: "+afterCount);
				System.out.println("getLatestRowEnrollmentsColmunValue: "+getPGGPLatestRowReasonColmunValue());
				System.out.println("getLatestRowNotesColmunValue: "+getPGGPLatestRowNotesColmunValue());
				System.out.println("getLatestRowOriginatedFromColmunValue: "+getPGGPLatestRowOriginatedFromColmunValue());
				System.out.println("getLatestRowCreatedByColmunValue: "+getPGGPLatestRowCreatedByColmunValue());
				System.out.println("getLatestRowCreatedDateColmunValue: "+getPGGPLatestRowCreatedDateColmunValue());
				System.out.println("getLatestRowModifiedByColmunValue: "+getPGGPLatestRowModifiedByColmunValue());
				System.out.println("getLatestRowModifiedDateColmunValue: "+getPGGPLatestRowModifiedDateColmunValue());
			//	System.out.println("today's date: "+currentDate);  
				
				
				
				if(afterCount == (beforeCount+1))
				{
					System.out.println("Notes has been added scucesfully");
					//Now verify the added notes in the table
					Assert.assertTrue(PGGPGetLatestRowColumns().isDisplayed());//Verify a row is getting displayed
					
					return true;
					
					
				}
				
				return false;
	}
	

}
