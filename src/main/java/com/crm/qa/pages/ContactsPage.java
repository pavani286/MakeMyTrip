package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.BaseTest;
public class ContactsPage extends BaseTest{
	WebDriver d;
	By ContactsLabel = By.xpath("//a[@title='Contacts']");
	By NewContactLabel= By.xpath("//a[@title='New Contact']");
	By FirstName = By.name("first_name");
	By LastName = By.name("surname");
	By SaveButton = By.xpath("//*[@id='contactForm']//descendant::input[@value='Save']");
	public ContactsPage(WebDriver dr){
		this.d = dr;
	            }
	
	public boolean verifyContactLabel(){
		return d.findElement(ContactsLabel).isDisplayed();
	                     }
	
	public void CreateNewContacts(String fname,String lname) {
		d.findElement(FirstName).sendKeys(fname);
		d.findElement(LastName).sendKeys(lname);
		d.findElement(SaveButton).click();
	                 }
	
	public void selectContacts(String Name){
		d.findElement(By.xpath("//a[text()='"+Name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	            }
	
}
