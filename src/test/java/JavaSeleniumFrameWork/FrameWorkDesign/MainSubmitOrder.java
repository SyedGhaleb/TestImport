package JavaSeleniumFrameWork.FrameWorkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainSubmitOrder {

	public static void main(String[] args) throws InterruptedException

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

		String Selectproduct = "ZARA COAT 3";

		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("Selenium123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> productname = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = productname.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(Selectproduct))
				.findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> finalproduct = driver.findElements(By.xpath("//div [@class='cartSection'] /h3"));

		Boolean product = finalproduct.stream()
				.anyMatch(cartproduts -> cartproduts.getText().equalsIgnoreCase(Selectproduct));

		Assert.assertTrue(product);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "ind").build().perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("[class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("(//button [contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement placeorder = driver.findElement(By.cssSelector("[class='btnn action__submit ng-star-inserted']"));

		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);

		Thread.sleep(2000);

		placeorder.click();

		String Confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertEquals(Confirmation, "THANKYOU FOR THE ORDER.");
		driver.close();

	}
}
