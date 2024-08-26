package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	
	@FindBy(id ="input-email")
	private WebElement emailValidation;

	@FindBy(id ="input-password")
	private WebElement passwordValidation;
	
	@FindBy(xpath ="//input[ @ value ='Login']")
	private WebElement clickLoginvalidation; 
	
	
	
	public loginPage (WebDriver driver) {
		
		this.driver =driver ;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmail(String emailText) {
		emailValidation.sendKeys(emailText);
		
	
	}

	public void enterPassword(String passwordText) {
		passwordValidation.sendKeys(passwordText);
		
	
	}
//	public loginPage login(String loginText,String passwordText) {
//		emailValidation.sendKeys(loginText);
//		passwordValidation.sendKeys(passwordText);
//		return new loginPage(driver);
//	}

	public void clickLogin() {
		clickLoginvalidation.click();

	
	
	}
	
	
}
