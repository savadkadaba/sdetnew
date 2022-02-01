package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.generiUtility.WebDriverUtility;

public class Create_new_contact_page extends WebDriverUtility {
	WebDriver driver;  //global driver variable
	public Create_new_contact_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameEdt;
		
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orglookup;
	
	@FindBy(xpath="//input[contains(@class,'crmButton small save')]")
		private WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement getsearchBtn; 
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBTn;
	
	
	
	public WebElement getSearchNowBTn() {
		return searchNowBTn;
	}

	

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getOrglookup() {
		return orglookup;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
public void createcontact(String contactName, String orgName) {
	lastnameEdt.sendKeys(contactName);
orglookup.click();
switchToWindow(driver, "Accounts&action");

getsearchBtn.sendKeys(orgName);
getSearchNowBTn().click();


driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
switchToWindow(driver, "Contacts&action");

saveBtn.click();


}
		

}
