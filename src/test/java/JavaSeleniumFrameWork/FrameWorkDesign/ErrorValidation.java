package JavaSeleniumFrameWork.FrameWorkDesign;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWorkDesignPageObject.CartDisplayPage;
import FrameWorkDesignPageObject.ProductDisplayPage;
import FrameWorkDesignTestComponents.BaseTest;
import FrameWorkDesignTestComponents.RetryTest;

public class ErrorValidation extends BaseTest {

	@Test(groups = { "ErrorHandling" },retryAnalyzer=RetryTest.class)
	public void validateErrorMsg() {
		login.LoginApplication("Selenium1234@gmail.com", "Selenium@1234g");

		Assert.assertEquals("Incorrect email or password.", login.LoginError());
	}
	
	@Test(groups = { "ErrorHandling" })

	public void ProductErrorValidation() throws InterruptedException {
		String Selectproduct = "ZARA COAT 3";
		String Countryname = "ind";
		ProductDisplayPage productdisplaypage = login.LoginApplication("Selenium1234@gmail.com", "Selenium@1234");
		List<WebElement> prod = productdisplaypage.AllProductList();
		productdisplaypage.addproductTocart(Selectproduct);
		CartDisplayPage cartdisplaypage = productdisplaypage.goTocart();
		Boolean match = cartdisplaypage.getCartList("ZARA COAT 3");
		Assert.assertTrue(match);
		Assert.assertTrue(match);
		Assert.assertTrue(match);
		Assert.assertTrue(match);
		Assert.assertTrue(match);
	}
}
