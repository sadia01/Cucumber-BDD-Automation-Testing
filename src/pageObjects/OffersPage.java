package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By offerSearch = By.xpath("//input[@type='search']");
	private By offerProductName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchOfferItem(String name)
	{
		driver.findElement(offerSearch).sendKeys(name);
		
	}
	
	public String getSearchOfferProductName()
	{
		String Prod = driver.findElement(offerProductName).getText();
		return Prod;
	}

}
