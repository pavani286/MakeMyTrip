package com.crm.qa.testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestData;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseTest {
	LoginPage loginpage;
	HomePage  homepage;
	TestUtil testutil;
	ContactsPage contactpage;
   String sheetName = "Contacts";
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException{
		intialization();
		contactpage = new ContactsPage(d);
		testutil =new TestUtil();
		loginpage = new LoginPage(d);
		homepage =loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwtichToFrame();
		contactpage= homepage.ClickonContactsLink();
	                        }
	@Test(priority=1)
	public void verfiyContactTest() {
      //AssertJUnit.assertTrue(contactpage.verifyContactLabel(), "contactlabel didn't appear"); 
		AssertJUnit.assertTrue("contactlabel didn't appear", contactpage.verifyContactLabel());
                               }
	@Test(priority=2)
	public void selectContactNameTest() {
		contactpage.selectContacts("pradeep vemula");
	                       }
    @DataProvider
    public Object[][] getCRMTestData(){
    	
    	Object data[][] = TestData.getTestData(sheetName);
		return data;
    	
    
	               }
	@Test(priority=3, dataProvider="getCRMTestData")
	public void CreateNewContactsTest(String firstName, String lastName) throws InterruptedException {
		homepage.ClickonNewContactsLink();
		contactpage.CreateNewContacts(firstName,lastName);
	         }
	@AfterMethod
	public void closebrowser() {
		d.close();
	}
}
