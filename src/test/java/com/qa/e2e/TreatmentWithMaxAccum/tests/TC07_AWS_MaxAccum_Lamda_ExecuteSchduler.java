package com.qa.e2e.TreatmentWithMaxAccum.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.AWS.qa.base.TestBase;
//import com.AWS.qa.pages.*;
import com.AWS.qa.util.TestUtil;
import com.AWS.qa.util.Xls_Reader;
import com.juno.qa.getandsetTestData.E2EWorkflow_TestData;
import com.juno.qa.util.ExcelTestDataReader;



public class TC07_AWS_MaxAccum_Lamda_ExecuteSchduler extends TestBase {
	

	TestUtil testUtil;
	String sheet = "CTM";
	public static WebDriver driver;
	public static String MemberPayment;
	public static String PaymentAmount;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestData.xlsx";
	static Xls_Reader reader = new Xls_Reader(TESTDATA_SHEET_PATH);
	
	E2EWorkflow_TestData dat = new E2EWorkflow_TestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	String Key = "CTMData";	
	String Key1 = "StatusAfterCheckAll";
	String Key2 = "HubStatusCheckAfterCheckAll";
	String Key3 = "StatusAfterCheckClear";
	String Key4 = "HubStatusCheckAfterCheckClear";
		
	
    
	public TC07_AWS_MaxAccum_Lamda_ExecuteSchduler()
	{
		//super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before Method started");
	//	initialization("Payment");
		TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		System.out.println("Before Method completed");
		
}
	

	
	@Test()
	public void AWS_S3_Upload_Check_All() throws InterruptedException, IOException, AWTException 
 
	
	{
		String browsername = "Chrome"; 
		if (browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
		}
		
		 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			

			int rowNum = etd.getKeyValuePair(Key);

			
			
			List<String> testData = new ArrayList<String>();
			testData = dat.GetCTMDataForPaymentApproval(Key, rowNum);
			
			String URL = "https://myapps.microsoft.com/signin/AWS_Console/6088ac6b-1432-490d-a6cb-f940f06dbcb9?tenantId=ed28afd7-821e-40af-bf1a-24170859ba17";
			driver.get(URL);
//			Thread.sleep(10000);
			Thread.sleep(3000);
			String uname = prop.getProperty("CurentUserName");
			System.out.println("uname is:"+uname);
			String pwd = prop.getProperty("CurrentPassword").trim();
			
			Thread.sleep(3000);
			
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
			
			
		
			String ProgramNameCheck = testData.get(1);
			System.out.println(ProgramNameCheck);
           boolean check1=false;
			

			
			String MainwidowHandle = driver.getWindowHandle();

			
			//Switch to QA Environment

			driver.findElement(By.xpath("//*[@id='nav-usernameMenu']/span[2]")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[contains(text(),'Switch')]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='switchrole_firstrun_button']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='account']")).sendKeys("Connectiverx-QA");
			driver.findElement(By.xpath("//*[@id='roleName']")).sendKeys("QA");
			driver.findElement(By.xpath("//*[@id='displayName']")).sendKeys("QA");
			driver.findElement(By.xpath("//*[@id='input_switchrole_button']")).click();
		

		
			System.out.println("inside 1");
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).sendKeys("Lambda");
			Thread.sleep(5000);
			System.out.println("Select s3 from the list");
			driver.findElement(By.xpath("//h3/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("awsui-autosuggest-0")).sendKeys("CRXBuyandBill-WBScheduler-Jobs");
			Thread.sleep(5000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(6000);
			driver.findElement(By.xpath( "//a[contains(@href,'#/functions/CRXBuyandBill-WBScheduler-Jobs')]")).click();
			
			System.out.println("Clciked on WBscheduler JOBS");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='lambda-functionDesigner']/awsui-tabs/div/ul/li[2]/a/span")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='testEventContainer']/div[1]/div/div[2]/awsui-button[4]")).click();
			System.out.println("Clciked on Test JOBS");
			String Confirmationtext= driver.findElement(By.xpath("//*[@id='awsui-tabs-0-testing-panel']/span/div/div[1]/div/awsui-alert/div/div[2]/div/div/span/span/h3/span")).getText();
			System.out.println("Confirmationtext is:" +Confirmationtext);
			
			if(driver.findElement(By.xpath("//*[@id='awsui-tabs-0-testing-panel']/span/div/div[1]/div/awsui-alert/div/div[2]/div/div/span/span/h3/span")).isDisplayed())
	        {
			TestBase.classAInstance.logReport("Pass","AWS Lambda","Succesfully ran Lambda");
					}
			 else
			   {
					    TestBase.classAInstance.logReport("Fail","AWS Lambda","Failed to ran Lambda");
		   }
			driver.quit();
		}	    	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
//		if(result.getStatus()== ITestResult.SUCCESS){
//			TestBase.classAInstance.logReport("Pass", "AWS Lambda", "Succesfully uploaded  ran Lambda");
//			} else {
//			TestBase.classAInstance.logReport("Fail", "AWS Lambda", "Failed to uploaded  ran Lambda");
//			}
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
		WebElement faxTable = driver.findElement(By.xpath("//table"));
		List<WebElement> noofRows = faxTable.findElements(By.tagName("tr"));

		return noofRows;
	}
	}


