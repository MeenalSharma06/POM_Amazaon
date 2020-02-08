package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.TestUtil;
import com.amazon.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream io = new FileInputStream(System.getProperty("user.dir")
								+ "/src/main/java/com/amazon/qa/config/config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Initialize base 
	@SuppressWarnings("unused")
	public void Initialization() {

		String browserName = prop.getProperty("browser");
		
		switch (browserName) {
		
		case "chrome": {
	    	System.setProperty("webdriver.chrome.driver","C:/SeleniumFiles/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		case "Chrome": {
	    	System.setProperty("webdriver.chrome.driver","C:/SeleniumFiles/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
	    	System.setProperty("webdriver.gecko.driver","C:/SeleniumFiles/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		
		case "Firefox": {
	    	System.setProperty("webdriver.gecko.driver","C:/SeleniumFiles/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		case "FF": {
	    	System.setProperty("webdriver.gecko.driver","C:/SeleniumFiles/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		case "Safari": {
			
		}
		
		default: {
	    	System.setProperty("webdriver.gecko.driver","C:/SeleniumFiles/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		TestUtil.PageLoadTimeout(driver);
		TestUtil.ImplicitlyWait(driver);
		
		String URL = prop.getProperty("url");
		driver.get(URL);
	}

}
