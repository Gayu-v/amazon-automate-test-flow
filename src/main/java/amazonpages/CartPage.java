package amazonpages;


	import java.text.DecimalFormat;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import java.time.Duration;

	public class CartPage {

		private WebDriver driver;
		private WebDriverWait wait;

		private By qtyDropdown = By.xpath("//button[@class='a-declarative']/span[@class='a-icon a-icon-small-add']");
		private By unitPriceWhole = By.xpath("//span[@class='a-price apex-price-to-pay-value']//span[@class='a-price-whole']");
		private By unitPriceFraction = By.xpath("//span[@class='a-price apex-price-to-pay-value']//span[@class='a-price-fraction']");
		public static By cartCount = By.id("nav-cart-count");
		private By total = By.xpath("//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");

		public CartPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		}

		public void updateQuantity() {

			System.out.println("Updating quantity in cart...");
			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(qtyDropdown));
			System.out.println("Quantity in Cart updated to value 2...");
			dropdown.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void assertPriceCalculation() {

			// Get unit price
			String unitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceWhole)).getText()
					.replace("₹", "").replace(",", "").trim();

			if (unitPrice.endsWith(".0")) {
				unitPrice = unitPrice.substring(0, unitPrice.length() - 2);
			}

			String unitFraction = wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceFraction)).getText();
			double finalValue = Double.parseDouble(unitPrice + "." + unitFraction);
			System.out.println("Unit price: " + finalValue);

			// Calculate expected total
			double multiplied = finalValue * 2;
			DecimalFormat df = new DecimalFormat("#.##");
			String expectedTotal = df.format(multiplied);
			System.out.println("Expected total price: " + expectedTotal);

			// Get actual total from cart
			String totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText()
					.replace("₹", "").replace(",", "").trim();

			if (totalPrice.endsWith(".00")) {
				totalPrice = totalPrice.substring(0, totalPrice.length() - 3);
			}

			System.out.println("Actual total price: " + totalPrice);

			// Assert
			Assert.assertEquals(totalPrice, expectedTotal, "Price calculation mismatch!");
		}
	}


