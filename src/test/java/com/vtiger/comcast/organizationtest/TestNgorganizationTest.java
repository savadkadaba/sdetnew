package com.vtiger.comcast.organizationtest;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.generiUtility.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class TestNgorganizationTest extends BaseAnnotationClass  {
	@Test(groups = "smokeTest")
	public void createorganization() throws Throwable, Throwable {
		
		/*Read test script Data*/
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + "-"+randomInt;
		
		 /*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
        homePage.getOrganizationLnk().click();
        
        /*step 3 : navigate to "create new organization"page by click on "+" image */
        Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
        /*step 4 : create organization*/
        CreateNewOrganization cno = new CreateNewOrganization(driver);
        cno.createOrg(orgName);
        
       /*step 5 : verify the successful msg with org name*/
        OrganizationInfo oinfop = new OrganizationInfo(driver);
        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
        System.out.println(actSuccesfullMg);
        
        if(actSuccesfullMg.contains(orgName)) {
        	System.out.println(orgName + "==>created successfully");
        }else {
        	System.out.println(orgName + "==> not created successfully");

        }
      
	}
	@Test(groups="regressionTest")
	public void createorganizationindustry( ) throws Throwable, Throwable {
		
		/*Read test script Data*/
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + "-"+randomInt;

		
		 /*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
        homePage.getOrganizationLnk().click();
        
        /*step 3 : navigate to "create new organization"page by click on "+" image */
        Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
        
      /*
       
       */
        
     CreateNewOrganization cno = new CreateNewOrganization(driver);
     cno.createdropd(orgName);
      
        
        /*step 5 : verify the successful msg with org name*/
        OrganizationInfo oinfop = new OrganizationInfo(driver);
        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
        System.out.println(actSuccesfullMg);
        
        if(actSuccesfullMg.contains(orgName)) {
        	System.out.println(orgName + "==>created successfully");
        }else {
        	System.out.println(orgName + "==> not created successfully");

        }
       
	}

	}
	
	
	
	


