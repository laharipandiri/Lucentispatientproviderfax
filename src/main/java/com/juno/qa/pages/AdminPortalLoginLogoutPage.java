package com.juno.qa.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juno.qa.base.TestBase;

public class AdminPortalLoginLogoutPage extends TestBase {
	
	  public AdminPortalLoginLogoutPage() {
	        PageFactory.initElements(driver, this);
	    }
		 
	  public WebElement Header()
		{
			return driver.findElement(By.xpath("//*[@id='header']"));
		 
		}
	  
	  public WebElement UserID()
		{
			return driver.findElement(By.name("username"));
		}
		public WebElement Password()
		{
			return driver.findElement(By.name("password"));
		}

		public WebElement LoginButton() {
			return driver.findElement(By.cssSelector("input[type='submit']"));
		}
		public WebElement WelcomeVerification() {
			return driver.findElement(By.xpath("//*[@id='form-table']"));
		}
		
		
		public WebElement ForgotChangePasswordLink()
		{
			return driver.findElement(By.linkText("Forgot/Change password?"));
		}

		public Select ProgramName()
		{
			Select programNameList = new Select(driver.findElement(By.id("program")));
			return programNameList;
		}
		
		public WebElement AdminPortalLogoutButton()
		{
			return driver.findElement(By.linkText("Log Out"));
		}
		
		public WebElement UsernameRequiredMessage()
		{
			return driver.findElement(By.xpath("//div[@class='form-container']/font/p[1][(text() = 'The Username field is required.')]"));
		}
		
		public WebElement PasswordRequiredMessage()
		{
			return driver.findElement(By.xpath("//div[@class='form-container']/font/p[2][(text() = 'The Password field is required.')]"));
		}
		
		public WebElement ProgramNameRequiredMessage()
		{
			return driver.findElement(By.xpath("//div[@class='form-container']/font/p[3][(text() = 'Please select a program.')]"));
		}
		
		/* ****************************************************************************************************************** */
		public  void BeforeLoginVerification() throws IOException, AWTException 
		{
			Boolean Header=Header().isDisplayed();
			Assert.assertTrue(Header);
			boolean  verfHeader= Header().isDisplayed();
			 if (verfHeader= true) {
				 TestBase.classAInstance.logReport("Pass","Header before login","Succesfully able to Verify Header before login");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Header before login","Failed to Verify Header before login");
				}
			 Assert.assertTrue(UserID().isDisplayed());
			 boolean verfUserID= UserID().isDisplayed();
			 if (verfUserID= true) {
				 TestBase.classAInstance.logReport("Pass","UserID verified before login","Succesfully able to Verify UserID before login");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","UserID verified before login","Failed to Verify UserID before login");
				}
			 Assert.assertTrue(Password().isDisplayed());
			 boolean verfPassword= Password().isDisplayed();
			 if (verfPassword= true) {
				 TestBase.classAInstance.logReport("Pass","Password verified before login","Succesfully able to Verify Password before login");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","Password verified before login","Failed to Verify Password before login");
				}
			 Assert.assertTrue(LoginButton().isDisplayed());
			 boolean verfLoginButton= LoginButton().isDisplayed();
			 if (verfLoginButton= true) {
				 TestBase.classAInstance.logReport("Pass","LoginButton verified before login","Succesfully able to Verify LoginButton before login");
				}
				else
				{
					TestBase.classAInstance.logReport("Fail","LoginButton verified before login","Failed to Verify LoginButton before login");
				}
			
		boolean hhh= driver.getPageSource().contains("error");
		//System.out.println("hhh:" +hhh);
				
		if (hhh == true) {
			 TestBase.classAInstance.logReport("Fail","Checking for errors on the screen","Error is present on the screen-5");
		 
			}
		else
			{
			TestBase.classAInstance.logReport("Pass","Checking for errors on the screen","Error is not present on the screen-5");
			}
		}
		 public boolean AdminPortalLogin() {
			 	WebDriverWait wait =  new WebDriverWait(driver, 30);
				boolean result = false;
				String uname = prop.getProperty("username");
				String pwd = prop.getProperty("password").trim();
				String prg = prop.getProperty("Program").trim();

				//String ExpectedTitle = "Teva - Ajovy";
			//	String Program = prop.getProperty("ProgramforLogin"); 
				System.out.println("The Username is:" +uname);
				System.out.println("The password is:" +pwd);
				System.out.println("The Program is:" +prg);
				try {
					UserID().clear();
					UserID().sendKeys(uname);
					Thread.sleep(1000);
					Password().clear();
					Password().sendKeys(pwd);
					Thread.sleep(1000);

			    	ProgramName().selectByVisibleText(prg);
					Thread.sleep(1000); 
					LoginButton().click();
					Thread.sleep(1000);

					String title = driver.getTitle();
					System.out.println("The title is:" +title);

					//Assert.assertEquals(title, ExpectedTitle);
				
					result = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;

			}
		 
		 public boolean AdminReimbursementPortalLogin() {

				boolean result = false;
				String uname = prop.getProperty("username");
				String pwd = prop.getProperty("password").trim();

				String ExpectedTitle = "Juno - Admin Reimbursement";
				String Program = prop.getProperty("AdminprogramforLogin"); 

				try {
					UserID().clear();
					UserID().sendKeys(uname);
					Thread.sleep(1000);
					Password().clear();
					Password().sendKeys(pwd);
					Thread.sleep(1000);

			    	ProgramName().selectByVisibleText(Program);
					Thread.sleep(1000); 
					LoginButton().click();
					Thread.sleep(1000);

					String title = driver.getTitle();
					System.out.println(title);

					Assert.assertEquals(title, ExpectedTitle);
				
					result = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;

			}
			 
			 public boolean AdminPortalLogout()
			 {
				 boolean result = false;
				 AdminPortalLogoutButton().click();
				 result=true;
				 return result;
			 }
	
}
