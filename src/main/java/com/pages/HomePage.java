package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.TestBase;
import util.Testutil;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='q' and @type='text'])[1]")
	WebElement Searchbox;
	
	@FindBy(xpath="(//a//img)[2]")
	WebElement logo;
	
	@FindBy(xpath="//span[@class=\"cart-txt\"]")
	WebElement MyCartIcon;
	
	@FindBy(xpath="(//div[@class=\"container\"])[3]")
	WebElement Navigationmenu;
	
	@FindBy(xpath="//img[@class=\"lazyload desktop-img\"]")
	WebElement mainimage;
	
	@FindBy(xpath="//a[contains(text(),'HomeGalore Premium Document Organizer Bag')]")
	WebElement Productheading;
	
	@FindBy(xpath="//h2[contains(text(),'Best Selling')]")
	WebElement Productheader;
	
	@FindBy(xpath="//div[@class='main-footer']")
	WebElement footersection;
	
	public String VerifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean Verifylogo() {
		return logo.isDisplayed();
	}
	
	public boolean VerifySearchbox() {
		return Searchbox.isDisplayed();
	}
	
	
	public String VerifyHomePageCartIcon() {
		return MyCartIcon.getText();
	}
	
	public boolean VerifyNavigationMenu() {
		return Navigationmenu.isDisplayed();
	}
	
	public boolean VerifyHomeMainImage() {
		return mainimage.isDisplayed();
	}
	
	public void SearchPageDataUsingDataDriven() {
		
		String SearchDataFile = "D:\\Automation\\ecom\\src\\main\\java\\testdata\\searchData.xlsx";
		
		List<String> SearchData = Testutil.readSearchTermsFromExcel(SearchDataFile);
	     
	     for (String searchTerm : SearchData) {
	         Searchbox.clear();
	         Searchbox.sendKeys(searchTerm);
	         
	         Searchbox.submit();
	         try {
	             Thread.sleep(2000);
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	         driver.navigate().back();
	     }
		
	}
	 
	public ProductDetailPage Click_On_Product() {
		
		Testutil.ScrollSpecificElelemnt(Productheader);
		Productheading.click();
		
		
		return new ProductDetailPage();
	}
	
	public SearchPage Verify_Search_Functionality_with_Valid_Data() {
		Searchbox.sendKeys(prop.getProperty("validsearchdata"));
		Searchbox.sendKeys(Keys.ENTER);
		
		return new SearchPage();
	}
	
	public boolean VerifyFooterSections() {
		return footersection.isDisplayed();
	}

}
