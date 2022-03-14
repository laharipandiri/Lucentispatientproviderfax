package com.juno.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_BO_ProvidersTabPage extends TestBase {
	
	public AdminPortal_PG_BO_ProvidersTabPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement ProvidersTab()
	{
		return driver.findElement(By.xpath("//*[@id='provider_providers_list']//*[text()='Providers']"));
	}
	
	public WebElement ProviderName()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div[2]/div/form/table/tbody/tr[2]/td[2]/input[@id='provider_name']"));
	}
	
	public WebElement ProviderContactLastName()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div[2]/div/form/table/tbody/tr[3]/td[2]/input[@id='provider_last_name']"));
	}
	
	public WebElement ProviderContactFirstName()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div[2]/div/form/table/tbody/tr[4]/td[2]/input[@id='provider_first_name']"));
	}
	
	public WebElement ProviderNPI()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div[2][@id='tabs_wrapper']/div[2][@id='tabs_content_container']/div[2]/div/form/table/tbody/tr[4]/td[2]/input[@id='provider_npi']"));
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.className("btn_update"));
	}
	
	public WebElement RequiredFieldsMsg()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd2grp']/table/tbody/tr[6]/td/font"));
	}
	
	public WebElement ProviderNameAutoSuggest()
	{
		return driver.findElement(By.id("provider_search"));
	}
	
	public List<WebElement> GetAllNameAutoSuggetions()
	{
		return driver.findElements(By.xpath("//*[@id='provider_search']"));
	}
	
	public void ClickAutoSuggestExcludingProvider(String lastname)
	{
		List<WebElement> autosuggests = driver.findElements(By.xpath("//*[@id='provider_search']"));
		for(WebElement ele:autosuggests) {
			if(!ele.getText().contains(lastname)) {
				ele.click();
			}
		}
	}
	
	public WebElement ProviderAddConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='provideradd2grp']/table/tbody/tr[6]/td/font"));
	}
	
	public void ClickArrowDownToDisplayTable(String id)
	{
		WebElement ele = driver.findElement(By.id(id));
		
		if(!ele.getAttribute("class").contains("showhideup"))
			ele.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	
	
	public List<WebElement> ProviderstabListGridHeaderCols()
	{
		return driver.findElements(By.xpath("//table[@id='provider-providers-list']//th"));
	}
	
	public WebElement ProviderstabListGridHeaderColNames(int i)
	{
		return driver.findElement(By.xpath("//table[@id='provider-providers-list']//th[" + i + "]"));
	}
	
	public List<WebElement> GetProvidersListTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tabprovider_2']/div[3]/table[@class='tablesorter']/tbody/tr"));
	}
	
	public String getLatestRowProviderNameColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[1]")).getText();
	}
	
	public String getLatestRowContactNameColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[2]")).getText();
	}
	
	public String getLatestRowAddressColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[3]")).getText();
	}
	
	public String getLatestRowCityColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[4]")).getText();
	}
	
	public String getLatestRowStateColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[5]")).getText();
	}
	
	public String getLatestRowZipColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[6]")).getText();
	}
	
	public String getLatestRowTerritoryColmunValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tabprovider_2']/div[3]/table[@class='tablesorter']/tbody/tr["+GetProvidersListTableRows().size()+"]/td[7]")).getText();
	}
	
	public String getLatestRowCardIDColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[7]")).getText();
	}
	
	public String getLatestRowProviderTypeColmunValue()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr/td[8]")).getText();
	}
	
	public WebElement getLatestRowActionColmun()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tabprovider_2']/div[3]/table[@class='tablesorter']/tbody/tr["+GetProvidersListTableRows().size()+"]/td[10]"));
	}
	
	public WebElement getLatestRowActionReviewLink()
	{
		return driver.findElement(By.xpath("//*[@id='provider-providers-list']//tbody//tr//*[@name='Review']"));
	}
	
	public WebElement getLatestRowActionUngroupLink()
	{
		return driver.findElement(By.xpath("//*[@value='Ungroup']"));
	}
	
	public int TotalProvidersCount()
	{
		WebElement totalproviderslabel = driver.findElement(By.xpath("//*[@id='tabprovider_2']/div[2]/table/tbody/tr/td[2]"));
		String providerlabel = totalproviderslabel.getText();
		
		if(providerlabel.length()>16) 
		{
			String totalCount = providerlabel.substring(16, providerlabel.length());
			return Integer.parseInt(totalCount);
		}
		
		return 0;
		
	}
	
	public int TotalProvidersCountFromTable()
	{
		ClickArrowDownToDisplayTable("showproviderrow");
		return driver.findElements(By.xpath("//*[@id='provider-providers-list']//tbody//tr[@role='row']")).size();
		
	}
	
	public Map<String, String> getProviderRowsDataByName(String name){
		Map<String, String> providersData = new HashMap<String, String>();
		List<WebElement> colHeaders = driver.findElements(By.xpath("//*[@id='provider-providers-list']//thead//th"));
		for(int i=0; i<colHeaders.size();i++) {
			String colName = colHeaders.get(i).getText();
			if(!colName.equalsIgnoreCase("Action")) {
				int colNum = i+1;
				String colData = driver.findElement(By.xpath("//td[text()='" + name + "']/parent::tr/td[" + colNum + "]")).getText();
				providersData.put(colName, colData);
			}
		}
		return providersData;
	}
	

}
