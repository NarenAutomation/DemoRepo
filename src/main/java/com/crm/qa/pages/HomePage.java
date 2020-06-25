package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;
	
	@FindBy(linkText="Contacts")
	WebElement contactsLink;
	
	@FindBy(linkText="Deals")
	WebElement dealsLink;
	
	@FindBy(linkText="Tasks")
	WebElement tasksLink;
	
	@FindBy(linkText="New Contact")
	WebElement newContactLink;
	
	public HomePage() throws IOException {		
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitleValidation() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		 contactsLink.click();
		 return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
}
