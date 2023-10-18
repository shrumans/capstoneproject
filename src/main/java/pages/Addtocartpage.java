package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.TestWait;

public class Addtocartpage extends Basepage {

	public Addtocartpage(WebDriver driver2) {
		super(driver2);
	}

	By view=By.xpath("//a[@href='/medicare/show/2/product']");
	By addtocart=By.xpath("//a[@href='/medicare/cart/add/2/product']");
	By checkout=By.xpath("//a[@href='/medicare/cart/validate']");
	By selectaddress=By.xpath("//a[text()='Select']");
	By cardno=By.id("cardNumber");
	By expMonth=By.id("expityMonth");
	By expYear=By.id("expityYear");
    By cvcode=By.id("cvCode");
	By paybtn=By.xpath("//a[text()='Pay']");
	By msg=By.xpath("//h3[text()='Your Order is Confirmed!!']");
	By continueshop=By.xpath("//a[text()='Continue Shopping']");
	By addItem2=By.xpath("//a[@href='/medicare/cart/add/3/product']");
	By addItem3=By.xpath("//a[@href='/medicare/cart/add/4/product']");
	By addItem4=By.xpath("//a[@href='/medicare/cart/add/5/product']");
	By cont=By.xpath("//a[@href='/medicare/show/all/products']");
	
	
public String checkout() {
		
		clickaction(checkout);
		TestWait.hardwait(1);
		clickaction(selectaddress);
		TestWait.hardwait(1);
		typeText(cardno, "12345678910");
		typeText(expMonth, "12");
	    typeText(expYear, "2023");
	    typeText(cvcode, "123");
	    TestWait.hardwait(2);
	    clickaction(paybtn);
	    TestWait.hardwait(1);
	    String actual=driver.findElement(msg).getText();
	    TestWait.hardwait(1);
	    return actual;
	    
	}

	public String add1ItemToCart() {
		
		clickaction(view);
		TestWait.hardwait(1);
		driver.findElement(addtocart).sendKeys(Keys.ENTER);
		TestWait.hardwait(2);
		return checkout();
	}
	
	public void continueShopping() {
	 clickaction(cont);
	}
	
	public String addMultipleItemsToCart() {
		
		clickaction(addItem2);
		TestWait.hardwait(2);
		clickaction(cont);
		TestWait.hardwait(2);
		clickaction(addItem3);
		TestWait.hardwait(2);
		clickaction(cont);
		TestWait.hardwait(2);
		clickaction(addItem4);
		TestWait.hardwait(2);
		return checkout();
	}
	
	
}
