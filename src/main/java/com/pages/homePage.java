package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
 WebDriver driver;
	
	@FindBy(xpath ="//a[text() ='My Account']")
	private WebElement MyAccountvalidation;

	@FindBy(linkText ="Login")
	private WebElement clickingUponLoginButton;
	
	
	
	public homePage (WebDriver driver) {
		
		this.driver =driver ;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickMyAccount() {
		MyAccountvalidation.click();
		
	
	}
	
	public void ClickLoginButton() {
    clickingUponLoginButton.click();
		
	
	}
	
}
