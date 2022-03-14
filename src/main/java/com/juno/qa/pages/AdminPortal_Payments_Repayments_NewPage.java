package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Payments_Repayments_NewPage extends TestBase {
	
	public AdminPortal_Payments_Repayments_NewPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* **************** Repayment Information Section ********************** */
	public Select ProgramNameDropdown()
	{
		Select programList = new Select(driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr/td/table/tbody/tr[2]/td[2]/select[@id='program']")));
		return programList;
	}
	
	public WebElement CheckNum()
	{
		return driver.findElement(By.name("check_num"));
	}
	
	public WebElement CardNumAutoSuggest()
	{
		return driver.findElement(By.id("patient_search"));
	}
	
	public WebElement Amount()
	{
		return driver.findElement(By.name("amount"));
	}
	
	public WebElement CheckDate()
	{
		return driver.findElement(By.name("check_cut_date"));
	}
	
	public Select PaymentStatus()
	{
		Select paymentStatus = new Select(driver.findElement(By.name("payment_status")));
		return paymentStatus;
	}
	
	public Select CheckStatus()
	{
		Select checkStatus = new Select(driver.findElement(By.name("check_status")));
		return checkStatus;
	}
	
	public WebElement RequestDate()
	{
		return driver.findElement(By.name("request_date"));
	}
	
	public WebElement RepaymentDate()
	{
		return driver.findElement(By.name("repayment_date"));
	}
	
	public WebElement SentDate()
	{
		return driver.findElement(By.name("repayment_sent_dt"));
	}
	
	/* ********************* Payment Information Section *********************** */
	
	public WebElement CardNum()
	{
		return driver.findElement(By.name("patient_short_card_id"));
	}
	
	public WebElement FindTreatmentLink()
	{
		return driver.findElement(By.name("find_treatments"));
	}
	
	public WebElement FirstName()
	{
		return driver.findElement(By.name("patient_first_name"));
	}
	
	public WebElement LastName()
	{
		return driver.findElement(By.name("patient_last_name"));
	}
	
	public WebElement Email()
	{
		return driver.findElement(By.name("patient_email_address"));
	}
	
	public Select StateDropdown()
	{
		Select statesList = new Select(driver.findElement(By.id("patient_state")));
		return statesList;
	}
	
	public WebElement Notes()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/textarea"));
	}
	
	/* ********************* Provider Information Section *********************** */
	
	public WebElement ProviderName()
	{
		return driver.findElement(By.name("provider_name"));
	}
	
	public WebElement ProviderNameAutoSuggest()
	{
		return driver.findElement(By.id("provider_search"));
	}
	
	public WebElement ProviderFirstName()
	{
		return driver.findElement(By.name("provider_first_name"));
	}
	
	public WebElement ProviderLastName()
	{
		return driver.findElement(By.name("provider_last_name"));
	}
	
	public WebElement Address()
	{
		return driver.findElement(By.name("provider_address_1"));
	}
	
	public WebElement Address2()
	{
		return driver.findElement(By.name("provider_address_2"));
	}
	
	public WebElement City()
	{
		return driver.findElement(By.name("provider_city"));
	}
	
	public WebElement Zip()
	{
		return driver.findElement(By.name("provider_zip"));
	}
	
	public WebElement NPI()
	{
		return driver.findElement(By.name("provider_npi"));
	}
	
	public WebElement Phone()
	{
		return driver.findElement(By.name("provider_phone_number"));
	}
	
	public Select ProviderStateDropdown()
	{
		Select statesList = new Select(driver.findElement(By.id("provider_state")));
		return statesList;
	}
	
	public WebElement AddButton()
	{
		return driver.findElement(By.name("add_update"));
	}
	
	public WebElement AddConfirmationMsgFirstLine()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[4]/td/font"));
	}
	
	public WebElement AddConfirmationMsgSecondLine()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[4]/td[1]/font/br[1]"));
	}
	
	public WebElement AddConfirmationMsgThirdLine()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[4]/td/font/br[2]"));
	}
	
	/* ***********************************  Treatments & Transactions ****************************************** */
	
	public List<WebElement> TreatmentsTransactionsCols()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/thead/tr/th"));
	}
	
	public List<WebElement> TreatmentsTransactionsColNames(int i)
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> TreatmentsTransactionsRows()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr"));
	}
	
	public WebElement TransactionIDRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[1]"));
	}
	
	public WebElement AmountInDollarsRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[2]/input"));
	}
	
	public WebElement DateAndTimeRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[3]"));
	}
	
	public WebElement UseCountRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[4]"));
	}
	
	public WebElement DaysElapsedRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[5]"));
	}
	
	public WebElement BenefitPeriodRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[6]"));
	}
	
	public WebElement TransactionTypeRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[7]"));
	}
	
	public WebElement PaymentTypeRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[8]"));
	}
	
	public WebElement StatusRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[9]"));
	}
	
	public WebElement CheckboxRow(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/form/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[10]/input[1]"));
	}
	
	public double AddRepayment(List<String> testData) throws InterruptedException
	{
		//verify that the card# of the patient is automatically populated
				Assert.assertEquals(CardNum().getAttribute("value"), testData.get(1));
				Thread.sleep(2000);
				Assert.assertTrue(CardNumAutoSuggest().isDisplayed());
				
				//click on Find treatments link
				CardNumAutoSuggest().click();
				//now click on find treatments link
				FindTreatmentLink().click();
				Thread.sleep(3000);
				double claimAmount = 0.0;
				
				for(int i=1; i<=TreatmentsTransactionsRows().size(); i++)
				{
					if(TransactionIDRow(i).getText().equalsIgnoreCase(testData.get(2)))
					{
						//change the amount to the amount to be refunded
						claimAmount = Double.parseDouble(AmountInDollarsRow(i).getAttribute("value"));
						AmountInDollarsRow(i).clear();
						AmountInDollarsRow(i).sendKeys(testData.get(3));
						CheckboxRow(i).click();
						
						
					}
				}
				
				CheckNum().sendKeys(testData.get(4));
				Amount().sendKeys(testData.get(3));
				PaymentStatus().selectByVisibleText(testData.get(5));
				CheckStatus().selectByVisibleText(testData.get(6));
				
				Notes().sendKeys(testData.get(7));
				ProviderName().sendKeys(testData.get(8));
				Thread.sleep(2000);
				int attempts = 0;
			    while(attempts < 2) {
			        try {
			        	ProviderNameAutoSuggest().click();
			            break;
			        } catch(org.openqa.selenium.StaleElementReferenceException e) {
			        }
			        attempts++;
			    }
			//	prn.ProviderNameAutoSuggest().click();
				AddButton().click();
				Thread.sleep(3000);
				
				return claimAmount;
	}
	
	
	
	
	
}
