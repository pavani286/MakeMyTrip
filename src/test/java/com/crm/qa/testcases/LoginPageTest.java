package com.crm.qa.testcases;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intialization();
		loginpage= new LoginPage(d);
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title =loginpage.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void LoginTest() throws InterruptedException{
	homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
  @AfterMethod
  public void ClosingBrowser() {
	  d.quit();
  }
}
