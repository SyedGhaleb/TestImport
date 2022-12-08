package FrameWorkDesign.Stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameWorkDesignPageObject.CartDisplayPage;
import FrameWorkDesignPageObject.LandingPage;
import FrameWorkDesignPageObject.OrderConformationPage;
import FrameWorkDesignPageObject.PaymentPage;
import FrameWorkDesignPageObject.ProductDisplayPage;
import FrameWorkDesignTestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefination extends BaseTest {
	public LandingPage login;
	public ProductDisplayPage productdisplaypage;
	public OrderConformationPage orderconformationpage;
	
	@Given ("I land on Ecommerce Page")
	public void I_land_on_Ecommerce_Page() throws IOException
	
	{
		login=LauchApplication();
		
	}

	@Given("^Logged in with username(.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password)
	{
		 productdisplaypage = login.LoginApplication(username,password);	
	}
	
	@When("^I add product(.+) to chart$")
	public void I_add_product_to_chart(String productName) throws InterruptedException
	{
		List<WebElement> prod = productdisplaypage.AllProductList();
		productdisplaypage.addproductTocart(productName);
	}
	@When ("^Checkout(.+) and Submit order$")
	public void Checkout_and_Submit_order(String productName) throws InterruptedException
	{
		CartDisplayPage cartdisplaypage = productdisplaypage.goTocart();
		Boolean match = cartdisplaypage.getCartList(productName);
		Assert.assertTrue(match);
		PaymentPage paymentpage = cartdisplaypage.checkout();
		paymentpage.SelectCountry("india");
		 orderconformationpage = paymentpage.placeorder();
	}
	
	@Then("{string} message is displayed on Confimation page")
	public void  message_is_displayed_on_Confimation_page(String string)
	{
		String msg = orderconformationpage.ordersuccessful();

		Assert.assertEquals(msg, string);
		driver.close();
			
}
	

	
	@Then("{string} message is displayed")
			public void Incorrect_email_or_password_message_is_displayed(String string)
			{
		

		Assert.assertEquals(string , login.LoginError());
		driver.close();
			}
}