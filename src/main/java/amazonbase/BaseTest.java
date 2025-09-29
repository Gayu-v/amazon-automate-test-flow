package amazonbase;


	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	

	public class BaseTest {
		protected WebDriver driver;

		@BeforeMethod
		public void setUp() {
			
			  driver = new ChromeDriver();
			
			System.out.println("Browser Getting launched!");
			driver.manage().window().maximize();
			System.out.println("Browser Getting Maximized");
			driver.get("https://www.amazon.in/");
			System.out.println("URL Is Getting Inserted");
			
		}

		@AfterMethod
		public void tearDown() {
			if (driver != null) {
				driver.quit();
				System.out.println("Browser is getting Closed");

			}
		}
	}


