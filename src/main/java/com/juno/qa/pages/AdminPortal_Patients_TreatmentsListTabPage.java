package com.juno.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class AdminPortal_Patients_TreatmentsListTabPage extends TestBase {
	
	public AdminPortal_Patients_TreatmentsListTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement TreatmentsListTab()
	{
		return driver.findElement(By.linkText("Treatment List"));
	}
	
	public WebElement TreatmentsListShowTreatmentInfo()
	{
		return driver.findElement(By.xpath("//*[@id='treatmentrowid']"));
	}
	public WebElement TreatmentsListCancelTreatment()
	{
		return driver.findElement(By.xpath("//*[@id='treatments-list']/tbody/tr[1]/td[15]")); 
	}
	
	public WebElement TreatmentsListReasonForHold()
	{
		return driver.findElement(By.xpath("//*[@id='treatments-list']/tbody/tr[2]/td[13]"));  
	} 
	public WebElement TreatmentsListGKRejectReason()
	{
		return driver.findElement(By.xpath("//*[@id='treatments-list']/tbody/tr[3]/td[13]"));  
	} 
	
	public WebElement TreatmentsListReprocesWithGKByPass()
	{
		return driver.findElement(By.xpath("//*[@id='HT168508']"));   
	} 
	
	public WebElement TreatmentsListReprocesWithGK()
	{
		return driver.findElement(By.xpath("//*[@id='168508']"));    
	} 
	
	public WebElement TreatmentsListReprocesWithGKByPassNote()
	{
		return driver.findElement(By.name("notes_168508"));   
	} 
	
	public WebElement TreatmentsListReprocesWithGKByPassSubmit()
	{
		return driver.findElement(By.name("override_treatment"));   
	} 
	public WebElement TreatmentsListReprocesWithGKByPassConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='tab_12']/div[1]/h4/font[2]"));
	} 
	
	
	
	public WebElement TreatmentsListCancelTreatmentConfirmation()
	{
		return driver.findElement(By.xpath("//*[@id='tab_12']/div[1]/h4"));
	}
	
	
	public WebElement TreatmentsListEDITreatmentInfo()
	{
		return driver.findElement(By.xpath("//*[@id='editreatmentrowid']"));
	}
	
	
	
	public String ManualTreatmentInformationLabel()
	{
		return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[1]/table/tbody/tr/td/font/strong")).getText();
	}
	
	public List<WebElement> ManualTreatmentInformationTableCols()
	{
		return driver.findElements(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/thead/tr/th"));
	}
	
	public List<WebElement> ManualTreatmentInformationTableRows()
	{
		return driver.findElements(By.xpath("//table[@id='sortTable1']/tbody/tr"));
	}
	
	
	public WebElement TreatmentTabTable()
	{
		return driver.findElement(By.xpath("//table[@id='treatments-list']/tbody/tr[2]/td[13]"));
	}
	
	public WebElement MTCardNumColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[1]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[1]"));
	}
	
	public WebElement MTTreatmentIDColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[2]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[2]"));
	}
	
	public WebElement MTTreatmentIDColLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[3]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[2]"));
	}
	
	public WebElement MTClaimIDColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[3]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[3]"));
	}
	
	public WebElement MTClaimIDColLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[3]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[3]"));
	}
	
	public WebElement MTTreatmentNotesColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[4]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[4]"));
	}
	
	public WebElement MTClaimNotesColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[5]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[5]"));
	}
	
	public WebElement MTClaimInfoColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[6]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[6]"));
	}
	//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[11]
	
	public WebElement MTEOBInfoColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[7]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[7]"));
	}
	
	public WebElement MTDOBColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[8]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[8]"));
	}
	
	public WebElement MTBillingInfoColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[9]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[9]"));
	}
	
	public WebElement MTAmountRequestedColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[10]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[10]"));
	}
	
	public WebElement MTAmountLoadedColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[11]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[11]"));
	}
	
	public WebElement MTAmountLoadedColLatestRow()
	{
		return driver.findElement(By.xpath("//table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[11]"));
	}
	
	public WebElement MTBalanceColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[12]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[12]"));
	}
	
	public WebElement MTAcceptedDateColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[13]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[13]"));
	}
	
	public WebElement MTStatusColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[14]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[14]"));
	}
	
	public WebElement MTStatusColLatestRow()
	{
		return driver.findElement(By.xpath("//table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[14]"));
	}
	
	public WebElement MTCopayRequiredColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[15]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[15]"));
	}
	
	public WebElement MTRequestedByColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[16]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[16]"));
	}
	
	public WebElement MTLoadIDColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[17]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[17]"));
	}
	
	public WebElement MTLoadIDColLatestRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[3]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[17]"));
	}
	
	public WebElement MTLoadStatusColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[18]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[18]"));
	}
	
	public WebElement MTLoadProcessedDateColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[19]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[19]"));
	}
	
	public WebElement MTAcceptedByColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[20]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[20]"));
	}
	
	public WebElement MTReasonForHoldColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[21]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[21]"));
	}
	
	public WebElement MTReasonForHoldColLatestRow()
	{
		return driver.findElement(By.xpath("//table[@id='sortTable1']/tbody/tr["+ManualTreatmentInformationTableRows().size()+"]/td[21]"));
	}
	
	public WebElement MTBackendCodeColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[22]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[22]"));
	}
	
	public WebElement MTLoadNotesColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[23]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[23]"));
	}
	
	public WebElement MTFaxResponseTypeColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[25]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[25]"));
	}
	
	public WebElement MTPayerColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[26]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[26]"));
	}
	
	public WebElement MTActionColFirstRow()
	{
		//return driver.findElement(By.xpath("//div[@id='patient_treatment_requests']/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[27]"));
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[6]/div[2]/table[@id='sortTable1']/tbody/tr[1]/td[27]"));
	}

}
