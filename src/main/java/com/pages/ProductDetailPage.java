package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;
import util.Testutil;

public class ProductDetailPage extends TestBase{
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='q' and @type='text'])[1]")
	WebElement Searchbox;
	
	@FindBy(xpath="(//a//img)[2]")
	WebElement logo;
	
	@FindBy(xpath="//span[@class='cart-txt']")
	WebElement MyCartIcon;
	
	@FindBy(xpath="(//div[@class='container'])[3]")
	WebElement Navigationmenu;
	
	@FindBy(xpath="//h2[@itemprop='name']")
	WebElement Productheading;
	
	@FindBy(xpath="//button[@class='cart-btn' and @type='submit']")
	WebElement addtocartbtn;
	
	public String VerifyProductPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean Verifylogo() {
		return logo.isDisplayed();
	}
	
	public boolean VerifyProductSearchbox() {
		return Searchbox.isDisplayed();
	}
	
	
	public String VerifyProductDetailPageCartIcon() {
		return MyCartIcon.getText();
	}
	
	public boolean VerifyNavigationMenu() {
		return Navigationmenu.isDisplayed();
	}
	
	public String VerifyProductHeadingText() {
		return Productheading.getText();
	}
	
	public AddtoCartPage ClickOnAddtoCartButton() {
		Testutil.WaitforElement(driver, addtocartbtn, Duration.ofSeconds(10));
		addtocartbtn.click();
		
		return new AddtoCartPage();
	}
	
}
