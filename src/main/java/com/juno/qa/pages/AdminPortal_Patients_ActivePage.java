package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_ActivePage extends TestBase {
	
	public AdminPortal_Patients_ActivePage() {
		PageFactory.initElements(driver, this);
	}
		public WebElement PatientsActivePageMemberID()
		{
			return driver.findElement(By.name("patient_other_id"));
		}
		
		public WebElement PatientsActivePageCardID()
		{
			return driver.findElement(By.name("patient_short_card_id"));
		}
		
		public WebElement PatientsActivePagePartnerPatientID()
		{
			return driver.findElement(By.name("patient_referral_code"));
		}
		
		public WebElement PatientsActivePageFindButton()
		{
			return driver.findElement(By.name("patient_list_button_find"));
		}
		
		public WebElement PatientsActiveFirstReviewButton()
		{
			return driver.findElement(By.name("Review"));
		}
		
		public WebElement EnrollFromDate()
		{
			return driver.findElement(By.name("enroll_min_date"));
		}
		
		public WebElement EnrollToDate()
		{
			return driver.findElement(By.name("enroll_max_date"));
		}
		
		public WebElement SelectTodayDateInCalendar()
		{
			return driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']"));
		}
		
		public String LastNameValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[1]")).getText();
		}
		
		public String FirstNameValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[2]")).getText();
		}
		public String ProgramNameValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[3]")).getText();
		}
		
		public String ActivationDateValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[5]")).getText();
		}
		public String CreatedDateValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[6]")).getText();
		}
		
		public String StatusValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[8]")).getText();
		}
		public String ConatctValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[9]")).getText();
		}
		
		public String MemberIDValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[4]")).getText();
		}
		
		public String PartnerPatientIDValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[10]")).getText();
		}
		
		public String CardIDValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[11]")).getText();
		}
		public String ProviderNameValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[11]")).getText();
		}
		
		public String ProviderTypeValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[12]")).getText();
		}
		
		public String ConfirmationNumberValueInFirstRow()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr[1]/td[14]")).getText();
		}
		
		public List<WebElement> PatientsActivePageSearchResultGridCols()
		{
			return driver.findElements(By.xpath("//table[@id='patients-list']/thead/tr/th"));
		}
		
		public WebElement PatientsActivePageSearchResultGridColNames(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/thead/tr/th["+i+"]"));
		}
		
		public WebElement PatientAddressFromGrid()
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']//tbody//td[9]"));
		}
		
		public List<WebElement> PatientsActivePageSearchResultGridRows()
		{
			return driver.findElements(By.xpath("//table[@id='patients-list']/tbody/tr"));
		}
		
		public String MemberIDValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[9]")).getText();
		}
		
		public String LastNameValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[1]")).getText();
		}
		
		public String FirstNameValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[2]")).getText();
		}
		public String ProgramNameValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[3]")).getText();
		}
		
		public String ActivationDateValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[4]")).getText();
		}
		public String CreatedDateValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[5]")).getText();
		}
		
		public String StatusValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[7]")).getText();
		}
		public String ConatctValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[8]")).getText();
		}
		
		public String PartnerPatientIDValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[10]")).getText();
		}
		
		public String CardIDValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[11]")).getText();
		}
		public String ProviderNameValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[12]")).getText();
		}
		
		public String ProviderTypeValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[13]")).getText();
		}
		
		public String ConfirmationNumberValueInGrid(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[14]")).getText();
		}
		
		public WebElement PatientsActiveReviewButton(int i)
		{
			return driver.findElement(By.xpath("//table[@id='patients-list']/tbody/tr["+i+"]/td[15]/form[1]/input[@name='Review']"));
		}

}
