package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;
public class HomePage extends BaseTest{
	WebDriver d;
	By UserNameLabel = By.xpath("//td[@align='left'and @class='headertext']");
	By ContactsLink = By.xpath("//a[@title ='Contacts']");
	By DealsLink = By.xpath("//a[@title ='Deals']");
	By TasksLink = By.xpath("//a[@title ='Tasks']");
	By NewContactLink = By.xpath("//a[contains(text(),'New Contact')]");
	By NagMenu = By.id("navmenu");
	
	public HomePage(WebDriver dr){
		this.d = dr;
	          }
	
	//Actions (or) Features
	public String validateHomePageTitle(){
		return d.getTitle();
	                       }
	
	public boolean VerifyCorrectusername() {
		return  d.findElement(UserNameLabel).isDisplayed();
	                   }
	
	public ContactsPage ClickonContactsLink(){
		d.findElement(ContactsLink).click();
		return new ContactsPage(d);
	              }
	
	public DealsPage ClickOnDealsLink(){
		d.findElement(DealsLink).click();
		return new DealsPage(d);
	         }
	public TasksPage ClickonTasksLink(){
		d.findElement(TasksLink).click();
		return new TasksPage();
	   }
	public  void ClickonNewContactsLink() throws InterruptedException {
		//Thread.sleep(2000);
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(NagMenu)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(d.findElement(ContactsLink)).build().perform();
		WebDriverWait w = new WebDriverWait(d,80);
	    w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NewContactLink));
		d.findElement(NewContactLink).click();
		
	}
}
