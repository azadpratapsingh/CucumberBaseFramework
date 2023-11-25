package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;


public class OfferPageStepDefinition {
	public WebDriver driver;
	String offerPageProductName;
	String landningPageProductName;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}

	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1= testContextSetup.driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		offerPageProductName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	@Then("Validate product name in offers page matches with Landing page")
	public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}
