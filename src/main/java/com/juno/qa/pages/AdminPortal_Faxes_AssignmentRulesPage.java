package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Faxes_AssignmentRulesPage extends TestBase {
	
	public AdminPortal_Faxes_AssignmentRulesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select UserDropdown()
	{
		Select usersList = new Select(driver.findElement(By.id("user_id")));
		return usersList;
	}
	
	public WebElement StartTime()
	{
		return driver.findElement(By.name("add_start_time"));
	}
	
	public WebElement EndTime()
	{
		return driver.findElement(By.name("add_end_time"));
	}
	
	public WebElement DailyMax()
	{
		return driver.findElement(By.name("add_daily_max"));
	}
	
	public WebElement CatchOutsideHours()
	{
		return driver.findElement(By.name("add_catch_outside_hours"));
	}
	
	public WebElement AddButton()
	{
		//return driver.findElement(By.className("button_add"));
		return driver.findElement(By.className("btn_update"));
		
	}
	
	public WebElement RemoveLinkInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[9][@id='Remove']"));
	}
	
	public WebElement UpdateLinkInGrid()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr[3]/td/form/input[8][@id='Update']"));
	}
	
	public WebElement UpdateConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td/font"));
	}
	
	public WebElement AddConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div/form/div/table/tbody/tr[5]/td/font"));
	}
	
	public String UsernameLabelInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/strong")).getText();
	}
	
	public String StartTimeValueInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[1][@id='start_time']")).getAttribute("value");
	}
	
	public String EndTimeValueInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[2][@id='end_time']")).getAttribute("value");
	}
	
	public String CatchOutsideHoursValueInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[3][@id='catch_outside_hours']")).getAttribute("value");
	}
	
	public String DailyMaxValueInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[4][@id='daily_max']")).getAttribute("value");
	}

	
	public Select StatusDropdownValueInGrid(int i)
	{
		//Select status = new Select(driver.findElement(By.name("fax_assignment_rule_status")));
		Select status = new Select(driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/select[@name='fax_assignment_rule_status']")));
		
		return status;
		
	}
	
	public WebElement StartTimeInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[1][@id='start_time']"));
	}
	
	public WebElement EndTimeInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[2][@id='end_time']"));
	}
	
	public WebElement CatchOutsideHoursInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[3][@id='catch_outside_hours']"));
	}
	
	public WebElement DailyMaxInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form/input[4][@id='daily_max']"));
	}
	
	public String LabelsInGrid(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr["+i+"]/td/form")).getText();
	}
	
	public WebElement FieldValidationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div/form/div/table/tbody/tr[5]/td/font"));
	}
	
	public String TotalCountLabelAndValue()
	{
		//return driver.findElement(By.xpath("//*[@id='form-table']/div/div[1]/table/tbody/tr/td[2]")).getText();
		return driver.findElement(By.xpath("//*[@id='form-table']/div/div[1]/table/tbody/tr/td[2]")).getText();
	}
	
	public List<WebElement> AssignmentRulesGridRows()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div[@id='form-table']/div/div[2][@class='table_head']/table[@id='reportTable']/tbody[1]/tr"));
	}
	

	public boolean VerifyAbilityToAddNewAssignmentRules_N(List<String> testData) 
	{
		boolean verify = true;
		if(verify)
		{
			UserDropdown().selectByVisibleText(testData.get(0));
			StartTime().click();
			StartTime().sendKeys(testData.get(1));
			EndTime().click();
			EndTime().sendKeys(testData.get(2));
			DailyMax().clear();
			DailyMax().sendKeys(testData.get(3));
			CatchOutsideHours().clear();
			CatchOutsideHours().sendKeys(testData.get(4));
			
			AddButton().click();
			
			Assert.assertTrue(AddConfirmationMsg().getText().contains(testData.get(5)));
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyAbilityToAddNewAssignmentRules_Y(List<String> testData) 
	{
		boolean verify = true;
		if(verify)
		{
			UserDropdown().selectByVisibleText(testData.get(0));
			DailyMax().clear();
			DailyMax().sendKeys(testData.get(1));
			CatchOutsideHours().clear();
			CatchOutsideHours().sendKeys(testData.get(2));
			
			AddButton().click();
			
			Assert.assertTrue(AddConfirmationMsg().getText().contains(testData.get(3)));
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursN(List<String> updateData) 
	{
		boolean verify = true;
		if(verify)
		{
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(updateData.get(0)))
				{
			
					StartTimeInGrid(i).clear();
					StartTimeInGrid(i).sendKeys(updateData.get(0));
					EndTimeInGrid(i).clear();
					EndTimeInGrid(i).sendKeys(updateData.get(1));
					DailyMaxInGrid(i).clear();
					DailyMaxInGrid(i).sendKeys(updateData.get(2));
			
			
					UpdateLinkInGrid().click();
			
					Assert.assertTrue(UpdateConfirmationMsg().getText().contains(updateData.get(3)));
					
					break;
				}
			}
			
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursY(List<String> updateData) 
	{
		boolean verify = true;
		if(verify)
		{
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(updateData.get(0)))
				{
					StartTimeInGrid(i).clear();
					EndTimeInGrid(i).clear();
					CatchOutsideHoursInGrid(i).clear();
					CatchOutsideHoursInGrid(i).sendKeys(updateData.get(6));
					DailyMaxInGrid(i).clear();
					DailyMaxInGrid(i).sendKeys(updateData.get(2));
					
					
					UpdateLinkInGrid().click();
					
					Assert.assertTrue(UpdateConfirmationMsg().getText().contains(updateData.get(3)));
					
					break;
				}
			}
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyAbilityToUpdateAssignmentRulesWithCatchOutsideHoursYToN(List<String> updateData) 
	{
		boolean verify = true;
		if(verify)
		{
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(updateData.get(0)))
				{
					StartTimeInGrid(i).clear();
					StartTimeInGrid(i).sendKeys(updateData.get(0));
					EndTimeInGrid(i).clear();
					EndTimeInGrid(i).sendKeys(updateData.get(1));
					DailyMaxInGrid(i).clear();
					DailyMaxInGrid(i).sendKeys(updateData.get(2));
					CatchOutsideHoursInGrid(i).clear();
					CatchOutsideHoursInGrid(i).sendKeys(updateData.get(5));
					
					UpdateLinkInGrid().click();
					Assert.assertTrue(UpdateConfirmationMsg().getText().contains(updateData.get(3)));
					
					break;
				}
			}
			return verify;
		}
		
		verify = false;
		return verify;
	}
	
	public boolean VerifyNewlyCreatedRules_N(List<String> testData, List<String> gridLabels)
	{
		boolean verify =true;
		if(verify)
		{
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(testData.get(0)))
				{
					String[] firstThreeLabels = LabelsInGrid(i).split(": ");
					String[] twoRemLabels = firstThreeLabels[3].split("\n");
					
				//	Assert.assertEquals(UsernameLabelInGrid_FirstRow(), testData.get(0));
					Assert.assertEquals(firstThreeLabels[0], gridLabels.get(0));
					Assert.assertEquals(firstThreeLabels[1], gridLabels.get(1));
					Assert.assertEquals(firstThreeLabels[2], gridLabels.get(2));
					Assert.assertEquals(twoRemLabels[0], gridLabels.get(3));
					Assert.assertEquals(twoRemLabels[1], gridLabels.get(4)); 
					
					Assert.assertEquals(StartTimeValueInGrid(i), testData.get(1));//StartTimeValueInGrid
					Assert.assertEquals(EndTimeValueInGrid(i), testData.get(2));//EndTimeValueInGrid
					Assert.assertEquals(CatchOutsideHoursValueInGrid(i), testData.get(4));//CatchOutsideHoursValueInGrid
					Assert.assertEquals(DailyMaxValueInGrid(i), testData.get(3));//DailyMaxValueInGrid
					Assert.assertEquals(StatusDropdownValueInGrid(i).getFirstSelectedOption().getText(), testData.get(6));//StatusDropdownValueInGrid_FirstRow()
					
					break;
					
				}
			}
			
			return verify;
		}
		
		verify=false;
		return verify;
	}
	
	public boolean VerifyNewlyCreatedRules_Y(List<String> testData, List<String> gridLabels)
	{
		boolean verify =true;
		if(verify)
		{
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(testData.get(0)))
				{
					String[] firstThreeLabels = LabelsInGrid(i).split(": ");
					String[] twoRemLabels = firstThreeLabels[3].split("\n");
			
					Assert.assertEquals(UsernameLabelInGrid(i), testData.get(0));
					Assert.assertEquals(firstThreeLabels[0], gridLabels.get(0));
					Assert.assertEquals(firstThreeLabels[1], gridLabels.get(1));
					Assert.assertEquals(firstThreeLabels[2], gridLabels.get(2));
					Assert.assertEquals(twoRemLabels[0], gridLabels.get(3));
					Assert.assertEquals(twoRemLabels[1], gridLabels.get(4)); 
					
					
					Assert.assertTrue(StartTimeValueInGrid(i).isEmpty());
					Assert.assertTrue(EndTimeValueInGrid(i).isEmpty());
					Assert.assertEquals(CatchOutsideHoursValueInGrid(i), testData.get(2));
					Assert.assertEquals(DailyMaxValueInGrid(i), testData.get(1));
					Assert.assertEquals(StatusDropdownValueInGrid(i).getFirstSelectedOption().getText(), testData.get(4));
					
					break;
				}
			}
			
			return verify;
		}
		
		verify=false;
		return verify;
	}
	
	public boolean VerifyRemoveLink(String confirmationMsg, String username)
	{
		boolean verify = true;
		if(verify)
		{
			String[] totalBeforeCount = TotalCountLabelAndValue().split(": ");
			int beforeCount = Integer.parseInt(totalBeforeCount[1]);
			for(int i=2; i<=AssignmentRulesGridRows().size(); i++)//we starting the loop from #2 because the first row has no data
			{
				if(UsernameLabelInGrid(i).equalsIgnoreCase(username))
				{
					RemoveLinkInGrid(i).click();
					Assert.assertTrue(UpdateConfirmationMsg().getText().contains(confirmationMsg));
					
					break;
				}
			}
			
			String[] totalAfterCount = TotalCountLabelAndValue().split(": ");
			int afterCount = Integer.parseInt(totalAfterCount[1]);
			
		//	Assert.assertTrue(beforeCount==afterCount+1);
			
			return verify;
		}
		
		verify=false;
		return verify;
		
	}
}
