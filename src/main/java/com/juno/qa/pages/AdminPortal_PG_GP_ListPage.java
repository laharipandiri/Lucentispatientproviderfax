package com.juno.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortal_PG_GP_ListPage extends TestBase {
	
	public AdminPortal_PG_GP_ListPage () {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement AllLink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[27]/form/input[8]"));
	}
	
	public WebElement TotalCountLabel()
	{
		return driver.findElement(By.id("providers-list_info"));
	}
	
	public List<WebElement> HeaderAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td"));
	}
	
	public WebElement HeaderAlphabeticalLinkNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td["+i+"]/form/input[8]"));
	}
	
	public List<WebElement> FooterAlphabeticalLinks()
	{
		return driver.findElements(By.xpath("//*[@id='form-table']/div[4]/table/tbody/tr/td"));
	}
	
	public WebElement FooterAlphabeticalLinkNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[4]/table/tbody/tr/td["+i+"]/form/input[8]"));
	}
	
	public List<WebElement> HeaderColumns()
	{
		return driver.findElements(By.xpath("//*[@id='providers-list']//th"));
	}
	
	public WebElement HeaderColumnNames(int i)
	{
		return driver.findElement(By.xpath("//*[@id=\"sortTable\"]/thead/tr/th["+i+"]"));
	}
	
	public WebElement ALink()
	{
		return driver.findElement(By.xpath("//*[@id='form-table']/div[1]/table/tbody/tr/td[1]/form/input[8]"));
	}
	
	public Select ShowEntriesDD()
	{
		return new Select(driver.findElement(By.xpath("//select[@name='providers-list_length']")));
	}
	
	public List<String> GetShowEntriesDropDownOptions(){
		List<String> options = new ArrayList<String>();
		List<WebElement> ddeles = ShowEntriesDD().getOptions();
		for(WebElement ele:ddeles) {
			options.add(ele.getText());
		}
		return options;
	}
	
	public String GetTableEntriesDisplayMsg() {
		return driver.findElement(By.xpath("//div[@id='providers-list_info']")).getText();
	}
	
	public int GetTotalTableEntries() {
		String totalRecords = GetTableEntriesDisplayMsg().split("of")[1].split(" ")[1].strip();
		return Integer.valueOf(totalRecords);
	}
	
	public WebElement GetPaginationElement(String paginationNo) {
		return driver.findElement(By.xpath("//*[contains(@class,'paginate_button') and text()='" + paginationNo + "']"));
	}
	
	public WebElement GetCurrentPageElement() {
		return driver.findElement(By.xpath("//*[@class='paginate_button current']"));
	}
	
	public int GetCurrentPageNo() {
		String pageNo = GetCurrentPageElement().getText();
		return Integer.valueOf(pageNo);
	}
}
