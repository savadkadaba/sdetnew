package com.vtiger.comcast.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.comcast.generiUtility.ExcelUtlity;
import com.vtiger.comcast.generiUtility.FileUtility;
import com.vtiger.comcast.generiUtility.JavaUtility;
import com.vtiger.comcast.generiUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Contact_info_page;
import com.vtiger.comcast.pomrepositylib.Contact_page;
import com.vtiger.comcast.pomrepositylib.Create_new_contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class Createcontact {
	public static void main(String[] args) throws Throwable {
		/*Object Creation for Lib*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtlity eLib = new ExcelUtlity();
		WebDriver driver = null;
				
		/* Read common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*Read test script Data*/
		int randomInt = jLib.getRandomNumber();
		String conname = eLib.getDataFromExcel("contact", 1, 2) + "-"+randomInt;
		
		
		/* Launch the browser*/
		if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}
        
        /* step 1 : login */
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
        Login loginPage = new Login(driver);
        loginPage.loginToApp(USERNAME, PASSWORD);
        
        
     
     /* step : 2 navigate to contact */
        Home hp = new Home(driver);  
 		hp.getGetcontactLnk().click();
        
      
      
      // step :3 create the contacts
       Contact_page cp = new Contact_page(driver);
       cp.getCretcontctIcon().click();
      
      // step : 4 create new contact
       Create_new_contact_page cnp = new Create_new_contact_page(driver);
       cnp.getLastnameEdt().sendKeys(conname);
       cnp.getSaveBtn().click();
       
       //step : 5 verify the contact
       Contact_info_page cinfo = new Contact_info_page(driver);
       String actName = cinfo.getSuccesfullMsg().getText();
    
      if(actName.contentEquals(actName)) {
    	  System.out.println("contact created succesful");
      }
      else {
    	  System.out.println("contact not created === failed");
      }
       //step :6 logout
      hp.logout();
      
      // step: 7 close
      driver.close();
	}
	}
		 


