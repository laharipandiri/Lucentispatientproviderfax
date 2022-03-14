package com.qa.ExtentReportListener;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.SystemAttributeContext;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.juno.qa.util.TestUtil;
//import com.biooncology.qa.util.TestUtil;


public class ExtentManager {
    private static ExtentReports extent;
    //private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String reportFileName = "Test-Automaton-Report"+ TestUtil.getTimeStamp() +""+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    public static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    public static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
   
   // public static ExtentTest test;
  
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
      //  System.out.println("The location is:" + reportFileLocation);
        
        String reportFileName = "Test-Automaton-Report"+ TestUtil.getTimeStamp() +""+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName + "//" + reportFileName).viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
       // ExtentSparkReporter spark1 = new ExtentSparkReporter("target/index.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle(reportFileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(reportFileName);
        
        
    /*    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName); */
        
     //   SystemAttributeContext Browser = null;
	//	htmlReporter.setSystemAttributeContext(Browser);
   //     htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(spark);
    //    extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");
		//System.out.println("I am inside createInstance:" + extent);
        return extent;
    }
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 
}
