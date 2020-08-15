package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage  homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=3)
	public void LoginPageTitleTest() {
		String page_title = loginpage.ValidateLoginPageTitle();
		//System.out.println("Title of the Login Page is: " + page_title);
		Assert.assertEquals(page_title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean crm_logo = loginpage.ValidateCRMlogo();
		Assert.assertTrue(crm_logo);
	}
	
	@Test(priority=1)
	public void loginTest() {
		
		System.out.println("value of username is:"+ prop.getProperty("username") );
		System.out.println("value of username is:"+ prop.getProperty("password") );
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
