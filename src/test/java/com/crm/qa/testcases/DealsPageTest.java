package com.crm.qa.testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends BaseTest {

	LoginPage loginpage;
	HomePage  homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	DealsPage dealpage;
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization();
		dealpage = new DealsPage(d);
		testutil =new TestUtil();
		loginpage = new LoginPage(d);
		homepage =loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwtichToFrame();
		dealpage = homepage.ClickOnDealsLink();
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void verifyDealsLabelTest() {
		AssertJUnit.assertTrue("deal page didn't appear",dealpage.verifyDealsLabel());
	   }
	@Test(priority = 2)
	public void verifyDealIdTest() throws InterruptedException {
		dealpage.verifyDealId("computer");
		  }
	@AfterMethod
	public void closebrowser() {
		d.close();
	          }
}
