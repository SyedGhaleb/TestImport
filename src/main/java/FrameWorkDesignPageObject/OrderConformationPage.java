package FrameWorkDesignPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesignAbstarctComponents.AbstractClass;

public class OrderConformationPage extends AbstractClass {

	WebDriver driver;

	public OrderConformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement orderconfirmation;

	public String ordersuccessful()

	{
		String successmsg = orderconfirmation.getText();

		System.out.println(successmsg);
		return successmsg;
	}

}
