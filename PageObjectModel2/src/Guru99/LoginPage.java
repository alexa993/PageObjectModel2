package Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement userID;
	@FindBy(name="password")
	WebElement password;
	@FindBy(className="barone")
	WebElement title;
	@FindBy(name="btnLogin")
	WebElement login;
	@FindBy(name="btnReset")
	WebElement reset;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//set username
	public void setUserID(String strUserID) {
		userID.sendKeys(strUserID);
	}
	//set password
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	
	
	//login click
	public void clickLogin() {
		login.click();
	}
	
	public void resetLogin() {
		reset.click();
	}
	
	//get title
	
	public String getLoginTitle() {
		return title.getText();
	}
	public void loginToGuru(String strUserID,String strPassword) {
		this.setUserID(strUserID);
		this.setPassword(strPassword);
		this.clickLogin();
	}
}
