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


public class TC06_AWS_S3_MaxAccum_Upload_Check_Clear extends TestBase {
	

	TestUtil testUtil;
	String sheetname = "CTP";
	public static WebDriver driver;
	public static String MemberPayment;
	public static String PaymentAmount;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\juno\\qa\\testdata\\XolairTestData.xlsx";
	static Xls_Reader reader2 = new Xls_Reader(TESTDATA_SHEET_PATH);
	
	E2EWorkflow_TestData dat = new E2EWorkflow_TestData();
	ExcelTestDataReader etd = new ExcelTestDataReader();
	String Key = "CTPData";	
	   
	public TC06_AWS_S3_MaxAccum_Upload_Check_Clear()
	{
	//	super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before Method started");
	//	initialization("Payment");
		TestBase.classAInstance.StartTest(this.getClass().getSimpleName());
		System.out.println("Before Method completed");
		
}
	

	
	@Test()
	public void AWS_S3_Upload_Check_Clear() throws InterruptedException, IOException, AWTException 
 
	
	{
		String browsername = "Chrome"; 
		if (browsername.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
		}
		
		 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			
	/*	int rwCount = reader2.getRowCount("CTM");
		rwCount = Xls_Reader.sheet.getLastRowNum(); */
			
			//Row row;
			//Cell cell;
			
			
			String URL = "https://myapps.microsoft.com/signin/AWS_Console/6088ac6b-1432-490d-a6cb-f940f06dbcb9?tenantId=ed28afd7-821e-40af-bf1a-24170859ba17";
			driver.get(URL);
			Thread.sleep(20000);
			String uname = prop.getProperty("CurentUserName");
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
			
       boolean check1=false;
			
			for (int refresh = 0; refresh < 10 && !check1 == true; refresh++) {
//				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='content']/div/h1/span[1]"))));
//				check1=driver.findElement(By.xpath("//*[@id='content']/div/h1/span[1]")).isDisplayed();
//				if (check1==false)
//				{
//					driver.get(URL);
//					Thread.sleep(10000);
//				}
				
				}
		/*	Row row;
			Cell cell;
			row = Xls_Reader.sheet.getRow(1);
			cell = row.getCell(2);
			String ProgramNameCheck=cell.getStringCellValue(); */
			
			int rowNum = etd.getKeyValuePair(Key);
			List<String> testData = new ArrayList<String>();
			testData = dat.GetCTPDataForPaymentApproval(Key, rowNum);
			
			String ProgramNameCheck = testData.get(1);
			System.out.println(ProgramNameCheck);
			
			String MainwidowHandle = driver.getWindowHandle();

			//WebDriverWait wait = new WebDriverWait(driver, 60);
			//Switch to QA Environment
			//driver.findElement(By.xpath("//*[@id='nav-usernameMenu']/div[2]")).click(); updated on 9/21/2020
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
		

			Thread.sleep(20000);
			System.out.println("inside 1");
			//driver.findElement(By.xpath("//*[@id='nav-servicesMenu']/div[2]")).click();//updated on 9/25/2020
			//driver.findElement(By.xpath("//*[@id='search-box-input']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).sendKeys("S3"); //updated on 12012021
			Thread.sleep(5000);
			
			System.out.println("Select s3 from the list");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h3/a/span")).click();
			//driver.findElement(By.xpath("//*[@id='awsc-services-container']/ul[1]/li[11]/a/span")).click();//updated on 9/25/2020
			//driver.findElement(By.xpath("//*[@id='search-box-input-dropdown-s3']/awsui-select-option/div")).click();
			System.out.println("Selected S3 from the list");
			Thread.sleep(15000);
			System.out.println("Click on affordability-qa-buyandbill-files");
			//driver.findElement(By.xpath("//*[@id='sidebarNavDiv']/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='buckets-table']/div/div[3]/table/tbody/tr[1]/td[2]/span/span/a")).click();//worked till 28th may
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
				//*[@id="mat-option-48"]/span
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
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Nivestym"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Nivestym')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Ruxience"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Ruxience')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Trazimera"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Trazimera')]")).click();
			      Thread.sleep(5000);
			}
			else if(ProgramNameCheck.equalsIgnoreCase("Zirabev"))
			{
				driver.findElement(By.xpath("//*[contains(text(),'Zirabev')]")).click();
			      Thread.sleep(5000);
			}
			else if (ProgramNameCheck.equalsIgnoreCase("Entyvio $5"))
			{
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
	      
			driver.findElement(By.xpath("//span[contains(text(),'Object actions')]")).click();
			Thread.sleep(1000);
			// driver.findElement(By.xpath("//li[contains(text(),'Open')]")).click(); updated on 6/10/2021
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
	    SimpleDateFormat ssdf = new SimpleDateFormat(DATE_FORMAT);
	    Calendar c1 = Calendar.getInstance(); // today
	    System.out.println("Today is " + ssdf.format(c1.getTime()));
	    
	    String DATE_FORMAT1 = "MM/dd/yyyy";
	    SimpleDateFormat ssdf1 = new SimpleDateFormat(DATE_FORMAT1);
	    Calendar c2 = Calendar.getInstance(); // today
	    System.out.println("Today is " + ssdf1.format(c2.getTime()));
	    
	    
	    
	   // String HeaderCheckFile="Payee_ID|CheckNbr|CheckDate|CheckAmt|Vendid|Vendor_Name";
	    String FFileName1="CHK_CLEAR_";
	    String FFileName2=ssdf.format(c1.getTime());
	    //String FileName3="_AFS_PROLIA_";
	    String FFileName4="|";
	  int ccounter=1;
	    String FFileName5="_000"+ ccounter;
	   
	    String FFileName6="Check to Practice";
	    String FFileName7=" ";
	    //String PPayeeId=arrRefNum[52].trim();
	    //String VVendId=arrRefNum[50].trim();
	    //String CCheckAmt=arrRefNum[64].trim();
	    String FFileName8=".txt";
	    String FFinalFileName=FFileName1+FFileName2+FFileName5+FFileName8;
	  //  String CCheckNbr="58380"+ ccounter;
	    //ccounter=ccounter+1;
	    String DDateinCheckFile=ssdf1.format(c2.getTime());
	    
	   int size= arrRefNum.length;
	//   for(int a=0;a<=size;a++)
	 // {
		//  System.out.println(arrRefNum[a]);
	  //}
	    
	    
	    
	    driver.close();
	        driver.switchTo().window(MainwidowHandle);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String TestFile = System.getProperty("user.dir") + "\\" + FFinalFileName;
	 		  File FC = new File(TestFile);//Created object of java File class.
	 		  FC.createNewFile();//Create file.
	 		  
	 		  //Writing In to file.
	 		  //Create Object of java FileWriter and BufferedWriter class.
	 		  FileWriter FW = new FileWriter(TestFile);
	 		  BufferedWriter BW = new BufferedWriter(FW);
	 		//  BW.write(HeaderCheckFile); //Writing In To File.
	 		  //BW.newLine();
	 		 for(int filecounter=1;filecounter<records;filecounter++)
	 		  {
	 			 String CCheckNbr="58380"+ ccounter;
	 			 BW.write(arrRefNum[filecounter][1]);
	 		 BW.write(FFileName4);
	 		 BW.write(arrRefNum[filecounter][3]);
	 		BW.write(FFileName4);
	 		 BW.write(arrRefNum[filecounter][15]);
	 		 BW.write(FFileName4);
	 		 BW.write(CCheckNbr);
	 		 BW.write(FFileName4);
	 		 BW.write(DDateinCheckFile);
	 		 BW.newLine();
	 		ccounter=ccounter+1;
	 		  }
	 	
	 		  
	 		  
	 		/*  BW.write(PayeeId);
	 		  BW.write(FileName4);
	 		  BW.write(CheckNbr);
	 		 BW.write(FileName4);
	 		 BW.write(DateinCheckFile);
	 		 BW.write(FileName4);
	 		 BW.write(CheckAmt);
	 		 BW.write(FileName4);
	 		 BW.write(VendId);
	 		BW.write(FileName4);
	 		 BW.write(VendId);
	 		BW.write(FileName7);*/
	 		
	 		
	 		 
	 		 
	 		 
	 		  
	 		 
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
	 		  Thread.sleep(4000);
	 		
	      
	 		//driver.findElement(By.xpath("//*[@id='search-box-input']")).click(); // updated on 9/27/2020
		      //driver.findElement(By.xpath("//*[@id='nav-servicesMenu']/div[2]")).click();
//				driver.findElement(By.xpath("//*[@id='awsc-nav-header']/div[1]/div[2]")).click();
				Thread.sleep(2000);
			/*	driver.findElement(By.xpath("//*[@id='search-widget-input']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='search-widget-input']")).sendKeys("S3");
				driver.findElement(By.xpath("//*[@id='search-widget-result-s3']")).click();
				
	 	
	      
			Thread.sleep(5000);
			System.out.println("Select s3 from the list");
			//driver.findElement(By.xpath("//*[@id='awsc-services-container']/ul[1]/li[14]/a/span")).click();
		//	driver.findElement(By.xpath("//*[@id='awsc-services-container']/ul[1]/li[11]/a/span")).click();
			Thread.sleep(5000);*/
				 driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).click(); //after copying the data again click s3
				 driver.findElement(By.xpath("//*[@id='awsc-nav-header']/nav/nav/div[1]/div[2]/div/div/div[1]/input[2]")).sendKeys("S3"); //updated on 12012021
				Thread.sleep(5000);
				
				System.out.println("Select s3 from the list");
				driver.findElement(By.xpath("//h3/a/span")).click();
				//driver.findElement(By.xpath("//*[@id='awsc-services-container']/ul[1]/li[11]/a/span")).click();//updated on 9/25/2020
				//driver.findElement(By.xpath("//*[@id='search-box-input-dropdown-s3']/awsui-select-option/div")).click();
				System.out.println("Selected S3 from the list");
				Thread.sleep(15000);
			System.out.println("Click on affordability-qa-buyandbill-files");
			driver.findElement(By.xpath("//*[@id='buckets-table']/div/div[3]/table/tbody/tr[1]/td[2]/span/span/a")).click();//worked till 28th may
			//driver.findElement(By.xpath("//*[@id='sidebarNavDiv']/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/a")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[contains(text(),'Incoming')]")).click();
			Thread.sleep(5000);
			
		/*	driver.findElement(By.xpath("//*[contains(text(),'Check')]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div/awsui-button[1]/button/span[2]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id='uploadInputNoFilesSelected']")).click();
			Thread.sleep(10000); */
			//click on Check files folder
			driver.findElement(By.xpath("//*[@id='objects-table']/div/div[3]/table/tbody/tr[4]/td[2]/span/span/span/a/span")).click();
			Thread.sleep(5000);
			
			//CLick on upload button
			driver.findElement(By.xpath("//*[@id='upload-button']/button/span")).click();
			Thread.sleep(5000);
			
			//click on add files
			driver.findElement(By.xpath("//awsui-button[2]/button/span")).click();
			
			//String filename = FFinalFileName;
			String fileLocation = System.getProperty("user.dir") + "\\" + FFinalFileName;
			Thread.sleep(10000);
			System.out.println(fileLocation);
			uploadFile(fileLocation);
			
			Thread.sleep(7000);
		/*	String verifyUpldFilename = driver
					.findElement(By.xpath("//p[@class='modal-selected-files-file-name ng-binding']")).getText();
			System.out.println(verifyUpldFilename);
			Reporter.log("The Check Clear File name is:" + verifyUpldFilename );
			Thread.sleep(3000);
			if (verifyUpldFilename.equalsIgnoreCase(FFinalFileName)) {
				System.out.println("File uploaded in AWS");
				Thread.sleep(3000);
				String fileDetail = driver
						.findElement(
								By.xpath("//div[@class='upload-modal-selected-files-properties-inner-div truncate']"))
						.getText();
				
				System.out.println(fileDetail);
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='uploadModal']/div/div[1]/div[3]/div[2]/modal-footer/div/awsui-button[1]/button/span")).click();
			Thread.sleep(5000);
			System.out.println("Check file uploaded  successfullly");
			
		//	Thread.sleep(600000);*/
			
			WebElement abc= driver.findElement(By.xpath("//awsui-table/div/div[3]/table/thead/tr/td"));//select the check box after upload
			abc.click();
			Thread.sleep(3000);
						
			//driver.findElement(By.xpath("//awsui-form-field/div/div/div/div/span/awsui-checkbox")).click(); //acknowledge the  checkbox
			//Thread.sleep(3000);
						
			driver.findElement(By.xpath("//button/span[contains(text(),'Upload')]")).click(); //Click on upload button
			Thread.sleep(3000);
			
			
			boolean rst= driver.findElement(By.xpath("//*[contains(text(),'Upload succeeded')]")).isDisplayed();
			System.out.println(rst);
			if(driver.findElement(By.xpath("//*[contains(text(),'Upload succeeded')]")).isDisplayed())
	        {
				TestBase.classAInstance.logReport("Pass","AWS check all","Succesfully able to add Check Clear file");
					}
				   else
				   {
					    TestBase.classAInstance.logReport("Fail","AWS check all","Failed to add add Check Clear file");
		   }
			
			
			
			if (rst==true) {
				
				System.out.println("File uploaded in AWS");
				Thread.sleep(3000);
			}
				
		    driver.quit();
			
}	    	
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException, AWTException {
//		if(result.getStatus()== ITestResult.SUCCESS){
//			TestBase.classAInstance.logReport("Pass", "Max Accum payment", "Succesfully uploaded  check Clear file");
//			} else {
//			TestBase.classAInstance.logReport("Fail", "Max Accum payment", "Failed to uploaded  check Clear file");
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


