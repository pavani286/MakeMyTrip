package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.util.WebEventListener;

public class BaseTest {
	public static  WebDriver d;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public BaseTest(){
		try {
		        prop = new Properties();
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") +"/src/main/java/com/crm/qa/config/config.properties");
				prop.load(fs);
				     }catch (FileNotFoundException e) {
					e.printStackTrace();
				              }catch (IOException e) {
					e.printStackTrace();
				         }
			}
		
	public static void intialization(){
		String browsername =prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","/Users/pavanivemula/Documents/Drivers/chromedriver");
			d= new ChromeDriver();
		           }else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver","/Users/pavanivemula/Documents/Drivers/geckodriver");
			d= new FirefoxDriver();
			 }
		/*    for creating the log information in console     */
		e_driver = new EventFiringWebDriver(d);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		d = e_driver;
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get(prop.getProperty("url"));
	
	}
}

