package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase {
	
	
	// //div[@id='dashboard-toolbar']/div[1][contains(text(),'Contacts')]
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement last_name;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	
	//Initializing the Page Factory
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void clickOnNewContact() {
		newContact.click();
	}
	
	public void selectContactsByName(String name) {
		//WebDriverWait wait2 = new WebDriverWait(driver, 10);
		//wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("xpath_of_element_to_be_invisible")));
		//driver.findElement(By.xpath("xpath_element_to_be_clicked")).click();
		
		driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td[1]/div")).click();;
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[1]/div/label
		//td[text()='Mini Kaur']//parent::tr/td[1]/div
	}
	
	public void createNewContact(String fname, String lname, String companyname) {
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		company.sendKeys(companyname);
		save.click();
	}

}
