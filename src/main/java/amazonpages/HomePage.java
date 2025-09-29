package amazonpages;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class HomePage {

		private WebDriver driver;
	    private WebDriverWait wait;

		private By searchBox = By.id("twotabsearchtextbox");
		private By searchBtn = By.id("nav-search-submit-button");

		public HomePage(WebDriver driver) {

			this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		}

		public void search(String query) {
			
			WebElement searchBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
			searchBoxElement.sendKeys(query);
			
			System.out.println("Search Term Entered Successfully");
			
			WebElement searchBtnElement = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
			searchBtnElement.click();
	       
			System.out.println("Search button Clicked Successfully");

		}
	}


