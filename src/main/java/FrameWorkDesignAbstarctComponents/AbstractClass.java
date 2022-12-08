package FrameWorkDesignAbstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameWorkDesignPageObject.CartDisplayPage;
import FrameWorkDesignPageObject.YourOrdersPage;

public class AbstractClass {

	WebDriver driver;

	public AbstractClass(WebDriver driver)

	{
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement clickOnCartButton;

	@FindBy(css = "li [routerlink='/dashboard/myorders']")
	WebElement ordersbutton;

	public void waitUntillElementVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)); // By locator return type is By

	}

	public void waitUntillWebElementVisible(WebElement findBy2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(findBy2)); // By locator return type is By

	}

	public void waitUntillInVisibleElement(By findBy1) throws InterruptedException {

		Thread.sleep(2000);

//	WebDriverWait wait= new  WebDriverWait(driver,Duration.ofMillis(5000));
//	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy1));	
	}

	public CartDisplayPage goTocart() {

		clickOnCartButton.click();

		CartDisplayPage cartdisplaypage = new CartDisplayPage(driver);

		return cartdisplaypage;
	}

	public void scroll(WebElement Exactfield) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", Exactfield);
		Thread.sleep(2000);
	}

	public YourOrdersPage goToOrdersPage() {
		ordersbutton.click();

		YourOrdersPage yourorderspage = new YourOrdersPage(driver);
		return yourorderspage;
	}

}
