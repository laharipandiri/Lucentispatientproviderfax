package com.juno.qa.pages;


import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class AdminPortal_Faxes_AssignmentsPage extends TestBase {
	public static String FAXnum="";
	
	AdminPortal_Faxes_IncomingFindPage aff = new AdminPortal_Faxes_IncomingFindPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	AdminPortal_Patients_FindPage apf = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_FaxInfoTabPage afi = new AdminPortal_Patients_FaxInfoTabPage();
	CommonFunctions cf = new CommonFunctions();
	Xls_Reader reader = new Xls_Reader(TestUtil.TESTDATA_SHEET_PATH);
	
	public AdminPortal_Faxes_AssignmentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProgramDropdown()
	{
		Select program = new Select(driver.findElement(By.id("program")));
		return program;
	}
	
	public WebElement FromDateField()
	{
		return driver.findElement(By.name("request_date_from"));
	}
	
	public WebElement ToDateField()
	{
		return driver.findElement(By.name("request_date_to"));
	}
	
	public WebElement FindButton()
	{
		return driver.findElement(By.name("find"));
	}
	
	public WebElement ReassignFaxesFirstRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']//div/div[3]/table/tbody/tr/td[7]/div/table/thead/tr/td/font"));
	}
	
	public Select FromUserDropdown()
	{
		Select fromUsers = new Select(driver.findElement(By.xpath("(//select[contains(@id,'source_user')])[1]")));
		return fromUsers;
	}
	
	public Select ToUserDropdown()
	{
		Select fromUsers = new Select(driver.findElement(By.xpath("(//select[contains(@id,'target_user')])[1]")));
		return fromUsers;
	}
	
	public WebElement FaxCountField()
	{
		return driver.findElement(By.name("reassign_fax_count"));
	}
	
	public WebElement FaxIDListField()
	{
		return driver.findElement(By.name("reassign_fax_list"));
	}
	
	public WebElement ReassignLink()
	{
		return driver.findElement(By.name("ReplaceCard"));
	}
	
	public WebElement FaxCountWrongErrorMsg()
	{
		return driver.findElement(By.xpath("//*[@id='assignments']/div/table/tbody/tr[4]/td/font"));
	}
	
	public WebElement MarkOutFromDate()
	{
		return driver.findElement(By.name("skip_start"));
	}
	
	public WebElement MarkOutToDate()
	{
		return driver.findElement(By.name("skip_end"));
	}
	
	public WebElement MarkCancelOutLink()
	{
		return driver.findElement(By.name("Edit"));
	}
	
	public WebElement FromLabel()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[1]/td"));
	}
	
	public WebElement ToLabel()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[2]/td"));
	}
	
	public WebElement FaxCountLabel()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[3]/td"));
	}
	
	public WebElement FaxIDListLabel()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[4]/td"));
	}
	
	public List<WebElement> AssignmentsPageTableCols()
	{
		return driver.findElements(By.xpath("//table[@id='reportTable']/thead/tr/th"));
	}
	
	public WebElement AssignmentPageTableColNames(int i)
	{
		return driver.findElement(By.xpath("//table[@id='reportTable']/thead/tr/th["+i+"]"));
	}
	
	public WebElement NestedTableDataColNames(int i)
	{
		return driver.findElement(By.xpath("//table[@id='reportTable']/thead/tr/th[8]/table/tbody/tr["+i+"]/th["+i+"]"));
	}
	
	public WebElement SubNestedColNames(int i, int j)
	{
		return driver.findElement(By.xpath("//table[@id='reportTable']/thead/tr/th[8]/table/tbody/tr["+i+"]/th["+j+"]"));
	}
	
	public WebElement FaxReassignLabel()
	{
		return driver.findElement(By.xpath("//div[@id='form-table']/div[3]/table/tbody/tr/td[7]/div/table/tbody/tr/td/form/fieldset/legend/strong"));
	}
	
	public List<WebElement> NestedTableDataCols()
	{
		return driver.findElements(By.xpath("//table[@id='reportTable']/thead/tr/th[8]/table/tbody/tr"));
	}
	
	public List<WebElement> SubNestedCols()
	{
		return driver.findElements(By.xpath("//table[@id='reportTable']/thead/tr/th[8]/table/tbody/tr[2]/th"));
	}
	
	public List<WebElement> AssignmentsPageTableRows()
	{
		return driver.findElements(By.xpath("//table[@id='reportTable']/tbody/tr"));
	}
	
	public List<WebElement> AssignmentsPageTableRowsFirstColumns()
	{
		return driver.findElements(By.xpath("//table[@id='reportTable']/tbody/tr/td[1]"));
	}
	
	public WebElement FaxAssignmentsLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b"));
	}
	
	public WebElement TotalCountLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]"));
	}
	
	public WebElement ReassignFaxesLink(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[7]/div/table/thead/tr/td/font"));
	}
	
	public String UserAssignedColValue(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[1]")).getText();
	}
	
	public String FaxesAssignedColValue(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public Select ToUserDropdown(int i)
	{
		System.out.println("=====>(//*[@id='reportTable']/tbody/tr)["+i+"]/td[7]//table//*[contains(@id,'source_user')]");
		Select toUser = new Select(driver.findElement(By.xpath("(//*[@id='reportTable']/tbody/tr)["+i+"]/td[7]//table//*[contains(@id,'target_user')]")));
		return toUser;
	}
	
	public WebElement FaxListID(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[4]/td[2]/input"));
	}
	
	public WebElement ReassignLink(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[7]/div/table/tbody/tr/td/form/fieldset/table/tbody/tr[5]/td/input[@name='ReplaceCard']"));
	}
	
	public WebElement AssignedUser(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr["+i+"]/td[1]"));
	}
	
	public WebElement FaxesAssignedConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='assignments']/div/table/tbody/tr[4]/td/font"));
	}
	
	public int GetUserRowNum(String username)
	{
		System.out.println(AssignmentsPageTableRows().size());
		for(int i=1;i<=AssignmentsPageTableRows().size();i++)
		{
			if(AssignedUser(i).getText().equalsIgnoreCase(username))
			{
				return i;
			}
		}
		return 0;
	}
	
	public boolean VerifyAbilityToReassignFax(List<String> testData, int i, int j, int rowNum) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			System.out.println("Faxes assigned col value for i: "+FaxesAssignedColValue(i));
			System.out.println("Faxes assigned col value for j: "+FaxesAssignedColValue(j));
			//get before count of From User
			int beforeCountOfFromUserAssignedFaxes = Integer.parseInt(FaxesAssignedColValue(i));//get before count of faxes assigned to Erin Stevens
			//get before count of To User
			int beforeCountOfToUserAssignedFaxes = Integer.parseInt(FaxesAssignedColValue(j));//get before count of faxes assigned to Kevin Josh 
			
			
			ReassignFaxesLink(i).click();//click on re-assign faxes related to the User Erin Stevens
			//click on the To user dropdown and select the value Kevin Josh 
			ToUserDropdown(i).selectByVisibleText(testData.get(4));
			//now specify value for faxlist id
			//FaxListID(i).sendKeys(testData.get(0));
			Thread.sleep(2000);
			//now click on re-assign link
			ReassignLink(i).click();
			Thread.sleep(3000);
			//Assert.assertEquals(FaxesAssignedConfirmationMsg().getText(), testData.get(6));
			
			
			int afterCountOfFromUserAssignedFaxes = Integer.parseInt(FaxesAssignedColValue(i));//get the faxes assigned after count of Diana Jack
		//	Assert.assertTrue(afterCountOfFromUserAssignedFaxes == beforeCountOfFromUserAssignedFaxes-1);//we are verifying that the col value count for the pre-requiresite test data has decremented
			
			//now verify the col value count for the To User has incremented by one.
			int afterCountOfToUserAssignedFaxes = Integer.parseInt(FaxesAssignedColValue(j));//get the faxes assigned after count of Christina John
		//	Assert.assertTrue(afterCountOfToUserAssignedFaxes == beforeCountOfToUserAssignedFaxes+1);//we are verifying that the col value count for the To User test data has incremented
			
			//Now swap the values of From and To user for when we do the final reassign that the test data will be reset for the next test run
			String beforeToUser = testData.get(4);
			reader.copyCellData("Regression", "ToUser", rowNum, testData.get(3));//Assign FromUser value to what was previously To User col
			reader.copyCellData("Regression", "FromUser", rowNum, beforeToUser);//Assign previously To User value to what was previously From User col
			
			FAXnum = aff.FaxIDNumber().substring(38);
			System.out.println(FAXnum);
			//aff.SelectFaxStatus(FAXID);
			return verify;
		}
		
		return false;
	}

	public boolean VerifyAssignedToInIncomingFaxesPage(List<String> testData) throws InterruptedException, IOException, AWTException
	{
		boolean verify = true;
		if(verify)
		{
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString();
			
			//Search for the faxID/cardID and then verify the assignedTo col and the assignedDate
			aff.EnrollFromDate().click();
			cf.SelectDate(testData.get(2));
			aff.FaxID().clear();
		
			//aff.FaxID().sendKeys(testData.get(0));
			aff.FaxID().sendKeys(FAXnum);
			aff.SelectFaxStatus("ALL");
			aff.FaxesPageFindButton().click();
			Thread.sleep(2000);
			//String FAXID = aff.FaxIDNumber();
			//System.out.println("FAXID: "+FAXID);
			//aff.SelectFax(FAXID);
			//Assert.assertEquals(aff.FirstAssignedToInGrid().getText(), testData.get(5));//toUser
			//Assert.assertTrue(aff.FirstAssignedDateInGrid().getText().contains(currentDate));
			String cardID = aff.FirstCardIDInGrid().getText();
			
			System.out.println("CardID: "+cardID);
			
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			apf.PatientsFindPageCardID().sendKeys(cardID);
			apf.PatientsPageFindButton().click();
			
			Thread.sleep(2000);
			apf.PatientsFindFirstReviewButton().click();
			Thread.sleep(1000);
			
			afi.FaxInfoTab().click();
			Thread.sleep(8000);
			//Assert.assertEquals(afi.AssignedToValueLatestRow(), testData.get(5));
			//Assert.assertTrue(afi.AssignedDateValueLatestRow().contains(currentDate));
			
			
			
			return verify;
		}
		verify = false;
		return verify;
	}

}
