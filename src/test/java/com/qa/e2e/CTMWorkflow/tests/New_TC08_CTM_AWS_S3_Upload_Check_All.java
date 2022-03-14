package com.qa.e2e.CTMWorkflow.tests;


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

public class New_TC08_CTM_AWS_S3_Upload_Check_All extends TestBase {
	

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
		
	
    
	public New_TC08_CTM_AWS_S3_Upload_Check_All()
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
			//We need wait as the job runs every 5 min (1 & 6 interval)
			Thread.sleep(40000);
			Thread.sleep(2000);
			String uname = prop.getProperty("CurentUserName");
			System.out.println("uname is:"+uname);
			String pwd = prop.getProperty("CurrentPassword").trim();
			
			
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
		
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='nav-usernameMenu']/span[2]")).click(); //*[@id="i0116"]
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[contains(text(),'Switch')]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='switchrole_firstrun_button']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='account']")).sendKeys("Connectiverx-QA");
			driver.findElement(By.xpath("//*[@id='roleName']")).sendKeys("QA");
			driver.findElement(By.xpath("//*[@id='displayName']")).sendKeys("QA");
			driver.findElement(By.xpath("//*[@id='input_switchrole_button']")).click();
		

			Thread.sleep(20000);
			System.out.println("inside 1");
			Thread.sleep(9000);
			driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).sendKeys("S3"); //updated on 12012021
			System.out.println("I am clicking the search button");
			Thread.sleep(5000);
			
			System.out.println("Select s3 from the list");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h3/a/span")).click();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			System.out.println("Selected S3 from the list");
			Thread.sleep(15000);
			System.out.println("Click on affordability-qa-buyandbill-files");
			driver.findElement(By.xpath("//*[@id='buckets-table']/div/div[3]/table/tbody/tr[1]/td[2]/span/span/a")).click();//worked till may 28th
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(text(),'Outgoing')]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[contains(text(),'PaymentTextFiles/')]")).click();
			Thread.sleep(5000);
			
			//Click on Last modified
			driver.findElement(By.xpath("//*[@id='objects-table']/div/div[3]/table/thead/tr/th[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='objects-table']/div/div[3]/table/thead/tr/th[3]")).click();
			Thread.sleep(5000);
			if(ProgramNameCheck.equalsIgnoreCase("Prolia"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Prolia')]"))));
			driver.findElement(By.xpath("//*[contains(text(),'Prolia')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Lucentis"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Ophthalmology')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("blincyto"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'blincyto')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'blincyto')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Imlygic"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Imlygic')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Imlygic')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Kanjinti"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Kanjinti')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Kanjinti')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Kyprolis"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Kyprolis')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Kyprolis')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Mvasi"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Mvasi')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Mvasi')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Nplate"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Nplate')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Nplate')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Vectibix"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Vectibix')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Vectibix')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Xgeva"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Xgeva')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Xgeva')]")).click();		
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Neulasta"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Neulasta')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Neulasta')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Neupogen"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Neupogen')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Neupogen')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Avsola"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Avsola')]"))));
			driver.findElement(By.xpath("//*[contains(text(),'Avsola')]")).click();
			Thread.sleep(10000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Inflectra"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Inflectra')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Inflectra')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Nivestym"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Nivestym')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Nivestym')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Ruxience"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Ruxience')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Ruxience')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Trazimera"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Trazimera')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Trazimera')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Zirabev"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Zirabev')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Zirabev')]")).click();
			      Thread.sleep(5000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Entyvio $5"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Entyvio5')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'Entyvio5')]")).click();
				Thread.sleep(10000);
			}  
			else if (ProgramNameCheck.equalsIgnoreCase("Entyvio Clinical $0"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Entyvio0')]")).click();
				Thread.sleep(10000);
				
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Herzuma"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Herzuma')]"))));
			driver.findElement(By.xpath("//*[contains(text(),'Herzuma')]")).click();
			Thread.sleep(10000);
				}
			else if (ProgramNameCheck.equalsIgnoreCase("Truxima"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Truxima')]"))));
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
				driver.findElement(By.xpath("//*[contains(text(),'TysabriCopayEx')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Copay New"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'TysabriCopayNew')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon Exist"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'TysabriCopayEx')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon New"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'TysabriCopayNew')]")).click();
				Thread.sleep(10000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Tysabri Procedure"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'TysabriProc')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Drug Reimbursement"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'JunoDrug')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'JunoDrug')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Admin Reimbursement"))
			{
			WebDriverWait wait1 = new WebDriverWait(driver, 90);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'JunoAdmin')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'AdminDrug')]")).click();
				Thread.sleep(10000);
			}
			else if(ProgramNameCheck.trim().equalsIgnoreCase("Ajovy Buy and Bill Savings Program"))
			{
				WebDriverWait wait1 = new WebDriverWait(driver, 90);
				wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'AjovyBBPgm')]"))));
				driver.findElement(By.xpath("//*[contains(text(),'AjovyBBPgm')]")).click();
				Thread.sleep(10000);
			}
			
			String finalFileName = driver.findElement(By.xpath("//div[@class='object-detail-header__header awsui-util-mb-m']/div[1][@class = 'awsui-util-action-stripe']/h1")).getText();
			System.out.println("Filename: "+finalFileName);
	
			driver.findElement(By.xpath("//span[contains(text(),'Object actions')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='object-detail-open-object-button']")).click();
			Thread.sleep(5000);
	     
	     
	Set<String> allwinHandel = driver.getWindowHandles();
	     
	     int winSize =  allwinHandel.size();
	     
	     for (String CurWinHande:allwinHandel){
	    	 
	    	 
	    	 if(!CurWinHande.equals(MainwidowHandle)){
	    		 
	    		 driver.switchTo().window(CurWinHande);
	    		 
	    		 Thread.sleep(3000);
	    	 }
	     }
	     
	boolean sts1=driver.findElement(By.xpath("/html/body/pre")).isDisplayed();
	     
	     String FileValue = driver.findElement(By.xpath("/html/body/pre")).getText();
	     
	     System.out.println(FileValue);
	     String[] totalrecords;
	    totalrecords = FileValue.split("\n");
	   
	    System.out.println(totalrecords);
	    int records=totalrecords.length;
	    String[][] arrRefNum=new String[records][50];
	    for(int looparray=0;looparray<records;looparray++)
	    {
	    arrRefNum[looparray] = totalrecords[looparray].split("\\|");
	 
	    }
	    
	    String DATE_FORMAT = "yyyyMMdd";
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	    Calendar c1 = Calendar.getInstance(); // today
	    System.out.println("Today is " + sdf.format(c1.getTime()));
	    
	    String DATE_FORMAT1 = "MM/dd/yyyy";
	    SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT1);
	    Calendar c2 = Calendar.getInstance(); // today
	    System.out.println("Today is " + sdf.format(c2.getTime()));
	    
	    
	    
	    String HeaderCheckFile="Payee_ID|CheckNbr|CheckDate|CheckAmt|Vendid|Vendor_Name";
	    String FileName1="CHK_ALL_";
	    String FileName2=sdf.format(c1.getTime());
	    String FileName3 = null;
	    if(ProgramNameCheck.equalsIgnoreCase("Prolia"))
		{		
	    	   FileName3="_AFS_PROLIA_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("blincyto"))
		{
	        FileName3="_AFS_Blincyto_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Imlygic"))
		{
			  FileName3="_AFS_Imlygic_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Kanjinti"))
		{
			  FileName3="_AFS_Kanjinti_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Kyprolis"))
		{
			   FileName3="_AFS_Kyprolis_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Mvasi"))
		{
			  FileName3="_AFS_Mvasi_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Nplate"))
		{
			  FileName3="_AFS_Nplate_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Vectibix"))
		{
			  FileName3="_AFS_Vectibix_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Xgeva"))
		{
			  FileName3="_AFS_Xgeva_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Neulasta"))
		{
			  FileName3="_AFS_Neulasta_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Neupogen"))
		{
			  FileName3="_AFS_Neupogen_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("avasola"))
		{
	        FileName3="_AFS_avasola_";
		}

	    else if(ProgramNameCheck.equalsIgnoreCase("Inflectra"))
		{
		
	    	   FileName3="_AFS_Inflectra_";
		  
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Nivestym"))
		{
	        FileName3="_AFS_Nivestym_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Ruxience"))
		{
			  FileName3="_AFS_Ruxience_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Trazimera"))
		{
			  FileName3="_AFS_Trazimera_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Zirabev"))
		{
			   FileName3="_AFS_Zirabev_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Entyvio $5"))
		{
			   FileName3="_AFS_Entyvio $5_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Entyvio Clinical $0"))
		{
			   FileName3="_AFS_Entyvio0_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Herzuma"))
		{
			   FileName3="_AFS_Herzuma_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Truxima"))
		{
			   FileName3="_AFS_Truxima_";
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Spinraza"))
		{
			   FileName3="_AFS_Spinraza_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Tysabri Copay Exist"))
		{
			   FileName3="_AFS_Tysabri Copay Exist_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Tysabri Copay New"))
		{
			   FileName3="_AFS_Tysabri Copay New_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon Exist"))
		{
			   FileName3="_AFS_Tysabri Coupon Exist_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Tysabri Coupon New"))
		{
			   FileName3="_AFS_Tysabri Coupon New_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Tysabri Procedure"))
		{
			   FileName3="_AFS_Tysabri Procedure_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Drug Reimbursement"))
		{
			   FileName3="_AFS_DrugReimbursement_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Admin Reimbursement"))
		{
			   FileName3="_AFS_AdminReimbursement_"; 
		}
		else if(ProgramNameCheck.equalsIgnoreCase("Ajovy Buy and Bill Savings Program"))
		{
			   FileName3="_AJB_DrugReimbursement_"; 
		}
	    
		
	    String FileName4="|";
	    int counter=1;
	    String FileName5="000"+ counter;
	   
	    String FileName6="Check to Practice";
	    String FileName7=" ";
	    String FileName8=".txt";
	    String FinalFileName=FileName1+FileName2+FileName3+FileName5+FileName8;
	    Reporter.log("Check all file is uploaded: " +FinalFileName );
	   	  String DateinCheckFile=sdf1.format(c2.getTime());
	    
	   	  	Thread.sleep(1000);
	   	  	driver.close();
	        driver.switchTo().window(MainwidowHandle);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String TestFile = System.getProperty("user.dir") + "\\" + FinalFileName;
	 		  File FC = new File(TestFile);//Created object of java File class.
	 		  FC.createNewFile();//Create file.
	 		  
	 		  //Writing In to file.
	 		  //Create Object of java FileWriter and BufferedWriter class.
	 		
	 	    
	 		  FileWriter FW = new FileWriter(TestFile);
	 		  BufferedWriter BW = new BufferedWriter(FW);
	 		  BW.write(HeaderCheckFile); //Writing In To File.
	 		  BW.newLine();
	 	
	 		  for(int filecounter=1;filecounter<records;filecounter++)
	 		  {
	 			 String CheckNbr="58380"+ counter;

	 			  BW.write (arrRefNum[filecounter][3]);
	 			  BW.write(FileName4);
		 		  BW.write(CheckNbr);
		 	     BW.write(FileName4);
		 		 BW.write(DateinCheckFile);
		 		 BW.write(FileName4);
		 		 BW.write (arrRefNum[filecounter][15]);
		 		 BW.write(FileName4);
		 		 BW.write (arrRefNum[filecounter][1]);
		 		BW.write(FileName4);
		 		BW.write (arrRefNum[filecounter][1]);
		 		BW.write(FileName7);
		 		BW.write(FileName6);
		 		 BW.newLine();
		 		 counter=counter+1;
	 		  }
	 		  
	 		
	 		 
	 		 
	 		 
	 		  
	 		 
	 		  BW.close();
	 		  
	 		  //Reading from file.
	 		  //Create Object of java FileReader and BufferedReader class.
	 		  FileReader FR = new FileReader(TestFile);
	 		  BufferedReader BR = new BufferedReader(FR);
	 		  String Content = "";
	 		  
	 		  //Loop to read all lines one by one from file and print It.
	 		  while((Content = BR.readLine())!= null){
	 			   System.out.println(Content);
	 			  
	  			  }
	 		
				Thread.sleep(2000);
						
			 driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).click(); //after copying the data again click s3
			 driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).sendKeys("S3"); //updated on 12012021
				System.out.println("I am clicking the search button");
			Thread.sleep(5000);
			
			System.out.println("Select s3 from the list");
			driver.findElement(By.xpath("//h3/a/span")).click();
			System.out.println("Selected S3 from the list");
			Thread.sleep(15000);
			
	     
			Thread.sleep(5000);
			System.out.println("Click on affordability-qa-buyandbill-files");
			driver.findElement(By.xpath("//*[@id='buckets-table']/div/div[3]/table/tbody/tr[1]/td[2]/span/span/a")).click();//worked till may 28th
			
			
			driver.findElement(By.xpath("//*[contains(text(),'Incoming')]")).click();
			Thread.sleep(5000);
			
		
			//click on Check files folder
			driver.findElement(By.xpath("//*[@id='objects-table']/div/div[3]/table/tbody/tr[4]/td[2]/span/span/span/a/span")).click();
			Thread.sleep(5000);
			
			//CLick on upload button
			driver.findElement(By.xpath("//*[@id='upload-button']/button/span")).click();
			Thread.sleep(5000);
			
			//click on add files
			driver.findElement(By.xpath("//awsui-button[2]/button/span")).click();
			
			String filename = FinalFileName;
			
			String fileLocation = System.getProperty("user.dir") + "\\" + FinalFileName;
			Thread.sleep(10000);
			
			uploadFile(fileLocation);
			Thread.sleep(7000);
		
			
			WebElement abc= driver.findElement(By.xpath("//awsui-table/div/div[3]/table/thead/tr/td"));//select the check box after upload
			abc.click();
			Thread.sleep(3000);
						
		
			//Thread.sleep(3000);
						
			driver.findElement(By.xpath("//button/span[contains(text(),'Upload')]")).click(); //Click on upload button
			Thread.sleep(3000);
			
			
			boolean rst= driver.findElement(By.xpath("//*[contains(text(),'Upload succeeded')]")).isDisplayed();
			System.out.println(rst);
			
			if (rst==true) {
				
				System.out.println("File uploaded in AWS");
				Thread.sleep(3000);
				
			}
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

		
		WebElement faxTable = driver.findElement(By.xpath("//table[@class='table table-hover mat-table']"));
		List<WebElement> noofRows = faxTable.findElements(By.tagName("tr"));

		return noofRows;
	}
	
	public static List<WebElement> NumOfRowsPayment() {

		
		WebElement faxTable = driver.findElement(By.xpath("//table"));
		List<WebElement> noofRows = faxTable.findElements(By.tagName("tr"));

		return noofRows;
	}
	}


