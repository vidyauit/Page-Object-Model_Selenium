package com.pom.TestCase;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pom.HomePage.HomePage;
import com.pom.TestBase.TestBase;

public class Testcase001registrationPage extends TestBase{
HomePage homepage;
Logger log  = Logger.getLogger(Testcase001registrationPage.class.getName());
String email = "vidyacs0104@gmail.com";

String firstName ="vidya";
String lastName = "rajput";
String password = "Vidy@1345";
String emailAddress = "email"+System.currentTimeMillis()+"@gmail.com";
String day = "10";
String month = "july";
String year = "2007";
	@BeforeTest
	public void setup(){
	
	init();
	}
	@Test
	public void registation() throws InterruptedException{
		homepage = new HomePage(driver);
		homepage.signup();
		homepage.createaccount(email);
		
		homepage.personalaccountdetail(firstName,lastName,password,day,month,year);
		
	}
	
}
