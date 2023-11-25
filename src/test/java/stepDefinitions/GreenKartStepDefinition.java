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


public class GreenKartStepDefinition {
	
	public WebDriver driver;
	String offerPageProductName;
	String landningPageProductName;
	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\iamco\\Udemy\\Cucumber\\CucmberFrameworkDesign\\src\\main\\resources\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		landningPageProductName=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landningPageProductName+" is extracted from home page");
	}
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		offerPageProductName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	@Then("Validate product name in offers page matches with Landing page")
	public void Validate_product_name_in_offers_page_matches_with_Landing_page() {
		Assert.assertEquals(offerPageProductName, landningPageProductName);
	}
}
