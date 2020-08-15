package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
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
		contactsPage = homepage.clickOnContacts();
	}
	
	
	@Test(priority = 3)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts labels is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Mini Kaur");
	}
	
	@Test(priority=1, dataProvider = "getCRMTestData()")
	public void validateCreateNewContact(String fname, String lname, String comp ) {
		contactsPage.clickOnNewContact();
		//contactsPage.createNewContact("Rohit", "Sharma", "fidelity");
	}
	
	@DataProvider
	public Object [][] getCRMTestData() throws IOException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
