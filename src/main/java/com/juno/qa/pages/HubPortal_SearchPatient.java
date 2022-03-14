package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class HubPortal_SearchPatient extends TestBase {

	// Patient Portal Page Objects

public WebElement FirstName() // External Portal- First name
	{
		return driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
	}
	
public WebElement LastName() // External Portal- Last Name
{
	return driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
}

public WebElement PateintSearchDate() // External Portal - date
{
	return driver.findElement(By.xpath("//input[@aria-haspopup='dialog']"));
}


public WebElement PateintSearchMemberID() // External Portal -Member ID
{
	return driver.findElement(By.xpath("//input[@formcontrolname='memberId']"));
}


public Select  PateintSearchProduct() //External Portal -Product
{
	Select State = new Select(driver.findElement(By.id("mat-select-value-3")));
	return State;
	
}
public WebElement PateintSearchButton() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-search/form/button[1]/span[1]"));  
}
public WebElement PateintSearchOpenPatient() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr[1]/td[1]/a/span"));  
}

public WebElement PateintSearchFullName() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[1]/mat-card-content/div[1]/div[1]/div[2]"));
}
public WebElement PateintName() // External Portal- Search
{
	return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-search/div/app-patient-search-table/div/table/tbody/tr/td[1]/a/span"));
}

public WebElement PateintSearchGender() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[1]/mat-card-content/div[1]/div[2]/div[2]"));
	
}
public WebElement PateintSearchDOB() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[1]/mat-card-content/div[1]/div[3]/div[2]"));
	
}
public WebElement PateintSearchAddress() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[1]/mat-card-content/div[2]/div[1]"));
}

public WebElement PateintSearchPhoneNumber() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[1]/mat-card-content/div[2]/div[2]/div[1]/div/div[2]"));
}
public WebElement PateintSearchBIN() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[1]/div[1]/div[2]"));
}
public WebElement PateintSearchPCN() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[1]/div[2]/div[2]"));
}
public WebElement PateintSearchGroup() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[1]/div[3]/div[2]"));
}
public WebElement PateintSearchMember() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}

public WebElement PateintSearchCompanyName() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchPlanType() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchGroupNumber() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchMemberNumber() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchEffectiveDate() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchBIN2() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}
public WebElement PateintSearchPCN2() // External Portal- Search
{
	return driver.findElement(By.xpath("//app-patient-info/mat-card[2]/mat-card-content/div/div[2]/div/div[2]"));
}

public WebElement PateintSearchFirstReview() // External Portal- Search
{
	//return driver.findElement(By.xpath("//app-patient-search-table/div/table/tbody/tr[1]/td[1]")); 
	//return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-search/div/app-patient-search-table/div/table/tbody/tr[1]/td[1]"));
	return driver.findElement(By.xpath("//a[contains(@href,'/hcp/view-patient')]"));
}

public WebElement PateintSearchPatientsTabLandingMessage() // External Portal- Search
{
//	return driver.findElement(By.xpath("//*[contains(text(),'Patient Information')]"));  //updated on 8112021
	return driver.findElement(By.xpath("//*[contains(text(),'Patient Profile Details')]"));
}

public WebElement PateintSearchClaimsTab() // External Portal- Search
{
	//return driver.findElement(By.xpath("//a[contains(@href,'/hcp/view-patient/154666/claims?programName=Xolair%20Injection%20Replatform')]"));//updated on 7/29/2021
	return driver.findElement(By.xpath("//app-patient-viewer/nav/div[2]/div/div/a[2]"));
}
public WebElement ClaimsTable() // External Portal- Search
{
	return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/div/div[1]/div/div[2]/div/app-patient-viewer/app-patient-claims/mat-card/mat-card-content/div/app-patient-claims-table/div/table"));
}

public WebElement ClaimsTabSearchButton() // External Portal- Search
{
	return driver.findElement(By.xpath("//span[contains(text(),'Search')]//ancestor::button"));
}

public WebElement PateintSearchLoading() // External Portal- Search
{
	return driver.findElement(By.xpath("//*[@id='font-size-control']/app-layout/app-app-progress-spinner/div/mat-spinner/svg/circle"));
}


public WebElement PateintSearchClaimsTabLandingMessage() // External Portal- Search
{
	return driver.findElement(By.xpath("//*[contains(text(),'Patient Claims History')]"));  
}

public WebElement PateintSearchCommunicationTab() // External Portal- Search
{
	//return driver.findElement(By.xpath("//a[contains(@href,'/hcp/view-patient/154666/communications?programName=Xolair%20Injection%20Replatform')]")); //updated on 7/29/2021
	return driver.findElement(By.xpath("//app-patient-viewer/nav/div[2]/div/div/a[3]"));
	
}

public WebElement PateintSearchCommunicationTabLandingMessage() // External Portal- Search
{
	return driver.findElement(By.xpath("//*[contains(text(),'Patient Communications History')]"));  
}

}