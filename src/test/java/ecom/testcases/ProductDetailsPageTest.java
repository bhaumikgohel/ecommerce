package ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;
import com.pages.SearchPage;

import ecom.TestBase;

public class ProductDetailsPageTest extends TestBase {
	
	HomePage homepageobj;
	ProductDetailPage productdetailpageobj;
	AddtoCartPage addtocartpage;
	
	public ProductDetailsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		productdetailpageobj =	homepageobj.Click_On_Product();
//		addtocartpage = new AddtoCartPage();
	}
	
	@Test(priority=1)
	public void Verify_Page_Title_Test() {

		
		String title = productdetailpageobj.VerifyProductPageTitle();
		
		Assert.assertEquals(title, "HomeGalore Premium Document Organizer Bag – Home Galore","Title not matched");
		
	}
	
	@Test(priority=2)
	public void Verify_Page_Logo_Test() {
		boolean logo = productdetailpageobj.Verifylogo();
		Assert.assertTrue(logo, "Site Logo Not displaying to user");
	}
	
	@Test(priority=3)
	public void Verify_Searchbox_Test() {
		boolean Searchbox = productdetailpageobj.VerifyProductSearchbox();
		Assert.assertTrue(Searchbox, "Searchbox not displaying to user");
	}
	
	@Test(priority=4)
	public void Verify_Cart_Test() {
		String Carticon = productdetailpageobj.VerifyProductDetailPageCartIcon();
		Assert.assertEquals(Carticon, "MY CART");
	}
	
	@Test(priority=5)
	public void Verify_Navigation_Menu_Test() {
		boolean Navigationmenu = homepageobj.VerifyNavigationMenu();
		Assert.assertTrue(Navigationmenu, "Navigation Menu Not Displaying");
	}
	
	@Test(priority=6)
	public void Verify_Add_to_Cart_Functionality_Test() {
		addtocartpage =	productdetailpageobj.ClickOnAddtoCartButton();
	}

	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
