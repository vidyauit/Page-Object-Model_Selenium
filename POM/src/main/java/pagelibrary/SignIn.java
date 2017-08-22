package pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class SignIn {
	
	public WebDriver driver;
static Logger log = Logger.getLogger(SignIn.class.getName());
	
	By signIn = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By createAccEmailAddr = By.xpath(".//*[@id='email_create']");
	By allreadyRegEmailAddr = By.xpath("//*[@id='email']");
	By allReadyRegPass = By.xpath("//*[@id='passwd']");
	By submitbutton = By.xpath("//*[@id='SubmitLogin']");
	By createAnAccount = By.xpath("//*[@id='SubmitCreate']");
	By signOut = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");
	public SignIn(WebDriver driver){
		this.driver = driver;
	}
	public void clickonSignIn(){
		
		try {
			driver.findElement(signIn).click();
			log.info( "Clicking on sing in Link");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL,"Clicking on sing in Link");
		}
	}
	public void enterEmailAddressToCraeteAccount(String emailAddress){
		
		log.info("entering email address to create an account :"+emailAddress.toString());
		driver.findElement(createAccEmailAddr).sendKeys(emailAddress);
		log.info("email enterd");
		
	}

	public void clickoncreateaccount(){
		driver.findElement( createAnAccount).click();
		log.info("clickrd on");
	}
	
	public void enterdatatocreateaccount(String emailAddress){
		clickonSignIn();
		enterEmailAddressToCraeteAccount( emailAddress);
		clickoncreateaccount();	
	}
	
	public void enterAllreadyRegisterUserEmail(String emailAddress){
		log.info("entering email addredd to all ready registered user text box");
		driver.findElement(allreadyRegEmailAddr).sendKeys(emailAddress);
	}
	
	public void enterAllReadyRegisteredPassword(String password){
		log.info("enterign password to password text box");
		driver.findElement(allReadyRegPass).sendKeys(password);
	}
	public void clickonSignInToAccount(){
		log.info("clicking on sign in button");
		driver.findElement(submitbutton).click();
	}
	
	public void loginToApplication(String Email, String Password){
		clickonSignIn();
		enterAllreadyRegisterUserEmail(Email);
		enterAllReadyRegisteredPassword(Password);
		clickonSignInToAccount();
	}
	
	public void logout(){
		try{
		boolean isdisplayed = driver.findElement(signOut).isDisplayed();
		if(isdisplayed){
			driver.findElement(signOut).click();
		}
		}
		catch(Exception e){
			Assert.assertTrue(false, "sign out buttom is not displayed");
		}
	}
}
