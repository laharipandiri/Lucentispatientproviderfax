package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_MatchPage extends TestBase {
	
	AdminPortal_Patients_ProviderTabPage apt = new AdminPortal_Patients_ProviderTabPage();
	AdminPortalHomePage ahp = new AdminPortalHomePage();
	AdminPortal_Patients_FindPage app = new AdminPortal_Patients_FindPage();
	AdminPortal_Patients_PatientAndCardTabPage ppc = new AdminPortal_Patients_PatientAndCardTabPage();
	AdminPortal_Patients_TreatmentsPage atp = new AdminPortal_Patients_TreatmentsPage();
	AdminPortal_PG_BO_ProvidersTabPage apbo = new AdminPortal_PG_BO_ProvidersTabPage();
	
	public AdminPortal_Patients_MatchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PatientInformationLabel()
	{
		//return driver.findElement(By.xpath("//div[@class='form-container']/div/table/tbody/tr/td/font/strong")); updated for replatform
		return driver.findElement(By.xpath("//*[@id='patientmatch']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/th"));
		
	}
	
	public WebElement PatientInformationGrid()
	{
		//return driver.findElement(By.xpath("//div[@class='form-container']/div[2]")); updated for replatform
		return driver.findElement(By.xpath("//*[@id='patientmatch']/table/tbody/tr[2]/td[1]"));
		
	}
	
	public WebElement ProviderInformationLabel()
	{
		//return driver.findElement(By.xpath("//div[@class='form-container']/form[@name='patientmatch']/div/table/tbody/tr/td/font/strong")); //updated for replatform
		return driver.findElement(By.xpath("//*[@id='patientmatch']/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/th/font/strong"));
		
	}
	
	public WebElement ProviderInformationGrid()
	{
		//return driver.findElement(By.xpath("//div[@class='form-container']/form/div[2]")); Updated for replatform
		return driver.findElement(By.xpath("//*[@id='patientmatch']/table/tbody/tr[2]/td[2]"));
		
	}
	
	public WebElement AssignButton()
	{
		//return driver.findElement(By.className("button_assign")); //updated for replatform
		return driver.findElement(By.className("button_search"));
		
	}
	
	public Select ProviderLinkTypeDropdown()
	{
		Select providerLinkType = new Select(driver.findElement(By.id("provider_link_type")));
		return providerLinkType;
	}
	
	public WebElement ProviderName()
	{
		return driver.findElement(By.id("provider_name"));
	}
	
	public WebElement ProviderFirstName()
	{
		return driver.findElement(By.id("provider_first_name"));
	}
	
	public WebElement ProviderLastName()
	{
		return driver.findElement(By.id("provider_last_name"));
	}
	
	public WebElement ProviderNPI()
	{
		return driver.findElement(By.id("provider_npi"));
	}
	
	public WebElement ProviderAddressOne()
	{
		return driver.findElement(By.id("provider_address_1"));
	}
	
	public WebElement ProviderCity()
	{
		return driver.findElement(By.id("provider_city"));
	}
	
	public WebElement ProviderState()
	{
		return driver.findElement(By.id("provider_state"));
	}
	
	public WebElement ProviderZip()
	{
		return driver.findElement(By.id("provider_zip"));
	}
	
	public WebElement ProviderPhone()
	{
		return driver.findElement(By.id("provider_phone_number"));
	}
	
	public WebElement AutoSuggest()
	{
		return driver.findElement(By.id("provider_search"));
	}
	
	public WebElement PatientPhysicianMatchedConfirmationMsg()
	{
		//return driver.findElement(By.xpath("//*[@id='sortTable1']/tbody/tr[13]/td/font")); updated for replatform
		return driver.findElement(By.xpath("//*[@id='patientmatch']/table/tbody/tr[4]/td/font")); 
		
	}
	
	public String ProviderLinkTypeFieldRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[1]")).getText();
	}
	
	public String ProviderNameRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[2]")).getText();
	}
	
	public String ProviderLastNameRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[4]")).getText();
	}
	
	public String ProviderFirstNameRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[3]")).getText();
	}
	
	public String ProviderNPIRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id='sortTable1']/tbody/tr[5]/td[1]/font")).getText();
	}
	
	public String ProviderAddressOneRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[5]")).getText();
	}
	
	public String ProviderCityRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[6]")).getText();
	}
	
	public String ProviderStateRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[7]")).getText();
	}
	
	public String ProviderZipRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[8]")).getText();
	}
	
	public String ProviderPhoneRequiredMsg()
	{
		return driver.findElement(By.xpath("//*[@id=\"patientmatch\"]/table/tbody/tr[4]/td/font/text()[9]")).getText();
	}
	
	public String RequiredMsgUnderAssignButton()
	{
		return driver.findElement(By.xpath("//*[@color='red']")).getText();
	}
	
	public boolean VerifyAbilityToMatchAndUnlinkPrimaryProviderWithPatient(List<String> testData, List<String> providertabCols, WebElement searchField, String searchFieldValue, String ProviderLinkType) throws InterruptedException, IOException, AWTException
	{
		//String providerPracticeNameType = testData.get(1)+" / "+testData.get(12); //updated for replatform
		String providerPracticeNameType = testData.get(1);
		System.out.println("providerPracticeNameType is:" +providerPracticeNameType);
		String cityStateZip = testData.get(6)+", "+testData.get(7)+" "+testData.get(8);
		System.out.println("cityStateZip is:" +cityStateZip);
		String fullAddress = testData.get(5)+"\n"+ testData.get(6)+","+testData.get(7)+" "+testData.get(8);
		System.out.println("fullAddress is:" +fullAddress);
		String[] phoneNum = testData.get(9).split("-");
		System.out.println("phoneNum is:" +phoneNum);
		
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ProviderLinkTypeDropdown().selectByVisibleText(ProviderLinkType);//ProviderLinkType=Primary
		searchField.sendKeys(searchFieldValue);
		Thread.sleep(5000);
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	            //AutoSuggest().click();
	        	driver.findElement(By.xpath("//*[contains(text(),'" + testData.get(1) + "')]")).click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);
		
		AssignButton().click();
		System.out.println("The test data in 16 is:" +testData.get(16));
		System.out.println(PatientPhysicianMatchedConfirmationMsg().getText());
		if(PatientPhysicianMatchedConfirmationMsg().getText().equalsIgnoreCase(testData.get(16)))
		{
			//Now verify that the linked physician in the Provider tab of the patient
			ahp.PatientsLink().click();
			Thread.sleep(1000);
			ahp.FindLink().click();
			Thread.sleep(1000);
			app.PatientsFindPageCardID().sendKeys("EYE00000002");
			app.PatientsPageFindButton().click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(ppc.PatientAndCardTab()));
			Thread.sleep(10000);
			
			//navigate to Provider tab
			apt.PatientProviderTab().click();
			Thread.sleep(10000);
			
			apbo.ClickArrowDownToDisplayTable("showpatprorow");
			apt.SelectPagePerRecords("100");
			apt.OrderByLinkedDateDesc();
			apt.ShowInfoLinkByProviderLinkType("Primary").click();
			//verify in the grid cols and data for the new match
			Thread.sleep(3000);
			List<WebElement> cols = apt.ProviderTabGridCols();
			for(int i=1;i<=cols.size();i++)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'show_parent_provider')]//thead//th[" + i + "]")).getText(), providertabCols.get(i));
			}
			
			Assert.assertEquals(apt.ProviderNameFirstRowValue(), testData.get(1));
			//Assert.assertEquals(apt.ProviderFirstNameFirstRowValue(), testData.get(2));
			//Assert.assertEquals(apt.ProviderLastNameFirstRowValue(), testData.get(3));
			//Assert.assertEquals(apt.ProviderAddressFirstRowValue(), fullAddress);
			/*Assert.assertEquals(apt.ProviderPhoneFirstRowValue(), phoneNum[0]+phoneNum[1]+phoneNum[2]);
			Assert.assertEquals(apt.ProviderEmailFirstRowValue(), testData.get(17));
			Assert.assertEquals(apt.ProviderTypeFirstRowValue(), testData.get(12)); */
			Assert.assertEquals(apt.ProviderNPIFirstRowValue(), testData.get(4));
			/*Assert.assertEquals(apt.ProviderLinkTypeFirstRowValue(), ProviderLinkType);
			Assert.assertTrue(apt.ProviderLinkedDateFirstRowValue().contains(currentDate));
			Assert.assertEquals(apt.ProviderIDFirstRowValue(), testData.get(19));
		//	Assert.assertEquals(apt.ParentProviderIDFirstRowValue(), testData.get(20));
			Assert.assertTrue(apt.ProviderActionFirstRowValue().isDisplayed());*/
			
			
			if(apt.ProviderNPIFirstRowValue().equalsIgnoreCase(testData.get(4)))
			{
				TestBase.classAInstance.logReport("Pass","Match And Unlink  Primary Provider With Patient","Succesfully able to  Verify Match And Unlink Primary Provider With Patient");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Match And Unlink  Primary Provider With Patient","Failed to  Verify Match And Unlink  Primary Provider With Patient");
			}
			
			apt.VerifyUnlinkingProviderFromPatient(testData.get(4), testData.get(18), "Primary");
			
			
			return true;
		}
		
		return false;
	}
	
	public void AutoSuggestSelectByName(String name) {
		List<WebElement> sugges = driver.findElements(By.xpath("//*[@id='provider_search' and contains(text(),'" + name + "')]"));
		for(WebElement ele:sugges) {
			String text = ele.getText();
			if(!text.contains("TAX ID")) {
				ele.click();
				break;
			}
		}
	}
	
	public boolean VerifyAbilityToMatchAndUnlinkSecondaryPrimaryProviderWithPatient(List<String> testData, List<String> providertabCols, WebElement searchField, String searchFieldValue, String ProviderLinkType) throws InterruptedException, IOException, AWTException
	{

		String fullAddress = testData.get(5)+"\n"+ testData.get(6)+","+testData.get(7)+" "+testData.get(8);
		String[] phoneNum = testData.get(9).split("-");
		
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ProviderLinkTypeDropdown().selectByVisibleText(ProviderLinkType);//ProviderLinkType=Primary
		searchField.sendKeys(searchFieldValue);
		Thread.sleep(3000);
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	            //AutoSuggest().click();
	        	driver.findElement(By.xpath("//*[contains(text(),'" + testData.get(1) + "')]")).click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);
		
		AssignButton().click();
		if(PatientPhysicianMatchedConfirmationMsg().getText().equalsIgnoreCase(testData.get(16)))
		{
			//Now verify that the linked physician in the Provider tab of the patient
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			app.PatientsFindPageCardID().sendKeys("EYE00000002");
			app.PatientsPageFindButton().click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(ppc.PatientAndCardTab()));
			
			//navigate to Provider tab
			apt.PatientProviderTab().click();
			Thread.sleep(20000);
			//We cannot verify summary section for secondary because secondary provider info is not displayed here
			apbo.ClickArrowDownToDisplayTable("showpatprorow");
			apt.SelectPagePerRecords("100");
			apt.OrderByLinkedDateDesc();
			apt.ShowInfoLinkByProviderLinkType("Secondary").click();
			//verify in the grid cols and data for the new match
			Thread.sleep(3000);
			List<WebElement> cols = apt.ProviderTabGridCols();
			for(int i=1;i<=cols.size();i++)
			{
				Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'show_parent_provider')]//thead//th[" + i + "]")).getText(), providertabCols.get(i));
			}
			
			Assert.assertEquals(apt.ProviderNameFirstRowValue(), testData.get(1));
			//Assert.assertEquals(apt.ProviderFirstNameFirstRowValue(), testData.get(2));
			//Assert.assertEquals(apt.ProviderLastNameFirstRowValue(), testData.get(3));
			//Assert.assertEquals(apt.ProviderAddressFirstRowValue(), fullAddress);
			/*Assert.assertEquals(apt.ProviderPhoneFirstRowValue(), phoneNum[0]+phoneNum[1]+phoneNum[2]);
			Assert.assertEquals(apt.ProviderEmailFirstRowValue(), testData.get(17));
			Assert.assertEquals(apt.ProviderTypeFirstRowValue(), testData.get(12)); */
			Assert.assertEquals(apt.ProviderNPIFirstRowValue(), testData.get(4));
			/*Assert.assertEquals(apt.ProviderLinkTypeFirstRowValue(), ProviderLinkType);
			Assert.assertTrue(apt.ProviderLinkedDateFirstRowValue().contains(currentDate));
			Assert.assertEquals(apt.ProviderIDFirstRowValue(), testData.get(19));
		//	Assert.assertEquals(apt.ParentProviderIDFirstRowValue(), testData.get(20));
			Assert.assertTrue(apt.ProviderActionFirstRowValue().isDisplayed());*/
			
			
			
			if(apt.ProviderNPIFirstRowValue().equalsIgnoreCase(testData.get(4)))
			{
				TestBase.classAInstance.logReport("Pass","Match And Unlink Secondary Primary Provider With Patient","Succesfully able to  Verify Match And Unlink Secondary Primary Provider With Patient");
			}
			else
			{
				TestBase.classAInstance.logReport("Fail","Match And Unlink Secondary Primary Provider With Patient","Failed to  Verify Match And Unlink Secondary Primary Provider With Patient");
			}
			
			apt.VerifyUnlinkingProviderFromPatient(testData.get(4), testData.get(18), "Secondary");
			
			
			return true;
		}
		
		return false;
	}
	
	public boolean VerifyAbilityToMatchProviderWithPatientAndBOAvailableInTreatmentsTab(List<String> testData, String ProviderLinkType) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ProviderLinkTypeDropdown().selectByVisibleText(ProviderLinkType);//ProviderLinkType=Primary
		ProviderName().sendKeys(testData.get(1));
		Thread.sleep(1000);
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	            AutoSuggest().click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);
		
		AssignButton().click();
		if(PatientPhysicianMatchedConfirmationMsg().getText().equalsIgnoreCase(testData.get(14)))
		{
			//Now verify that the linked physician in the BO dropdown of Treatments tab
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			app.PatientsFindPageMemberID().sendKeys(testData.get(0));
			app.PatientsPageFindButton().click();
			wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(ppc.PatientAndCardTab()));
			
			//navigate to treatments tab
			atp.TreatmentsTabOption().click();
			Thread.sleep(10000);
			
			//verify the matched BO is displayed in the BO dropdown
			atp.SelectBillingProviderDropdown().click();
			Assert.assertEquals(atp.SelectBillingProviderDropdownFirstValidOption().getText(), testData.get(1));
			//select the BO
			atp.SelectBillingProviderDropdownFirstValidOption().click();
			
			Assert.assertEquals(atp.BillingNameValue(), testData.get(1));
			Assert.assertEquals(atp.ContactFirstNameValue(), testData.get(2));
			Assert.assertEquals(atp.ContactLastNameValue(), testData.get(3));
			Assert.assertEquals(atp.AddressValue(), testData.get(5));
			Assert.assertEquals(atp.CityValue(), testData.get(6));
			Assert.assertEquals(atp.StateValue(), testData.get(7));
			Assert.assertEquals(atp.ZipValue(), testData.get(8));
			//Assert.assertEquals(atp.PhoneNumberValue(), testData.get(9));
			//Assert.assertEquals(atp.FaxNumberValue(), testData.get(10));
			//Assert.assertEquals(atp.NPIValue(), testData.get(4));
			Assert.assertEquals(atp.ProviderIDValue(), testData.get(11));
			
			//reporting
			if(atp.BillingNameValue().equalsIgnoreCase(testData.get(1)))
		     {
		    	TestBase.classAInstance.logReport("Pass","Match Provider With Patient And BO Available In Treatments Tab","Succesfully able to  Verify Match Provider With Patient And BO Available In Treatments Tab");
		     }
		     else
		     {
		    	TestBase.classAInstance.logReport("Fail","Match Provider With Patient And BO Available In Treatments Tab", "Failed to Verify ability to match Provider With Patient And BO Available In Treatments Tab");
		     }
			
			return true;
		}
		
		return false;
	}
	
	public boolean VerifyAbilityToMatchProviderWithPatientAndGPAvailableInTreatmentsTab(List<String> testData, String ProviderLinkType) throws InterruptedException, IOException, AWTException
	{
	/*	String providerPracticeNameType = testData.get(1)+" / "+testData.get(12);
		String cityStateZip = testData.get(6)+", "+testData.get(7)+" "+testData.get(8);
		String fullAddress = testData.get(5)+"\n"+ testData.get(6)+","+testData.get(7)+" "+testData.get(8);
		String[] phoneNum = testData.get(9).split("-");
		
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString(); */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ProviderLinkTypeDropdown().selectByVisibleText(ProviderLinkType);//ProviderLinkType=Primary
		ProviderName().sendKeys(testData.get(1));
		Thread.sleep(1000);
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	            AutoSuggest().click();
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    Thread.sleep(2000);
		
		AssignButton().click();
		if(PatientPhysicianMatchedConfirmationMsg().getText().equalsIgnoreCase(testData.get(13)))
		{
			//Now verify that the linked physician in the BO dropdown of Treatments tab
			ahp.PatientsLink().click();
			ahp.FindLink().click();
			app.PatientsFindPageMemberID().sendKeys(testData.get(0));
			app.PatientsPageFindButton().click();
			wait.until(ExpectedConditions.visibilityOf(app.PatientsFindFirstReviewButton()));
			
			
			app.PatientsFindFirstReviewButton().click();
			wait.until(ExpectedConditions.visibilityOf(ppc.PatientAndCardTab()));
			
			//navigate to treatments tab
			atp.TreatmentsTabOption().click();
			Thread.sleep(10000);
			
			//verify the matched BO is displayed in the BO dropdown
			atp.SelectTreatingPracticeDropdown().click();
			Assert.assertEquals(atp.SelectTreatingPracticeDropdownFirstValidOption().getText(), testData.get(1));
			//select the BO
			atp.SelectTreatingPracticeDropdownFirstValidOption().click();
			
			Assert.assertEquals(atp.TreatingPracticeNameValue(), testData.get(1));
			Assert.assertEquals(atp.TreatingAddressValue(), testData.get(2));
			Assert.assertEquals(atp.TreatingCityValue(), testData.get(3));
			Assert.assertEquals(atp.TreatingStateValue(), testData.get(4));
			Assert.assertEquals(atp.TreatingZipValue().substring(0, 5), testData.get(5));
			Assert.assertEquals(atp.TreatingPhoneNumberValue(), testData.get(6));
			Assert.assertEquals(atp.TreatingFaxNumberValue(), testData.get(7));
			Assert.assertEquals(atp.TreatingTaxNumberValue(), testData.get(8));
			Assert.assertEquals(atp.TreatingNPIValue(), testData.get(9));
			Assert.assertEquals(atp.TreatingProviderIDValue(), testData.get(10));
			
			//reporting
			if(atp.TreatingPracticeNameValue().equalsIgnoreCase(testData.get(1)))
		     {
				js.executeScript("window.scrollBy(0,1080)", "");
		    	TestBase.classAInstance.logReport("Pass","Match Provider With Patient And GP Available In Treatments Tab","Succesfully able to  Verify Match Provider With Patient And GP Available In Treatments Tab");
		     }
		     else
		     {
				 js.executeScript("window.scrollBy(0,1080)", "");
		    	TestBase.classAInstance.logReport("Fail","Match Provider With Patient And GP Available In Treatments Tab", "Failed to Verify ability to match Provider With Patient And GP Available In Treatments Tab");
		     }
			
			return true;
		}
		
		return false;
	}
	
	
	
}
