package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	// Page Factory: Object Repository
	
	@FindBy(xpath="//span[.='Log In']")
	WebElement LogIn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[.='Sign Up']']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']/div/a")
	WebElement CRMlogo;
	
	
	//Initializing the Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCRMlogo() {
		return CRMlogo.isDisplayed();
	}
	
	public HomePage login(String usrname, String pwd) {
		
		LogIn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
		
	}
	
	

}
