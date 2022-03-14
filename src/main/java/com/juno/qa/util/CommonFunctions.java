package com.juno.qa.util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

//import regressionSuit.DriverScript.MasterScript;

public class CommonFunctions extends TestBase {
	
	public static int  iScreenCounter=1;

	public boolean clickobjecById(WebDriver drv, String Property, String ElementName) {
		boolean result = false;

		try {
			drv.findElement(By.id(Property)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean clickobjecByLinkText(WebDriver drv, String Property, String ElementName) {
		boolean result = false;

		try {
			drv.findElement(By.linkText(Property)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean clickobjecByPartialLinkText(WebDriver drv, String Property, String ElementName) {
		boolean result = false;

		try {
			drv.findElement(By.partialLinkText(Property)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean clickobjecByName(WebDriver drv, String Property, String ElementName) {
		boolean result = false;

		try {
			drv.findElement(By.name(Property)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean EditTextById(WebDriver driver, String Property, String ElementValue) {
		boolean result = false;

		try {
			driver.findElement(By.id(Property)).click();
			driver.findElement(By.id(Property)).sendKeys(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean EditTextByXpath(WebDriver driver, String Property, String ElementValue) {
		boolean result = false;

		try {
			driver.findElement(By.xpath(Property)).click();
			driver.findElement(By.xpath(Property)).sendKeys(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean EditTextByName(WebDriver drv, String Property, String ElementValue) {
		boolean result = false;

		try {
			drv.findElement(By.name(Property)).sendKeys(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean SelectValueById(WebDriver drv, String Property, String ElementValue) {
		boolean result = false;

		try {
			Select se = new Select(drv.findElement(By.id(Property)));
			se.selectByVisibleText(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean SelectValueByName(WebDriver drv, String Property, String ElementValue) {
		boolean result = false;

		try {
			Select se = new Select(drv.findElement(By.name(Property)));
			se.selectByVisibleText(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean SelectValueByXpath(WebDriver drv, String Property, String ElementValue) {
		boolean result = false;

		try {
			Select se = new Select(drv.findElement(By.xpath(Property)));
			se.selectByVisibleText(ElementValue);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean clickobjecByXpath(WebDriver drv, String Property, String ElementName) {
		boolean result = false;

		try {
			drv.findElement(By.xpath(Property)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public String GetValueXpath(WebDriver drv, String Property, String ElementName) {
		String result = "";

		try {
			WebElement myele = drv.findElement(By.xpath(Property));
			result = myele.getText();

		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public boolean clickobjecByWeblementXpath(WebDriver drv, String Property, String Secondpath) {
		boolean result = false;

		try {
			WebElement ele = drv.findElement(By.xpath(Property));
			ele.findElement(By.xpath(Secondpath)).click();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;

		}

		return result;
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public boolean UploadOperation(String fileLocation) throws Exception {

		boolean result = false;
		try {
			// Setting clipboard with file location

			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(2000);
			setClipboardData(fileLocation);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			result = true;
		} catch (Exception exp) {
			exp.printStackTrace();
			result = false;
		}
		return result;
	}

	
	public static String screenshot(WebDriver drv, String ScreName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) drv;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dest = "D:\\FrameWork\\Snap\\" + ScreName + ".png";
			File destination = new File(dest);
			// FileUtils.copyFile(src, destination);
			System.out.println("screen captured");
			return dest;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	public int SelectRandomState(List<WebElement> statesList)
	{
		int size = statesList.size();
		System.out.println("Size of states drop down: "+size);
		int randomStateNumber = ThreadLocalRandom.current().nextInt(1, size);//specified from 1 to size because the first option is not a state in the drop down
		return randomStateNumber;
	}
	
	public int SelectRandomInsuranceName(List<WebElement> insuranceNames)
	{
		int size = insuranceNames.size();
		System.out.println("Size of insurances drop down: "+size);
		int randomInsNum = ThreadLocalRandom.current().nextInt(1, size);//specified from 1 to size because the first option is not a ins name in the drop down
		return randomInsNum;
	}
	
	public String GetResidingStateName(String stateCD)
	{
		switch(stateCD) {
		  case "AL":
			 return "Alabama";
		  case "AK":
			  return "Alaska";
		  case "AZ":
			  return "Arizona";
		  case "AR":
			  return "Arkansas";
		  case "CA":
			  return "California";
		  case "CO":
			  return "Colorado";
		  case "CT":
			  return "Connecticut";
		  case "DE":
			  return "Delaware";
		  case "FL":
			  return "Florida";
		  case "GA":
			  return "Georgia";
		  case "HI":
			  return "Hawaii";
		  case "ID":
			  return "Idaho";
		  case "IL":
			  return "Illinois";
		  case "IN":
			  return "Indiana";
		  case "IA":
			  return "Iowa";
		  case "KS":
			  return "Kansas";
		  case "KY":
			  return "Kentucky";
		  case "LA":
			  return "Louisiana";
		  case "ME":
			  return "Maine";
		  case "MD":
			  return "Maryland";
		  case "MA":
			  return "Massachusetts";
		  case "MI":
			  return "Michigan";
		  case "MN":
			  return "Minnesota";
		  case "MS":
			  return "Mississippi";  
		  case "MO":
			  return "Missouri";
		  case "MT":
			  return "Montana";
		  case "NE":
			  return "Nebraska";
		  case "NV":
			  return "Nevada";
		  case "NH":
			  return "New Hampshire";
		  case "NJ":
			  return "New Jersey";
		  case "NM":
			  return "New Mexico";
		  case "NY":
			  return "New York";
		  case "NC":
			  return "North Carolina";
		  case "ND":
			  return "North Dakota";
		  case "OH":
			  return "Ohio";
		  case "OK":
			  return "Oklahoma";
		  case "OR":
			  return "Oregon";  
		  case "PA":
			  return "Pennsylvania";
		  case "PR":
			  return "Puerto Rico";
		  case "RI":
			  return "Rhode Island";
		  case "SC":
			  return "South Carolina";
		  case "SD":
			  return "South Dakota";
		  case "TN":
			  return "Tennessee";
		  case "TX":
			  return "Texas";
		  case "UT":
			  return "Utah";
		  case "VT":
			  return "Vermont";
		  case "VA":
			  return "Virginia";
		  case "WA":
			  return "Washington";
		  case "DC":
			  return "Washington DC";
		  case "WV":
			  return "West Virginia";
		  case "WI":
			  return "Wisconsin";
		  case "WY":
			  return "Wyoming";
				   
			  
		  default:
		    return null;
		}
	}
	
	public String GetResidingStateCode(String stateName)
	{
		switch(stateName) {
		  case "Alabama":
			 return "AL";
		  case "Alaska":
			  return "AK";
		  case "Arizona":
			  return "AZ";
		  case "Arkansas":
			  return "AR";
		  case "California":
			  return "CA";
		  case "Colorado":
			  return "CO";
		  case "Connecticut":
			  return "CT";
		  case "Delaware":
			  return "DE";
		  case "Florida":
			  return "FL";
		  case "Georgia":
			  return "GA";
		  case "Hawaii":
			  return "HI";
		  case "Idaho":
			  return "ID";
		  case "Illinois":
			  return "IL";
		  case "Indiana":
			  return "IN";
		  case "Iowa":
			  return "IA";
		  case "Kansas":
			  return "KS";
		  case "Kentucky":
			  return "KY";
		  case "Louisiana":
			  return "LA";
		  case "Maine":
			  return "ME";
		  case "Maryland":
			  return "MD";
		  case "Massachusetts":
			  return "MA";
		  case "Michigan":
			  return "MI";
		  case "Minnesota":
			  return "MN";
		  case "Mississippi":
			  return "MS";  
		  case "Missouri":
			  return "MO";
		  case "Montana":
			  return "MT";
		  case "Nebraska":
			  return "NE";
		  case "Nevada":
			  return "NV";
		  case "New Hampshire":
			  return "NH";
		  case "New Jersey":
			  return "NJ";
		  case "New Mexico":
			  return "NM";
		  case "New York":
			  return "NY";
		  case "North Carolina":
			  return "NC";
		  case "North Dakota":
			  return "ND";
		  case "Ohio":
			  return "OH";
		  case "Oklahoma":
			  return "OK";
		  case "Oregon":
			  return "OR";  
		  case "Pennsylvania":
			  return "PA";
		  case "Puerto Rico":
			  return "PR";
		  case "Rhode Island":
			  return "RI";
		  case "South Carolina":
			  return "SC";
		  case "South Dakota":
			  return "SD";
		  case "Tennessee":
			  return "TN";
		  case "Texas":
			  return "TX";
		  case "Utah":
			  return "UT";
		  case "Vermont":
			  return "VT";
		  case "Virginia":
			  return "VA";
		  case "Washington":
			  return "WA";
		  case "Washington DC":
			  return "DC";
		  case "West Virginia":
			  return "WV";
		  case "Wisconsin":
			  return "WI";
		  case "Wyoming":
			  return "WY";
				   
			  
		  default:
		    return null;
		}
	}
	
	public void SelectDate(String date)
	{
		String[] DS = date.split("-");
        String YDS = DS[2];
        String MDS = DS[1];
        String DDS = DS[0];

        System.out.println(MDS);
        System.out.println(DDS);
        
        Select YearDS = new Select(driver.findElement(By.className("ui-datepicker-year")));
        YearDS.selectByValue(YDS);
    //    Thread.sleep(3000);
        Select MonthDS = new Select(driver.findElement(By.className("ui-datepicker-month")));
        MonthDS.selectByVisibleText(MDS);
    //    Thread.sleep(3000);
        //Click day of date for DOB - In the excel sheet always give only 2 digit date days like from 10th day in the month
        WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
        
        List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
        for (WebElement col: columnsDS)
        { 
        	//System.out.println("Col.getText(): "+col.getText());
        	//System.out.println("DDS substring 0:"+DDS.substring(0,1));
        	if(DDS.substring(0,1).equalsIgnoreCase("0"))
        	{
        		System.out.println("Inside DDS match");
        		DDS = DDS.substring(1,2);
        		
        	}
           if (col.getText().equals(DDS))
           {
           	System.out.println("Inside if:"+col.getText());
           	System.out.println("DDS:"+DDS);
              col.findElement(By.linkText(DDS)).click();
              System.out.println("Done with HIPPA");
              break;
              
           }
        }
	}
	
	public String ConvertToMonthString(int monthNum)
	{
		switch(monthNum) {
		  case 1:
			 return "Jan";
		  case 2:
			  return "Feb";
		  case 3:
			  return "Mar";
		  case 4:
			  return "Apr";
		  case 5:
			  return "May";
		  case 6:
			  return "Jun";
		  case 7:
			  return "Jul";
		  case 8:
			  return "Aug";
		  case 9:
			  return "Sep";
		  case 10:
			  return "Oct";
		  case 11:
			  return "Nov";
		  case 12:
			  return "Dec";
			  
		  default:
		    return null;
		}
	}
	
	public int ConvertToMonthNumber(String monthCode)
	{
		switch(monthCode) {
		  case "Jan":
			 return 01;
		  case "Feb":
			  return 02;
		  case "Mar":
			  return 03;
		  case "Apr":
			  return 04;
		  case "May":
			  return 05;
		  case "Jun":
			  return 06;
		  case "Jul":
			  return 07;
		  case "Aug":
			  return 8;
		  case "Sep":
			  return 9;
		  case "Oct":
			  return 10;
		  case "Nov":
			  return 11;
		  case "Dec":
			  return 12;
			  
		  default:
		    return 0;
		}
	}
	
	public static String  snapShot(String fileName, String filePath) throws IOException, AWTException {
		System.out.println("The snapshot- filename is:" +fileName);
		//System.out.println("The snapshot- filePath is:" +filePath);
		
        String osName = System.getProperty("os.name");
        Robot rb = new Robot();
        
        String sTestCaseLogFolder = TestBase.reportsPath;
        
         ArrayList<Integer> iTotalScreenCounter=new ArrayList<Integer>();
        String commandName = "cmd.exe";
        
        String[] cmds = new String[9];

        cmds[0] = commandName;
        cmds[1] = "/C";
        //cmds[2] = FPath.SCREENSHOT_EXE;
        cmds[3] = "/f";
        cmds[4] = fileName;
        cmds[5] = "/d";
        cmds[6] = filePath;
        cmds[7] = "/q";
        cmds[8] = "100,7,True";
        //Process substProcess = Runtime.getRuntime().exec(cmds, null, null);
        
      //  BufferedImage screenShot = rb.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));//For some reason this line was not capturing the entire screen
        BufferedImage screenShot = rb.createScreenCapture(new Rectangle(1920, 1080));//The dimensions here are from the display resolution of the local machine
        
        ImageIO.write(screenShot, "jpg", new File(TestBase.reportsPath+"\\"+"Success"+iScreenCounter+".jpg"));
        //ImageIO.write(screenShot, "jpg", new File(sTestCaseLogFolder+"\\"+iScreenCounter+".jpg"));
        iScreenCounter=iScreenCounter+1;
        iTotalScreenCounter.add(iScreenCounter);
        
        return filePath+"/"+fileName;
        
        
 }
 
 
 
 public static String  snapShotFail(String fileName, String filePath) throws IOException, AWTException {
        String osName = System.getProperty("os.name");
        Robot rb = new Robot();
        
        String sTestCaseLogFolder = TestBase.reportsPath;
        
         ArrayList<Integer> iTotalScreenCounter=new ArrayList<Integer>();
        String commandName = "cmd.exe";
        
        String[] cmds = new String[9];

        cmds[0] = commandName;
        cmds[1] = "/C";
        //cmds[2] = FPath.SCREENSHOT_EXE;
        cmds[3] = "/f";
        cmds[4] = fileName;
        cmds[5] = "/d";
        cmds[6] = filePath;
        cmds[7] = "/q";
        cmds[8] = "100,7,True";
        //Process substProcess = Runtime.getRuntime().exec(cmds, null, null);
        
        BufferedImage screenShot = rb.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        
        
        ImageIO.write(screenShot, "jpg", new File(TestBase.reportsPath+"\\"+"Error"+iScreenCounter+".jpg"));
        //ImageIO.write(screenShot, "jpg", new File(sTestCaseLogFolder+"\\"+iScreenCounter+".jpg"));
        iScreenCounter=iScreenCounter+1;
        iTotalScreenCounter.add(iScreenCounter);
        
        return filePath+"/"+fileName;
        
        
 }


 public static String getTimeStamp(){
      Date d  = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy_h-mm-ss");
      String date = sdf.format(d).toString();
      return date;
}
 
 public static String createScreenShotFolder() {
      File file = new File(TestBase.reportsPath+TestBase.ConstantTimeStamp);
      if (!file.exists()) {
             if (file.mkdir()) {
                   //System.out.println("Screenshot_Directory is created!");
             } else {
                   System.out.println("Failed to create Screenshot directory!");
             }
      }
      return TestBase.reportsPath+TestBase.ConstantTimeStamp;
}
 
 public boolean isAttributePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	    	System.out.println("Test data attribute value: "+attribute);
	        String value = element.getAttribute(attribute);
	        System.out.println("Attribute value: "+value);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}
 
 public boolean VerifyFutureDatesAreDisabled(String currentDate, String UIStateDisabled, String UIStateHighlight)
 {
	 String[] date = currentDate.split("-");
	 Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
	 Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
	 
	 Assert.assertEquals(month.getFirstSelectedOption().getText(), ConvertToMonthString(Integer.parseInt(date[1])));
	 Assert.assertEquals(year.getFirstSelectedOption().getText(), date[0]);
	 
	 //verify the future dates are disabled in date picker
	 char num = date[2].charAt(0);
	 System.out.println("num: "+num);
	 if(num=='0')
	 {
		 date[2] = Character.toString(date[2].charAt(1));
	 }
	 boolean verify = true;
	 if(verify)
	 {
		 
		 //verify no future months are available
		 List<WebElement> numOfMonths = month.getOptions();
		 Assert.assertTrue(numOfMonths.size()==Integer.parseInt(date[1]));
		
		 //verify no future years are available
		 List<WebElement> numOfYears = year.getOptions();
		 int yrSize = numOfYears.size();
		 year.selectByIndex(yrSize-1);//select the last option in the year dropdown
		 Assert.assertTrue(year.getFirstSelectedOption().getText().equals(date[0]));//make sure the year selected in above step is the current yr
		 
		 
		 
		 WebElement dateWidgetDS = driver.findElement(By.className("ui-datepicker-calendar"));
		 List<WebElement> columnsDS = dateWidgetDS.findElements(By.tagName("td"));
	        for (WebElement col: columnsDS)
	        { 
	        	if(!col.getText().trim().isEmpty())//If there are any initial empty "td" with value &nbsp, which means no dates for those days in the calendar
	        	{
		           if (col.getText().equals(date[2]))
		           {
		           	  //Now make sure that future dates are disabled
		        	  System.out.println("This is the current date");
		        	  Assert.assertTrue(col.getAttribute("class").contains(UIStateHighlight));
		           }
		           else if(Integer.parseInt(col.getText()) < Integer.parseInt(date[2]))
		           {
		        	   System.out.println("This is the previous to current date");
		           } 
		           else
		           {
		        	   System.out.println("entered else");
		        	   Assert.assertTrue(col.getAttribute("class").contains(UIStateDisabled));
		           }
	          
		           
	        	}
	
	       }
	        return verify;
	 }
		 
	 verify = false;
	 return verify;
 }
 
 	public boolean getTextofInputBox(By xpath) {

	   JavascriptExecutor js = (JavascriptExecutor) driver; 
	   String value = (String)((js).executeScript("return arguments[0].value",driver.findElement(xpath)));
	 //  System.out.println("Value: "+value);
	   
	   if(value.isEmpty())
	   {
		   return true;
	   }
	  return false;
	}
 	
 	public void deleteExistingFile(String downloadPath, String fileName) {
 		//	boolean flag = false;
 		    File dir = new File(downloadPath);
 		    File[] dir_contents = dir.listFiles();
 		  	    
 		    for (int i = 0; i < dir_contents.length; i++) {
 		        if (dir_contents[i].getName().startsWith(fileName)) {
 		        	dir_contents[i].delete();
 		    		// return flag=true;
 		    	 }
 		           
 		            }

 		   // return flag;
 		}
 		
 		
 		public boolean isFileDownloaded(String downloadPath, String fileName) {
 			boolean flag = false;
 		    File dir = new File(downloadPath);
 		    File[] dir_contents = dir.listFiles();
 		  	    
 		    for (int i = 0; i < dir_contents.length; i++) {
 		        if (dir_contents[i].getName().equals(fileName))
 		        {
 		        	flag = true;
 		        	 return flag;
 		        }
 		    		
 		    	 }

 		    return flag;
 		}
 
 
 
 
}
	
	


