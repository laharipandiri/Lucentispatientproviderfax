package com.qa.e2e.CTPWorkflow.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.AWS.qa.base.TestBase;
//import com.AWS.qa.pages.*;
import com.AWS.qa.util.TestUtil;
import com.AWS.qa.util.Xls_Reader;
import com.juno.qa.getandsetTestData.E2EWorkflow_TestData;
import com.juno.qa.util.ExcelTestDataReader;


public class New_TC14_CTP_ValidatingPaymentSite_CheckClear_Status extends TestBase {
	

	TestUtil testUtil;
	String sheetname = "CTM";
	
	String uname = prop.getProperty("CurentUserName");
	String pwd = prop.getProperty("CurrentPassword").trim();
	
	public static WebDriver driver;
	public static String MemberPayment;
	public static String PaymentAmount;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestData.xlsx";
	static Xls_Reader reader2 = new Xls_Reader(TESTDATA_SHEET_PATH);
	
	E2EWorkflow_TestData dat = new E2EWorkflow_TestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	String Key = "CTMData";	
		
	
    
	public New_TC14_CTP_ValidatingPaymentSite_CheckClear_Status()
	{
	//	super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before Method started");
	//	initialization("Payment");
		
		System.out.println("Before Method completed");
		
}
	

	
	@Test()
	public void ValidatingPaymentSite_Paid_Status() throws InterruptedException, AWTException, IOException 
 
	
	{
		
		String browsername = "Chrome"; 
		if (browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
		}
		 boolean finalresult=false;
		 int numberofrecordsvalidated=0;
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		
			//Payments Site//
			System.out.println("Logging to Payment site for Validation");
			String URL1="https://affordability-platform-qa.connectiverx.com/";
			driver.get(URL1);
			Thread.sleep(4000);
			//click on connectiverx button
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/form/div/input")).click();
			Thread.sleep(10000);
			
			if(driver.findElement(By.name("loginfmt")).isDisplayed()== true)
			{
				driver.findElement(By.name("loginfmt")).sendKeys(uname);
				Thread.sleep(2000);
				driver.findElement(By.id("idSIButton9")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("passwd")).sendKeys(pwd);
				Thread.sleep(2000);
				driver.findElement(By.id("idSIButton9")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("idSIButton9")).click();
				Thread.sleep(2000);
				
			}
			//Going to Payment//
		//	Thread.sleep(240000);
			driver.findElement(By.xpath("//*[contains(text(),'Payment')]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//span[contains(text(),'Search Payments')]")).click();
			driver.findElement(By.xpath("//*[contains(text(),'Approve Payment Requests')]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id='mat-select-0']/div/div[2]")).click();
			driver.findElement(By.xpath("//*[@id='mat-input-2']")).click();
			Thread.sleep(2000);
			Row row;Cell cell;
		/*	int rwCount = reader2.getRowCount("CTM");
			rwCount = Xls_Reader.sheet.getLastRowNum();
			row = Xls_Reader.sheet.getRow(1);
			cell = row.getCell(2);
			String ProgramNameCheck=cell.getStringCellValue(); */
			
			int rowNum = etd.getKeyValuePair(Key);
			List<String> testData = new ArrayList<String>();
			testData = dat.GetCTMDataForPaymentApprovalForCheckAll(Key, rowNum);
			
			String ProgramNameCheck = testData.get(1);
			System.out.println(ProgramNameCheck);
			
			if(ProgramNameCheck.equalsIgnoreCase("Prolia"))
			{
				//*[@id="mat-option-48"]/span
			driver.findElement(By.xpath("//*[contains(text(),'Prolia')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("blincyto"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'blincyto')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Lucentis"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Lucentis')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Imlygic"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Imlygic')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Kanjinti"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Kanjinti')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Kyprolis"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Kyprolis')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Mvasi"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Mvasi')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Nplate"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Nplate')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Vectibix"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Vectibix')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Xgeva"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Xgeva')]")).click();		
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Neulasta"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Neulasta')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Neupogen"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Neupogen')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Avsola"))
			{
				//*[@id="mat-option-48"]/span
			driver.findElement(By.xpath("//*[contains(text(),'Avsola')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Inflectra"))
			{
			
			driver.findElement(By.xpath("//*[contains(text(),'Inflectra')]")).click();
			Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Nivestym"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Nivestym')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Ruxience"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Ruxience')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Trazimera"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Trazimera')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Zirabev"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Zirabev')]")).click();
				Thread.sleep(10000);
			}	
			else if (ProgramNameCheck.equalsIgnoreCase("Entyvio $5"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Entyvio $5')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Entyvio Clinical $0"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Entyvio Clinical $0')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Herzuma"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Herzuma')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Truxima"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Truxima')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Spinraza"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Spinraza')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Copay Exist"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Tysabri Copay Exist')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Copay New"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Tysabri Copay New')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon Exist"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Tysabri Coupon Exist')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon New"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Tysabri Coupon New')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Procedure"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Tysabri Procedure')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Drug Reimbursement"))
			{
				//*[@id="mat-option-48"]/span
			driver.findElement(By.xpath("//*[contains(text(),'Drug Reimbursement')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Admin Reimbursement"))
			{
				//*[@id="mat-option-48"]/span
			driver.findElement(By.xpath("//*[contains(text(),'Admin Reimbursement')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Ajovy Buy and Bill Savings Program"))
			{
				//*[@id="mat-option-48"]/span
			driver.findElement(By.xpath("//*[contains(text(),' Ajovy Buy and Bill Savings Program ')]")).click();
			Thread.sleep(10000);
			}
			
			driver.findElement(By.xpath("//*[contains(text(),'Payment Requests Approved Today')]")).click();
			Thread.sleep(10000);
			
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_ESCAPE);
//			robot.keyRelease(KeyEvent.VK_ESCAPE);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//mat-select[@formcontrolname='approvedBys']")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.className("mat-option-text")).click();
//			Thread.sleep(1000);
//			robot.keyPress(KeyEvent.VK_ESCAPE);
//			robot.keyRelease(KeyEvent.VK_ESCAPE);
//			Thread.sleep(1000);
			
			//click on submit
			driver.findElement(By.xpath("//span[contains(text(),'Submit')]//ancestor::button")).click();
			Thread.sleep(1000);
			
			
			HashMap<String, String> excelData = new HashMap<String, String>();
			
		/*	for (int loop2 = 1; loop2 <= rwCount; loop2++) {

				row = Xls_Reader.sheet.getRow(loop2);
				cell = row.getCell(2);
				String ProgramName=cell.getStringCellValue();
				cell = row.getCell(3);
				String Amount=cell.getStringCellValue();
				cell = row.getCell(1);
				MemberPayment=cell.getStringCellValue();
				
				System.out.println("The memebr ID from Excel:" +MemberPayment);
				excelData.put(MemberPayment, Amount); */

		excelData.put(testData.get(0), testData.get(2));
				
				Thread.sleep(2000);
			int TotalRows = NumOfRows().size();
			List<WebElement> columns;
			String Member = "";
			String PaymentStatus = "";
			String PayAmount = "";
					
			if(NumOfRows() !=null) {
				System.out.println("NumOfRows() size ########" +NumOfRows().size());
				
				System.out.println("NumOfRows().get(0) ########" +NumOfRows().get(0));
				Thread.sleep(1000);
				columns = NumOfRows().get(1).findElements(By.tagName("td"));
				Thread.sleep(1000);
				Member =  columns.get(3).getText();
				Thread.sleep(1000);
				PaymentStatus = columns.get(10).getText();
				
				System.out.println("The TotalRows is:" +TotalRows);
				System.out.println("The Member is:" +Member);
				System.out.println("The PaymentStatus is:" +PaymentStatus);	
			}else {
				System.out.println("Number of rows is null");
			}
			
		
			System.out.println("excel data****************************"+excelData.toString());
			
			   if(TotalRows >= 1){
			    	 
			    	 for(int k=1;k<=TotalRows-1;k++)
			    		 
		    		 {
			    		 Thread.sleep(1000);
			    		 Member= driver.findElement(By.xpath("//tbody/tr["+k+"]/td[4]")).getText();
			    		 PayAmount=driver.findElement(By.xpath("//tbody/tr["+k+"]/td[10]")).getText();
			    		 String excelAmountForMemberId = excelData.get(Member);
			    		 PaymentStatus=driver.findElement(By.xpath("//tbody/tr["+k+"]/td[11]")).getText();
			    		 String checkNum = driver.findElement(By.xpath("//tbody/tr["+k+"]/td[17]")).getText();
			    		 String paymentID = driver.findElement(By.xpath("//tbody/tr["+k+"]/td[8]/button/span")).getText();
			    		
			    		 if(Member.contains(testData.get(0)) && PayAmount.contains(testData.get(2)) && PaymentStatus.contains("Check Cleared")) 
			    		 {
			    			// driver.findElement(By.xpath("//*[@id='mat-input-2']")).sendKeys(Member);
			    			 System.out.println("Inside if");
			    			// Assert.assertEquals(checkNum, testData.get(3));
			    			// Assert.assertEquals(paymentID, testData.get(4));
			    			
				    		 Thread.sleep(1000);
			    			 finalresult=true;
			    			 numberofrecordsvalidated=numberofrecordsvalidated+1;
			    			 System.out.println("The member Id status is changed to Check Cleared: " +Member);
			    			 Reporter.log("The member Id status is changed to Check Cleared: " +Member);
		    			    break;
			     		 }
		    		
			    		System.out.println("Outside if after break"+k);
		    		 }
			   }
	System.out.println("Total records validated for Check Cleared: " + numberofrecordsvalidated);
	Assert.assertTrue(finalresult);
	driver.quit();
	System.out.println("Member is $$$$$$$:" +Member);
	
	
	boolean rst= true;
	System.out.println(rst);
	
	if (rst==true) {
		
			 TestBase.classAInstance.logReport("Pass","CTP Check all file is uploaded","CTP Check all file is uploaded");
				}
		 else{
		    	TestBase.classAInstance.logReport("Fail","CTP Check all file is not uploaded","CTP Check all file is not uploaded");
		 }      		                  
		      
			}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("After Method started");
		TestBase.classAInstance.endReport();
		driver.quit();
		System.out.println("After Method ended");
		
	
	}
	public static void closeBrowser()
	{	
		//Method to close the browser
		driver.quit();
		System.out.println("The browser has been closed");

	}
	
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	public static List<WebElement> NumOfRows() {

	
		 WebElement table = driver.findElement(By.xpath("//table[@class='mat-table cdk-table mat-sort table table-hover']"));
		 List<WebElement> noofRows = table.findElements(By.tagName("tr"));

		return noofRows;
	}
	
	public static List<WebElement> NumOfRowsPayment() {

		// wait.until(ExpectedConditions.visibilityOf(com.drv.findElement(By.xpath("//th[text()='Fax#']"))));

		// wait.until(ExpectedConditions.visibilityOf(pppo.RecordTable()));
		// AdminFaxesPageObjects afpo = new AdminFaxesPageObjects(drv);
		List<WebElement> noofRows = driver.findElements(By.xpath("//table/tbody/tr"));
		

		return noofRows;
	}
	}


