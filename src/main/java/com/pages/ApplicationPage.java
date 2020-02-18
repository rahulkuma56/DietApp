package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplicationPage {
	@ FindBy(how=How.XPATH, using="//div[@class='ui fluid search']//input")
	public WebElement searchBox;
	
	@ FindBy(how=How.XPATH, using="//i[@class= 'search icon']")
	public WebElement searchIcon;
	
	@ FindBy(how=How.XPATH, using="//i[@class= 'remove icon']")
	public WebElement removeIcon;

	public WebElement selectFood(WebDriver driver,String food) {
		// TODO Auto-generated method stub
		
return driver.findElement(By.xpath("//div[@id='food-search']//td[text()='"+food+"']/.."));
		
	}
	
	
	
	

}
