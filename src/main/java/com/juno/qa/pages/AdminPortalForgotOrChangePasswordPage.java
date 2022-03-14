package com.juno.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juno.qa.base.TestBase;

public class AdminPortalForgotOrChangePasswordPage extends TestBase {
	
	  public AdminPortalForgotOrChangePasswordPage() {
	        PageFactory.initElements(driver, this);
	    } 
	  
	  public WebElement UserName()
	  {
		  return driver.findElement(By.name("login_id"));
	  }
	  
	  public WebElement EmailAddress()
	  {
		  return driver.findElement(By.name("email_address"));
	  }
	  
	  public WebElement NewPassword()
	  {
		  return driver.findElement(By.name("password"));
	  }
	  
	  public WebElement ConfirmPassword()
	  {
		  return driver.findElement(By.name("re-password")); 
	  }
	  
	  public Select ProgramDropDown()
	  {
		  Select programNames = new Select(driver.findElement(By.name("program")));
		  return programNames;
	  }
	  
	  public WebElement UpdateButton()
	  {
		  return driver.findElement(By.className("button_update"));
	  }

}
