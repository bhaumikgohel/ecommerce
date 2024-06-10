package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;
import util.Testutil;

public class CheckoutPage extends TestBase{

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	//p[@id='error-for-TextField0']

	

	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmailid;
	
	@FindBy(xpath="//p[@id='error-for-email']")
	WebElement Emailvalidationtext;
	
	@FindBy(xpath="//select[@id='Select0']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='TextField0']")
	WebElement inputFirstName;
	
	@FindBy(xpath="//p[@id='error-for-TextField0']")
	WebElement Firstnamevalidationtext;
	
	@FindBy(xpath="//input[@id='TextField1']")
	WebElement inputLastName;
	
	@FindBy(xpath="//p[@id='error-for-TextField1']")
	WebElement Lastnamevalidationtext;
	
	
	@FindBy(xpath="//input[@id='TextField2']")
	WebElement inputAddress;
	
	@FindBy(xpath="//p[@id='error-for-TextField2']")
	WebElement AddressValidationtext;
	
	@FindBy(xpath="//input[@id='TextField4']")
	WebElement inputCity;
	
	@FindBy(xpath="//p[@id='error-for-TextField4']")
	WebElement CityValidationtext;
	
	@FindBy(xpath="//input[@id='TextField5']")
	WebElement inputPincode;
	
	@FindBy(xpath="//p[@id='error-for-TextField5']")
	WebElement PincodeValidationtext;
	
	@FindBy(xpath="//input[@id='TextField6']")
	WebElement inputPhone;
	
	@FindBy(xpath="//p[@id='error-for-TextField6']")
	WebElement Phonevalidation;
	
	@FindBy(xpath="//input[@id='basic-paymentOnDelivery']")
	WebElement CashOnDelivery;
			
	@FindBy(xpath="//label[@for='basic-PhonePe Payment Gateway (UPI, Cards & NetBanking)']")
	WebElement PaymentGateway;
			
	
	@FindBy(xpath="//input[@id='ReductionsInput4']")
	WebElement inputCouponcode;
	
	@FindBy(xpath="//button[@class='QT4by _1fragempw rqC98 _1m2hr9gc _1m2hr9ga _7QHNJ VDIfJ janiy _1m2hr9gr']")
	WebElement CouponApplyBtn;
	
	@FindBy(xpath="//button[@id='checkout-pay-button']")
	WebElement Paynowbtn;
	
	@FindBy(xpath="//button[@id='checkout-pay-button']")
	WebElement CompleteOrderbtn;
	
	public String VerifyCheckoutPageTitle() {
		return driver.getTitle();
	}
	
	
	public String[] CheckRequiredFieldValidationMessage() throws InterruptedException {
		
		Testutil.WaitforElement(driver, PaymentGateway, Duration.ofSeconds(20));
		Testutil.ScrollSpecificElelemnt(PaymentGateway);
		
		Thread.sleep(3000);
		
		Paynowbtn.click();
		
		Thread.sleep(3000);
		
		String emailvalidation = Emailvalidationtext.getText();
		String Firstnamevalidation = Firstnamevalidationtext.getText();
		String Lastnamevalidation = Lastnamevalidationtext.getText();
		String AddressValidation = AddressValidationtext.getText();
		String CityValidation = CityValidationtext.getText();
		String pincodeValidation = PincodeValidationtext.getText();
		String phonenumbervalidation = Phonevalidation.getText();
		
		return new String[] {emailvalidation,Firstnamevalidation,Lastnamevalidation,AddressValidation,CityValidation,pincodeValidation,phonenumbervalidation};
		
	}
	
	public String[] CheckFieldsValidationsMessagesWithNagativeValue(String email, String firstname, String lastname, String Address, String city, String pincode, String mobileno) throws InterruptedException {
		
		Testutil.WaitforElement(driver, Paynowbtn, Duration.ofSeconds(20));
		Testutil.ScrollSpecificElelemnt(PaymentGateway);
		
		inputEmailid.sendKeys(email);
		inputFirstName.sendKeys(firstname);
		inputLastName.sendKeys(lastname);
		inputAddress.sendKeys(Address);
		inputCity.sendKeys(city);
		inputPincode.sendKeys(pincode);
		inputPhone.sendKeys(mobileno);
		
		Paynowbtn.click();
		
		Thread.sleep(5000);
		
		
		String emailvalidation = Emailvalidationtext.getText();
		String pincodeValidation = PincodeValidationtext.getText();
		String phonenumbervalidation = Phonevalidation.getText();
		
		return new String[] {emailvalidation,pincodeValidation,phonenumbervalidation};
		
		
	}
	
}
