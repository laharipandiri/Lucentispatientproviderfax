package com.qa.e2e.CTMWorkflow.tests;


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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AWS.qa.base.TestBase;
//import com.AWS.qa.pages.*;
import com.AWS.qa.util.TestUtil;
import com.AWS.qa.util.Xls_Reader;
import com.juno.qa.getandsetTestData.E2EWorkflow_TestData;
import com.juno.qa.util.ExcelTestDataReader;
import com.qa.ExtentReportListener.TestNGListner;

@Listeners(TestNGListner.class)
public class New_TC07_PaymentSent_CTM extends TestBase {
	

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
	
	
    
	public New_TC07_PaymentSent_CTM()
	{
		//super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before Method started");
		TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
	//	initialization("Payment");
		System.out.println("Before Method completed");
		
}
	

	
	@Test()
	public void PaymentSent_CTM() throws InterruptedException, IOException, AWTException 
 
	
	{
		String browsername = "Chrome"; 
		if (browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
		}
		//Launching Driver for Payment site
		 int numberofrecordsvalidated=0;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
	/*	int rwCount = reader2.getRowCount("Smoke");
		List<String> testData = new ArrayList<String>();
		testData = 
		rwCount = Xls_Reader.sheet.getLastRowNum();

		Row row;
		Cell cell; */
		
		int rowNum = etd.getKeyValuePair(Key);
		List<String> testData = new ArrayList<String>();
		testData = dat.GetCTMDataForPaymentApproval(Key, rowNum);
		
	//Payments Site open
		String URL1="https://affordability-platform-qa.connectiverx.com/";
		driver.get(URL1);
		Thread.sleep(400000);
		//click on connectiverx button
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/form/div/input")).click();
		Thread.sleep(40000);
		
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
	//click on Payment
	driver.findElement(By.xpath("//*[contains(text(),'Payment')]")).click();
	
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//*[contains(text(),'Approve Payment Requests')]")).click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//*[@id='mat-input-2']")).click();
	Thread.sleep(4000);
	
/*	row = Xls_Reader.sheet.getRow(1);
	cell = row.getCell(2);
	String ProgramNameCheck=cell.getStringCellValue(); */
	String ProgramNameCheck = testData.get(1);
	System.out.println(ProgramNameCheck);
	if(ProgramNameCheck.equalsIgnoreCase("Prolia"))
	{
		//*[@id="mat-option-48"]/span
	driver.findElement(By.xpath("//*[contains(text(),'Prolia')]")).click();
	Thread.sleep(10000);
	}
	else if(ProgramNameCheck.equalsIgnoreCase("Lucentis"))
	{
		driver.findElement(By.xpath("//*[contains(text(),'Lucentis')]")).click();
		Thread.sleep(10000);
	}
	else if(ProgramNameCheck.equalsIgnoreCase("blincyto"))
	{
		driver.findElement(By.xpath("//*[contains(text(),'blincyto')]")).click();
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
		//driver.findElement(By.xpath("//*[@id='mat-option-241']/span")).click();  
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
	
	
	
	driver.findElement(By.xpath("//*[text() = 'CTM']")).click();
	Thread.sleep(8000);
	
	
	HashMap<String, String> excelData = new HashMap<String, String>();
/*	for (int loop2 = 1; loop2 <= rwCount; loop2++) {
     
		row = Xls_Reader.sheet.getRow(loop2);
		cell = row.getCell(2);
		String ProgramName=cell.getStringCellValue();
		cell = row.getCell(3);
		String Amount=cell.getStringCellValue();
		cell = row.getCell(1);
		MemberPayment=cell.getStringCellValue(); */
		
		excelData.put(testData.get(0), testData.get(2));
		
//	}
	
	System.out.println("excel data ####"+excelData.toString());
		
	int TotalRowsPayment = NumOfRowsPayment().size();// - 1;
	System.out.println(TotalRowsPayment);
//	List<WebElement> columnspayment;
    
	for (int i = 1; i <= TotalRowsPayment; i++) {	
		
		String MemberIDScreen =driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
		System.out.println("Screen member id amount "+MemberIDScreen);
		
		PaymentAmount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[9]")).getText();
		System.out.println("Sceen payment amount "+PaymentAmount);
	
		 String excelAmountForMemberId = excelData.get(MemberIDScreen);
		 System.out.println("excelAmountForMemberId "+excelAmountForMemberId);
		
	  if(excelAmountForMemberId!=null && PaymentAmount.contains(excelAmountForMemberId)){
		System.out.println("Member " + MemberIDScreen +"with amount " + PaymentAmount + "is present on the screen " );
		Reporter.log("Member ID is: " + MemberIDScreen +" and amount is : " + PaymentAmount);
		 // driver.findElement(By.xpath("//table/tbody/tr["+loop1+"]/td[13]")).click(); -- updated on 9/29/2020
	//	int j= i+4;
		//driver.findElement(By.xpath("//*[@id='mat-checkbox-"+j+"']/label/div")).click();
		driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[13]")).click();
		    
		numberofrecordsvalidated=numberofrecordsvalidated+1;
		 Thread.sleep(4000);
		 break;
		  }
	  
	 }
	
		
	driver.findElement(By.xpath("//*[text() = 'CTM']")).click();
	Thread.sleep(1000);
	System.out.println("before Approve button");
	driver.findElement(By.xpath("//*[contains(text(),'Approve Payments')]")).click();
	 
	
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
		System.out.println("Total records sent for payment " + numberofrecordsvalidated);	
		Thread.sleep(4000);	
			
		driver.quit();
	}	    	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
		if(result.getStatus()== ITestResult.SUCCESS){
			TestBase.classAInstance.logReport("Pass", "E2E CTP Lucentis Enrollment Patient", "Succesfully enrolled a patient");
			} else {
			TestBase.classAInstance.logReport("Fail", "E2E CTP Lucentis Enrollment Patient", "Failed to enrolled a patient");
			}
		driver.quit();
		TestBase.classAInstance.endReport();
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

		// wait.until(ExpectedConditions.visibilityOf(com.drv.findElement(By.xpath("//th[text()='Fax#']"))));

		// wait.until(ExpectedConditions.visibilityOf(pppo.RecordTable()));
		// AdminFaxesPageObjects afpo = new AdminFaxesPageObjects(drv);
		WebElement faxTable = driver.findElement(By.xpath("//table[@class='table table-hover mat-table']"));
		List<WebElement> noofRows = faxTable.findElements(By.tagName("tr"));

		return noofRows;
	}
	
	public static List<WebElement> NumOfRowsPayment() {

		// wait.until(ExpectedConditions.visibilityOf(com.drv.findElement(By.xpath("//th[text()='Fax#']"))));

		// wait.until(ExpectedConditions.visibilityOf(pppo.RecordTable()));
		// AdminFaxesPageObjects afpo = new AdminFaxesPageObjects(drv);
		//WebElement faxTable = driver.findElement(By.xpath("//table"));
		List<WebElement> noofRows = driver.findElements(By.xpath("//table/tbody/tr"));

		return noofRows;
	}
	}


