package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountPage {

	
 WebDriver driver;
	
	@FindBy(xpath ="//a[contains(text(),'Edit your account information')]")
	private WebElement MyAccountpagedisplayed;



	public accountPage (WebDriver driver) {
		
		this.driver =driver ;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean accountpageIsDisplayed() {
		boolean acc= MyAccountpagedisplayed.isDisplayed();
		return acc ;
	
	}
}
