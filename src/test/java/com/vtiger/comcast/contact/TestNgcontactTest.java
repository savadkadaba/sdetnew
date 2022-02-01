package com.vtiger.comcast.contact;


import org.testng.annotations.Test;

import com.vtiger.comcast.generiUtility.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositylib.Contact_info_page;
import com.vtiger.comcast.pomrepositylib.Contact_page;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Create_new_contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class TestNgcontactTest extends BaseAnnotationClass{

	@Test(groups ="smokeTest")
	public void createcontact() throws Throwable, Throwable {
		int randomInt = jLib.getRandomNumber();
		String orgNm = eLib.getDataFromExcel("contact", 4, 3) + "-"+randomInt;
		String conNm = eLib.getDataFromExcel("contact", 1, 2);
		
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
		
	}
	
	@Test(groups = "regressionTest")
	public void createcontact1( ) throws Throwable, Throwable {
		/*Read test script Data*/
		int randomInt = jLib.getRandomNumber();
		String conname = eLib.getDataFromExcel("contact", 1, 2) + "-"+randomInt;
		
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
	}
}
