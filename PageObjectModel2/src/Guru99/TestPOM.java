package Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPOM {
	WebDriver driver;
	String url = "http://demo.guru99.com/V4/";
	HomePage homePage;
	LoginPage loginPage;
	// USERID = mngr16533; PASS = sajAzer;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\QATests\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testMethod1() {
		driver.get(url);
		//Creating login object
		loginPage = new LoginPage(driver);
		
		//Verify title
		String loginPageTitle = loginPage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		
		// Login Application
		loginPage.loginToGuru("mngr16533", "sajAzer");
		
		//Next Page
		homePage = new HomePage(driver);
		
		//Verify HomePage
		Assert.assertTrue(homePage.getDashboardName().toLowerCase().contains("manger id : mngr16533"));
		
	}
	
	@Test
	public void testMethod2() {
		driver.get(url);
		loginPage = new LoginPage(driver);
		loginPage.setUserID("mngr16533");
		loginPage.setPassword("sajAzer");
		
		loginPage.resetLogin();
		
	
	}
	@AfterTest
	public void exit() {
		driver.close();
		driver.quit();
	}
}
