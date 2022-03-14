package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_ProviderTabPage extends TestBase {
	
	
	public AdminPortal_Patients_ProviderTabPage  () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientProviderTab()
	{
		return driver.findElement(By.linkText("Provider"));
	}
	
	public WebElement MatchProviderButton()
	{
		return driver.findElement(By.name("Review"));
	}
	public WebElement MatchProviderUnlink()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr[1]/td[13]/form[1]/input[10]"));
	}
	
	public WebElement PrimaryProviderInfm()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Primary Provider Information')]"));
	}
	
	public WebElement PatientProviderList()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_3']/form/div/table/tbody/tr/td[1]/font/strong"));//Updated on 8/6/2021
		return driver.findElement(By.xpath("//*[@id='showpatprorow']"));
		
	}
	public WebElement PatientLinkedProviderList() //Added on 8/6/2021
	{
		return driver.findElement(By.xpath("//*[@id='showpatlinkrow']"));
		
	}
	
	public String ProviderPracticeNameTypeValue()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/form/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]")).getText();//updated for replatform
		return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).getText();
		
	}
	
	public String ProviderContactNameValue()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/form/table/tbody/tr[1]/td[1]/table/tbody/tr[4]/td[2]")).getText();//updated for replatform
		return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]")).getText();
		
	}
	
	public String ProviderNPIValue()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/form/table/tbody/tr[1]/td[1]/table/tbody/tr[6]/td[2]")).getText(); updated for replatform
		return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/table/tbody/tr/td[1]/table/tbody/tr[6]/td[2]")).getText();
		
	}
	
	public String ProviderCityStateZipValue()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/form/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]")).getText(); updated for replatform
		return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]")).getText();
		
	}
	
	public String ProviderPhoneValue()
	{
		return driver.findElement(By.xpath("//*[@id='tab_3']/div[1]/form/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]")).getText();
	}
	
	public List<WebElement> ProviderTabGridCols()
	{
		return driver.findElements(By.xpath("//*[contains(@id,'show_parent_provider')]//thead//th"));
	}
	
	public List<WebElement> ProviderTabGridRows()
	{
		//return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr")); updated for replatform
		return driver.findElements(By.xpath("//*[@id='pat-pro-list']/tbody/tr"));
	}
	
	public void OrderByLinkedDateDesc() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//*[text()='Linked Date']"));
		for(int i=0;i<3;i++) {
			if(ele.getAttribute("class").equalsIgnoreCase("sorting_desc")) {
				break;
			}else {
				ele.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public void SelectPagePerRecords(String noofrecords) throws InterruptedException
	{
		new Select(driver.findElement(By.name("pat-pro-list_length"))).selectByVisibleText(noofrecords);
		Thread.sleep(2000);
	}
	
	public WebElement ShowInfoLinkByProviderLinkType(String providerLinkType)
	{
		//return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr")); updated for replatform
		return driver.findElement(By.xpath("//*[@id='pat-pro-list']//tbody//tr//td[text()='" + providerLinkType + "']/parent::tr//*[text()='Show Info']"));
	}
	
	
	public String ProviderNameFirstRowValue()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[1]")).getText(); //updated for replatform
		return driver.findElement(By.xpath("//*[contains(@id,'show_parent_provider')]//tbody//td[1]")).getText();
		
	}
	
	public String ProviderFirstNameFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[2]")).getText();
	}
	
	public String ProviderLastNameFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[3]")).getText();
	}
	
	public String ProviderAddressFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[4]")).getText();
	}
	
	public String ProviderPhoneFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[5]")).getText();
	}
	
	public String ProviderEmailFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[6]")).getText();
	}
	
	public String ProviderTypeFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[7]")).getText();
	}
	
	public String ProviderNPIFirstRowValue()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[8]")).getText(); //updated for replatform
		return driver.findElement(By.xpath("//*[contains(@id,'show_parent_provider')]//tbody//td[8]")).getText();
		
	}
	
	public String ProviderLinkTypeFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[9]")).getText();
	}
	
	public String ProviderLinkedDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[10]")).getText();
	}
	
	public String ProviderIDFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[11]")).getText();
	}
	
	public String ParentProviderIDFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr/td[12]")).getText();
	}
	
	
	
	public WebElement ProviderShowPatientProviderList()
	{
		return driver.findElement(By.xpath("//*[@id='showpatprorow']"));
	}
	
	public WebElement ProviderSorting()
	{
		return driver.findElement(By.xpath("//*[@id='pat-pro-list']/thead/tr/th[3]"));
	}
	
	public WebElement ProviderShowPatientProviderListShowInfo()
	{
		return driver.findElement(By.xpath("//*[@id='533']"));
	}
	
	public WebElement ProviderFirstRowUnlink()
	{
		return driver.findElement(By.xpath("//*[@value='Unlink']"));
		
	}
	 
	
	public WebElement ProviderActionFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[2]/table[@id='sortTable']/tbody/tr/td[13]/form/input[@name='Review']"));
	}
	 

	public WebElement ProviderAfterReviewVerify()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd']/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/th/strong/span"));
	}
	public String ProviderLinkTypeLastRowValue()
	{//we need to consider size-1 in the following because on the UI, the last row is actually not a row. The last row that has data is in position size-1
		//return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr["+(ProviderTabGridRows().size() - 1)+"]/td[9]")).getText(); updated for replatform
		//*[@id="pat-pro-list"]/tbody
		
		//return driver.findElement(By.xpath("//div[@id='pat-pro-list']/tbody/tr["+(ProviderTabGridRows().size() - 1)+"]/td]")).getText();
		return driver.findElement(By.xpath("//*[@id='dtcol_0']")).getText();
		
	
		
	}
	
	public String ProviderNPILastRowValue()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr["+(ProviderTabGridRows().size() - 1)+"]/td[5]")).getText(); updated for replatform
		return driver.findElement(By.xpath("//*[contains(@id,'show_parent_provider')]//tbody//td[8]")).getText();
		
	}
	
	public String ProviderNameSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[1]")).getText();
	}
	
	public String ProviderFirstNameSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[2]")).getText();
	}
	
	public String ProviderLastNameSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[3]")).getText();
	}
	
	public String ProviderAddressSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[4]")).getText();
	}
	
	public String ProviderPhoneSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[5]")).getText();
	}
	
	public String ProviderEmailSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[6]")).getText();
	}
	
	public String ProviderTypeSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[7]")).getText();
	}
	
	public String ProviderNPISecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[8]")).getText();
	}
	
	public String ProviderLinkTypeSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[9]")).getText();
	}
	
	public String ProviderLinkedDateSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[10]")).getText();
	}
	
	public WebElement ProviderActionSecondRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[@id='tab_3']/div[3]/table[@id='sortTable']/tbody/tr[2]/td[11]/form/input[@class='button_empty']"));
	}
	
	public WebElement ProviderUnlinkSuccessMsg(String message)
	{
		//return driver.findElement(By.xpath("//*[@id='sortTable']/tbody/tr["+ProviderTabGridRows().size()+"]/td/font")); updated for replatform
		return driver.findElement(By.xpath("//*[text()='" + message + "']"));
	}

	public void VerifyUnlinkingProviderFromPatient(String npi, String unlinkMsg, String providerLinkType) throws InterruptedException
	{
		//click on unlink link
		//click on unlink link
		AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
		AdminPortal_PG_BO_ProvidersTabPage apbo = new AdminPortal_PG_BO_ProvidersTabPage();
				apbo.ClickArrowDownToDisplayTable("showpatprorow");
				apt.OrderByLinkedDateDesc();
				Thread.sleep(2000);
				ProviderFirstRowUnlink().click();
				Thread.sleep(5000);
				//ProviderActionFirstRowValue().click();//Unlink the first row which is the latest added/matched provider
				Assert.assertEquals(ProviderUnlinkSuccessMsg(unlinkMsg).getText(), unlinkMsg);
				apbo.ClickArrowDownToDisplayTable("showpatprorow");
				apt.SelectPagePerRecords("100");
				apt.OrderByLinkedDateDesc();
				apt.ShowInfoLinkByProviderLinkType("Inactive").click();
			Thread.sleep(2000);
			System.out.println("npi is:" +npi);
			System.out.println("=>:" +ProviderNPILastRowValue());
			Assert.assertTrue(ProviderNPILastRowValue().equals(npi));
		//	Assert.assertTrue(ProviderPracticeNameTypeValue().contains("/"));
			
		
	}
	
	
	
}
