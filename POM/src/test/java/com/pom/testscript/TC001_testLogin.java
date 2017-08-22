package com.pom.testscript;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import pagelibrary.SignIn;

public class TC001_testLogin extends BaseTest {

	static Logger log = Logger.getLogger(TC001_testLogin.class.getName());
	
	SignIn signin;
	String password = "Password";
	String emailAddress = "vidyacs01@gmail.com";
	
	@BeforeClass
	public void setup(){
		init();
		
        test = extent.startTest("Login Test", "This test will verify login test");
		
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}
	@Test
	public void testlogin() throws InterruptedException{
		test.log(LogStatus.PASS, "Login Test started");
		signin = new SignIn(driver);
		signin.clickonSignIn();
		signin.loginToApplication(emailAddress, password);
		
			Thread.sleep(3000);
		signin.logout();
		}
	
	}
	

