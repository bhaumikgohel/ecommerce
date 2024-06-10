package ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;

import ecom.TestBase;

public class CartPageTest extends TestBase{
	
	HomePage homepageobj;
	ProductDetailPage productdetailpageobj;
	AddtoCartPage addtocartpageobj;
	CartPage cartpageobj;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		productdetailpageobj = homepageobj.Click_On_Product();
		
	  addtocartpageobj = productdetailpageobj.ClickOnAddtoCartButton();
	 
	 cartpageobj = addtocartpageobj.VerifyDecreaseQTYFunctionality();
	 
	 
	}

	@Test(priority=1)
	public void Verify_Empty_Cart_Heading_Test() {
		String[] CartHeadingText = cartpageobj.VerifyEmptyCartHeading();
		
		Assert.assertEquals(CartHeadingText[0], "Your cart", "Heading is not Matched");
		Assert.assertEquals(CartHeadingText[1], "Your cart is currently empty.", "SubHeading is not Matched");
		
	}
	
	@Test(priority=2)
	public void Verify_Empty_Cart_Items_Test() {
		homepageobj =  cartpageobj.VerifyEmptyCartItems();
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
