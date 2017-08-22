package com.pom.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.TestBase.TestBase;

public class RegistrationPage extends TestBase{

	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	@FindBy(xpath=".//*[@id='email_create']")
	WebElement Emailaddress;
	
	@FindBy(xpath=".//*[@id='SubmitCreate']")
	WebElement createaccount;
	
	public RegistrationPage(WebDriver deiver){
		PageFactory.initElements(driver, this);
	}
}
