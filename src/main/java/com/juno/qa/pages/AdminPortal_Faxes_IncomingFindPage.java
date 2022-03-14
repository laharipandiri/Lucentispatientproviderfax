package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Faxes_IncomingFindPage extends TestBase {
	
	AdminPortalHomePage ahp = new AdminPortalHomePage(); 
	
	public AdminPortal_Faxes_IncomingFindPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProgramDropdown()
	{
		Select programList = new Select(driver.findElement(By.id("program")));
		return programList;
	}
	
	public Select HelpDeskUserDropdown()
	{
		Select HDUserList = new Select(driver.findElement(By.id("assigned_user")));
		return HDUserList;
	}
	
	public WebElement EnrollFromDate()
	{
		return driver.findElement(By.name("request_date_from"));
	}
	
	public WebElement EnrollToDate()
	{
		return driver.findElement(By.name("request_date_to"));
	}
	
	public WebElement CardID()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement FaxID()
	{
		return driver.findElement(By.name("fax_id"));
	}
	
	public void SelectFaxStatus(String value)
	{
		Select sel = new Select(driver.findElement(By.name("fax_status")));
		sel.selectByVisibleText(value);
	}
	
	public WebElement MemberID()
	{
		return driver.findElement(By.name("patient_other_id"));
	}
	
	public WebElement PartnerPatientID()
	{
		return driver.findElement(By.name("patient_referral_code"));
	}
	
	public Select FaxTYpeDropdown()
	{
		Select faxTypeList = new Select(driver.findElement(By.id("fax_type")));
		return faxTypeList;
	}
	
	public Select FaxStatusDropdown()
	{
		Select faxStatusList = new Select(driver.findElement(By.id("fax_status")));
		return faxStatusList;
	}
	public Select FaxProgramDropdown()
	{
		Select faxprogramList = new Select(driver.findElement(By.id("program")));
		return faxprogramList;
	}
	
	public WebElement Faxesprogram()
	{
		return driver.findElement(By.id("program"));
	}
	
	public WebElement FaxesprogramSusvimo()
	{
		return driver.findElement(By.xpath("//*[@id='program']/option[2]"));
	}
	
	
	public WebElement FaxesPageFindButton()
	{
		return driver.findElement(By.cssSelector("input[type='submit']"));
	}
	
	public WebElement CloneFaxFirstRowLinkBeforeClone()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[10]/form[2]/input[14]"));
	}
	
	public WebElement CloneFaxFirstRowLinkAfterClone()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[14]/form[2]/input[14]"));
	}
	
	public WebElement CloneFaxWithCardFirstRowLinkBeforeClone()
	{
		return driver.findElement(By.xpath("//*[@id=\"dtcol_7\"]/form[3]/input[12]")); //updated for Clone a Fax with card 
		//return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[10]/form[3]/input[14]"));
		
		
	}
	
	public WebElement CloneFaxWithCardFirstRowLinkAfterClone()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[14]/form[3]/input[14]"));
	}
	
	public WebElement EditAssignLinkFirstRow()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[14]/form[1]/input[10]"));
	}
	public WebElement FaxClonedMessage()
	{
		return driver.findElement(By.xpath("*[@id=\"search_fax\"]/div/table/tbody/tr[8]/td/font"));
		//*[@id="search_fax"]/div/table/tbody/tr[8]/td/font
		//return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/fieldset/form/div/table/tbody/tr[10]/td/font"));
		
	}
	
	
	public String FaxListLabel()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[1]/b")).getText();
	}
	
	public String TotalFaxesLabelAndValue()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String CountLabelAndValue()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[2]/table/tbody/tr/td[3]")).getText();
	}
	
	public List<WebElement> IncomingFaxeSearchGridCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th"));
	}
	
	public WebElement IncomingFaxeSearchGridColNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> OldFaxDataCols()
	{
		return driver.findElements(By.xpath("//*[@id='reportTable']/thead/tr/th[5]/table/tbody/tr/th"));
	}
	
	public WebElement PatientReviewLinkFirstRow() 
	{
//		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[10]/form[1]/input[@value = 'Review' ]"));//updated 01102022
		return driver.findElement(By.xpath("//*[@id='incoming-list']/tbody/tr[1]/td[8]/form[1]/input[@value = 'Review' ]"));
	}
	
	public WebElement FirstCardIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='incoming-list']/tbody/tr/td[6]"));
	}
	
	public WebElement CardInGridAfterCloneWithFax()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[1]"));
	}
	
	public WebElement FirstFaxIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[1]/a"));
	}
	
	public WebElement FirstFaxTypeInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[2]"));
	}
	
	public WebElement FirstDateTimeInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[3]"));
	}
	
	public WebElement FirstFaxNumInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[4]"));
	}
	
	public WebElement FirstAssignedToInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[5]"));
	}
	
	public WebElement FirstPartnerPatientIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[8]"));
	}
	
	public WebElement FirstMemberIDInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[7]"));
	}
	
	public WebElement FirstAssignedDateInGrid()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr[1]/td[9]"));
	}
	
	public WebElement NewTypeValueFromOldFax()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[7]/table/tbody/tr/td[1]"));
	}
	
	public WebElement NewIDValueFromOldFax()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[7]/table/tbody/tr/td[2]/a"));
	}
	
	public WebElement NewFileValueFromOldFax()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[7]/table/tbody/tr/td[3]"));
	}
	
	public WebElement NewTimeValueFromOldFax()
	{
		return driver.findElement(By.xpath("//*[@id='reportTable']/tbody/tr/td[7]/table/tbody/tr/td[4]"));
	}
	
	public WebElement CloneConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/fieldset/form/div/table/tbody/tr[10]/td/font"));
	}
	
	public String FaxIDNumber()
	{
		return driver.findElement(By.xpath("//*[@id=\"assignments\"]/div/table/tbody/tr[4]/td/font")).getText();
	}
	public boolean VerifyAfterCloneFunctionality(List<String> testData, List<String> testData1, String newFaxID)
	{
		boolean verify = true;
		if(verify)
		{
			//verify the column headers
			for(int i=1; i<=IncomingFaxeSearchGridCols().size();i++ )
			{
				if(i<7) {
							Assert.assertEquals(driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th["+i+"]")).getText(), testData1.get(i));
						 }	
						 else if(i==7)
						 		{
							 		for(int j=1; j<=OldFaxDataCols().size(); j++)
							 		{
							 			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th[5]/table/tbody/tr/th["+j+"]")).getText(), testData1.get(j+6));
							 		}
						 		}
						 else if(i>7)
						 {
							 Assert.assertEquals(driver.findElement(By.xpath("//*[@id='reportTable']/thead/tr/th["+i+"]")).getText(), testData1.get(i+7));
						 }
				
			}
			//verify the values in the columns as much as you can for now
			//verify the links in the last column
			Assert.assertTrue(EditAssignLinkFirstRow().isDisplayed());
			Assert.assertTrue(CloneFaxFirstRowLinkAfterClone().isDisplayed());
			Assert.assertTrue(CloneFaxWithCardFirstRowLinkAfterClone().isDisplayed());
			
			
			Assert.assertEquals(NewTypeValueFromOldFax().getText(), testData.get(3));
			Assert.assertEquals(NewIDValueFromOldFax().getText(), newFaxID);
			Assert.assertEquals(NewFileValueFromOldFax().getText(), testData.get(4));
			Assert.assertEquals(NewTimeValueFromOldFax().getText(), testData.get(5).trim());
			
			return verify;
		}
		else
			verify = false;
		
		return verify;
		
	}
		
	public boolean VerifyNewClonesFaxIsInIncomingPage(String newFaxID, String enrollFromDate)
	{
		boolean verify = true;
		if(verify)
		{
			ahp.FaxesLink().click();
			ahp.IncomingFaxesLink().click();
			EnrollFromDate().click();
			
			String[] DS = enrollFromDate.split("-");
	        String YDS = DS[2];
	        String MDS = DS[1];
	        String DDS = DS[0];
	
	        System.out.println(MDS);
	        System.out.println(DDS);
	        
	        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
	        YearDS.selectByValue(YDS);
	    //    Thread.sleep(3000);
	        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
	        MonthDS.selectByVisibleText(MDS);
	    //    Thread.sleep(3000);
	        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
	        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
	        
	        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	           if (col.getText().equals(DDS))
	           {
	           	System.out.println(col.getText());
	              col.findElement(By.linkText(DDS)).click();
	              break;
	           }
	        }
	      
	        
	        FaxID().sendKeys(newFaxID);
			FaxesPageFindButton().click();
			
			Assert.assertEquals(FirstFaxIDInGrid().getText(), newFaxID);
			return true;
		}
		else
			verify = false;
		
		return verify;
		
		
		
	}

}

