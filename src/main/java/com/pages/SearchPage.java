package com.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;
import util.Testutil;

public class SearchPage extends TestBase{
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header-logo']")
	WebElement logo;
	
	@FindBy(xpath="//h2[text()='Products']")
	WebElement ProductGrid;
	
	@FindBy(xpath="//input[@id='SearchInput']")
	WebElement Searchinput;
	
	@FindBy(xpath="//p[contains(text(),'Your search for \"Test Product with invalid result\"')]")
	WebElement InvalidSearchResult;
	
	
	
	public String VerifySearchPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean Verifylogo() {
		return logo.isDisplayed();
	}
	
	public boolean VerifyProductOnSearchPage() {
		
		return ProductGrid.isDisplayed();
	}
	public String Verify_Invalid_Search_Functionality() {
		Searchinput.clear();
		Searchinput.sendKeys(prop.getProperty("invalidsearchdata"));
		Searchinput.sendKeys(Keys.ENTER);
		
		Testutil.WaitforElement(driver, InvalidSearchResult, Duration.ofSeconds(10));
		
		return InvalidSearchResult.getText();
		
	}
}
