package pages;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestWait;

public class SignUpPage extends Basepage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	public static String mailid;
	public static String password;
	//signup page elements locators

	By signUpBtn= By.xpath("//a[text()='Sign Up']");
	By fName=By.id("firstName");
    By lName=By.id("lastName");
	By eMail=By.id("email");
	By numb=By.id("contactNumber");
	By pword=By.id("password");
	By confirmpword=By.id("confirmPassword");
	By userrole=By.id("role1");
	By supplierRole=By.id("role2");
	By nxtbill=By.name("_eventId_billing");
	
	//signup address page elements locators
	
	By add1= By.id("addressLineOne");
	By add2=By.id("addressLineTwo");
	By city= By.id("city");
	By postcode=By.id("postalCode");
	By state=By.id("state");
	By country=By.id("country");
	By nextbtn=By.name("_eventId_confirm");
	
	By confirmbtn=By.xpath("//div[@class='text-center']/following::a[2]");
	
	By medicarewidget=By.xpath("//a[@class='navbar-brand']");
	By msg=By.className("text-center");
	
	
	public void signup() {
		clickaction(signUpBtn);
		TestWait.hardwait(1);
		typeText(fName, "Shruthi");
		TestWait.hardwait(1);
		typeText(lName, "Manjesh");
		TestWait.hardwait(1);
		
		Random ran= new Random();
		int x=ran.nextInt(9);
		int y=ran.nextInt(6);
		mailid=+(y-1)+"abc"+x+0+y+"@xyz.com";
		typeText(eMail,mailid);
		
		typeText(numb, "9876543210");
		password="123456789";
		typeText(pword, password);
		typeText(confirmpword, password);
		TestWait.hardwait(1);
	}
	
	public void signupaddress() {
		
		typeText(add1,"somecross");
		typeText(add2,"someroad");
		typeText(city,"somecity");
		typeText(postcode,"somecode");
		typeText(state,"somestate");
		typeText(country,"somecountry");
		TestWait.hardwait(1);
		clickaction(nextbtn);
		TestWait.hardwait(1);
		
		WebElement ele = driver.findElement(confirmbtn);
		ele.sendKeys(Keys.ENTER);
		
	}
	
	public void signUpAsUser() {
		signup();
		clickaction(userrole);
		TestWait.hardwait(1);
		clickaction(nxtbill);
		TestWait.hardwait(1);
		signupaddress();
	}
	
	public void signUpAsSupplier() {
		signup();
		clickaction(supplierRole);
		TestWait.hardwait(1);
		clickaction(nxtbill);
		TestWait.hardwait(1);
		signupaddress();
	}
	
	public void goBackToHomePage() {
		WebElement med = driver.findElement(medicarewidget);
		med.sendKeys(Keys.ENTER);
		TestWait.hardwait(1);
	}
	
	public String validateSignUpMsg() {
		String actual = driver.findElement(msg).getText();
		System.out.println("printing actual text: "+actual);
		return actual;
	}
	
}
