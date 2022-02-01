package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;  //global driver variable
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(linkText = "Organizations")
private WebElement organizationLnk;

@FindBy(linkText = "Products")
private WebElement productLnk;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstatorImg;

@FindBy(linkText="Contacts")
private WebElement getcontactLnk;


public WebElement getGetcontactLnk() {
	return getcontactLnk;
}
@FindBy(linkText = "Sign Out")
private WebElement signOutLnk;
public WebElement getAdminstatorImg() {
	return adminstatorImg;
}

public void setAdminstatorImg(WebElement adminstatorImg) {
	this.adminstatorImg = adminstatorImg;
}


public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getProductLnk() {
	return productLnk;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}
public void logout() {
	 Actions act = new Actions(driver);
	 act.moveToElement(adminstatorImg).perform();
	 signOutLnk.click();
}


	
	
	
	
	
	
	
	
	
	
	
	
}
