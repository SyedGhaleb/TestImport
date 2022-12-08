package JavaSeleniumFrameWork.FrameWorkDesign;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameWorkDesignPageObject.CartDisplayPage;
import FrameWorkDesignPageObject.OrderConformationPage;
import FrameWorkDesignPageObject.PaymentPage;
import FrameWorkDesignPageObject.ProductDisplayPage;
import FrameWorkDesignTestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	// String Selectproduct = "ZARA COAT 3";
	@Test(dataProvider = "testdata1", groups = "purchase")

	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException

	{

		// String Selectproduct = "ZARA COAT 3";
		String Countryname = "ind";
		ProductDisplayPage productdisplaypage = login.LoginApplication(input.get("email"), input.get("Password"));
		List<WebElement> prod = productdisplaypage.AllProductList();
		productdisplaypage.addproductTocart(input.get("Selectproduct"));
		CartDisplayPage cartdisplaypage = productdisplaypage.goTocart();
		Boolean match = cartdisplaypage.getCartList(input.get("Selectproduct"));
		Assert.assertTrue(match);
		PaymentPage paymentpage = cartdisplaypage.checkout();
		paymentpage.SelectCountry(Countryname);
		OrderConformationPage orderconformationpage = paymentpage.placeorder();
		String msg = orderconformationpage.ordersuccessful();

		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "submitOrder" }, groups = "purchase")

	public void orderconfirmation() {

		ProductDisplayPage productdisplaypage = login.LoginApplication("Selenium123@gmail.com", "Selenium@123");
		FrameWorkDesignPageObject.YourOrdersPage yourorderspage = productdisplaypage.goToOrdersPage();
		Assert.assertTrue(yourorderspage.confirmOrder("ZARA COAT 3"));

	}

//	@DataProvider

//	public Object[][] testdata()
//	{
//		
//	return	new Object[][] {{"Selenium123@gmail.com","Selenium@123","ZARA COAT 3"},
//		{"Selenium1234@gmail.com","Selenium@1234","adidas original"}};
//	}

//	@DataProvider
//	
//	public Object[][] testdata1()
//	{
//		HashMap<String,String> hs = new HashMap<String,String> ();
//		hs.put("email", "Selenium123@gmail.com");
//		hs.put("Password", "Selenium@123");
//		hs.put("Selectproduct","zara coat 3");
//		
//		HashMap<String,String> hs1 = new HashMap<String,String> ();
//		hs1.put("email", "Selenium1234@gmail.com");
//		hs1.put("Password", "Selenium@1234");
//		hs1.put("Selectproduct","adidas original");
//		
//		
//		
//		return new Object[][] {{hs},{hs1}};
//	}
//	

	@DataProvider
	public Object[][] testdata1() throws IOException {

		List<HashMap<String, String>> data1 = getJasonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\FrameWorkDesignData\\Testdata.json");

		return new Object[][] { { data1.get(0) }, { data1.get(1) } };
	}

	
}
