package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactsText;
	
	@FindBy(name="title")
	WebElement dropdownTitle;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsText() throws IOException {
		return contactsText.isDisplayed();
	}
	
	public void createNewContact(String title, String ftname,String ltname) {
		Select dropdown=new Select(dropdownTitle);
		dropdown.selectByValue(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		saveButton.click();
	}
	
}
