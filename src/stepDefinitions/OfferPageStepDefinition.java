package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utilis.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPage_productName;
	public TestContextSetup testContextSetup; 
	public PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup; 
	}
	
	public void switchToOffersPage()
	{
		  //if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))

	      LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	      landingPage.getTopDealsPage();
	      testContextSetup.genericUtils.switchWindowToChild();
    
	}
	
	@Then("^User searched for (.+) Shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String Shortname) throws InterruptedException
	{
		
		  switchToOffersPage();
		  OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		  offersPage.searchOfferItem(Shortname);
		  Thread.sleep(2000);
		  offerPage_productName = offersPage.getSearchOfferProductName();
	}
	
	@Then("Validate ProductName in Offers Page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPage_productName, offerPage_productName);
	}

	
	

}
