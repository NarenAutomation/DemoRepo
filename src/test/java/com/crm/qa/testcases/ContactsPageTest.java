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
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="Data";
	
	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToMainFrame();
		homepage.clickOnContactsLink();
	}

	@Test(priority=1)
	public void verifyContactsTextTest() throws IOException {
		Assert.assertTrue(contactspage.verifyContactsText(), "Contacts");
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname) {
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title, firstname, lastname);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		Object data[][]=testutil.getTestData(sheetname);
		return data;
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
