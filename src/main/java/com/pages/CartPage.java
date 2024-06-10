package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;

public class CartPage extends TestBase{

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='empty-page-content text-center']//h1")
	WebElement CartHeadingtext;
	
	@FindBy(xpath="//p[@class='cart--empty-message']")
	WebElement CartSSubHeadingText;
	
	@FindBy(xpath="//a[@class='btn btn--has-icon-after cart__continue-btn']")
	WebElement ContinueShoppingbtn;
	
	@FindBy(xpath="//i[@class='cart_qty_cls']")
	WebElement cartitems;
	
	public String[] VerifyEmptyCartHeading() {
		
		String Heading = CartHeadingtext.getText();
		String SubHeading = CartSSubHeadingText.getText();
		
		return new String[] {Heading,SubHeading};
	}
	
	public boolean VerifyEmptyCartbutton() {
		return ContinueShoppingbtn.isDisplayed();
	}
	
	public HomePage VerifyEmptyCartItems() {
		String count = cartitems.getText();
		
		if(count.equals("0")) {
			System.out.println("Cart is Empty");
			ContinueShoppingbtn.click();
			
		}
		else {
			System.out.println("Cart is not empty");
		}
		return new HomePage();
	}
}
