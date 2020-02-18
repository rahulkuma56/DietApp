package com.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports report;
	public ExtentTest logger; 
	@BeforeSuite
	public void setupSuite() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//Reports//ExtentReport.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}  
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver =  new ChromeDriver();
		 System.out.println("Driver is setup");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://twggnhiringworkshop.herokuapp.com");
		 wait = new WebDriverWait(driver, 10);

		
		 
	}
	@AfterMethod
	public void TearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL	, logger.getStatus().toString());
			//logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)))
		}
		report.flush();
	}
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
