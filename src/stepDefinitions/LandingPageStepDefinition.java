package stepDefinitions;


import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utilis.TestContextSetup;

public class LandingPageStepDefinition {

	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenKart Landing page")
	public void user_is_on_green_kart_landing_page() {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^User searched with Shortname (.+) and extract actual name of product$")
	public void user_searched_with_shortname_and_extract_actual_name_of_product(String Shortname) throws InterruptedException 
	{
	
		landingPage.searchItem(Shortname);
		Thread.sleep(2000);
		testContextSetup.landingPage_productName = landingPage.getSearchProductName();
		System.out.println(testContextSetup.landingPage_productName + " is extracted from Home Page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	

}
