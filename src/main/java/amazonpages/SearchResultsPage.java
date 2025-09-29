package amazonpages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;
	import java.util.List;

	public class SearchResultsPage {

		private WebDriver driver;
		private WebDriverWait wait;

		private By productList = By.xpath("//div[@data-component-type='s-search-result']");

		public SearchResultsPage(WebDriver driver) {

			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // explicit wait

		}

		public void selectSecondWatchInThirdRow() throws InterruptedException {

			// Get all products
			List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

			int row = 3;
			int col = 2;
			int itemsPerRow = 5;

			int index = (row - 1) * itemsPerRow + (col - 1) + 1; // +1 because XPath is 1-based

			
			System.out.println("Identify the index of the product "+index);

			if (index < products.size()) {

				// Use String.format to parameterize
				WebElement element = driver.findElement(By.xpath(String.format("(//div[@data-component-type='s-search-result'])[%d]", index)));
				
				// scroll until this product is in view

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

				WebElement targetProduct = products.get(index);

				// Try to find "Add to Cart" for that product

				List<WebElement> addToCartBtns = targetProduct.findElements(By.xpath("//button[@name=\"submit.addToCart\" and @id=\"a-autoid-13-announce\"]"));

				if (!addToCartBtns.isEmpty()) {
					wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns.get(0))).click();
					System.out.println("Clicked Add to Cart successfully!");
				} else {
					System.out.println("No direct Add to Cart button for this product. Redirecting...");
				}
			}}}


