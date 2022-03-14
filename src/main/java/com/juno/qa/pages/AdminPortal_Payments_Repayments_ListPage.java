package com.juno.qa.pages;

import java.time.LocalDate;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Payments_Repayments_ListPage extends TestBase {
	
	AdminPortal_Payments_Repayments_NewPage prn = new AdminPortal_Payments_Repayments_NewPage();
	
	public AdminPortal_Payments_Repayments_ListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Select ProgramNameDropdown()
	{
		Select programList = new Select(driver.findElement(By.xpath("//div[@class='form-container']/div/div/fieldset/form/table/tbody/tr[1]/td[2]/select[@id='program']")));
		return programList;
	}
	
	public WebElement FromRequestDate()
	{
		return driver.findElement(By.name("request_from_date"));
	}
	
	public WebElement ToRequestDate()
	{
		return driver.findElement(By.name("request_to_date"));
	}
	
	public WebElement FromIssueDate()
	{
		return driver.findElement(By.name("issue_from_date"));
	}
	
	public WebElement ToIssueDate()
	{
		return driver.findElement(By.name("issue_to_date"));
	}
	
	public WebElement FromSentDate()
	{
		return driver.findElement(By.name("sent_from_date"));
	}
	
	public WebElement ToSentDate()
	{
		return driver.findElement(By.name("sent_to_date"));
	}
	
	public WebElement CheckNum()
	{
		return driver.findElement(By.name("check_num"));
	}
	
	public Select PaymentStatus()
	{
		Select status = new Select(driver.findElement(By.name("payment_status_id")));
		return status;
	}
	
	public WebElement CardID()
	{
		return driver.findElement(By.name("short_card_id"));
	}
	
	public WebElement FindButton()
	{
		return driver.findElement(By.name("find"));
	}
	
	public List<WebElement> RepaymentsListCols()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/div[3]/table/thead/tr/th"));
	}
	
	public WebElement RepaymentsListColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> RepaymentsListRows()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr"));
	}
	
	public WebElement TotalProvidersLabelWithCount()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[2]/table/tbody/tr[1]/td[2]"));
	}
	
	public WebElement CheckNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[1]"));
	}
	
	public WebElement AmountNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[2]"));
	}
	
	public WebElement CardIDLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[3]"));
	}
	
	public WebElement ReqDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[4]"));
	}
	
	public WebElement CheckDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[5]"));
	}
	
	public WebElement RepaymentDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[6]"));
	}
	
	public WebElement SentToTMGLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[7]"));
	}
	
	public WebElement DateSentLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[8]"));
	}
	
	public WebElement CheckStatusLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[9]"));
	}
	
	public WebElement PracticeInfoLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[10]"));
	}
	
	public WebElement FaxIDLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[11]"));
	}
	
	public WebElement NotesLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[12]/textarea"));
	}
	
	public WebElement ActionLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+RepaymentsListRows().size()+"]/td[13]/form/input[@name='review']"));
	}
	
	/* ************* Subtable rows & cols ***************** */
	
	public List<WebElement> RepaymentsListSubTableLatestRowCols()
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/thead/tr/th"));
	}
	
	public List<WebElement> RepaymentsListSubTableLatestRowColNames(int i)
	{
		return driver.findElements(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/thead/tr/th["+i+"]"));
	}

	
	public WebElement RefundNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[1]"));
	}
	
	public WebElement PaymentNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[2]"));
	}
	
	public WebElement RefundTransactionNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[3]"));
	}
	
	public WebElement TotalRefundAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[4]"));
	}
	
	public WebElement DistributedAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[5]"));
	}
	
	public WebElement TransactionNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[6]"));
	}
	
	public WebElement RefundAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[7]"));
	}
	
	public WebElement TransactionAmountLeftLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[8]"));
	}
	
	public WebElement TransactionOriginalAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[9]"));
	}
	
	public WebElement TransactionWipedLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[10]"));
	}
	
	public WebElement CreatedByLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[11]"));
	}
	
	public WebElement CreatedDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@class='form-container']/div/div[3]/table/tbody/tr["+(RepaymentsListRows().size()/2)+"]/td/table/tbody/tr[1]/td[12]"));
	}
	
	public boolean VerifyReviewLink(List<String> testData)
	{
		LocalDate todayDate = java.time.LocalDate.now(); 
		String currentDate = todayDate.toString();

		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(prn.ProgramNameDropdown().getFirstSelectedOption().getText(), testData.get(17));
			Assert.assertEquals(prn.CheckNum().getAttribute("value"), testData.get(4));
			Assert.assertTrue(prn.Amount().getAttribute("value").contains(testData.get(3)));
			Assert.assertTrue(prn.CheckDate().getAttribute("value").contains(currentDate));
			Assert.assertEquals(prn.PaymentStatus().getFirstSelectedOption().getText(), testData.get(5));
			Assert.assertEquals(prn.CheckStatus().getFirstSelectedOption().getText(), testData.get(6));
			Assert.assertTrue(prn.RequestDate().getAttribute("value").contains(currentDate));
			Assert.assertTrue(prn.RepaymentDate().getAttribute("value").contains(currentDate));
			Assert.assertTrue(prn.SentDate().getAttribute("value").contains(currentDate));
			Assert.assertEquals(prn.CardNum().getAttribute("value"), testData.get(1));
			Assert.assertEquals(prn.FirstName().getAttribute("value"), testData.get(18));
			Assert.assertEquals(prn.LastName().getAttribute("value"), testData.get(19));
			Assert.assertEquals(prn.StateDropdown().getFirstSelectedOption().getText(), testData.get(20));
			Assert.assertEquals(prn.Notes().getAttribute("value"), testData.get(7));
			Assert.assertEquals(prn.ProviderName().getAttribute("value"), testData.get(8));
			Assert.assertEquals(prn.ProviderFirstName().getAttribute("value"), testData.get(21));
			Assert.assertEquals(prn.ProviderLastName().getAttribute("value"), testData.get(22));
			Assert.assertEquals(prn.Address().getAttribute("value"), testData.get(23));
			Assert.assertEquals(prn.City().getAttribute("value"), testData.get(24));
			Assert.assertEquals(prn.ProviderStateDropdown().getFirstSelectedOption().getText(), testData.get(25));
			Assert.assertEquals(prn.Zip().getAttribute("value").substring(0, 5), testData.get(26));
			Assert.assertEquals(prn.NPI().getAttribute("value"), testData.get(27));
			Assert.assertEquals(prn.Phone().getAttribute("value"), testData.get(28));
			
			
			
			
			return verify;
		}
		
		verify= false;
		return verify;
	}
	
	public boolean VerifyRepaymentsListAfterRepayment(List<String> testData, List<String> testData1, String currentDate) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			
		    CardID().sendKeys(testData.get(1));
		    FindButton().click();
		    Thread.sleep(5000);
		    
		    Assert.assertEquals(CheckNumLatestRow().getText(), testData.get(4));
		    Assert.assertTrue(AmountNumLatestRow().getText().contains(testData.get(3)));
		    Assert.assertEquals(CardIDLatestRow().getText(), testData.get(1));
		    Assert.assertTrue(ReqDateLatestRow().getText().contains(currentDate));
		    Assert.assertTrue(CheckDateLatestRow().getText().contains(currentDate));
		    Assert.assertTrue(RepaymentDateLatestRow().getText().contains(currentDate));
		    Assert.assertTrue(DateSentLatestRow().getText().contains(currentDate));
		    Assert.assertEquals(CheckStatusLatestRow().getText(), testData.get(6));
		    Assert.assertEquals(PracticeInfoLatestRow().getText(), testData.get(8));
		    Assert.assertEquals(NotesLatestRow().getText(), testData.get(7));
		    
		    Assert.assertEquals(RefundNumLatestRow().getText(), testData1.get(1));
		    Assert.assertEquals(PaymentNumLatestRow().getText(), testData1.get(0));
		    Assert.assertEquals(RefundTransactionNumLatestRow().getText(), testData1.get(3));
		    Assert.assertTrue(TotalRefundAmountLatestRow().getText().contains(testData.get(3)));
		    Assert.assertTrue(DistributedAmountLatestRow().getText().contains(testData.get(3)));
		    Assert.assertEquals(TransactionNumLatestRow().getText(), testData.get(2));
		    Assert.assertTrue(RefundAmountLatestRow().getText().contains(testData.get(3)));
		    Assert.assertTrue(TransactionAmountLeftLatestRow().getText().contains(testData1.get(2)));
		    Assert.assertTrue(TransactionOriginalAmountLatestRow().getText().contains(testData.get(12)));
		    Assert.assertEquals(TransactionWipedLatestRow().getText(), testData.get(13));
		    Assert.assertEquals(CreatedByLatestRow().getText(), testData.get(14));
			Assert.assertTrue(CreatedDateLatestRow().getText().contains(currentDate));
		    
		    
		    //click on reviews in payments tab and in repayments list page
			//verify clicking on review link
			ActionLatestRow().click();
			Thread.sleep(5000);
			Assert.assertTrue(VerifyReviewLink(testData));
			
			
			
			
			return verify;
		}
		
		verify = false;
		return verify;
	}
	

}
