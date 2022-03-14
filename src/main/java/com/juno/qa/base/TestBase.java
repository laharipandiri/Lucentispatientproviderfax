package com.juno.qa.base;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.juno.qa.pages.HubHomeLoginLogoutPage;
import com.juno.qa.util.*;
import com.qa.ExtentReportListener.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
public class TestBase {
	
	 
	public static WebDriver driver;
	public static Properties prop;
	public static int counter;
	public static String ScreenShotPath;
	public static String ConstantTimeStamp;
	public static int ScreenShotCounter=1;
	public static String ChangeUser=""; 
	public static String UserName=""; 
	public static String PWD=""; 
	public static ExtentTest test;
	public static ExtentReports extent;
	public static Map<Integer, String> testStatusRef;
	public static StringWriter sw = new StringWriter();
	public static TestBase classAInstance = new TestBase();
	public static String PASS = "Pass";
	public static String FAIL = "Fail";
	public static String SKIP = "Skiped";
	public static String SUCCESS_PERCENTAGE_FAILURE = "Failed with condition";

	public static String fileSeperator = System.getProperty("file.separator");

	public static String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
					+ "screenshots\\";

	public TestBase() {
		/* Constructor to read property file */
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\juno\\qa\\config\\config.properties");
			prop.load(ip);
			testStatusRef = new HashMap<Integer, String>();
			testStatusRef.put(1,PASS);
			testStatusRef.put(2,FAIL);
			testStatusRef.put(3,SKIP);
			testStatusRef.put(4,SUCCESS_PERCENTAGE_FAILURE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startReport(String mypath){
		 System.out.println("******* this is in startReport ******************");
			 
			 ExtentManager ext = new ExtentManager();
	         mypath= ExtentManager.reportFileLocation;
	         try{
	        // extent = new ExtentReports(mypath,false); //Commented for extent report 5
	        	 extent = ext.getInstance(); //added for extent report 5
	         }catch(Exception e){
	               System.out.println("Report already Created Moving on to the next Step");
	         }
	         String extnPath=System.getProperty("user.dir") + "\\config.xml";
	        // extent.loadConfig(new File(extnPath)); //Commented for extent report 5
	         ConstantTimeStamp = CommonFunctions.getTimeStamp();
	         reportsPath = CommonFunctions.createScreenShotFolder();
	      //test = extent.startTest(CalssName,"Test Report");
	   }
	   
	public void StartTest(String CalssName){
    	 ExtentManager ext = new ExtentManager();
		 extent = ext.getInstance();
		 
	   test = extent.createTest(CalssName,"Test Report");
        System.out.println("***************** ###########"+CalssName);
  }
	   
	   public void logReport(String Status1, String Steps, String Actual) throws IOException, AWTException{
		 	  
	 	  	String filepath;
	         if(Status1.equalsIgnoreCase("Pass")){
	               filepath = CommonFunctions.snapShot("Success"+ScreenShotCounter+".jpg",reportsPath);
	              // System.out.println("The file path inside pass is:" +filepath);
	               test.log(Status.PASS,Actual);
	       //  test.log(Status.PASS,"Test case pass Screen shot " +test.addScreenCaptureFromBase64String(filepath));
	               test.pass(MarkupHelper.createLabel(Steps, ExtentColor.GREEN));
	        // 	test.log(Status.PASS,Steps +MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	               test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	         ScreenShotCounter=ScreenShotCounter+1;
	       //  System.out.println(" No.of screenshots are ...>" +ScreenShotCounter);
	         }
	         else {
	      
	             filepath = CommonFunctions.snapShotFail("Error"+ScreenShotCounter+".jpg",reportsPath);
	             System.out.println("The file path inside Failed is:" +filepath);
	         test.log(Status.FAIL,Actual);
	         test.fail(MarkupHelper.createLabel(Steps, ExtentColor.RED));
	     //    test.log(Status.FAIL,"Test case pass Screen shot " +test.addScreenCaptureFromBase64String(filepath));
	       //  test.log(Status.FAIL,Steps +MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	         test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	          ScreenShotCounter=ScreenShotCounter+1;    
	         }
	   }
	   public void endReport(){
		   extent.flush(); //Anu
	   } 
	
	public static void initialization(String mode)
	/* Method for Browser and webdriver initialization */

	{
		String browsername = prop.getProperty("Browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
			
		    driver = new ChromeDriver();
		    ChromeOptions options = new ChromeOptions();

		    options.addArguments("no-sandbox");

		    options.addArguments("disable-extensions");

		    driver = new ChromeDriver(options);
			
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		boolean isInitialized = false;
		if (mode == "Admin") {
			driver.get(prop.getProperty("AdminUrl"));
		} else if (mode == "Hub") {
			driver.get(prop.getProperty("HubUrl"));
		
		}

	}


	public static void intializeHubDriver() throws InterruptedException
	/* Method for Browser and webdriver initialization */
	{HubHomeLoginLogoutPage ddd=new HubHomeLoginLogoutPage();
		String browsername = prop.getProperty("Browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("HCPUrl"));
	
		Thread.sleep(6000);
		ddd.Cookie().click();
		Thread.sleep(4000);
	
	}
	
	public static void intializeHubDriverPopUp() throws InterruptedException
	/* Method for Browser and webdriver initialization */
	
	{
		HubHomeLoginLogoutPage ddd=new HubHomeLoginLogoutPage();
		String browsername = prop.getProperty("Browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("HCPPopUpUrl"));
		Thread.sleep(6000);
		
		ddd.Cookie().click();
		Thread.sleep(4000);
	}
	
	public static void intializePatientDriverPopUp() throws InterruptedException
	/* Method for Browser and webdriver initialization */
	{
		String browsername = prop.getProperty("Browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("PatientPopUpUrl"));
		
		Thread.sleep(6000);
		HubHomeLoginLogoutPage ddd=new HubHomeLoginLogoutPage();
		ddd.Cookie().click();
		Thread.sleep(2000);
		ddd.ClickClose();
		Thread.sleep(2000);
		ddd.ClickCloseBtn();
		Thread.sleep(2000);
	}
	
	public static void intializeAdminDriver() throws InterruptedException
	/* Method for Browser and webdriver initialization */

	{
		String browsername = prop.getProperty("Browser");
		
		
		System.out.println(browsername);
	
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
			
					  //driver = new ChromeDriver();
			    ChromeOptions options = new ChromeOptions();

			    options.addArguments("no-sandbox");

			    options.addArguments("disable-extensions");
			    options.addArguments("--disable-gpu");
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			    driver = new ChromeDriver(options);
				
			
			
			
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("AdminUrl"));
		Thread.sleep(2000);
		}
	
	
	
	public static void closeBrowser()
	{	
		//Method to close the browser
		driver.quit();
		System.out.println("The browser has been closed");

	}
	
	//encoded way-Base64
		public String getScreenshotAsBase64() throws IOException{

			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+"/Screenshots/googlesearchscreenshot.png";
			FileUtils.copyFile(source, new File(destination));
			byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destination));

			return Base64.getEncoder().encodeToString(imageBytes);
		}
	
}
