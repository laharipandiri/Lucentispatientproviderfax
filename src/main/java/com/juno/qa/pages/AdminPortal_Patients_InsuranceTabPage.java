package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;
import com.juno.qa.util.CommonFunctions;
import com.juno.qa.util.TestUtil;

public class AdminPortal_Patients_InsuranceTabPage extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	AdminPortalLoginLogoutPage alp = new AdminPortalLoginLogoutPage();
	HubHomeLoginLogoutPage hll = new HubHomeLoginLogoutPage();
	HubHomePage hhp = new HubHomePage();
	HubPortal_ListAllCopayProgramPatientPage hlp = new HubPortal_ListAllCopayProgramPatientPage();
	HubReimbursementPage hrp = new HubReimbursementPage();
	HubPortal_ListAllCopayProgramPatients_InsuranceTabPage hlc = new HubPortal_ListAllCopayProgramPatients_InsuranceTabPage();
	HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage pct = new HubPortal_ListAllCopayProgramPatients_PatientCardInfoTabPage();
	
	public AdminPortal_Patients_InsuranceTabPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement InsuranceTab()
	{
		return driver.findElement(By.linkText("Insurance & Reprocess")); //updated for replatform
	}
	public WebElement InsuranceTabName()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Patient Insurance History')]"));
	}
	
	public WebElement InsuranceTabOtherInsCompanyName()
	{
		return driver.findElement(By.id("payerName_other"));
	}
	
	public Select InsuranceTabInsuranceCompanyName()
	{
		Select insCompanyName = new Select(driver.findElement(By.id("payerName")));
		return insCompanyName;
	}
	
	public List<WebElement> PayerNameList()
	{
		return driver.findElements(By.xpath("//*[@id='payerName']/option"));
	}
	
	public WebElement InsuranceTabInsuranceCompanyNameDropdown()
	{
		return driver.findElement(By.id("payerName"));
	}
	public WebElement InsuranceCompanyOthers()
	{
		return driver.findElement(By.id("payerName_other"));
	}
	public WebElement InsurancePlanOthers()
	{
		return driver.findElement(By.id("payerPlanName_other"));
	}
	
	
	
	public Select InsuranceTabPayerPlanName()
	{
		Select insPayerPlanName = new Select(driver.findElement(By.id("payerPlanName")));
		return insPayerPlanName;
	}
	
	public Select InsuranceTabStatus()
	{
		Select insStatus = new Select(driver.findElement(By.id("patient_status")));
		return insStatus;
	}
	public WebElement InsuranceTabInsuranceGroupNumber()
	{
		return driver.findElement(By.name("corp_api_field[insurances][groupNumber]"));
	}
	
	public WebElement InsuranceTabInsuranceMemberNumber()
	{
		return driver.findElement(By.name("corp_api_field[insurances][memberId]"));
	}
	public WebElement InsuranceTabInsEffDate()
	{
		return driver.findElement(By.name("corp_api_field[insurances][insuranceEffectiveDate]"));
	}
	public WebElement InsuranceTabInsuranceBIN()
	{
		return driver.findElement(By.name("corp_api_field[insurances][bin]"));
	}
	
	public WebElement InsuranceTabInsurancePCN()
	{
		return driver.findElement(By.name("corp_api_field[insurances][pcn]"));
	}
	
	public Select InsuranceTabChecksToRunField()
	{
		Select insCheckDropdown = new Select(driver.findElement(By.name("service_check_bf")));
		return insCheckDropdown;
	}
	
	public WebElement InsuranceTabChecksToRunDropdown()
	{
		return driver.findElement(By.name("service_check_bf"));
	}
	
	public String InsuranceTabInsuranceCompanyNameValue()
	{
		return InsuranceTabInsuranceCompanyName().getFirstSelectedOption().getText();
	}
	
	public String InsuranceTabInsuranceGroupNumberValue()
	{
		return InsuranceTabInsuranceGroupNumber().getAttribute("value");
	}
	
	public String InsuranceTabInsuranceMemberNumberValue()
	{
		return InsuranceTabInsuranceMemberNumber().getAttribute("value");
	}
	
	public String InsuranceTabInsuranceBINValue()
	{
		return InsuranceTabInsuranceBIN().getAttribute("value");
	}
	
	public String InsuranceTabInsurancePCNValue()
	{
		return InsuranceTabInsurancePCN().getAttribute("value");
	}
	
	public WebElement InsurancetabUpdateButton()
	{
		return driver.findElement(By.id("adding_notes"));
	}
	
	public WebElement GKUpdateButton()
	{
		return driver.findElement(By.name("button_reprocess"));
	}
	
	
	public WebElement InsuranceTabPatientHistoryLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div/table/thead/tr/td/font/strong"));
	}

	public WebElement InsuranceTabUpdateInsuranceLabel()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div/form/fieldset/legend/strong"));
	}

	public List<WebElement> InsuranceTabGridCols()
	{
		return driver.findElements(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/thead/tr/th"));
	}
	
	public WebElement InsuranceTabGridColNames(int i)
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/thead/tr/th["+i+"]"));
	}
	
	public String InsuranceFieldFirstRowValue()
	{
		System.out.println("Inside page object");
		System.out.println("dd"+driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/tbody/tr[1]/td[1]/textarea")).getText());
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/tbody/tr[1]/td[1]/textarea")).getText();
	}
	
	public String CreatedDateFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/tbody/tr[1]/td[3]")).getText();
	}
	
	public String RecordStatusFirstRowValue()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[3][@id='tab_11']/div[2]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String InsuranceFieldFirstRowValueAfterUpdate()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tab_11']/div[2]/table/tbody/tr[1]/td[1]/textarea")).getText();
	}
	
	public String CreatedDateFirstRowValueAfterUpdate()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tab_11']/div[2]/table/tbody/tr[1]/td[3]")).getText();
	}
	
	public String RecordStatusFirstRowValueAfterUpdate()
	{
		return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tab_11']/div[2]/table/tbody/tr[1]/td[4]")).getText();
	}
	
	public String InsuranceUpdateConfirmationMsg()
	{
		//return driver.findElement(By.xpath("//div[@id='tabs_content_container']/div[2][@id='tab_11']/div/form/fieldset/table/tbody/tr[9]/td/font")).getText();
		return driver.findElement(By.xpath("//*[@id='insuranceErr']")).getText();
		
	}
	public String InsuranceGKUpdateConfirmationMsg()
	{
		return driver.findElement(By.xpath("//*[@id='insuranceErr']/font")).getText();
	}
	
	public WebElement RefreshDataLink()
	{
		return driver.findElement(By.id("RefreshData"));
	}
	
	public String InsuranceInfo_Admin(List<String> testData)
	{
		String info = "insurance_company_name : "+testData.get(0)+" "+"\n"+"insurance_payer_name : "+testData.get(0)+" "+"\n"+"insurance_plan_type : primary medical insurance "+"\n"+"insurance_group_number : "+testData.get(1)+" "+"\n"+
						"insurance_member_number : "+testData.get(2)+" "+"\n"+"insurance_effective_date :  "+"\n"+"insurance_bin_number : "+testData.get(3)+" "+"\n"
						+"insurance_pcn_number : "+testData.get(4)+" "+"\n"+"rxinsurance_group_number : "+testData.get(1)+" "+"\n"+"rxinsurance_member_number : "+testData.get(2)+" "+"\n"+"rxinsurance_bin_number : "+
						testData.get(3)+" "+"\n"+"rxinsurance_pcn_number : "+testData.get(4)+" ";
		
		return info;
	}
	
	public List<String> UpdateInsuranceInfoInInsuranceTabForGKReject() throws InterruptedException
	{
		
//			int randomInsNum = cf.SelectRandomInsuranceName(PayerNameList());
//			PayerNameList().get(randomInsNum).click();
			InsuranceTabInsuranceCompanyNameDropdown().sendKeys("other");
			InsuranceCompanyOthers().clear();
			InsuranceCompanyOthers().sendKeys("Medicare");
			InsuranceTabPayerPlanName().selectByVisibleText("EPO");
			InsuranceTabInsuranceGroupNumber().clear();
			InsuranceTabInsuranceMemberNumber().clear();
			InsuranceTabInsuranceBIN().clear();
			InsuranceTabInsurancePCN().clear();
			
			InsuranceTabInsuranceGroupNumber().sendKeys(TestUtil.randomAlphaNumeric(15));
			InsuranceTabInsuranceMemberNumber().sendKeys(TestUtil.randomNumeric(12));
			InsuranceTabInsuranceBIN().sendKeys(TestUtil.randomNumeric(6));
			InsuranceTabInsurancePCN().sendKeys(TestUtil.randomNumeric(10));
			
			InsurancetabUpdateButton().click();
			Thread.sleep(2000);
			
			System.out.println("Clicked on update insurance Button");
			Assert.assertEquals(InsuranceUpdateConfirmationMsg(), "Insurance Update Response: Success");
			Thread.sleep(30000);
						
			return null;
		}
	
	public List<String> UpdateGKReject() throws InterruptedException
	{
			System.out.println("Before  Clicking on GK");
			InsuranceTabChecksToRunField().selectByVisibleText("Bypass Gatekeeper Check");
			Thread.sleep(2000);
			System.out.println("Before  Clicking on GK- update");
			GKUpdateButton().click();
			System.out.println("After  Clicking on GK- update");
			
			Assert.assertEquals(InsuranceGKUpdateConfirmationMsg(), "Enrollment Reprocess Response: Success");
			
			return null;
		}
	
	
	public List<String> UpdateInsuranceInfoInInsuranceTab() throws InterruptedException
	{
		
			int randomInsNum = cf.SelectRandomInsuranceName(PayerNameList());
			PayerNameList().get(randomInsNum).click();
			InsuranceTabInsuranceGroupNumber().clear();
			InsuranceTabInsuranceMemberNumber().clear();
			InsuranceTabInsuranceBIN().clear();
			InsuranceTabInsurancePCN().clear();
			
			InsuranceTabInsuranceGroupNumber().sendKeys(TestUtil.randomAlphaNumeric(15));
			InsuranceTabInsuranceMemberNumber().sendKeys(TestUtil.randomNumeric(12));
			InsuranceTabInsuranceBIN().sendKeys(TestUtil.randomNumeric(6));
			InsuranceTabInsurancePCN().sendKeys(TestUtil.randomNumeric(10));
			
			InsurancetabUpdateButton().click();
			Thread.sleep(2000);
			
			Assert.assertEquals(InsuranceUpdateConfirmationMsg(), "Patient Update Response: Success");
			Thread.sleep(30000);
			//click on Refresh Data link
			RefreshDataLink().click();
			Thread.sleep(5000);
			List<String> testData = new ArrayList<String>();
			testData.add(0, InsuranceTabInsuranceCompanyNameValue());
			testData.add(1, InsuranceTabInsuranceGroupNumberValue());
			testData.add(2, InsuranceTabInsuranceMemberNumberValue());
			testData.add(3, InsuranceTabInsuranceBINValue());
			testData.add(4, InsuranceTabInsurancePCNValue());
			
			return testData;
		
	}
	
	public boolean VerifyUpdatedInsuranceInfoInAdminAndHub(List<String> InsInfo, String memberID, String loginType) throws ParseException, InterruptedException, IOException, AWTException
	{
		boolean verify = true;
		if(verify)
		{
			System.out.println("Inside verify in hub and admin");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			LocalDate todayDate = java.time.LocalDate.now(); 
			String currentDate = todayDate.toString(); 
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(currentDate);
			
			String expectedInsInfo_Admin = InsuranceInfo_Admin(InsInfo);
			
			
			Assert.assertEquals(InsuranceFieldFirstRowValueAfterUpdate(), expectedInsInfo_Admin);
			Assert.assertTrue(CreatedDateFirstRowValueAfterUpdate().contains(currentDate));
			Assert.assertEquals(RecordStatusFirstRowValueAfterUpdate(), "Current");
			
			//reporting
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,850)", "");
		    if(InsuranceFieldFirstRowValueAfterUpdate().equalsIgnoreCase(expectedInsInfo_Admin))
		    {
		    	TestBase.classAInstance.logReport("Pass","Verify Insurance Info update in Admin Portal","Succesfully able to Verify Insurance Info update in Admin Portal");
		    }
		    else
		    {
		    	TestBase.classAInstance.logReport("Fail","Verify Insurance Info update in Admin Portal","Failed to Verify Insurance Info update in Admin Portal");
		    }
			
			alp.AdminPortalLogout();
			driver.quit();
			Thread.sleep(2000);
		//	WebDriverWait wait = new WebDriverWait(driver, 30);
			//now log into hub and verify the updated insurance info
			try {
				intializeHubDriver();
				}
				catch(InterruptedException e) {
					
				}
			Thread.sleep(2000);
			hll.HubPortalLogin();
			Thread.sleep(2000);
			if(loginType.equalsIgnoreCase("DrugReimbursement"))
			{
				//click on DrugReimbursement button
				hhp.HubCarTDrugProgramButton().click();
				Thread.sleep(2000);
			}
			else if(loginType.equalsIgnoreCase("AdminReimbursement"))
			{
				//click on DrugReimbursement button
				hhp.HubTravelProgramButton().click();
				Thread.sleep(2000);
			}
			
			hrp.ListAllCopayProgramPatientsButton().click();
			Thread.sleep(3000);
			
			hlp.MemberIDSearchField().sendKeys(memberID);
			Thread.sleep(2000);
			
			hlp.ActionColReviewLink().click();
			Thread.sleep(5000);
			
			//Now verify the hub portal is sowing updated insurance info here
			System.out.println("Before Assertions in pctab");
			Assert.assertEquals(pct.InsurancesPayerNameDropdown().getFirstSelectedOption().getText(), InsInfo.get(0));
			Assert.assertEquals(pct.InsuranceGroupNumber().getAttribute("value"), InsInfo.get(1));
			Assert.assertEquals(pct.InsuranceMemberID().getAttribute("value"), InsInfo.get(2));
			Assert.assertEquals(pct.InsuranceBINNumber().getAttribute("value"), InsInfo.get(3));
			Assert.assertEquals(pct.InsurancePCNNumber().getAttribute("value"), InsInfo.get(4));
			System.out.println("after Assertions in pctab");
			//reporting
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,1000)", "");
		    if(pct.InsurancesPayerNameDropdown().getFirstSelectedOption().getText().equalsIgnoreCase(InsInfo.get(0)))
		    {
		    	System.out.println("inside yes reporting");
		    	TestBase.classAInstance.logReport("Pass","Verify Insurance Info update in Hub Portal","Succesfully able to Verify Insurance Info update in Hub Portal");
		    }
		    else
		    {
		    	TestBase.classAInstance.logReport("Fail","Verify Insurance Info update in Hub Portal","Failed to Verify Insurance Info update in Hub Portal");
		    }
			
			hlc.InsuranceTab().click();
			Thread.sleep(2000);
			
			
			String expectedInsInfo_Hub = hlc.InsuranceInfo_Hub(InsInfo);
			System.out.println("Before Assertions in instab");
			Assert.assertEquals(hlc.InsuranceFirstRow().getText(), expectedInsInfo_Hub);
			Assert.assertEquals(hlc.RecordStatusFirstRow().getText(), "Active");
			Assert.assertTrue(hlc.LastUpdatedDateFirstRow().getText().contains(new SimpleDateFormat("MM/dd/yyyy").format(date)));
			System.out.println("after Assertions in instab");
			//reporting
		    if(hlc.InsuranceFirstRow().getText().equalsIgnoreCase(expectedInsInfo_Hub))
		    {
		    	TestBase.classAInstance.logReport("Pass","Verify Insurance Info update in Hub Portal","Succesfully able to Verify Insurance Info update in Hub Portal");
		    }
		    else
		    {
		    	TestBase.classAInstance.logReport("Fail","Verify Insurance Info update in Hub Portal","Failed to Verify Insurance Info update in Hub Portal");
		    }
		    
			hrp.HubReimbursementLogoutButton().click();
			
			
			
			return verify;
		}
		
		verify = false;
		return verify;
		
	}
	
}
