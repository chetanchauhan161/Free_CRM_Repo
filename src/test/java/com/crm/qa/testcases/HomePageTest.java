package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	// Test cases should be independent
	// before each test case -- launch the browser and login
	// @Test -- execute each test
	// After every test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homepage  = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepage_title = homepage.VerifyHomePageTitle();
		Assert.assertEquals(homepage_title, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homepage.VerifyUserNameLabel());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homepage.clickOnContacts();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
