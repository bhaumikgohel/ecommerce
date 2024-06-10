package ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;

import ecom.TestBase;

public class AddtoCartPageTest extends TestBase{
	
	HomePage homepageobj;
	ProductDetailPage productdetailpageobj;
	AddtoCartPage addtocartpageobj;
	CartPage cartpageobj;
	CheckoutPage checkoutpageobj;
	
	public AddtoCartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		productdetailpageobj =	homepageobj.Click_On_Product();
		addtocartpageobj =	productdetailpageobj.ClickOnAddtoCartButton();
		
		
	}
	
	@Test(priority=1)
	public void Verify_Page_Title_Test() {

		
		String title = addtocartpageobj.VerifyAddtoCartPageTitle();
		
		Assert.assertEquals(title, "Your Shopping Cart – Home Galore","Title not matched");
		
	}
	
	@Test(priority=2)
	public void Verify_Page_Logo_Test() {
		boolean logo = addtocartpageobj.Verifylogo();
		Assert.assertTrue(logo, "Site Logo Not displaying to user");
	}
	
	@Test(priority=3)
	public void Verify_Searchbox_Test() {
		boolean Searchbox = addtocartpageobj.VerifyProductSearchbox();
		Assert.assertTrue(Searchbox, "Searchbox not displaying to user");
	}
	
	@Test(priority=4)
	public void Verify_CartPage_Text_Test() {
		String[] CartPageText = addtocartpageobj.VerifyProductPageText();
		Assert.assertEquals(CartPageText[0], "HomeGalore Premium Document Organizer Bag");
		Assert.assertEquals(CartPageText[1], "Rs. 1,595.00");
		Assert.assertEquals(CartPageText[2], "MY CART");
		
	}
	
	@Test(priority=5)
	public void Verify_Navigation_Menu_Test() {
		boolean Navigationmenu = addtocartpageobj.VerifyNavigationMenu();
		Assert.assertTrue(Navigationmenu, "Navigation Menu Not Displaying");
	}
	
	
	@Test(priority=6)
	public void Verify_Cart_Qty_Increase_Test() {
		String productprice = addtocartpageobj.VerifyIncreaseQTYFunctionality();
		
		Assert.assertEquals(productprice, "Rs. 3,190.00", "Product price not matched");
	}
	
	@Test(priority=7)
	public void Verify_Cart_Decrease_Qty_Test() {
		cartpageobj = addtocartpageobj.VerifyDecreaseQTYFunctionality();
	}
	
	@Test(priority=8)
	public void Click_on_Checkout_button_Test() {
		checkoutpageobj = addtocartpageobj.ClickOnCheckOutButton();
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}

}
