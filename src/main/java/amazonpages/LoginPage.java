package amazonpages;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {

		private WebDriver driver;
		private WebDriverWait wait;


		private By signButton = By.id("nav-link-accountList");
		private By mobileNumberField = By.name("email");
		private By continueBtn = By.className("a-button-input");
		private By passwordField = By.id("ap_password");
		private By loginBtn = By.id("signInSubmit");

		public LoginPage(WebDriver driver) {

			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));


		}

		public void login(String email, String password) {

			WebElement signBtnElement = wait.until(ExpectedConditions.elementToBeClickable(signButton));
			signBtnElement.click();

			System.out.println("SignButton Clicked Successfully");

			WebElement emailOrPhoneNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField));
			emailOrPhoneNumberElement.sendKeys(email);

			System.out.println("MobileNumber Entered Successfully");

			WebElement continueBtnElement = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
			continueBtnElement.click();

			System.out.println("Continue Button Clicked Successfully");

			WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
			passwordFieldElement.sendKeys(password);

			System.out.println("Password Entered Successfully");

			WebElement loginBtnnElement = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
			loginBtnnElement.click();

			System.out.println("Login Button Clicked Successfully");


		}
	}


