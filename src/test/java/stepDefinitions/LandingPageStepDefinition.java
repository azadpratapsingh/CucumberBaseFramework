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


public class LandingPageStepDefinition {
	public WebDriver driver;
	String offerPageProductName;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}

	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\iamco\\Udemy\\Cucumber\\CucmberFrameworkDesign\\src\\main\\resources\\msedgedriver.exe");
		testContextSetup.driver=new EdgeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		Thread.sleep(3000);
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName=testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName+" is extracted from home page");
	}
	

}