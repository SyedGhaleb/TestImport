package FrameWorkDesignPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class YourOrdersPage extends AbstractClass {

	WebDriver driver;

	public YourOrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-of-type(2)")
	List<WebElement> NameofOrder;

	public Boolean confirmOrder(String Selectproduct) {

		Boolean Orderedproduct = NameofOrder.stream()
				.anyMatch(ordername -> ordername.getText().equalsIgnoreCase(Selectproduct));

		return Orderedproduct;
	}

}
