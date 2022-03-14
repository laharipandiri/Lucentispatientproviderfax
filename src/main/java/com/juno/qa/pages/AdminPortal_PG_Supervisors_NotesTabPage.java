package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_Supervisors_NotesTabPage extends TestBase {
	
	public AdminPortal_PG_Supervisors_NotesTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement NotesTab()
	{
		return driver.findElement(By.linkText("Notes"));
	}
	
	public WebElement PGSupervisorsNotesRequiredFieldMsg()
	{
		return driver.findElement(By.xpath("//*[@id='replaceErr']/font"));
	}
	
	public WebElement PGSupervisorsNotesAddButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_add']"));
	}
	
	public WebElement PGSupervisorsNotesUpdateButton()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[4]/td/input[@class='button_update']"));
	}
	
	public Select PGSupervisorsNotesCallerDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_origination")));
		return callerList;
	}
	
	public Select PGSupervisorsNotesReasonDropdown()
	{
		Select reasonList = new Select(driver.findElement(By.id("notes_reason")));
		return reasonList;
	}
	
	public WebElement PGSupervisorsNotesTextArea()
	{
		return driver.findElement(By.id("notes_text"));
	}
	
	public int PGSupervisorsNotesTableHeaderColumnsCount()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th")).size();
	}
	
	public WebElement PGSupervisorsNotesTableHeaderColumnNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> PGSupervisorsGetNotesTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr"));
	}
	
	public int PGSupervisorsGetNotesTableRowsCount()
	{
		int rowCount = PGSupervisorsGetNotesTableRows().size();
		return rowCount;
	}
	
	public WebElement PGSupervisorsNotesAddedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	public WebElement PGSupervisorsNotesUpdatedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div/form/fieldset/table/tbody/tr[5]/td[@id='replaceErr']/font[@color='blue']"));
	}
	
	/* The following locators will help identify rows and col values of the latest row */
	public WebElement PGSupervisorsGetLatestRowColumns()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td"));
	}
	
	public String getPGSupervisorsLatestRowReasonColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[1]")).getText();
	}
	
	public String getPGSupervisorsLatestRowNotesColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[2]/textarea")).getText();
	}
	
	public String getPGSupervisorsLatestRowCardLoadColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[3]")).getText();
	}
	
	public String getPGSupervisorsLatestRowOriginatedFromColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[4]")).getText();
	}
	
	public String getPGSupervisorsLatestRowCreatedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[5]")).getText();
	}
	
	public String getPGSupervisorsLatestRowCreatedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[6]")).getText();
	}
	
	public String getPGSupervisorsLatestRowModifiedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[7]")).getText();
	}
	
	public String getPGSupervisorsLatestRowModifiedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[8]")).getText();
	}
	
	public WebElement getPGSupervisorsLatestRowActionsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tabprovider_8']/div[2]/table/tbody/tr["+PGSupervisorsGetNotesTableRowsCount()+"]/td[9]/form/input[@name='edit_provider_notes']"));
	}
	
	
	
	public boolean PGSupervisorsAddNotesInNotesTab(List<String> testData) throws InterruptedException
	{
		//before you add notes verify whats the row count is for the notes table
				int beforeCount = PGSupervisorsGetNotesTableRowsCount();
				System.out.println("before adding count: "+beforeCount);
				PGSupervisorsNotesCallerDropdown().selectByVisibleText(testData.get(4));
				PGSupervisorsNotesReasonDropdown().selectByVisibleText(testData.get(5));
				
				PGSupervisorsNotesTextArea().sendKeys(testData.get(6));
				Thread.sleep(1000);
				PGSupervisorsNotesAddButton().click();
				
				//First make sure that the rows count has been increased by 1
				int afterCount = PGSupervisorsGetNotesTableRowsCount();
				System.out.println("after adding count: "+afterCount);
				System.out.println("getLatestRowEnrollmentsColmunValue: "+getPGSupervisorsLatestRowReasonColmunValue());
				System.out.println("getLatestRowNotesColmunValue: "+getPGSupervisorsLatestRowNotesColmunValue());
				System.out.println("getLatestRowOriginatedFromColmunValue: "+getPGSupervisorsLatestRowOriginatedFromColmunValue());
				System.out.println("getLatestRowCreatedByColmunValue: "+getPGSupervisorsLatestRowCreatedByColmunValue());
				System.out.println("getLatestRowCreatedDateColmunValue: "+getPGSupervisorsLatestRowCreatedDateColmunValue());
				System.out.println("getLatestRowModifiedByColmunValue: "+getPGSupervisorsLatestRowModifiedByColmunValue());
				System.out.println("getLatestRowModifiedDateColmunValue: "+getPGSupervisorsLatestRowModifiedDateColmunValue());
			//	System.out.println("today's date: "+currentDate);  
				
				
				
				if(afterCount == (beforeCount+1))
				{
					System.out.println("Notes has been added scucesfully");
					//Now verify the added notes in the table
					Assert.assertTrue(PGSupervisorsGetLatestRowColumns().isDisplayed());//Verify a row is getting displayed
					
					return true;
					
					
				}
				
				return false;
	}


}
