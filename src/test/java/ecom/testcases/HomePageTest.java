package ecom.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ProductDetailPage;
import com.pages.SearchPage;

import ecom.TestBase;

public class HomePageTest extends TestBase{

	HomePage homepageobj;
	SearchPage searchpageobj;
	ProductDetailPage productdetailpageobj;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		productdetailpageobj = new ProductDetailPage();
	}
	
	@Test(priority=1)
	public void Verify_Page_Home_Page_Title_Test() {

		
		String title = homepageobj.VerifyHomePageTitle();
		
		Assert.assertEquals(title, "Home Galore","Title not matched");
		
	}
	
	@Test(priority=2)
	public void Verify_Home_Page_Logo_Test() {
		boolean logo = homepageobj.Verifylogo();
		Assert.assertTrue(logo, "Site Logo Not displaying to user");
	}
	
	@Test(priority=3)
	public void Verify_Search_box_Test() {
		boolean Searchbox = homepageobj.VerifySearchbox();
		Assert.assertTrue(Searchbox, "Searchbox not displaying to user");
	}
	
	@Test(priority=4)
	public void Verify_Cart_Test() {
		String Carticon = homepageobj.VerifyHomePageCartIcon();
		Assert.assertEquals(Carticon, "MY CART");
	}
	
	@Test(priority=5)
	public void Verify_Navigation_Menu_Test() {
		boolean Navigationmenu = homepageobj.VerifyNavigationMenu();
		Assert.assertTrue(Navigationmenu, "Navigation Menu Not Displaying");
	}
	
	@Test(priority=6)
	public void Verify_Home_Page_Image_Test() {
		boolean Mainimage = homepageobj.VerifyHomeMainImage();
		Assert.assertTrue(Mainimage, "Navigation Menu Not Displaying");
	}
	
	@Test(priority=7)
	public void Validate_Search_Functionality() {
		homepageobj.SearchPageDataUsingDataDriven();
	}
	
	@Test(priority=8)
	public void Verify_Product() {
	 productdetailpageobj =	homepageobj.Click_On_Product();
	}
	
	@Test(priority=9)
	public void Verify_Footer_Section_Test() {
		boolean footer = homepageobj.VerifyFooterSections();
		Assert.assertTrue(footer, "Searchbox not displaying to user");
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
