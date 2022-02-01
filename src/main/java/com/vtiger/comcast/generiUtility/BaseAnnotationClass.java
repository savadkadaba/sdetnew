package com.vtiger.comcast.generiUtility;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;


public class BaseAnnotationClass {
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("========>Connect to database<=======");
	}

	/*Object Creation for Lib*/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtlity eLib = new ExcelUtlity();
	public WebDriver driver = null;
	public static WebDriver sDriver = null;
	


	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void Launchbrowser() throws Throwable {
		System.out.println("=======> Launch the browser<====");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}
	}
@BeforeMethod(groups = {"smokeTest","regressionTest"})
public void configlog() throws Throwable
		{
	System.out.println("=======>Login<=======");
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			 /* step 1 : login */
			driver.get(URL);
			wLib.waitUntilPageLoad(driver);
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
		}

@AfterMethod(groups = {"smokeTest","regressionTest"})
public void confilogout() {
	System.out.println("=========>Logout<=========");
	Home hp = new Home(driver);
	hp.logout();
	
	

	}
	
	
@AfterClass(groups = {"smokeTest","regressionTest"})
public void closebrowser() {
	System.out.println("========>Close the browser<========");
	driver.quit();
}
	
@AfterSuite(groups = {"smokeTest","regressionTest"})
public void config() {
	System.out.println("=======>Close database connection<========");
}
}
