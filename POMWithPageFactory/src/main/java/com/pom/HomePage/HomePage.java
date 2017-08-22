package com.pom.HomePage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pom.TestBase.TestBase;

public class HomePage {
//WebDriver driver;
	
	Logger log  = Logger.getLogger(HomePage.class.getName());
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	@FindBy(xpath=".//*[@id='email']")
	WebElement emailaddress;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement password;
	
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement Submit;
	
	@FindBy(xpath=".//*[@id='email_create']")
	WebElement Emailaddress;
	
	@FindBy(xpath=".//*[@id='SubmitCreate']")
	WebElement createaccount;
	@FindBy(xpath="//input[@name='id_gender' and @type='radio']")
	List<WebElement> radio;
	
	@FindBy(xpath="//*[@id='id_gender1']")
	WebElement male;
	
	@FindBy(xpath="//*[@id='id_gender2']")
	WebElement female;
	

	@FindBy(id="//*[@id='customer_firstname']")
	WebElement firstname;
	

	@FindBy(xpath="//*[@id='customer_lastname']")
	WebElement lastname;
	
	 @FindBy(xpath="//*[@id='email']")
	 WebElement email;
	@FindBy(xpath="//*[@id='passwd']")
	WebElement passwords;
	
	@FindBy(id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void signup(){
		SignIn.click();
		log.info("Click on signin and object"+SignIn);
	}
	public void vaifyinvaliddata(String email,String pass){
		
		SignIn.click();
		log.info("Click on signin and object"+SignIn);
		emailaddress.sendKeys(email);
		log.info("enter email and object  : "+emailaddress);
		password.sendKeys(pass);
		log.info("enter password and object  : "+password);
		Submit.click();
		log.info("click on submit and object"+Submit);
	}
	public void createaccount(String email){
		Emailaddress.sendKeys(email);
		log.info("enter email and object  : "+email);
		createaccount.click();
		log.info("click on buttun");
		
	}
	/**public void accountdetail(String fname,String Lname,String pass,){
	
	int siz=title.size();
		log.info("number of radio button"+siz);
		for(int i =1;i<=siz;i++){
			WebElement local_radio = title.get(i);
			log.info("first radio button"+local_radio);
			String val = local_radio.getAttribute("value");
			System.out.println("Value of radio button"+val);
			log.info("first radio button"+val);
			if(val.equalsIgnoreCase("Mrs")){
				female.click();
			}
		}
		
		firstname.sendKeys(arg0);*/
	
	
	public void mrradiobutton(){
		
	/*	boolean bValue = false;

		bValue = radio.get(0).isSelected();
		log.info("value is selected"+bValue);
		if(bValue == true){
			radio.get(1).click();
		}else{
			radio.get(0).click();
		}*/
		
		//int siz=radio.size();
		//log.info("number of radio button :"+siz);
		for(int i =0;i<radio.size();i++){
			log.info("number of radio button :"+radio.size());
			WebElement  local_radio = radio.get(i);
			log.info("first radio button :"+local_radio);
			String value = local_radio.getAttribute("value");
			System.out.println("Value of radio button"+value);
			log.info("first radio button"+value);
			if(value.equalsIgnoreCase("Mrs")){
				local_radio.click();
			}
			break;
		}
		//male.click();
	
	}
	
	public void mrsradiobutton(){
		female.click();
	}

public void selectDaysInDropDown(String daydrop) throws InterruptedException{
	Select Day=new Select(day);
	Day.deselectByValue(daydrop);
}
public void selectMonthInDropDown(String monthdrop) throws InterruptedException{
	Select Day=new Select(month);
	Day.deselectByValue(monthdrop);
}

public void selectyearInDropDown(String yeardrop) throws InterruptedException{
	Select Day=new Select(year);
	Day.deselectByValue(yeardrop);
}


public void personalaccountdetail(String fname,String lname,String pass,String day,String month,String year) throws InterruptedException{
	
	mrradiobutton();
	
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	password.sendKeys(pass);
	selectDaysInDropDown(day);
	selectMonthInDropDown(month);
	selectyearInDropDown(year);
}
}

