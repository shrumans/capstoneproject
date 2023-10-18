package simplilearn.capstoneproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.Addtocartpage;
import pages.Loginpage;
import pages.SignUpPage;
import utils.TestWait;

public abstract class BASE {
	    WebDriver driver;
	    SignUpPage signpage;
	    Loginpage loginpage;
	    Addtocartpage cartpage;
	    
	    
		@BeforeTest
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\manje\\Downloads\\chromedriverStable\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://localhost:8080/medicare");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			TestWait.hardwait(3);
			
			signpage=new SignUpPage(driver);
			loginpage=new Loginpage(driver);
			cartpage=new Addtocartpage(driver);
		}
		
		@AfterTest
		public void closedriver() {
			driver.quit();
		}
	
}
