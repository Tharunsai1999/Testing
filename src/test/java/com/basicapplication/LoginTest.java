package com.basicapplication;

import java.util.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.pages.homePage;
import com.pages.loginPage;


import Genaralpackage.Basic;
import basicapplication.utitities.Utilities;




public class LoginTest extends Basic {
	

	public LoginTest() {
	super();
	}
	 
	@BeforeMethod
	public void setup() {
	
    initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		
		homePage homepage = new homePage(driver);
		homepage.clickMyAccount();
		homepage.ClickLoginButton();
	}
	
	
	@AfterMethod
	 public void tearDown() {
		driver.quit();
	}
	@Test(priority=3,dataProvider="validCredentialsSupplier")
	public void verifyLoginwrongEmail(String Email,String Password) {
		
		  loginPage loginpage = new loginPage(driver);
		  loginpage.enterEmail(Email);
		  loginpage.enterPassword(Password);
		  loginpage.clickLogin();
	
		  
//	  String actualresult=  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//	  Assert.assertTrue(actualresult.contains("Warning: No match for E-Mail Address and/or Password."));
		// accountPage accountpage = new accountPage(driver);
		 String actualresult=  driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).getText();
  Assert.assertEquals(actualresult,"Edit your account information" , "isdisplalyed");
 
   //  Assert.assertEquals(accountpage.accountpageIsDisplayed(),"Edit your account information");
	}
	
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority =1)
	public void ObjectverifyLoginwrongPassword() {
		
	
		  driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		  driver.findElement(By.id("input-password")).sendKeys("12345");
		  driver.findElement(By.xpath("//input[ @ value ='Login']")).click();
		  
//		  String actualresult=  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//		  Assert.assertTrue(actualresult.contains("Warning: No match for E-Mail Address and/or Password."));
		
		  

	}

	
	
	
	
	
	@Test (priority =2, dependsOnMethods="ObjectverifyLoginwrongPassword")
	public void verifyLoginwrongemail() {
		
	
		  driver.findElement(By.id("input-email")).sendKeys(dataProp.getProperty("invalidemail"));
		  driver.findElement(By.id("input-password")).sendKeys("12345");
		  driver.findElement(By.xpath("//input[ @ value ='Login']")).click();
		  
		  String actualresult=  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		  Assert.assertTrue(actualresult.contains("Warning: No match for E-Mail Address and/or Password."));
		
	
}

}