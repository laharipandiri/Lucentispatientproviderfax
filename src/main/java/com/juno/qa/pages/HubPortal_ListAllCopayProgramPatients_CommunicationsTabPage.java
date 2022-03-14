package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubPortal_ListAllCopayProgramPatients_CommunicationsTabPage extends TestBase {
	
	public HubPortal_ListAllCopayProgramPatients_CommunicationsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CommunicationsTab()
	{
		return driver.findElement(By.linkText("Communications"));
	}
	
	public String LettersLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/p")).getText();
	}
	
	public List<WebElement> LettersTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr/td"));
	}
	
	public List<WebElement> LettersTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[1]/tbody/tr"));
	}
	
	public WebElement LettersTableSubjectLetterLinkLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+LettersTableRows().size()+"]/td[1]/a"));
	}
	
	
	public String LettersTableCreatedDatevalueLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+LettersTableRows().size()+"]/td[2]")).getText();
	}
	
	public String LettersTableSentDatevalueLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+LettersTableRows().size()+"]/td[3]")).getText();
	}
	
	public String LettersTableSentTovalueLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+LettersTableRows().size()+"]/td[4]")).getText();
	}
	
	public WebElement LettersTableSubjectLetterLinkLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+(LettersTableRows().size()-1)+"]/td[1]/a"));
	}
	
	
	public String LettersTableCreatedDatevalueLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+(LettersTableRows().size()-1)+"]/td[2]")).getText();
	}
	
	public String LettersTableSentDatevalueLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+(LettersTableRows().size()-1)+"]/td[3]")).getText();
	}
	
	public String LettersTableSentTovalueLastButOneRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table/tbody/tr["+(LettersTableRows().size()-1)+"]/td[4]")).getText();
	}
	
	public String FaxesLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/p[2]")).getText();
	}
	
	public List<WebElement> FaxesTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr/td"));
	}
	
	public List<WebElement> FaxTableRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr"));
	}
	
	public WebElement FaxTableFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td"));
	}
	
	public WebElement FaxTableLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr["+FaxTableRows().size()+"]/td"));
	}
	
	public String FaxTypevalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td")).getText();
	}
	
	public String TypevalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[1]")).getText();
	}
	
	public String FaxIDvalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String ClaimIDvalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[3]")).getText();
	}
	
	public String DatevalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[4]")).getText();
	}
	
	public String FaxStatusvalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[5]")).getText();
	}
	
	public String FaxNumbervalueFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[6]")).getText();
	}
	
	public WebElement ViewLinkFirstRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td[7]/a"));
	}
	
	public String TypevalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String FaxIDvalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public String ClaimIDvalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]")).getText();
	}
	
	public String DatevalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[4]")).getText();
	}
	
	public String FaxStatusvalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[5]")).getText();
	}
	
	public String FaxNumbervalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[6]")).getText();
	}
	
	public WebElement ViewLinkSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[7]/a"));
	}
	
	public String FaxTypevalueSecondRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td")).getText();
	}
	
	public String TypevalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[1]")).getText();
	}
	
	public String FaxIDvalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[2]")).getText();
	}
	
	public String ClaimIDvalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[3]")).getText();
	}
	
	public String DatevalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String FaxStatusvalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[5]")).getText();
	}
	
	public String FaxNumbervalueThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[6]")).getText();
	}
	
	public WebElement ViewLinkThirdRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[7]/a"));
	}
	
	public String TypevalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String FaxIDvalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public String ClaimIDvalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[3]")).getText();
	}
	
	public String DatevalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[4]")).getText();
	}
	
	public String FaxStatusvalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[5]")).getText();
	}
	
	public String FaxNumbervalueFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[6]")).getText();
	}
	
	public WebElement ViewLinkFourthRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs']/div[5][@id='tabs-4']/table[2]/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[7]/a"));
	}
	
	
	

}
