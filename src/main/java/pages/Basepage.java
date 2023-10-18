package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basepage {
	
	WebDriver driver;
	
	public Basepage(WebDriver driver2) {
		this.driver=driver2;
		
	}
	
	public void clickaction(By locator) {
		driver.findElement(locator).click();
	}
	
	public void typeText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	
	
}
