package FrameWorkDesignPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class PaymentPage extends AbstractClass {

	WebDriver driver;

	public PaymentPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "ind").build().perform();
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = ("(//button [contains(@class,'ta-item')])[2]"))
	WebElement dropdownselect;

	@FindBy(css = ("[class='btnn action__submit ng-star-inserted']"))
	WebElement Submit;

	By dropdown = By.cssSelector("[class='ta-results list-group ng-star-inserted']");

	@FindBy(css = "[class='btnn action__submit ng-star-inserted']")
	WebElement ExactField;

	public void SelectCountry(String Countryname) throws InterruptedException {

		Actions a = new Actions(driver);
		a.sendKeys(country, Countryname).build().perform();
		waitUntillElementVisible(dropdown);
		dropdownselect.click();

	}

	public OrderConformationPage placeorder() throws InterruptedException {

		scroll(ExactField);
		Submit.click();
		OrderConformationPage orderconformationpage = new OrderConformationPage(driver);

		return orderconformationpage;
	}

}
