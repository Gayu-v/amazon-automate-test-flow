package amazonpages;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class ProductPage {

		private WebDriver driver;
	    private WebDriverWait wait;

		private By addToCartBtn = By.id("nav-cart-count-container");

		public ProductPage(WebDriver driver) {
			this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		}

		public void addToCart() {
			
			System.out.println("We are under Cart Page Now");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement addToCartBtnElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
			addToCartBtnElement.click();
			
			System.out.println("Add to Cart Icon was clicked successfully");

		}}
