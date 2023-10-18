package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestWait;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	By loginhere=By.xpath("//a[text()='Login Here']");
	
	By loginbtn=By.xpath("//a[text()='Login']");
	By uname=By.id("username");
	By pword=By.id("password");
	By loginbtn2=By.xpath("//input[@value='Login']");
	By loginName=By.id("dropdownMenu1");
	
	By dropdown=By.id("dropdownMenu1");
	By logoutbtn=By.id("logout");
	
	public void login() {
		clickaction(loginbtn);
		TestWait.hardwait(1);
		typeText(uname, SignUpPage.mailid);
		typeText(pword, SignUpPage.password);
		TestWait.hardwait(1);
		clickaction(loginbtn2);
	}
	
	public void loginHere() {
		clickaction(loginhere);
		TestWait.hardwait(1);
		typeText(uname, SignUpPage.mailid);
		typeText(pword, SignUpPage.password);
		TestWait.hardwait(1);
		clickaction(loginbtn2);
	}
	
	public String validateLogin() {
		String actualName = driver.findElement(loginName).getText();
		return actualName;
	}
	
	public void logout() {
		clickaction(dropdown);
		TestWait.hardwait(1);
		clickaction(logoutbtn);
		TestWait.hardwait(1);
	}
	
}
