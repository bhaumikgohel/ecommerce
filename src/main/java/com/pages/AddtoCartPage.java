package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;

public class AddtoCartPage extends TestBase{
	
	public AddtoCartPage() {
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
	
	@FindBy(xpath="//h2[contains(text(),'Shopping cart')]")
	WebElement shopingcartheading;
	
	@FindBy(xpath="//a[contains(text(),'HomeGalore Premium Document Organizer Bag')]")
	WebElement productheading;
	
	@FindBy(xpath="(//span[@class='bcpo-cart-item-line-price'])[2]")
	WebElement productprice;
	
	@FindBy(xpath="//i[@class='cart_qty_cls']")
	WebElement cartitems;
	
	@FindBy(xpath="//button[@class='checkout-btn']")
	WebElement Checkoutbtn;
	
	@FindBy(xpath="//input[@class='QuantityInput']")
	WebElement qty;
	
	@FindBy(xpath="//a[@class='plus cart_qty']")
	WebElement pluscarteqty;
	
	@FindBy(xpath="//a[@class='minus cart_qty']")
	WebElement minuscartqty;
	
public String VerifyAddtoCartPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean Verifylogo() {
		return logo.isDisplayed();
	}
	
	public boolean VerifyProductSearchbox() {
		return Searchbox.isDisplayed();
	}
	
	
	public boolean VerifyNavigationMenu() {
		return Navigationmenu.isDisplayed();
	}
	
	
	public String[] VerifyProductPageText() {
		String productheadingtext = productheading.getText();
		String productpricetext = productprice.getText();
		 String CartText = MyCartIcon.getText();
		 
		return new  String[]  {productheadingtext,productpricetext,CartText};
	}
	
	public CartPage VerifyDecreaseQTYFunctionality() {
		
		minuscartqty.click();
		
		return new CartPage();
		
		
	}
	
	public CheckoutPage ClickOnCheckOutButton() {
		Checkoutbtn.click();
		
		return new CheckoutPage();
	}
	
public String VerifyIncreaseQTYFunctionality() {
		
		pluscarteqty.click();
		
		String count = qty.getText();
		
		if(count.equals("2")) {
			productprice.getText();
		}
		return productprice.getText();
		
	}
	
}
