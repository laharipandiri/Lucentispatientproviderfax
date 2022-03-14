package com.AWS.qa.base;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.ExtentReportListener.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.AWS.qa.util.CommonFunctions;
import com.AWS.qa.util.TestUtil;



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
	public static TestBase classAInstance = new TestBase();

	public static String fileSeperator = System.getProperty("file.separator");

	public static String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
					+ "screenshots\\";

	public TestBase() {
		/* Constructor to read property file */
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\AWS\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(String mode)
	/* Method for Browser and webdriver initialization */

	{
		String browsername = prop.getProperty("Browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("no-sandbox");
			options.addArguments("disable-extensions");
			WebDriver driver = new ChromeDriver(options);
		

			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// driver.get(prop.getProperty("PatientPortalUrl"));//AdminURL//PatientPortalUrl

		if (mode == "Payment") {
			driver.get(prop.getProperty("PaymentUrl"));
		} else if (mode == "AWS") {
			driver.get(prop.getProperty("AWSUrl"));
		}

	}
	
	public void startReport(String mypath){
		 
		 System.out.println("******* this is in startReport ******************");
		 ExtentManager ext = new ExtentManager();
        mypath= ExtentManager.reportFileLocation;
        try{
      //  extent = new ExtentReports(mypath,false);
          	 extent = ext.getInstance();
        
        }catch(Exception e){
              System.out.println("Report already Created Moving on to the next Step");
        }
        String extnPath=System.getProperty("user.dir") + "\\config.xml";
       //extent.loadConfig(new File(extnPath));
        ConstantTimeStamp = CommonFunctions.getTimeStamp();
        reportsPath = CommonFunctions.createScreenShotFolder();

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
              System.out.println("The file path inside pass is:" +filepath);
              System.out.println("String 1############## "+Actual);
              System.out.println("String 2###############"+Status.PASS);
              //test.log(Status.PASS,Actual);
      //  test.log(Status.PASS,"Test case pass Screen shot " +test.addScreenCaptureFromBase64String(filepath));
              test.pass(MarkupHelper.createLabel(Steps, ExtentColor.GREEN));
       // 	test.log(Status.PASS,Steps +MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
              test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
        ScreenShotCounter=ScreenShotCounter+1;
        System.out.println(" No.of screenshots are ...>" +ScreenShotCounter);
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

//encoded way-Base64
	public String getScreenshotAsBase64() throws IOException{

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/Screenshots/googlesearchscreenshot.png";
		FileUtils.copyFile(source, new File(destination));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destination));

		return Base64.getEncoder().encodeToString(imageBytes);
	}

	
}