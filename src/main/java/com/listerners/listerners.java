package com.listerners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.nio.file.*;

import basicapplication.utitities.Utilities;
import basicapplication.utitities.extentReporter;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;

public class listerners implements ITestListener {
	WebDriver driver = null;
	 ExtentReports expentReport ;
	 ExtentTest extentTest ;
	@Override
	public void onStart(ITestContext context) {
		  expentReport = extentReporter.generateExtentReport();		
	}

	@Override
	public void onTestStart(ITestResult result) {
	String testName =	result.getName();
	 extentTest = expentReport .createTest(testName);
	extentTest.log(Status.INFO, testName+"strated successfully");
	

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName =	result.getName();
		 extentTest = expentReport .createTest(testName);
		extentTest.log(Status.PASS, testName+"successfullyexecuted");
		
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String testName =	result.getName();
	WebDriver driver = null ;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		

		
		 
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String  destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(sourceFile,new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
		
	}

		
		


		

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName =	result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testName+"skipped");
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		expentReport.flush();
		String extentReports = System.getProperty("user.dir")+"\\test-output\\extentreports\\extentreports.html";
		File reports =new File(extentReports);
		
		try {
			Desktop.getDesktop().browse(reports.toURI());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	}
		
}