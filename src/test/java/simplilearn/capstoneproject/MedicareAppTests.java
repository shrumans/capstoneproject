package simplilearn.capstoneproject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignUpPage;
import utils.TestWait;

public class MedicareAppTests extends BASE {
	
	@Test(priority=1)
	public void validateSignUpAndLoginAsSupplier(){
		
		signpage.signUpAsSupplier();
		assertTrue(signpage.validateSignUpMsg().contains("Welcome!"));
		TestWait.hardwait(2);
		
		loginpage.loginHere();
		assertEquals(loginpage.validateLogin(),"Shruthi Manjesh");
		TestWait.hardwait(2);
		
		loginpage.logout();
		signpage.goBackToHomePage();
		TestWait.hardwait(2);
	}

	@Test(priority=1)
	public void validateSignUpAndLoginAsUser() {
		
		signpage.signUpAsUser();
		assertTrue(signpage.validateSignUpMsg().contains("Welcome!"));
		TestWait.hardwait(2);
		
		loginpage.loginHere();
		assertEquals(loginpage.validateLogin(),"Shruthi Manjesh");
		TestWait.hardwait(2);
		
	}
	
	@Test(priority=2)
	public void addItemToCartAndValidateCheckout() {
		
		assertTrue(cartpage.add1ItemToCart().contains("Your Order is Confirmed!!"));
		TestWait.hardwait(2);
		cartpage.continueShopping();
		TestWait.hardwait(2);
	}
	
	@Test(priority=3)
	public void addMultipleItemsToCartAndValidateCheckout() {
		
		assertTrue(cartpage.addMultipleItemsToCart().contains("Your Order is Confirmed!!"));
		TestWait.hardwait(2);
		cartpage.continueShopping();
		TestWait.hardwait(2);
	}
}
