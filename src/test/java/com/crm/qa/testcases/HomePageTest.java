package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() throws IOException {
		super();
	}
	
	//test cases should be independent
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitle() {
		String actualTitle=homepage.homePageTitleValidation();
		Assert.assertEquals(actualTitle, "CRMPRO");
	}
	
	
	@Test(priority=2)
	public void verifyUserName() {	
		Assert.assertTrue(homepage.verifyCorrectUserName());
		}
	
	@Test(priority=3)
	public void verifyContactLink() throws IOException {
		testutil.switchToMainFrame();
		contactspage=homepage.clickOnContactsLink();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
