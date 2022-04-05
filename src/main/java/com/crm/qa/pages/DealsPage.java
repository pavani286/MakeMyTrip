package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;

public class DealsPage extends BaseTest {
	WebDriver d;
	By DealsLabel = By.xpath("//a[@title='Deals']");
	public DealsPage(WebDriver dr) {
		this.d = dr;
	              }
	
	public boolean verifyDealsLabel() {
		return d.findElement(DealsLabel).isDisplayed();
	         }
	
	public void verifyDealId(String Dealname) throws InterruptedException {
		Thread.sleep(2000);
		 WebDriverWait w = new WebDriverWait(d,80);
	     w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='"+Dealname+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//a[@context='deal']")));
d.findElement(By.xpath("//a[text()='"+Dealname+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//a[@context='deal']")).click();
	  }
}
