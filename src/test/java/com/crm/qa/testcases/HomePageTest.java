package com.crm.qa.testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends BaseTest{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
    public HomePageTest(){
    	 super();
                   }
  @BeforeMethod
   public void setup() throws InterruptedException {
	intialization();
	testutil = new TestUtil();
	loginpage = new LoginPage(d);
	homepage =loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	                                    }   
  @Test(priority = 1)
  public void validateHomePageTitleTest(){
	 String  homepagetilte= homepage.validateHomePageTitle();
	 AssertJUnit.assertEquals(homepagetilte, "CRMPRO", "CRMPRO");
	                            }
  @Test(priority=2)
  public void VerifyusernameTest(){
	  testutil.SwtichToFrame();
	  AssertJUnit.assertTrue(homepage.VerifyCorrectusername());
                       }
  @Test(priority=3)
  public void ContactsLinkTest(){
	  testutil.SwtichToFrame();
	  contactspage = homepage.ClickonContactsLink();
                  }
  @AfterMethod
   public void ClosingBrowser() {
     	  d.quit();
       }
}
