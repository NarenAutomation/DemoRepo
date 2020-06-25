package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public WebDriver driver;
	public Properties prop;
	
	public TestBase() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
	}
	
	public void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\drivers\\chromedriver-83\\chromedriver.exe");
			driver=new ChromeDriver();			
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\narendran.r\\eclipse-workspace\\FreeCRMTest\\drivers\\IEDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
}
