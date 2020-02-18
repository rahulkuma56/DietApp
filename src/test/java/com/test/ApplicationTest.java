package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.ApplicationPage;
/*
 * Page Object Model
 * Uses the 
 */
public class ApplicationTest extends BaseTest {
	private ApplicationPage ap;
	
	@BeforeMethod
	public void initialze() {
		 ap = PageFactory.initElements(driver, ApplicationPage.class);
		 
		
		
	}
	
	@Test
	public void searchFood() {
		 //ap.searchBox.wait(5);
		try {
			logger= report.createTest("searchFood");
			logger.log(logger.getStatus(), "Exectution Start searchFood");
			 ap.searchBox.sendKeys("Raspberries, raw");
			 logger.log(logger.getStatus(), "Search Raspberries, raw");
			 int size = driver.findElements(By.xpath("//div[@id='food-search']//td/..")).size();
			System.out.println(size);
			 assertTrue(size>0);
			 logger.log(logger.getStatus(), "Searched results for Raspberries, raw "+ size);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void clearSearchBox() {
		 
		try {
			logger= report.createTest("clearSearchBox");
			logger.log(logger.getStatus(), "Start execution clearSearchBox");
			 ap.searchBox.sendKeys("Raspberries, raw");
			 logger.log(logger.getStatus(), "Search Raspberries, raw");
			// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='food-search']//td[text()='Raspberries, raw']..\")));

			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();",  ap.selectFood(driver,"Raspberries, raw"));
			 logger.log(logger.getStatus(), "clicked on macthing  'Raspberries, raw' result");
		
			 logger.log(logger.getStatus(), "Raspberries, raw is selected");
			 ap.removeIcon.click();
			 logger.log(logger.getStatus(), "reomve icon is clicked");
			 assertEquals(ap.searchBox.getText(), "");
			 logger.log(logger.getStatus(), "Verify search box is blank");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void searchAndSelectFood() {
		 
		try {
			logger= report.createTest("Check steps Logs");
			logger.log(logger.getStatus(), "Logger information step");
			 ap.searchBox.sendKeys("Raspberries, raw");
			 logger.log(logger.getStatus(), "Search Raspberries, raw");
			
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();",  ap.selectFood(driver,"Raspberries, raw"));

			
			 logger.log(logger.getStatus(), "Raspberries, raw is selected");
			 ap.removeIcon.click();
			 logger.log(logger.getStatus(), "reomve icon is clicked");
			 System.out.println(driver.findElements(By.xpath("//td[text()='Raspberries, raw']")).size());
			 assertEquals(driver.findElements(By.xpath("//td[text()='Raspberries, raw']"))
					  .get(0).getText(),"Raspberries, raw" ); 
			 logger.log(logger.getStatus(),"Verify selected  'Raspberries, raw'");
			 
			/*
			 * driver.findElement(By.
			 * xpath("//td[text()='Raspberries, raw']/../td[@class = 'trash']")).click();
			 * System.out.println(driver.findElements(By.
			 * xpath("//td[text()='Raspberries, raw']")).size());
			 * 
			 */
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
