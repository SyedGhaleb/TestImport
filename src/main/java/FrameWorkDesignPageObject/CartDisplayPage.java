package FrameWorkDesignPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class CartDisplayPage extends AbstractClass {

	WebDriver driver;

	public CartDisplayPage(WebDriver driver)

	{

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

//List<WebElement> finalproduct=driver.findElements(By.xpath("//div [@class='cartSection'] /h3"));
//	
//	Boolean product =finalproduct.stream().anyMatch(cartproduts->cartproduts.getText().equalsIgnoreCase("ZARA COAT 3"));
//	
//	Assert.assertTrue(product);
//	
//	driver.findElement(By.cssSelector(".totalRow button")).click();

	@FindBy(xpath = "//div [@class='cartSection'] /h3")
	List<WebElement> cartproducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	public Boolean getCartList(String Selectproduct) {
		Boolean product = cartproducts.stream()
				.anyMatch(cartproduts -> cartproduts.getText().equalsIgnoreCase(Selectproduct));

		return product;

	}

	public PaymentPage checkout() {
		checkout.click();

		PaymentPage paymentpage = new PaymentPage(driver);
		return paymentpage;
	}
}
