package com.juno.qa.pages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_HelpDeskNotesTabPage extends TestBase {
	AdminPortal_PG_BO_ProvidersTabPage apbo = new AdminPortal_PG_BO_ProvidersTabPage();
	
	public AdminPortal_Patients_HelpDeskNotesTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement HelpDeskNotesTab()
	{
		return driver.findElement(By.linkText("HelpDesk Notes"));
	}
	public WebElement HelpDeskNotesHeader()
	{
		return driver.findElement(By.xpath("//*[@id='tab_10']/div/table/thead/tr/td/font/strong"));
	}
	
	public Select CallerDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_origination")));
		return callerList;
	}
	
	public Select ReasonDropdown()
	{
		Select callerList = new Select(driver.findElement(By.id("notes_reason")));
		return callerList;
	}
	
	public WebElement CallerDropdownList()
	{
		return driver.findElement(By.name("notes_origination"));
	}
	
	public WebElement ReasonDropdownList()
	{
		return driver.findElement(By.name("notes_reason"));
	}
	
	public List<WebElement> callerDropwdownValues()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div/form/fieldset/table/tbody/tr[2]/td[2]/select[@id='notes_origination']/option"));
	}
	
	public WebElement CallerDropwdownValueNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div/form/fieldset/table/tbody/tr[2]/td[2]/select[@id='notes_origination']/option["+i+"]"));
	}
	
	public List<WebElement> reasonDropwdownValues()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div/form/fieldset/table/tbody/tr[3]/td[2]/select[@id='notes_reason']/option"));
	}
	
	public WebElement ReasonDropwdownValues(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div/form/fieldset/table/tbody/tr[3]/td[2]/select[@id='notes_reason']/option["+i+"]"));
	}
	
	public WebElement NotesTextArea()
	{
		return driver.findElement(By.id("notes_text"));
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.id("adding_notes"));
	}
	
	public WebElement NotesAddedConfirmationMessage()
	{
		return driver.findElement(By.xpath("//*[@id='replaceErr']/font"));
	}
	
	public WebElement NotesTableHeaderColumns()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/thead/tr"));
	}
	
	public WebElement NotesTableHeaderColumnNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/thead/tr/th["+i+"]"));
	}
	
	public int NotesTableHeaderColumnsCount()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/thead/tr/th")).size();
	}
	
	public List<WebElement> GetNotesTableRows()
	{
		return driver.findElements(By.xpath("//table[@id='notes-list']//tbody/tr"));
	}
	/* The following locators will help identify rows and col values of the latest row */
	public WebElement GetLatestRowColumns()
	{
		return driver.findElement(By.xpath("//table[@id='notes-list']//tbody/tr[" + GetNotesTableRows().size() + "]//td"));
	}
	
	public String getLatestRowEnrollmentsColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[1]")).getText();
	}
	
	public String getLatestRowNotesColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[2]/textarea")).getText();
	}
	
	public String getLatestRowCardLoadColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[3]")).getText();
	}
	
	public String getLatestRowOriginatedFromColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[4]")).getText();
	}
	
	public String getLatestRowCreatedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[5]")).getText();
	}
	
	public String getLatestRowCreatedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[6]")).getText();
	}
	
	public String getLatestRowModifiedByColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[7]")).getText();
	}
	
	public String getLatestRowModifiedDateColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_10']/div[2]/table[@id = 'sortTable']/tbody/tr["+GetNotesTableRows().size()+"]/td[8]")).getText();
	}
	
	public WebElement getLatestRowActionsColmunValue()
	{
		return driver.findElement(By.xpath("//table[@id='notes-list']//tbody/tr[" + GetNotesTableRows().size() + "]//td"));
	}
	
	public int getNotesTableRowsCount()
	{
		int rowCount = GetNotesTableRows().size();
		return rowCount;
	}
	
	public int getNotesTableRowsCountByMsg()
	{
		apbo.ClickArrowDownToDisplayTable("shownotesrow");
		String totalCount = driver.findElement(By.className("dataTables_info")).getText().split(" ")[5];
		return Integer.valueOf(totalCount);
	}
	
	public WebElement EditLink()
	{
		return driver.findElement(By.name("edit_helpdesk_notes"));
	}
	
	public WebElement UpdateButton()
	{
		return driver.findElement(By.className("button_update"));
	}
	
	public void AddNotesInHelpDesk(List<String> testData) throws InterruptedException
	{
		 
		//before you add notes verify whats the row count is for the notes table
		int beforeCount = getNotesTableRowsCount();
		System.out.println("before adding count: "+beforeCount);
		CallerDropdown().selectByVisibleText(testData.get(2));
		ReasonDropdown().selectByVisibleText(testData.get(3));
		
		NotesTextArea().sendKeys(testData.get(4));
		Thread.sleep(1000);
		AddButton().click();
		driver.findElement(By.xpath("//*[text()='Notes Added']")).isDisplayed();
		//First make sure that the rows count has been increased by 1
		int afterCount = getNotesTableRowsCount();
	/*	System.out.println("after adding count: "+afterCount);
		System.out.println("getLatestRowEnrollmentsColmunValue: "+anp.getLatestRowEnrollmentsColmunValue());
		System.out.println("getLatestRowNotesColmunValue: "+anp.getLatestRowNotesColmunValue());
		System.out.println("getLatestRowOriginatedFromColmunValue: "+anp.getLatestRowOriginatedFromColmunValue());
		System.out.println("getLatestRowCreatedByColmunValue: "+anp.getLatestRowCreatedByColmunValue());
		System.out.println("getLatestRowCreatedDateColmunValue: "+anp.getLatestRowCreatedDateColmunValue());
		System.out.println("getLatestRowModifiedByColmunValue: "+anp.getLatestRowModifiedByColmunValue());
		System.out.println("getLatestRowModifiedDateColmunValue: "+anp.getLatestRowModifiedDateColmunValue());
		System.out.println("today's date: "+currentDate); */
		
		
		
		if(afterCount == (beforeCount+1))
		{
			System.out.println("Notes has been added scucesfully");
			//Now verify the added notes in the table
			Assert.assertTrue(GetLatestRowColumns().isDisplayed());//Verify a row is getting displayed
			
			
		}
		
	}
	
	public void UpdateNotesInHelpDesk(List<String> testData) throws InterruptedException
	{
		 
		//before you add notes verify whats the row count is for the notes table
		int beforeCount = getNotesTableRowsCountByMsg();
		System.out.println("before adding count: "+beforeCount);
		CallerDropdown().selectByVisibleText(testData.get(1));
		ReasonDropdown().selectByVisibleText(testData.get(2));
		
		NotesTextArea().sendKeys(testData.get(3));
		Thread.sleep(1000);
		AddButton().click();
		Thread.sleep(2000);
		
		
		//First make sure that the rows count has been increased by 1
		int afterCount = getNotesTableRowsCountByMsg();
	/*	System.out.println("after adding count: "+afterCount);
		System.out.println("getLatestRowEnrollmentsColmunValue: "+anp.getLatestRowEnrollmentsColmunValue());
		System.out.println("getLatestRowNotesColmunValue: "+anp.getLatestRowNotesColmunValue());
		System.out.println("getLatestRowOriginatedFromColmunValue: "+anp.getLatestRowOriginatedFromColmunValue());
		System.out.println("getLatestRowCreatedByColmunValue: "+anp.getLatestRowCreatedByColmunValue());
		System.out.println("getLatestRowCreatedDateColmunValue: "+anp.getLatestRowCreatedDateColmunValue());
		System.out.println("getLatestRowModifiedByColmunValue: "+anp.getLatestRowModifiedByColmunValue());
		System.out.println("getLatestRowModifiedDateColmunValue: "+anp.getLatestRowModifiedDateColmunValue());
		System.out.println("today's date: "+currentDate); */
		
		Assert.assertTrue(afterCount == (beforeCount + 1));
		
	}
	
	public boolean AddNotesAgainAndVerify(List<String> testData) throws InterruptedException
	{
		boolean verify =  true;
		if(verify)
		{
			int beforeCount = getNotesTableRowsCount();
			System.out.println("before adding count: "+beforeCount);
			CallerDropdown().selectByVisibleText(testData.get(1));
			ReasonDropdown().selectByVisibleText(testData.get(2));
			
			NotesTextArea().sendKeys(testData.get(3));
			Thread.sleep(1000);
			AddButton().click();
			
			Assert.assertEquals(NotesAddedConfirmationMessage().getText(), testData.get(16));
			//First make sure that the rows count has been increased by 1
			int afterCount = getNotesTableRowsCount();
			
			if(afterCount == (beforeCount+1))
			{
				System.out.println("Additional notes has been added scucesfully");
			}
			
			return verify;
		}
		
		verify = false;
		return verify;
		
	}
	
	

}
