package FrameWorkDesignPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class ProductDisplayPage extends AbstractClass {

	WebDriver driver;

	public ProductDisplayPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> productname =driver.findElements(By.cssSelector(".mb-3"));

//	WebElement prod=	productname.stream().filter(product->
//	product.findElement(By.tagName("b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
//
//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

	// driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

	@FindBy(css = ".mb-3")
	List<WebElement> allproducts;

	By ListOFproducts = By.cssSelector(".mb-3");

	By toaster = By.id("toast-container");

	By animation = By.cssSelector(".ng-animating");

	By addtocart = By.cssSelector(".card-body button:last-of-type");

	public List<WebElement> AllProductList()

	{

		waitUntillElementVisible(ListOFproducts);
		return allproducts;

	}

	public WebElement selectproduct(String Selectproduct) {

		WebElement prod = allproducts.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(Selectproduct))
				.findFirst().orElse(null);

		return prod;
	}

	public void addproductTocart(String Selectproduct) throws InterruptedException

	{
		WebElement prod = selectproduct(Selectproduct);
		prod.findElement(addtocart).click();
		waitUntillElementVisible(toaster);
		waitUntillInVisibleElement(animation);

	}

}
