package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	WebDriver d;
	By Username = By.name("username");
	By Password = By.name("password");
	By LoginBtn = By.xpath("//input[@type='submit']");
	By loginbtnLabel = By.xpath("//input[@type='submit']");
	
	//Initializing the object
	public LoginPage(WebDriver dr){
		this.d = dr;
	          }
	//Actions
	public String validateLoginPageTitle(){
		return d.getTitle();
	                         }
	
	public HomePage Login(String un,String pwd) throws InterruptedException{
		d.findElement(Username).sendKeys(un);
		d.findElement(Password).sendKeys(pwd);
		//LoginBtn.click();
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(LoginBtn)).build().perform();
		WebDriverWait wait = new  WebDriverWait(d,20);
		wait.until(ExpectedConditions.visibilityOf(d.findElement(LoginBtn)));
		Thread.sleep(2000);
		d.findElement(LoginBtn).click();
		
		return new HomePage(d);
	                                     }
                        }
	
