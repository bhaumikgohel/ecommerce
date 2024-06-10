package ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.CheckoutPage;
import com.pages.HomePage;
import com.pages.ProductDetailPage;

import ecom.TestBase;
import util.Testutil;

public class CheckOutPageTest extends TestBase{
	
	HomePage  homepageobj;
	ProductDetailPage productdetailpageobj;
	AddtoCartPage addtocartpage;
	CheckoutPage checkoutpageobj;
	String sheetName = "checkoutdata";
	
	
	public CheckOutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		homepageobj = new HomePage();
		productdetailpageobj =	homepageobj.Click_On_Product();
		addtocartpage = productdetailpageobj.ClickOnAddtoCartButton();
		checkoutpageobj = addtocartpage.ClickOnCheckOutButton();
		
		
	}

	@Test(priority=1)
	public void Check_Check_Out_Page_Title_Test() {
		String CheckOutPageTitle = checkoutpageobj.VerifyCheckoutPageTitle();
		
		Assert.assertEquals(CheckOutPageTitle, "Your Shopping Cart – Home Galore");
	}
	
	
	@Test(priority=2)
	public void CheckOutRequiredFieldValidationTest() throws InterruptedException {
		String[] checkoutvalidation = checkoutpageobj.CheckRequiredFieldValidationMessage();
		Assert.assertEquals(checkoutvalidation[0], "Enter an email");
		Assert.assertEquals(checkoutvalidation[1], "Enter a first name");
		Assert.assertEquals(checkoutvalidation[2], "Enter a last name");
		Assert.assertEquals(checkoutvalidation[3], "Enter an address");
		Assert.assertEquals(checkoutvalidation[4], "Enter a city");
		Assert.assertEquals(checkoutvalidation[5], "Enter a ZIP / postal code");
		Assert.assertEquals(checkoutvalidation[6], "Enter a phone number");
	}
	
	@DataProvider
	public Object[][] getCheckOutData(){
		Object data[][] = Testutil.AddCheckoutdata(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCheckOutData")
	public void VerifyCheckOutFunctionalitywithNagativeValueTest(String email, String firstname, String lastname, String address, String city, String pincode, String phonenumber) throws InterruptedException {
		String[] FieldValidation = 	checkoutpageobj.CheckFieldsValidationsMessagesWithNagativeValue(email, firstname, lastname, address, city, pincode, phonenumber);
		
		Assert.assertEquals(FieldValidation[0], "Enter a valid email");
		Assert.assertEquals(FieldValidation[1], "Enter a valid postal code for Gujarat");
		Assert.assertEquals(FieldValidation[2], "Enter a valid phone number");
		
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
