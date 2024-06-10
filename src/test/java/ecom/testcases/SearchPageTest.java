package ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.HomePage;
import com.pages.SearchPage;

import ecom.TestBase;

public class SearchPageTest extends TestBase{
	
	HomePage homepageobj;
	SearchPage searchpageobj;
	
	public SearchPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		searchpageobj = homepageobj.Verify_Search_Functionality_with_Valid_Data();
	}
	
	@Test(priority=1)
	public void Verify_Page_Title_Test() {
		String Title = searchpageobj.VerifySearchPageTitle();
		Assert.assertEquals(Title, "Search: 1 result found for \"HomeGalore Premium Document Organizer Bag\" – Home Galore");
	}
	
	@Test(priority=2)
	public void Verify_Logo_Test() {
		boolean logo = searchpageobj.Verifylogo();
		Assert.assertTrue(logo, "Logo Not Displaying");
	}
	
	@Test(priority=3)
	public void Verify_Product_On_Search_Page_Test() {
		boolean ProductDetailGrid = searchpageobj.VerifyProductOnSearchPage();
		Assert.assertTrue(ProductDetailGrid, "Product Grid Not Displaying");
	}
	
	@Test(priority=4)
	public void Verify_Invali_Search_Functionality_Test() {
		String InvalidSearchResult = searchpageobj.Verify_Invalid_Search_Functionality();
		
		Assert.assertEquals(InvalidSearchResult, "Your search for \"Test Product with invalid result\" did not yield any results.");
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
