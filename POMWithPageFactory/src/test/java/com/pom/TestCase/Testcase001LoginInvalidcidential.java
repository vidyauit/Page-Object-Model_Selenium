package com.pom.TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pom.HomePage.HomePage;
import com.pom.TestBase.TestBase;

public class Testcase001LoginInvalidcidential extends TestBase{
    // WebDriver driver ;
	
	Logger log  = Logger.getLogger(Testcase001LoginInvalidcidential.class.getName());
	HomePage homepage;
		@BeforeTest
		public void setup(){
		
		init();
		}
		@Test
		public void LoginInvalidcidential(){
			homepage =new HomePage(driver);
			log.info("Start varification");
		homepage.vaifyinvaliddata("vidya","passd");
		
		}
		
		@AfterClass
		public void endtest(){
			driver.close();
		}
	}

