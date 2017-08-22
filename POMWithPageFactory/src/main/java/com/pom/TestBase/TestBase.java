package com.pom.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
 
	Logger log  = Logger.getLogger(TestBase.class.getName());
	
public  WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "firefox";
	public void init(){
		initailzeBrowser(browser);
		geturl(url);
		String log4jprop = "log4j.properties";
		PropertyConfigurator.configure(log4jprop);
		
	}
	
	public  void initailzeBrowser(String brows){
		
		if(brows.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "C:\\geckoffdriver\\geckodriver.exe");
			log.info("Creating objrct of "+brows);
			driver = new FirefoxDriver();
		}
	}
	public void geturl(String urls){
		driver.get(urls);
		log.info("navigate url" +urls);
		driver.manage().window().maximize();
		log.info("maximze window");
	}
	
	
}
