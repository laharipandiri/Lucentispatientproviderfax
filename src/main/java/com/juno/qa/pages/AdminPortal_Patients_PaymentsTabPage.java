package com.juno.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_PaymentsTabPage extends TestBase {
	
	AdminPortal_Payments_Repayments_ListPage prl = new AdminPortal_Payments_Repayments_ListPage();

	public AdminPortal_Patients_PaymentsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PaymentsTab()
	{
		return driver.findElement(By.xpath("//*[@id='tab_button_5']/a"));
		//return driver.findElement(By.xpath("//div[@class='form-container']/div[2]/div/ul/li[6]/a"));
	}
	
	public WebElement CardReplacement()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_5']/div[1]/table/thead/tr/td[1]/font/strong")); updated on 8/7/2021
		return driver.findElement(By.xpath("//*[@id='showrepaymentrow']"));
	}
	
	public WebElement EFTPayment()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_5']/div[3]/table/thead/tr/td[1]/font/strong")); updated on 8/7/2021
		return driver.findElement(By.xpath("//*[@id='showeftrow']"));
	}
	
	public WebElement CheckPaymentInformation()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_5']/div[3]/table/thead/tr/td[1]/font/strong")); updated on 8/7/2021
		return driver.findElement(By.xpath("//*[@id='showcheckrow']"));
	}
	
	public WebElement DEBITCARDPaymentInformation()
	{
		//return driver.findElement(By.xpath("//*[@id='tab_5']/div[4]/table[2]/thead/tr/td[1]/font/strong")); updated on 8/7/2021
		return driver.findElement(By.xpath("//*[@id='showdebitrow']"));
	
	}
	public WebElement RepaymentCard()
	{
		return driver.findElement(By.name("RepaymentCard"));
	}
	
	public WebElement RepaymentCardInfo()
	{
		return driver.findElement(By.xpath("//*[@id='repaymentadd']/div/table/tbody/tr[1]/td[1]/table/tbody/tr[1]/th/strong"));
	}
	
	public WebElement RepaymentCardPaymentInfo()
	{
		return driver.findElement(By.xpath("//*[@id='repaymentadd']/div/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/th/strong"));
	}
	public WebElement RepaymentCardProviderInfo()
	{
		return driver.findElement(By.xpath("//*[@id='repaymentadd']/div/table/tbody/tr[1]/td[3]/table/tbody/tr[1]/th/strong"));
	}
	
	public WebElement RepaymentCardAddUpdate()
	{
		return driver.findElement(By.name("add_update"));
	}
	
	
	public List<WebElement> CheckPaymentInformationGridRows()
	{
		return driver.findElements(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr"));
	}
	
	public WebElement ClaimStatusLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[2]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[2]"));
	}
	
	public WebElement CheckTraceNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[3]"));
	}
	
	public WebElement CheckStatusLatestRow()
	{
//		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[7]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[7]"));
	}
	public WebElement ShowCheckPayments()
	{
		return driver.findElement(By.xpath("//*[@id='showcheckrow']"));
	}
	
	
	public WebElement ClaimIDLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[1]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[1]"));
		
	}
	
	public WebElement CheckNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[3]"));
	}
	
	public WebElement AmountLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[4]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[4]"));
	}
	
	public WebElement CheckDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[5]"));
	}
	
	public WebElement SentDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[6]"));
	}
	
	public WebElement PaidToLatestRow()
	{
//		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[8]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[8]"));
	}
	
	public WebElement FaxIDLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[9]")); updated 10312021
		return driver.findElement(By.xpath("//*[@id='check-list']/tbody/tr[1]/td[9]"));
	}
	
	public WebElement NotesLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[10]"));
	}
	
	public WebElement ActionLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tab_5']/div[4]/table/tbody/tr[1]/td[11]"));
	}
	
	/* ********************************************************* Repayments ****************************************************************** */
	
	public WebElement RepaymentsLink()
	{
		return driver.findElement(By.xpath("//input[@name = 'ReplaceCard']"));
	}
	
	/* ***************** Card Repyaments Rows ****************** */
	public List<WebElement> CardRepaymentsCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/thead/tr/th"));
	}
	
	public List<WebElement> CardRepaymentsColNames(int i)
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public List<WebElement> CardRepaymentsRows()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr"));
	} 
	
	public WebElement RepaymentsCardIDLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[1]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[2]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentsAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[3]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentsProviderNameLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[4]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentsCheckNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[5]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentCheckDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[6]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentsNotesLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[7]"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public WebElement RepaymentsActionReviewLinkLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+(CardRepaymentsRows().size()-1)+"]/td[8]/form/input[@name='review']"));
		//we need to consider size-1, because this col holds value in the last but one row of the parent repayments table
	}
	
	public List<WebElement> RepaymentsSubTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/thead/tr/th"));
	}
	
	public List<WebElement> RepaymentsSubTableColNames(int i)
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/thead/tr/th["+i+"]"));
	}
	
	public WebElement RefundNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[1]"));
	}
	
	public WebElement PaymentNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[2]"));
	}
	
	public WebElement RefundTransactionNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[3]"));
	}
	
	public WebElement OriginalTransactionNumLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[4]"));
	}
	
	public WebElement TotalRefundAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[5]"));
	}
	
	public WebElement DistributedAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[6]"));
	}
	
	public WebElement RefundAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[7]"));
	}
	
	public WebElement OriginalTransactionAmountLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[8]"));
	}
	
	public WebElement TransactionAmountLeftLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[9]"));
	}
	
	public WebElement TransactionWipedLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[10]"));
	}
	
	public WebElement CreatedByLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[11]"));
	}
	
	public WebElement CreatedDateLatestRow()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[8][@id='tab_5']/div[2]/table/tbody/tr["+CardRepaymentsRows().size()+"]/td[1]/table/tbody/tr/td[12]"));
	}
	
	public boolean VerifyPaymentsTabAfterRepayment(List<String> testData, List<String> testData1, String currentDate) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			Assert.assertEquals(RepaymentsCardIDLatestRow().getText(), testData.get(1));
			Assert.assertTrue(RepaymentDateLatestRow().getText().contains(currentDate));
			Assert.assertTrue(RepaymentsAmountLatestRow().getText().contains(testData.get(3)));
			Assert.assertTrue(RepaymentsProviderNameLatestRow().getText().contains(testData.get(8)));
			Assert.assertEquals(RepaymentsCheckNumLatestRow().getText(), testData.get(4));
			Assert.assertTrue(RepaymentCheckDateLatestRow().getText().contains(currentDate));
			Assert.assertEquals(RepaymentsNotesLatestRow().getText(), testData.get(7));
			
			Assert.assertEquals(RefundNumLatestRow().getText(), testData1.get(1));
			Assert.assertEquals(PaymentNumLatestRow().getText(), testData1.get(0));
			Assert.assertEquals(OriginalTransactionNumLatestRow().getText(), testData.get(2));
			Assert.assertTrue(TotalRefundAmountLatestRow().getText().contains(testData.get(3)));
			Assert.assertTrue(DistributedAmountLatestRow().getText().contains(testData.get(3)));
			Assert.assertTrue(RefundAmountLatestRow().getText().contains(testData.get(3)));
			Assert.assertTrue(OriginalTransactionAmountLatestRow().getText().contains(testData.get(12)));
			Assert.assertTrue(TransactionAmountLeftLatestRow().getText().contains(testData1.get(2)));
			Assert.assertEquals(TransactionWipedLatestRow().getText(), testData.get(13));
			Assert.assertEquals(CreatedByLatestRow().getText(), testData.get(14));
			Assert.assertTrue(CreatedDateLatestRow().getText().contains(currentDate));
			
			//verify clicking on review link
			RepaymentsActionReviewLinkLatestRow().click();
			Thread.sleep(5000);
			Assert.assertTrue(prl.VerifyReviewLink(testData));
			
			return verify;
		}
		
		verify = false;
		return verify;
	}

}
