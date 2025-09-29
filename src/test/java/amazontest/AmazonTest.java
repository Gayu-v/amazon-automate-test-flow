package amazontest;


	import org.testng.annotations.Test;
	import amazonpages.CartPage;
	import amazonpages.LoginPage;
	import amazonbase.BaseTest;
	import amazonpages.ProductPage;
	import amazonpages.SearchResultsPage;
	
	import amazonpages.HomePage;

	public class AmazonTest extends BaseTest {

	    @Test(description="Verify the total price of the product")
	    public void amazonFlowTest() {
	        LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        SearchResultsPage searchPage = new SearchResultsPage(driver);
	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);

	        loginPage.login("9003248533", "VIgnesh_23");
	        
	        homePage.search("Watch");
	        try {
				searchPage.selectSecondWatchInThirdRow();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        productPage.addToCart();
	        cartPage.updateQuantity();
	        cartPage.assertPriceCalculation();
	        
	        
	       

	    }
	}


