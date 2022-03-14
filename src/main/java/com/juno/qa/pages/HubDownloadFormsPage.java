package com.juno.qa.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.juno.qa.base.TestBase;

public class HubDownloadFormsPage extends TestBase {
	
	public HubDownloadFormsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement TravelRequestFormButton()
	{
		return driver.findElement(By.linkText("Travel request form"));
	}
	

	public WebElement TravelChangeFormButton()
	{
		return driver.findElement(By.linkText("Travel change form"));
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
