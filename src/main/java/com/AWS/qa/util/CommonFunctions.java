package com.AWS.qa.util;

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

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class CommonFunctions extends TestBase {
	
	public static int  iScreenCounter=1;
	
	public static String  snapShot(String fileName, String filePath) throws IOException, AWTException {
		System.out.println("The snapshot- filename is:" +fileName);
		System.out.println("The snapshot- filePath is:" +filePath);
		
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
	

}



