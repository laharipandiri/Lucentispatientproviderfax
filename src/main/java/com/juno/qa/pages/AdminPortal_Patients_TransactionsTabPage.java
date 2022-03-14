package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;


public class AdminPortal_Patients_TransactionsTabPage extends TestBase {

	public AdminPortal_Patients_TransactionsTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement TransactionsTab()
	{
		return driver.findElement(By.linkText("Transactions"));
	}
	
	public Select Pagination()
	{
		Select Pagination = new Select(driver.findElement(By.xpath("//*[@id='patient-transaction-list_length']/label/select")));
		return Pagination;
	}
	
	
	public WebElement RefreshDataLink()
	{
		return driver.findElement(By.id("RefreshData"));
	}
	
	public List<WebElement> TrasnactionsTabGridRows()
	{
		return driver.findElements(By.xpath("//table[@id='report']/tbody/tr"));
	}
	
	public WebElement ShowTransactionDetailLatestRowLink()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]"));//updated 10272021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[14]"));
	}
	
	public WebElement ShowProviderLatestRowLink()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[14]")); //updated 10272021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[12]"));
		
	}
	
	public WebElement ShowPatientLatestRowLink()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[15]")); //updated 10272021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[13]"));
		
	}
	
	public WebElement GetTransactionDetailClaimTypeStatusValueForFirstRow()
	{
	//	return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[2]")); //updated 10272021
		return driver.findElement(By.xpath("//*[@id='show_trans_detail_0']/table/tbody/tr/td[2]"));
		
	}
	
	public String CardIDValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[1]")).getText(); //updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[1]")).getText();
		
	}
	
	public String TransactionIDValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[2]")).getText();//updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[2]")).getText();
	}
	
	
	
	public String AmountInDollarValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[3]")).getText();//updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[3]")).getText();
	}
	
	public String OriginalAmountInDollarValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[4]")).getText(); //updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[4]")).getText();
	}
	
	public String DateAndTimeValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[5]")).getText();//updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[5]")).getText();
	}
	
	
	public String UseCountValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[6]")).getText();//updated 10262021
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[5]")).getText();
	}
	
	public String DaysElapsedValueFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[7]")).getText();
	}
	
	
	public String CardTypeValueFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[8]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[7]")).getText();
	}
	
	public String TransactionTypeValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[9]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[8]")).getText();
	}
	
	
	public String PaymentTypeValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[10]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[9]")).getText();
	}
	
	public String TreatmentIDValueFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[11]")).getText();
	}
	
	
	public String StatusValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[12]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[10]")).getText();
	}
	
	public String RefundValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[13]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[11]")).getText();
	}
	
	public WebElement ProviderValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[14]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[12]"));
	}
	
	
	public WebElement PatientValueFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[15]")).getText();
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[13]"));
	}
	
	public WebElement GetTransactionDetailStatusValueForFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[5]"));
		return driver.findElement(By.xpath("//table[@id='patient-transaction-list']/tbody/tr[1]/td[14]"));
	}
	
	public WebElement GetTransactionDetailAmountValueForFirstRow()
	{
//		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[6]"));
		return driver.findElement(By.xpath("//*[@id='show_trans_detail_0']/table/tbody/tr/td[7]"));
	}
	
	public WebElement GetTransactionDetailClaimTypeIDValueForFirstRow()
	{
		//return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[1]")); //updated 10272021
		return driver.findElement(By.xpath("//*[@id='show_trans_detail_0']/table/tbody/tr/td[1]"));
		
		
	}
	
	public WebElement GetTransactionDetailClaimTypeTraceNumValueForFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[3]"));
	}
	
	public WebElement GetTransactionDetailDateValueForFirstRow()
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr[1]/td[16]/table/tbody/tr[2]/td[4]"));
	}
	
	public String CardIDValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[1]")).getText();
	}
	
	public String TransactionIDValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String AmountInDollarValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[3]")).getText();
	}
	
	public String OriginalAmountInDollarValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public String DateAndTimeValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[5]")).getText();
	}
	
	
	public String UseCountValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[6]")).getText();
	}
	
	public String DaysElapsedValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[7]")).getText();
	}
	
	
	public String CardTypeValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[8]")).getText();
	}
	
	public String TransactionTypeValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[9]")).getText();
	}
	
	
	public String PaymentTypeValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[10]")).getText();
	}
	
	public String TreatmentIDValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[11]")).getText();
	}
	
	
	public String StatusValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[12]")).getText();
	}
	
	public String RefundValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[13]")).getText();
	}
	
	public String ProviderValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[14]")).getText();
	}
	
	
	public String PatientValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[15]")).getText();
	}
	
	public WebElement GetTransactionDetailStatusValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[16]/table/tbody/tr[2]/td[5]"));
	}
	
	public WebElement GetTransactionDetailAmountValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[16]/table/tbody/tr[2]/td[6]"));
	}
	
	public WebElement GetTransactionDetailClaimTypeIDValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[16]/table/tbody/tr[2]/td[1]"));
	}
	
	public WebElement GetTransactionDetailClaimTypeTraceNumValueForFirstRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[16]/table/tbody/tr[2]/td[3]"));
	}
	
	public WebElement GetTransactionDetailDateValueRow(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[16]/table/tbody/tr[2]/td[4]"));
	}
	
	public WebElement ShowPatientLink(int i)
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+i+"]/td[15]"));
	}
	
	public String AmountInDollarValueLatestRow()
	{
		return driver.findElement(By.xpath("//table[@id='report']/tbody/tr["+TrasnactionsTabGridRows().size() +"]/td[3]")).getText();
	}

	public boolean VerifyTransactionsTabAfterRepayment(List<String> testData, List<String> testData1, String currentDate) throws InterruptedException
	{
		boolean verify = true;
		if(verify)
		{
			for(int i=1; i<=TrasnactionsTabGridRows().size(); i++)
		    {
		    	if(TransactionIDValueRow(i).equalsIgnoreCase(testData1.get(3)))
		    	{
		    		//now verify the rest of the cols in this ith row
		    		Assert.assertEquals(CardIDValueRow(i), testData.get(1));
		    		Assert.assertEquals(AmountInDollarValueRow(i), "$0.00");
		    		String originalAmountInDollars = "$-"+testData.get(3)+"0";
		    		Assert.assertEquals(OriginalAmountInDollarValueRow(i), originalAmountInDollars);
		    		Assert.assertTrue(DateAndTimeValueRow(i).contains(currentDate));
		    		Assert.assertEquals(TransactionTypeValueRow(i), testData.get(15));
		    		Assert.assertEquals(PaymentTypeValueRow(i), testData.get(16));
		    		Assert.assertEquals(StatusValueRow(i), "Processed");
		    		ShowPatientLink(i).click();
		    		Thread.sleep(2000);
		    		Assert.assertEquals(PatientValueRow(i), testData.get(29));
		    		
		    	}
		    	
		    }
		    
		  //verify that the amount in $ is also deducted for the original transaction
		    for(int i=1; i<=TrasnactionsTabGridRows().size(); i++)
		    {
		    	if(TransactionIDValueRow(i).equalsIgnoreCase(testData.get(2)))
		    	{
		    		Assert.assertTrue(AmountInDollarValueRow(i).contains(testData1.get(2)));
		    	}
		    }
		    
		    return verify;
		}
		verify = false;
		return verify;
		
	
	}
	
	
	
	
	
	
	
}
