package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Providers_ParentProvidersTabPage extends TestBase {
	
	public AdminPortal_Providers_ParentProvidersTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> ParentProvidersTabtableRows()
	{
		return driver.findElements(By.xpath("//table[@id='provider-parentproviders-list']//tbody//tr"));
	}
	
	public List<WebElement> ProvidersTabtableRows()
	{
		return driver.findElements(By.xpath("//table[@id='provider-providers-list']//tbody//tr"));
	}
	
	public int GetTotalProvidersCount()
	{
		WebElement providerCount = driver.findElement(By.xpath("//*[@id='tabprovider_9']/div[1]/table/tbody/tr/td[2]"));
		
		String providerlabel = providerCount.getText();
		
		if(providerlabel.length()>23) 
		{
			String totalCount = providerlabel.substring(23, providerlabel.length());
			return Integer.parseInt(totalCount);
		}
		
		return 0;
	} 
	
	
	
	

}
