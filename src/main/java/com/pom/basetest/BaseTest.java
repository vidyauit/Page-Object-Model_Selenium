package com.pom.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class BaseTest {
	Logger log  = Logger.getLogger(BaseTest.class.getName());
	
	public static WebDriver driver;
		String url = "http://automationpractice.com/index.php";
		String browser = "firefox";
		
		
		public static Properties Repository = new Properties();
		public File f;
		public FileInputStream FI;
		//public static WebDriver driver;
		public String startTime;
		public static int indexSI = 1;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		static {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			extent = new ExtentReports(System.getProperty("user.dir") + "/src/test/java/com/companyname/projectname/testReport/test" + formater.format(calendar.getTime()) + ".html", false);
		}
		
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
		
		public void expliciteWait(WebElement element, int timeToWaitInSec) {
			WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public void waitForPageToLoad(long timeOutInSeconds) {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			try {
				System.out.println("Waiting for page to load...");
				WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
				wait.until(expectation);
			} catch (Throwable error) {
				System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
				Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

			}
		}

		public void clickWhenReady(By locator, int timeout) {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();

		}
/*
		public WebElement fluentWait(final WebElement webElement, int timeinsec) {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			WebElement element = wait.until(() {
				public WebElement apply(WebDriver driver) {
					return webElement;
				}
			});

			return element;
		};
		*/
		
		@AfterClass(alwaysRun = true)
		public void endTest() {
			closeBrowser();
		}

		public void closeBrowser() {
			extent.endTest(test);
			extent.flush();
		}

		public WebElement getWhenVisible(By locator, int timeout) {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element;

		}

		public void waitFor(int sec) throws InterruptedException {
			Thread.sleep(sec * 1000);
		}

}
