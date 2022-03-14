package com.qa.ExtentReportListener;

import java.awt.AWTException;
import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.juno.qa.base.TestBase;



public class TestNGListner implements ITestListener {

	public static String timeStamp;
	String concatenate = ".";

	public void onFinish(ITestContext context) {
		//System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		//ExtentTestManager.endTest(); //commented on 9/8/2020
		//ExtentManager.getInstance().flush();  //commented on 9/8/2020
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		TestBase.classAInstance.startReport(ExtentManager.reportFilepath); //added on 9/8/2020
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) { //Commented for extent report 5
		
	/*	TestBase tb = new TestBase();
		
		try {
			tb.logReport( "Fail",  "Test Step Should Pass",  "TestCase Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	// TODO Auto-generated method stub

	public void onTestSkipped(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		//System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		String modelId="0";
		String modelIdArray[] = result.toString().split("output=");
		modelId = modelIdArray[1];
	    modelId = modelId.replaceAll("]", "");
	 // ExtentTestManager.getTest().log(Status.PASS, "Test passed"); //Commented on 9/8/2020
	//  ExtentTestManager.getTest().info(MarkupHelper.createLabel(modelId, ExtentColor.BLUE)); //Commented on 9/8/2020
	}

	public void onTestStart(ITestResult result) {
		//System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		//ExtentTestManager.startTest(result.getMethod().getMethodName());//Commented on 9/8/2020
	}

}
