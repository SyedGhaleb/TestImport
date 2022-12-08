package FrameWorkDesignPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class LandingPage extends AbstractClass {

	WebDriver driver;

	public LandingPage(WebDriver driver)

	{

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//	
//	driver.findElement(By.id("userEmail")).sendKeys();
//	driver.findElement(By.id("userPassword")).sendKeys("Selenium@123");
//	driver.findElement(By.cssSelector("input[type='submit']")).click();

	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement userpwd;

	@FindBy(css = "input[type='submit']")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut ']")
	WebElement errormessage;

	public ProductDisplayPage LoginApplication(String email, String pwd) {
		useremail.sendKeys(email);
		userpwd.sendKeys(pwd);
		submit.click();
		ProductDisplayPage productdisplaypage = new ProductDisplayPage(driver);
		return productdisplaypage;
	}

	public void gotoUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String LoginError() {

		waitUntillWebElementVisible(errormessage);
		return errormessage.getText();

	}
}
