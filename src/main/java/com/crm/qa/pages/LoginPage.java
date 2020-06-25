package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement CRMLogo;
	
	//Initializing the Page object
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
