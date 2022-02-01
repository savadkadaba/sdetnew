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
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Create_new_contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class Createcontactwithorganization {

	public static void main(String[] args) throws Throwable {
		 /*Object Creation for Lib*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtlity eLib = new ExcelUtlity();
		
		
		
		/* Read common Data*/
		
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*Read test script Data*/
		int randomInt = jLib.getRandomNumber();
		String orgNm = eLib.getDataFromExcel("contact", 4, 3) + "-"+randomInt;
		String conNm = eLib.getDataFromExcel("contact", 1, 2);
		
		/* Launch the browser*/
		WebDriver driver = null;
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
        
        /*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
        homePage.getOrganizationLnk().click();
        
        /*step 3 : navigate to "create new organization"page by click on "+" image */
       Home hp= new Home(driver);
       hp.getOrganizationLnk().click();
       
       /* step:4 navigate to organization page */
       Organizations org = new Organizations(driver);
       org.getCreateOrgImg().click();
       
        
      /*step 5: create new organization page */
        wLib.waitUntilPageLoad(driver);
     CreateNewOrganization cno = new CreateNewOrganization(driver);
     cno.createOrg(orgNm);
    
     
    OrganizationInfo or = new OrganizationInfo(driver);
    wLib.waitForElementVisibility(driver, or.getSuccesfulMsg());
    
    
     
     /* step : 6 navigate to contact */
     		hp= new Home(driver);  
     		hp.getGetcontactLnk().click();
     		
        /* step 7: navigate to create contact*/
     		Contact_page cp = new Contact_page(driver);
     		cp.getCretcontctIcon().click();
      
      
      // step : 8 create new contact
       Create_new_contact_page cnp = new Create_new_contact_page(driver);
       cnp.createcontact(conNm, orgNm);
       
       //step : 9 verify the contact
       Contact_info_page cinfo = new Contact_info_page(driver);
       String actNm = cinfo.getSuccesfullMsg().getText();
       System.out.println(conNm);
       
       
       
      String actNamE = cinfo.getOraname().getText();
      if(actNamE.trim().equals(orgNm)) {
    	  System.out.println(orgNm+"is used to create con");
      }
      else {
    	  System.out.println(orgNm+"is not create con");  
      }
       //step :10 logout
      hp.logout();
      
      // step: 11 close
      driver.close();
	}
}
