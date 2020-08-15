package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[@class='user-display' and text()='Chetan Chauhan']")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement Contacts;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement Deals;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement Tasks;
	
	//Initializing the Page Factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyUserNameLabel() {
		return UsernameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContacts() {
		Contacts.click();
		return new ContactsPage();
	}
		
	public DealsPage clickOnDeals() {
		Deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		Tasks.click();
		return new TasksPage();
	}
}
